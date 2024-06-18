package Console;

public class phone {
	private long phone;
	private String mail;
	@Override
	public String toString() {
		return "phone [phone=" + phone + "]";
	}

	
	public phone(long phone, String mail) {
		super();
		this.phone = phone;
		this.mail = mail;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public long getPhone() {
		return phone;
	}

	public  void setPhone(long phone) {
		this.phone = phone;
	}

}
