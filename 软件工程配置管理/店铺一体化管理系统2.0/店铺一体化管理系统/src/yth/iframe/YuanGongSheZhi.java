package yth.iframe;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import yth.iframe.ygGuanLi.*;

public class YuanGongSheZhi extends JInternalFrame {// �����˹����ڲ�����
	public YuanGongSheZhi() {// �����˹����ڲ�����Ĺ��췽��
		setIconifiable(true);// ����ͼ�껯
		setClosable(true);// ���Թر�
		setBounds(100, 100, 491, 200);// ���þ����˹����ڲ������λ�úͿ��
		setTitle("Ա������");// ���þ����˹����ڲ�����ı���
		JTabbedPane tabPane = new JTabbedPane();// ����ѡ����
		//final TianJiaYg tjPanel = new TianJiaYg();// ��Ӿ��������
		final SetYg setPanel = new SetYg();// ���þ��������
		//tabPane.addTab("���Ա��", null, tjPanel, "���Ա��");// ����Ӿ����������ӵ�ѡ������
		tabPane.addTab("Ա������", null, setPanel, "Ա������");// �����þ����������ӵ�ѡ������
		getContentPane().add(tabPane);// ��ѡ������ӵ������˹����ڲ���������������
		tabPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				setPanel.initTable();// ��ʼ�����þ���������еı��ģ��
			}
		});
		addInternalFrameListener(new InternalFrameAdapter(){
			public void internalFrameActivated(InternalFrameEvent e) {
				super.internalFrameActivated(e);
				setPanel.initTable();//��ʼ����Ʒ�������еĹ�Ӧ������ѡ���
			}
		});
		pack();// �����˹����ڲ������е����������ѡ��С���в���
		setVisible(true);// ʹ�����˹����ڲ�����ɼ�
	}
}