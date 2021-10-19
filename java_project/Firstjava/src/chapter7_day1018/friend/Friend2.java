package chapter7_day1018.friend;

public class Friend2 {
	//개인정보 프로그램
	
	//변수-정보를 저장
	String name;
	String phoneNumber;
	String adress;
	
	//생성자-저장 데이터의 초기화 
	public Friend2(String name, String phoneNumber, String adress) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.adress = adress;
	}
	
	//메소드1-데이터출력 : 상속을 하면 오버라이딩해서 하이 클래스의 멤버도 출력
	public void showData() {
		System.out.println("이름: " +this.name);
		System.out.println("전화번호: "+this.phoneNumber);
		System.out.println("주소: "+this.adress);
	}
	
	//메소드2-오버라이딩 목적
	public void showBasicInfo() {}
	
}
