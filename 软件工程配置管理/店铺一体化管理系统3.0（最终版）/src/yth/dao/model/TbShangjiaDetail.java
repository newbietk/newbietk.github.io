package yth.dao.model;

public class TbShangjiaDetail implements java.io.Serializable {// 入库明细（实现序列化接口）

	private String id;// 流水号
	private String tbSpinfo;// 商品信息
	private String tbShangjiaMain;// 上架主表
	private Double dj;// 单价
	private Integer sl;// 数量

	public TbShangjiaDetail() {// 缺省构造函数
	}

	public TbShangjiaDetail(String tbSpinfo, String tbShangjiaMain, Double dj, Integer sl) {// 完整构造函数
		this.tbSpinfo = tbSpinfo;
		this.tbShangjiaMain = tbShangjiaMain;
		this.dj = dj;
		this.sl = sl;
	}

	// 使用Getters and Setters方法将入库明细类的私有属性封装起来
	public String getId() {
		return this.id;
	}

	public void setId(String lsh) {
		this.id = lsh;
	}

	public String getTabSpinfo() {
		return this.tbSpinfo;
	}

	public void setTabSpinfo(String tbSpinfo) {
		this.tbSpinfo = tbSpinfo;
	}

	public String getTabRukuMain() {
		return this.tbShangjiaMain;
	}

	public void setTabShangjiaMain(String tbShangjiaMain) {
		this.tbShangjiaMain = tbShangjiaMain;
	}

	public Double getDj() {
		return this.dj;
	}

	public void setDj(Double dj) {
		this.dj = dj;
	}

	public Integer getSl() {
		return this.sl;
	}

	public void setSl(Integer sl) {
		this.sl = sl;
	}

	public void setTbsjMain(Object shangjiaId) {
		// TODO Auto-generated method stub
		
	}

}