package com.bitcamp.op.member.domain;

public class MemberLoginRequest {

	private String url;
	private String uid;
	private String pw;
	private String saveid;
	
	
	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getUid() {
		return uid;
	}


	public void setUid(String uid) {
		this.uid = uid;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getSaveid() {
		return saveid;
	}


	public void setSaveid(String saveid) {
		this.saveid = saveid;
	}


	@Override
	public String toString() {
		return "MemberLoginRequest [url=" + url + ", uid=" + uid + ", pw=" + pw + ", saveid=" + saveid + "]";
	}
	
	
	
	
}
