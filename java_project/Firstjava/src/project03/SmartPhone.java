package project03;

//3.SmartPhone 클래스의 배열을 다형성의 특징을 이용해서
//상위타입의 배열을 생성,
//하위클래스의 인스턴스를 저장하는형태로 프로그램을 작성

import java.util.Scanner;

public class SmartPhone {
	//연락처 정보 관리하는 클래스
	public static final Scanner scanner = new Scanner(System.in);
	//배열-10개
	
	private Contact[] con;
	private int numOfUser;
	
	public SmartPhone(int size) {
		con = new Contact[size];
		numOfUser =0;
	}
	public SmartPhone() {
		this(10);
	}
	
	void addContactInfo(Contact c) {
		con[numOfUser++] =c;
	}
	
	
	//-저장(입력받아서)
	public void insertInfo(int userChoice) {
		
		System.out.println("---------------------------");
			System.out.println("이름을 입력해주세요.");
			String name= scanner.nextLine();
			
			System.out.println("전화번호를 입력해주세요.");
			String phone=scanner.nextLine();
			
			System.out.println("이메일을 입력해주세요.");
			String email =scanner.nextLine();
			
			System.out.println("주소를 입력해주세요.");
			String adress =scanner.nextLine();
			
			System.out.println("생일을 입력해주세요.");
			String birthday=scanner.nextLine();
			
			System.out.println("그룹을 입력해주세요.");
			String group=scanner.nextLine();
			
			if(userChoice ==1) {
				//회사정보입력
				System.out.println("회사이름을 입력하세요.");
				String compName = scanner.nextLine();
				System.out.println("부서를 입력하세요.");
				String department = scanner.nextLine();
				System.out.println("직급을 입력하세요.");
				String position = scanner.nextLine();

				addContactInfo(new CompanyContact(name, phone,email,adress,birthday,group,compName,department,position)); 
			}else {
				System.out.println("거래처회사 이름을 입력하세요.");
				String customerCompName = scanner.nextLine();
				System.out.println("거래품목을 입력하세요.");
				String item = scanner.nextLine();
				System.out.println("직급을 입력하세요.");
				String position = scanner.nextLine();

				addContactInfo(new CustomerContact(name, phone,email,adress,birthday,group,customerCompName,item,position));
			}
			
			
			System.out.println("입력 완료");
			
			System.out.println("---------------------------");
			
			//
			//입력한 정보 출력
			
			
		
	}
	//-삭제 : 이름검색으로
	public void delete() {
		//이름입력
		System.out.println("---------------------------");
		System.out.println("삭제하려는 사용자의 이름을 입력해주세요.");
		String searchName = scanner.nextLine();
		
		for(int i = 0; i<numOfUser; i++) {
			//검색한 이름이 같으면
			if( searchName.equals(con[i].getName())) {
				//시프트
				for(int j=i; j<numOfUser-1; j++ ) {
					con[j] = con [j+1];
				}
				System.out.println("사용자의 데이터가 삭제되었습니다.");
				numOfUser--;
				System.out.println("---------------------------");
			}else {
				System.out.println("검색한 사용자의 데이터가 존재하지 않습니다.");
				System.out.println("---------------------------");
			}
		}
	}
	
		
	
	//-수정 : 이름검색으로
	public void update() {
		//이름입력
		System.out.println("---------------------------");
		
		System.out.println("수정하려는 사용자의 구분을 입력해주세요. 1)회사 2)거래처");
		int userChoice = scanner.nextInt();
		scanner.nextLine();
		System.out.println("수정하려는 사용자의 이름을 입력해주세요.");
		String searchName = scanner.nextLine();
		
		for(int i = 0; i<numOfUser; i++) {
			//검색한 이름이 같으면
			if(searchName.equals(con[i].getName())) {
				//시프트
				
				System.out.println("데이터 수정을 위한 입력을 시작합니다.");
				numOfUser--;
				insertInfo(userChoice);
				System.out.println("사용자의 데이터가 수정되었습니다.");
				System.out.println("---------------------------");
				System.out.println(con[i]);
			}else {
				System.out.println("검색한 사용자의 데이터가 존재하지 않습니다.");
				System.out.println("---------------------------");
			}
		}
	}
	//-출력 : 모든정보출력
	public void printAll() {
		System.out.println("---------------------------");
		System.out.println("모든 정보를 출력합니다.");
		System.out.println("---------------------------");
		for(int i =0; i<numOfUser; i++) {
			con[i].printOne();;
		}
		System.out.println("---------------------------");
		
	}
}
