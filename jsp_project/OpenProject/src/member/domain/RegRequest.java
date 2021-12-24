package member.domain;

public class RegRequest {
	
	private String userid;
	private String pw;
	private String username;
	private String fileName;
	
	public RegRequest() {
		
	}
	
	public RegRequest(String userid, String pw, String username, String fileName) {
		
		this.userid = userid;
		this.pw = pw;
		this.username = username;
		this.fileName = fileName;
	}
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	
	@Override
	public String toString() {
		return "RegRequest [userid=" + userid + ", pw=" + pw + ", username=" + username + "]";
	}
	// RegRequest객체에서 -> Member객체로 반환되는 메소드
	public Member getMemeber() {
		return new Member(0, this.userid, this.pw, this.username, null, null);
	}
}
