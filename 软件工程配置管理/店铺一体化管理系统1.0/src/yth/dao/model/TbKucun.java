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

	public TbKucun(String id, String name, String spcd, String gysname,String spdw, Double spdj,
			Integer spsl) {// 完整构造函数
		this.id = id;
		this.name = name;
		this.spcd = spcd;
		this.gysname = gysname;
		this.spdw = spdw;
		this.spdj = spdj;
		this.spsl = spsl;
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

	public void setName(String name) {
		this.name = name;
	}

	public String getGysname() {
		return this.gysname;
	}

	public void setGysname(String gysname) {
		this.gysname = gysname;
	}

	public String getSpcd() {
		return this.spcd;
	}

	public void setSpcd(String spcd) {
		this.spcd = spcd;
	}

	public String getSpdw() {
		return this.spdw;
	}

	public void setSpdw(String spdw) {
		this.spdw = spdw;
	}

	public Double getSpdj() {
		return this.spdj;
	}

	public void setSpdj(Double spdj) {
		this.spdj = spdj;
	}

	public Integer getSpsl() {
		return this.spsl;
	}

	public void setSpsl(Integer spsl) {
		this.spsl = spsl;
	}

	public String toString() {
		return getName();
	}
}