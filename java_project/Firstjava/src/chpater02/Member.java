package chpater02;

public class Member {
	// 변수 = 저장공간을 생성한다
	// 변수를 선언하면 저장공간(메모리의 저장공간)이 생기고 
	// 저장공간의 논리값주소가 생긴다
	// 변수를 선언하고 그 생긴 저장공간에 값을 입력하게 되는것
	// 입력하는 데이터에 따라서 저장공간을 구분하는 것이고 그래서 기본형타입이 존재.(정수실수문자논리)
	// 변수>메모리공간을 만들고 찾아갈 수 있는 주소>변수참고>읽고 쓰고하게되는 것
	// 정보하나저장 = 변수 / 타입에 구애받지않고 저장 = 클래스 / 같은타입을 저장 = 배열
	
	/*
	① String 타입의 이름을 저장할 수 있는 변수 name을 정의해봅시다.
	② int 타입의 나이를 저장할 수 있는 변수 age를 정의해봅시다.
	③ double 타입의 키를 저장할 수 있는 변수 height를 정의해봅시다.
	④ boolean 타입의 JAVA책의 보유 여부를 저장할 수 있는 변수 hasBook를 정의해봅시다.
	⑤ 이름과 나이, 키, 책의 보유 여부를 출력해봅시다.
	*/
	
	// 클래스 정의
	// [접근제어자] [final] 클래스 이름 {}
	// final = 상속이 안된다는 뜻. 
	// {
	//	 변수정의
	//	 메소드 정의
	// }
	// 인스턴스변수는 자동초기화
	// 인스턴스경우는 초기화하지않아도됨. 지역변수는 해야함.
	String name;    //null, 이름을 저장하는 변수
	int age;        //사용자의 나이를 저장하는 변수
	double height;  //사용자의 키를 저장하는 변수
	boolean hasBook;//자바책 보유 여부를 저장하는 변수
	
	//회원의 데이터를 출력하는 메소드
	void printData() {
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
		System.out.println("키: " + height);
		System.out.println("자바 책 보유여부: " + hasBook);
	}
	
	//⑤ 이름과 나이, 키, 책의 보유 여부를 출력해봅시다.
	public static void main(String[] args) {
		
		long jn = 9701011111111L; //literral해줘야 int가 long으로 변환됨.
		
		
		//Member 클래스로 인스턴스를 생성 -> 이름, 나이, 키, 책보유여부 저장할 수 있는 메모리공간을 생성
		Member member = new Member();//참조하기위해서! 밑에member.age는 참조변수이다
		
		//인스턴스의 변수를 참조해서 출력
//		System.out.println("이름: " + member.name);
//		System.out.println("나이: " + member.age);
//		System.out.println("키: " + member.height);
//		System.out.println("자바 책 보유여부: " + member.hasBook);
		
		member.printData();		
		
		// 인스턴스변수의 값을 변경
		member.name = "정지원";
		member.age = 27;
		member.height = 169.7;
		member.hasBook = false;
				
		System.out.println();
		System.out.println("인스턴스변수의 값을 변경");
		System.out.println();
		
//		System.out.println("이름: " + member.name);
//		System.out.println("나이: " + member.age);
//		System.out.println("키: " + member.height);
//		System.out.println("자바 책 보유여부: " + member.hasBook); //이렇게 중복되는 코드를 메소드로 정리해버리자!
		
		// 공통코드들 -> 메소드로 정의 => Member 클래스에서 메소드를 정의
		member.printData();		
		
	}
	
	
	
}
