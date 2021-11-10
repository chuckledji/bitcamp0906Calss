package member;

public class Users {

	private int id;
	private String userid;
	private String username;
	private String password;
	private String address;
	private String phone;
	private String email;
	
	
	//생성자 초기화
	public Users(int id, String userid, String username, String password, String address, String phone, String email) {
		
		this.id = id;
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}
	
	
	//기본생성자(디폴트)
	public Users() {}
	
	
	//getter/setter
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	//to String
	@Override
	public String toString() {
		return  id + "\t" + userid + "\t" + username + "\t" + password + "\t"
				+ address + "\t" + phone + "\t" + email;
	}


	
	
	
	
	
	
	
	
	
}
