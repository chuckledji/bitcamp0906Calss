package chapter7_day1018.friend;

import java.util.Scanner;

public class FriendInfoHandler {
	//배열을 가지고(친구정보를 저장하는)
	//배열에 데이터를 저장하고
	//배열에 저장된 정보 데이터를 출력하는 메소드
	
	
	
	//배열-다형성을 이용
	private Friend[] friends;
	private int numOfFriends; //입력된 친구 정보의 개수, 배열의 index로 사용
	
	
	
	//배열 사이즈
	FriendInfoHandler(int size){
		friends = new Friend[size];
		numOfFriends =0;
	}
	FriendInfoHandler(){
		this(10);
	}
	
	
	
	//메소드1-배열에 요소 입력 : Friend타입의 인스턴스를 참조하는 참조값을 받아서 배열에 추가
	void addFriendInfo(Friend f) {
		//다형성이용 -> 매개변수의 선언은 상위타입의 클래스타입으로 정의
		//Friend f = new HighFriend();
		//Friend f = new UnivFriend();
		friends[numOfFriends++] =f;
	}
	
	
	
	
	//메소드2-데이터를 사용자로부터 입력받아
	//		Friend 클래스의 파생 클래스의 인스턴스를 생성,
	//		-> addFriendInfo(f)호출
	public void addFriend(int userChoice) {
		Scanner sc = new Scanner(System.in);
		
		//기본정보를 입력받고
		System.out.println("친구정보를 입력을 시작합니다.");
		
		System.out.println("이름을 입력하세요.");
		String name = sc.nextLine();
		System.out.println("전화번호를 입력하세요.");
		String phoneNumber = sc.nextLine();
		System.out.println("주소를 입력하세요.");
		String adress = sc.nextLine();
		
		//userChoice ==1 ->고교친구들 추가정보 받고, 인스턴스를 생성
		//userChoice ==2 ->대학친구들 추가정보 받고, 인스턴스를 생성
		if(userChoice ==1) {
			System.out.println("직업을 입력하세요.");
			String job = sc.nextLine();
			
			//인스턴스생성 후, //배열에 인스턴스를 추가
			//Friend f = new HighFriend(name, phoneNumber, adress, job);
			//addFriendInfo(f);
			//합쳐서->
			addFriendInfo(new HighFriend(name, phoneNumber, adress, job));
		}else {
			System.out.println("전공을 입력하세요.");
			String major = sc.nextLine();
			addFriendInfo(new UnivFriend(name, phoneNumber, adress, major));
		}
	}
	
	
	
	//메소드3-모든정보출력
	public void showAllData() {
		System.out.println("친구정보를 모두 출력합니다.");
		for(int i=0; i<numOfFriends; i++) {
			friends[i].showData();//오버라이딩 된 쇼데이타가 나올것이다
			System.out.println("-----------------");
		}
	}
	
	
	
	//메소드4-기본정보만출력
	public void showAllSimpleData() {
		System.out.println("친구의 기본정보를 모두 출력합니다.");
		for(int i=0; i<numOfFriends; i++) {
			friends[i].showBasicInfo();
			System.out.println("-----------------");
		}
	}
	
}
