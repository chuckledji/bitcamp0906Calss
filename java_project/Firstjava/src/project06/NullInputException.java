package project06;

public class NullInputException extends Exception {
	public NullInputException() {
		super("공백이 포함된 입력값입니다.");
	}
}
