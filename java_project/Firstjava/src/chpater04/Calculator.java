package chpater04;

import java.util.Calendar;
import java.util.Scanner;

public class Calculator {
	
	
	String name;
	int birthYear;
	int age;
	
	// shft alt s
	
	//이름데이터를 받아서 초기화하는 생성자
	Calculator(String name, int birthyear){
		this.name = name;
		this.birthYear = birthyear;
		age =ageCal(birthyear);//밑에 메소드를 받아서 사용할 수 있다
	}
	

	Calculator(int year){
		//age = ageCal(year);
		this(null,year);
	}
	//기본생성자
	Calculator(){}
	
	
	//shft alt s using field에서 코드 만듦
//	public Calculator(String name, int birthYear, int age) {
//		
//		this.name = name;
//		this.birthYear = birthYear;
//		this.age = age;
//	}
	
	
	Scanner scanner = new Scanner(System.in);
	/*
	 * ① 독감예방 접종이 가능한지 여부를 확인하는 메소드를 정의합니다.
	- 매개변수로 태어난 해(년도)를 전달받습니다.
	- 15세 미만의 경우와 65세 이상의 경우 “무료예방접종이 가능합니다.” 메시지가 콘솔에 출력하도록 합니다.
	- 위에서 정의한 조건의 범위가 아닌 나머지의 경우 “무료접종 대상이 아닙니다.”라고 출력하도록 합니다.
	*/
	
	public void shot() {
		
		//int age = 2021- birthYear -1;
		
		boolean checkAge1 = age < 15 || age >= 65;
		boolean checkAge2 = !(age >=15&& age< 65); //이렇게 해서 하는 게 나을 때가 있다.
		//요구사항에 맞는 논리연산을 만드는 것이 중요한 것.
		
		if(checkAge1) {
			System.out.println("무료예방접종 대상입니다.");
		}else {
			System.out.println("무료예방접종 대상이 아닙니다.");
		}
		
	}
	
	
	
	
	
	/*
	② 건강검진 대상 여부를 판별하고 어떤 검진이 가능한지 확인하는 메소드를 정의합니다.
	- 매개변수로 태어난 해(년도)를 전달받습니다.
	- 대한민국 성인( 20세 )의 경우 무료로 2년마다 건강검진을 받을 수 있습니다.
	- 짝수 해에 태어난 사람은 올해가 짝수년이라면 검사 대상이 됩니다.
	- 40 이상의 경우는 암 검사도 무료로 검사를 할 수 있습니다.

	 */
	public void checkUp() {
		//int age = 2021 - birthYear -1;
		
		//올해년도
		int year = Calendar.getInstance().get(Calendar.YEAR);
		
		boolean checkUp = birthYear%2 == year%2; //태어난해가 짝수인 사람이 올해도 짝수면
		
		if(age>=20 && checkUp) {
			System.out.println("올해 무료검진 대상자입니다.");
			if(age>=40) {
				System.out.println("암검진도 가능한 대상자입니다.");
			}
		}else {
			System.out.println("올해 무료검진 대상자가 아닙니다.");
		}
	}

	// 나이 계산 후 반환 하는 메소드
		int ageCal(int year) {
			return Calendar.getInstance().get(Calendar.YEAR)-year-1;
		}
		
		
		public static void main(String[] args) {
			Calculator member = new Calculator("james", 1979);
			
			new Calculator();//인스턴스 생성한것
			new Calculator(1990);
			
			System.out.println("이름:"+member.name);
			member.shot();
			member.checkUp();
		}
	
	
}
