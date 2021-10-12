package chpater01;

public class Calculator {
	/*
	Calculator 클래스를 정의해 봅시다. 
	① 숫자 두 개를 매개변수의 인자로 전달받아 더하기 메소드를 추가합시다.
	② 숫자 두 개를 매개변수의 인자로 전달받아 빼기 메소드를 추가합시다.
	③ 숫자 두 개를 매개변수의 인자로 전달받아 곱하기 메소드를 추가합시다.
	④ 숫자 두 개를 매개변수의 인자로 전달받아 나누기 메소드를 추가합시다
	*/
	
	
	// ① 숫자 두 개를 매개변수의 인자로 전달받아 더하기 메소드를 추가합시다.
	// 데이터반환: 숫자 두개를 더하기 연산한 결과를 반환
	// 매개변수: 숫자 두 개를 매개변수의 인자로 전달받아 -> int num, int num2
	// num1+num2 => int
	int add(int num1, int num2) {
		return num1 + num2;
	}
	
	// ② 숫자 두 개를 매개변수의 인자로 전달받아 빼기 메소드를 추가합시다.
	// 매개변수 : 
	//숫자 두 개를 매개변수의 인자로 전달받아
	//num1 - num2 => int
	int minus(int num1, int num2) {
		return num1-num2;
	}
	
	// ③ 숫자 두 개를 매개변수의 인자로 전달받아 곱하기 메소드를 추가합시다.
	// 곱하기의경우,
	// 매개변수: 숫자 두 개를 매개변수의 인자로 전달받아 =>long num1, long num2
	// int * int => int, (long)int * int => 22억 //숏이나 바이트는 자동으로 int로 변환해서계산할수있음
	// long * int = long //원래 int가맞다
	long multiply(long num1, long num2) {
		return num1*num2; //결과는int   
	}
	
	//④ 숫자 두 개를
	//매개변수의 인자로 전달받아 나누기 메소드를 추가합시다
	//int/int
	//devide(1,2)>첫번쨰것
	//devide(1.5,2.0)>두번쨰것
	//메소드의 오버로딩은 메소드의 호출시에 정해진다!
	int devide(int num1, int num2) {
		return num1/num2;
	}
	
	//오버로딩 : 메소드의 이름이 같은 메소드를 정의
	//오버로딩의 조건: 이름은 같다, 매개변수의 개수 또는 매개변수의 타입이 달라야한다, 반환타입은 의미없다!
	float devide(float num1, float num2) {
		return num1/num2;
	}
	
	public static void main(String[] args) {
		// 클래스의 정의된 메소드의 사용 -> 믈래스를 이용해서 인스턴스(객체)를 생성
		// 클래스의 멤버(변수, 메소드)들이 메모시레 로드된다!
		// 객체생성 : new 믈래스이름() => 참조값(객체의 메모리 주소값) new>인스턴스생성(객체) > 주소값을반환 >변수에(참조변수)에 저장 /클래스이름 =생성자초기화
		//참조변수: 객체의 주소값을 저장하는 변수
		// 클래스이름 변수이름
		Calculator cal = new Calculator();
		
		System.out.println("더하기메소드호출");
		System.out.println("1+2="+cal.add(1,2)); //ctrl 마우스포인트 > 메소드 찾아간다.
		System.out.println("빼기메소드호출");
		System.out.println("20-10="+cal.minus(20, 10));
		System.out.println("곱하기메소드호출");
		System.out.println("1000000*1000000="+cal.multiply(1000000, 1000000));
		//답도
		System.out.println("정수나누기메소드호츌");
		 System.out.println("10/3="+cal.devide(10,3));
		 System.out.println("실순나두기 메소드호출");
		System.out.println("10.0/3.0="+cal.devide(10.0f, 3.0f));
		//정수의 기본타입은 itn
		//실수이ㅢ 기본 타입은 >doublid
		
				//10.060.dpubi
		
		
	}
	
}
