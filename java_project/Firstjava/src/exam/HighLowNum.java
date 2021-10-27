package exam;


import javax.swing.JOptionPane;

//10초 안에 맞추는 하이로우게임

//1~100랜덤숫자추출
//숫자입력받아 추출된숫자와 비교. 높은숫자인지 낮은숫자인지 출력

//10초카운팅된다.

public class HighLowNum {

	static boolean answer = false;
	
	public static void main(String[] args) {
		
		
		
		//랜덤숫자추출
		int randomNum = (int)(Math.random()*101);
		
		//카운트다운시작
		System.out.println("카운트다운시작-30초 내로 숫자를 맞추세요.");
		HighLowCountdown t = new HighLowCountdown();
		t.start();
		
		while(true) {
			//사용자에게 입력받기
			String userNum = JOptionPane.showInputDialog("1~100 사이의 숫자 중 하나를 입력하세요");
			System.out.println("입력숫자: "+userNum);
			
			if(Integer.parseInt(userNum) == randomNum) {
				answer = true;
				System.out.println("정답입니다.");
				break;
			}else {
				answer = false;
				if(Integer.parseInt(userNum)< randomNum) {
					System.out.println("UP. 더 큰 수입니다.");
				}else {
					System.out.println("Down. 더 작은 수입니다.");
				}
			} 
		}
		
		
	}

	
	
	
	
	
}
