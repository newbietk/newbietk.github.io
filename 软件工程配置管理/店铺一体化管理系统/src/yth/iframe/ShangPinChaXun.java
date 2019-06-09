package yth.iframe;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import yth.Item;
import yth.dao.Dao;
import yth.dao.model.TbSpinfo;

public class ShangPinChaXun extends JInternalFrame {// 商品查询内部窗体
	
	private JTable table;// 表格模型
	private JTextField conditionContent;// “条件内容”文本框
	private JComboBox conditionOperation;// “条件运算”下拉列表
	private JComboBox conditionName;// “条件名称”下拉列表
	
	public ShangPinChaXun() {// 商品查询内部窗体的构造方法
		super();// 调用父类JInternalFrame的构造方法
		setIconifiable(true);// 可以图标化
		setClosable(true);// 可以关闭
		setTitle("商品信息查询");// 设置商品查询内部窗体的标题
		getContentPane().setLayout(new GridBagLayout());// 设置商品查询内部窗体的布局为网格布局
		setBounds(100, 100, 650, 375);// 设置商品查询内部窗体的位置和宽高
		// 表格模型
		table = new JTable();
		table.setEnabled(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 不自动调整列的宽度；使用滚动条
		final DefaultTableModel dftm = (DefaultTableModel) table.getModel();
		String[] tableHeads = new String[]{"商品编号", "商品名称", "产地", "计量单位",
				"单价", "数量", "供应商名称",};
		dftm.setColumnIdentifiers(tableHeads);
		// 滚动面板
		final JScrollPane scrollPane = new JScrollPane(table);
		final GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();
		gridBagConstraints_6.weighty = 1.0;
		gridBagConstraints_6.anchor = GridBagConstraints.NORTH;
		gridBagConstraints_6.insets = new Insets(0, 10, 0, 10);
		gridBagConstraints_6.fill = GridBagConstraints.BOTH;
		gridBagConstraints_6.gridwidth = 6;
		gridBagConstraints_6.gridy = 1;
		gridBagConstraints_6.gridx = 0;
		getContentPane().add(scrollPane, gridBagConstraints_6);
		// “选择查询条件”标签和“条件名称”下拉列表
		setupComponet(new JLabel(" 选择查询条件："), 0, 0, 1, 1, false);
		conditionName = new JComboBox();
		conditionName.setModel(new DefaultComboBoxModel(new String[]{"商品名称", "供应商名称", "产地"}));
		setupComponet(conditionName, 1, 0, 1, 30, true);
		// “条件运算”下拉列表
		conditionOperation = new JComboBox();
		conditionOperation.setModel(new DefaultComboBoxModel(new String[]{"等于", "包含"}));
		setupComponet(conditionOperation, 2, 0, 1, 30, true);
		// “条件内容”文本框
		conditionContent = new JTextField();
		setupComponet(conditionContent, 3, 0, 1, 140, true);
		// “查询”按钮
		final JButton queryButton = new JButton();
		queryButton.addActionListener(new QueryAction(dftm));
		setupComponet(queryButton, 4, 0, 1, 1, false);
		queryButton.setText("查询");
		// “显示全部数据”按钮
		final JButton showAllButton = new JButton();
		showAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				conditionContent.setText("");
				List list = Dao.getSpInfos();
				updateTable(list, dftm);
			}
		});
		setupComponet(showAllButton, 5, 0, 1, 1, false);
		showAllButton.setText("显示全部数据");
	}
	// 点击“显示全部数据”按钮后，更新表格内容
	private void updateTable(List list, final DefaultTableModel dftm) {
		int num = dftm.getRowCount();
		for (int i = 0; i < num; i++)
			dftm.removeRow(0);
		Iterator iterator = list.iterator();
		TbSpinfo spInfo;// 商品信息
		while (iterator.hasNext()) {
			List info = (List) iterator.next();
			Item item = new Item();
			item.setId((String) info.get(0));
			item.setName((String) info.get(1));
			spInfo = Dao.getSpInfo(item);
			Vector rowData = new Vector();
			rowData.add(spInfo.getId().trim());// 商品编号
			rowData.add(spInfo.getName().trim());// 商品名称
			rowData.add(spInfo.getSpcd());// 产地
			rowData.add(spInfo.getSpdw());// 商品计量单位
			rowData.add(spInfo.getSpdj());// 商品单价
			rowData.add(spInfo.getSpsl());// 商品数量
			rowData.add(spInfo.getGysname());// 供应商名称
			dftm.addRow(rowData);// 向表格对象添加行数据（商品信息）
		}
	}
	// 设置组件位置并添加到容器中
	private void setupComponet(JComponent component, int gridx, int gridy,
			int gridwidth, int ipadx, boolean fill) {
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
	// 条件查询
	private final class QueryAction implements ActionListener {
		private final DefaultTableModel dftm;
		private QueryAction(DefaultTableModel dftm) {
			this.dftm = dftm;
		}
		public void actionPerformed(final ActionEvent e) {
			String conName, conOperation, content;
			conName = conditionName.getSelectedItem().toString().trim();
			conOperation = conditionOperation.getSelectedItem().toString();
			content = conditionContent.getText().trim();
			List list = null;
			list = searchInfo(conName, conOperation, content, list);
			updateTable(list, dftm);
		}
		// 拼接SQL语句，并获得执行SQL语句后相应的结果集
		private List searchInfo(String conName, String conOperation,
				String content, List list) {
			String sql = "select * from tb_spinfo where ";
			if (conOperation.equals("等于")) {
				if (conName.equals("商品名称"))
					list = Dao.findForList(sql + "name='" + content + "'");
				if (conName.equals("供应商名称"))
					list = Dao.findForList(sql + "gysname='" + content + "'");
				if (conName.equals("产地"))
					list = Dao.findForList(sql + "spcd='" + content + "'");
			} else {
				if (conName.equals("商品名称"))
					list = Dao.findForList(sql + "name like '%" + content
							+ "%'");
				if (conName.equals("供应商全称"))
					list = Dao.findForList(sql + "gysname like '%" + content
							+ "%'");
				if (conName.equals("产地"))
					list = Dao.findForList(sql + "spcd like '%" + content + "%'");
			}
			return list;
		}
	}
}
