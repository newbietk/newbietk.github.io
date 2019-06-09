package yth.dao.model;

import java.util.HashSet;
import java.util.Set;

public class TbSellMain implements java.io.Serializable {// 销售主表（实现序列化接口）

	private String sellId;// 订单编号
	private String khname;// 客户名称
	private String hydj; //会员等级
	private String je;// 销售金额
	private String xsdate;// 销售日期
	private String jsr;// 经手人
	private String czy; //操作员
	private String jsfs;// 结算方式
	private Set tbSellDetails = new HashSet(0);// 销售明细

	public TbSellMain() {// 缺省构造函数
	}
	
	public TbSellMain(String sellId,String khname,String hydj, String je, String xsdate, 
			String jsr,String czy, String jsfs) {// 完整构造函数
		this.sellId = sellId;
		this.khname = khname;
		this.hydj = hydj;
		this.je = je;
		this.xsdate = xsdate;
		this.jsr = jsr;
		this.czy = czy;
		this.jsfs = jsfs;
		this.tbSellDetails = tbSellDetails;
	}

	// 使用Getters and Setters方法将销售主表类的私有属性封装起来
	public String getSellId() {
		return this.sellId;
	}

	public void setSellId(String sellId) {
		this.sellId = sellId;
	}
	
	public String getKhname() {
		return this.khname;
	}
	
	public void setKhname(String khname) {
		this.khname = khname;
	}

	public String getHyDj() {
		return this.hydj;
	}

	public void setHyDj(String hydj) {
		this.hydj = hydj;
	}

	public String getJe() {
		return this.je;
	}

	public void setJe(String je) {
		this.je = je;
	}

	public String getXsdate() {
		return this.xsdate;
	}

	public void setXsdate(String xsdate) {
		this.xsdate = xsdate;
	}

	public String getJsr() {
		return this.jsr;
	}

	public void setJsr(String jsr) {
		this.jsr = jsr;
	}
	
    public String getCzy() {
    	return this.czy;
    }
    
    public void setCzy(String czy) {
    	this.czy = czy;
    }
    
	public String getJsfs() {
		return this.jsfs;
	}

	public void setJsfs(String jsfs) {
		this.jsfs = jsfs;
	}

	public Set getTbSellDetails() {
		return this.tbSellDetails;
	}

	public void setTbSellDetails(Set tbSellDetails) {
		this.tbSellDetails = tbSellDetails;
	}
}