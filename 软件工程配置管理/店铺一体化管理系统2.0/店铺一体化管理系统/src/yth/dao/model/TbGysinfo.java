package yth.dao.model;

public class TbGysinfo {
	
	private String id;//��Ӧ�̱��
	private String name;//��Ӧ������
	private String gysaddress;//��Ӧ�̵�ַ
	private String gysmail;//��Ӧ������
	private String gystel;//��Ӧ�̵绰
	private String gysbat;//��Ӧ�������˻�
	private String gystax;//��Ӧ����˰��

	public TbGysinfo() {
		// TODO �Զ����ɵĹ��캯�����
	}
	
	public TbGysinfo(String gys_id) {
		this.id = gys_id;
	}

	public TbGysinfo(String gys_id, String gys_name, String gys_address, String gys_mail, String gys_tel,
			String gys_bat, String gys_tax) {
		super();
		this.id = gys_id;
		this.name = gys_name;
		this.gysaddress = gys_address;
		this.gysmail = gys_mail;
		this.gystel = gys_tel;
		this.gysbat = gys_bat;
		this.gystax = gys_tax;
	}

	public String getId() {
		return id;
	}

	public void setId(String gys_id) {
		this.id = gys_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String gys_name) {
		this.name = gys_name;
	}

	public String getGysaddress() {
		return gysaddress;
	}

	public void setGysaddress(String gys_address) {
		this.gysaddress = gys_address;
	}

	public String getGysmail() {
		return gysmail;
	}

	public void setGysmail(String gys_mail) {
		this.gysmail = gys_mail;
	}

	public String getGystel() {
		return gystel;
	}

	public void setGystel(String gys_tel) {
		this.gystel = gys_tel;
	}

	public String getGysbat() {
		return gysbat;
	}

	public void setGysbat(String gys_bat) {
		this.gysbat = gys_bat;
	}

	public String getGystax() {
		return gystax;
	}

	public void setGystax(String gys_tax) {
		this.gystax = gys_tax;
	}
	
	
}
