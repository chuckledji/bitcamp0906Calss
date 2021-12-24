package guestbook.domain;

public class ListRequest {

	//리스트 목록에 필요한 객체들 
	private int idx;
	private String subject;
	private String userid;
	private String regdate;
	
	public ListRequest(int idx, String subject, String userid, String regdate) {
		
		this.idx = idx;
		this.subject = subject;
		this.userid = userid;
		this.regdate = regdate;
	}

	

	public int getIdx() {
		return idx;
	}



	public void setIdx(int idx) {
		this.idx = idx;
	}



	public String getSubject() {
		return subject;
	}



	public void setSubject(String subject) {
		this.subject = subject;
	}



	public String getUserid() {
		return userid;
	}



	public void setUserid(String userid) {
		this.userid = userid;
	}



	public String getRegdate() {
		return regdate;
	}



	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}



	@Override
	public String toString() {
		return "ListRequest [idx=" + idx + ", subject=" + subject + ", userid=" + userid + ", regdate=" + regdate + "]";
	}
	
	
}
