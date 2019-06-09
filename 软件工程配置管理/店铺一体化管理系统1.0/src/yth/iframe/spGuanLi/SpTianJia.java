package yth.iframe.spGuanLi;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import yth.Item;
import yth.dao.Dao;
import yth.dao.model.TbSpinfo;

public class SpTianJia extends JPanel {// 商品添加面板
	
    
	private JComboBox gysQuanCheng;// “供应商全称”下拉列表
	private JTextField danJia;// “单价”文本框
	private JTextField shuLiang;// “数量”文本框
	private JTextField danWei;// “单位”文本框
	private JTextField chanDi;// “产地”文本框
	private JTextField quanCheng;// “商品名称”文本框
	private JButton resetButton;// “重置”按钮

	public SpTianJia() {// 商品添加面板
		//setTitle("商品添加"); //设置窗口标题
		//setIconifiable(true);// 设置供应商管理窗体可以图标化
		//setClosable(true);// 设置可以关闭供应商管理窗体
		setLayout(new GridBagLayout());// 设置商品添加面板的布局为网格布局
		setBounds(10, 10, 550, 400);// 设置商品添加面板的位置与宽高
		setupComponent(new JLabel("商品名称："), 0, 0, 1, 1, false);// 设置“商品名称”标签的位置并添加到容器中
		quanCheng = new JTextField();// “商品名称”文本框
		setupComponent(quanCheng, 1, 0, 3, 1, true);// 设置“商品名称”文本框的位置并添加到容器中
		
		setupComponent(new JLabel("产地："), 0, 2, 1, 1, false);// 设置“产地”标签的位置并添加到容器中
		chanDi = new JTextField();// “产地”文本框
		setupComponent(chanDi, 1, 2, 3, 300, true);// 设置“产地”文本框的位置并添加到容器中
		setupComponent(new JLabel("单位："), 0, 3, 1, 1, false);// 设置“单位”标签的位置并添加到容器中
		danWei = new JTextField();// “单位”文本框
		setupComponent(danWei, 1, 3, 1, 130, true);// 设置“单位”文本框的位置并添加到容器中
		
		setupComponent(new JLabel("单价："), 2, 3, 1, 1, false);// 设置“单价”标签的位置并添加到容器中
		danJia = new JTextField();// “单价”文本框
		setupComponent(danJia, 3, 3, 1, 1, true);// 设置“单价”文本框的位置并添加到容器中
		
		setupComponent(new JLabel("数量："), 0, 4, 1, 1, false);// 设置“数量”标签的位置并添加到容器中
		shuLiang = new JTextField();// “数量”文本框
		setupComponent(shuLiang, 1, 4, 1, 1, true);// 设置“数量”文本框的位置并添加到容器中
		
		setupComponent(new JLabel("供应商全称："), 0, 6, 1, 1, false);// 设置“供应商全称”标签的位置并添加到容器中
		gysQuanCheng = new JComboBox();// “供应商全称”下拉列表
		gysQuanCheng.setMaximumRowCount(5);// 设置“供应商全称”下拉列表显示的最大行数
		setupComponent(gysQuanCheng, 1, 6, 3, 1, true);// 设置“供应商全称”下拉列表的位置并添加到容器中
		
	
		final JButton tjButton = new JButton();// “添加”按钮
		tjButton.addActionListener(new ActionListener() {// 为“添加”按钮添加动作事件的监听
			public void actionPerformed(final ActionEvent e) {
				// 文本框为空时，弹出提示框
				if (chanDi.getText().equals("") || danWei.getText().equals("")
						|| danJia.getText().equals("") || shuLiang.getText().equals("") ||
						quanCheng.getText().equals("")) {
					JOptionPane.showMessageDialog(SpTianJia.this, "请完成未填写的信息。", "商品添加",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				// 执行SQL查询语句获得的结果集
				ResultSet haveUser = Dao.query("select * from tbspinfo where spname='" + quanCheng.getText().trim() + "'");
				try {
					if (haveUser.next()) {// 结果集haveUser中有超过一条的记录
						System.out.println("error");// 控制台输出error
						JOptionPane.showMessageDialog(SpTianJia.this, "商品信息添加失败，存在同名商品", "客户添加信息",
								JOptionPane.INFORMATION_MESSAGE);// 弹出提示框
						return;
					}
				} catch (Exception er) {
					er.printStackTrace();
				}
				ResultSet set = Dao.query("select max(spid) from tbspinfo");// 执行SQL查询语句获得的结果集
				String spid = null;// 声明产品编号
				try {
					if (set != null && set.next()) {// 结果集set不为空且结果集set中有超过一条的记录
						String sid = set.getString(1);// 获得结果集set中的第一列数据值
						if (sid == null)// 第一列数据值为空
							spid = "sp1001";// 为产品编号赋值
						else {
							String str = sid.substring(2);// 从索引为2处开始截取字符串
							spid = "sp" + (Integer.parseInt(str) + 1);// 重新拼接字符串获得产品编号
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				TbSpinfo spInfo = new TbSpinfo();// 商品信息
				spInfo.setId(spid);// 设置商品编号
				spInfo.setSpcd(chanDi.getText().trim());// 设置产地
				spInfo.setSpdw(danWei.getText().trim());// 设置商品计量单位
				spInfo.setSpdj(danJia.getText().trim());// 设置商品单价
				spInfo.setSpsl(shuLiang.getText().trim()); // 设置商品数量
				spInfo.setGysname(gysQuanCheng.getSelectedItem().toString().trim());// 设置供应商全称
				spInfo.setName(quanCheng.getText().trim());// 设置商品名称
				Dao.addSp(spInfo);// 添加商品信息
				JOptionPane.showMessageDialog(SpTianJia.this, "商品信息已经成功添加", "商品添加",
						JOptionPane.INFORMATION_MESSAGE);// 弹出提示框
				resetButton.doClick();// “重置”按钮执行点击事件
			}
		});
		tjButton.setText("添加");// “添加”按钮
		setupComponent(tjButton, 1, 8, 1, 1, false);// 设置“添加”按钮的位置并添加到容器中
		final GridBagConstraints gridBagConstraints_20 = new GridBagConstraints();// 创建网格限制对象
		gridBagConstraints_20.weighty = 1.0;// “添加”按钮纵向扩大的权重是1.0
		gridBagConstraints_20.insets = new Insets(0, 65, 0, 15);// “添加”按钮与其他组件彼此的间距
		gridBagConstraints_20.gridy = 8;// “添加”按钮位于网格的纵向索引为8
		gridBagConstraints_20.gridx = 1;// “添加”按钮位于网格的横向索引为1
		resetButton = new JButton();// “重置”按钮
		setupComponent(resetButton, 3, 8, 1, 1, false);// 设置“重置”按钮的位置并添加到容器中
		resetButton.addActionListener(new ActionListener() {// “重置”按钮动作事件的监听
			public void actionPerformed(final ActionEvent e) {
				// 设置文本框的内容为空
				chanDi.setText("");
				danWei.setText("");
				danJia.setText("");
				shuLiang.setText("");
				quanCheng.setText("");
			}
		});
		resetButton.setText("重置");// 设置“重置”按钮中的文本内容
	}
	

	private void setupComponent(JComponent component, int gridx, int gridy, int gridwidth, int ipadx, boolean fill) {// 设置组件的位置并添加到容器中
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

	public void initGysBox() {// 初始化供应商下拉选择框
		List gysInfo = Dao.getGysInfos();// 获取供应商信息
		List<Item> items = new ArrayList<Item>();// 创建数据公共表的集合
		gysQuanCheng.removeAllItems();// 移除下拉列表中现有的供应商全称
		for (Iterator iter = gysInfo.iterator(); iter.hasNext();) {// 遍历list集合
			List element = (List) iter.next();// 获得集合中下一个元素
			Item item = new Item();// 创建数据表公共类对象
			item.setId(element.get(0).toString().trim());// 设置编号属性
			item.setName(element.get(1).toString().trim());// 设置名称信息
			if (items.contains(item))// 集合中包含数据表公共类对象
				continue;// 跳过本次循环
			items.add(item);// 集合中不包含数据表公共类对象，项集合中添加数据表公共类对象
			gysQuanCheng.addItem(item);// 项下拉列表中添加数据表公共类对象
		}
	}
}