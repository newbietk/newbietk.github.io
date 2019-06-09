package yth.dao.model;

import java.util.HashSet;
import java.util.Set;

public class TbSellMain implements java.io.Serializable {// ��������ʵ�����л��ӿڣ�

	private String sellId;// �������
	private String khname;// �ͻ�����
	private String hydj; //��Ա�ȼ�
	private String je;// ���۽��
	private String xsdate;// ��������
	private String jsr;// ������
	private String czy; //����Ա
	private String jsfs;// ���㷽ʽ
	private Set tbSellDetails = new HashSet(0);// ������ϸ

	public TbSellMain() {// ȱʡ���캯��
	}
	
	public TbSellMain(String sellId,String khname,String hydj, String je, String xsdate, 
			String jsr,String czy, String jsfs) {// �������캯��
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

	// ʹ��Getters and Setters�����������������˽�����Է�װ����
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