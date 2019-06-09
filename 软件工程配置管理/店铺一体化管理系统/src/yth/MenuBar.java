package yth;

import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.lang.reflect.*;
import java.net.*;
import java.util.*;

import javax.swing.*;
import javax.swing.event.*;

import yth.iframe.*;
import yth.iframe.gysGuanLi.*;
import yth.iframe.khGuanLi.*;
import yth.iframe.spGuanLi.*;
import yth.iframe.ygGuanLi.*;

public class MenuBar extends JMenuBar{
	
	//进货菜单
	private JMenu jinhuo_Menu = null;
	//进货单 菜单项
	private JMenuItem jinhuodan_Item = null;
	//退货单 菜单项
	private JMenuItem tuihuodan_Item = null;
	
	//供应商菜单
	private JMenu gys_Menu = null;
	// 供应商添加 菜单项， 
	private JMenuItem gystianjia_Item = null;
	// 供应商修改 菜单项
	private JMenuItem gysxiugai_Item = null;
	//供应商删除 菜单项
	private JMenuItem gysshanchu_Item  = null;
	

	//销售管理菜单
	private JMenu xiaoshou_Menu = null;
	//销售单 菜单项， 在销售管理菜单中
	private JMenuItem xiaoshoudan_Item = null;
	//商品销量排行
	private JMenuItem spxlrank_Item = null;
	
	//库存管理菜单
	private JMenu kucun_Menu = null;
	//进货记录 菜单项， 在库存管理菜单中
	private JMenuItem spjinhuoItem = null;
	//商品数量 菜单项，在库存管理菜单中
	private JMenuItem spshuliang_Item = null;
	//出库记录 菜单项， 在库存管理菜单中
	private JMenuItem spchuku_Item = null;
	
	//商品管理菜单
	private JMenu shangpin_Menu = null;
	//商品添加 菜单项，在商品管理菜单中
	private JMenuItem sptianjia_Item = null;
	//商品修改 菜单项，在商品管理菜单中
	private JMenuItem spxiugai_Item = null;
	//商品删除 菜单项，在商品管理菜单中
	private JMenuItem spshanchu_Item = null;
	
	//客户管理菜单
	private JMenu kehu_Menu = null;
	//客户添加菜单项
	private JMenuItem khtianjia_Item = null;
	//客户管理菜单项
	private JMenuItem khshezhi_Item = null;
	
	//快捷查询菜单
	private JMenu kuaijiechaxun_Menu = null;
	//商品查询 菜单项，在快捷查询菜单中
	private JMenuItem spchaxun_Item = null;
	//供应商查询 菜单项，在快捷查询菜单中
	private JMenuItem xschaxun_Item = null;
	
	//员工管理菜单
	private JMenu yuangonggl_Menu = null;
	//添加员工 菜单项
	private JMenuItem tianjiayg_Item = null;
	//员工设置 菜单项
	private JMenuItem ygset_Item = null;
	
	//系统管理菜单
	private JMenu xitong_Menu = null;
	//密码修改 菜单项，在系统管理菜单中
	private JMenuItem mimaxiugai_Item = null;
	//退出系统 菜单项，在系统管理菜单中
	private JMenuItem exit_Item = null;
	
	//容纳内部窗体的桌面面板
	private JDesktopPane desktopPanel = null;
	//内部窗体集合
	private Map<JMenuItem,JInternalFrame> iFrames = null;
	//内部窗体的位置坐标
	private int nextFrameX, nextFrameY;

	//默认构造方法
	private MenuBar(){
	}

	public MenuBar(JDesktopPane desktopPanel){
		super();
		iFrames = new HashMap<JMenuItem, JInternalFrame>();
		this.desktopPanel = desktopPanel;
		initialize();
	}

	//初始化菜单栏界面
	private void initialize(){
		this.setSize(new Dimension(600,24));
		add(getGongyingshang_Menu());
		add(getJinHuo_Menu());
		add(getKucun_Menu());
		add(getShangpin_Menu());
		add(getXiaoshou_Menu());
		add(getYuanGongGL_Menu());
		add(getKuaijiechaxun_Menu());
		add(getXitong_Menu());
	}
	
	//初始化 进货管理 菜单
	private JMenu getJinHuo_Menu(){
		if(jinhuo_Menu == null){
			jinhuo_Menu = new JMenu();
			jinhuo_Menu.setText("进货管理(J)");
			jinhuo_Menu.add(getJinhuodan_Item());
			jinhuo_Menu.add(getTuihuodan_Item());
		}
		return jinhuo_Menu;
	}
	
	//初始化 进货单 菜单项
	private JMenuItem getJinhuodan_Item(){
		if(jinhuodan_Item == null){
			jinhuodan_Item = new JMenuItem();
			jinhuodan_Item.setText("进货单");
			jinhuodan_Item.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					createIFrame(jinhuodan_Item,JinHuoDan_IFrame.class);
				}
			});
		}
		return jinhuodan_Item;
	}
	
	//初始化 退货单 菜单项
	private JMenuItem getTuihuodan_Item(){
		if(tuihuodan_Item == null){
			tuihuodan_Item = new JMenuItem();
			tuihuodan_Item.setText("退货单");
			tuihuodan_Item.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					//createIframe(tuihuodan_Item,TuiHuoDan.class);
				}
			});
		}
		return tuihuodan_Item;
	}
	
	//初始化 供应商管理 菜单
	public JMenu getGongyingshang_Menu(){
		if(gys_Menu == null){
			gys_Menu = new JMenu();
			gys_Menu.setText("供应商管理(G)");
			gys_Menu.setMnemonic(KeyEvent.VK_S);
			gys_Menu.add(getGystianjiaItem());
			gys_Menu.add(getGysxiugaiItem());
			gys_Menu.add(getGysshanchuItem());
		}
		return gys_Menu;
	}
	
	//初始化 供应商添加 菜单
	public JMenuItem getGystianjiaItem(){
		if(gystianjia_Item == null){
			gystianjia_Item = new JMenuItem();
			gystianjia_Item.setText("供应商添加");
			gystianjia_Item.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					createIFrame(gystianjia_Item, GysTianJia.class);
				}
			});
		}
		return gystianjia_Item;
	}
	
	//初始化 供应商修改 菜单项
	public JMenuItem getGysxiugaiItem(){
		if(gysxiugai_Item == null){
			gysxiugai_Item = new JMenuItem();
			gysxiugai_Item.setText("供应商信息修改");
			gysxiugai_Item.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					createIFrame(gysxiugai_Item,GysXiuGai.class);
				}
			});
		}
		return gysxiugai_Item;
	}
	
	//初始化 供应商删除 菜单项
	public JMenuItem getGysshanchuItem(){
		if(gysshanchu_Item == null){
			gysshanchu_Item = new JMenuItem();
			gysshanchu_Item.setText("供应商删除");
			gysshanchu_Item.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					createIFrame(gysshanchu_Item,GysShanChu.class);
				}
			});
		}
		return gysshanchu_Item;
	}

	
	//初始化销售管理菜单 
	public JMenu getXiaoshou_Menu(){
		if(xiaoshou_Menu == null ){
			xiaoshou_Menu = new JMenu();
			xiaoshou_Menu.setText("销售管理(X)");
			xiaoshou_Menu.setMnemonic(KeyEvent.VK_J);
			xiaoshou_Menu.add(getXiaoshoudanItem());
			xiaoshou_Menu.add(getSpxlrankItem());
		}
		return xiaoshou_Menu;
	}

	//初始化 销售单 菜单项
	public JMenuItem getXiaoshoudanItem(){
		if(xiaoshoudan_Item == null){
			xiaoshoudan_Item = new JMenuItem();
			xiaoshoudan_Item.setText("销售单");
			//xiaoshoudan_Item.setIcon(new ImageIcon(getClass().getResource("/res/icon/xiaoshoudan.png")));
			xiaoshoudan_Item.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					createIFrame(xiaoshoudan_Item, XiaoShouDan.class);
				}
			});
		}
		return xiaoshoudan_Item;
	}
	
	//初始化 商品销量排行 菜单项
	public JMenuItem getSpxlrankItem(){
		if(spxlrank_Item == null){
			spxlrank_Item = new JMenuItem();
			spxlrank_Item.setText("销量排行");
			spxlrank_Item.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					createIFrame(spxlrank_Item,XiaoShouPaiHang.class);
				}
			});
		}
		return spxlrank_Item;
	}
		
	
	//初始化 库存管理 菜单
	public JMenu getKucun_Menu(){
		if(kucun_Menu == null){
			kucun_Menu = new JMenu();
			kucun_Menu.setText("库存管理(K)");
			kucun_Menu.setMnemonic(KeyEvent.VK_K);
			kucun_Menu.add(getSpjinhuoItem());
			kucun_Menu.add(getSpshuliangItem());
			kucun_Menu.add(getSpchukuItem());
		}
		return kucun_Menu;
	}
	
	//初始化 入库记录菜单项
	public JMenuItem getSpjinhuoItem(){
		if(spjinhuoItem == null){
			spjinhuoItem = new JMenuItem();
			spjinhuoItem.setText("入库记录");
			//spjinhuoItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/test.png")));
			spjinhuoItem.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					createIFrame(spjinhuoItem,RuKuJiLu_IFrame.class);
				}
			});
		}
		return spjinhuoItem;
	}
	
	//初始化 商品数量 菜单项
	public JMenuItem getSpshuliangItem(){
		if(spshuliang_Item == null){
			spshuliang_Item =new JMenuItem();
			spshuliang_Item.setText("商品数量");
			spshuliang_Item.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e){
					createIFrame(spshuliang_Item,ShangPinShuLiang.class);
				}
			});
		}
		return spshuliang_Item;
	}
	
	//初始化 出库记录 菜单项
	public JMenuItem getSpchukuItem(){
		if(spchuku_Item == null){
			spchuku_Item =new JMenuItem();
			spchuku_Item.setText("出库记录");
			spchuku_Item.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e){
					createIFrame(spchuku_Item,ChuKuJiLu.class);
				}
			});
		}
		return spchuku_Item;
	}
	
	//初始化 商品管理 菜单
	public JMenu getShangpin_Menu(){
		if(shangpin_Menu == null){
			shangpin_Menu = new JMenu();
			shangpin_Menu.setText("商品管理(S)");
			shangpin_Menu.setMnemonic(KeyEvent.VK_S);
			shangpin_Menu.add(getSptianjiaItem());
			shangpin_Menu.add(getSpxiugaiItem());
			shangpin_Menu.add(getSpshanchuItem());
		}
		return shangpin_Menu;
	}
	
	//初始化 商品添加 菜单项
	public JMenuItem getSptianjiaItem(){
		if(sptianjia_Item == null){
			sptianjia_Item = new JMenuItem();
			sptianjia_Item.setText("商品添加");
			sptianjia_Item.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					createIFrame(sptianjia_Item,ShangPinTianJia.class);
				}
			});
		}
		return sptianjia_Item;
	}
	
	//初始化 商品修改 菜单项
	public JMenuItem getSpxiugaiItem(){
		if(spxiugai_Item == null){
			spxiugai_Item = new JMenuItem();
			spxiugai_Item.setText("商品信息修改");
			spxiugai_Item.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					createIFrame(spxiugai_Item,ShangPinXiuGai.class);
				}
			});
		}
		return spxiugai_Item;
	}
	
	//初始化 商品删除 菜单项
	public JMenuItem getSpshanchuItem(){
		if(spshanchu_Item == null){
			spshanchu_Item = new JMenuItem();
			spshanchu_Item.setText("商品删除");
			spshanchu_Item.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					createIFrame(spshanchu_Item,ShangPinShanChu.class);
				}
			});
		}
		return spshanchu_Item;
	}
	
	//初始化快捷查询菜单
	public JMenu getKuaijiechaxun_Menu(){
		if(kuaijiechaxun_Menu == null){
			kuaijiechaxun_Menu = new JMenu();
			kuaijiechaxun_Menu.setText("快捷查询(C)");
			kuaijiechaxun_Menu.setMnemonic(KeyEvent.VK_C);
			kuaijiechaxun_Menu.add(getSpchaxunItem());
			kuaijiechaxun_Menu.add(getXschaxunItem());
		}
		return kuaijiechaxun_Menu;
	}
	
	//初始化 商品查询 菜单项
	public JMenuItem getSpchaxunItem(){
		if(spchaxun_Item == null){
			spchaxun_Item = new JMenuItem();
			spchaxun_Item.setText("商品查询");
			spchaxun_Item.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					createIFrame(spchaxun_Item,ShangPinChaXun.class);
				}
			});
		}
		return spchaxun_Item;
	}
	
	//初始化 销售查询 菜单项
	public JMenuItem getXschaxunItem(){
		if(xschaxun_Item == null){
			xschaxun_Item = new JMenuItem();
			xschaxun_Item.setText("销售查询");
			xschaxun_Item.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					createIFrame(xschaxun_Item,XiaoShouChaXun.class);
				}
			});
		}
		return xschaxun_Item;
	}
	
	//初始化员工管理菜单
	public JMenu getYuanGongGL_Menu(){
		if(yuangonggl_Menu == null){
			yuangonggl_Menu = new JMenu();
			yuangonggl_Menu.setText("员工管理(Y)");
			yuangonggl_Menu.add(getTianjiaygItem());
			yuangonggl_Menu.add(getSetygItem());
		}
		return yuangonggl_Menu;
	}
	
	
	//初始化添加员工 菜单项
	public JMenuItem getTianjiaygItem(){
		if(tianjiayg_Item == null){
			tianjiayg_Item = new JMenuItem();
			tianjiayg_Item.setText("添加员工");
			tianjiayg_Item.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					createIFrame(tianjiayg_Item,TianJiaYg.class);
				}
			});
		}
		return tianjiayg_Item;
	}
	
	//初始化员工设置 菜单项
	public JMenuItem getSetygItem(){
		if(ygset_Item == null){
			ygset_Item = new JMenuItem();
			ygset_Item.setText("员工信息管理");
			//ygset_Item.setIcon(new ImageIcon(getClass().getResource("/res/test.png")));
			ygset_Item.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					createIFrame(ygset_Item,SetYg.class);
				}
			});
		}
		return ygset_Item;
	}
	
	//初始化系统管理菜单
	public JMenu getXitong_Menu(){
		if(xitong_Menu == null){
			xitong_Menu = new JMenu();
			xitong_Menu.setText("系统管理(S)");
			xitong_Menu.add(getMimaxiugaiItem());
			xitong_Menu.add(getTuichuxitongItem());
		}
		return xitong_Menu;
	}
	
	//初始化 密码修改 菜单项
	public JMenuItem getMimaxiugaiItem(){
		if(mimaxiugai_Item == null){
			mimaxiugai_Item = new JMenuItem();
			mimaxiugai_Item.setText("密码修改");
			mimaxiugai_Item.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					createIFrame(mimaxiugai_Item,XiuGaiMiMa.class);
				}
			});
		}
		return mimaxiugai_Item;
	}
	
	//初始化 退出系统 菜单项
	public JMenuItem getTuichuxitongItem(){
		if(exit_Item == null){
			exit_Item = new JMenuItem();
			exit_Item.setText("退出系统");
			exit_Item.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					System.exit(0);;
				}
			});
		}
		return exit_Item;
	}

	//创建内部窗体的方法，该方法使用反射技术获取内部窗体的构造方法，从而创建内部窗体
	private JInternalFrame createIFrame(JMenuItem item, Class clazz){
		Constructor constructor = clazz.getConstructors()[0];
		JInternalFrame iFrame = iFrames.get(item);
		try{
			if(iFrame == null || iFrame.isClosed()){
				iFrame = (JInternalFrame)constructor.newInstance(new Object[]{});
				iFrames.put(item,iFrame);
				iFrame.setFrameIcon(item.getIcon());
				iFrame.setLocation(nextFrameX, nextFrameY);
				int frameH = iFrame.getPreferredSize().height;
				int panelH = iFrame.getContentPane().getPreferredSize().height;
				int fSpacing = frameH - panelH;
				nextFrameX += fSpacing;
				nextFrameY += fSpacing;
				if(nextFrameX + iFrame.getWidth() > desktopPanel.getWidth())
					nextFrameX = 0;
				if(nextFrameY + iFrame.getHeight() > desktopPanel.getHeight())
					nextFrameY = 0;
				desktopPanel.add(iFrame);
				iFrame.setResizable(false);
				iFrame.setMaximizable(false);
				iFrame.setVisible(true);
			}
			iFrame.setSelected(true);

		}catch (Exception e){
			e.printStackTrace();
		}
		return iFrame;
	}
}