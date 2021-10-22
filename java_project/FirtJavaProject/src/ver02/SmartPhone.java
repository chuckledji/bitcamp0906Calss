package ver02;

import java.util.Scanner;

//① Contact 클래스의 인스턴스 10개를 저장 할 수 있는 배열을 정의합시다.
//② 배열에 인스턴스를 저장하고, 수정하고, 삭제, 저장된 데이터의 리스트를 출력하는 메소드를 정의합니다
public class SmartPhone {
	
	//배열 선언 - 이곳에서만 쓰일 수 있도록
	private Contact[] contacts;			// Conatct타입의 인스턴스를 저장하는 배열 선언 (참조변수)
	private int cnt;					// 저장된 Contact 타입의 인스턴스 개수, 배열의 index로 사용한다.
	public static Scanner sc = new Scanner(System.in);
	
	
	public SmartPhone(int size) {
		contacts = new Contact[size]; 	// 배열 생성
		cnt =0;							// 필수는 아니지만 해두면 좋다
	}
	
	//메소드1 - 배열에 요소를 추가 : 참조값(변수)을 전달받아 배열에 추가하는 기능
	public void addContact(Contact contact) {
		contacts[cnt++]=contact;
	}
	
	//메소드2 - 사용자로부터 데이터를 받아 Contact객체를 생성, 배열에 참조값을 저장하는 메소드를 호출
	public void insertContactData() {
		System.out.println("연락처 등록을 시작합니다.--------");
		System.out.println("이름: > ");
		String name =sc.nextLine();
		System.out.println("전화번호: > ");
		String phoneNumber =sc.nextLine();
		System.out.println("이메일: > ");
		String email =sc.nextLine();
		System.out.println("주소: > ");
		String adress =sc.nextLine();
		System.out.println("생일: > ");
		String birthday =sc.nextLine();
		System.out.println("그룹: > ");
		String group =sc.nextLine();
		
		//Contact c =new Contact(name, phoneNumber, email, adress, birthday, group);
		//addContact(c);
		addContact(new Contact(name, phoneNumber, email, adress, birthday, group));
	}
	//메소드3 - 전체 데이터 출력 : 배열은 반복문사용
	public void printAll() {
		System.out.println("전체 정보의 리스트를 출력한다.("+cnt+"명");
		System.out.println("======================================");
		
		for(int i=0; i<cnt; i++) {
			contacts[i].printContact();
			System.out.println("----------------------");
			
		}
	}
	//이름을 전달받아서 배열의 각 요소에 이름과 비교, 같은 요소가 있으면 해당 인덱스를 반환
	private int searchIndex(String name) {
		int index = -1; 	//인위적으로 -1을 준다.
		
		//배열의 요소를 반복해서 참조하고 이름과 비료->찾으면 반복종료 flase
		for(int i =0; i<cnt; i++) {
			if(contacts[i].getName().equals(name)) {
				index =i;
				break;
			}
		}
		return index;
	}
	
	//메소드4 - 검색 후 출력 : 이름해당하는 index찾기
	public void searchPrintInt() {
		System.out.println("검색을 시작합니다--------------------");
		System.out.println("찾고자 하는 이름을 입력해주세요.>>");
		String name = sc.nextLine();
		
		int index = searchIndex(name);
		if(index<0) {
			System.out.println("찾으시는 이름: "+name+"의 정보가 존재하지 않습니다.");
		}else {
			System.out.println("검색결과: ");
			System.out.println("--------------------");
			contacts[index].printContact();
			System.out.println("--------------------");
		}
	}
	
	//메소드5 - 데이터 삭제: 이름검색으로
	public void deleteDontact() {
		System.out.println("데이터 삭제를 시작합니다.");
		System.out.println("삭제하고자 하는 데이터의 이름을 입력하세요.>>");
		String name = sc.nextLine();
		
		int index = searchIndex(name);
		
		if(index<0) {
			System.out.println("삭제하고자 하는 이름 "+name+"의 데이터가 존재하지 않습니다.");
		}else {
			//삭제처리: index 위치의 참조값을 index+1위치의 값으로 치환, shift
			for(int i = index; i<cnt-1; i++) {
				contacts[i]=contacts[index+1];
			}
			cnt--;
			System.out.println(name+"의 데이터가 삭제되었습니다.");
		}
		
	}
	
	//메소드6 - 데이터 수정: 이름검색으로/ 수정할 데이터를 받아서 처리
	public void editContact() {
		System.out.println("데이터수정을 시작합니다.");
		System.out.println("수정하고자 하는 데이터의 이름을 입력하세요.>>");
		String name = sc.nextLine();
		
		int index = searchIndex(name);
		
		if(index<0) {
			System.out.println("수정하고자 하는 이름"+name+"의 데이터가 존재하지 않습니다.");
		}else {
			//수정처리
			System.out.println("데이터 수정을 위해 각각의 데이터를 입력하세요.");
			
			System.out.println("연락처 등록을 시작합니다.--------");
			System.out.println("이름: > ");
			String ename =sc.nextLine();
			System.out.println("전화번호: > ");
			String phoneNumber =sc.nextLine();
			System.out.println("이메일: > ");
			String email =sc.nextLine();
			System.out.println("주소: > ");
			String adress =sc.nextLine();
			System.out.println("생일: > ");
			String birthday =sc.nextLine();
			System.out.println("그룹: > ");
			String group =sc.nextLine();
			
			//Contact타입의 c
			contacts[index].setName(ename);					//배열의 인덱스번에 새로저장
			contacts[index].setPhoneNumber(phoneNumber);
			contacts[index].setEmail(email);
			contacts[index].setAdress(adress);
			contacts[index].setBirthday(birthday);
			contacts[index].setGroup(group);
			
			System.out.println(name+"의 데이터가 수정되었습니다.");
		}
	}
	
	
}
