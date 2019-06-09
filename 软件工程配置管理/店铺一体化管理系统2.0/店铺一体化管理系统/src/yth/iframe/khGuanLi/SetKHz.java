package yth.iframe.khGuanLi;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

import yth.*;
import yth.dao.Dao;
import yth.iframe.*;

public class SetKHz extends JInternalFrame {

	private JTable table;
	private DefaultTableModel dftm;//����������
	private String[] columnNames;//�洢�б��������

	public SetKHz() {
		setIconifiable(true);
		setClosable(true);
		setTitle("��Ա����");
		setBounds(0, 0, 500, 200);
		setLayout(new GridBagLayout());
		
		table = new JTable();
		dftm = (DefaultTableModel) table.getModel();
		addInternalFrameListener(new InternalFrameAdapter(){
			public void internalFrameActivated(InternalFrameEvent e) {
				super.internalFrameActivated(e);
				initTable();
			}
		});
		columnNames = new String[] {"���","����","��Ա�ȼ�","�绰","���"};
		dftm.setColumnIdentifiers(columnNames);
		
		final JButton button = new JButton("ɾ��");
		final GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = new Insets(5,0,5,0);
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		add(button, gridBagConstraints);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(final ActionEvent e) {
				int op = JOptionPane.showConfirmDialog(SetKHz.this, "ȷ��ɾ���û�Ա��");
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