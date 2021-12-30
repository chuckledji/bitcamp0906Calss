package member.domain;

public class LoginInfo {

	private String userId;
	private String userName;
	private String photo;
	
	public LoginInfo(String userId, String userName, String photo) {
		this.userId = userId;
		this.userName = userName;
		this.photo = photo;
	}
	//로그인중 정보변화는 있으면 안되므로 getter만 만든다
	public String getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getPhoto() {
		return photo;
	}
	
	@Override
	public String toString() {
		return "LoginInfo [userId=" + userId + ", userName=" + userName + ", photo=" + photo + "]";
	}
	public int getIdx() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
