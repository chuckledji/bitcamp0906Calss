package chapter10.test;

//아이디를 입력 받아 정상적인 영문자와 숫자로만 이루어진 값을 입력했는지
public class BadIdInputException extends Exception{
		
	public BadIdInputException() {
		super("유효하지 않은 아이디가 입력되었습니다.");
	}
	 public void print() {
		 System.out.println("예외 클래스에서 정의한 메소드입니다.");
	 }
}
