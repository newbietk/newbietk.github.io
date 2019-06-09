package yth.iframe.gysGuanLi;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

import keyListener.InputKeyListener;

import yth.Item;
import yth.dao.Dao;
import yth.dao.model.TbGysinfo;

public class GysXiuGaiPanel extends JInternalFrame {// 供应商修改面板
	
	private JTextField GysNameF;// “供应商名称”文本框
	private JTextField GysAddressF;// “地址”文本框
	private JTextField GysMailF;// “邮箱”文本框
	private JTextField GysTelF;// “电话”文本框
	private JTextField GysBatF;// “银行账户”文本框
	private JTextField GysTaxF;// “纳税号”文本框
	private JComboBox gys;// “选择供应商”下拉列表

	public GysXiuGaiPanel() {// 供应商修改面板
		setTitle("供应商修改"); //设置窗口标题
		setIconifiable(true);// 设置供应商管理窗体可以图标化
		setClosable(true);// 设置可以关闭供应商管理窗体
		setLayout(new GridBagLayout());// 设置供应商修改面板的布局为网格布局
		setBounds(10, 10, 510, 302);// 设置供应商修改面板的位置和宽高

		setupComponet(new JLabel("供应商名称："), 0, 0, 1, 1, false);// 设置“供应商名称”标签的位置并添加到容器中
		GysNameF = new JTextField();// “供应商名称”文本框
		setupComponet(GysNameF, 1, 0, 3, 200, true);// 设置“供应商名称”文本框的位置并添加到容器中

		setupComponet(new JLabel("地址："), 0, 1, 1, 1, false);// 设置“地址”标签的位置并添加到容器中
		GysAddressF = new JTextField();// “地址”文本框
		setupComponet(GysAddressF, 1, 1, 1, 100, true);// 设置“地址”文本框的位置并添加到容器中

		setupComponet(new JLabel("邮箱："), 2, 1, 1, 1, false);// 设置“邮箱”标签的位置并添加到容器中
		GysMailF = new JTextField();// “邮箱”文本框
		GysMailF.addKeyListener(new InputKeyListener());// 为“邮箱”文本框添加键盘输入事件的监听
		setupComponet(GysMailF, 3, 1, 1, 100, true);// 设置“邮箱”文本框的位置并添加到容器中

		setupComponet(new JLabel("电话："), 0, 2, 1, 1, false);// 设置“电话”标签的位置并添加到容器中
		GysTelF = new JTextField();// “电话”文本框
		setupComponet(GysTelF, 1, 2, 1, 0, true);// 设置“电话”文本框的位置并添加到容器中

		setupComponet(new JLabel("银行账户："), 2, 2, 1, 1, false);// 设置“银行账户”标签的位置并添加到容器中
		GysBatF = new JTextField();// “银行账户”文本框
		GysBatF.addKeyListener(new InputKeyListener());// 为“银行账户”文本框添加键盘输入事件的监听
		setupComponet(GysBatF, 3, 2, 1, 0, true);// 设置“银行账户”文本框的位置并添加到容器中

		setupComponet(new JLabel("纳税号："), 0, 3, 1, 1, false);// 设置“纳税号”标签的位置并添加到容器中
		GysTaxF = new JTextField();// “纳税号”文本框
		GysTaxF.addKeyListener(new InputKeyListener());// 为“纳税号”文本框添加键盘输入事件的监听
		setupComponet(GysTaxF, 1, 3, 3, 200, true);// 设置“纳税号”文本框的位置并添加到容器中

		setupComponet(new JLabel("选择供应商"), 0, 7, 1, 0, false);// 设置“选择供应商”标签的位置并添加到容器中
		gys = new JComboBox();// “选择供应商”下拉列表
		gys.setPreferredSize(new Dimension(230, 21));// 设置“选择供应商”下拉列表的宽高
		initComboBox();// 初始化“选择供应商”下拉列表
		gys.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doGysSelectAction();// “选择供应商”下拉列表的选项事件
			}
		});
		setupComponet(gys, 1, 7, 2, 0, true);// 设置“选U 择供应商”下拉列表的位置并添加到容器中
		JButton modifyButton = new JButton("修改");// “修改”按钮
		JPanel panel = new JPanel();// 按钮面板
		panel.add(modifyButton);// 把“修改”按钮放到按钮面板中
		setupComponet(panel, 3, 7, 1, 0, false);// 设置按钮面板的位置并添加到容器中
	
		modifyButton.addActionListener(new ActionListener() {// “修改”按钮动作事件的监听
			public void actionPerformed(ActionEvent e) {
				Item item = (Item) gys.getSelectedItem();// 获得数据表公共类对象
				TbGysinfo gysInfo = new TbGysinfo();// 供应商信息
				gysInfo.setId(item.getId());// 设置供应商编号
				gysInfo.setName(GysNameF.getText().trim());// 设置供应商名称
				gysInfo.setGysaddress(GysAddressF.getText().trim());// 设置地址
				gysInfo.setGysmail(GysMailF.getText().trim());// 设置邮箱
				gysInfo.setGystel(GysTelF.getText().trim());// 设置电话
				gysInfo.setGysbat(GysBatF.getText().trim());// 设置供应商银行账户
				gysInfo.setGystax(GysTaxF.getText().trim());// 设置纳税号
				if (Dao.updateGys(gysInfo) == 1)// 更改供应商信息的数量等于1
					JOptionPane.showMessageDialog(GysXiuGaiPanel.this, "修改完成");// 弹出提示框
				else// 更改供应商信息的数量不等于1
					JOptionPane.showMessageDialog(GysXiuGaiPanel.this, "修改失败");// 弹出提示框
			}
		});
	}
	
	public void initComboBox() {// 初始化“选择供应商”下拉列表
		List gysInfo = Dao.getGysInfos();// 获取供应商信息
		List<Item> items = new ArrayList<Item>();// 创建数据公共表的集合
		gys.removeAllItems();// 移除下拉列表中现有的供应商名称
		for (Iterator iter = gysInfo.iterator(); iter.hasNext();) {// 遍历list集合
			List element = (List) iter.next();// 获得集合中下一个元素
			Item item = new Item();// 创建数据表公共类对象
			item.setId(element.get(0).toString().trim());// 设置编号属性
			item.setName(element.get(1).toString().trim());// 设置名称信息
			if (items.contains(item))// 集合中包含数据表公共类对象
				continue;// 跳过本次循环
			items.add(item);// 集合中不包含数据表公共类对象，向集合中添加数据表公共类对象
			gys.addItem(item);// 向下拉列表中添加数据表公共类对象
		}
		doGysSelectAction();// “选择供应商”下拉列表的选项事件
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
	
	private void doGysSelectAction() {// “选择供应商”下拉列表的选项事件
		Item selectedItem;// “选择供应商”下拉列表中的选项
		if (!(gys.getSelectedItem() instanceof Item)) {// “选择供应商”下拉列表中的选项不是数据公共类的一个实例
			return;// 退出应用程序
		}
		selectedItem = (Item) gys.getSelectedItem();// 获得“选择供应商”下拉列表中的选项
		TbGysinfo gysInfo = Dao.getGysInfo(selectedItem);// 供应商信息
		GysNameF.setText(gysInfo.getName());// 设置“供应商名称称”文本框中的文本内容
		GysAddressF.setText(gysInfo.getGysaddress());// 设置“地址”文本框中的文本内容
		GysMailF.setText(gysInfo.getGysmail());// 设置“邮箱”文本框中的文本内容
		GysTelF.setText(gysInfo.getGystel());// 设置“电话”文本框中的文本内容
		GysBatF.setText(gysInfo.getGysbat());// 设置“银行账户”文本框中的文本内容
		GysTaxF.setText(gysInfo.getGystax());// 设置“纳税号”文本框中的文本内容
	}
}
