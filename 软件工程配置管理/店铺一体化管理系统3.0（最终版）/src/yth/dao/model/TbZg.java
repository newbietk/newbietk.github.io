package yth.dao.model;

public class TbZg implements java.io.Serializable {
	
	private String id;//ְ�����
	private String name;//ְ������
	private String sex;//ְ���Ա�
	private String age;//ְ������
	private String tel;//ְ���绰
	private String bat;//ְ�������˻�
	private String flag;//�Ƿ���ְ��ְ

	public TbZg() {
		// TODO �Զ����ɵĹ��캯�����
	}
	
	public TbZg(String id) {
		this.id = id;
	}

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getBat() {
		return bat;
	}

	public void setBat(String bat) {
		this.bat = bat;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}
