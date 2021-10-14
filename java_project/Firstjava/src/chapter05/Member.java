package chapter05;

public class Member {

//		1.Member 클래스에는 아래 요구사항에 맞는 변수와 메소드를 정의하고, main()메소드 에 해당 메소드를 호출해서 결과를 확인해보세요. 단 인스턴스의 생성은 생성자를 이용해서 초기화하는 코드를 작성해 봅시다.
//
//		①아래의 데이터를 저장 이름, 전화번호, 전공, 학년, email, 생일, 주소
//		//private : 클래스 내부의 멤버들만 엑세스가 가능하다!
	
		private String name;
		private String phoneNumber;//010-0100-0100
		private String major;
		private int grade;
		private String email;//AAA@gmail.com
		private String birthday;//20001020, 2000-10-20. 2000/10/20
								//20001020 % 10000 => 나머지1020 % 100 =>나머지20
		private String adress;
		
		//////////////////////////////////////////////////////////////////////
		//생성자
		public Member(String name, String phoneNumber, String major, int grade, String email, String birthday, String adress) {
			this.name = name;
			this.phoneNumber = phoneNumber;
			this.major = major;
			this.grade = grade;
			this.email = email;
			this.birthday = birthday;
			this.adress = adress;
		}
		public Member(String name, String phoneNumber, String major, int grade, String email) {
//			this.name = name;
//			this.phoneNumber = phoneNumber;
//			this.major = major;
//			this.grade = grade;
//			this.email = email;
			//this(name, phoneNumber, major, grade, email, null, null);
			this(name, phoneNumber, major, grade, email,"생일정보없음", "주소정보없음");
			
		}
		public Member() {}
		
		//////////////////////////////////////////////////////////////////////
//		 
//		②위에서 정의한 정보를 출력하는 메소드 정의
		public void showData() {
			System.out.println("이름: "+this.name);
			System.out.println("전화번호: "+this.phoneNumber);
			System.out.println("전공: " +this.major);
			System.out.println("학년: "+this.grade );
			System.out.println("이메일: "+this.email );
			System.out.println("생일: "+this.birthday );
			System.out.println("주소: "+this.adress );
			
			//if null
//			if(this.birthday == null) {//생일정보가없으면
//				System.out.println("생일: 생일정보없음" );
//			}else {	
//				System.out.println("생일: "+ this.birthday );
//			}
//			if(this.adress == null){ //주소정보가 없음
//				System.out.println("주소: 주소정보없음");
//			}
//			System.out.println("주소: "+this.adress );
//			
		}
//		③모든 정보를 저장하도록 하는 생성자와 생일과 주소는 저장하지 않을 수 있는 생성자를 정의
//		④main() 메소드에서 두 가지 생성자를 이용해서 인스턴스 생성하고 출력 메소드를 통해 저장된 데이터 출력
//	 
	
	
	
	
	
}
