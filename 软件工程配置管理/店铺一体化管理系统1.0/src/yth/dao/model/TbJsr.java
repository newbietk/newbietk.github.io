package yth.dao.model;

public class TbJsr {// ְ����Ϣ
    private String num;//ְ�����
	private String name;// ְ������
	private String sex;// ְ���Ա�
	private String age;// ְ������
	private String tel;// ְ���绰
	private String bat;//ְ�������˻�
    private String flag;//�Ƿ���ְ��ְ
	
	// ʹ��Getters and Setters��������������Ϣ���˽�����Է�װ����
    public String getNum() {
    	return num;
    }
    
    public void setNum(String num) {
    	this.num = num;
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

	public void setSex(String username) {
		this.sex = username;
	}
	
	public String getAge() {
		return this.age;
	}

	public void setAge(String pass) {
		this.age = pass;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String quan) {
		this.tel = quan;
	}
	
	public String getBat() {
		return this.bat;
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