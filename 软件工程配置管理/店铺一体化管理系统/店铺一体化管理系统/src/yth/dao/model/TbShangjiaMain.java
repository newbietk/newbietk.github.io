package yth.dao.model;

import java.util.HashSet;
import java.util.Set;

public class TbShangjiaMain implements java.io.Serializable {// �������ʵ�����л��ӿڣ�

	private String sjId;// �ϼܱ��
	private String pzs;// Ʒ������
	private String je;// �ܼƽ��
	private String sjdate;// �ϼ�ʱ��
	private String czy;// ����Ա
	private String jsr;// ������
	private Set<TbShangjiaDetail> tabShangjiaDetails = new HashSet<TbShangjiaDetail>(0);// �ϼ���ϸ

	public TbShangjiaMain() {// ȱʡ���캯��
	}

	public TbShangjiaMain(String sjId, String pzs, String je,  String sjdate, String czy,
			String jsr) {// �������캯��
		this.sjId = sjId;
		this.pzs = pzs;
		this.je = je;
		this.sjdate = sjdate;
		this.czy = czy;
		this.jsr = jsr;
	}
	
	// ʹ��Getters and Setters����������������˽�����Է�װ����
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
