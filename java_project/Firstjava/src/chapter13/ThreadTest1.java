package chapter13;

public class ThreadTest1 {

	public static void main(String[] args) {
		
		//스레드 인스턴스생성
		ShowThread t1 = new ShowThread("멋진스레드");
		ShowThread t2 = new ShowThread("          예쁜스레드");
		
		//스레드실행 : run()직접호출한경우 스레드환경(새로운작업)이 생성되지 않는다.
		t1.start();
		t2.start();
		
		for(int i=0; i<100;i++) {
			System.out.println("--------메인스레드");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
