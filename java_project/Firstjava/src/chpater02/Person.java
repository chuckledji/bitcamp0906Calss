package chpater02;

public class Person {
	/*
	2. Person 클래스를 만들어 보고, 아래의 회원 정보를 저장하는 변수들을 선언해봅시다. 
	변수이름을 작성하는 규칙에 맞게 직접 변수 이름을 정의해 보세요. 
	① 회원이름을 저장하는 변수
	② 회원 전화번호 ( 000-0000-0000 )를 저장하는 변수
	③ 회원 주민등록번호 ( 000000-0000000 또는 0000000000000 )를 저장하는 변수
	*/
	
	//private : 클래스 내부에 멤버들만 참조가 가능하도록 하는 접근 제어자
	
	private String memberName;//회원이름
	private String phoneNum;  //(하이픈이있으므로 String)전화번호
	//private String juminNum;  //주민번호
	private long juminNum;   //주민번호
	
	//setter / getter 설정(저장) / 가져오기
	//setter => 값을 받아서 변수에 저장
	//갈색은지역변수 파랑색은 인스턴스
	public void setMemberName(String name) {
		memberName = name;
	}
	
	//getter => 인스턴스변수를 반환
	public String getMemberName() {
		return memberName;
	}
	public void setPhoneNum(String num) {
		phoneNum = num;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setJuminNum(long num) {
		juminNum = num;
	}
	public long getJuminNum() {
		return juminNum;
	}
	
	//전체 데이터 출력
	public void printData() {
		System.out.println("이름:" + memberName);
		System.out.println("전화전호:" + phoneNum);
		System.out.println("주민번호:" + juminNum);
	}
	
}
