package chapter7_day1018.speaker;

public class BaseEnSpeaker extends Speaker{
	
	//스피커클래스의 변수1과 메소드1,2가 들어왔을 것
	
	//변수2
	private int baseRate;
	
	//메소드3
	public void setBaseRate(int base) {
		baseRate=base;
}
	//오버라이딩
	//상위 클래스의 메소드의 선언부를 일치시키고
	//처리 부를 변경하는것
	
	//@에노테이션 - 추가적인 기능을 사용할때 쓴다.
	//@Override : 상위 클래스의 매소드를 오버라이딩한다, 오버라이딩의 규칙에 맞게 정의하는지 체크한다
	@Override
	public void showCurrentState() {
		super.showCurrentState();//상위클래스의 메소드를 호출
		System.out.println("베이스 크기"+baseRate);
	}
	
	public static void main(String[] args) {
		
		//1.
		BaseEnSpeaker bSpeaker = new BaseEnSpeaker();//강조-다형성
		bSpeaker.showCurrentState();
		
		System.out.println("----------------------");
		
		//2.
		Speaker speaker = new Speaker();
		speaker.showCurrentState();
		
		
		System.out.println("----------------------");
		
		//3.
		//다형성
		//상위 타입의 참조변수 = 하위타입의 인스턴스
		Speaker sp = new BaseEnSpeaker();//(하나의 타입으로 여러개를 받을 수 있는 것)
		
		sp.showCurrentState();
		//참조변수의 타입에 정의된 멤버만 사용이 가능하다.
		//타입을 Speaker로 선언하면 Speaker내의 변수나 메소드만 사용 가능하지만 오버라이딩 된 메소드는 호출 가능
		//sp.setBaseRate(100);메모리에는 있지만 타입에 있는 멤버가 아니므로 메소드를 쓸 수 없다.
		
	}
	
	
	
	
}
