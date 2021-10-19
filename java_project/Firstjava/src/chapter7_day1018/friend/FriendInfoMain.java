package chapter7_day1018.friend;

import java.util.Scanner;

public class FriendInfoMain {

	public static void main(String[] args) {
		FriendInfoHandler handler = new FriendInfoHandler();//디폴트가모지
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("#### 메뉴 선택 ####");
			System.out.println(Menu.ISERT_HIGH+"1.고교친구 정보저장");
			System.out.println(Menu.INSERT_UNIV+"2.대학친구 정보저장");
			System.out.println(Menu.SHOW_ALL+"3.전체정보 출력");
			System.out.println(Menu.SHOW_BASIC+"4.기본정보 출력");
			System.out.println(Menu.EXIT+"5.프로그램 종료");
			System.out.println("메뉴선택 >>> ");
			
			
			int userChoice = Integer.parseInt(sc.nextLine());
			
			switch(userChoice) {
			case Menu.ISERT_HIGH: case Menu.INSERT_UNIV: //1또는 2
				handler.addFriend(userChoice);
				break;
			case Menu.SHOW_ALL:
				handler.showAllData();
				break;
			case Menu.SHOW_BASIC:
				handler.showAllSimpleData();
				break;
			case Menu.EXIT:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0); //return;
			}
		}
	}

}
