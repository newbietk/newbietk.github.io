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
	
	//�����˵�
	private JMenu jinhuo_Menu = null;
	//������ �˵���
	private JMenuItem jinhuodan_Item = null;
	//�˻��� �˵���
	private JMenuItem tuihuodan_Item = null;
	
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
	//��Ʒ��������
	private JMenuItem spxlrank_Item = null;
	
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
	//��Ʒ��� �˵������Ʒ����˵���
	private JMenuItem sptianjia_Item = null;
	//��Ʒ�޸� �˵������Ʒ����˵���
	private JMenuItem spxiugai_Item = null;
	//��Ʒɾ�� �˵������Ʒ����˵���
	private JMenuItem spshanchu_Item = null;
	
	//�ͻ�����˵�
	private JMenu kehu_Menu = null;
	//�ͻ���Ӳ˵���
	private JMenuItem khtianjia_Item = null;
	//�ͻ�����˵���
	private JMenuItem khshezhi_Item = null;
	
	//��ݲ�ѯ�˵�
	private JMenu kuaijiechaxun_Menu = null;
	//��Ʒ��ѯ �˵���ڿ�ݲ�ѯ�˵���
	private JMenuItem spchaxun_Item = null;
	//��Ӧ�̲�ѯ �˵���ڿ�ݲ�ѯ�˵���
	private JMenuItem xschaxun_Item = null;
	
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
		add(getJinHuo_Menu());
		add(getKucun_Menu());
		add(getShangpin_Menu());
		add(getXiaoshou_Menu());
		add(getYuanGongGL_Menu());
		add(getKuaijiechaxun_Menu());
		add(getXitong_Menu());
	}
	
	//��ʼ�� �������� �˵�
	private JMenu getJinHuo_Menu(){
		if(jinhuo_Menu == null){
			jinhuo_Menu = new JMenu();
			jinhuo_Menu.setText("��������(J)");
			jinhuo_Menu.add(getJinhuodan_Item());
			jinhuo_Menu.add(getTuihuodan_Item());
		}
		return jinhuo_Menu;
	}
	
	//��ʼ�� ������ �˵���
	private JMenuItem getJinhuodan_Item(){
		if(jinhuodan_Item == null){
			jinhuodan_Item = new JMenuItem();
			jinhuodan_Item.setText("������");
			jinhuodan_Item.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					createIFrame(jinhuodan_Item,JinHuoDan_IFrame.class);
				}
			});
		}
		return jinhuodan_Item;
	}
	
	//��ʼ�� �˻��� �˵���
	private JMenuItem getTuihuodan_Item(){
		if(tuihuodan_Item == null){
			tuihuodan_Item = new JMenuItem();
			tuihuodan_Item.setText("�˻���");
			tuihuodan_Item.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					//createIframe(tuihuodan_Item,TuiHuoDan.class);
				}
			});
		}
		return tuihuodan_Item;
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
			gysxiugai_Item.setText("��Ӧ����Ϣ�޸�");
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
			xiaoshou_Menu.add(getSpxlrankItem());
		}
		return xiaoshou_Menu;
	}

	//��ʼ�� ���۵� �˵���
	public JMenuItem getXiaoshoudanItem(){
		if(xiaoshoudan_Item == null){
			xiaoshoudan_Item = new JMenuItem();
			xiaoshoudan_Item.setText("���۵�");
			//xiaoshoudan_Item.setIcon(new ImageIcon(getClass().getResource("/res/icon/xiaoshoudan.png")));
			xiaoshoudan_Item.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					createIFrame(xiaoshoudan_Item, XiaoShouDan.class);
				}
			});
		}
		return xiaoshoudan_Item;
	}
	
	//��ʼ�� ��Ʒ�������� �˵���
	public JMenuItem getSpxlrankItem(){
		if(spxlrank_Item == null){
			spxlrank_Item = new JMenuItem();
			spxlrank_Item.setText("��������");
			spxlrank_Item.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					createIFrame(spxlrank_Item,XiaoShouPaiHang.class);
				}
			});
		}
		return spxlrank_Item;
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
	
	//��ʼ�� ����¼�˵���
	public JMenuItem getSpjinhuoItem(){
		if(spjinhuoItem == null){
			spjinhuoItem = new JMenuItem();
			spjinhuoItem.setText("����¼");
			//spjinhuoItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/test.png")));
			spjinhuoItem.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					createIFrame(spjinhuoItem,RuKuJiLu_IFrame.class);
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
					createIFrame(spshuliang_Item,ShangPinShuLiang.class);
				}
			});
		}
		return spshuliang_Item;
	}
	
	//��ʼ�� �����¼ �˵���
	public JMenuItem getSpchukuItem(){
		if(spchuku_Item == null){
			spchuku_Item =new JMenuItem();
			spchuku_Item.setText("�����¼");
			spchuku_Item.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e){
					createIFrame(spchuku_Item,ChuKuJiLu.class);
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
			shangpin_Menu.add(getSptianjiaItem());
			shangpin_Menu.add(getSpxiugaiItem());
			shangpin_Menu.add(getSpshanchuItem());
		}
		return shangpin_Menu;
	}
	
	//��ʼ�� ��Ʒ��� �˵���
	public JMenuItem getSptianjiaItem(){
		if(sptianjia_Item == null){
			sptianjia_Item = new JMenuItem();
			sptianjia_Item.setText("��Ʒ���");
			sptianjia_Item.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					createIFrame(sptianjia_Item,ShangPinTianJia.class);
				}
			});
		}
		return sptianjia_Item;
	}
	
	//��ʼ�� ��Ʒ�޸� �˵���
	public JMenuItem getSpxiugaiItem(){
		if(spxiugai_Item == null){
			spxiugai_Item = new JMenuItem();
			spxiugai_Item.setText("��Ʒ��Ϣ�޸�");
			spxiugai_Item.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					createIFrame(spxiugai_Item,ShangPinXiuGai.class);
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
					createIFrame(spshanchu_Item,ShangPinShanChu.class);
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
			ygset_Item.setText("Ա����Ϣ����");
			//ygset_Item.setIcon(new ImageIcon(getClass().getResource("/res/test.png")));
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