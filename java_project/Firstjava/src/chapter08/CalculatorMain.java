package chapter08;

//3.다형성의 특징으로 상위 타입인 인터페이스 타입의 참조변수에 
//	인터페이스를 구현한 클래스 타입의 인스턴스를 참조하는 코드를 작성해 봅시다.
public class CalculatorMain {
	public static void main(String[] args) {
		Calculator cal = new Calculator3();
		
		cal.add(10,30);
		cal.substract(10,30);
		cal.multiply(10,30);
		cal.divide(10, 20);
		
	}
}
