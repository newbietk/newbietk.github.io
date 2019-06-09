package yth.iframe.gysGuanLi;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

import keyListener.InputKeyListener;

import yth.Item;
import yth.dao.Dao;
import yth.dao.model.TbGysinfo;

public class GysShanChu extends JInternalFrame {// ��Ӧ���޸����
	
	private JTextField GysNameF;// ����Ӧ�����ơ��ı���
	private JTextField GysAddressF;// ����ַ���ı���
	private JTextField GysMailF;// �����䡱�ı���
	private JTextField GysTelF;// ���绰���ı���
	private JTextField GysBatF;// �������˻����ı���
	private JTextField GysTaxF;// ����˰�š��ı���
	private JComboBox gys;// ��ѡ��Ӧ�̡������б�

	public GysShanChu() {// ��Ӧ���޸����
		setTitle("��Ӧ��ɾ��"); //���ô��ڱ���
		setIconifiable(true);// ���ù�Ӧ�̹��������ͼ�껯
		setClosable(true);// ���ÿ��Թرչ�Ӧ�̹�����
		setLayout(new GridBagLayout());// ���ù�Ӧ���޸����Ĳ���Ϊ���񲼾�
		setBounds(10, 10, 510, 302);// ���ù�Ӧ���޸�����λ�úͿ��

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

		setupComponet(new JLabel("ѡ��Ӧ��"), 0, 7, 1, 0, false);// ���á�ѡ��Ӧ�̡���ǩ��λ�ò���ӵ�������
		gys = new JComboBox();// ��ѡ��Ӧ�̡������б�
		gys.setPreferredSize(new Dimension(230, 21));// ���á�ѡ��Ӧ�̡������б�Ŀ��
		initComboBox();// ��ʼ����ѡ��Ӧ�̡������б�
		gys.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doGysSelectAction();// ��ѡ��Ӧ�̡������б��ѡ���¼�
			}
		});
		setupComponet(gys, 1, 7, 2, 0, true);// ���á�ѡ��Ӧ�̡������б��λ�ò���ӵ�������

		JButton delButton = new JButton("ɾ��");// ��ɾ������ť
		JPanel panel = new JPanel();// ��ť���
		panel.add(delButton);// �ѡ�ɾ������ť�ŵ���ť�����
		setupComponet(panel, 3, 7, 1, 0, false);// ���ð�ť����λ�ò���ӵ�������
		
		delButton.addActionListener(new ActionListener() {// ��ɾ������ť�����¼��ļ���
			public void actionPerformed(ActionEvent e) {
				Item item = (Item) gys.getSelectedItem();// ������ݱ��������
				if (item == null || !(item instanceof Item))// ���ݱ��������Ϊ�ջ����ݱ�������������ݱ������ʵ��
					return;// �˳�����
				int confirm = JOptionPane.showConfirmDialog(GysShanChu.this, "ȷ��ɾ����Ӧ����Ϣ��");// ������ȷ��ɾ����Ӧ����Ϣ�𣿡���ʾ��
				if (confirm == JOptionPane.YES_OPTION) {// �����ȷ�ϡ���
					int rs = Dao.delete("delete from tb_gysinfo where id='" + item.getId() + "'");// ���ɾ����Ӧ����Ϣ������
					if (rs > 0) {// ɾ����Ӧ����Ϣ����������0
						JOptionPane.showMessageDialog(GysShanChu.this, "��Ӧ�̣�" + item.getName() + "��ɾ���ɹ�");// ������ʾ��
						gys.removeItem(item);// �Ƴ���ѡ��Ӧ�̡������б�����ƥ������ݱ��������
					} else {// ɾ����Ӧ����Ϣ������������0
						JOptionPane.showMessageDialog(GysShanChu.this, "�޷�ɾ����Ӧ�̣�" + item.getName() + "��");// ������ʾ��
					}
				}
			}
		});
	}

	public void initComboBox() {// ��ʼ����ѡ��Ӧ�̡������б�
		List gysInfo = Dao.getGysInfos();// ��ȡ��Ӧ����Ϣ
		List<Item> items = new ArrayList<Item>();// �������ݹ�����ļ���
		gys.removeAllItems();// �Ƴ������б������еĹ�Ӧ������
		for (Iterator iter = gysInfo.iterator(); iter.hasNext();) {// ����list����
			List element = (List) iter.next();// ��ü�������һ��Ԫ��
			Item item = new Item();// �������ݱ��������
			item.setId(element.get(0).toString().trim());// ���ñ������
			item.setName(element.get(1).toString().trim());// ����������Ϣ
			if (items.contains(item))// �����а������ݱ��������
				continue;// ��������ѭ��
			items.add(item);// �����в��������ݱ���������򼯺���������ݱ��������
			gys.addItem(item);// �������б���������ݱ��������
		}
		doGysSelectAction();// ��ѡ��Ӧ�̡������б��ѡ���¼�
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
	
	private void doGysSelectAction() {// ��ѡ��Ӧ�̡������б��ѡ���¼�
		Item selectedItem;// ��ѡ��Ӧ�̡������б��е�ѡ��
		if (!(gys.getSelectedItem() instanceof Item)) {// ��ѡ��Ӧ�̡������б��е�ѡ������ݹ������һ��ʵ��
			return;// �˳�Ӧ�ó���
		}
		selectedItem = (Item) gys.getSelectedItem();// ��á�ѡ��Ӧ�̡������б��е�ѡ��
		TbGysinfo gysInfo = Dao.getGysInfo(selectedItem);// ��Ӧ����Ϣ
		GysNameF.setText(gysInfo.getName());// ���á���Ӧ�����Ƴơ��ı����е��ı�����
		GysAddressF.setText(gysInfo.getGysaddress());// ���á���ַ���ı����е��ı�����
		GysMailF.setText(gysInfo.getGysmail());// ���á����䡱�ı����е��ı�����
		GysTelF.setText(gysInfo.getGystel());// ���á��绰���ı����е��ı�����
		GysBatF.setText(gysInfo.getGysbat());// ���á������˻����ı����е��ı�����
		GysTaxF.setText(gysInfo.getGystax());// ���á���˰�š��ı����е��ı�����
	}
}
