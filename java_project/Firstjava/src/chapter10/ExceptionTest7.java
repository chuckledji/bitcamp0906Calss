package chapter10;

import java.util.Scanner;

public class ExceptionTest7 {
	
	public static void main(String[] args) {
			
		System.out.println("나이를 입력해주세요.");
		
		try {
			int age = getAge(); //예외 발생 포인트
			System.out.println("나이는 "+age+"세 입니다.");
		}catch(AgelInputException e) {
			System.out.println(e.getMessage());  //예외를 상위타입으로해도 이 메세지는 오버라이딩 된 것이라 출력된다.
			//e.printStackTrace();
			e.print();
		}
		System.out.println("프로그램을 종료합니다.");
	}
	// 사용자의 나이를 입력받아 반환하는 메소드
	public static int getAge() throws AgelInputException {
		//throws AgelInputException
		//메소드 내부에서 throws AgelInputException예외가 발생하면
		//내부에서 처리하지 않고 호출한 메소드로 예외 객체를 던진다(전달, throw)
		
		int age =0; //디폴트값
		
		// 핵심처리하고 age값을 대입한다.
		Scanner sc = new Scanner(System.in);
		age = sc.nextInt();
		
		if(age < 0) {					//음수를 입력하면 예외처리를한다
			//1.예외객체 생성
			//AgelInputException e = new AgelInputException();
			AgelInputException e =new AgelInputException(age);
			//2.예외 발생
			throw e;
		}
		
		return age;
	}
}
