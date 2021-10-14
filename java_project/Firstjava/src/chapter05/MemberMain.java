package chapter05;

public class MemberMain {
	public static void main(String[] args) {
		// 회원의 정보를 저장하는 프로그램
		// 데이터를 저장할 수 있는 구조(클래스)를 만들었다!
		// Member클래스로 인스턴스를 생성하면 데이터를 저장하는 것과 같다!(인스턴스를 생성하는 순간 메모리에 데이터가 들어가니까)
		// Member클래스는 정보를 저장하기위한 기능을 하기 위해 존재하는것
		
		Member member1 = new Member("손흥민", "010-0100-0100", "스포츠재활학과", 2, "Son@gmail.com", "1988-05-05", "서울시");
		
		//개인정보(데이터들)출력
		member1.showData();
		
		Member member2 = new Member("이강인", "010-0505-0505","스포츠학과", 4, "Lee@gmail.com");
		
		member2.showData();
		
	}
}
