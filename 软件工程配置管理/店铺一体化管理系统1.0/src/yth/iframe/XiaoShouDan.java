package yth.iframe;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.List;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

import yth.*;
import yth.dao.Dao;
import yth.dao.model.*;

public class XiaoShouDan extends JInternalFrame {// 销售单内部窗体

	private final JTable table;// 表格模型
	private final JTextField sellDate = new JTextField();// “销售时间”文本框
	private JComboBox jsr = null;// “经手人”下拉列表
	private final JComboBox jsfs = new JComboBox();// “结算方式”下拉列表
	private final JComboBox khname = new JComboBox();// “客户名称”下拉列表
	private final JComboBox hydj = new JComboBox(); //“会员等级”下拉列表
	private final JTextField sellId = new JTextField();// “订单编号”文本框
	private final JTextField sl = new JTextField("0");// “品种数量”文本框
	private final JTextField dj = new JTextField("0");// “货品总数”文本框
	private final JTextField hjje = new JTextField("0");// “销售金额”文本框
	private final JTextField czy = new JTextField();// “操作员”文本框
	private Date xssjDate;// “销售日期”
	private JComboBox sp;// “商品”下拉列表

	public XiaoShouDan() {// 销售单内部窗体的构造方法
		super();// 调用父类JInternalFrame的构造器
		setMaximizable(true);// 可以最大化
		setIconifiable(true);// 可以图标化
		setClosable(true);// 可以关闭销售单内部窗体
		getContentPane().setLayout(new GridBagLayout());// 设置销售单内部窗体的布局为网格布局
		setTitle("销售记录");// 设置销售单内部窗体的标题
		setBounds(50, 50, 700, 400);// 设置销售单内部窗体的位置和宽高
		// “订单编号”标签和“订单编号”文本框
		setupComponet(new JLabel("订单编号："), 0, 0, 1, 0, false);
		sellId.setFocusable(false);
		setupComponet(sellId, 1, 0, 1, 140, true);
		// “客户名称”标签和“客户名称”下拉列表
		setupComponet(new JLabel("客户名称："), 2, 0, 1, 0, false);
		khname.setPreferredSize(new Dimension(160, 21));
		khname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doKhSelectAction();// “客户名称”下拉列表的选择事件
			}
		});
		setupComponet(khname, 3, 0, 1, 1, true);
	    // “会员等级”标签和“会员等级”下拉列表
		setupComponet(new JLabel("会员等级："), 4, 0, 1, 0, false);
		hydj.addItem("一级");
		hydj.addItem("二级");
		hydj.addItem("三级");
		hydj.setEditable(true);
		setupComponet(hydj, 5, 0, 1, 0, true);
		// “结算方式”标签和“结算方式”下拉列表
		setupComponet(new JLabel("结算方式："), 0, 1, 1, 0, false);
		jsfs.addItem("现金");
		jsfs.addItem("支票");
		jsfs.setEditable(true);
		setupComponet(jsfs, 1, 1, 1, 1, true);
		// “销售时间”标签和“销售时间”文本框
		setupComponet(new JLabel("销售时间："), 2, 1, 1, 0, false);
		sellDate.setFocusable(false);
		setupComponet(sellDate, 3, 1, 1, 1, true);
		// “经手人”标签和“经手人”下拉列表
		setupComponet(new JLabel("经手人："), 4, 1, 1, 0, false);
		setupComponet(getJsrComboBox(), 5, 1, 1, 1, true);
		// “商品”下拉列表
		sp = new JComboBox();
		sp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TbSpinfo info = (TbSpinfo) sp.getSelectedItem();
				if (info != null && info.getId() != null) {
					updateTable();// 如果选择有效就更新表格
				}
			}
		});
		// 表格模型
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 不自动调整列的宽度，使用滚动条
		initTable();
		// 添加事件完成品种数量、货品总数、合计金额的计算
		table.addContainerListener(new computeInfo());
		JScrollPane scrollPanel = new JScrollPane(table);
		scrollPanel.setPreferredSize(new Dimension(380, 200));
		setupComponet(scrollPanel, 0, 2, 6, 1, true);
		// “商品数量”标签和“商品数量”文本框
		setupComponet(new JLabel("商品数量："), 0, 3, 1, 0, false);
		sl.setFocusable(false);
		setupComponet(sl, 1, 3, 1, 1, true);
		// “商品单价”标签和“商品单价”文本框
		setupComponet(new JLabel("商品单价："), 2, 3, 1, 0, false);
		dj.setFocusable(false);
		setupComponet(dj, 3, 3, 1, 1, true);
		// “销售金额”标签和“销售金额”文本框
		setupComponet(new JLabel("销售金额："), 4, 3, 1, 0, false);
		hjje.setFocusable(false);
		setupComponet(hjje, 5, 3, 1, 1, true);

		// “添加”按钮
		JButton tjButton = new JButton("添加");
		tjButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 初始化票号
				initPiaoHao();
				// 结束表格中没有编写的单元
				stopTableCellEditing();
				// 如果表格中还包含空行，就再添加新行
				for (int i = 0; i < table.getRowCount(); i++) {
					TbSpinfo info = (TbSpinfo) table.getValueAt(i, 0);
					if (table.getValueAt(i, 0) == null)
						return;
				}
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Vector());
			}
		});
		setupComponet(tjButton, 1, 4, 1, 1, false);
		
		// “销售”按钮
		JButton sellButton = new JButton("销售");
		sellButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopTableCellEditing();// 结束表格中没有编写的单元
				clearEmptyRow();// 清除空行
				String slStr = sl.getText();// 货品总数
				String djStr = dj.getText();// 品种数
				String jeStr = hjje.getText();// 合计金额
				String jsfsStr = jsfs.getSelectedItem().toString();// 结算方式
				String jsrStr = jsr.getSelectedItem() + "";// 经手人
				String czyStr = czy.getText();// 操作员
				String rkDate = xssjDate.toLocaleString();// 销售时间
				String id = sellId.getText();// 订单编号
				String kehuName = khname.getSelectedItem().toString();// 供应商名字
				if (jsrStr == null || jsrStr.isEmpty()) {
					JOptionPane.showMessageDialog(XiaoShouDan.this, "请填写经手人");
					return;
				}
			
				if (table.getRowCount() <= 0) {
					JOptionPane.showMessageDialog(XiaoShouDan.this, "填加销售商品");
					return;
				}
				TbSellMain sellMain = new TbSellMain(id, slStr, jeStr,djStr, kehuName, rkDate, czyStr, jsrStr);// 销售主表
				Set<TbSellDetail> set = sellMain.getTbSellDetails();// 获得销售明细的集合
				int rows = table.getRowCount();
				for (int i = 0; i < rows; i++) {
					TbSpinfo spinfo = (TbSpinfo) table.getValueAt(i, 0);
					String djStr1 = (String) table.getValueAt(i, 6);
					String slStr1 = (String) table.getValueAt(i, 7);
					Double dj = Double.valueOf(djStr1);
					Integer sl = Integer.valueOf(slStr);
					TbSellDetail detail = new TbSellDetail();// 销售明细
					detail.setSpid(spinfo.getId());// 流水号
					detail.setTbSellMain(sellMain.getSellId());// 销售主表
					detail.setDj(dj);// 销售单价
					detail.setSl(sl);// 销售数量
					set.add(detail);// 把销售明细添加到销售明细的集合中
				}
				boolean rs = Dao.insertSellInfo(sellMain);// 添加销售信息
				if (rs) {
					JOptionPane.showMessageDialog(XiaoShouDan.this, "销售完成");
					DefaultTableModel dftm = new DefaultTableModel();
					table.setModel(dftm);
					initTable();
					sl.setText("0");
					dj.setText("0");
					hjje.setText("0");
				}
			}
		});
		setupComponet(sellButton, 3, 4, 1, 1, false);
		// 添加窗体监听器，完成初始化
		addInternalFrameListener(new initTasks());
	}
	// “经手人”下拉列表
	private JComboBox getJsrComboBox() {
		if (jsr == null) {
			jsr = new JComboBox();
			List<List> czyList = Dao.getYgs();
			for (List<String> list : czyList) {
				String id = list.get(0);
				String name = list.get(1);
				Item item = new Item(id, name);
				item.setId(id + "");
				item.setName(name);
				jsr.addItem(item);
			}
		}
		return jsr;
	}

	// 初始化表格
	private void initTable() {
		String[] columnNames = { "商品名称", "商品编号", "供应商", "产地", "计量单位", "单价", "数量" };
		((DefaultTableModel) table.getModel()).setColumnIdentifiers(columnNames);
		TableColumn column = table.getColumnModel().getColumn(0);
		final DefaultCellEditor editor = new DefaultCellEditor(sp);
		editor.setClickCountToStart(2);
		column.setCellEditor(editor);
	}

	// 初始化商品下拉列表
	private void initSpBox() {
		List list = new ArrayList();
		ResultSet set = Dao.query(" select * from tbspinfo" + " where id in (select id from tbkucun where spsl>0)");
		sp.removeAllItems();
		sp.addItem(new TbSpinfo());
		for (int i = 0; table != null && i < table.getRowCount(); i++) {
			TbSpinfo tmpInfo = (TbSpinfo) table.getValueAt(i, 0);
			if (tmpInfo != null && tmpInfo.getId() != null)
				list.add(tmpInfo.getId());
		}
		try {
			while (set.next()) {
				TbSpinfo spinfo = new TbSpinfo();
				spinfo.setId(set.getString("id").trim());
				// 如果表格中以存在同样商品，商品下拉框中就不再包含该商品
				if (list.contains(spinfo.getId()))
					continue;
				spinfo.setName(set.getString("name").trim());
				spinfo.setSpcd(set.getString("spcd").trim());
				spinfo.setSpdw(set.getString("spdw").trim());
				spinfo.setSpdj(set.getString("spdj").trim());
				spinfo.setSpsl(set.getString("spsl").trim());
				spinfo.setGysname(set.getString("gysname").trim());
				sp.addItem(spinfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 设置组件位置并添加到容器中
	private void setupComponet(JComponent component, int gridx, int gridy, int gridwidth, int ipadx, boolean fill) {
		final GridBagConstraints gridBagConstrains = new GridBagConstraints();
		gridBagConstrains.gridx = gridx;
		gridBagConstrains.gridy = gridy;
		if (gridwidth > 1)
			gridBagConstrains.gridwidth = gridwidth;
		if (ipadx > 0)
			gridBagConstrains.ipadx = ipadx;
		gridBagConstrains.insets = new Insets(5, 1, 3, 1);
		if (fill)
			gridBagConstrains.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(component, gridBagConstrains);
	}

	// 供应商选择时更新联系人字段
	private void doKhSelectAction() {
		Item item = (Item) khname.getSelectedItem();
		TbKhinfo khInfo = Dao.getKhInfo(item);
		//khname.setText(khInfo.getKhname());
	}

	// 计算品种数量、货品总数、合计金额
	private final class computeInfo implements ContainerListener {
		public void componentRemoved(ContainerEvent e) {
			// 清除空行
			clearEmptyRow();
			// 计算代码
			int rows = table.getRowCount();
			int count = 0;
			double money = 0.0;
			// 计算品种数量
			TbSpinfo column = null;
			if (rows > 0)
				column = (TbSpinfo) table.getValueAt(rows - 1, 0);
			if (rows > 0 && (column == null || column.getId().isEmpty()))
				rows--;
			// 计算货品总数和金额
			for (int i = 0; i < rows; i++) {
				String column7 = (String) table.getValueAt(i, 7);
				String column6 = (String) table.getValueAt(i, 6);
				int c7 = (column7 == null || column7.isEmpty()) ? 0 : Integer.valueOf(column7);
				Double c6 = (column6 == null || column6.isEmpty()) ? 0 : Double.valueOf(column6);
				count += c7;
				money += c6 * c7;
			}
			sl.setText(rows + "");
			dj.setText(count + "");
			hjje.setText(money + "");
		}

		public void componentAdded(ContainerEvent e) {
		}
	}

	// 窗体的初始化任务
	private final class initTasks extends InternalFrameAdapter {
		public void internalFrameActivated(InternalFrameEvent e) {
			super.internalFrameActivated(e);
			initTimeField();
			initKehuField();
			initPiaoHao();
			initSpBox();
		}
		// 初始化客户字段
		private void initKehuField() {
			List gysInfos = Dao.getKhInfos();
			for (Iterator iter = gysInfos.iterator(); iter.hasNext();) {
				List list = (List) iter.next();
				Item item = new Item();
				item.setId(list.get(0).toString().trim());
				item.setName(list.get(1).toString().trim());
				khname.addItem(item);
			}
			doKhSelectAction();
		}
		// 启动销售时间线程
		private void initTimeField() {
			new Thread(new Runnable() {
				public void run() {
					try {
						while (true) {
							xssjDate = new Date();
							sellDate.setText(xssjDate.toLocaleString());
							Thread.sleep(100);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}
	// 初始化“销售票号”
	private void initPiaoHao() {
		java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
		String maxId = Dao.getSellMainMaxId(date);
		sellId.setText(maxId);
	}

	// 根据商品下拉列表，更新表格当前行的内容
	private synchronized void updateTable() {
		TbSpinfo spinfo = (TbSpinfo) sp.getSelectedItem();
		Item item = new Item();
		item.setId(spinfo.getId());
		TbKucun kucun = Dao.getKucun(item);
		int row = table.getSelectedRow();
		if (row >= 0 && spinfo != null) {
			table.setValueAt(spinfo.getId(), row, 1);
			table.setValueAt(spinfo.getGysname(), row, 2);
			table.setValueAt(spinfo.getSpcd(), row, 4);
			table.setValueAt(spinfo.getSpdw(), row, 5);
			table.setValueAt(spinfo.getSpdj(), row, 6);
			table.setValueAt(kucun.getSpsl() + "", row, 8);
			table.editCellAt(row, 7);
		}
	}
	
	// 清除空行
	private synchronized void clearEmptyRow() {
		DefaultTableModel dftm = (DefaultTableModel) table.getModel();
		for (int i = 0; i < table.getRowCount(); i++) {
			TbSpinfo info2 = (TbSpinfo) table.getValueAt(i, 0);
			if (info2 == null || info2.getId() == null || info2.getId().isEmpty()) {
				dftm.removeRow(i);
			}
		}
	}

	// 停止表格单元的编辑
	private void stopTableCellEditing() {
		TableCellEditor cellEditor = table.getCellEditor();
		if (cellEditor != null)
			cellEditor.stopCellEditing();
	}
}
