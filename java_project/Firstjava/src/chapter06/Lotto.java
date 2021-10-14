package chapter06;

public class Lotto {
public static void main(String[] args) {
	
	//1부터 45까지의 숫자를 저장할 수 있는 배열을 생성
	int[] ball = new int[45];
	
	//각 배열의 요소에 1~45까지의 숫자를 저장
	for(int i =0; i<ball.length; i++) {
		//각 요소에 값을 저장
		ball[i] = i+1; //(0번지에 1)
	}
	//출력
  	for( int i =0; i<ball.length; i++) {
  		System.out.println(ball[i]);
  	}
	
  	System.out.println("-------------섞기--------");
  	
	//자리바꾸기
	//임시변수(빈잔) : 0번지의 값을 저장
	int temp = ball[0];//그냥 0이라고 해도 좋음
	
	for(int i = 0; i < 10000; i++) { //만번돌림

		//랜덤한 index(정수)를 뽑아야함. -> 1~44(0은 어차피 있으니까)
		int index = (int)(Math.random()*44)+1; // 0.0<= r <1.0 ->43.99999999999 -> 43.0 + 1 -> 44.0 -> 형변환으로 정수만나옴
		
		temp = ball[0]; //temp(빈잔)에 콜라넣기
		ball[0] = ball[index];
		ball[index] = temp;
	}
	
	//배열의 모든 요소 0~5 출력
	for( int i =0; i<6; i++) {
 		System.out.println(ball[i]);
 	}
	
	
	
}
}
