package yth.dao.model;

public class TbJsr {// 职工信息
    private String num;//职工编号
	private String name;// 职工姓名
	private String sex;// 职工性别
	private String age;// 职工年龄
	private String tel;// 职工电话
	private String bat;//职工银行账户
    private String flag;//是否入职离职
	
	// 使用Getters and Setters方法将经手人信息类的私有属性封装起来
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