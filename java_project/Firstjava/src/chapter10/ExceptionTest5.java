package chapter10;


import java.util.Scanner;

public class ExceptionTest5 {
	
	public static void main(String[] args) {
		
		try{
			System.out.println(10/2);
			return;
		}catch(Exception e) {
			System.out.println("예외가 발생된 경우입니다. => 예외처리를 했습니다.");
		}finally {
			System.out.println("finally: 예외상황과 상관없이 실행!");
		}
		
		
		
		try {								//위에 return이 있으면 여기는 실행되지 않는다.
			System.out.println("try");
		}finally {
			System.out.println("finally");	//catch없이도 쓸 수 있다!
		}
	}
}
