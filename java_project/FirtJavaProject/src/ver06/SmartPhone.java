package ver06;

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
	public void insertContactData(int userChoice) {
		
		System.out.println("연락처 등록을 시작합니다.--------");
		System.out.println("이름: > ");
		String name =getString();
		System.out.println("전화번호: > ");
		String phoneNumber =checkPhoneNumber();
		
		if(checkPhoneNumber(phoneNumber)) {
			System.out.println("존재하는 전화번호입니다. 다시 입력해주세요.");
			System.out.println("메뉴로 돌아갑니다.");
			return;
		}
		
		System.out.println("이메일: > ");
		String email =getString();
		System.out.println("주소: > ");
		String adress =getString();
		System.out.println("생일: > ");
		String birthday =getString();
		System.out.println("그룹: > ");
		String group =getString();
		
		
		if(userChoice ==1) {
			//회사정보입력
			System.out.println("회사이름: >");
			String companyName =getString();
			System.out.println("부서이름: >");
			String divName =getString();
			System.out.println("직급: >");
			String job =getString();
			
			addContact(new CompanyContact(name, phoneNumber, email, adress, birthday, group, companyName, divName, job));
			
		}else {
			//거래처정보입력
			System.out.println("거래처이름: >");
			String companyName =getString();
			System.out.println("거래품목: >");
			String product=getString();
			System.out.println("직급: >");
			String job =getString();
			
			addContact(new CustomerContact(name, phoneNumber, email, adress, birthday, group, companyName, product, job));
			
		}
		
	}
	//*중복전화메소드
	private boolean checkPhoneNumber(String number) {
		
		boolean chk = false;
		
		//배열반복하며 번호비교 -> 같은번호가 있으면 -> chk = true;
		for(int i=0; i<cnt; i++) {
			if(contacts[i].getPhoneNumber().equals(number)) {
				chk = true;
				break;
			}
		}	
		return chk;
	}
	
	//*중복전화메소드 (오버로딩)
	private String checkPhoneNumber() {
		String number = null;
		
		while(true) {
			number = sc.nextLine().trim();
			//전화번호 존재 체크
			boolean chk = false;
			if(number.length()>0) {
				
				//번호가 같은지 비교
				for(int i =0; i<cnt; i++) {
				if(contacts[i].getPhoneNumber().equals(number)) {
					
					try {
					//예외처리
					throw new DuplicatePhoneNumberException();
					}catch(DuplicatePhoneNumberException e) {
						chk = true;
						System.out.println("존재하는 번호입니다. 다시 입력해주세요.");
						break;
					}
				  }
				}
				//같은번호가 존재하면 while문을 벗어나지않는다.
				if(!chk) {
					break;
				}
			}else {
				System.out.println("공백문자를 허용하지 않습니다. 다시 입력해주세요.");
			}
		}
		return number;
	}
	
	//공백허용하지않고, 영문자와한글만 가능하도록 처리
	
	private String getName() {
		
		String result = null;
		//사용자에 문자열받고-> 예외발생여부 확인 -> 예외발생 -> 예외처리
		while(true) {	//outtwr라벨
			//데이터받기
			result = sc.nextLine().trim();
			//잘못된 입력판단 조건식
			if(result.length()>0) {
				
				//문자열에 영문자와 한글만 포함하고 있는지 체크하는변수
				boolean chk = false;	//중복하지않아
				
				for(int i =0; i<result.length(); i++) {
					char c = result.charAt(i);
					boolean c1 = c>= 'a' && c<='z'; //입력문자가 소문자
					boolean c2 = c>= 'A' && c<='Z'; //입력문자가 대문자
					boolean c3 = c>= '가' && c<='힣';//입력문자가 한글
					if(!(c1 || c2 || c3 )) {
						//정상적으로 영문자와 한글이 입력되지 않은경우
						BadNameInputException one = new BadNameInputException("영문자 또는 한글이 아닌 문자가 입력되었습니다\n 확인 후 다시 입력해주세요.");
							try {
								throw bne;
								catch(BadNameInputException e) {
									System.out.println(e.getMessage());
									chk = true;
									break;
							}
						}
					}
				//예외없이 문자열체크
				//정상적으로 영문자와 한글이 입력된경우
				//chek -> true면 다시입력. flase면 while문 벗어나기.
				//result 문자열을 현재 보관 중
				if(!chk) {
					break; //while문 벗어남
				}
				
			}else {
				//만약 0이다 = 예외발생
				BadNameInputException bne = new BadNameInputException("공백입력!");
				try {
				throw bne;
				}catch(BadNameInputException e) {
					//예외처리 : 예외의 로그 등록
					System.out.println(e.getMessage());
					System.out.println("다시입력해주세요.");
				}
			}
		}
		
		return result;
	}
	
	//*공백메소드 - 사용자로부터 문자열을 입력받고 -> 공백여부를 확인 -> 공백이면 다시 입력 -> 입력받은 데이터를 반환
	private String  getString() {
		String result = null;
		
		while(true) {
			result = sc.nextLine();
			result = result.trim(); 		// "  글자 " -> "글자"(좌우 공백을 없앤다.)
			if(result.length()==0) {		// 문자열이 아무것도 없는 상태인 것.
				System.out.println("공백입력은 허용되지 않습니다.다시 입력해주세요.");
			}else {
				break;
			}
		}
		return result;
	}
	
	
	
	//메소드3 - 전체 데이터 출력 : 배열은 반복문사용
	public void printAll() {
		System.out.println("전체 정보의 리스트를 출력한다.("+cnt+"명)");
		System.out.println("======================================");
		
		for(int i=0; i<cnt; i++) {
			contacts[i].printContact();
			System.out.println("----------------------");
			
		}
	}
	
	
	//*이름을 전달받아서 배열의 각 요소에 이름과 비교, 같은 요소가 있으면 해당 인덱스를 반환
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
			//이 부분 다시 읽어보기****************************************************************
			if(cnt == 1 && index ==0) {
				contacts[0] = null;
				cnt --;
			}else {
				for(int i = index; i<cnt-1; i++) {
					contacts[i]=contacts[index+1];
				}	
				cnt--;
			}
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
			String ename =getString();
			System.out.println("전화번호: > ");
			String phoneNumber =getString();
			System.out.println("이메일: > ");
			String email =getString();
			System.out.println("주소: > ");
			String adress =getString();
			System.out.println("생일: > ");
			String birthday =getString();
			System.out.println("그룹: > ");
			String group =getString();
			
			//회사동료인지 고객인지 분기 - 형변환이 가능한지여부에 따라 달라짐 
			if(contacts[index] instanceof CompanyContact) {
				//형변환
				CompanyContact contact = (CompanyContact) contacts[index];
				
				System.out.println("회사이름: >");
				String companyName = sc.nextLine();
				System.out.println("부서이름: >");
				String divName = sc.nextLine();
				System.out.println("직급: >");
				String job = sc.nextLine();
				
				contact.setName(ename);					//공통된 부분은 앞에서 처리할 수 있지만 오류가 생길 가능성이 있으니 마지막에 한꺼번에 처리한다.
				contact.setPhoneNumber(phoneNumber);		
				contact.setEmail(email);
				contact.setAdress(adress);
				contact.setBirthday(birthday);
				contact.setGroup(group);
				contact.setCompanyName(companyName);
				contact.setDivName(divName);
				contact.setJob(job);
				
			}else { //CustomerContact
				CustomerContact contact = (CustomerContact) contacts[index];
				
				System.out.println("거래처이름: >");
				String companyName = sc.nextLine();
				System.out.println("거래품목: >");
				String product = sc.nextLine();
				System.out.println("직급: >");
				String job = sc.nextLine();
				
				contact.setName(ename);
				contact.setPhoneNumber(phoneNumber);
				contact.setEmail(email);
				contact.setAdress(adress);
				contact.setBirthday(birthday);
				contact.setGroup(group);
				contact.setCompanyName(companyName);
				contact.setProduct(product);
				contact.setJob(job);
				
			}
					
			System.out.println(name+"의 데이터가 수정되었습니다.");
		}
	}
	
	
}
