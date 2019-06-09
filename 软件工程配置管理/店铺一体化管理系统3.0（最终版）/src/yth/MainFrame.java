package yth;

import static java.awt.BorderLayout.*;
import static javax.swing.border.BevelBorder.*;
import java.awt.*;
import java.util.Date;
import javax.swing.*;

import yth.login.LoginDialog;

public class MainFrame extends JFrame{//主窗体
    private static final long serialVersionUID = 1L;
    private JPanel frameContentPane = null;//内容面板
    private MenuBar frameMenuBar = null;//菜单栏
    //private ToolBar toolBar = null;//工具栏
    private DesktopPanel desktopPane = null;//桌面面板
    //程序主方法，程序运行入口
    public static void main(String [] args){
        JFrame login = new LoginDialog();
        try{
        login.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Thread.sleep(3000);
        }catch (InterruptedException e){
        	
        }
        login.setVisible(true);
    }
    
    //初始化菜单栏的方法
    protected MenuBar getFrameMenuBar(){
        if(frameMenuBar == null){
            frameMenuBar = new MenuBar(getDesktopPane());
        }
        return frameMenuBar;
    }
    //初始化桌面面板的方法
    private DesktopPanel getDesktopPane(){
        if(desktopPane == null){
            desktopPane = new DesktopPanel();//创建桌面面板对象
        }
        return desktopPane;
    }

    public MainFrame(){
        super();
        initialize();
    }

    private void initialize(){
        this.setSize(1000,600);
        this.setJMenuBar(getFrameMenuBar()); //设置菜单栏
        this.setContentPane(getFrameContentPane());
        this.setTitle("店铺一体化管理系统");
    }

    private JPanel getFrameContentPane(){//获得内容面板的方法
        if(frameContentPane ==null){
            frameContentPane = new JPanel();
            frameContentPane.setLayout(new BorderLayout());
            //frameContentPane.add(getJJToolBar(),NORTH);
            frameContentPane.add(getDesktopPane(),CENTER);
        }
        return frameContentPane;
    }
}