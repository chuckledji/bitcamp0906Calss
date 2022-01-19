package com.bitcamp.op.guestbook.domain;

public class ReplyRegRequest {

	private int idx;				//등록되고 나서 생기는 자동 증가하는 idx값
	private int memberIdx;
	private int guestbookIdx;
	private String message;
	
	
	
	public ReplyRegRequest() {
	}
	
	
	public ReplyRegRequest(int idx, int memberIdx, int guestbookIdx, String message) {
		this.idx = idx;
		this.memberIdx = memberIdx;
		this.guestbookIdx = guestbookIdx;
		this.message = message;
	}


	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getMemberIdx() {
		return memberIdx;
	}
	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}
	public int getGuestbookIdx() {
		return guestbookIdx;
	}
	public void setGuestbookIdx(int guestbookIdx) {
		this.guestbookIdx = guestbookIdx;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}


	@Override
	public String toString() {
		return "ReplyRegRequest [idx=" + idx + ", memberIdx=" + memberIdx + ", guestbookIdx=" + guestbookIdx
				+ ", message=" + message + "]";
	}
	
	
	
}
