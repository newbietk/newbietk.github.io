package yth.iframe.ygGuanLi;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

import yth.dao.Dao;
import yth.dao.model.*;

public class SetYg extends JInternalFrame {// Ա�����ô���

	private JTextField sexField;// ���Ա��ı���
	private JTextField ageField;// �����䡱�ı���
	private JTextField nameField;// ���������ı���
	private JTextField telField;//����ϵ�绰���ı���
	private JTextField bakField;//�������˻����ı���
	private JTable table;// ���ģ��
	private DefaultTableModel dftm;// ����������
	private String[] columnNames;// �洢�б��������

	public SetYg() {// Ա�����ô���
		setTitle("Ա������");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 500, 300);// ���á�����Ա����塱��λ�úͿ��
		setLayout(new GridBagLayout());// ���á�����Ա����塱�Ĳ���Ϊ���񲼾�

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

		table = new JTable();// ���ģ��
		dftm = (DefaultTableModel) table.getModel();// ����������
		addInternalFrameListener(new InternalFrameAdapter(){
			public void internalFrameActivated(InternalFrameEvent e) {
				super.internalFrameActivated(e);
				initTable();
			}
		});
		columnNames = new String[] { "���", "����", "�Ա�", "����", "��ϵ�绰","�����˻�", "״̬" };// �洢�б��������
		dftm.setColumnIdentifiers(columnNames);// ���б��������е�Ԫ���滻�������е��б�ʶ��
		table.addMouseListener(new MouseAdapter() {// Ϊ���ģ�����������¼�
			public void mouseClicked(final MouseEvent e) {
				String nameStr, ageStr, sexStr, telStr, bakStr;// �����������������Ա𡱡������䡱������ϵ�绰�����������˻���
				int selRow = table.getSelectedRow();// ѡ���е�����
				nameStr = table.getValueAt(selRow, 1).toString().trim();// ��á�������
				ageStr = table.getValueAt(selRow, 3).toString().trim();// ��á����䡱
				sexStr = table.getValueAt(selRow, 2).toString().trim();// ��á��Ա�
				telStr = table.getValueAt(selRow, 4).toString().trim();//��á���ϵ�绰��
				bakStr = table.getValueAt(selRow, 5).toString().trim();//��á������˻���
				nameField.setText(nameStr);// ���á��������ı����е�����
				ageField.setText(ageStr);// ���á����䡱�ı����е�����
				sexField.setText(sexStr);// ���á��Ա��ı����е�����
				telField.setText(telStr);//���á���ϵ�绰���ı����е�����
				bakField.setText(bakStr);//���á������˻����ı����е�����
			}
		});
		scrollPane.setViewportView(table);// �ѱ��ģ�����ڹ��������

		final JLabel label = new JLabel();// ����������ǩ
		final GridBagConstraints gridBagConstraints_3 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_3.gridy = 2;// ���λ���������������Ϊ2
		gridBagConstraints_3.gridx = 0;// ���λ������ĺ�������Ϊ0
		add(label, gridBagConstraints_3);// �����þ������������ӡ���������ǩ
		label.setText("������");// ���á���������ǩ�е��ı�����

		nameField = new JTextField();// ���������ı���
		nameField.setEditable(true);// ���á��������ı��򲻿ɱ༭
		final GridBagConstraints gridBagConstraints_4 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_4.insets = new Insets(0, 0, 0, 10);// ����˴˵ļ��
		gridBagConstraints_4.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
		gridBagConstraints_4.weightx = 1.0;// ������������Ȩ����1.0
		gridBagConstraints_4.gridy = 2;// ���λ���������������Ϊ2
		gridBagConstraints_4.gridx = 1;// ���λ������ĺ�������Ϊ3
		add(nameField, gridBagConstraints_4);// �����þ������������ӡ��������ı���

		final JLabel label_2 = new JLabel();// ���Ա𡱱�ǩ
		label_2.setText("�Ա�");// ���á��Ա𡱱�ǩ�е��ı�����
		final GridBagConstraints gridBagConstraints_7 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_7.gridy = 2;// ���λ���������������Ϊ2
		gridBagConstraints_7.gridx = 2;// ���λ������ĺ�������Ϊ4
		add(label_2, gridBagConstraints_7);// �����þ������������ӡ��Ա𡱱�ǩ

		sexField = new JTextField();// ���Ա��ı���
		sexField.setEditable(true);// ���á��Ա��ı��򲻿ɱ༭
		final GridBagConstraints gridBagConstraints_8 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_8.weightx = 1.0;// ������������Ȩ����1.0
		gridBagConstraints_8.insets = new Insets(0, 0, 0, 10);// ����˴˵ļ��
		gridBagConstraints_8.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
		gridBagConstraints_8.gridy = 2;// ���λ���������������Ϊ2
		gridBagConstraints_8.gridx = 3;// ���λ������ĺ�������Ϊ5
		add(sexField, gridBagConstraints_8);// ������Ա���������ӡ��Ա��ı���

		final JLabel label_1 = new JLabel();// �����䡱��ǩ
		final GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_6.gridy = 2;// ���λ���������������Ϊ2
		gridBagConstraints_6.gridx = 4;// ���λ������ĺ�������Ϊ6
		add(label_1, gridBagConstraints_6);// ������Ա���������ӡ��Ա��ı���
		label_1.setText("���䣺");// ���á����䡱��ǩ�е��ı�����

		ageField = new JTextField();// �����䡱�ı���
		final GridBagConstraints gridBagConstraints_5 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_5.insets = new Insets(0, 0, 0, 10);// ����˴˵ļ��
		gridBagConstraints_5.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
		gridBagConstraints_5.weightx = 1.0;// ������������Ȩ����1.0
		gridBagConstraints_5.gridy = 2;// ���λ���������������Ϊ2
		gridBagConstraints_5.gridx = 5;// ���λ������ĺ�������Ϊ7
		add(ageField, gridBagConstraints_5);// ������Ա���������ӡ����䡱�ı���
		ageField.setEditable(true);
		
		final JLabel label_3 = new JLabel();//����ϵ�绰����ǩ
		final GridBagConstraints gridBagConstraints_9 = new GridBagConstraints();
		label_3.setText("��ϵ�绰��");
		gridBagConstraints_9.gridy = 3;
		gridBagConstraints_9.gridx = 0;
		add(label_3,gridBagConstraints_9);
		
		telField = new JTextField();
		final GridBagConstraints gridBagConstraints_10 = new GridBagConstraints();
		gridBagConstraints_10.insets = new Insets(0, 0, 0, 10);
		gridBagConstraints_10.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_10.weightx = 1.0;
		gridBagConstraints_10.gridy = 3;
		gridBagConstraints_10.gridx = 1;
		add(telField,gridBagConstraints_10);
		
		final JLabel label_4 = new JLabel();//�������˻�����ǩ
		final GridBagConstraints gridBagConstraints_11 = new GridBagConstraints();
		label_4.setText("�����˻���");
		gridBagConstraints_11.gridy = 3;
		gridBagConstraints_11.gridx = 2;
		add(label_4,gridBagConstraints_11);
		
		bakField = new JTextField();
		final GridBagConstraints gridBagConstraints_12 = new GridBagConstraints();
		gridBagConstraints_12.insets = new Insets(0, 0, 0, 10);
		gridBagConstraints_12.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_12.weightx = 1.0;
		gridBagConstraints_12.gridy = 3;
		gridBagConstraints_12.gridx = 3;
		add(bakField,gridBagConstraints_12);

		final JButton button = new JButton("ɾ��");// ��ɾ������ť
		final GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_1.insets = new Insets(5, 0, 5, 0);// ����˴˵ļ��
		gridBagConstraints_1.gridy = 7;// ���λ���������������Ϊ7
		gridBagConstraints_1.gridx = 4;// ���λ������ĺ�������Ϊ4
		add(button, gridBagConstraints_1);// �����þ������������ӡ�ɾ������ť
		button.addActionListener(new ActionListener() {// ��ɾ������ť�����¼��ļ���
			public void actionPerformed(final ActionEvent e) {
				int op = JOptionPane.showConfirmDialog(SetYg.this, "ȷ��Ҫɾ���ò���Ա��");// ������ȷ��Ҫɾ���ò���Ա��������ʾ��
				if (op == JOptionPane.OK_OPTION) {// �����ȷ�ϡ�
					int selRow = table.getSelectedRow();// ѡ���е�����
					if (selRow < 0)// ѡ���е�����С��0
						return;// �˳�Ӧ�ó���
					String id = table.getValueAt(selRow, 0).toString().trim();// ��þ����˱��
					Dao.delete("delete from tb_zg where id='" + id + "'");// ִ��SQLɾ�����
					sexField.setText("");// ���á��Ա��ı����е�����Ϊ��
					ageField.setText("");// ���á����䡱�ı����е�����Ϊ��
					nameField.setText("");// ���á��������ı����е�����Ϊ��
					initTable();// ��ʼ�����ģ��
				}
			}
		});

		final JButton unenableButton = new JButton("����");// ������/���á���ť
		final GridBagConstraints gridBagConstraints4 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints4.insets = new Insets(5, 0, 5, 0);// ����˴˵ļ��
		gridBagConstraints4.gridy = 7;// ���λ���������������Ϊ7
		gridBagConstraints4.gridx = 1;// ���λ������ĺ�������Ϊ3
		add(unenableButton, gridBagConstraints4);// �����þ������������ӡ�����/���á���ť
		unenableButton.addActionListener(new ActionListener() {// ������/���á���ť�����¼��ļ���
			public void actionPerformed(final ActionEvent e) {
				int selRow = table.getSelectedRow();// ѡ���е�����
				if (selRow < 0)// ѡ���е�����С��0
					return;// �˳�Ӧ�ó���
				int op = JOptionPane.showConfirmDialog(SetYg.this, "ȷ��Ҫ�޸ĸ�Ա��״̬��");// ������ȷ��Ҫ�޸ĸò���Ա״̬��������ʾ��
				if (op == JOptionPane.OK_OPTION) {// �����ȷ�ϡ�
					if (selRow < 0)// ѡ���е�����С��0
						return;// �˳�Ӧ�ó���
					String id = table.getValueAt(selRow, 0).toString().trim();// ���Ա�����
					Dao.update("update tb_zg set flag=0 where id='" + id + "'");// ִ��SQL�޸����
					initTable();// ��ʼ�����ģ��
				}
			}
		});
		
		final JButton enableButton = new JButton("����");// ������/���á���ť
		final GridBagConstraints gridBagConstraints_14 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_14.insets = new Insets(5, 0, 5, 0);// ����˴˵ļ��
		gridBagConstraints_14.gridy = 7;// ���λ���������������Ϊ7
		gridBagConstraints_14.gridx = 2;// ���λ������ĺ�������Ϊ3
		add(enableButton, gridBagConstraints_14);// �����þ������������ӡ�����/���á���ť
		enableButton.addActionListener(new ActionListener() {// ������/���á���ť�����¼��ļ���
			public void actionPerformed(final ActionEvent e) {
				int selRow = table.getSelectedRow();// ѡ���е�����
				if (selRow < 0)// ѡ���е�����С��0
					return;// �˳�Ӧ�ó���
				int op = JOptionPane.showConfirmDialog(SetYg.this, "ȷ��Ҫ�޸ĸ�Ա��״̬��");// ������ȷ��Ҫ�޸ĸò���Ա״̬��������ʾ��
				if (op == JOptionPane.OK_OPTION) {// �����ȷ�ϡ�
					if (selRow < 0)// ѡ���е�����С��0
						return;// �˳�Ӧ�ó���
					String id = table.getValueAt(selRow, 0).toString().trim();// ���Ա�����
					Dao.update("update tb_zg set flag=1 where id='" + id + "'");// ִ��SQL�޸����
					initTable();// ��ʼ�����ģ��
				}
			}
		});
		
		final JButton modifyButton = new JButton("�޸�");
		final GridBagConstraints gridBagConstraints_13 = new GridBagConstraints();
		gridBagConstraints_13.insets = new Insets(5,0,5,0);
		gridBagConstraints_13.gridy = 7;
		gridBagConstraints_13.gridx = 3;
		add(modifyButton,gridBagConstraints_13);
		modifyButton.addActionListener(new ActionListener(){
			public void actionPerformed(final ActionEvent e) {
				int selRow = table.getSelectedRow();// ѡ���е�����
				TbZg zgInfo = new TbZg();
				zgInfo.setId(table.getValueAt(selRow, 0).toString().trim());
				zgInfo.setName(nameField.getText().trim());
				zgInfo.setSex(sexField.getText().trim());
				zgInfo.setAge(ageField.getText().trim());
				zgInfo.setTel(telField.getText().trim());
				zgInfo.setBat(bakField.getText().trim());
				if(Dao.updateYg(zgInfo) == 1)
					JOptionPane.showMessageDialog(SetYg.this,"�޸ĳɹ�");
				else
					JOptionPane.showMessageDialog(SetYg.this,"�޸�ʧ��");
				initTable();// ��ʼ�����ģ��
			}
		});
		
		
	}

	public void initTable() {// ��ʼ�����ģ��
		List ul = Dao.getYgs();// ��ñ����õ�Ա������
		Iterator it = ul.iterator();// ��ȡԱ�����ϵĵ�����
		String[] data = new String[7];// ��������Ϊ7���ַ�������
		dftm.setDataVector(null, columnNames);// ���ñ��ģ�Ͷ��������
		while (it.hasNext()) {// Ա���ļ����е�Ԫ���Ƿ񱻱�����
			List userlist = (List) it.next();// ���Ա���ļ����е���һ��Ԫ��
			// �Ѽ�����Ԫ�ش�����ַ���������
			data[0] = (String) userlist.get(0);
			data[1] = (String) userlist.get(1);
			data[2] = (String) userlist.get(2);
			data[3] = (String) userlist.get(3);
			data[4] = (String) userlist.get(4);
			data[5] = (String) userlist.get(5);
			data[6] = ((String) userlist.get(6)).equals("1") ? "��ְ" : "��ְ";
			dftm.addRow(data);// ������������������
		}
		setVisible(true);// ʹ���ģ�Ϳɼ�
	}
}
