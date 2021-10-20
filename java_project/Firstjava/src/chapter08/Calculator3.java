package chapter08;

//Calulator 인터페이스를 상속하는 인스턴스를 생성할 수 있는 클래스를 정의해봅시다.
public class Calculator3 implements Calculator{

	int n1;
	int n2;
	
	public Calculator2 (int n1, int n2) {
		this.n1 = n1;
		this.n2 = n2;
	}
	
	@Override
	public long add(long n1, long n2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long substract(long n1, long n2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long multiply(long n1, long n2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double divide(double n1, double n2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
