package yth.login;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import yth.*;
import yth.dao.*;

public class LoginDialog extends JFrame{
	private static final long serialVersionUID = 1L;
	private LoginPanel loginPanel = null;//登陆面板
	private JLabel jLabel = null;//用户名标签
	private JTextField userField = null;//用户名文本框
	private JLabel jLabel1 = null;//密码标签
	private JPasswordField passwordField = null;//密码文本框
	private JButton loginButton = null;//登陆按钮
	private JButton exitButton = null;//退出按钮
	private static String userStr = null;//用户输入用户名
	private MainFrame mainFrame;//主窗体

	public LoginDialog(){//登陆窗体的构造方法
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			mainFrame = new MainFrame();//实例化主窗体
			initialize();//初始化登陆窗体
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private LoginPanel getLoginPanel(){//初始化loginPanel登陆面板的方法
		if(loginPanel == null){//登陆面板还没有组件
			jLabel = new JLabel();//用户名标签
			jLabel.setBounds(new Rectangle(85,41,56,18));//用户名标签的位置与宽高
			jLabel.setText("用户名：");//用户名标签文本内容
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(86,71,55,18));
			jLabel1.setText("密 码：");
			loginPanel = new LoginPanel();//实例化登陆面板
			loginPanel.setLayout(null);//设置登陆面板的布局为绝对布局
			loginPanel.setBackground(new Color(0xD8DDC7));//设置登陆面板的背景颜色
			loginPanel.add(jLabel,null);//添加用户名标签到登 陆面板
			loginPanel.add(getUserField(),null);//添加用户名文本框到登陆面板
			loginPanel.add(jLabel1,null);
			loginPanel.add(getPasswordField(),null);
			loginPanel.add(getLoginButton(),null);//添加登陆按钮到登陆面板
			loginPanel.add(getExitButton(),null);//添加退出按钮到登陆面板
		}
		return loginPanel;
	}

	private JTextField getUserField(){//初始化用户名文本框
		if(userField == null){//如果用户名文本框没有组件
			userField = new JTextField();//实例化用户名文本框
			userField.setBounds(new Rectangle(142,39,127,22));
		}
		return userField;
	}

	private JPasswordField getPasswordField(){//初始化密码文本框
		if(passwordField == null){//如果密码文本框没有组件
			passwordField = new JPasswordField();
			passwordField.setBounds(new Rectangle(143,69,125,22));
			passwordField.addKeyListener(new KeyAdapter(){//密码文本框添加键盘事件的监听
				public void keyTyped(KeyEvent e){
					if(e.getKeyChar()=='\n'){//按下的键是回车时
						loginButton.doClick();//执行登陆按钮点击事件
					}
				}
			});
		}
		return passwordField;
	}

	private JButton getLoginButton(){//初始化登陆按钮
		if(loginButton == null){
			loginButton = new JButton();
			loginButton.setBounds(new Rectangle(109,114,48,20));
			loginButton.setIcon(new ImageIcon(getClass().getResource("/res/loginButton.jpg")));//设置登陆按钮图标
			loginButton.addActionListener(new ActionListener(){//登陆按钮添加动作事件的监听
				public void actionPerformed(ActionEvent e){
					try{
						userStr = userField.getText();//获得用户名文本框内容
						String passStr = new String(passwordField.getPassword());//获得密码文本框内容
						if(!Dao.checkLogin(userStr,passStr)){//验证用户名和密码失败
							JOptionPane.showMessageDialog(LoginDialog.this,"用户名与密码无法登陆","登陆失败",
								JOptionPane.ERROR_MESSAGE);//登陆失败对话框
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

	private JButton getExitButton(){//初始化退出按钮
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

	private void initialize(){//初始化登陆窗体
		Dimension size = getToolkit().getScreenSize();//获得屏幕尺寸
		setLocation((size.width-296)/2,(size.height-188)/2);//设置登陆窗体尺寸
		setSize(296,188);//设置登陆窗体的宽高
		this.setTitle("系统登陆");
		setContentPane(getLoginPanel());//添加登陆面板到登陆窗体中
	}

	public String getUserStr(){
		return userStr;
	}
}