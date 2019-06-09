package yth.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import yth.dao.model.TbGysinfo;
import yth.dao.model.TbKhinfo;
import yth.dao.model.TbKucun;
import yth.dao.model.TbRukuDetail;
import yth.dao.model.TbRukuMain;
import yth.dao.model.TbSellDetail;
import yth.dao.model.TbSellMain;
import yth.dao.model.TbShangjiaDetail;
import yth.dao.model.TbShangjiaMain;
import yth.dao.model.TbSpinfo;
import yth.dao.model.TbZg;

import yth.Item;

public class Dao{

	protected static String dbClassName = "com.mysql.jdbc.Driver"; //
	protected static String dbUrl = "jdbc:mysql://127.0.0.1:3306/db_storemanagement";
	protected static String dbUser = "root";
	protected static String dbPwd = "Tangkun123";
	protected static String dbName = "db_storemanagement";
	protected static String second = null;
	protected static Connection conn =null;

	static {
		try{
			if(conn == null){
				Class.forName(dbClassName).newInstance();
				conn = DriverManager.getConnection(dbUrl,dbUser,dbPwd);
			}
		} catch(ClassNotFoundException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "请将MySQL的JDBC驱动包复制到lib文件夹中。");
			System.exit(-1);
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	private Dao(){

	}
	
	// 执行指定查询
	public static ResultSet query(String QueryStr) {
		ResultSet set = findForResultSet(QueryStr);
		return set;
	}

	public static ResultSet findForResultSet(String sql) {
		if (conn == null)
			return null;
		long time = System.currentTimeMillis();
		ResultSet rs = null;
		try {
			Statement stmt = null;
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
			second = ((System.currentTimeMillis() - time) / 1000d) + "";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	//登录验证
	public static boolean checkLogin(String userStr, String passStr)
		throws SQLException{
			ResultSet rs = findForResultSet("select * from tb_admin where id='"
				+ userStr + "' and pd='" + passStr + "'");
			if(rs ==null)
				return false;
			return rs.next();
		}
	
	// 执行删除
	public static int delete(String sql) {
		return update(sql);
	}
	
	//读取所有客户信息
	public static List getKhInfos() {
		List list = findForList("select id,name from tb_khinfo");
		return list;
	}
	
	//读取指定客户信息
	public static TbKhinfo getKhInfo(Item item) {
		String where = "name='" + item.getName() + "'";
		if (item.getId() != null)
			where = "id='" + item.getId() + "'";
		TbKhinfo info = new TbKhinfo();
		ResultSet set = findForResultSet("select * from tb_khinfo where "
				+ where);
		try {
			if (set.next()) {
				info.setId(set.getString("id").trim());
				info.setName(set.getString("name").trim());
				info.setKhdj(set.getString("khdj").trim());
				info.setKhtel(set.getString("khtel").trim());
				info.setKhye(set.getString("khye").trim());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return info;
	}
	
	// 读取指定供应商信息
	public static TbGysinfo getGysInfo(Item item) {
		String where = "name='" + item.getName() + "'";
		if (item.getId() != null)
			where = "id='" + item.getId() + "'";
		TbGysinfo info = new TbGysinfo();
		ResultSet set = findForResultSet("select * from tb_gysinfo where "
				+ where);
		try {
			if (set.next()) {
				info.setId(set.getString("id").trim());
				info.setGysaddress(set.getString("gysaddress").trim());
				info.setGystel(set.getString("gystel").trim());
				info.setGysmail(set.getString("gysmail").trim());
				info.setName(set.getString("name").trim());
				info.setGystax(set.getString("gystax").trim());
				info.setGysbat(set.getString("gysbat").trim());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return info;
	}
	
	// 读取所有供应商信息
	public static List getGysInfos() {
		List list = findForList("select id,name from tb_gysinfo");
		return list;
	}
	
	// 读取员工
	public static TbZg getYg(String name, String age) {
		TbZg user = new TbZg();
		ResultSet rs = findForResultSet("select * from tb_zg where name='"
				+ name + "'");
		try {
			if (rs.next()) {
				user.setName(name);
				user.setAge(rs.getString("age"));
				if (user.getAge().equals(age)) {
					user.setName(rs.getString("name"));
					user.setTel(rs.getString("tel"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
	// 添加员工
	public static int addYg(TbZg yg) {
		String sql = "insert tb_zg values('" + yg.getId() + "','" + yg.getName() + "','"
				+ yg.getSex() + "','" + yg.getAge() + "','" + yg.getTel()
				+ "','" + yg.getBat() + "',1)";
		System.out.println(sql);
		return update(sql);
	}
	
	//获取所有员工
	public static List getYgs() {
		List list = findForList("select * from tb_zg ");
		return list;
	}
	
	//获取客户
	public static TbKhinfo getKh(String name, String khdj) {
		TbKhinfo kh = new TbKhinfo();
		ResultSet rs = findForResultSet("select * from tb_khinfo where name ='"
			+ name + "'");
		try {
			if(rs.next()) {
				kh.setName(name);
				kh.setKhdj(khdj);
				if(kh.getKhdj().equals(khdj)) {
					kh.setName(rs.getString("name"));
				}
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return kh;
	}

	//获取所有客户
	public static List getKhs() {
		List list = findForList("select * from tb_khinfo");
		return list;
	}
	public static List findForList(String sql) {
		List<List> list = new ArrayList<List>();
		ResultSet rs = findForResultSet(sql);
		try {
			ResultSetMetaData metaData = rs.getMetaData();
			int colCount = metaData.getColumnCount();
			while (rs.next()) {
				List<String> row = new ArrayList<String>();
				for (int i = 1; i <= colCount; i++) {
					String str = rs.getString(i);
					if (str != null && !str.isEmpty())
						str = str.trim();
					row.add(str);
				}
				list.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//添加客户
	public static int addKh(TbKhinfo kh){
		String sql = "insert tb_khinfo values('" + kh.getId() + "','" + kh.getName() + "','"
		+ kh.getKhdj() + "','" + kh.getKhtel() + "','" + kh.getKhye() + "')";
		System.out.println(sql);
		return update(sql);
	}
	
	// 修改用户方法
	public static int modifyPassword(String oldPass, String pass) {
		return update("update tb_admin set pd='" + pass + "' where pd='"
				+ oldPass + "'");
	}
	
	//修改库存的方法
	public static int updateKucunDj(TbKucun kcInfo) {
		return update("update tb_kucun set spdj=" + kcInfo.getSpdj()
				+ " where id='" + kcInfo.getId() + "'");
	}
	
	// 添加供应商信息的方法
	public static boolean addGys(TbGysinfo gysInfo) {
		if (gysInfo == null)
			return false;
		return insert("insert tb_gysinfo values('" + gysInfo.getId() + "','"
				+ gysInfo.getName() + "','" + gysInfo.getGysaddress() + "','"
				+ gysInfo.getGysmail() + "','"+ gysInfo.getGystel() + "','" +
				gysInfo.getGysbat() + "','"+ gysInfo.getGystax() +  "')");
	}
	
	//修改供应商信息的方法
	public static int updateGys(TbGysinfo gysInfo) {
		return update("update tb_gysinfo set gysaddress='" + gysInfo.getGysaddress()
				+ "',gysmail='" + gysInfo.getGysmail() + "',gystel='"
				+ gysInfo.getGystel() + "',gysbat='" + gysInfo.getGysbat()
				+ "',gystax='" + gysInfo.getGystax() + "' where id='" + gysInfo.getId() + "'");
	}
	
	// 添加商品
	public static boolean addSp(TbSpinfo spInfo) {
		if (spInfo == null)
			return false;
		return insert("insert tb_spinfo values('" + spInfo.getId() + "','"
				+ spInfo.getName() + "','" 
				+ spInfo.getSpcd() + "','" + spInfo.getSpdw() + "','"
				+ spInfo.getSpdj() + "','" + spInfo.getSpsl() + "','"
				+ spInfo.getGysname() + "')");
	}
	
	//获取入库最大ID
	public static String getRuKuMainMaxId(Date date) {
		return getMainTypeTableMaxId(date, "tb_rukumain", "RK", "rkid");
	}
	
	//在事务中添加入库信息
	public static boolean insertRukuInfo(TbRukuMain ruMain) {
		try {
			boolean autoCommit = conn.getAutoCommit();
			conn.setAutoCommit(false);
			// 添加入库主表记录
			insert("insert into tb_rukumain values('" + ruMain.getRkId()
					+ "','" + ruMain.getPzs() + "'," + ruMain.getJe() + ",'"
					+ ruMain.getYsjl() + "','" + ruMain.getGysname() + "','"
					+ ruMain.getRkdate() + "','" + ruMain.getCzy() + "','"
					+ ruMain.getJsr() + "','" + ruMain.getJsfs() + "')");
			Set<TbRukuDetail> rkDetails = ruMain.getTabRukuDetails();
			for (Iterator<TbRukuDetail> iter = rkDetails.iterator(); iter
					.hasNext();) {
				TbRukuDetail details = iter.next();
				// 添加入库详细表记录
				insert("insert into tb_rukudetail values('" + ruMain.getRkId()
						+ "','" + details.getTabSpinfo() + "',"
						+ details.getDj() + "," + details.getSl() + ")");
				// 添加或修改库存表记录
				Item item = new Item();
				item.setId(details.getTabSpinfo());
				TbSpinfo spInfo = getSpInfo(item);
				if (spInfo.getId() != null && !spInfo.getId().isEmpty()) {
					TbKucun kucun = getKucun(item);
					if (kucun.getId() == null || kucun.getId().isEmpty()) {
						insert("insert into tb_kucun values('" + spInfo.getId()
								+ "','" + spInfo.getName() + "','"
								+ spInfo.getGysname() + "','" + spInfo.getSpcd()
								+ "','"  + spInfo.getSpdw()+ "'," 
								+ details.getDj() + ","+ details.getSl() + ")");
					} else {
						int sl = kucun.getSpsl() + details.getSl();
						update("update tb_kucun set spsl=" + sl + ",spdj="
								+ details.getDj() + " where id='"
								+ kucun.getId() + "'");
					}
				}
			}
			conn.commit();
			conn.setAutoCommit(autoCommit);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	// 更新商品
	public static int updateSp(TbSpinfo spInfo) {
		return update("update tb_spinfo set spcd='" 
				+ spInfo.getSpcd() + "',spdw='" + spInfo.getSpdw() 
				+"',spdw='"+spInfo.getSpdj()+ "',spsl='"+spInfo.getSpsl()+"',gysname='" 
				+ spInfo.getGysname()+ "' where id='" + spInfo.getId() + "'");
	}
	
	// 读取商品信息
	public static TbSpinfo getSpInfo(Item item) {
		String where = "name='" + item.getName() + "'";
		if (item.getId() != null)
			where = "id='" + item.getId() + "'";
		ResultSet rs = findForResultSet("select * from tb_spinfo where "
				+ where);
		TbSpinfo spInfo = new TbSpinfo();
		try {
			if (rs.next()) {
				spInfo.setId(rs.getString("id").trim());
				spInfo.setSpcd(rs.getString("spcd").trim());
				spInfo.setSpdw(rs.getString("spdw").trim());
				spInfo.setSpdj(rs.getString("spdj").trim());
				spInfo.setSpsl(rs.getString("spsl").trim());
				spInfo.setGysname(rs.getString("gysname").trim());
				spInfo.setName(rs.getString("name").trim());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return spInfo;
	}
	
	// 获取所有商品信息
	public static List getSpInfos() {
		List list = findForList("select * from tb_spinfo");
		return list;
	}
	
	//获取上架最大ID
	public static String getShangjiaMainMaxId(Date date) {
		return getMainTypeTableMaxId(date, "tb_shangjiamain", "RT", "sjId");
	}
	
	//获取上架记录
	public static boolean insersjInfo(TbShangjiaMain sjMain) {
		// TODO Auto-generated method stub
		return false;
	}
	
	// 获取销售主表最大ID
	public static String getSellMainMaxId(Date date) {
		return getMainTypeTableMaxId(date, "tb_sellmain", "XS", "sellID");
	}
	
	// 在事务中添加销售信息
	public static boolean insertSellInfo(TbSellMain sellMain) {
		try {
			boolean autoCommit = conn.getAutoCommit();
			conn.setAutoCommit(false);
			// 添加销售主表记录
			insert("insert into tb_sellmain values('" + sellMain.getSellId()
					+ "','" + sellMain.getKhname() + "'," + sellMain.getHyDj()
					+ ",'" + sellMain.getJe() + "','" + sellMain.getXsdate()
					+ "','" + sellMain.getJsr() + "','"  + sellMain.getJsfs()
					+ "')");
			Set<TbSellDetail> rkDetails = sellMain.getTbSellDetails();
			for (Iterator<TbSellDetail> iter = rkDetails.iterator(); iter
					.hasNext();) {
				TbSellDetail details = iter.next();
				// 添加销售详细表记录
				insert("insert into tb_selldetail values('"
						+ sellMain.getSellId() + "','" + details.getSpid()
						+ "'," + details.getDj() + "," + details.getSl() + ")");
				// 修改库存表记录
				Item item = new Item();
				item.setId(details.getSpid());
				TbSpinfo spInfo = getSpInfo(item);
				if (spInfo.getId() != null && !spInfo.getId().isEmpty()) {
					TbKucun kucun = getKucun(item);
					if (kucun.getId() != null && !kucun.getId().isEmpty()) {
						int sl = kucun.getSpsl() - details.getSl();
						update("update tb_kucun set spsl=" + sl + " where id='"
								+ kucun.getId() + "'");
					}
				}
			}
			conn.commit();
			conn.setAutoCommit(autoCommit);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	// 获取各类主表最大ID
	private static String getMainTypeTableMaxId(Date date, String table,
			String idChar, String idName) {
		String dateStr = date.toString().replace("-", "");
		String id = idChar + dateStr;
		String sql = "select max(" + idName + ") from " + table + " where "
				+ idName + " like '" + id + "%'";
		ResultSet set = query(sql);
		String baseId = null;
		try {
			if (set.next())
				baseId = set.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		baseId = baseId == null ? "000" : baseId.substring(baseId.length() - 3);
		int idNum = Integer.parseInt(baseId) + 1;
		id += String.format("%03d", idNum);
		return id;
	}
	
	// 获得库存信息
	public static List getKucunInfos() {
		List list = findForList("select id,name,spdj,spsl from tb_kucun");
		return list;
	}
	
	// 获取库存商品信息
	public static TbKucun getKucun(Item item) {
		String where = "name='" + item.getName() + "'";
		if (item.getId() != null)
			where = "id='" + item.getId() + "'";
		ResultSet rs = findForResultSet("select * from tb_kucun where " + where);
		TbKucun kucun = new TbKucun();
		try {
			if (rs.next()) {
				kucun.setId(rs.getString("id"));
				kucun.setName(rs.getString("name"));
				kucun.setSpcd(rs.getString("spcd"));
				kucun.setSpdj(rs.getDouble("spdj"));
				kucun.setSpdw(rs.getString("spdw"));
				kucun.setGysname(rs.getString("gysname"));
				kucun.setSpsl(rs.getInt("spsl"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kucun;
	}
	
	
	
	// 添加数据
	public static boolean insert(String sql) {
		boolean result = false;
		try {
			Statement stmt = conn.createStatement();
			result = stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
		
	// 更新数据
	public static int update(String sql) {
		int result = 0;
		try {
			Statement stmt = conn.createStatement();
				result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}