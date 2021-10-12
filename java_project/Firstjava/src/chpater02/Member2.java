package chpater02;

public class Member2 {
	
	String name;    //null, 이름을 저장하는 변수
	int age;        //사용자의 나이를 저장하는 변수
	double height;  //사용자의 키를 저장하는 변수
	boolean hasBook;//자바책 보유 여부를 저장하는 변수
	
	void printData() {
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
		System.out.println("키: " + height);
		System.out.println("자바 책 보유여부: " + hasBook);
	}
	
	public static void main(String[] args) {
		
		long jn = 9701011111111L; //literral해줘야 int가 long으로 변환됨.
		
		
	   Member2 member = new Member2();//참조하기위해서! 밑에member.age는 참조변수이다
	
		member.printData();		
		
		member.name = "정지원";
		member.age = 27;
		member.height = 169.7;
		member.hasBook = false;
				
		System.out.println();
		System.out.println("인스턴스변수의 값을 변경");
		System.out.println();
		

		member.printData();		
		
	}
	
	
	
}
