package guestbook.domain;

public class GuestBook {

	private int idx;
	private String title;
	private String content;
	private String regdate;
	private int memberidx;
	
	public GuestBook() {}

	public GuestBook(int idx, String tilte, String content, String regdate, int memberidx) {
		super();
		this.idx = idx;
		this.title = tilte;
		this.content = content;
		this.regdate = regdate;
		this.memberidx = memberidx;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getTitle() {
		return title;
	}

	public void setTilte(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getMemberidx() {
		return memberidx;
	}

	public void setMemberidx(int memberidx) {
		this.memberidx = memberidx;
	}

	@Override
	public String toString() {
		return "GuestBook [idx=" + idx + ", title=" + title + ", content=" + content + ", regdate=" + regdate
				+ ", memberidx=" + memberidx + "]";
	}
	
	
	
}