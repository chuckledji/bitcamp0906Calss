package chpater02;

public class PersonMain {
	public static void main(String[] args) {
	
		//Person 클래스의 인스턴스 생성
		Person p =new Person();
		
		//값 저장하기
		//p.memberName ="정지원";
		p.setMemberName("정지원");
		p.setPhoneNum("010-2222-3333");
		p.setJuminNum(9901011111112L);//L붙여줘야함
		
		//하나하나 겟해서 출력할떄
		System.out.println("이름:"+p.getMemberName());
		System.out.println("전화번호:"+p.getPhoneNum());
		System.out.println("주민번호:"+p.getJuminNum());
		
		
		System.out.println("--------------------------------");
		//모든정보를 메소드로 출력할때 
		p.printData();
	}



}
