package project05;
//정보입출력하는메인
public class SmartPhoneMain {
	
public static void main(String[] args) {
	SmartPhone smartPhone = new SmartPhone();
	
	System.out.println("연락처 입력 프로그램");
	while(true) {
		//메뉴
		menu();
		System.out.println("---------------------------");
		System.out.println("실행할 메뉴 번호를 선택해주세요.");
				
		int userChoice = Integer.parseInt(SmartPhone.scanner.nextLine());
				
		switch(userChoice) {
		case 1 :
			//정보입력
			System.out.println("사용자 정보를 입력합니다.");
			smartPhone.insertInfo();
			break;
		case 2:
			//정보리스트출력
			System.out.println("모든 사용자 정보 리스트를 출력합니다.");
			smartPhone.printAll();
			break;
		case 3:
			//정보검색
			System.out.println("사용자 정보를 수정합니다.");
			smartPhone.update();
			break;
		case 4:
			//정보삭제
			System.out.println("사용자 정보를 삭제합니다.");
			smartPhone.delete();
			break;
		case 5:	
			//프로그램종료
			System.out.println("프로그램을 종료합니다.");
			return;
		}
	}
	
}

	public static void menu() {
		
		System.out.println("---------------------------");
		System.out.println("1.사용자 연락처 입력");
		System.out.println("2.사용자 정보 리스트 출력");
		System.out.println("3.사용자 정보 수정");
		System.out.println("4.사용자 정보 삭제");
		System.out.println("5.프로그램 종료");
	}


}
