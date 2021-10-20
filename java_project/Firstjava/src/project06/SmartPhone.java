package project06;

import java.util.Scanner;

public class SmartPhone {
	//연락처 정보 관리하는 클래스
	public static final Scanner scanner = new Scanner(System.in);
	//배열-10개
	
	private Member[] mem;
	private int numOfUser;
	
	public SmartPhone(int size) {
		mem = new Member[size];
		numOfUser =0;
	}
	public SmartPhone() {
		this(10);
	}
	
	//-저장(입력받아서)
	public void insertInfo() {
		
		System.out.println("---------------------------");
			System.out.println("이름을 입력해주세요.");			//공백포함시 다시입력받는다.
			System.out.println("> ");
			String name= scanner.nextLine();
			while(name.indexOf(" ")>=0) {
				System.out.println("공백이 포함되어 있습니다. 다시 입력해주세요.");
				name= scanner.nextLine();
			}
			
			System.out.println("전화번호를 입력해주세요.");
			System.out.println("> ");
			String phone=scanner.nextLine();
			
			sameNum(phone);								//전화번호중복메소드
			
			System.out.println("이메일을 입력해주세요.");
			System.out.println("> ");
			String email =scanner.nextLine();
			while(email.indexOf(" ")>=0) {
				System.out.println("공백이 포함되어 있습니다. 다시 입력해주세요.");
				email= scanner.nextLine();
			}
			System.out.println("주소를 입력해주세요.");
			System.out.println("> ");
			String adress =scanner.nextLine();
			while(adress.indexOf(" ")>=0) {
				System.out.println("공백이 포함되어 있습니다. 다시 입력해주세요.");
				adress= scanner.nextLine();
			}
			System.out.println("생일을 입력해주세요.");
			System.out.println("> ");
			String birthday=scanner.nextLine();
			while( birthday.indexOf(" ")>=0) {
				System.out.println("공백이 포함되어 있습니다. 다시 입력해주세요.");
				 birthday= scanner.nextLine();
			}
			System.out.println("그룹을 입력해주세요.");
			System.out.println("> ");
			String group=scanner.nextLine();
			while(group.indexOf(" ")>=0) {
				System.out.println("공백이 포함되어 있습니다. 다시 입력해주세요.");
				group= scanner.nextLine();
			}
			System.out.println("입력 완료");
			
			System.out.println("---------------------------");
			
			mem[numOfUser++] = new Member(name, phone,email,adress,birthday,group);
			
	}
	
	//중복전화번호메소드
	private String sameNum(String phoneNumber) {
		for(int i =0; i<numOfUser; i++) {
			while(phoneNumber.equalsIgnoreCase(mem[i].getPhone())) {
				System.out.println("존재하는 전화번호입니다. 다시 입력해주세요.");
				phoneNumber = scanner.nextLine();
			}
		}
		return phoneNumber;
	}
	
	//-삭제 : 이름검색으로
	public void delete() {
		
		System.out.println("---------------------------");
		System.out.println("삭제하려는 사용자의 이름을 입력해주세요.");
		String searchName = scanner.nextLine();
		while(searchName.indexOf(" ")>=0) {
			System.out.println("공백이 포함되어 있습니다. 다시 입력해주세요.");	//공백포함시 다시입력받는다.
			searchName= scanner.nextLine();
			
		}
		
		for(int i = 0; i<numOfUser; i++) {
			if( searchName.equals(mem[i].getName())) {
				for(int j=i; j<numOfUser-1; j++ ) {
					mem[j] = mem [j+1];
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
		
		System.out.println("---------------------------");
		System.out.println("수정하려는 사용자의 이름을 입력해주세요.");
		String searchName = scanner.nextLine();
		while(searchName.indexOf(" ")>=0) {
			System.out.println("공백이 포함되어 있습니다. 다시 입력해주세요."); 	//공백포함시 다시입력받는다.
			searchName= scanner.nextLine();
			
		}
		for(int i = 0; i<numOfUser; i++) {
			if(searchName.equals(mem[i].getName())) {
				System.out.println("데이터 수정을 위한 입력을 시작합니다.");
				numOfUser--;
				insertInfo();
				System.out.println("사용자의 데이터가 수정되었습니다.");
				System.out.println("---------------------------");
				System.out.println(mem[i]);
			}else {
				System.out.println("검색한 사용자의 데이터가 존재하지 않습니다.");
				System.out.println("---------------------------");
			}
		}
	}
	//-출력 : 모든정보출력
	public void printAll() {
		System.out.println("---------------------------");
		System.out.println("이름 \t 전화번호\t 이메일\t 주소\t 생일\t 그룹");
		System.out.println("---------------------------");
		for(int i =0; i<numOfUser; i++) {
			System.out.println(mem[i]);
		}
		System.out.println("---------------------------");
		
	}
	
	
}
