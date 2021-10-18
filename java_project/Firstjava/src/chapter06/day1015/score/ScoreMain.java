package chapter06.day1015.score;

public class ScoreMain {
	public static void main(String[] args) {
		//①Student 타입의 배열을 선언하고, 요소 10개를 저장할 수 있는 배열 인스턴스를 생성해 봅시다.
 		Student[] score = new Student[10];
 		
 		int numOfStudent = 0; // 입력된 학생의 수, 배열에 입력할 때 index로 사용
		
		//②Student 타입의 인스턴스를 생성하고 배열에 저장하는 코드를 정의해봅시다.
		Student s1 = new Student("손흥민", 100, 100, 100);
		//score[0] = s1;
		score[numOfStudent] = s1;
		numOfStudent++; //추가된 학생의 수를 +1증가
		
		Student s2 = new Student("이강인00", 100, 100, 100);
		score[numOfStudent] = s2;
		numOfStudent++; //추가된 학생의 수를 +1증가
				
		System.out.println(score[1]);
		
		//③배열에 저장된 Student 타입의 인스턴스의 메소드를 이용해서 모든 데이터를 출력해봅시다.
		for(int i=0; i<numOfStudent;i++) {
//			System.out.println(score[i].getScoreKor()+"\t"+score[i].getScoreEng()+"\t"+score[i].getScoreMath()+"\t"+score[i].getSum()+"\t"+score[i].getAvg());
			System.out.println(score[i]); // score[i].toString()으로 출력을 해준다.
		}
		
		// 데이터를 입력하면 =>배열에 저장을한다
		// 데이터를 검색하면 =>배열 요소(객체)에서 검색을한다
		// 데이터를 삭제하면 =>배열 요소를 삭제한다.
		
	}
}
