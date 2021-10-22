package ver02;

public class SmartPhoneMain {
	public static void main(String[] args) {
		
//		① SmartPhone 클래스의 인스턴스를 생성합니다.
		SmartPhone phone = new SmartPhone(10);
		
		
//		② 사용자로부터 입력을 받아 Contact 인스턴스를 생성해서 SmartPhone 클래스의 인스턴스가 가지고 있는 배열에 추가합니다.
//		③ 10번 반복해서 배열에 추가합니다.
		for(int i =0; i<2; i++) {
		phone.insertContactData(); 			//이미 에소드를 만들어 놓았다.
		}

//		④ 배열의 모든 요소를 출력합니다.
		phone.printAll();
		
//		⑤ 배열의 모든 요소를 검색합니다. (검색 후 출력)
		phone.searchPrintInt();
		
//		⑥ 배열의 요소를 삭제해 봅시다.
		phone.deleteDontact();
		
//		⑦ 배열의 요소를 수정해 봅시다
		phone.editContact();
		
		//삭제와 변경여부 확인
		phone.printAll();
		
	}
}
