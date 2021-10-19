package chapter08.test;


//2.Person 클래스를 상속해서 확장하는 새로운 클래스 Male 클래스와 Female 클래스를 정의 해봅시다.
//①각 클래스는 상속 받은 멤버 외에 추가적인 변수와 메소드를 추가해서 새로운 클래스를 정의해봅시다.
//③Person 클래스에서 정의된 인사하는 메소드를 오버라이딩 해봅시다.
//④Person 클래스에 생성자를 정의해서 인스턴스 변수들을 초기화 해봅시다.
public class Male extends Person {
	
	
	//생성자
	public Male(String name, String juminNum) {
		super(name, juminNum);
		
	}

	@Override
	public void sayHi() {
		
		super.sayHi();
		System.out.println("그리고 저는 여자입니다.");
	}
	
	
}