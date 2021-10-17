package project02;

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
		Member m = new Member();
		System.out.println("---------------------------");
			System.out.println("이름을 입력해주세요.");
			System.out.println("> ");
			m.setName(scanner.nextLine());
			
			System.out.println("전화번호를 입력해주세요.");
			System.out.println("> ");
			m.setPhone(scanner.nextLine());
			
			System.out.println("이메일을 입력해주세요.");
			System.out.println("> ");
			m.setEmail(scanner.nextLine());
			
			System.out.println("주소를 입력해주세요.");
			System.out.println("> ");
			m.setAdress(scanner.nextLine());
			
			System.out.println("생일을 입력해주세요.");
			System.out.println("> ");
			m.setBirthday(scanner.nextLine());
			
			System.out.println("그룹을 입력해주세요.");
			System.out.println("> ");
			m.setGroup(scanner.nextLine());
			
			System.out.println("입력 완료");
			
			System.out.println("---------------------------");
			
			mem[numOfUser++] = new Member(m.getName(), m.getPhone(), m.getEmail(), m.getAdress(), m.getBirthday(), m.getGroup());//
			//입력한 정보 출력
			
			m.printOne(m);
		
	}
	//-삭제 : 이름검색으로
	public void delete() {
		//이름입력
		System.out.println("---------------------------");
		System.out.println("삭제하려는 사용자의 이름을 입력해주세요.");
		String searchName = scanner.nextLine();
		
		for(int i = 0; i<numOfUser; i++) {
			//검색한 이름이 같으면
			if( searchName == mem[i].getName()) {
				//시프트
				for(int j=-1; j<numOfUser-1; j++ ) {
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
		//이름입력
		System.out.println("---------------------------");
		System.out.println("수정하려는 사용자의 이름을 입력해주세요.");
		String searchName = scanner.nextLine();
		
		for(int i = 0; i<numOfUser; i++) {
			//검색한 이름이 같으면
			if( searchName == mem[i].getName()) {
				//시프트
				System.out.println("데이터 수정을 위한 입력을 시작합니다.");
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
		System.out.println("정보 리스트를 출력합니다.");
		System.out.println("---------------------------");
		System.out.println("이름 \t 전화번호\t 이메일\t 주소\t 생일\t 그룹");
		System.out.println("---------------------------");
		for(int i =0; i<numOfUser; i++) {
			System.out.println(mem[i]);
		}
		System.out.println("---------------------------");
		
	}
}
