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
	private DefaultTableModel dftm;//����������
	private String[] columnNames;//�洢�б��������

	public SetKh() {
		setIconifiable(true);
		setClosable(true);
		setTitle("��Ա����");
		setBounds(0, 0, 500, 350);
		setLayout(new GridBagLayout());
		
		final JScrollPane scrollPane = new JScrollPane();// �������
		final GridBagConstraints gridBagConstraints = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints.weightx = 1.0;// ������������Ȩ����1.0
		gridBagConstraints.insets = new Insets(0, 0, 20, 0);// ����˴˵ļ��
		gridBagConstraints.gridwidth = 12;// ��������Խ12������
		gridBagConstraints.fill = GridBagConstraints.BOTH;// ���ˮƽ����ֵͬʱ������ռ�ݿհ�����
		gridBagConstraints.weighty = 1.0;// ������������Ȩ����1.0
		gridBagConstraints.gridx = 0;// ���λ������ĺ�������Ϊ0
		gridBagConstraints.gridy = 0;// ���λ���������������Ϊ0
		gridBagConstraints.ipadx = 35;// �����������35����
		gridBagConstraints.ipady = -195;// ����������195����
		add(scrollPane, gridBagConstraints);// ������Ա���������ӹ������
		
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
		scrollPane.setViewportView(table);
		
		final JButton button = new JButton("ɾ��");
		final GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();
		gridBagConstraints_1.insets = new Insets(5,0,5,0);
		gridBagConstraints_1.gridx = 1;
		gridBagConstraints_1.gridy = 1;
		add(button, gridBagConstraints_1);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(final ActionEvent e) {
				int op = JOptionPane.showConfirmDialog(SetKh.this, "ȷ��ɾ���û�Ա��");
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