import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import xgboost as xgb
#import lightgbm as lgb
import seaborn as sns
import math
from sklearn.model_selection import KFold, cross_val_score, train_test_split
from sklearn.model_selection import GridSearchCV

#读取文件
train_data = pd.read_csv('train.csv')
test_data = pd.read_csv('test.csv')

train_data['total'] = train_data['卧室数量'] + train_data['厅的数量'] + train_data['卫的数量']
train_data['sleep_area'] = train_data['房屋面积'] * train_data['卧室数量'] / train_data['total']
train_data['hall_area'] = train_data['房屋面积'] * train_data['厅的数量'] / train_data['total']
train_data['wash_area'] = train_data['房屋面积'] * train_data['卫的数量'] / train_data['total']
train_data['house_area'] = train_data['房屋面积'] / train_data['total']
train_data['avg_area'] = train_data['小区房屋出租数量']*train_data['房屋面积']

test_data['total'] = test_data['卧室数量'] + test_data['厅的数量'] + test_data['卫的数量']
test_data['sleep_area'] = test_data['房屋面积'] * test_data['卧室数量'] / test_data['total']
test_data['hall_area'] = test_data['房屋面积'] * test_data['厅的数量'] / test_data['total']
test_data['wash_area'] = test_data['房屋面积'] * test_data['卫的数量'] / test_data['total']
test_data['house_area'] = test_data['房屋面积'] / test_data['total']
test_data['avg_area'] = test_data['小区房屋出租数量']*test_data['房屋面积']

ntrain = train_data.shape[0]
ntest = test_data.shape[0]
y_train = train_data.月租金.values
id = test_data[['id']]

#合并后特征填充
'''首先id是一个数据索引，没作用，剔除；
   然后查看数据文件得知，时间列只有1,2,3三个属性
   可以推断是三个月份的，其意义不大，不存在新老房之分
   然后通过corr分析相关性可知居住状态呈负相关，剔除'''
all_data.drop(['月租金'], axis=1, inplace=True)
all_data.drop(['id','时间','居住状态'], axis=1, inplace=True)
#房屋朝向用朝向出现的频率代替
tf = all_data[['房屋朝向','房屋面积']]
tf['count'] = 1
tf = tf.groupby('房屋朝向').agg('sum').reset_index()
tf.drop('房屋面积',axis =1,inplace=True)
tf['count'] = tf['count']/len(all_data)
all_data = pd.merge(all_data,tf,on='房屋朝向',how='left')
all_data.drop('房屋朝向',axis=1,inplace=True)
all_data.rename(columns={'count':'oriented'},inplace=True)

#all_data['装修情况'] = all_data['装修情况'].fillna(all_data['装修情况'].mode()[0])
#all_data['出租方式'] = all_data['出租方式'].fillna(0)
all_data['地铁线路'] = all_data['地铁线路'].fillna(0)
all_data['地铁站点'] = all_data['地铁站点'].fillna(0)
all_data['距离'] = all_data['距离'].fillna(0)
all_data['区'] = all_data['区'].fillna(all_data['区'].mode()[0])
all_data['位置'] = all_data['位置'].fillna(all_data['位置'].mode()[0])
all_data['小区房屋出租数量'] = all_data['小区房屋出租数量'].fillna(all_data['小区房屋出租数量'].mean())

for f in all_data.columns:
        if all_data[f].dtype != 'float64':
            all_data[f] = all_data[f].astype('float64')

train = all_data[:ntrain]
test = all_data[ntrain:]


model_xgb = xgb.XGBRegressor(colsample_bytree=0.8, gamma=0.2,
                             learning_rate=0.05, max_depth=10,
                             min_child_weight=1, n_estimators=2226,
                             reg_alpha=0.5, reg_lambda=0.01,
                             subsample=0.8, silent=False,
                             random_state=7)
def rmsle(y, y_pred):
    return np.sqrt(mean_squared_error(y, y_pred))

model_xgb.fit(train, y_train)
xgb_train_pred = model_xgb.predict(train)
xgb_pred = model_xgb.predict(test)
print(rmsle(y_train, xgb_train_pred))

sub = pd.DataFrame()
sub['id'] = id
sub['price'] = xgb_pred
sub.to_csv('sample.csv', index=False)
