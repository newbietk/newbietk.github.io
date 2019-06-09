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

public class RuKuJiLu_IFrame extends JInternalFrame {// 入库记录内部窗体
	
	private final JTable table;// 表格模型
	private final JTextField rksj = new JTextField();// “入库时间”文本框
	private JComboBox jsr = null;// “经手人”下拉列表
	private final JComboBox gys = new JComboBox();// “供应商”下拉列表
	private final JTextField rkid = new JTextField();// “入库编号”文本框
	private final JTextField spdj = new JTextField("0");// “商品单价”文本框
	private final JTextField spname = new JTextField();//"商品名称"文本框
	private final JTextField spsl = new JTextField("0");// “商品数量”文本框
	private final JTextField hjje = new JTextField("0");// “合计金额”文本框
	private final JTextField ysjl = new JTextField();// “验收结论”文本框
	private final JTextField czy = new JTextField();// “操作员”文本框
	private Date sjDate;// “入库时间”
	private JComboBox sp;// “商品”下拉列表

	public RuKuJiLu_IFrame() {// 进货-退货内部窗体的构造方法
		super();// 调用父类JInternalFrame的构造器
		setMaximizable(true);// 可以最大化
		setIconifiable(true);// 可以图标化
		setClosable(true);// 入库记录内部窗体可以关闭
		getContentPane().setLayout(new GridBagLayout());// 设置入库记录内部窗体的布局为网格布局
		setTitle("入库记录");// 设置入库记录内部窗体的标题
		setBounds(50, 50, 700, 400);// 设置入库编号内部窗体的位置和宽高
		// “入库编号”标签与“入库编号”文本框
		setupComponet(new JLabel("入库编号："), 0, 0, 1, 0, false);
		rkid.setFocusable(false);
		setupComponet(rkid, 1, 0, 1, 100, true);
		// “退货时间”标签与“退货时间”文本框
		setupComponet(new JLabel("入库时间："), 2, 0, 1, 0, false);
	    rksj.setFocusable(false);
		setupComponet(rksj, 3, 0, 1, 120, true);
		// “供应商”标签与“供应商”下拉列表
		setupComponet(new JLabel("供应商："), 4, 0, 1, 0, false);
		gys.setPreferredSize(new Dimension(160, 21));
		gys.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//doGysSelectAction();// “供应商”下拉列表的选择事件
			}
		});
		setupComponet(gys, 5, 0, 1, 1, true);
		// “商品名称”标签与“商品名称”文本框
		setupComponet(new JLabel("商品名称："), 0, 1, 1, 0, false);
		spname.setFocusable(false);
		spname.setPreferredSize(new Dimension(80, 21));
		setupComponet(spname, 1, 1, 1, 120, true);
		// “商品单价”标签与“商品单价”下拉列表
		//setupComponet(new JLabel("单价："), 0, 1, 1, 0, false);
		//spdj.setFocusable(false);
		//setupComponet(spdj, 1, 1, 1, 1, true);
		// “商品数量”标签与“商品数量”文本框
		//setupComponet(new JLabel("数量："), 2, 1, 1, 0, false);
		//spsl.setFocusable(false);
		//setupComponet(spsl, 3, 1, 1, 1, true);
		// “经手人”标签与“经手人”下拉列表
		setupComponet(new JLabel("经手人："), 4, 1, 1, 0, false);
		setupComponet(getJsrComboBox(), 5, 1, 1, 1, true);
		// “商品”下拉列表
		sp = new JComboBox();
		sp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TbKucun info = (TbKucun) sp.getSelectedItem();
				if (info != null && info.getId() != null) {// 如果选择有效就更新表格
					updateTable();
				}
			}
		});
		// 表格模型
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		initTable();
		table.addContainerListener(new computeInfo());// 添加事件完成品种数量、货品总数、合计金额的计算
		JScrollPane scrollPanel = new JScrollPane(table);
		scrollPanel.setPreferredSize(new Dimension(380, 200));
		setupComponet(scrollPanel, 0, 2, 6, 1, true);
		// “商品单价”标签与“商品单价”文本框
		setupComponet(new JLabel("商品单价："), 0, 3, 1, 0, false);
		spdj.setFocusable(false);
		setupComponet(spdj, 1, 3, 1, 1, true);
		// “商品数量”标签与“商品数量”文本框
		setupComponet(new JLabel("商品数量："), 2, 3, 1, 0, false);
		spsl.setFocusable(false);
		setupComponet(spsl, 3, 3, 1, 1, true);
		// “合计金额”标签与“合计金额”文本框
		setupComponet(new JLabel("合计金额："), 4, 3, 1, 0, false);
		hjje.setFocusable(false);
		setupComponet(hjje, 5, 3, 1, 1, true);
		// “验收结论”标签与“验收结论”文本框
		setupComponet(new JLabel("验收结论："), 0, 4, 1, 0, false);
		setupComponet(ysjl, 1, 4, 1, 1, true);
		// “操作人员”标签与“操作人员”文本框
		setupComponet(new JLabel("操作人员："), 2, 4, 1, 0, false);
		czy.setFocusable(false);
		//czy.setText(MainFrame.getCzyStateLabel().getText());
		setupComponet(czy, 3, 4, 1, 1, true);

		JButton tjButton = new JButton("添加");// “添加”按钮
		tjButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 初始化入库编号
				initrkid();
				// 结束表格中没有编写的单元
				stopTableCellEditing();
				// 如果表格中还包含空行，就不再添加新行
				for (int i = 0; i < table.getRowCount(); i++) {
					TbKucun info = (TbKucun) table.getValueAt(i, 0);
					if (info == null || info.getId().isEmpty())
						return;
				}
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Vector());
				initSpBox();
			}
		});
		setupComponet(tjButton, 4, 4, 1, 1, false);
		
		JButton rkButton = new JButton("入库");// “入库”按钮
		rkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 结束表格中没有编写的单元
				stopTableCellEditing();
				// 清除空行
				clearEmptyRow();
				String djStr = spdj.getText();// 商品单价
				String slStr = spsl.getText();// 商品数量
				String jeStr = hjje.getText();// 合计金额
				String jsrStr = jsr.getSelectedItem() + "";// 经手人
				String czyStr = czy.getText();// 操作员
				String sDate = sjDate.toLocaleString();// 入库时间
				String ysjlStr = ysjl.getText().trim();// 验收结论
				String id = rkid.getText();// 票号
				String gysName = gys.getSelectedItem().toString();// 供应商名字
				if (jsrStr == null || jsrStr.isEmpty()) {
					JOptionPane.showMessageDialog(RuKuJiLu_IFrame.this, "请填写经手人");
					return;
				}
				if (ysjlStr == null || ysjlStr.isEmpty()) {
					JOptionPane.showMessageDialog(RuKuJiLu_IFrame.this, "填写验收结论");
					return;
				}
				if (table.getRowCount() <= 0) {
					JOptionPane.showMessageDialog(RuKuJiLu_IFrame.this, "添加入库商品");
					return;
				}
				TbShangjiaMain sjMain = new TbShangjiaMain(id, slStr, jeStr, ysjlStr, gysName, sDate);
				Set<TbShangjiaDetail> set = sjMain.getTabShangjiaDetails();
				int rows = table.getRowCount();
				for (int i = 0; i < rows; i++) {
					TbKucun kucun = (TbKucun) table.getValueAt(i, 0);
					String djStr1 = (String) table.getValueAt(i, 6);
					String slStr1 = (String) table.getValueAt(i, 7);
					Double dj = Double.valueOf(djStr1);
					Integer sl = Integer.valueOf(slStr1);
					TbShangjiaDetail detail = new TbShangjiaDetail();
					detail.setId(kucun.getId());
					detail.setTbsjMain(ChuKuJiLu.getShangjiaId());
					detail.setDj(dj);
					detail.setSl(sl);
					set.add(detail);
				}
				boolean rs = Dao.insersjInfo(sjMain);
				if (rs) {
					JOptionPane.showMessageDialog(RuKuJiLu_IFrame.this, "入库完成");
					DefaultTableModel dftm = new DefaultTableModel();
					table.setModel(dftm);
					initTable();
					spdj.setText("0");
					spsl.setText("0");
					hjje.setText("0");
				}
			}
		});
		setupComponet(rkButton, 5, 4, 1, 1, false);
		addInternalFrameListener(new initTasks());// 添加窗体监听器，完成初始化
	}

	protected static Object getShangjiaId() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 获得“经手人”下拉列表的方法
	 * 
	 * @return “经手人”下拉列表
	 */
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

	private void initTable() {// 初始化表格
		String[] columnNames = { "商品编号", "商品名称", "产地", "计量单位", "单价", "数量","供应商名称" };// 表头
		((DefaultTableModel) table.getModel()).setColumnIdentifiers(columnNames);// 创建表格模型对象并向其中添加表头
		TableColumn column = table.getColumnModel().getColumn(0);// 以表格模型中索引为0的列作参照
		final DefaultCellEditor editor = new DefaultCellEditor(sp);// 创建单元格编辑器
		editor.setClickCountToStart(2);// 开始编辑单元格所需的单击次数为2次
		column.setCellEditor(editor);// 编辑参照列中单元格时所用的编辑器
	}

	private void initSpBox() {// 初始化“商品”下拉列表
		List list = new ArrayList();
		ResultSet set = Dao.query("select * from tb_kucun where " + "id in(select id from tb_spinfo where gysName='"
				+ gys.getSelectedItem() + "')");
		sp.removeAllItems();
		sp.addItem(new TbKucun());
		for (int i = 0; table != null && i < table.getRowCount(); i++) {
			TbKucun tmpInfo = (TbKucun) table.getValueAt(i, 0);
			if (tmpInfo != null && tmpInfo.getId() != null)
				list.add(tmpInfo.getId());
		}
		try {
			while (set.next()) {
				TbKucun kucun = new TbKucun();
				kucun.setId(set.getString("id").trim());
				if (list.contains(kucun.getId()))// 如果表格中以存在同样商品，商品下拉框中就不再包含该商品
					continue;
				kucun.setName(set.getString("name").trim());
				kucun.setSpcd(set.getString("spcd").trim());
				kucun.setSpdw(set.getString("spdw").trim());
				kucun.setGysname(set.getString("gysname").trim());
				kucun.setSpdj(Double.valueOf(set.getString("spdj").trim()));
				kucun.setSpsl(Integer.valueOf(set.getString("spsl").trim()));
				sp.addItem(kucun);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
		getContentPane().add(component, gridBagConstrains);// 添加组件
	}

	private final class computeInfo implements ContainerListener {// 在事件中计算品种数量、货品总数、合计金额
		public void componentRemoved(ContainerEvent e) {
			// 清除空行
			clearEmptyRow();
			// 计算代码
			int rows = table.getRowCount();
			int count = 0;
			double money = 0.0;
			// 计算品种数量
			TbKucun column = null;
			if (rows > 0)
				column = (TbKucun) table.getValueAt(rows - 1, 0);
			if (rows > 0 && (column == null || column.getId().isEmpty()))
				rows--;
			// 计算货品总数和金额
			for (int i = 0; i < rows; i++) {
				String column7 = (String) table.getValueAt(i, 7);
				String column6 = (String) table.getValueAt(i, 6);
				int c7 = (column7 == null || column7.isEmpty()) ? 0 : Integer.parseInt(column7);
				Double c6 = (column6 == null || column6.isEmpty()) ? 0 : Double.valueOf(column6);
				count += c7;
				money += c6 * c7;
			}
			spdj.setText(rows + "");
			spsl.setText(count + "");
			hjje.setText(money + "");
		}

		public void componentAdded(ContainerEvent e) {
		}
	}

	private final class initTasks extends InternalFrameAdapter {// 窗体的初始化任务
		public void internalFrameActivated(InternalFrameEvent e) {
			super.internalFrameActivated(e);
			initTimeField();// 启动退货时间线程
			initGysField();// 初始化供应商字段
			initrkid();// 初始化“入库编号”
			initSpBox();// 初始化“商品”下拉列表
		}

		private void initGysField() {// 初始化供应商字段
			List gysInfos = Dao.getGysInfos();
			for (Iterator iter = gysInfos.iterator(); iter.hasNext();) {
				List list = (List) iter.next();
				Item item = new Item();
				item.setId(list.get(0).toString().trim());
				item.setName(list.get(1).toString().trim());
				gys.addItem(item);
			}
			//doGysSelectAction();
		}

		private void initTimeField() {// 启动退货时间线程
			new Thread(new Runnable() {
				public void run() {
					try {
						while (true) {
							sjDate = new Date();
							rksj.setText(sjDate.toLocaleString());
							Thread.sleep(1000);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}

	private void initrkid() {// 初始化“入库编号”
		java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
		String maxId = Dao.getShangjiaMainMaxId(date);
		rkid.setText(maxId);
	}

	private synchronized void updateTable() {// 根据商品下拉框的选择，更新表格当前行的内容
		TbKucun kucun = (TbKucun) sp.getSelectedItem();
		int row = table.getSelectedRow();
		if (row >= 0 && kucun != null) {
			table.setValueAt(kucun.getId(), row, 1);
			table.setValueAt(kucun.getSpcd(), row, 2);
			table.setValueAt(kucun.getSpdw(), row, 3);
			table.setValueAt(kucun.getGysname(), row, 5);
			table.setValueAt(kucun.getSpdj().toString(), row, 6);
			table.setValueAt(kucun.getSpsl().toString(), row, 7);
			table.editCellAt(row, 7);
		}
	}

	private synchronized void clearEmptyRow() {// 清除空行
		DefaultTableModel dftm = (DefaultTableModel) table.getModel();
		for (int i = 0; i < table.getRowCount(); i++) {
			TbKucun kucun = (TbKucun) table.getValueAt(i, 0);
			if (kucun == null || kucun.getId() == null || kucun.getId().isEmpty()) {
				dftm.removeRow(i);
			}
		}
	}

	private void stopTableCellEditing() {// 停止表格单元的编辑
		TableCellEditor cellEditor = table.getCellEditor();
		if (cellEditor != null)
			cellEditor.stopCellEditing();
	}
}

