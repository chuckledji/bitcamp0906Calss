package com.bitcamp.op.member.domain;

public class SearchParams {
	
	private int index;
	private int count;
	private String serchType;
	private String keyword;
	
	public SearchParams() {}
	
	public SearchParams(int index, int count, String serchType, String keyword) {
		this.index = index;
		this.count = count;
		this.serchType = serchType;
		this.keyword = keyword;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getSerchType() {
		return serchType;
	}

	public void setSerchType(String serchType) {
		this.serchType = serchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
	
	
}
