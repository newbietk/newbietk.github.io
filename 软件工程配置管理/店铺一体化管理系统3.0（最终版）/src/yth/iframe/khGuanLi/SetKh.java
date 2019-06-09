package yth.iframe.khGuanLi;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

import yth.dao.Dao;
import yth.iframe.*;

public class SetKh extends JInternalFrame {

	private JTable table;
	private DefaultTableModel dftm;//创建表格对象
	private String[] columnNames;//存储列标题的数组

	public SetKh() {
		setIconifiable(true);
		setClosable(true);
		setTitle("会员设置");
		setBounds(0, 0, 500, 350);
		setLayout(new GridBagLayout());
		
		final JScrollPane scrollPane = new JScrollPane();// 滚动面板
		final GridBagConstraints gridBagConstraints = new GridBagConstraints();// 创建网格限制对象
		gridBagConstraints.weightx = 1.0;// 组件横向扩大的权重是1.0
		gridBagConstraints.insets = new Insets(0, 0, 20, 0);// 组件彼此的间距
		gridBagConstraints.gridwidth = 12;// 组件横向跨越12个网格
		gridBagConstraints.fill = GridBagConstraints.BOTH;// 组件水平、数值同时扩大以占据空白区域
		gridBagConstraints.weighty = 1.0;// 组件纵向扩大的权重是1.0
		gridBagConstraints.gridx = 0;// 组件位于网格的横向索引为0
		gridBagConstraints.gridy = 0;// 组件位于网格的纵向索引为0
		gridBagConstraints.ipadx = 35;// 组件横向增加35像素
		gridBagConstraints.ipady = -195;// 组件纵向减少195像素
		add(scrollPane, gridBagConstraints);// 向设置员工面板中添加滚动面板
		
		table = new JTable();
		dftm = (DefaultTableModel) table.getModel();
		addInternalFrameListener(new InternalFrameAdapter(){
			public void internalFrameActivated(InternalFrameEvent e) {
				super.internalFrameActivated(e);
				initTable();
			}
		});
		columnNames = new String[] {"编号","姓名","会员等级","电话","余额"};
		dftm.setColumnIdentifiers(columnNames);
		scrollPane.setViewportView(table);
		
		final JButton button = new JButton("删除");
		final GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();
		gridBagConstraints_1.insets = new Insets(5,0,5,0);
		gridBagConstraints_1.gridx = 1;
		gridBagConstraints_1.gridy = 1;
		add(button, gridBagConstraints_1);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(final ActionEvent e) {
				int op = JOptionPane.showConfirmDialog(SetKh.this, "确认删除该会员？");
				if(op == JOptionPane.OK_OPTION){
					int selRow = table.getSelectedRow();
					if(selRow < 0)
						return;
					String id = table.getValueAt(selRow, 0).toString().trim();
					Dao.delete("delete from tb_khinfo where id='" + id +"'");
					initTable();
				}
			}
		});
	}

	public void initTable() {
		List ul = Dao.getKhs();
		Iterator it = ul.iterator();
		String[] data = new String[5];
		dftm.setDataVector(null, columnNames);
		while(it.hasNext()) {
			List khlist = (List) it.next();
			data[0] = (String) khlist.get(0);
			data[1] = (String) khlist.get(1);
			data[2] = (String) khlist.get(2);
			data[3] = (String) khlist.get(3);
			data[4] = (String) khlist.get(4);
			dftm.addRow(data);
		}
		setVisible(true);
	}
}