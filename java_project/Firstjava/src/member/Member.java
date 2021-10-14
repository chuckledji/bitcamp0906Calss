package member;

public class Member {
	/*
	 * 1.Member 클래스에는 아래 요구사항에 맞는 변수와 메소드를 정의하고, main()메소드 에 해당 메소드를 호출해서 결과를 확인해보세요. 단 인스턴스의 생성은 생성자를 이용해서 초기화하는 코드를 작성해 봅시다.

		①아래의 데이터를 저장 이름, 전화번호, 전공, 학년, email, 생일, 주소
		②위에서 정의한 정보를 출력하는 메소드 정의
		③모든 정보를 저장하도록 하는 생성자와 생일과 주소는 저장하지 않을 수 있는 생성자를 정의
		④main() 메소드에서 두 가지 생성자를 이용해서 인스턴스 생성하고 출력 메소드를 통해 저장된 데이터 출력
	 */
	//①아래의 데이터를 저장 이름, 전화번호, 전공, 학년, email, 생일, 주소
	String name;
	String phone;
	String major;
	String grade;
	String email;
	String birthday;
	String adress;
	
	
	
//	②위에서 정의한 정보를 출력하는 메소드 정의
	//출력메소드
	public void printList() {
		
			System.out.println("이름: "+name);
			System.out.println("전화번호: "+phone);
			System.out.println("전공: "+major);
			System.out.println("학년: " +grade);
			System.out.println("이메일: "+email);
			
	}
	
	//상황에따른 출력메소드
	
	public void printInfo() {
		if(birthday == null && adress == null) {
			printList();
		}else {
			printList();
			System.out.println("생일: "+birthday);
			System.out.println("주소: "+adress);
		}
	}
	
//	③모든 정보를 저장하도록 하는 생성자와 생일과 주소는 저장하지 않을 수 있는 생성자를 정의
	Member(String name, String phone, String major, String grade, String email, String birthday, String adress) {
		
		this.name = name;
		this.phone = phone;
		this.major = major;
		this.grade = grade;
		this.email = email;
		this.birthday = birthday;
		this.adress = adress;
	}
	
	Member(String name, String phone, String major, String grade, String email) {
		
		this.name = name;
		this.phone = phone;
		this.major = major;
		this.grade = grade;
		this.email = email;
	}
	
	
//	④main() 메소드에서 두 가지 생성자를 이용해서 인스턴스 생성하고 출력 메소드를 통해 저장된 데이터 출력
	
	public static void main(String[] args) {
		//모두다
		Member mem1 = new Member("James","010-010-010","Philosophy","Junior","James@gmail.com","1990-05-05","NY State Univ.");
		mem1.printInfo();
		
		System.out.println("--------------------------");
		
		//생일과 주소빼고
		Member mem2 = new Member("James","010-010-010","Philosophy","Junior","James@gmail.com");
		mem2.printInfo();
	
	}

	
}
