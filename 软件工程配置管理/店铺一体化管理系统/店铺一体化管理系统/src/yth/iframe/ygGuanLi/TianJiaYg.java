package yth.iframe.ygGuanLi;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import yth.dao.Dao;
import yth.dao.model.TbZg;

public class TianJiaYg extends JPanel {// ���Ա�����

	private JTextField ygName;// ���������ı���
	private JTextField tel;// ���绰���ı���
	private JTextField age;// �����䡱�ı���
	private JComboBox sex;// ���Ա������б�
	private JTextField id;//����š��ı���
	private JTextField bat;//�������˻����ı���
	private JComboBox status;//����ְ��ְ״̬�������б�

	private void clear() {// ����ı������ݵķ���
		// �����ı��������Ϊ��
		ygName.setText(null);
		tel.setText(null);
		age.setText(null);
		id.setText(null);
		bat.setText(null);
	}

	public TianJiaYg() {// ���Ա�����
		super();// ���ø���JPanel�Ĺ�����
		setLayout(new GridBagLayout());// �������Ա�����Ĳ���Ϊ���񲼾�
		setBounds(10, 10, 300, 256);// ����Ա�������ڲ������λ�úͿ��
		
		final JLabel label_4 = new JLabel();// ����������ǩ
		label_4.setFont(new Font("", Font.PLAIN, 14));// ���á���������ǩ���������ʽ�ʹ�С
		label_4.setText("������");// ���á���������ǩ�ڵ��ı�����
		final GridBagConstraints gridBagConstraints_10 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_10.gridx = 0;// ���λ������ĺ�������Ϊ0
		gridBagConstraints_10.gridy = 0;// ���λ���������������Ϊ0
		add(label_4, gridBagConstraints_10);// �����Ա���������ӡ���������ǩ
		
		ygName = new JTextField();// ���������ı���
		final GridBagConstraints gridBagConstraints_11 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_11.weighty = 1.0;// ������������Ȩ����1.0
		gridBagConstraints_11.insets = new Insets(0, 0, 0, 10);// ����˴˵ļ��
		gridBagConstraints_11.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
		gridBagConstraints_11.gridwidth = 2;// ��������Խ2������
		gridBagConstraints_11.gridy = 0;// ���λ���������������Ϊ0
		gridBagConstraints_11.gridx = 1;// ���λ������ĺ�������Ϊ1
		add(ygName, gridBagConstraints_11);// �����Ա���������ӡ��������ı���
		
		final JLabel label = new JLabel();// ���Ա𡱱�ǩ
		label.setFont(new Font("", Font.PLAIN, 14));// ���á��Ա𡱱�ǩ���������ʽ�ʹ�С
		label.setText("�Ա�");// ���á��Ա𡱱�ǩ�ڵ��ı�����
		final GridBagConstraints gridBagConstraints = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints.gridy = 1;// ���λ���������������Ϊ1
		gridBagConstraints.gridx = 0;// ���λ������ĺ�������Ϊ0
		add(label, gridBagConstraints);// �����Ա���������ӡ��Ա𡱱�ǩ
		
		sex = new JComboBox();// ���Ա������б�
		sex.addItem("��");// ���á��Ա������б��е�ѡ������
		sex.addItem("Ů");// ���á��Ա������б��е�ѡ������
		final GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_1.weightx = 1.0;// ������������Ȩ����1.0
		gridBagConstraints_1.weighty = 1.0;// ������������Ȩ����1.0
		gridBagConstraints_1.ipadx = -250;// ����������250����
		gridBagConstraints_1.insets = new Insets(0, 0, 0, 10);// ����˴˵ļ��
		gridBagConstraints_1.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
		gridBagConstraints_1.gridwidth = 2;// ��������Խ2������
		gridBagConstraints_1.gridy = 1;// ���λ���������������Ϊ1
		gridBagConstraints_1.gridx = 1;// ���λ������ĺ�������Ϊ1
		add(sex, gridBagConstraints_1);// �����Ա���������ӡ��Ա������б�
		
		final JLabel label_2 = new JLabel();// �����䡱��ǩ
		label_2.setFont(new Font("", Font.PLAIN, 14));// ���á����䡱��ǩ���������ʽ�ʹ�С
		label_2.setText("���䣺");// ���á����䡱��ǩ�ڵ��ı�����
		final GridBagConstraints gridBagConstraints_4 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_4.gridy = 2;// ���λ���������������Ϊ2
		gridBagConstraints_4.gridx = 0;// ���λ������ĺ�������Ϊ0
		add(label_2, gridBagConstraints_4);// �����Ա���������ӡ����䡱��ǩ
		
		age = new JTextField();// �����䡱�ı���
		final GridBagConstraints gridBagConstraints_5 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_5.weighty = 1.0;// ������������Ȩ����1.0
		gridBagConstraints_5.insets = new Insets(0, 0, 0, 10);// ����˴˵ļ��
		gridBagConstraints_5.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
		gridBagConstraints_5.gridwidth = 2;// ��������Խ2������
		gridBagConstraints_5.gridy = 2;// ���λ���������������Ϊ2
		gridBagConstraints_5.gridx = 1;// ���λ������ĺ�������Ϊ1
		add(age, gridBagConstraints_5);// �����Ա���������ӡ����䡱�ı���
		
		final JLabel label_3 = new JLabel();// ���绰����ǩ
		label_3.setFont(new Font("", Font.PLAIN, 14));// ���á��绰����ǩ���������ʽ�ʹ�С
		label_3.setText("�绰��");// ���á��绰����ǩ�ڵ��ı�����
		final GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_6.gridy = 3;// ���λ���������������Ϊ3
		gridBagConstraints_6.gridx = 0;// ���λ������ĺ�������Ϊ0
		add(label_3, gridBagConstraints_6);// �����Ա���������ӡ��绰����ǩ
		
		tel = new JTextField();// ���绰���ı���
		final GridBagConstraints gridBagConstraints_7 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_7.weighty = 1.0;// ������������Ȩ����1.0
		gridBagConstraints_7.insets = new Insets(0, 0, 0, 10);// ����˴˵ļ��
		gridBagConstraints_7.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
		gridBagConstraints_7.gridwidth = 2;// ��������Խ2������
		gridBagConstraints_7.gridy = 3;// ���λ���������������Ϊ3
		gridBagConstraints_7.gridx = 1;// ���λ������ĺ�������Ϊ1
		add(tel, gridBagConstraints_7);// �����Ա���������ӡ��绰���ı���
		
		final JLabel label_5 = new JLabel();// ����š���ǩ
		label_5.setFont(new Font("", Font.PLAIN, 14));// ���á���š���ǩ���������ʽ�ʹ�С
		label_5.setText("��ţ�");// ���á���š���ǩ�ڵ��ı�����
		final GridBagConstraints gridBagConstraints_12 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_12.gridy = 4;// ���λ���������������Ϊ3
		gridBagConstraints_12.gridx = 0;// ���λ������ĺ�������Ϊ0
		add(label_5, gridBagConstraints_12);// �����Ա���������ӡ���š���ǩ
		
		id = new JTextField();// ����š��ı���
		final GridBagConstraints gridBagConstraints_13 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_13.weighty = 1.0;// ������������Ȩ����1.0
		gridBagConstraints_13.insets = new Insets(0, 0, 0, 10);// ����˴˵ļ��
		gridBagConstraints_13.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
		gridBagConstraints_13.gridwidth = 2;// ��������Խ2������
		gridBagConstraints_13.gridy = 4;// ���λ���������������Ϊ3
		gridBagConstraints_13.gridx = 1;// ���λ������ĺ�������Ϊ1
		add(id, gridBagConstraints_13);// ��Ա�����ô�������ӡ���š��ı���
		
		final JLabel label_6 = new JLabel();// �������˻�����ǩ
		label_6.setFont(new Font("", Font.PLAIN, 14));// ���á������˻�����ǩ���������ʽ�ʹ�С
		label_6.setText("�����˻���");// ���á������˻�����ǩ�ڵ��ı�����
		final GridBagConstraints gridBagConstraints_14 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_14.gridy = 5;// ���λ���������������Ϊ3
		gridBagConstraints_14.gridx = 0;// ���λ������ĺ�������Ϊ0
		add(label_6, gridBagConstraints_14);// ��Ա����������ӡ������˻�����ǩ
		
		bat = new JTextField();// �������˻����ı���
		final GridBagConstraints gridBagConstraints_15 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_15.weighty = 1.0;// ������������Ȩ����1.0
		gridBagConstraints_15.insets = new Insets(0, 0, 0, 10);// ����˴˵ļ��
		gridBagConstraints_15.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
		gridBagConstraints_15.gridwidth = 2;// ��������Խ2������
		gridBagConstraints_15.gridy = 5;// ���λ���������������Ϊ3
		gridBagConstraints_15.gridx = 1;// ���λ������ĺ�������Ϊ1
		add(bat, gridBagConstraints_15);// �����Ա���������ӡ������˻����ı���
		
		final JLabel label_7 = new JLabel();// ����ְ״̬����ǩ
		label_7.setFont(new Font("", Font.PLAIN, 14));// ���á��Ա𡱱�ǩ���������ʽ�ʹ�С
		label_7.setText("��ְ״̬��");// ���á��Ա𡱱�ǩ�ڵ��ı�����
		final GridBagConstraints gridBagConstraints_16 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_16.gridy = 6;// ���λ���������������Ϊ1
		gridBagConstraints_16.gridx = 0;// ���λ������ĺ�������Ϊ0
		add(label_7, gridBagConstraints_16);// �����Ա���������ӡ��Ա𡱱�ǩ
		
		status = new JComboBox();// ����ְ״̬�������б�
		status.addItem("��ְ");// ���á���ְ�������б��е�ѡ������
		status.addItem("��ְ");// ���á���ְ�������б��е�ѡ������
		final GridBagConstraints gridBagConstraints_17 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_17.weightx = 1.0;// ������������Ȩ����1.0
		gridBagConstraints_17.weighty = 1.0;// ������������Ȩ����1.0
		gridBagConstraints_17.ipadx = -250;// ����������250����
		gridBagConstraints_17.insets = new Insets(0, 0, 0, 10);// ����˴˵ļ��
		gridBagConstraints_17.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
		gridBagConstraints_17.gridwidth = 2;// ��������Խ2������
		gridBagConstraints_17.gridy = 6;// ���λ���������������Ϊ1
		gridBagConstraints_17.gridx = 1;// ���λ������ĺ�������Ϊ1
		add(status, gridBagConstraints_17);// �����Ա���������ӡ��Ա������б�
		
		final JButton button = new JButton("���");// ����ӡ���ť
		button.addActionListener(new ActionListener() {// ����ӡ���ť�����¼��ļ���
			public void actionPerformed(final ActionEvent e) {
				String nameStr = ygName.getText();// ��á��������ı����е��ı�����
				if (nameStr == null || nameStr.isEmpty())// ���������ı���Ϊ�ջ��������ı����е��ı�����Ϊ��
					return;// �˳�Ӧ�ó���
				String ageStr = new String(age.getText());// ��á����䡱�ı����е��ı�����
				TbZg user = Dao.getYg(nameStr, ageStr);// Ա����Ϣ
				if (user.getSex() != null && !user.getSex().isEmpty()) {// Ա�����Ա�Ϊ����Ա����ʾ�Ա���ַ����ĳ��Ȳ�Ϊ0
					JOptionPane.showMessageDialog(TianJiaYg.this, "Ա��(" + user.getName() + ")�Ѿ�����");// �����Ի���
					sex.setFocusable(true);// // ���Ա������б��ý���
					return;// �˳�Ӧ�ó���
				}
				String sexStr = sex.getSelectedItem() + "";// ���Ա�����Ա�
				String statusStr = status.getSelectedItem() + "";
				TbZg yg = new TbZg();// Ա����Ϣ
				yg.setTel(tel.getText());// ����Ա���绰
				yg.setAge(age.getText());// ����Ա������
				yg.setName(nameStr);// ����Ա������
				yg.setSex(sexStr);// ����Ա���Ա�
				yg.setId(id.getText());
				yg.setBat(bat.getText());
				yg.setFlag(statusStr);
				int i = Dao.addYg(yg);// ���Ա��
				if (i > 0)// ���Ա������Ŀ����1
					JOptionPane.showMessageDialog(TianJiaYg.this, "��ӳɹ�");// ������ʾ��
				clear();// ����ı��������
			}
		});
		final GridBagConstraints gridBagConstraints_8 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_8.weighty = 1.0;// ������������Ȩ����1.0
		gridBagConstraints_8.anchor = GridBagConstraints.EAST;// ��������ڸ������ʾ���������
		gridBagConstraints_8.gridy = 7;// ���λ���������������Ϊ7
		gridBagConstraints_8.gridx = 1;// ���λ������ĺ�������Ϊ1
		add(button, gridBagConstraints_8);// �����Ա���������ӡ���ӡ���ť

		final JButton button_1 = new JButton();// �����á���ť
		button_1.addActionListener(new ActionListener() {// Ϊ�����á���ť��Ӷ����¼��ļ���
			public void actionPerformed(final ActionEvent e) {
				clear();// ����ı��������
			}
		});
		button_1.setText("����");// ���á����á���ť�е���������
		final GridBagConstraints gridBagConstraints_9 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_9.weighty = 1.0;// ������������Ȩ����1.0
		gridBagConstraints_9.gridy = 7;// ���λ���������������Ϊ5
		gridBagConstraints_9.gridx = 2;// ���λ������ĺ�������Ϊ2
		add(button_1, gridBagConstraints_9);// �����Ա���������ӡ����á���ť
	}
}
