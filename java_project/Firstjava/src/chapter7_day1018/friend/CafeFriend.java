package chapter7_day1018.friend;

//추상클래스를 상속해서 새로운 클래스를 정의함
public class CafeFriend extends Friend{
	//변수
	String cafeName;
	//생성자
	public CafeFriend(String name, String phoneNumber, String adress, String cafeName) {
		super(name, phoneNumber, adress);
		this.cafeName = cafeName;
	}

	//추상클래스를 상속받으면 반드시 추상 메소드를 완성시켜야 인스턴스 생성기 가능하다
	@Override
	public void showBasicInfo() {
		System.out.println("이름: "+ name);
		System.out.println("전화번호: "+phoneNumber);
		System.out.println("동호회이름: "+cafeName);
	}

	
}
