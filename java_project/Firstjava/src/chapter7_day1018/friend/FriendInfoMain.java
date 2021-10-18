package chapter7_day1018.friend;

import java.util.Scanner;

public class FriendInfoMain {

	public static void main(String[] args) {
		FriendInfoHandler handler = new FriendInfoHandler();//디폴트가모지
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("#### 메뉴 선택 ####");
			System.out.println("1.고교친구 정보저장");
			System.out.println("2.대학친구 정보저장");
			System.out.println("3.전체정보 출력");
			System.out.println("4.기본정보 출력");
			System.out.println("5.프로그램 종료");
			System.out.println("메뉴선택 >>> ");
			
			int userChoice = Integer.parseInt(sc.nextLine());
			
			switch(userChoice) {
			case 1: case 2: //1또는 2
				handler.addFriend(userChoice);
				break;
			case 3:
				handler.showAllData();
				break;
			case 4:
				handler.showAllSimpleData();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0); //return;
			}
		}
	}

}
