package yth;

import static java.awt.BorderLayout.*;
import static javax.swing.border.BevelBorder.*;
import java.awt.*;
import java.util.Date;
import javax.swing.*;

import yth.login.LoginDialog;

public class MainFrame extends JFrame{//������
    private static final long serialVersionUID = 1L;
    private JPanel frameContentPane = null;//�������
    private MenuBar frameMenuBar = null;//�˵���
    //private ToolBar toolBar = null;//������
    private DesktopPanel desktopPane = null;//�������
    //�����������������������
    public static void main(String [] args){
        JFrame login = new LoginDialog();
        try{
        login.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Thread.sleep(3000);
        }catch (InterruptedException e){
        	
        }
        login.setVisible(true);
    }
    
    //��ʼ���˵����ķ���
    protected MenuBar getFrameMenuBar(){
        if(frameMenuBar == null){
            frameMenuBar = new MenuBar(getDesktopPane());
        }
        return frameMenuBar;
    }
    //��ʼ���������ķ���
    private DesktopPanel getDesktopPane(){
        if(desktopPane == null){
            desktopPane = new DesktopPanel();//��������������
        }
        return desktopPane;
    }

    public MainFrame(){
        super();
        initialize();
    }

    private void initialize(){
        this.setSize(1000,600);
        this.setJMenuBar(getFrameMenuBar()); //���ò˵���
        this.setContentPane(getFrameContentPane());
        this.setTitle("����һ�廯����ϵͳ");
    }

    private JPanel getFrameContentPane(){//����������ķ���
        if(frameContentPane ==null){
            frameContentPane = new JPanel();
            frameContentPane.setLayout(new BorderLayout());
            //frameContentPane.add(getJJToolBar(),NORTH);
            frameContentPane.add(getDesktopPane(),CENTER);
        }
        return frameContentPane;
    }
}