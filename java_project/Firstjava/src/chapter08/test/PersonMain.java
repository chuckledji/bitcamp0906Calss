package chapter08.test;

//①Person 클래스를 상속받은 Male클래스와 Female클래스를 이용해서 인스턴스를 생성해 봅시다.
//②생성된 인스턴스들을 이용해서 메소드를 호출해봅시다.
public class PersonMain {
	 public static void main(String[] args) {
		
		Person p1 = new Male("큰남자", "880606-1035647");
		Person p2 = new Female("큰여자", "960205-2065735");
		Person p3 = new Male("작은남자", "050606-1035647");
		Person p4 = new Female("작은여자", "100205-2065735");
		 
		 p1.sayHi();
		 p2.sayHi();
		 p3.sayHi();
		 p4.sayHi();
		 
		 
	}
}
