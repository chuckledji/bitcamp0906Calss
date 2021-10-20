package chapter08.test;

//①Person 클래스를 상속받은 Male클래스와 Female클래스를 이용해서 인스턴스를 생성해 봅시다.
//②생성된 인스턴스들을 이용해서 메소드를 호출해봅시다.
public class PersonMain {
	 public static void main(String[] args) {
		
		Person p1 = new Male("사람1", "880606-1035647");
		Person p2 = new Female("사람2", "960205-4065735");
		
		 
		 p1.sayHi();
		 p2.sayHi();
		
		 
		 
	}
}
