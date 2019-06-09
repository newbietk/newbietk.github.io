package yth.iframe.spGuanLi;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

import yth.dao.Dao;
import yth.dao.model.*;

import yth.Item;

public class SpShanChu extends JPanel{
	private JComboBox sp;//��ѡ����Ʒ�������б�
	private JTextField mingCheng;//����Ʒ���ơ��ı���
	private JTextField danJia;//����Ʒ���ۡ��ı���
	private JTextField shuLiang;//����Ʒ�������ı���
	private JTextField danWei;// ����λ���ı���
	private JTextField chanDi;// �����ء��ı���
	private JComboBox gysMingCheng;// ����Ӧ�����ơ������б�
	private JButton delButton;//"�޸�"��ť

	public SpShanChu(){
		setLayout(new GridBagLayout());// ������Ʒ�޸��ڲ�����Ĳ���Ϊ���񲼾�
		setBounds(10,10,550,400);//������Ʒ�޸��ڲ������λ������

		setupComponet(new JLabel("ѡ����Ʒ"), 0, 0, 1, 0, false);// ���á�ѡ����Ʒ����ǩ��λ�ò���ӵ�������
		sp = new JComboBox();// ��ѡ����Ʒ�������б�
		sp.setPreferredSize(new Dimension(230, 21));// ���á�ѡ����Ʒ�������б�Ŀ��
		sp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doSpSelectAction();// ��ѡ����Ʒ�������б����¼��ļ���
			}
		});
		setupComponet(sp, 1, 0, 2, 0, true);// ���á�ѡ����Ʒ�������б��λ�ò���ӵ�������

		setupComponet(new JLabel("��Ʒ���ƣ�"), 0, 1, 1, 1, false);// ���á���Ʒ���ơ���ǩ��λ�ò���ӵ�������
		mingCheng = new JTextField();// ����Ʒ���ơ��ı���
		mingCheng.setEditable(false);// ���á���Ʒ���ơ��ı��򲻿ɱ༭
		setupComponet(mingCheng, 1, 1, 3, 1, true);// ���á���Ʒ���ơ��ı����λ�ò���ӵ�������

		setupComponet(new JLabel("���أ�"), 0, 2, 1, 1, false);// ���á����ء���ǩ��λ�ò���ӵ�������
		chanDi = new JTextField();// �����ء��ı���
		setupComponet(chanDi, 1, 2, 3, 10, true);// ���á����ء��ı����λ�ò���ӵ�������

		setupComponet(new JLabel("��λ��"), 0, 3, 1, 1, false);// ���á���λ����ǩ��λ�ò���ӵ�������
		danWei = new JTextField();// ����λ���ı���
		setupComponet(danWei, 1, 3, 1, 300, true);// ���á���λ���ı����λ�ò���ӵ�������

		setupComponet(new JLabel("���ۣ�"), 0, 4, 1, 1, false);// ���á����ۡ���ǩ��λ�ò���ӵ�������
		danJia = new JTextField();// �����ۡ��ı���
		setupComponet(danJia, 1, 4, 3, 130, true);// ���á����ۡ��ı����λ�ò���ӵ�������

		setupComponet(new JLabel("������"), 0, 5, 1, 1, false);// ���á����ۡ���ǩ��λ�ò���ӵ�������
		shuLiang = new JTextField();// �����ۡ��ı���
		setupComponet(shuLiang, 1, 5, 3, 1, true);// ���á����ۡ��ı����λ�ò���ӵ�������
		
		setupComponet(new JLabel("��Ӧ��ȫ�ƣ�"), 0, 6, 1, 1, false);// ���á���Ӧ�����ơ���ǩ��λ�ò���ӵ�������
		gysMingCheng = new JComboBox();// ����Ӧ�����ơ������б�
		gysMingCheng.setMaximumRowCount(5);// ���á���Ӧ�����ơ������б���ʾ���������
		setupComponet(gysMingCheng, 1, 6, 3, 1, true);// ���á���Ӧ�����ơ������б��λ�ò���ӵ�������

		delButton = new JButton("ɾ��");// ��ɾ������ť
		JPanel panel = new JPanel();
		panel.add(delButton);
		setupComponet(panel,1,7,1,0,false);

		delButton.addActionListener(new ActionListener() {// ��ɾ������ť�����¼��ļ���
			public void actionPerformed(ActionEvent e) {
				Item item = (Item) sp.getSelectedItem();// ������ݱ��������
				if (item == null || !(item instanceof Item))// ���ݱ��������Ϊ�ջ����ݱ�������������ݱ������ʵ��
					return;// �˳�����
				int confirm = JOptionPane.showConfirmDialog(SpShanChu.this, "ȷ��ɾ����Ʒ��Ϣ��");// ������ȷ��ɾ����Ʒ��Ϣ�𣿡���ʾ��
				if (confirm == JOptionPane.YES_OPTION) {// �����ȷ�ϡ���
					int rs = Dao.delete("delete from tb_spinfo where id='" + item.getId() + "'");// ���ɾ����Ʒ��Ϣ������
					if (rs > 0) {// ɾ����Ʒ��Ϣ����������0
						JOptionPane.showMessageDialog(SpShanChu.this, "��Ʒ��" + item.getName() + "��ɾ���ɹ�");// ������ʾ��
						sp.removeItem(item);// �Ƴ���ѡ����Ʒ�������б�����ƥ������ݱ��������
					}
				}
			}
		});

	}

	public void initComboBox() {// ��ʼ����Ʒ����ѡ���
		List khInfo = Dao.getSpInfos();// ��ȡ��Ʒ��Ϣ
		List<Item> items = new ArrayList<Item>();// �������ݹ�����ļ���
		sp.removeAllItems();// �Ƴ������б������е���Ʒ����
		for (Iterator iter = khInfo.iterator(); iter.hasNext();) {// ����list����
			List element = (List) iter.next();// ��ü�������һ��Ԫ��
			Item item = new Item();// �������ݱ��������
			item.setId(element.get(0).toString().trim());// ���ñ������
			item.setName(element.get(1).toString().trim());// ����������Ϣ
			if (items.contains(item))// �����а������ݱ��������
				continue;// ��������ѭ��
			items.add(item);// �����в��������ݱ���������򼯺���������ݱ��������
			sp.addItem(item);// �������б���������ݱ��������
		}
		doSpSelectAction();// ��ѡ����Ʒ�������б����¼��ļ���
	}

	public void initGysBox() {// ��ʼ����Ӧ�������б�
		List gysInfo = Dao.getGysInfos();// ��ȡ��Ӧ����Ϣ
		List<Item> items = new ArrayList<Item>();// �������ݹ�����ļ���
		gysMingCheng.removeAllItems();// �Ƴ������б������еĹ�Ӧ��ȫ��
		for (Iterator iter = gysInfo.iterator(); iter.hasNext();) {// ����list����
			List element = (List) iter.next();// ��ü�������һ��Ԫ��
			Item item = new Item();// �������ݱ��������
			item.setId(element.get(0).toString().trim());// ���ñ������
			item.setName(element.get(1).toString().trim());// ����������Ϣ
			if (items.contains(item))// �����а������ݱ��������
				continue;// ��������ѭ��
			items.add(item);// �����в��������ݱ�������������������ݱ��������
			gysMingCheng.addItem(item);// �������б���������ݱ��������
		}
		doSpSelectAction();// ��ѡ����Ʒ�������б����¼��ļ���
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

	private void doSpSelectAction() {// ��ѡ����Ʒ�������б����¼��ļ���
		Item selectedItem;// ��ѡ����Ʒ�������б��е�ѡ��
		if (!(sp.getSelectedItem() instanceof Item)) {// ��ѡ����Ʒ�������б��е�ѡ������ݹ������һ��ʵ��
			return;// �˳�Ӧ�ó���
		}
		selectedItem = (Item) sp.getSelectedItem();// ��á�ѡ����Ʒ�������б��е�ѡ��
		TbSpinfo spInfo = Dao.getSpInfo(selectedItem);// ��Ʒ��Ϣ
		if (!spInfo.getId().isEmpty()) {// ��Ʒ��Ų�Ϊ��
			mingCheng.setText(spInfo.getName());// ���á���Ʒ���ơ��ı����е��ı�����
			//spid.setText(spInfo.getId());// ���á���װ���ı����е��ı�����
			chanDi.setText(spInfo.getSpcd());// ���á����ء��ı����е��ı�����
			danWei.setText(spInfo.getSpdw());// ���á���λ���ı����е��ı�����
			danJia.setText(spInfo.getSpdj());// ���á����ۡ��ı����е��ı�����
			shuLiang.setText(spInfo.getSpsl());// ���á��������ı����е��ı�����
			//beiZhu.setText(spInfo.getMemo());// ���á���ע���ı����е��ı�����
			//piHao.setText(spInfo.getPh());// ���á����š��ı����е��ı�����
			//wenHao.setText(spInfo.getPzwh());// ���á���׼�ĺš��ı����е��ı�����
			
			Item item = new Item();// ���ݱ�����
			item.setId(null);// ���ñ������Ϊ��
			item.setName(spInfo.getGysname());// ����������ϢΪ����Ӧ�����ơ�
			TbGysinfo gysInfo = Dao.getGysInfo(item);// ��ù�Ӧ����Ϣ
			item.setId(gysInfo.getId());// ���ñ������Ϊ��Ӧ�̱��
			item.setName(gysInfo.getName());// ����������ϢΪ����Ӧ�����ơ�
			for (int i = 0; i < gysMingCheng.getItemCount(); i++) {// ��������Ӧ��ȫ�ơ������б��е�ѡ��
				Item gys = (Item) gysMingCheng.getItemAt(i);// ��á���Ӧ��ȫ�ơ������б�ĵ�ǰѡ����
				if (gys.getName().equals(item.getName())) {// ��Ӧ��������ͬ
					item = gys;// Ϊ���ݱ������е�ʵ����ֵ
				}
			}
			gysMingCheng.setSelectedItem(item);// ���á���Ӧ��ȫ�ơ������б�ĵ�ǰѡ����
		}
	}

}