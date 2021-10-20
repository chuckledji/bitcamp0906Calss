package chapter10;

import java.util.Scanner;

//try~catch문으로 오류잡
public class ExceptionTest2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("피제수를 입력해주세요");
		int num1 = sc.nextInt();
		
		System.out.println("제수를 입력해주세요");
		int num2 = sc.nextInt();
		
		try {
			System.out.println(num1/num2);
		}catch(ArithmeticException e) {				//하나의 try에 여러 catch를 넣을 수 있다.
			System.out.println("0으로 나눌 수 없습니다.");
			System.out.println(e.getMessage());
		}catch(Exception e) {						//상위타입의 익셉션은 맨 마지막에 넣는다.
			System.out.println("오류 발생");
		}
		
		System.out.println("프로그램을 종료합니다.");
		
		///////////////위에오류순서바꾸기////////////////////
//		
//		try {
//			System.out.println(num1/num2);
//		}catch(Exception e) {						//하나의 try에 여러 catch를 넣을 수 있다.
//			System.out.println("예외!!!");
//			System.out.println(e.getMessage());
//		}catch(ArithmeticException e) {				//상위타입의 익셉션이 위에서 다 거르므로 이곳까지 닿지않으므로 없애야한다고 뜬다.
//			System.out.println("오류 발생");
//		}
//		
//		System.out.println("프로그램을 종료합니다.");
//		
	}
}
