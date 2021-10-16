package project01;

import java.util.Scanner;

public class Member {
	public static final Scanner scanner = new Scanner(System.in);
	
	
	//캡슐화처리
	private String name;
	private String phone;
	private String email;
	private String adress;
	private String birthday;
	private String group;
	
	//getter/setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	
	
	//생성자
	Member(){}
	
	public Member(String name, String phone, String email, String adress, String birthday, String group) {
		
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.adress = adress;
		this.birthday = birthday;
		this.group = group;
	}
	//입력 - 데이터저장
		public void insertInfo() {
			
			
			System.out.println("이름을 입력해주세요.");
			System.out.println("> ");
			this.setName(scanner.nextLine());
			
			System.out.println("전화번호를 입력해주세요.");
			System.out.println("> ");
			this.setPhone(scanner.nextLine());
			
			System.out.println("이메일을 입력해주세요.");
			System.out.println("> ");
			this.setEmail(scanner.nextLine());
			
			System.out.println("주소를 입력해주세요.");
			System.out.println("> ");
			this.setAdress(scanner.nextLine());
			
			System.out.println("생일을 입력해주세요.");
			System.out.println("> ");
			this.setBirthday(scanner.nextLine());
			
			System.out.println("그룹을 입력해주세요.");
			System.out.println("> ");
			this.setGroup(scanner.nextLine());
			
			System.out.println("입력 완료.");
			
			
		}
		
		
		//출력
		public void printList1() {
			System.out.println("----------------------------");
			System.out.println("이름 :" + this.getName());
			System.out.println("전화번호 :" + this.getPhone());
			System.out.println("이메일 :" + this.getEmail());
			System.out.println("주소 :" + this.getAdress());
			System.out.println("생일 :" + this.getBirthday());
			System.out.println("그룹 :" + this.getGroup());
			System.out.println("----------------------------");
		}
		
		//수정
		public void update () {
			System.out.println("----------------------------");
			System.out.println("새로운 정보를 입력합니다.");
			insertInfo();
			System.out.println("정보 수정 완료.");
			System.out.println("----------------------------");
			printList1();
		}
		
	public static void main(String[] args) {
		
		Member mem = new Member();
		
		mem.insertInfo();
		mem.printList1();
		mem.update();
		scanner.close();	
	}
}
