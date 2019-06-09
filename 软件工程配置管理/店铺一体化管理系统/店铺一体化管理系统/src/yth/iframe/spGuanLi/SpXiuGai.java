package yth.iframe.spGuanLi;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

import yth.dao.Dao;
import yth.dao.model.*;

import yth.Item;

public class SpXiuGai extends JPanel{
	private JComboBox sp;//“选择商品”下拉列表
	private JTextField mingCheng;//“商品名称”文本框
	private JTextField danJia;//“商品单价”文本框
	private JTextField shuLiang;//“商品数量”文本框
	private JTextField danWei;// “单位”文本框
	private JTextField chanDi;// “产地”文本框
	private JComboBox gysMingCheng;// “供应商名称”下拉列表
	private JButton modifyButton;//"修改"按钮

	public SpXiuGai(){
		setLayout(new GridBagLayout());// 设置商品修改内部窗体的布局为网格布局
		setBounds(10,10,550,400);//设置商品修改内部窗体的位置与宽高

		setupComponet(new JLabel("选择商品:"), 0, 0, 1, 0, false);// 设置“选择商品”标签的位置并添加到容器中
		sp = new JComboBox();// “选择商品”下拉列表
		sp.setPreferredSize(new Dimension(230, 21));// 设置“选择商品”下拉列表的宽高
		sp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doSpSelectAction();// “选择商品”下拉列表动作事件的监听
			}
		});
		setupComponet(sp, 1, 0, 2, 0, true);// 设置“选择商品”下拉列表的位置并添加到容器中

		setupComponet(new JLabel("商品名称："), 0, 1, 1, 1, false);// 设置“商品名称”标签的位置并添加到容器中
		mingCheng = new JTextField();// “商品名称”文本框
		mingCheng.setEditable(false);// 设置“商品名称”文本框不可编辑
		setupComponet(mingCheng, 1, 1, 3, 1, true);// 设置“商品名称”文本框的位置并添加到容器中

		setupComponet(new JLabel("产地："), 0, 2, 1, 1, false);// 设置“产地”标签的位置并添加到容器中
		chanDi = new JTextField();// “产地”文本框
		setupComponet(chanDi, 1, 2, 3, 10, true);// 设置“产地”文本框的位置并添加到容器中

		setupComponet(new JLabel("单位："), 0, 3, 1, 1, false);// 设置“单位”标签的位置并添加到容器中
		danWei = new JTextField();// “单位”文本框
		setupComponet(danWei, 1, 3, 1, 300, true);// 设置“单位”文本框的位置并添加到容器中

		setupComponet(new JLabel("单价："), 0, 4, 1, 1, false);// 设置“单价”标签的位置并添加到容器中
		danJia = new JTextField();// “单价”文本框
		setupComponet(danJia, 1, 4, 3, 130, true);// 设置“单价”文本框的位置并添加到容器中

		setupComponet(new JLabel("数量："), 0, 5, 1, 1, false);// 设置“单价”标签的位置并添加到容器中
		shuLiang = new JTextField();// “单价”文本框
		setupComponet(shuLiang, 1, 5, 3, 1, true);// 设置“单价”文本框的位置并添加到容器中
		
		setupComponet(new JLabel("供应商全称："), 0, 6, 1, 1, false);// 设置“供应商名称”标签的位置并添加到容器中
		gysMingCheng = new JComboBox();// “供应商名称”下拉列表
		gysMingCheng.setMaximumRowCount(5);// 设置“供应商名称”下拉列表显示的最大行数
		setupComponet(gysMingCheng, 1, 6, 3, 1, true);// 设置“供应商名称”下拉列表的位置并添加到容器中

		modifyButton = new JButton("修改");
		JPanel panel = new JPanel();
		panel.add(modifyButton);
		setupComponet(panel,1,7,1,0,false);

		modifyButton.addActionListener(new ActionListener() {// “修改”按钮动作事件的监听
			public void actionPerformed(ActionEvent e) {
				Item item = (Item) sp.getSelectedItem();// 获得数据表公共类对象
				TbSpinfo spInfo = new TbSpinfo();// 商品信息
				spInfo.setId(item.getId());// 设置商品编号
				//spInfo.setBz(baoZhuang.getText().trim());// 设置包装
				spInfo.setSpcd(chanDi.getText().trim());// 设置产地
				spInfo.setSpdw(danWei.getText().trim());// 设置商品计量单位
				spInfo.setSpdj(danJia.getText().trim());// 设置商品单价
				spInfo.setGysname(gysMingCheng.getSelectedItem().toString().trim());// 设置供应商全称
				spInfo.setSpsl(shuLiang.getText().trim());// 设置商品数量
				//spInfo.setMemo(beiZhu.getText().trim());// 设置备注
				//spInfo.setPh(piHao.getText().trim());// 设置批号
				//spInfo.setPzwh(wenHao.getText().trim());// 设置批准文号
				spInfo.setName(mingCheng.getText().trim());// 设置商品名称
				if (Dao.updateSp(spInfo) == 1)// 更改商品信息的数量等于1
					JOptionPane.showMessageDialog(SpXiuGai.this, "修改完成");// 弹出提示框
				else// 更改商品信息的数量不等于1
					JOptionPane.showMessageDialog(SpXiuGai.this, "修改失败");// 弹出提示框
			}
		});

	}

	public void initComboBox() {// 初始化商品下拉选择框
		List khInfo = Dao.getSpInfos();// 获取商品信息
		List<Item> items = new ArrayList<Item>();// 创建数据公共表的集合
		sp.removeAllItems();// 移除下拉列表中现有的商品名称
		for (Iterator iter = khInfo.iterator(); iter.hasNext();) {// 遍历list集合
			List element = (List) iter.next();// 获得集合中下一个元素
			Item item = new Item();// 创建数据表公共类对象
			item.setId(element.get(0).toString().trim());// 设置编号属性
			item.setName(element.get(1).toString().trim());// 设置名称信息
			if (items.contains(item))// 集合中包含数据表公共类对象
				continue;// 跳过本次循环
			items.add(item);// 集合中不包含数据表公共类对象，向集合中添加数据表公共类对象
			sp.addItem(item);// 向下拉列表中添加数据表公共类对象
		}
		doSpSelectAction();// “选择商品”下拉列表动作事件的监听
	}

	public void initGysBox() {// 初始化供应商下拉列表
		List gysInfo = Dao.getGysInfos();// 获取供应商信息
		List<Item> items = new ArrayList<Item>();// 创建数据公共表的集合
		gysMingCheng.removeAllItems();// 移除下拉列表中现有的供应商全称
		for (Iterator iter = gysInfo.iterator(); iter.hasNext();) {// 遍历list集合
			List element = (List) iter.next();// 获得集合中下一个元素
			Item item = new Item();// 创建数据表公共类对象
			item.setId(element.get(0).toString().trim());// 设置编号属性
			item.setName(element.get(1).toString().trim());// 设置名称信息
			if (items.contains(item))// 集合中包含数据表公共类对象
				continue;// 跳过本次循环
			items.add(item);// 集合中不包含数据表公共类对象，项集合中添加数据表公共类对象
			gysMingCheng.addItem(item);// 项下拉列表中添加数据表公共类对象
		}
		doSpSelectAction();// “选择商品”下拉列表动作事件的监听
	}

	private void setupComponet(JComponent component, int gridx, int gridy, int gridwidth, int ipadx, boolean fill) {// 设置组件位置并添加到容器中
		final GridBagConstraints gridBagConstrains = new GridBagConstraints();// 创建网格限制对象
		gridBagConstrains.gridx = gridx;// 设置组件位于网格的横向索引为gridx
		gridBagConstrains.gridy = gridy;// 设置组件位于网格的纵向索引为gridy
		gridBagConstrains.insets = new Insets(5, 1, 3, 1);// 组件彼此的间距
		if (gridwidth > 1)// 组件横跨网格数大于1
			gridBagConstrains.gridwidth = gridwidth;// 设置组件横跨网格数为gridwidth
		if (ipadx > 0)// 组件横向填充的大小大于0
			gridBagConstrains.ipadx = ipadx;// 设置组件横向填充的大小
		if (fill)// 组件占据空白区域
			gridBagConstrains.fill = GridBagConstraints.HORIZONTAL;// 组件水平扩大以占据空白区域
		add(component, gridBagConstrains);// 添加组件
	}

	private void doSpSelectAction() {// “选择商品”下拉列表动作事件的监听
		Item selectedItem;// “选择商品”下拉列表中的选项
		if (!(sp.getSelectedItem() instanceof Item)) {// “选择商品”下拉列表中的选项不是数据公共类的一个实例
			return;// 退出应用程序
		}
		selectedItem = (Item) sp.getSelectedItem();// 获得“选择商品”下拉列表中的选项
		TbSpinfo spInfo = Dao.getSpInfo(selectedItem);// 商品信息
		if (!spInfo.getId().isEmpty()) {// 商品编号不为空
			mingCheng.setText(spInfo.getName());// 设置“商品名称”文本框中的文本内容
			//spid.setText(spInfo.getId());// 设置“包装”文本框中的文本内容
			chanDi.setText(spInfo.getSpcd());// 设置“产地”文本框中的文本内容
			danWei.setText(spInfo.getSpdw());// 设置“单位”文本框中的文本内容
			danJia.setText(spInfo.getSpdj());// 设置“单价”文本框中的文本内容
			shuLiang.setText(spInfo.getSpsl());// 设置“数量”文本框中的文本内容
			//beiZhu.setText(spInfo.getMemo());// 设置“备注”文本框中的文本内容
			//piHao.setText(spInfo.getPh());// 设置“批号”文本框中的文本内容
			//wenHao.setText(spInfo.getPzwh());// 设置“批准文号”文本框中的文本内容
			
			Item item = new Item();// 数据表公共类
			item.setId(null);// 设置编号属性为空
			item.setName(spInfo.getGysname());// 设置名称信息为“供应商名称”
			TbGysinfo gysInfo = Dao.getGysInfo(item);// 获得供应商信息
			item.setId(gysInfo.getId());// 设置编号属性为供应商编号
			item.setName(gysInfo.getName());// 设置名称信息为“供应商名称”
			for (int i = 0; i < gysMingCheng.getItemCount(); i++) {// 遍历“供应商全称”下拉列表中的选项
				Item gys = (Item) gysMingCheng.getItemAt(i);// 获得“供应商全称”下拉列表的当前选择项
				if (gys.getName().equals(item.getName())) {// 供应商名称相同
					item = gys;// 为数据表公共类中的实例赋值
				}
			}
			gysMingCheng.setSelectedItem(item);// 设置“供应商全称”下拉列表的当前选择项
		}
	}

}