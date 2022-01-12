package member.domain;

public class LoginInfo {

	private int idx;
	private String userId;
	private String userName;
	private String photo;

	public LoginInfo(int idx, String userId, String userName, String photo) {
		this.idx = idx;
		this.userId = userId;
		this.userName = userName;
		this.photo = photo;
	}

	//로그인 중 정보변화는 없어야하므로 getter만 만든다
	public int getIdx() {
		return idx;
	}

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
		return "LoginInfo [idx=" + idx + ", userId=" + userId + ", userName=" + userName + ", photo=" + photo + "]";
	}

}
