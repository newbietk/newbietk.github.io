package yth.dao.model;

public class TbKhinfo implements java.io.Serializable {// �ͻ���Ϣ��ʵ�����л��ӿڣ�

	private String id;// �ͻ����
	private String name;// �ͻ�����
	private String khdj;//�ͻ���Ա�ȼ�
	private String khtel;// �绰
	private String khye; //�ͻ����

	public TbKhinfo() {// ȱʡ���캯��
	}

	public TbKhinfo(String id) {// ��С���캯��(����)
		this.id = id;
	}

	public TbKhinfo(String id, String name,String khdj, String khtel,String khye) {// �������캯��
		this.id = id;
		this.name = name;
		this.khdj = khdj;
		this.khtel = khtel;
		this.khye = khye;
	}
	
	// ʹ��Getters and Setters�������ͻ���Ϣ���˽�����Է�װ����
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
	
	public String getKhdj() {
		return this.khdj;
	}

	public void setKhdj(String khdj) {
		this.khdj = khdj;
	}

	public String getKhTel() {
		return this.khtel;
	}

	public void setKhTel(String khtel) {
		this.khtel = khtel;
	}

	public String getKhye() {
		return this.khye;
	}

	public void setKhye(String khye) {
		this.khye = khye;
	}

}