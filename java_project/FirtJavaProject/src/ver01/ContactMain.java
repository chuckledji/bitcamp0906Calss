package ver01;

public class ContactMain {
public static void main(String[] args) {
	
	//인스턴스생성 = > new클래스이름 -> 믈래스() 생성자호출
	//인스턴스 생성1 -데이터 모두 넣어서
	Contact contact1 = new Contact("손흥민", "010-0000-0001", "son@gmail.com", "서울시 광진구 무슨동","20001010" , "팀1");
	//인스턴스 생성2 -기본두개만 넣어서
	Contact contact2 = new Contact("이강인", "010-0000-0002");
	
	//출력 - getter메소드를 이용
	System.out.println("==========================================");
	System.out.println("이름: "+contact1.getName());	//getter setter메소드를 이용해서 값 가져오기
	System.out.println("이름: "+contact2.getName());
	
	//출력 - 저장된 모든 데이터
	System.out.println("==========================================");
	contact1.printContact();
	contact2.printContact();
	
	//데이터변경: setter메소드를 이용
	contact2.setEmail("lee@gmail.com");
	contact2.setAdress("서울");
	contact2.setBirthday("2000-10-20");
	contact2.setGroup("칭구");
	System.out.println("----------데이터변경(추가)-----------");
	
	
}
}
