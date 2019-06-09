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
		setIconifiable(true);// 可以图标化
		setClosable(true);// 可以关闭
		setBounds(100, 100, 491, 200);// 设置经手人管理内部窗体的位置和宽高
		setTitle("员工管理");// 设置员工管理内部窗体的标题
		JTabbedPane tabPane = new JTabbedPane();// 创建选项卡面板
		
		final TianJiaYg tjPanel = new TianJiaYg();// 设置添加员工面板
		tabPane.addTab("添加员工", null, tjPanel, "添加员工");// 把添加经手人面板添加到选项卡面板中
		getContentPane().add(tabPane);// 把选项卡面板添加到经手人管理内部窗体的内容面板中
		addInternalFrameListener(new InternalFrameAdapter(){
			public void internalFrameActivated(InternalFrameEvent e) {
				super.internalFrameActivated(e);
				//tjPanel.initTable();//初始化商品添加面板中的供应商下拉选择框
			}
		});
		pack();// 经手人管理内部窗体中的组件按其首选大小进行布局
		setVisible(true);// 使经手人管理内部窗体可见
	}

}
