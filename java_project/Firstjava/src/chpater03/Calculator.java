package chpater03;

import java.util.Scanner;

public class Calculator {
	/*
	Calculator 클래스를 정의해봅시다. 
	① 정수 두 개를 매개변수의 인자로 전달받아 더하기연산 후 출력하는 메소드를 정의
	② 정수 두 개를 매개변수의 인자로 전달받아 빼기연산 후 출력하는 메소드를 정의
	③ 정수 두 개를 매개변수의 인자로 전달받아 곱하기연산 후 출력하는 메소드를 정의
	④ 정수 두 개를 매개변수의 인자로 전달받아 나누기연산 후 출력하는 메소드를 정의
	//
	⑤ 실수 반지름 하나를 매개변수의 인자로 전달받아 원의 둘레를 구해 반환하는 메소드를 반환하는 메소드를 정의
	⑥ 실수 반지름 하나를 매개변수의 인자로 전달받아 원의 넓이를 구해 반환하는 메소드를 반환하는 메소드를 정의
	원의 둘레 : 2 x π x r , 월의 넓이 : π x r x r
	⑦ main() 메소드를 정의하고 각각의 메소드를 호출해서 결과를 콘솔에 출력해봅시다.
	⑧ 콘솔에서 사용자에게 데이터를 받아 메소드를 호출할 때 사용자에게 받은 데이터를 메소드의 매개변수의 인자로 전달하는 코드를 main() 메소드
	에 추가해봅시다.
	*/
	
	//final :
	//변수 앞에=>상수  /또는 클래스 앞에 사용=> 상속의 대상이 아니다. 
	//java에서 상수 : 변수에 최초 초기화된 값을 바꾸지 못한다!
	final float  PI = 3.1415f; //최초대입 = 초기화. 
	final String USER_NAME;

	
	
	//생성자: 초기화메소드, 메소드 구조와 유사 반환기능X
	//클래스이름(){}
	Calculator (String name) {
		USER_NAME = name;
	}
	//생성자를 통해서 초기화할수도 있다. new Calculator("손"); ->하고나면 이제 이 값은 바뀌지 않는다.
	
	
	public void add(int num1, int num2) {
		long result = (long)num1-num2;
		System.out.println(num1+"-"+num2+"=" + result);
//		System.out.println(num1+"-"+num2+"=" +( num1+num2))
		//이항연산의 방향! 괄호다음의 nunm1까지 문자열로 처리가 된다. 그래서 괄호로 묶어줘야함.
	}
	public void minus(int num1, int num2) {
		long result = (long)num1-num2;
		System.out.println(num1+"-"+num2+"=" + result);
	}
	public void multiply(int num1, int num2) {
		long result = (long)num1*num2;
		System.out.println(num1+"*"+num2+"=" + result);
	}
	public void devide(int num1, int num2) {
		long result = (long)num1/num2;
		System.out.println(num1+"/"+num2+"=" + result);
	}
//	⑤ 실수 반지름 하나를 매개변수의 인자로 전달받아 원의 둘레를 구해 반환하는 메소드를 반환하는 메소드를 정의
//	⑥ 실수 반지름 하나를 매개변수의 인자로 전달받아 원의 넓이를 구해 반환하는 메소드를 반환하는 메소드를 정의
//	원의 둘레 : 2 x π x r , 월의 넓이 : π x r x r
	public float circleLength(float r) {
		return 2 * PI * r;
	}
	public float circleWidth(float r) {
		return PI * r * r;
	}
	
//	⑦ main() 메소드를 정의하고 각각의 메소드를 호출해서 결과를 콘솔에 출력해봅시다.

	public static void main(String[] args) {
		Calculator cal = new Calculator("손흥민");
		
		//상수출력
		System.out.println("PI:" + cal.PI);
		System.out.println("User Name+"+cal.USER_NAME);
		System.out.println();
		//cal.USER_NAME = "이강인"; //상수 값 변경은 안됨
		cal.add(10,30);
	
	
//	⑧ 콘솔에서 사용자에게 데이터를 받아 메소드를 호출할 때 사용자에게 받은 데이터를 메소드의 매개변수의 인자로 전달하는 코드를 main() 메소드에 추가해봅시다.
	Scanner scanner = new Scanner(System.in);
	System.out.println("덧셈을 시작합니다,\n숫자1을 입력해주세요");
	int num1 = Integer.parseInt(scanner.nextLine());
	//System.out.println(num1);
	System.out.println("숫자2를 입력해주세요");
	int num2 = Integer.parseInt(scanner.nextLine());
	cal.add(num1, num2);
	
	System.out.println("--------------------------");
	System.out.println("원의 둘레와 넓이를 구합니다.\n반지름을 입력해주세요");
	float r =Float.parseFloat(scanner.nextLine());
	
	System.out.println("전달받은 반지름:"+r);
	System.out.println("원의 둘레:"+ cal.circleLength(r));
	System.out.println("원의 넓이:"+ cal.circleWidth(r));
	
	}
}
