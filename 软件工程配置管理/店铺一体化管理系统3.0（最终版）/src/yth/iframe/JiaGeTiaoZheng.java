package yth.iframe;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.event.*;

import yth.Item;
import yth.dao.Dao;
import yth.dao.model.TbKucun;

public class JiaGeTiaoZheng extends JInternalFrame {// �۸�����ڲ�����

	private TbKucun kcInfo;// �����Ϣ
	private JLabel danwei;// ����񡱱�ǩ
	private JTextField kuCunJinE;// �������ı���
	private JTextField kuCunShuLiang;// ������������ı���
	private JTextField danJia;// �����ۡ��ı���
	private JComboBox shangPinMingCheng;// ����Ʒ���ơ������б�

	private void updateJinE() {// ���Ŀ����ķ���
		Double dj = Double.valueOf(danJia.getText());// �������ۡ��ı����е�����ת��ΪDouble��
		Integer sl = Integer.valueOf(kuCunShuLiang.getText());// ��������������ı����е�����ת��ΪInteger��
		kuCunJinE.setText((dj * sl) + "");// ���ġ������ı����е�����
	}

	public JiaGeTiaoZheng() {// �۸��������Ĺ��췽��
		super();// ���ø���JInternalFrame�Ĺ�����
		addInternalFrameListener(new InternalFrameAdapter() {// ����ڲ�����ļ����¼�
			public void internalFrameActivated(final InternalFrameEvent e) {
				DefaultComboBoxModel mingChengModel = (DefaultComboBoxModel) shangPinMingCheng.getModel();// �����б��Ĭ��ģ��
				mingChengModel.removeAllElements();// ����б�
				List list = Dao.getKucunInfos();// ��ÿ����Ϣ�ļ���
				Iterator iterator = list.iterator();// ����뼯��list��Ӧ�ĵ�����
				while (iterator.hasNext()) {// �������ļ���Ԫ���Ƿ񱻱�����
					List element = (List) iterator.next();// ��ü����е���һ��Ԫ��
					Item item = new Item();// ������ݱ�����
					item.setId((String) element.get(0));// ���ñ������
					item.setName((String) element.get(1));// ����������Ϣ
					mingChengModel.addElement(item);// �����ݱ�����Ķ�����ӵ������б���
				}
			}
		});
		setIconifiable(true);// ���ü۸�����������ͼ�껯
		setClosable(true);// ���ÿ��Թرռ۸��������
		getContentPane().setLayout(new GridBagLayout());// ���ü۸���������������Ĳ���Ϊ���񲼾�
		setTitle("�۸����");// ���ü۸��������ı���
		setBounds(100, 100, 531, 253);// ���ü۸���������λ������
		
		setupComponet(new JLabel("��Ʒ���ƣ�"), 0, 0, 1, 1, false);// ���á���Ʒ���ơ���ǩ��λ�ò���ӵ�������
		shangPinMingCheng = new JComboBox();// ����Ʒ���ơ������б�
		shangPinMingCheng.setPreferredSize(new Dimension(220, 21));// ���á���Ʒ���ơ������б�Ŀ��
		setupComponet(shangPinMingCheng, 1, 0, 1, 1, true);// ���á���Ʒ���ơ������б��λ�ò���ӵ�������
		
		setupComponet(new JLabel("��    λ��"), 2, 0, 1, 0, false);// ���á���λ����ǩ��λ�ò���ӵ�������
		danwei = new JLabel();// ����λ����ǩ
		danwei.setForeground(Color.BLUE);// ���á���񡱱�ǩ�е�������ɫΪ��ɫ
		danwei.setPreferredSize(new Dimension(130, 21));// ���á���񡱱�ǩ�Ŀ��
		setupComponet(danwei, 3, 0, 1, 1, true);// ���á���񡱱�ǩ��λ�ò���ӵ�������
		
		setupComponet(new JLabel("�������أ� "), 0, 1, 1, 0, false);// ���á����ء���ǩ��λ�ò���ӵ�������
		final JLabel chanDi = new JLabel();// �����ء���ǩ
		chanDi.setForeground(Color.BLUE);// ���á����ء���ǩ�е�������ɫΪ��ɫ
		setupComponet(chanDi, 1, 1, 1, 1, true);// ���á����ء���ǩ��λ�ò���ӵ�������
		
		setupComponet(new JLabel("�������ۣ�"), 2, 1, 1, 0, false);// ���á����ۡ���ǩ��λ�ò���ӵ�������
		danJia = new JTextField();// �����ۡ��ı���
		danJia.addKeyListener(new KeyAdapter() {// Ϊ�����ۡ��ı�����Ӽ����¼��ļ���
			public void keyReleased(final KeyEvent e) {
				updateJinE();// ���Ŀ����ķ���
		    }
		});
		setupComponet(danJia, 3, 1, 1, 100, true);// ���á����ۡ��ı����λ�ò���ӵ�������
		
		setupComponet(new JLabel("���������"), 0, 2, 1, 0, false);// ���á������������ǩ��λ�ò���ӵ�������
		kuCunShuLiang = new JTextField();// ������������ı���
		kuCunShuLiang.setEditable(false);// ���á�����������ı��򲻿ɱ༭
		setupComponet(kuCunShuLiang, 1, 2, 1, 1, true);// ���á�����������ı����λ�ò���ӵ�������

		setupComponet(new JLabel("����"), 2, 2, 1, 0, false);// ���á�������ǩ��λ�ò���ӵ�������
		kuCunJinE = new JTextField();// �������ı���
		kuCunJinE.setEditable(false);// ���á������ı��򲻿ɱ༭
		setupComponet(kuCunJinE, 3, 2, 1, 100, true);// ���á������ı����λ�ò���ӵ�������
		
		final JButton okButton = new JButton();// ��ȷ������ť
		okButton.addActionListener(new ActionListener() {// Ϊ��ȷ������ť��Ӷ����¼��ļ���
			public void actionPerformed(final ActionEvent e) {
				kcInfo.setSpdj(Double.valueOf(danJia.getText()));// ���ÿ����Ϣ���еĵ���
				kcInfo.setSpsl(Integer.valueOf(kuCunShuLiang.getText()));// ���ÿ����Ϣ���еĿ������
				int rs = Dao.updateKucunDj(kcInfo);// ����޸Ŀ��ļ�¼����
				if (rs > 0)// �޸Ŀ��ļ�¼��������0
					JOptionPane.showMessageDialog(getContentPane(), "�۸������ϡ�", kcInfo.getName() + "�۸����",
							JOptionPane.QUESTION_MESSAGE);// �������۸������ϡ���ʾ��
			}
		});
		okButton.setText("ȷ��");// ���á�ȷ������ť�е��ı�����
		setupComponet(okButton, 1, 5, 1, 1, false);// ���á�ȷ������ť��λ�ò���ӵ�������

		final JButton closeButton = new JButton();// ���رա���ť
		closeButton.addActionListener(new ActionListener() {// Ϊ���رա���ť��Ӷ����¼��ļ���
			public void actionPerformed(final ActionEvent e) {
				JiaGeTiaoZheng.this.doDefaultCloseAction();// �رռ۸��������
			}
		});
		closeButton.setText("�ر�");// ���á��رա���ť�е��ı�����
		setupComponet(closeButton, 2, 5, 1, 1, false);// ���á��رա���ť��λ�ò���ӵ�������

		shangPinMingCheng.addItemListener(new ItemListener() {// Ϊ����Ʒ���ơ������б����ѡ���¼��ļ���
			public void itemStateChanged(final ItemEvent e) {
				Object selectedItem = shangPinMingCheng.getSelectedItem();// ��á���Ʒ���ơ������б�ѡ�е�ѡ��
				if (selectedItem == null)// ����Ʒ���ơ������б�ѡ�е�ѡ�����
					return;// �˳�Ӧ�ó���
				Item item = (Item) selectedItem;// ������ݱ�����
				kcInfo = Dao.getKucun(item);// ��ȡ�����Ϣ
				if (kcInfo.getId() == null)// �����Ϣ�е���Ʒ��Ų�����
					return;// �˳�Ӧ�ó���
				int dj, sl;// ���������ۡ��������������
				dj = kcInfo.getSpdj().intValue();// Ϊ�����ۡ���ֵ
				sl = kcInfo.getSpsl().intValue();// Ϊ�������������ֵ
				chanDi.setText(kcInfo.getSpcd());// ���á����ء���ǩ����ı�����
				danwei.setText(kcInfo.getSpdw());// ���á���λ����ǩ����ı�����
				danJia.setText(kcInfo.getSpdj() + "");// ���á����ۡ��ı�������ı�����
				kuCunShuLiang.setText(kcInfo.getSpsl() + "");// ���á�����������ı�������ı�����
				kuCunJinE.setText(dj * sl + "");// ���á������ı�������ı�����
			}
		});
	}

	private void setupComponet(JComponent component, int gridx, int gridy, int gridwidth, int ipadx, boolean fill) {// �������λ�ò���ӵ�������
		final GridBagConstraints gridBagConstrains = new GridBagConstraints();// �����������ƶ���
		gridBagConstrains.gridx = gridx;// �������λ������ĺ�������Ϊgridx
		gridBagConstrains.gridy = gridy;// �������λ���������������Ϊgridy
		gridBagConstrains.insets = new Insets(5, 1, 3, 5);// ����˴˵ļ��
		if (gridwidth > 1)// ����������������1
			gridBagConstrains.gridwidth = gridwidth;// ����������������Ϊgridwidth
		if (ipadx > 0)// ����������Ĵ�С����0
			gridBagConstrains.ipadx = ipadx;// ��������������Ĵ�С
		if (fill)// ���ռ�ݿհ�����
			gridBagConstrains.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
		getContentPane().add(component, gridBagConstrains);// ������
	}
}
