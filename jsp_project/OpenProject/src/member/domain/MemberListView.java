package member.domain;

import java.util.List;

public class MemberListView {
	
	//화면에 무슨오브젝트?
	private int pageTotalCount; //페이지 개수
	private int totalCount;		//전체 행의 개수(회원의 수)
	private int countPerPage; 	//한 페이지에 출력할 행의 개수
	private int currentPage;	//현재 페이지번호 (사용자가 요청한)
	private List<Member> list; 	//출력할 데이터 항목 리스트
	
	public MemberListView(int totalCount, int countPerPage, int currentPage, List<Member> list) {
		//PageTotalCount는 뺀다. -> 전체행의개수*한페이지에 출력할 행의 개수로 구할 수 있으므로 
		this.totalCount = totalCount;
		this.countPerPage = countPerPage;
		this.currentPage = currentPage;
		this.list = list;
		calTotalPageCount();
	}
	
	private void calTotalPageCount() {
		
		pageTotalCount = totalCount / countPerPage;
		
		if(totalCount%countPerPage>0) {
			pageTotalCount++;	//나머지가 남으면 박스하나로 처리하기 위해
		}
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getCountPerPage() {
		return countPerPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public List<Member> getList() {
		return list;
	}

	@Override
	public String toString() {
		return "MemberListView [pageTotalCount=" + pageTotalCount + ", totalCount=" + totalCount + ", countPerPage="
				+ countPerPage + ", currentPage=" + currentPage + ", list=" + list + "]";
	}
	
	
}
