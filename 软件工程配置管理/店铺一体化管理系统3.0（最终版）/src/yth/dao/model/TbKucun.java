package yth.dao.model;

public class TbKucun implements java.io.Serializable {// �����Ϣ��ʵ�����л��ӿڣ�

	private String id;// ��Ʒ���
	private String name;// ��Ʒ����
	private String spcd;// ����
	private String gysname;//��Ӧ��
	private String spdw;// ��Ʒ������λ
	private Double spdj;// ����
	private Integer spsl;// �������

	public TbKucun() {// ȱʡ���캯��
	}

	public TbKucun(String id) {// ��С���캯��(����)
		this.id = id;
	}

	public TbKucun(String id, String spname, String cd, String gys,String dw, Double dj,
			Integer kcsl) {// �������캯��
		this.id = id;
		this.name = spname;
		this.spcd = cd;
		this.gysname = gys;
		this.spdw = dw;
		this.spdj = dj;
		this.spsl = kcsl;
	}
	
	// ʹ��Getters and Setters�����������Ϣ���˽�����Է�װ����
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