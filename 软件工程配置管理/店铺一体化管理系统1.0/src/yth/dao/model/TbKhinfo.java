package yth.dao.model;

public class TbKhinfo implements java.io.Serializable {// 客户信息（实现序列化接口）

	private String id;// 客户编号
	private String name;// 客户名称
	private String khdj;//客户会员等级
	private String khtel;// 电话
	private String khye; //客户余额

	public TbKhinfo() {// 缺省构造函数
	}

	public TbKhinfo(String id) {// 最小构造函数(主键)
		this.id = id;
	}

	public TbKhinfo(String id, String name,String khdj, String khtel,String khye) {// 完整构造函数
		this.id = id;
		this.name = name;
		this.khdj = khdj;
		this.khtel = khtel;
		this.khye = khye;
	}
	
	// 使用Getters and Setters方法将客户信息类的私有属性封装起来
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getKhdj() {
		return this.khdj;
	}

	public void setKhdj(String khdj) {
		this.khdj = khdj;
	}

	public String getKhTel() {
		return this.khtel;
	}

	public void setKhTel(String khtel) {
		this.khtel = khtel;
	}

	public String getKhye() {
		return this.khye;
	}

	public void setKhye(String khye) {
		this.khye = khye;
	}

}