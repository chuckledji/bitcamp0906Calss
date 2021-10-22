package ver04;

public class SmartPhoneMain {
	public static void main(String[] args) {
		
//		① SmartPhone 클래스의 인스턴스를 생성합니다.
		SmartPhone phone = new SmartPhone(10);
		
		while(true){
			
			System.out.println("#### 전화번호 관리 프로그램 ####");
			System.out.println("1.회사 동료 전화번호 등록");
			System.out.println("2.거래처 담당자 전화번호 등록");
			System.out.println("3.전화번호 검색 -이름기준");
			System.out.println("4.전화번호 삭제 -이름기준");
			System.out.println("5.전화번호 수정 -이름기준");
			System.out.println("6.전화번호 전체 출력");
			System.out.println("7.프로그램 종료");
			System.out.println();
			System.out.println("메뉴를 선택하세요. >>");
			
			int userChoice = Integer.parseInt(SmartPhone.sc.nextLine());
			
			switch(userChoice) {
				case 1: case 2:
					phone.insertContactData(userChoice);
					break;
				case 3:
					phone.searchPrintInt();
					break;
				case 4:
					phone.deleteDontact();
					break;
				case 5:
					phone.editContact();
					break;
				case 6:
					phone.printAll();
					break;
				case 7:
					System.out.println("프로그램을 종료합니다.");
					//System.exit(0);
					return;
				default :
					System.out.println("해당하는 메뉴번호가 존재하지 않습니다.\n다시 확인 후 선택해주세요.");
			}
			
		}

		
	}
}
