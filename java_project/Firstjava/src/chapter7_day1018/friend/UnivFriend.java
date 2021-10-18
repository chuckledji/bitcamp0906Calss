package chapter7_day1018.friend;

public class UnivFriend extends Friend {
	//대학친구
	
	//변수
	String major;

	//생성자
	public UnivFriend(String name, String phoneNumber, String adress, String major) {
		super(name, phoneNumber, adress);
		this.major = major;
	}
	
	//오버라이딩
	@Override//안써도 된다.
	public void showData() {
		super.showData();
		System.out.println("전공: "+major);
	}

	public void showBasicInfo() {
		System.out.println("이름: "+name);
		System.out.println("전화번호: "+phoneNumber);
	}
	
}
