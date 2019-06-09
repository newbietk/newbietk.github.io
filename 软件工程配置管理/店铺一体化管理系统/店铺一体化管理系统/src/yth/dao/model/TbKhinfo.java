package yth.dao.model;

public class TbKhinfo implements java.io.Serializable {// 客户信息（实现序列化接口）

	private String id;// 客户编号
	private String name;// 客户名称
	private String khdj;//客户会员等级
	private String khtel;// 电话
	private String khye; //客户余额

	public TbKhinfo() {// 缺省构造函数
	}

	public TbKhinfo(String kh_id) {// 最小构造函数(主键)
		this.id = kh_id;
	}

	public TbKhinfo(String kh_id, String kh_name,String kh_dj, String kh_tel,String kh_ye) {// 完整构造函数
		this.id = kh_id;
		this.name = kh_name;
		this.khdj = kh_dj;
		this.khtel = kh_tel;
		this.khye = kh_ye;
	}

	// 使用Getters and Setters方法将客户信息类的私有属性封装起来
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKhdj() {
		return khdj;
	}

	public void setKhdj(String khdj) {
		this.khdj = khdj;
	}

	public String getKhtel() {
		return khtel;
	}

	public void setKhtel(String khtel) {
		this.khtel = khtel;
	}

	public String getKhye() {
		return khye;
	}

	public void setKhye(String khye) {
		this.khye = khye;
	}

}