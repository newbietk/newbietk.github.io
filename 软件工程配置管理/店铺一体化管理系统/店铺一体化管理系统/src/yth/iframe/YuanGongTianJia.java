package yth.iframe;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import yth.iframe.ygGuanLi.TianJiaYg;

public class YuanGongTianJia extends JInternalFrame{
	public YuanGongTianJia() {
		setIconifiable(true);// ����ͼ�껯
		setClosable(true);// ���Թر�
		setBounds(100, 100, 491, 200);// ���þ����˹����ڲ������λ�úͿ��
		setTitle("Ա������");// ����Ա�������ڲ�����ı���
		JTabbedPane tabPane = new JTabbedPane();// ����ѡ����
		
		final TianJiaYg tjPanel = new TianJiaYg();// �������Ա�����
		tabPane.addTab("���Ա��", null, tjPanel, "���Ա��");// ����Ӿ����������ӵ�ѡ������
		getContentPane().add(tabPane);// ��ѡ������ӵ������˹����ڲ���������������
		addInternalFrameListener(new InternalFrameAdapter(){
			public void internalFrameActivated(InternalFrameEvent e) {
				super.internalFrameActivated(e);
				//tjPanel.initTable();//��ʼ����Ʒ�������еĹ�Ӧ������ѡ���
			}
		});
		pack();// �����˹����ڲ������е����������ѡ��С���в���
		setVisible(true);// ʹ�����˹����ڲ�����ɼ�
	}

}
