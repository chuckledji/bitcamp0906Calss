package chapter13;

public class AccessThread extends Thread{
	
	IHaveTwoNum twoNum;	//= new IHave~해도 되지만 너무 의존형되는 것이라 안할것
	
	public AccessThread(IHaveTwoNum twoNum) {
		this.twoNum = twoNum;
	}
	@Override
	public void run() {
		twoNum.addOneNum1();	//num1
		twoNum.addOneNum1();	//num1
		
		twoNum.addOneNum2();	//num2
		twoNum.addOneNum2();	//num2
		
	}
	
	
	
}
