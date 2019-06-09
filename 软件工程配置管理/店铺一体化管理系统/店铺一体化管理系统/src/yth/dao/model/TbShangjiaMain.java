package yth.dao.model;

import java.util.HashSet;
import java.util.Set;

public class TbShangjiaMain implements java.io.Serializable {// 入库主表（实现序列化接口）

	private String sjId;// 上架编号
	private String pzs;// 品种数量
	private String je;// 总计金额
	private String sjdate;// 上架时间
	private String czy;// 操作员
	private String jsr;// 经手人
	private Set<TbShangjiaDetail> tabShangjiaDetails = new HashSet<TbShangjiaDetail>(0);// 上架明细

	public TbShangjiaMain() {// 缺省构造函数
	}

	public TbShangjiaMain(String sjId, String pzs, String je,  String sjdate, String czy,
			String jsr) {// 完整构造函数
		this.sjId = sjId;
		this.pzs = pzs;
		this.je = je;
		this.sjdate = sjdate;
		this.czy = czy;
		this.jsr = jsr;
	}
	
	// 使用Getters and Setters方法将入库主表类的私有属性封装起来
	public String getSjId() {
		return this.sjId;
	}

	public void setSjId(String sjId) {
		this.sjId = sjId;
	}

	public String getPzs() {
		return this.pzs;
	}

	public void setPzs(String pzs) {
		this.pzs = pzs;
	}

	public String getJe() {
		return this.je;
	}

	public void setJe(String je) {
		this.je = je;
	}
	
	public String getSjdate() {
		return this.sjdate;
	}

	public void setSjdate(String sjdate) {
		this.sjdate = sjdate;
	}

	public String getCzy() {
		return this.czy;
	}

	public void setCzy(String czy) {
		this.czy = czy;
	}

	public String getJsr() {
		return this.jsr;
	}

	public void setJsr(String jsr) {
		this.jsr = jsr;
	}


	public Set<TbShangjiaDetail> getTabShangjiaDetails() {
		return this.tabShangjiaDetails;
	}

	public void setTabShangjiaDetails(Set<TbShangjiaDetail> tabShangjiaDetails) {
		this.tabShangjiaDetails = tabShangjiaDetails;
	}
}
