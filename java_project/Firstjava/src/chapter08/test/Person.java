package chapter08.test;

import java.util.Calendar;

//1.Person 이라는 클래스를 정의해봅시다.
//①이름을 저장하는 변수, 주민등록번호를 저장하는 변수를 정의해봅시다.
//②인사하는 메소드를 정의해봅시다. - “안녕하세요. 저는 OOO입니다. 00살 입니다.”라는 문자열이 출력하도록 정의합시다.

public class Person {
	Calendar cal = Calendar.getInstance();
	
	//변수 - 이름을 저장, 주민등록번호를 저장
	private String name;
	private String juminNum;
	
	
	//생성자
	
	public Person(String name, String juminNum) {
		this.name = name;
		this.juminNum = juminNum;
	}
	
	
	//메소드- 인사하는 메소드
	public void sayHi(){
		
		int year = cal.get(Calendar.YEAR);
		int oneCentury = 1900;
		//태어난연도구하기
		int birthyear = Integer.parseInt(juminNum.substring(0, 2));
		
		//2000년생을 구분하기 위한 성별숫자(00년생이후로는 성별구분이 3,4)
		int maleFemale = Integer.parseInt(juminNum.substring(7,8));
		
		//2000년생이후
		if(maleFemale ==3 || maleFemale ==4) {
			System.out.println("안녕하세요. 저는 "+name+"입니다. "+(birthyear-1)+"살 입니다.");
		}else {
			System.out.println("안녕하세요. 저는 "+name+"입니다. "+(year-(birthyear+oneCentury))+"살 입니다.");
		}
		
	}
	

	
	
	
	
	
}
