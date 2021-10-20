package chapter10.test;

import java.util.InputMismatchException;
import java.util.Scanner;

//1.콘솔에서 사용자 아이디를 입력 받아 정상적인 영문자와 숫자로만 이루어진 값을 입력했는지 확인하는 프로그램을 만들어봅시다.
//①사용자 예외 클래스를 정의해서 예외를 발생 시켜 봅시다.
//②예외 클래스 이름은 BadIdInputException이라고 정의합시다.

//2.Scanner 클래스로 태어난 년도를 입력 받을 때 int 타입으로 받도록 합시다. 이때 nextInt() 메소드를 사용하게 되는데 이때 발생하는 예외처리를 하도록 합시다.

public class member {
//	String id;
//	String name;
//	int birthYear;
	
	final static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("아이디를 입력해주세요.");
		
		try {
			String id = getId();
			System.out.println("입력하신 아이디는 "+id+"입니다.");
		}catch(BadIdInputException e) {
			System.out.println(e.getMessage());
			e.print();
		}
		
		
		int birthYear = 0;
		boolean badYear = !(birthYear >1900 && birthYear <2022);

		System.out.println("생년 네자리를 입력해주세요.");
		
		try {
			birthYear =getBirthYear();
			System.out.println("입력하신 생년은 "+birthYear+"입니다.");
		}catch(InputMismatchException e) {
			System.out.println("1900년 이후~2021사이 숫자만 입력해주세요");
			e.getMessage();
		}
		
		
		
	}
	
	//사용자의 아이디를 입력받아 반환하는 메소드
	public static String getId() throws BadIdInputException{
		
		String id = sc.nextLine();
		
		if(!id.matches("^[a-zA-Z0-9]*$")) {
			//예외객체생성
			BadIdInputException e = new BadIdInputException();
			throw e;
		}
		return id;
	}
	
	public static int getBirthYear() {
		int birthYear = sc.nextInt();
		//생년이 오류일 때 : 1900년 이후~2021사이 의 반대
		if(!(birthYear >1900 && birthYear <2022)) {
			InputMismatchException b = new InputMismatchException();
			throw b;
		}
		return birthYear;
	}
	
	
}
