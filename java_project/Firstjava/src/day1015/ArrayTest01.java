package day1015;

public class ArrayTest01 {
//국어 영어 수학 점수 10개씩 조정하는 배열을 정의하고 점수를(랜덤하게)모두 출력하고 평균점수를 출력하는 프로그램을 만들어 봅시다

	//총점변수
			
	//
	public static void main(String[] args) {
		
		//배열
		int[][] score = new int[10][3];
		
		int totalKorScore =0;
		
		
		
		
		//랜덤점수넣기
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; j++) {
				score[i][j] = (int) (Math.random() * 100) + 1;
				System.out.print(score[i][j]+"\t");
			}System.out.println();

		}
		
		
		
	}	
	
	
	
	
	
	
	
}