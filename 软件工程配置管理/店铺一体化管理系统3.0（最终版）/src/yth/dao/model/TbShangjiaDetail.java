package yth.dao.model;

public class TbShangjiaDetail implements java.io.Serializable {// �����ϸ��ʵ�����л��ӿڣ�

	private String id;// ��ˮ��
	private String tbSpinfo;// ��Ʒ��Ϣ
	private String tbShangjiaMain;// �ϼ�����
	private Double dj;// ����
	private Integer sl;// ����

	public TbShangjiaDetail() {// ȱʡ���캯��
	}

	public TbShangjiaDetail(String tbSpinfo, String tbShangjiaMain, Double dj, Integer sl) {// �������캯��
		this.tbSpinfo = tbSpinfo;
		this.tbShangjiaMain = tbShangjiaMain;
		this.dj = dj;
		this.sl = sl;
	}

	// ʹ��Getters and Setters�����������ϸ���˽�����Է�װ����
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