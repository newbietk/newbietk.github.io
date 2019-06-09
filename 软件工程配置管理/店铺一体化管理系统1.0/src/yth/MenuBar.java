package yth;

import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.lang.reflect.*;
import java.net.*;
import java.util.*;

import javax.swing.*;
import javax.swing.event.*;

import yth.iframe.ShangPinGuanLi;

import yth.iframe.*;
import yth.iframe.gysGuanLi.*;
import yth.iframe.spGuanLi.*;
import yth.iframe.ygGuanLi.*;

public class MenuBar extends JMenuBar{
	
	//��Ӧ�̲˵�
	private JMenu gys_Menu = null;
	// ��Ӧ����� �˵�� 
	private JMenuItem gystianjia_Item = null;
	// ��Ӧ���޸� �˵���
	private JMenuItem gysxiugai_Item = null;
	//��Ӧ��ɾ�� �˵���
	private JMenuItem gysshanchu_Item  = null;
	

	//���۹���˵�
	private JMenu xiaoshou_Menu = null;
	//���۵� �˵�� �����۹���˵���
	private JMenuItem xiaoshoudan_Item = null;
	//�۸���� �˵�������۹���˵���
	private JMenuItem jiagetz_Item = null;
	
	//������˵�
	private JMenu kucun_Menu = null;
	//������¼ �˵�� �ڿ�����˵���
	private JMenuItem spjinhuoItem = null;
	//��Ʒ���� �˵���ڿ�����˵���
	private JMenuItem spshuliang_Item = null;
	//�����¼ �˵�� �ڿ�����˵���
	private JMenuItem spchuku_Item = null;

	//��Ʒ����˵�
	private JMenu shangpin_Menu = null;
	//��Ʒ�б� �˵������Ʒ����˵���
	private JMenuItem splist_Item = null;
	//��Ʒ��� �˵������Ʒ����˵���
	private JMenuItem sptianjia_Item = null;
	//��Ʒ�������
	private JMenuItem shangpin_guanliItem = null;
	//��Ʒ�޸� �˵������Ʒ����˵���
	private JMenuItem spxiugai_Item = null;
	//��Ʒɾ�� �˵������Ʒ����˵���
	private JMenuItem spshanchu_Item = null;
	
	//��ݲ�ѯ�˵�
	private JMenu kuaijiechaxun_Menu = null;
	//��Ʒ��ѯ �˵���ڿ�ݲ�ѯ�˵���
	private JMenuItem spchaxun_Item = null;
	//���۲�ѯ �˵���ڿ�ݲ�ѯ�˵���
	private JMenuItem xschaxun_Item = null;
	
	//�������в˵�
	private JMenu xiaoshourank_Menu = null;
	//��Ʒ��������
	private JMenuItem spxlrank_Item = null;
	
	//Ա������˵�
	private JMenu yuangonggl_Menu = null;
	//���Ա�� �˵���
	private JMenuItem tianjiayg_Item = null;
	//Ա������ �˵���
	private JMenuItem ygset_Item = null;
	
	//ϵͳ����˵�
	private JMenu xitong_Menu = null;
	//�����޸� �˵����ϵͳ����˵���
	private JMenuItem mimaxiugai_Item = null;
	//�˳�ϵͳ �˵����ϵͳ����˵���
	private JMenuItem exit_Item = null;
	
	//�����ڲ�������������
	private JDesktopPane desktopPanel = null;
	//�ڲ����弯��
	private Map<JMenuItem,JInternalFrame> iFrames = null;
	//�ڲ������λ������
	private int nextFrameX, nextFrameY;

	//Ĭ�Ϲ��췽��
	private MenuBar(){
	}

	public MenuBar(JDesktopPane desktopPanel){
		super();
		iFrames = new HashMap<JMenuItem, JInternalFrame>();
		this.desktopPanel = desktopPanel;
		initialize();
	}

	//��ʼ���˵�������
	private void initialize(){
		this.setSize(new Dimension(600,24));
		add(getGongyingshang_Menu());
		add(getXiaoshou_Menu());
		add(getKucun_Menu());
		add(getShangpin_Menu());
		add(getKuaijiechaxun_Menu());
		add(getXiaoshourank_Menu());
		add(getYuanGongGL_Menu());
		add(getXitong_Menu());
	}

	//��ʼ�� ��Ӧ�̹��� �˵�
	public JMenu getGongyingshang_Menu(){
		if(gys_Menu == null){
			gys_Menu = new JMenu();
			gys_Menu.setText("��Ӧ�̹���(G)");
			gys_Menu.setMnemonic(KeyEvent.VK_S);
			gys_Menu.add(getGystianjiaItem());
			gys_Menu.add(getGysxiugaiItem());
			gys_Menu.add(getGysshanchuItem());
		}
		return gys_Menu;
	}
	
	//��ʼ�� ��Ӧ����� �˵�
	public JMenuItem getGystianjiaItem(){
		if(gystianjia_Item == null){
			gystianjia_Item = new JMenuItem();
			gystianjia_Item.setText("��Ӧ�����");
			gystianjia_Item.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					createIFrame(gystianjia_Item, GysTianJia.class);
				}
			});
		}
		return gystianjia_Item;
	}
	
	//��ʼ�� ��Ӧ���޸� �˵���
	public JMenuItem getGysxiugaiItem(){
		if(gysxiugai_Item == null){
			gysxiugai_Item = new JMenuItem();
			gysxiugai_Item.setText("��Ӧ���޸�");
			gysxiugai_Item.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					createIFrame(gysxiugai_Item,GysXiuGai.class);
				}
			});
		}
		return gysxiugai_Item;
	}
	
	//��ʼ�� ��Ӧ��ɾ�� �˵���
	public JMenuItem getGysshanchuItem(){
		if(gysshanchu_Item == null){
			gysshanchu_Item = new JMenuItem();
			gysshanchu_Item.setText("��Ӧ��ɾ��");
			gysshanchu_Item.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					createIFrame(gysshanchu_Item,GysShanChu.class);
				}
			});
		}
		return gysshanchu_Item;
	}

	
	//��ʼ�����۹���˵� 
	public JMenu getXiaoshou_Menu(){
		if(xiaoshou_Menu == null ){
			xiaoshou_Menu = new JMenu();
			xiaoshou_Menu.setText("���۹���(X)");
			xiaoshou_Menu.setMnemonic(KeyEvent.VK_J);
			xiaoshou_Menu.add(getXiaoshoudanItem());
			xiaoshou_Menu.add(getJiagetzItem());
		}
		return xiaoshou_Menu;
	}

	//��ʼ�� ���۵� �˵���
	public JMenuItem getXiaoshoudanItem(){
		if(xiaoshoudan_Item == null){
			xiaoshoudan_Item = new JMenuItem();
			xiaoshoudan_Item.setText("���۵�");
			xiaoshoudan_Item.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					createIFrame(xiaoshoudan_Item, XiaoShouDan.class);
				}
			});
		}
		return xiaoshoudan_Item;
	}
	
	//��ʼ�� �۸���� �˵���
	public JMenuItem getJiagetzItem(){
		if(jiagetz_Item == null){
			jiagetz_Item = new JMenuItem();
			jiagetz_Item.setText("�۸����");
			jiagetz_Item.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					createIFrame(jiagetz_Item,JiaGeTiaoZheng.class);
				}
			});
		}
		return jiagetz_Item;
	}
	
	//��ʼ�� ������ �˵�
	public JMenu getKucun_Menu(){
		if(kucun_Menu == null){
			kucun_Menu = new JMenu();
			kucun_Menu.setText("������(K)");
			kucun_Menu.setMnemonic(KeyEvent.VK_K);
			kucun_Menu.add(getSpjinhuoItem());
			kucun_Menu.add(getSpshuliangItem());
			kucun_Menu.add(getSpchukuItem());
		}
		return kucun_Menu;
	}
	
	//��ʼ�� ������¼�˵���
	public JMenuItem getSpjinhuoItem(){
		if(spjinhuoItem == null){
			spjinhuoItem = new JMenuItem();
			spjinhuoItem.setText("������¼");
			//spjinhuoItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/test.png")));
			spjinhuoItem.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					createIFrame(spjinhuoItem,JinHuoDan_IFrame.class);
				}
			});
		}
		return spjinhuoItem;
	}
	
	//��ʼ�� ��Ʒ���� �˵���
	public JMenuItem getSpshuliangItem(){
		if(spshuliang_Item == null){
			spshuliang_Item =new JMenuItem();
			spshuliang_Item.setText("��Ʒ����");
			spshuliang_Item.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e){
					createIFrame(spshuliang_Item,ShangPingshuLiang.class);
				}
			});
		}
		return spshuliang_Item;
	}
	
	//��ʼ�� �ϼܼ�¼ �˵���
	public JMenuItem getSpchukuItem(){
		if(spchuku_Item == null){
			spchuku_Item =new JMenuItem();
			spchuku_Item.setText("�ϼܼ�¼");
			spchuku_Item.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e){
					createIFrame(spchuku_Item,ShangJiaJiLu.class);
				}
			});
		}
		return spchuku_Item;
	}
	
	//��ʼ�� ��Ʒ���� �˵�
	public JMenu getShangpin_Menu(){
		if(shangpin_Menu == null){
			shangpin_Menu = new JMenu();
			shangpin_Menu.setText("��Ʒ����(S)");
			shangpin_Menu.setMnemonic(KeyEvent.VK_S);
			shangpin_Menu.add(getSplistItem());
			//shangpin_Menu.add(getSptianjiaItem());
			shangpin_Menu.add(getShangpin_guanliItem());
			shangpin_Menu.add(getSpxiugaiItem());
			shangpin_Menu.add(getSpshanchuItem());
		}
		return shangpin_Menu;
	}
	
	//��ʼ�� ��Ʒ�б� �˵�
	public JMenuItem getSplistItem(){
		if(splist_Item == null){
			splist_Item = new JMenuItem();
			splist_Item.setText("��Ʒ�б�");
			splist_Item.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					//createIFrame(splist_Item, SPList.class);
				}
			});
		}
		return splist_Item;
	}
	
	//��ʼ�� ��Ʒ��� �˵���
	/*public JMenuItem getSptianjiaItem(){
		if(sptianjia_Item == null){
			sptianjia_Item = new JMenuItem();
			sptianjia_Item.setText("��Ʒ���");
			sptianjia_Item.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					createIFrame(sptianjia_Item,SpTianJia.class);
				}
			});
		}
		return sptianjia_Item;
	}*/
	
	public JMenuItem getShangpin_guanliItem() {
		if (shangpin_guanliItem == null) {
			shangpin_guanliItem = new JMenuItem();
			shangpin_guanliItem.setText("��Ʒ���Ϲ���");
			shangpin_guanliItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					createIFrame(shangpin_guanliItem, ShangPinGuanLi.class);
				}
			});
		}
		return shangpin_guanliItem;
	}
	//��ʼ�� ��Ʒ�޸� �˵���
	public JMenuItem getSpxiugaiItem(){
		if(spxiugai_Item == null){
			spxiugai_Item = new JMenuItem();
			spxiugai_Item.setText("��Ʒ�޸�");
			spxiugai_Item.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					createIFrame(spxiugai_Item,SpXiuGai.class);
				}
			});
		}
		return spxiugai_Item;
	}
	
	//��ʼ�� ��Ʒɾ�� �˵���
	public JMenuItem getSpshanchuItem(){
		if(spshanchu_Item == null){
			spshanchu_Item = new JMenuItem();
			spshanchu_Item.setText("��Ʒɾ��");
			spshanchu_Item.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					createIFrame(spshanchu_Item,SpShanChu.class);
				}
			});
		}
		return spshanchu_Item;
	}
	
	//��ʼ����ݲ�ѯ�˵�
	public JMenu getKuaijiechaxun_Menu(){
		if(kuaijiechaxun_Menu == null){
			kuaijiechaxun_Menu = new JMenu();
			kuaijiechaxun_Menu.setText("��ݲ�ѯ(C)");
			kuaijiechaxun_Menu.setMnemonic(KeyEvent.VK_C);
			kuaijiechaxun_Menu.add(getSpchaxunItem());
			kuaijiechaxun_Menu.add(getXschaxunItem());
		}
		return kuaijiechaxun_Menu;
	}
	
	//��ʼ�� ��Ʒ��ѯ �˵���
	public JMenuItem getSpchaxunItem(){
		if(spchaxun_Item == null){
			spchaxun_Item = new JMenuItem();
			spchaxun_Item.setText("��Ʒ��ѯ");
			spchaxun_Item.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					createIFrame(spchaxun_Item,ShangPinChaXun.class);
				}
			});
		}
		return spchaxun_Item;
	}
	
	//��ʼ�� ���۲�ѯ �˵���
	public JMenuItem getXschaxunItem(){
		if(xschaxun_Item == null){
			xschaxun_Item = new JMenuItem();
			xschaxun_Item.setText("���۲�ѯ");
			xschaxun_Item.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					createIFrame(xschaxun_Item,XiaoShouChaXun.class);
				}
			});
		}
		return xschaxun_Item;
	}
	
	//��ʼ���������в˵�
	public JMenu getXiaoshourank_Menu(){
		if(xiaoshourank_Menu == null){
			xiaoshourank_Menu = new JMenu();
			xiaoshourank_Menu.setText("��������(R)");
			xiaoshourank_Menu.setMnemonic(KeyEvent.VK_R);
			xiaoshourank_Menu.add(getSpxlrankItem());
		}
		return xiaoshourank_Menu;
	}
	
	//��ʼ�� ��Ʒ�������� �˵���
	public JMenuItem getSpxlrankItem(){
		if(spxlrank_Item == null){
			spxlrank_Item = new JMenuItem();
			spxlrank_Item.setText("��Ʒ��������");
			spxlrank_Item.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					createIFrame(spxlrank_Item,XiaoShouPaiHang.class);
				}
			});
		}
		return spxlrank_Item;
	}
	
	//��ʼ��Ա������˵�
	public JMenu getYuanGongGL_Menu(){
		if(yuangonggl_Menu == null){
			yuangonggl_Menu = new JMenu();
			yuangonggl_Menu.setText("Ա������(Y)");
			yuangonggl_Menu.add(getTianjiaygItem());
			yuangonggl_Menu.add(getSetygItem());
		}
		return yuangonggl_Menu;
	}
	
	
	//��ʼ�����Ա�� �˵���
	public JMenuItem getTianjiaygItem(){
		if(tianjiayg_Item == null){
			tianjiayg_Item = new JMenuItem();
			tianjiayg_Item.setText("���Ա��");
			tianjiayg_Item.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					createIFrame(tianjiayg_Item,TianJiaYg.class);
				}
			});
		}
		return tianjiayg_Item;
	}
	
	//��ʼ��Ա������ �˵���
	public JMenuItem getSetygItem(){
		if(ygset_Item == null){
			ygset_Item = new JMenuItem();
			ygset_Item.setText("Ա������");
			ygset_Item.setIcon(new ImageIcon(getClass().getResource("/res/test.png")));
			ygset_Item.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					createIFrame(ygset_Item,SetYg.class);
				}
			});
		}
		return ygset_Item;
	}
	
	//��ʼ��ϵͳ����˵�
	public JMenu getXitong_Menu(){
		if(xitong_Menu == null){
			xitong_Menu = new JMenu();
			xitong_Menu.setText("ϵͳ����(S)");
			xitong_Menu.add(getMimaxiugaiItem());
			xitong_Menu.add(getTuichuxitongItem());
		}
		return xitong_Menu;
	}
	
	//��ʼ�� �����޸� �˵���
	public JMenuItem getMimaxiugaiItem(){
		if(mimaxiugai_Item == null){
			mimaxiugai_Item = new JMenuItem();
			mimaxiugai_Item.setText("�����޸�");
			mimaxiugai_Item.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					createIFrame(mimaxiugai_Item,XiuGaiMiMa.class);
				}
			});
		}
		return mimaxiugai_Item;
	}
	
	//��ʼ�� �˳�ϵͳ �˵���
	public JMenuItem getTuichuxitongItem(){
		if(exit_Item == null){
			exit_Item = new JMenuItem();
			exit_Item.setText("�˳�ϵͳ");
			exit_Item.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					System.exit(0);;
				}
			});
		}
		return exit_Item;
	}

	//�����ڲ�����ķ������÷���ʹ�÷��似����ȡ�ڲ�����Ĺ��췽�����Ӷ������ڲ�����
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