package yth.iframe.gysGuanLi;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import keyListener.InputKeyListener;

import yth.dao.Dao;
import yth.dao.model.TbGysinfo;

public class GysTianJiaPanel extends JInternalFrame {// ��Ӧ��������

	private JTextField GysNameF;// ����Ӧ�����ơ��ı���
	private JTextField GysAddressF;// ����ַ���ı���
	private JTextField GysMailF;// �����䡱�ı���
	private JTextField GysTelF;// ���绰���ı���
	private JTextField GysBatF;// �������˻����ı���
	private JTextField GysTaxF;// ����˰�š��ı���
	private JButton resetButton;// �����á��ı���

	public GysTianJiaPanel() {// ��Ӧ��������
		setTitle("��Ӧ�����"); //���ô��ڱ���
		setIconifiable(true);// ���ù�Ӧ�̹��������ͼ�껯
		setClosable(true);// ���ÿ��Թرչ�Ӧ�̹�����
		setLayout(new GridBagLayout());// ���ù�Ӧ��������Ĳ���Ϊ���񲼾�
		setBounds(10, 10, 510, 302);// ���ù�Ӧ���������λ������

		setupComponet(new JLabel("��Ӧ�����ƣ�"), 0, 0, 1, 1, false);// ���á���Ӧ�����ơ���ǩ��λ�ò���ӵ�������
		GysNameF = new JTextField();// ����Ӧ�����ơ��ı���
		setupComponet(GysNameF, 1, 0, 3, 200, true);// ���á���Ӧ�����ơ��ı����λ�ò���ӵ�������

		setupComponet(new JLabel("��ַ��"), 0, 1, 1, 1, false);// ���á���ַ����ǩ��λ�ò���ӵ�������
		GysAddressF = new JTextField();// ����ַ���ı���
		setupComponet(GysAddressF, 1, 1, 1, 100, true);// ���á���ַ���ı����λ�ò���ӵ�������

		setupComponet(new JLabel("���䣺"), 2, 1, 1, 1, false);// ���á����䡱��ǩ��λ�ò���ӵ�������
		GysMailF = new JTextField();// �����䡱�ı���
		GysMailF.addKeyListener(new InputKeyListener());// Ϊ�����䡱�ı�����Ӽ��������¼��ļ���
		setupComponet(GysMailF, 3, 1, 1, 100, true);// ���á����䡱�ı����λ�ò���ӵ�������

		setupComponet(new JLabel("�绰��"), 0, 2, 1, 1, false);// ���á��绰����ǩ��λ�ò���ӵ�������
		GysTelF = new JTextField();// ���绰���ı���
		setupComponet(GysTelF, 1, 2, 1, 0, true);// ���á��绰���ı����λ�ò���ӵ�������

		setupComponet(new JLabel("�����˻���"), 2, 2, 1, 1, false);// ���á������˻�����ǩ��λ�ò���ӵ�������
		GysBatF = new JTextField();// �������˻����ı���
		GysBatF.addKeyListener(new InputKeyListener());// Ϊ�������˻����ı�����Ӽ��������¼��ļ���
		setupComponet(GysBatF, 3, 2, 1, 0, true);// ���á������˻����ı����λ�ò���ӵ�������

		setupComponet(new JLabel("��˰�ţ�"), 0, 3, 1, 1, false);// ���á���˰�š���ǩ��λ�ò���ӵ�������
		GysTaxF = new JTextField();// ����˰�š��ı���
		GysTaxF.addKeyListener(new InputKeyListener());// Ϊ����˰�š��ı�����Ӽ��������¼��ļ���
		setupComponet(GysTaxF, 1, 3, 3, 200, true);// ���á���˰�š��ı����λ�ò���ӵ�������

		final JButton tjButton = new JButton();// ����ӡ���ť
		tjButton.addActionListener(new ActionListener() {// ����ӡ���ť�����¼��ļ���
			public void actionPerformed(final ActionEvent e) {
				// �ı���Ϊ��ʱ��������ʾ��
				if(GysNameF.getText().equals("")) {
					JOptionPane.showMessageDialog(GysTianJiaPanel.this, "��Ӧ������Ϊ��");
					return ;
				}
				if(GysAddressF.getText().equals("")) {
					JOptionPane.showMessageDialog(GysTianJiaPanel.this, "��Ӧ�̵�ַΪ��");
					return ;
				}
				if(GysMailF.getText().equals("")) {
					JOptionPane.showMessageDialog(GysTianJiaPanel.this, "��Ӧ������Ϊ��");
					return ;
				}
				if(GysTelF.getText().equals("")) {
					JOptionPane.showMessageDialog(GysTianJiaPanel.this, "��Ӧ�̵绰Ϊ��");
					return ;
				}
				if(GysBatF.getText().equals("")) {
					JOptionPane.showMessageDialog(GysTianJiaPanel.this, "��Ӧ�������˻�Ϊ��");
					return ;
				}
				if ( GysTaxF.getText().equals("")) {
					JOptionPane.showMessageDialog(GysTianJiaPanel.this, "��Ӧ����˰��Ϊ��");
					return;
				}

				// ִ��SQL��ѯ����õĽ����
				ResultSet haveUser = Dao.query("select * from tb_gysinfo where name='" + GysNameF.getText().trim() + "'");
				try {
					if (haveUser.next()) {// �����haveUser���г���һ���ļ�¼
						System.out.println("error");// ����̨���error
						JOptionPane.showMessageDialog(GysTianJiaPanel.this, "��Ӧ����Ϣ���ʧ�ܣ�����ͬ����Ӧ��", "��Ӧ�������Ϣ",
								JOptionPane.INFORMATION_MESSAGE);// ������ʾ��
						return;
					}
				} catch (Exception er) {
					er.printStackTrace();
				}
				ResultSet set = Dao.query("select max(id) from tb_gysinfo");// ִ��SQL��ѯ����õĽ����
				String id = null;// ������Ӧ�̱��
				try {
					if (set != null && set.next()) {// �����set��Ϊ���ҽ����set���г���һ���ļ�¼
						String sid = set.getString(1).trim();// ��ý����set�еĵ�һ������ֵ
						if (sid == null)// ��һ������ֵΪ��
							id = "gys1001";// Ϊ��Ʒ��Ÿ�ֵ
						else {
							String str = sid.substring(3);// ������Ϊ3����ʼ��ȡ�ַ���
							id = "gys" + (Integer.parseInt(str) + 1);// ����ƴ���ַ�����ò�Ʒ���
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				TbGysinfo gysInfo = new TbGysinfo();// ��Ӧ����Ϣ
				gysInfo.setId(id);// ���ù�Ӧ�̱��
				gysInfo.setName(GysNameF.getText().trim());// ���ù�Ӧ������
				gysInfo.setGysaddress(GysAddressF.getText().trim());// ���õ�ַ
				gysInfo.setGysmail(GysMailF.getText().trim());// ��������
				gysInfo.setGystel(GysTelF.getText().trim());// ���õ绰
				gysInfo.setGysbat(GysBatF.getText().trim());// ���ù�Ӧ�������˻�
				gysInfo.setGystax(GysTaxF.getText().trim());// ������˰��
				Dao.addGys(gysInfo);// ��ӹ�Ӧ����Ϣ
				JOptionPane.showMessageDialog(GysTianJiaPanel.this, "�ѳɹ���ӿͻ�", "�ͻ������Ϣ",
						JOptionPane.INFORMATION_MESSAGE);// ������ʾ��
				resetButton.doClick();// �����á���ťִ�е���¼�
			}
		});
		tjButton.setText("���");// ����ӡ���ť
		setupComponet(tjButton, 1, 6, 1, 0, false);// ���á���ӡ���ť��λ�ò���ӵ�������

		resetButton = new JButton();// �����á���ť
		setupComponet(resetButton, 3, 6, 1, 0, false);// ���á����á���ť��λ�ò���ӵ�������
		resetButton.addActionListener(new ActionListener() {// �����á���ť�����¼��ļ���
			public void actionPerformed(final ActionEvent e) {
				// �����ı��������Ϊ��
				GysNameF.setText("");
				GysAddressF.setText("");
				GysMailF.setText("");
				GysTelF.setText("");
				GysBatF.setText("");
				GysTaxF.setText("");
			}
		});
		resetButton.setText("����");// ���á����á���ť�е��ı�����
	}
	
	

	private void setupComponet(JComponent component, int gridx, int gridy, int gridwidth, int ipadx, boolean fill) {// �������λ�ò���ӵ�������
		final GridBagConstraints gridBagConstrains = new GridBagConstraints();// �����������ƶ���
		gridBagConstrains.gridx = gridx;// �������λ������ĺ�������Ϊgridx
		gridBagConstrains.gridy = gridy;// �������λ���������������Ϊgridy
		gridBagConstrains.insets = new Insets(5, 1, 3, 1);// ����˴˵ļ��
		if (gridwidth > 1)// ����������������1
			gridBagConstrains.gridwidth = gridwidth;// ����������������Ϊgridwidth
		if (ipadx > 0)// ����������Ĵ�С����0
			gridBagConstrains.ipadx = ipadx;// ��������������Ĵ�С
		if (fill)// ���ռ�ݿհ�����
			gridBagConstrains.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
		add(component, gridBagConstrains);// ������
	}
}