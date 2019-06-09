package yth.iframe.spGuanLi;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import yth.Item;
import yth.dao.Dao;
import yth.dao.model.TbSpinfo;

public class SpTianJia extends JPanel {// ��Ʒ������
	
    
	private JComboBox gysQuanCheng;// ����Ӧ��ȫ�ơ������б�
	private JTextField danJia;// �����ۡ��ı���
	private JTextField shuLiang;// ���������ı���
	private JTextField danWei;// ����λ���ı���
	private JTextField chanDi;// �����ء��ı���
	private JTextField quanCheng;// ����Ʒ���ơ��ı���
	private JButton resetButton;// �����á���ť

	public SpTianJia() {// ��Ʒ������
		//setTitle("��Ʒ���"); //���ô��ڱ���
		//setIconifiable(true);// ���ù�Ӧ�̹��������ͼ�껯
		//setClosable(true);// ���ÿ��Թرչ�Ӧ�̹�����
		setLayout(new GridBagLayout());// ������Ʒ������Ĳ���Ϊ���񲼾�
		setBounds(10, 10, 550, 400);// ������Ʒ�������λ������
		setupComponent(new JLabel("��Ʒ���ƣ�"), 0, 0, 1, 1, false);// ���á���Ʒ���ơ���ǩ��λ�ò���ӵ�������
		quanCheng = new JTextField();// ����Ʒ���ơ��ı���
		setupComponent(quanCheng, 1, 0, 3, 1, true);// ���á���Ʒ���ơ��ı����λ�ò���ӵ�������
		
		setupComponent(new JLabel("���أ�"), 0, 2, 1, 1, false);// ���á����ء���ǩ��λ�ò���ӵ�������
		chanDi = new JTextField();// �����ء��ı���
		setupComponent(chanDi, 1, 2, 3, 300, true);// ���á����ء��ı����λ�ò���ӵ�������
		setupComponent(new JLabel("��λ��"), 0, 3, 1, 1, false);// ���á���λ����ǩ��λ�ò���ӵ�������
		danWei = new JTextField();// ����λ���ı���
		setupComponent(danWei, 1, 3, 1, 130, true);// ���á���λ���ı����λ�ò���ӵ�������
		
		setupComponent(new JLabel("���ۣ�"), 2, 3, 1, 1, false);// ���á����ۡ���ǩ��λ�ò���ӵ�������
		danJia = new JTextField();// �����ۡ��ı���
		setupComponent(danJia, 3, 3, 1, 1, true);// ���á����ۡ��ı����λ�ò���ӵ�������
		
		setupComponent(new JLabel("������"), 0, 4, 1, 1, false);// ���á���������ǩ��λ�ò���ӵ�������
		shuLiang = new JTextField();// ���������ı���
		setupComponent(shuLiang, 1, 4, 1, 1, true);// ���á��������ı����λ�ò���ӵ�������
		
		setupComponent(new JLabel("��Ӧ��ȫ�ƣ�"), 0, 6, 1, 1, false);// ���á���Ӧ��ȫ�ơ���ǩ��λ�ò���ӵ�������
		gysQuanCheng = new JComboBox();// ����Ӧ��ȫ�ơ������б�
		gysQuanCheng.setMaximumRowCount(5);// ���á���Ӧ��ȫ�ơ������б���ʾ���������
		setupComponent(gysQuanCheng, 1, 6, 3, 1, true);// ���á���Ӧ��ȫ�ơ������б��λ�ò���ӵ�������
		
	
		final JButton tjButton = new JButton();// ����ӡ���ť
		tjButton.addActionListener(new ActionListener() {// Ϊ����ӡ���ť��Ӷ����¼��ļ���
			public void actionPerformed(final ActionEvent e) {
				// �ı���Ϊ��ʱ��������ʾ��
				if (chanDi.getText().equals("") || danWei.getText().equals("")
						|| danJia.getText().equals("") || shuLiang.getText().equals("") ||
						quanCheng.getText().equals("")) {
					JOptionPane.showMessageDialog(SpTianJia.this, "�����δ��д����Ϣ��", "��Ʒ���",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				// ִ��SQL��ѯ����õĽ����
				ResultSet haveUser = Dao.query("select * from tbspinfo where spname='" + quanCheng.getText().trim() + "'");
				try {
					if (haveUser.next()) {// �����haveUser���г���һ���ļ�¼
						System.out.println("error");// ����̨���error
						JOptionPane.showMessageDialog(SpTianJia.this, "��Ʒ��Ϣ���ʧ�ܣ�����ͬ����Ʒ", "�ͻ������Ϣ",
								JOptionPane.INFORMATION_MESSAGE);// ������ʾ��
						return;
					}
				} catch (Exception er) {
					er.printStackTrace();
				}
				ResultSet set = Dao.query("select max(spid) from tbspinfo");// ִ��SQL��ѯ����õĽ����
				String spid = null;// ������Ʒ���
				try {
					if (set != null && set.next()) {// �����set��Ϊ���ҽ����set���г���һ���ļ�¼
						String sid = set.getString(1);// ��ý����set�еĵ�һ������ֵ
						if (sid == null)// ��һ������ֵΪ��
							spid = "sp1001";// Ϊ��Ʒ��Ÿ�ֵ
						else {
							String str = sid.substring(2);// ������Ϊ2����ʼ��ȡ�ַ���
							spid = "sp" + (Integer.parseInt(str) + 1);// ����ƴ���ַ�����ò�Ʒ���
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				TbSpinfo spInfo = new TbSpinfo();// ��Ʒ��Ϣ
				spInfo.setId(spid);// ������Ʒ���
				spInfo.setSpcd(chanDi.getText().trim());// ���ò���
				spInfo.setSpdw(danWei.getText().trim());// ������Ʒ������λ
				spInfo.setSpdj(danJia.getText().trim());// ������Ʒ����
				spInfo.setSpsl(shuLiang.getText().trim()); // ������Ʒ����
				spInfo.setGysname(gysQuanCheng.getSelectedItem().toString().trim());// ���ù�Ӧ��ȫ��
				spInfo.setName(quanCheng.getText().trim());// ������Ʒ����
				Dao.addSp(spInfo);// �����Ʒ��Ϣ
				JOptionPane.showMessageDialog(SpTianJia.this, "��Ʒ��Ϣ�Ѿ��ɹ����", "��Ʒ���",
						JOptionPane.INFORMATION_MESSAGE);// ������ʾ��
				resetButton.doClick();// �����á���ťִ�е���¼�
			}
		});
		tjButton.setText("���");// ����ӡ���ť
		setupComponent(tjButton, 1, 8, 1, 1, false);// ���á���ӡ���ť��λ�ò���ӵ�������
		final GridBagConstraints gridBagConstraints_20 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_20.weighty = 1.0;// ����ӡ���ť���������Ȩ����1.0
		gridBagConstraints_20.insets = new Insets(0, 65, 0, 15);// ����ӡ���ť����������˴˵ļ��
		gridBagConstraints_20.gridy = 8;// ����ӡ���ťλ���������������Ϊ8
		gridBagConstraints_20.gridx = 1;// ����ӡ���ťλ������ĺ�������Ϊ1
		resetButton = new JButton();// �����á���ť
		setupComponent(resetButton, 3, 8, 1, 1, false);// ���á����á���ť��λ�ò���ӵ�������
		resetButton.addActionListener(new ActionListener() {// �����á���ť�����¼��ļ���
			public void actionPerformed(final ActionEvent e) {
				// �����ı��������Ϊ��
				chanDi.setText("");
				danWei.setText("");
				danJia.setText("");
				shuLiang.setText("");
				quanCheng.setText("");
			}
		});
		resetButton.setText("����");// ���á����á���ť�е��ı�����
	}
	

	private void setupComponent(JComponent component, int gridx, int gridy, int gridwidth, int ipadx, boolean fill) {// ���������λ�ò���ӵ�������
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

	public void initGysBox() {// ��ʼ����Ӧ������ѡ���
		List gysInfo = Dao.getGysInfos();// ��ȡ��Ӧ����Ϣ
		List<Item> items = new ArrayList<Item>();// �������ݹ�����ļ���
		gysQuanCheng.removeAllItems();// �Ƴ������б������еĹ�Ӧ��ȫ��
		for (Iterator iter = gysInfo.iterator(); iter.hasNext();) {// ����list����
			List element = (List) iter.next();// ��ü�������һ��Ԫ��
			Item item = new Item();// �������ݱ��������
			item.setId(element.get(0).toString().trim());// ���ñ������
			item.setName(element.get(1).toString().trim());// ����������Ϣ
			if (items.contains(item))// �����а������ݱ��������
				continue;// ��������ѭ��
			items.add(item);// �����в��������ݱ�������������������ݱ��������
			gysQuanCheng.addItem(item);// �������б���������ݱ��������
		}
	}
}