import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import xgboost as xgb
#import lightgbm as lgb
import seaborn as sns
import math
from sklearn.model_selection import KFold, cross_val_score, train_test_split
from sklearn.model_selection import GridSearchCV

#��ȡ�ļ�
train_data = pd.read_csv('train.csv')
test_data = pd.read_csv('test.csv')

train_data['total'] = train_data['��������'] + train_data['��������'] + train_data['��������']
train_data['sleep_area'] = train_data['�������'] * train_data['��������'] / train_data['total']
train_data['hall_area'] = train_data['�������'] * train_data['��������'] / train_data['total']
train_data['wash_area'] = train_data['�������'] * train_data['��������'] / train_data['total']
train_data['house_area'] = train_data['�������'] / train_data['total']
train_data['avg_area'] = train_data['С�����ݳ�������']*train_data['�������']

test_data['total'] = test_data['��������'] + test_data['��������'] + test_data['��������']
test_data['sleep_area'] = test_data['�������'] * test_data['��������'] / test_data['total']
test_data['hall_area'] = test_data['�������'] * test_data['��������'] / test_data['total']
test_data['wash_area'] = test_data['�������'] * test_data['��������'] / test_data['total']
test_data['house_area'] = test_data['�������'] / test_data['total']
test_data['avg_area'] = test_data['С�����ݳ�������']*test_data['�������']

ntrain = train_data.shape[0]
ntest = test_data.shape[0]
y_train = train_data.�����.values
id = test_data[['id']]

#�ϲ����������
'''����id��һ������������û���ã��޳���
   Ȼ��鿴�����ļ���֪��ʱ����ֻ��1,2,3��������
   �����ƶ��������·ݵģ������岻�󣬲��������Ϸ�֮��
   Ȼ��ͨ��corr��������Կ�֪��ס״̬�ʸ���أ��޳�'''
all_data.drop(['�����'], axis=1, inplace=True)
all_data.drop(['id','ʱ��','��ס״̬'], axis=1, inplace=True)
#���ݳ����ó�����ֵ�Ƶ�ʴ���
tf = all_data[['���ݳ���','�������']]
tf['count'] = 1
tf = tf.groupby('���ݳ���').agg('sum').reset_index()
tf.drop('�������',axis =1,inplace=True)
tf['count'] = tf['count']/len(all_data)
all_data = pd.merge(all_data,tf,on='���ݳ���',how='left')
all_data.drop('���ݳ���',axis=1,inplace=True)
all_data.rename(columns={'count':'oriented'},inplace=True)

#all_data['װ�����'] = all_data['װ�����'].fillna(all_data['װ�����'].mode()[0])
#all_data['���ⷽʽ'] = all_data['���ⷽʽ'].fillna(0)
all_data['������·'] = all_data['������·'].fillna(0)
all_data['����վ��'] = all_data['����վ��'].fillna(0)
all_data['����'] = all_data['����'].fillna(0)
all_data['��'] = all_data['��'].fillna(all_data['��'].mode()[0])
all_data['λ��'] = all_data['λ��'].fillna(all_data['λ��'].mode()[0])
all_data['С�����ݳ�������'] = all_data['С�����ݳ�������'].fillna(all_data['С�����ݳ�������'].mean())

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
