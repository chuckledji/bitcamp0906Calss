package chapter7_day1018.friend;

public class ClassPrinter {
	public static void print(Object obj) {
		//전달받은 객체의 toString()출력
		String str = obj.toString();
		
		//해당 객체가UpperCasePrintable을 구현하고잇는지 체크
		//구현하고 있다면 대분자로 출력을한다.
		if(obj instanceof UpperCasePrintable) {
			str = str.toUpperCase();
		}
		System.out.println(str);
	}
}
