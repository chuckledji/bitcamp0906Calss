package chapter10;

import java.util.Scanner;

public class ExceptionTest3 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("피제수를 입력해주세요");
		int num1 = sc.nextInt();
		
		System.out.println("제수를 입력해주세요");
		int num2 = sc.nextInt();
		
		int result =0; //결과는 블럭밖에 초기화
		
		try {
			result = num1 / num2;
			System.out.println("나눗셈이 정상적으로 처리되었습니다.");
			System.out.println("나눗셈의 결과는"+result+"입니다.");
			
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
			System.out.println(e.getMessage());
		}catch(Exception e) {						//상위타입의 익셉션은 맨 마지막에 넣는다.
			System.out.println("오류 발생");
		}
		
		
		
		System.out.println("프로그램을 종료합니다.");
		
	}
}
