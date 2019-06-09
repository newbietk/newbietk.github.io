package yth.iframe.khGuanLi;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import yth.dao.Dao;
import yth.dao.model.TbKhinfo;

public class TianJiaKh extends JInternalFrame {

	private JTextField id;//
	private JTextField name;//
	private JTextField khdj;//
	private JTextField khtel;//
	private JTextField khye;//

	private void clear() {
		id.setText(null);
		name.setText(null);
		khdj.setText(null);
		khtel.setText(null);
		khye.setText(null);
	}

	public TianJiaKh(){
		super();
		setTitle("��ӿͻ�");
		setIconifiable(true);// ������ӿͻ��������ͼ�껯
		setClosable(true);// ���ÿ��Թرտͻ���Ӵ���
		setLayout(new GridBagLayout());
		setBounds(10,10, 300, 256);

		final JLabel label = new JLabel();//����š���ǩ
		label.setFont(new Font("", Font.PLAIN, 14));//���á���š���ǩ��������ʽ
		label.setText("��ţ�");//���á���š���ǩ�ڵ��ı�����
		final GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;//���λ������ĺ�������Ϊ0
		gridBagConstraints.gridy = 0;//���λ���������������Ϊ0
		add(label, gridBagConstraints);//���������ӡ���š���ǩ

		id = new JTextField();//����š��ı���
		final GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();
		gridBagConstraints_1.weighty = 1.0;
		gridBagConstraints_1.insets = new Insets(0,0,0,10);
		gridBagConstraints_1.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_1.gridwidth = 2;
		gridBagConstraints_1.gridx = 1;
		gridBagConstraints_1.gridy = 0;
		add(id, gridBagConstraints_1);

		final JLabel label_1 = new JLabel();
		label_1.setFont(new Font("",Font.PLAIN,14));
		label_1.setText("������");
		final GridBagConstraints gridBagConstraints_2 = new GridBagConstraints();
		gridBagConstraints_2.gridx = 0;
		gridBagConstraints_2.gridy = 1;
		add(label_1, gridBagConstraints_2);

		name = new JTextField();
		final GridBagConstraints gridBagConstraints_3 = new GridBagConstraints();
		gridBagConstraints_3.weighty = 1.0;
		gridBagConstraints_3.insets = new Insets(0,0,0,10);
		gridBagConstraints_3.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_3.gridwidth = 2;
		gridBagConstraints_3.gridy = 1;
		gridBagConstraints_1.gridx = 1;
		add(name, gridBagConstraints_3);

		final JLabel label_2 = new JLabel();
		label_2.setFont(new Font("", Font.PLAIN,14));
		label_2.setText("��Ա�ȼ���");
		final GridBagConstraints gridBagConstraints_4 = new GridBagConstraints();
		gridBagConstraints_4.gridx = 0;
		gridBagConstraints_4.gridy = 2;
		add(label_2, gridBagConstraints_4);

		khdj = new JTextField();
		final GridBagConstraints gridBagConstraints_5 = new GridBagConstraints();
		gridBagConstraints_5.weighty = 1.0;
		gridBagConstraints_5.insets = new Insets(0,0,0,10);
		gridBagConstraints_5.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_5.gridwidth = 2;
		gridBagConstraints_5.gridx = 1;
		gridBagConstraints_5.gridy = 2;
		add(khdj, gridBagConstraints_5);

		final JLabel label_3 = new JLabel();
		label_3.setFont(new Font("", Font.PLAIN,14));
		label_3.setText("�绰��");
		final GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();
		gridBagConstraints_6.gridx = 0;
		gridBagConstraints_6.gridy = 3;
		add(label_3, gridBagConstraints_6);

		khtel = new JTextField();
		final GridBagConstraints gridBagConstraints_7 = new GridBagConstraints();
		gridBagConstraints_7.weighty = 1.0;
		gridBagConstraints_7.insets = new Insets(0,0,0,10);
		gridBagConstraints_7.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_7.gridwidth = 2;
		gridBagConstraints_7.gridx = 1;
		gridBagConstraints_7.gridy = 3;
		add(khtel, gridBagConstraints_7);

		final JLabel label_4 = new JLabel();
		label_4.setFont(new Font("", Font.PLAIN,14));
		label_4.setText("��");
		final GridBagConstraints gridBagConstraints_8 = new GridBagConstraints();
		gridBagConstraints_8.gridx = 0;
		gridBagConstraints_8.gridy = 4;
		add(label_4, gridBagConstraints_8);

		khye = new JTextField();
		final GridBagConstraints gridBagConstraints_9 = new GridBagConstraints();
		gridBagConstraints_9.weighty = 1.0;
		gridBagConstraints_9.insets = new Insets(0,0,0,10);
		gridBagConstraints_9.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_9.gridwidth = 2;
		gridBagConstraints_9.gridx = 1;
		gridBagConstraints_9.gridy = 4;
		add(khye, gridBagConstraints_9);

		final JButton button = new JButton("���");
		button.addActionListener(new ActionListener(){
			public void actionPerformed(final ActionEvent e){
				String nameStr = name.getText();
				if(nameStr == null || nameStr.isEmpty())
					return;
				String khdjStr = khdj.getText();
				TbKhinfo kehu = Dao.getKh(nameStr,khdjStr);
				if(kehu.getKhtel() != null && !kehu.getKhtel().isEmpty()){
					JOptionPane.showMessageDialog(TianJiaKh.this, "�ͻ�(" + kehu.getName() +")�Ѿ�����");
					return ;
				}
				TbKhinfo kh = new TbKhinfo();
				kh.setId(id.getText());
				kh.setName(name.getText());
				kh.setKhdj(khdj.getText());
				kh.setKhtel(khtel.getText());
				kh.setKhye(khye.getText());
				int i = Dao.addKh(kh);
				if(i > 0)
					JOptionPane.showMessageDialog(TianJiaKh.this, "��ӳɹ�");
				clear();
			}
		});
		final GridBagConstraints gridBagConstraints_10 = new GridBagConstraints();
		gridBagConstraints_10.weighty = 1.0;
		gridBagConstraints_10.anchor = GridBagConstraints.EAST;
		gridBagConstraints_10.gridx = 1;
		gridBagConstraints_10.gridy = 5;
		add(button, gridBagConstraints_10);

		final JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener(){
			public void actionPerformed (final ActionEvent e){
				clear();
			}
		});
		button_1.setText("����");
		final GridBagConstraints gridBagConstraints_11  = new GridBagConstraints();
		gridBagConstraints_11.weighty = 1.0;
		gridBagConstraints_11.gridx = 2;
		gridBagConstraints_11.gridy = 5;
		add(button_1, gridBagConstraints_11);
	}
}