package yth.dao.model;

public class TbZg implements java.io.Serializable {
	
	private String id;//职工编号
	private String name;//职工姓名
	private String sex;//职工性别
	private String age;//职工年龄
	private String tel;//职工电话
	private String bat;//职工银行账户
	private String flag;//是否入职离职

	public TbZg() {
		// TODO 自动生成的构造函数存根
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
