package yth.login;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import yth.*;
import yth.dao.*;

public class LoginDialog extends JFrame{
	private static final long serialVersionUID = 1L;
	private LoginPanel loginPanel = null;//��½���
	private JLabel jLabel = null;//�û�����ǩ
	private JTextField userField = null;//�û����ı���
	private JLabel jLabel1 = null;//�����ǩ
	private JPasswordField passwordField = null;//�����ı���
	private JButton loginButton = null;//��½��ť
	private JButton exitButton = null;//�˳���ť
	private static String userStr = null;//�û������û���
	private MainFrame mainFrame;//������

	public LoginDialog(){//��½����Ĺ��췽��
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			mainFrame = new MainFrame();//ʵ����������
			initialize();//��ʼ����½����
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private LoginPanel getLoginPanel(){//��ʼ��loginPanel��½���ķ���
		if(loginPanel == null){//��½��廹û�����
			jLabel = new JLabel();//�û�����ǩ
			jLabel.setBounds(new Rectangle(85,41,56,18));//�û�����ǩ��λ������
			jLabel.setText("�û�����");//�û�����ǩ�ı�����
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(86,71,55,18));
			jLabel1.setText("�� �룺");
			loginPanel = new LoginPanel();//ʵ������½���
			loginPanel.setLayout(null);//���õ�½���Ĳ���Ϊ���Բ���
			loginPanel.setBackground(new Color(0xD8DDC7));//���õ�½���ı�����ɫ
			loginPanel.add(jLabel,null);//����û�����ǩ���� ½���
			loginPanel.add(getUserField(),null);//����û����ı��򵽵�½���
			loginPanel.add(jLabel1,null);
			loginPanel.add(getPasswordField(),null);
			loginPanel.add(getLoginButton(),null);//��ӵ�½��ť����½���
			loginPanel.add(getExitButton(),null);//����˳���ť����½���
		}
		return loginPanel;
	}

	private JTextField getUserField(){//��ʼ���û����ı���
		if(userField == null){//����û����ı���û�����
			userField = new JTextField();//ʵ�����û����ı���
			userField.setBounds(new Rectangle(142,39,127,22));
		}
		return userField;
	}

	private JPasswordField getPasswordField(){//��ʼ�������ı���
		if(passwordField == null){//��������ı���û�����
			passwordField = new JPasswordField();
			passwordField.setBounds(new Rectangle(143,69,125,22));
			passwordField.addKeyListener(new KeyAdapter(){//�����ı�����Ӽ����¼��ļ���
				public void keyTyped(KeyEvent e){
					if(e.getKeyChar()=='\n'){//���µļ��ǻس�ʱ
						loginButton.doClick();//ִ�е�½��ť����¼�
					}
				}
			});
		}
		return passwordField;
	}

	private JButton getLoginButton(){//��ʼ����½��ť
		if(loginButton == null){
			loginButton = new JButton();
			loginButton.setBounds(new Rectangle(109,114,48,20));
			loginButton.setIcon(new ImageIcon(getClass().getResource("/res/loginButton.jpg")));//���õ�½��ťͼ��
			loginButton.addActionListener(new ActionListener(){//��½��ť��Ӷ����¼��ļ���
				public void actionPerformed(ActionEvent e){
					try{
						userStr = userField.getText();//����û����ı�������
						String passStr = new String(passwordField.getPassword());//��������ı�������
						if(!Dao.checkLogin(userStr,passStr)){//��֤�û���������ʧ��
							JOptionPane.showMessageDialog(LoginDialog.this,"�û����������޷���½","��½ʧ��",
								JOptionPane.ERROR_MESSAGE);//��½ʧ�ܶԻ���
							return ;
						}
					}catch(Exception e1){
						e1.printStackTrace();
					}
					mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
					mainFrame.setVisible(true);
					//
					setVisible(false);
				}
			});
		}
		return loginButton;
	}

	private JButton getExitButton(){//��ʼ���˳���ť
		if(exitButton == null){
			exitButton = new JButton();
			exitButton.setBounds(new Rectangle(181,114,48,20));
			exitButton.setIcon(new ImageIcon(getClass().getResource("/res/exitButton.jpg")));
			exitButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					System.exit(0);
				}
			});
		}
		return exitButton;
	}

	private void initialize(){//��ʼ����½����
		Dimension size = getToolkit().getScreenSize();//�����Ļ�ߴ�
		setLocation((size.width-296)/2,(size.height-188)/2);//���õ�½����ߴ�
		setSize(296,188);//���õ�½����Ŀ��
		this.setTitle("ϵͳ��½");
		setContentPane(getLoginPanel());//��ӵ�½��嵽��½������
	}

	public String getUserStr(){
		return userStr;
	}
}