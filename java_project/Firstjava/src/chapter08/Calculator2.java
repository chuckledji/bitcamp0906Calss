package chapter08;

//Calulator 인터페이스를 상속하는 추상 클래스를 정의해봅시다.
public abstract class Calculator2 implements Calculator{
	
	
	
	public abstract long add(long n1, long n2); 
	public abstract long substract(long n1, long n2 ); 
	public abstract long multiply(long n1, long n2 ); 
	public abstract double divide(double n1, double n2 ); 
}
