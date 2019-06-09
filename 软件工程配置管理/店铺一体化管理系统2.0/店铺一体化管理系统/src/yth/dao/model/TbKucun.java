package yth.dao.model;

public class TbKucun implements java.io.Serializable {// 库存信息（实现序列化接口）

	private String id;// 商品编号
	private String name;// 商品名称
	private String spcd;// 产地
	private String gysname;//供应商
	private String spdw;// 商品计量单位
	private Double spdj;// 单价
	private Integer spsl;// 库存数量

	public TbKucun() {// 缺省构造函数
	}

	public TbKucun(String id) {// 最小构造函数(主键)
		this.id = id;
	}

	public TbKucun(String id, String spname, String cd, String gys,String dw, Double dj,
			Integer kcsl) {// 完整构造函数
		this.id = id;
		this.name = spname;
		this.spcd = cd;
		this.gysname = gys;
		this.spdw = dw;
		this.spdj = dj;
		this.spsl = kcsl;
	}
	
	// 使用Getters and Setters方法将库存信息类的私有属性封装起来
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String spname) {
		this.name = spname;
	}

	public String getGysname() {
		return this.gysname;
	}

	public void setGysname(String gys) {
		this.gysname = gys;
	}

	public String getSpcd() {
		return this.spcd;
	}

	public void setSpcd(String cd) {
		this.spcd = cd;
	}

	public String getSpdw() {
		return this.spdw;
	}

	public void setSpdw(String dw) {
		this.spdw = dw;
	}

	public Double getSpdj() {
		return this.spdj;
	}

	public void setSpdj(Double dj) {
		this.spdj = dj;
	}

	public Integer getSpsl() {
		return this.spsl;
	}

	public void setSpsl(Integer kcsl) {
		this.spsl = kcsl;
	}

	public String toString() {
		return getName();
	}
}