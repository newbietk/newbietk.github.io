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

	public TbKucun(String id, String name, String spcd, String gysname,String spdw, Double spdj,
			Integer spsl) {// �������캯��
		this.id = id;
		this.name = name;
		this.spcd = spcd;
		this.gysname = gysname;
		this.spdw = spdw;
		this.spdj = spdj;
		this.spsl = spsl;
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