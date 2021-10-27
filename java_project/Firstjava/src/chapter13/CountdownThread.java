package chapter13;

public class CountdownThread extends Thread {

	@Override
	public void run() {
		
		for(int i=10; i>0; i--) {
			
			if(ThreadTest4.inputCheck) {
				System.out.println("데이터가 입력되어 카운트다운을 멈춥니다.");
				return;		//종료된다.
			}			
			System.out.println(i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("10초동안 입력이 없어 프로그램을 종료합니다.");
		System.exit(0);		//이건 왜 이거더라
	}
}
