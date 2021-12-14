package domain;

public class LoginInfo {

	private String uid;
	private String name;
	private String nic;
	private String email;
	
	
	//생성자로 초기화
	public LoginInfo(String uid, String name, String nic, String email) {
		this.uid = uid;
		this.name = name;
		this.nic = nic;
		this.email = email;
	}

	
	//읽기전용이되어야함 > 중간에 사용자정보가 변경이 되면 안되니까. : getter만 존재, setter는 없다.
	public String getUid() {
		return uid;
	}
	public String getName() {
		return name;
	}
	public String getNic() {
		return nic;
	}
	public String getEmail() {
		return email;
	}


	@Override
	public String toString() {
		return "LoginInfo [uid=" + uid + ", name=" + name + ", nic=" + nic + ", email=" + email + "]";
	}
	
	
}
