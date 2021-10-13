package project01;

import java.util.Scanner;

public class Member {
	
	Scanner scanner = new Scanner(System.in);
	
	
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
	
	//기본생성자
	Member(){}
	
	//매개변수 있는 생성자
	Member(Scanner scanner, String name, String phone, String email, String adress, String birthday,
			String group) {
		
		this.scanner = scanner;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.adress = adress;
		this.birthday = birthday;
		this.group = group;
	}
	
	//연락처를 받고 반환하는 메소드
		private String insertName() {
			System.out.println("이름을 입력해주세요.");
			System.out.println("> ");
			setName(scanner.nextLine());
		return name;	
		}
		private String insertPhone() {
			System.out.println("전화번호를 입력해주세요.");
			System.out.println("> ");
			setPhone(scanner.nextLine());
		return phone;
		}
		private String email() {
			System.out.println("이메일을 입력해주세요.");
			System.out.println("> ");
			setEmail(scanner.nextLine());
		return email;
		}
		private String adress() {
			System.out.println("주소를 입력해주세요.");
			System.out.println("> ");
			setAdress(scanner.nextLine());
		return adress;
		}
		private String birthday() {
			System.out.println("생일을 입력해주세요.");
			System.out.println("> ");
			setBirthday(scanner.nextLine());
		return birthday;
		}
		private String group() {
			System.out.println("그룹을 입력해주세요.");
			System.out.println("> ");
			setGroup(scanner.nextLine());
		return group;			
		}
		
		
		//저장된 정보를 출력하는 메소드(변수값을 반환하는 메소드호출해서)
		private void printList1() {
			Member mem = new Member();
			System.out.println("이름 :" + mem.getName());
			System.out.println("전화번호 :" + mem.getPhone());
			System.out.println("이메일 :" + mem.getEmail());
			System.out.println("주소 :" + mem.getAdress());
			System.out.println("생일 :" + mem.getBirthday());
			System.out.println("그룹 :" + mem.getGroup());
		}
		
		
	
	
	
	
	
}
