package project08;

public class SmartPhoneMain2 {
	public static void main(String[] args) {
		
//		① SmartPhone 클래스의 인스턴스를 생성합니다.
		SmartPhone phone = new SmartPhone();
		
		while(true){
			
			System.out.println("#### 전화번호 관리 프로그램 ####");
			System.out.println("1.전화번호 등록");
			System.out.println("2.전화번호 검색 -이름기준");
			System.out.println("3.전화번호 삭제 -이름기준");
			System.out.println("4.전화번호 수정 -이름기준");
			System.out.println("5.전화번호 전체 출력");
			System.out.println("6.프로그램 종료");
			System.out.println("메뉴를 선택하세요. >>");
			
			int userChoice = Integer.parseInt(SmartPhone.sc.nextLine());
			
			switch(userChoice) {
				case 1: 
					phone.insertContactData();
					break;
				case 2:
					phone.searchPrintInt();
					break;
				case 3:
					phone.deleteDontact();
					break;
				case 4:
					phone.editContact();
					break;
				case 5:
					phone.printAll();
					break;
				case 6:
					System.out.println("프로그램을 종료합니다.");
					//System.exit(0);
					return;
					
			}
			
		}

		
	}
}
