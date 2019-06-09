package yth.iframe.gysGuanLi;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import keyListener.InputKeyListener;

import yth.dao.Dao;
import yth.dao.model.TbGysinfo;

public class GysTianJiaPanel extends JInternalFrame {// 供应商添加面板

	private JTextField GysNameF;// “供应商名称”文本框
	private JTextField GysAddressF;// “地址”文本框
	private JTextField GysMailF;// “邮箱”文本框
	private JTextField GysTelF;// “电话”文本框
	private JTextField GysBatF;// “银行账户”文本框
	private JTextField GysTaxF;// “纳税号”文本框
	private JButton resetButton;// “重置”文本框

	public GysTianJiaPanel() {// 供应商添加面板
		setTitle("供应商添加"); //设置窗口标题
		setIconifiable(true);// 设置供应商管理窗体可以图标化
		setClosable(true);// 设置可以关闭供应商管理窗体
		setLayout(new GridBagLayout());// 设置供应商添加面板的布局为网格布局
		setBounds(10, 10, 510, 302);// 设置供应商添加面板的位置与宽高

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

		final JButton tjButton = new JButton();// “添加”按钮
		tjButton.addActionListener(new ActionListener() {// “添加”按钮动作事件的监听
			public void actionPerformed(final ActionEvent e) {
				// 文本框为空时，弹出提示框
				if(GysNameF.getText().equals("")) {
					JOptionPane.showMessageDialog(GysTianJiaPanel.this, "供应商名称为空");
					return ;
				}
				if(GysAddressF.getText().equals("")) {
					JOptionPane.showMessageDialog(GysTianJiaPanel.this, "供应商地址为空");
					return ;
				}
				if(GysMailF.getText().equals("")) {
					JOptionPane.showMessageDialog(GysTianJiaPanel.this, "供应商邮箱为空");
					return ;
				}
				if(GysTelF.getText().equals("")) {
					JOptionPane.showMessageDialog(GysTianJiaPanel.this, "供应商电话为空");
					return ;
				}
				if(GysBatF.getText().equals("")) {
					JOptionPane.showMessageDialog(GysTianJiaPanel.this, "供应商银行账户为空");
					return ;
				}
				if ( GysTaxF.getText().equals("")) {
					JOptionPane.showMessageDialog(GysTianJiaPanel.this, "供应商纳税号为空");
					return;
				}

				// 执行SQL查询语句获得的结果集
				ResultSet haveUser = Dao.query("select * from tb_gysinfo where name='" + GysNameF.getText().trim() + "'");
				try {
					if (haveUser.next()) {// 结果集haveUser中有超过一条的记录
						System.out.println("error");// 控制台输出error
						JOptionPane.showMessageDialog(GysTianJiaPanel.this, "供应商信息添加失败，存在同名供应商", "供应商添加信息",
								JOptionPane.INFORMATION_MESSAGE);// 弹出提示框
						return;
					}
				} catch (Exception er) {
					er.printStackTrace();
				}
				ResultSet set = Dao.query("select max(id) from tb_gysinfo");// 执行SQL查询语句获得的结果集
				String id = null;// 声明供应商编号
				try {
					if (set != null && set.next()) {// 结果集set不为空且结果集set中有超过一条的记录
						String sid = set.getString(1).trim();// 获得结果集set中的第一列数据值
						if (sid == null)// 第一列数据值为空
							id = "gys1001";// 为产品编号赋值
						else {
							String str = sid.substring(3);// 从索引为3处开始截取字符串
							id = "gys" + (Integer.parseInt(str) + 1);// 重新拼接字符串获得产品编号
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				TbGysinfo gysInfo = new TbGysinfo();// 供应商信息
				gysInfo.setId(id);// 设置供应商编号
				gysInfo.setName(GysNameF.getText().trim());// 设置供应商名称
				gysInfo.setGysaddress(GysAddressF.getText().trim());// 设置地址
				gysInfo.setGysmail(GysMailF.getText().trim());// 设置邮箱
				gysInfo.setGystel(GysTelF.getText().trim());// 设置电话
				gysInfo.setGysbat(GysBatF.getText().trim());// 设置供应商银行账户
				gysInfo.setGystax(GysTaxF.getText().trim());// 设置纳税号
				Dao.addGys(gysInfo);// 添加供应商信息
				JOptionPane.showMessageDialog(GysTianJiaPanel.this, "已成功添加客户", "客户添加信息",
						JOptionPane.INFORMATION_MESSAGE);// 弹出提示框
				resetButton.doClick();// “重置”按钮执行点击事件
			}
		});
		tjButton.setText("添加");// “添加”按钮
		setupComponet(tjButton, 1, 6, 1, 0, false);// 设置“添加”按钮的位置并添加到容器中

		resetButton = new JButton();// “重置”按钮
		setupComponet(resetButton, 3, 6, 1, 0, false);// 设置“重置”按钮的位置并添加到容器中
		resetButton.addActionListener(new ActionListener() {// “重置”按钮动作事件的监听
			public void actionPerformed(final ActionEvent e) {
				// 设置文本框的内容为空
				GysNameF.setText("");
				GysAddressF.setText("");
				GysMailF.setText("");
				GysTelF.setText("");
				GysBatF.setText("");
				GysTaxF.setText("");
			}
		});
		resetButton.setText("重置");// 设置“重置”按钮中的文本内容
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
}