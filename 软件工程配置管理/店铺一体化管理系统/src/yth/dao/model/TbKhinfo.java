package yth.dao.model;

public class TbKhinfo implements java.io.Serializable {// �ͻ���Ϣ��ʵ�����л��ӿڣ�

	private String id;// �ͻ����
	private String name;// �ͻ�����
	private String khdj;//�ͻ���Ա�ȼ�
	private String khtel;// �绰
	private String khye; //�ͻ����

	public TbKhinfo() {// ȱʡ���캯��
	}

	public TbKhinfo(String kh_id) {// ��С���캯��(����)
		this.id = kh_id;
	}

	public TbKhinfo(String kh_id, String kh_name,String kh_dj, String kh_tel,String kh_ye) {// �������캯��
		this.id = kh_id;
		this.name = kh_name;
		this.khdj = kh_dj;
		this.khtel = kh_tel;
		this.khye = kh_ye;
	}

	// ʹ��Getters and Setters�������ͻ���Ϣ���˽�����Է�װ����
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKhdj() {
		return khdj;
	}

	public void setKhdj(String khdj) {
		this.khdj = khdj;
	}

	public String getKhtel() {
		return khtel;
	}

	public void setKhtel(String khtel) {
		this.khtel = khtel;
	}

	public String getKhye() {
		return khye;
	}

	public void setKhye(String khye) {
		this.khye = khye;
	}

}