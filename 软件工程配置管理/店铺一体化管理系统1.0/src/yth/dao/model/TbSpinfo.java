package yth.dao.model;

public class TbSpinfo implements java.io.Serializable {// ��Ʒ��Ϣ��ʵ�����л��ӿڣ�

	private String id;// ��Ʒ���
	private String name;// ��Ʒ����
	private String spcd;// ����
	private String spdw;// ��Ʒ������λ
	private String spdj;// ����
	private String spsl;// ����
	private String gysname;// ��Ӧ������
	
	// ʹ��Getters and Setters��������Ʒ��Ϣ���˽�����Է�װ����
	public TbSpinfo() {
	}

	public TbSpinfo(String spid) {
		this.id = spid;
	}

	public String getId() {
		return id;
	}

	public void setId(String spid) {
		this.id = spid;
	}

	public String getName() {
		return name;
	}

	public void setName(String spname) {
		this.name = spname;
	}

	public String getSpcd() {
		return spcd;
	}

	public void setSpcd(String spcd) {
		this.spcd = spcd;
	}

	public String getSpdw() {
		return spdw;
	}

	public void setSpdw(String spdw) {
		this.spdw = spdw;
	}

	public String getSpdj() {
		return spdj;
	}

	public void setSpdj(String spdj) {
		this.spdj = spdj;
	}

	public String getSpsl() {
		return spsl;
	}

	public void setSpsl(String spsl) {
		this.spsl = spsl;
	}

	public String getGysname() {
		return gysname;
	}

	public void setGysname(String gysname) {
		this.gysname = gysname;
	}

	public String toString() {
		return getName();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gysname == null) ? 0 : gysname.hashCode());
		result = prime * result + ((spcd == null) ? 0 : spcd.hashCode());
		result = prime * result + ((spdj == null) ? 0 : spdj.hashCode());
		result = prime * result + ((spdw == null) ? 0 : spdw.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((spsl == null) ? 0 : spsl.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TbSpinfo other = (TbSpinfo) obj;
		if (gysname == null) {
			if (other.gysname != null)
				return false;
		} else if (!gysname.equals(other.gysname))
			return false;
		if (spcd == null) {
			if (other.spcd != null)
				return false;
		} else if (!spcd.equals(other.spcd))
			return false;
		if (spdj == null) {
			if (other.spdj != null)
				return false;
		} else if (!spdj.equals(other.spdj))
			return false;
		if (spdw == null) {
			if (other.spdw != null)
				return false;
		} else if (!spdw.equals(other.spdw))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (spsl == null) {
			if (other.spsl != null)
				return false;
		} else if (!spsl.equals(other.spsl))
			return false;
		return true;
	}

}