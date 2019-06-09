package yth.iframe;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.List;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

import yth.*;
import yth.dao.Dao;
import yth.dao.model.*;

public class XiaoShouDan extends JInternalFrame {// ���۵��ڲ�����

	private final JTable table;// ���ģ��
	private final JTextField sellDate = new JTextField();// ������ʱ�䡱�ı���
	private JComboBox jsr = null;// �������ˡ������б�
	private final JComboBox jsfs = new JComboBox();// �����㷽ʽ�������б�
	private final JComboBox khname = new JComboBox();// ���ͻ����ơ������б�
	private final JComboBox hydj = new JComboBox(); //����Ա�ȼ��������б�
	private final JTextField sellId = new JTextField();// ��������š��ı���
	private final JTextField sl = new JTextField("0");// ��Ʒ���������ı���
	private final JTextField dj = new JTextField("0");// ����Ʒ�������ı���
	private final JTextField hjje = new JTextField("0");// �����۽��ı���
	private final JTextField czy = new JTextField();// ������Ա���ı���
	private Date xssjDate;// ���������ڡ�
	private JComboBox sp;// ����Ʒ�������б�

	public XiaoShouDan() {// ���۵��ڲ�����Ĺ��췽��
		super();// ���ø���JInternalFrame�Ĺ�����
		setMaximizable(true);// �������
		setIconifiable(true);// ����ͼ�껯
		setClosable(true);// ���Թر����۵��ڲ�����
		getContentPane().setLayout(new GridBagLayout());// �������۵��ڲ�����Ĳ���Ϊ���񲼾�
		setTitle("���ۼ�¼");// �������۵��ڲ�����ı���
		setBounds(50, 50, 700, 400);// �������۵��ڲ������λ�úͿ��
		// ��������š���ǩ�͡�������š��ı���
		setupComponet(new JLabel("������ţ�"), 0, 0, 1, 0, false);
		sellId.setFocusable(false);
		setupComponet(sellId, 1, 0, 1, 140, true);
		// ���ͻ����ơ���ǩ�͡��ͻ����ơ������б�
		setupComponet(new JLabel("�ͻ����ƣ�"), 2, 0, 1, 0, false);
		khname.setPreferredSize(new Dimension(160, 21));
		khname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doKhSelectAction();// ���ͻ����ơ������б��ѡ���¼�
			}
		});
		setupComponet(khname, 3, 0, 1, 1, true);
	    // ����Ա�ȼ�����ǩ�͡���Ա�ȼ��������б�
		setupComponet(new JLabel("��Ա�ȼ���"), 4, 0, 1, 0, false);
		hydj.addItem("һ��");
		hydj.addItem("����");
		hydj.addItem("����");
		hydj.setEditable(true);
		setupComponet(hydj, 5, 0, 1, 0, true);
		// �����㷽ʽ����ǩ�͡����㷽ʽ�������б�
		setupComponet(new JLabel("���㷽ʽ��"), 0, 1, 1, 0, false);
		jsfs.addItem("�ֽ�");
		jsfs.addItem("֧Ʊ");
		jsfs.setEditable(true);
		setupComponet(jsfs, 1, 1, 1, 1, true);
		// ������ʱ�䡱��ǩ�͡�����ʱ�䡱�ı���
		setupComponet(new JLabel("����ʱ�䣺"), 2, 1, 1, 0, false);
		sellDate.setFocusable(false);
		setupComponet(sellDate, 3, 1, 1, 1, true);
		// �������ˡ���ǩ�͡������ˡ������б�
		setupComponet(new JLabel("�����ˣ�"), 4, 1, 1, 0, false);
		setupComponet(getJsrComboBox(), 5, 1, 1, 1, true);
		// ����Ʒ�������б�
		sp = new JComboBox();
		sp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TbSpinfo info = (TbSpinfo) sp.getSelectedItem();
				if (info != null && info.getId() != null) {
					updateTable();// ���ѡ����Ч�͸��±��
				}
			}
		});
		// ���ģ��
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// ���Զ������еĿ�ȣ�ʹ�ù�����
		initTable();
		// ����¼����Ʒ����������Ʒ�������ϼƽ��ļ���
		table.addContainerListener(new computeInfo());
		JScrollPane scrollPanel = new JScrollPane(table);
		scrollPanel.setPreferredSize(new Dimension(380, 200));
		setupComponet(scrollPanel, 0, 2, 6, 1, true);
		// ����Ʒ��������ǩ�͡���Ʒ�������ı���
		setupComponet(new JLabel("��Ʒ������"), 0, 3, 1, 0, false);
		sl.setFocusable(false);
		setupComponet(sl, 1, 3, 1, 1, true);
		// ����Ʒ���ۡ���ǩ�͡���Ʒ���ۡ��ı���
		setupComponet(new JLabel("��Ʒ���ۣ�"), 2, 3, 1, 0, false);
		dj.setFocusable(false);
		setupComponet(dj, 3, 3, 1, 1, true);
		// �����۽���ǩ�͡����۽��ı���
		setupComponet(new JLabel("���۽�"), 4, 3, 1, 0, false);
		hjje.setFocusable(false);
		setupComponet(hjje, 5, 3, 1, 1, true);

		// ����ӡ���ť
		JButton tjButton = new JButton("���");
		tjButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ��ʼ��Ʊ��
				initPiaoHao();
				// ���������û�б�д�ĵ�Ԫ
				stopTableCellEditing();
				// �������л��������У������������
				for (int i = 0; i < table.getRowCount(); i++) {
					TbSpinfo info = (TbSpinfo) table.getValueAt(i, 0);
					if (table.getValueAt(i, 0) == null)
						return;
				}
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Vector());
			}
		});
		setupComponet(tjButton, 1, 4, 1, 1, false);
		
		// �����ۡ���ť
		JButton sellButton = new JButton("����");
		sellButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopTableCellEditing();// ���������û�б�д�ĵ�Ԫ
				clearEmptyRow();// �������
				String slStr = sl.getText();// ��Ʒ����
				String djStr = dj.getText();// Ʒ����
				String jeStr = hjje.getText();// �ϼƽ��
				String jsfsStr = jsfs.getSelectedItem().toString();// ���㷽ʽ
				String jsrStr = jsr.getSelectedItem() + "";// ������
				String czyStr = czy.getText();// ����Ա
				String rkDate = xssjDate.toLocaleString();// ����ʱ��
				String id = sellId.getText();// �������
				String kehuName = khname.getSelectedItem().toString();// ��Ӧ������
				if (jsrStr == null || jsrStr.isEmpty()) {
					JOptionPane.showMessageDialog(XiaoShouDan.this, "����д������");
					return;
				}
			
				if (table.getRowCount() <= 0) {
					JOptionPane.showMessageDialog(XiaoShouDan.this, "���������Ʒ");
					return;
				}
				TbSellMain sellMain = new TbSellMain(id, slStr, jeStr,djStr, kehuName, rkDate, czyStr, jsrStr);// ��������
				Set<TbSellDetail> set = sellMain.getTbSellDetails();// ���������ϸ�ļ���
				int rows = table.getRowCount();
				for (int i = 0; i < rows; i++) {
					TbSpinfo spinfo = (TbSpinfo) table.getValueAt(i, 0);
					String djStr1 = (String) table.getValueAt(i, 6);
					String slStr1 = (String) table.getValueAt(i, 7);
					Double dj = Double.valueOf(djStr1);
					Integer sl = Integer.valueOf(slStr);
					TbSellDetail detail = new TbSellDetail();// ������ϸ
					detail.setSpid(spinfo.getId());// ��ˮ��
					detail.setTbSellMain(sellMain.getSellId());// ��������
					detail.setDj(dj);// ���۵���
					detail.setSl(sl);// ��������
					set.add(detail);// ��������ϸ��ӵ�������ϸ�ļ�����
				}
				boolean rs = Dao.insertSellInfo(sellMain);// ���������Ϣ
				if (rs) {
					JOptionPane.showMessageDialog(XiaoShouDan.this, "�������");
					DefaultTableModel dftm = new DefaultTableModel();
					table.setModel(dftm);
					initTable();
					sl.setText("0");
					dj.setText("0");
					hjje.setText("0");
				}
			}
		});
		setupComponet(sellButton, 3, 4, 1, 1, false);
		// ��Ӵ������������ɳ�ʼ��
		addInternalFrameListener(new initTasks());
	}
	// �������ˡ������б�
	private JComboBox getJsrComboBox() {
		if (jsr == null) {
			jsr = new JComboBox();
			List<List> czyList = Dao.getYgs();
			for (List<String> list : czyList) {
				String id = list.get(0);
				String name = list.get(1);
				Item item = new Item(id, name);
				item.setId(id + "");
				item.setName(name);
				jsr.addItem(item);
			}
		}
		return jsr;
	}

	// ��ʼ�����
	private void initTable() {
		String[] columnNames = { "��Ʒ����", "��Ʒ���", "��Ӧ��", "����", "������λ", "����", "����" };
		((DefaultTableModel) table.getModel()).setColumnIdentifiers(columnNames);
		TableColumn column = table.getColumnModel().getColumn(0);
		final DefaultCellEditor editor = new DefaultCellEditor(sp);
		editor.setClickCountToStart(2);
		column.setCellEditor(editor);
	}

	// ��ʼ����Ʒ�����б�
	private void initSpBox() {
		List list = new ArrayList();
		ResultSet set = Dao.query(" select * from tbspinfo" + " where id in (select id from tbkucun where spsl>0)");
		sp.removeAllItems();
		sp.addItem(new TbSpinfo());
		for (int i = 0; table != null && i < table.getRowCount(); i++) {
			TbSpinfo tmpInfo = (TbSpinfo) table.getValueAt(i, 0);
			if (tmpInfo != null && tmpInfo.getId() != null)
				list.add(tmpInfo.getId());
		}
		try {
			while (set.next()) {
				TbSpinfo spinfo = new TbSpinfo();
				spinfo.setId(set.getString("id").trim());
				// ���������Դ���ͬ����Ʒ����Ʒ�������оͲ��ٰ�������Ʒ
				if (list.contains(spinfo.getId()))
					continue;
				spinfo.setName(set.getString("name").trim());
				spinfo.setSpcd(set.getString("spcd").trim());
				spinfo.setSpdw(set.getString("spdw").trim());
				spinfo.setSpdj(set.getString("spdj").trim());
				spinfo.setSpsl(set.getString("spsl").trim());
				spinfo.setGysname(set.getString("gysname").trim());
				sp.addItem(spinfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// �������λ�ò���ӵ�������
	private void setupComponet(JComponent component, int gridx, int gridy, int gridwidth, int ipadx, boolean fill) {
		final GridBagConstraints gridBagConstrains = new GridBagConstraints();
		gridBagConstrains.gridx = gridx;
		gridBagConstrains.gridy = gridy;
		if (gridwidth > 1)
			gridBagConstrains.gridwidth = gridwidth;
		if (ipadx > 0)
			gridBagConstrains.ipadx = ipadx;
		gridBagConstrains.insets = new Insets(5, 1, 3, 1);
		if (fill)
			gridBagConstrains.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(component, gridBagConstrains);
	}

	// ��Ӧ��ѡ��ʱ������ϵ���ֶ�
	private void doKhSelectAction() {
		Item item = (Item) khname.getSelectedItem();
		TbKhinfo khInfo = Dao.getKhInfo(item);
		//khname.setText(khInfo.getKhname());
	}

	// ����Ʒ����������Ʒ�������ϼƽ��
	private final class computeInfo implements ContainerListener {
		public void componentRemoved(ContainerEvent e) {
			// �������
			clearEmptyRow();
			// �������
			int rows = table.getRowCount();
			int count = 0;
			double money = 0.0;
			// ����Ʒ������
			TbSpinfo column = null;
			if (rows > 0)
				column = (TbSpinfo) table.getValueAt(rows - 1, 0);
			if (rows > 0 && (column == null || column.getId().isEmpty()))
				rows--;
			// �����Ʒ�����ͽ��
			for (int i = 0; i < rows; i++) {
				String column7 = (String) table.getValueAt(i, 7);
				String column6 = (String) table.getValueAt(i, 6);
				int c7 = (column7 == null || column7.isEmpty()) ? 0 : Integer.valueOf(column7);
				Double c6 = (column6 == null || column6.isEmpty()) ? 0 : Double.valueOf(column6);
				count += c7;
				money += c6 * c7;
			}
			sl.setText(rows + "");
			dj.setText(count + "");
			hjje.setText(money + "");
		}

		public void componentAdded(ContainerEvent e) {
		}
	}

	// ����ĳ�ʼ������
	private final class initTasks extends InternalFrameAdapter {
		public void internalFrameActivated(InternalFrameEvent e) {
			super.internalFrameActivated(e);
			initTimeField();
			initKehuField();
			initPiaoHao();
			initSpBox();
		}
		// ��ʼ���ͻ��ֶ�
		private void initKehuField() {
			List gysInfos = Dao.getKhInfos();
			for (Iterator iter = gysInfos.iterator(); iter.hasNext();) {
				List list = (List) iter.next();
				Item item = new Item();
				item.setId(list.get(0).toString().trim());
				item.setName(list.get(1).toString().trim());
				khname.addItem(item);
			}
			doKhSelectAction();
		}
		// ��������ʱ���߳�
		private void initTimeField() {
			new Thread(new Runnable() {
				public void run() {
					try {
						while (true) {
							xssjDate = new Date();
							sellDate.setText(xssjDate.toLocaleString());
							Thread.sleep(100);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}
	// ��ʼ��������Ʊ�š�
	private void initPiaoHao() {
		java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
		String maxId = Dao.getSellMainMaxId(date);
		sellId.setText(maxId);
	}

	// ������Ʒ�����б����±��ǰ�е�����
	private synchronized void updateTable() {
		TbSpinfo spinfo = (TbSpinfo) sp.getSelectedItem();
		Item item = new Item();
		item.setId(spinfo.getId());
		TbKucun kucun = Dao.getKucun(item);
		int row = table.getSelectedRow();
		if (row >= 0 && spinfo != null) {
			table.setValueAt(spinfo.getId(), row, 1);
			table.setValueAt(spinfo.getGysname(), row, 2);
			table.setValueAt(spinfo.getSpcd(), row, 4);
			table.setValueAt(spinfo.getSpdw(), row, 5);
			table.setValueAt(spinfo.getSpdj(), row, 6);
			table.setValueAt(kucun.getSpsl() + "", row, 8);
			table.editCellAt(row, 7);
		}
	}
	
	// �������
	private synchronized void clearEmptyRow() {
		DefaultTableModel dftm = (DefaultTableModel) table.getModel();
		for (int i = 0; i < table.getRowCount(); i++) {
			TbSpinfo info2 = (TbSpinfo) table.getValueAt(i, 0);
			if (info2 == null || info2.getId() == null || info2.getId().isEmpty()) {
				dftm.removeRow(i);
			}
		}
	}

	// ֹͣ���Ԫ�ı༭
	private void stopTableCellEditing() {
		TableCellEditor cellEditor = table.getCellEditor();
		if (cellEditor != null)
			cellEditor.stopCellEditing();
	}
}
