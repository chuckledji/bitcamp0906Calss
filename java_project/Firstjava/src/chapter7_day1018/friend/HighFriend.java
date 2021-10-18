package chapter7_day1018.friend;

public class HighFriend extends Friend {
	//고교친구
	
	//변수
	String work;
	
	//생성자
	public HighFriend(String name, String phoneNum, String adress, String work){
		super(name, phoneNum, adress);
		this.work = work;
	}
	
	//오버라이딩
	@Override
	public void showData() {
		super.showData();
		System.out.println("직업: "+work);
	}

	@Override
	public void showBasicInfo() {
		//super.showBasicInfo(); 상위클래스에서 내용이없으니 할필요없다
		System.out.println("이름: "+name);
		System.out.println("전화번호: "+phoneNumber);
	}
	
	
	
}
