package chapter7_day1018.product;

public class Computer extends Product {

	public Computer(int price) {
		super(price);
	}
	
	@Override
	public String toString() {
		//toString() : Object클래스가 가지는 메소드
		//오버라이딩
		return"computer";
	}
}
