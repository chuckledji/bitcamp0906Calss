package chapter06.day1015.score;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 2021:10:20 배열을 ArrayList로변경
public class ScoreManager {
	
	public static final Scanner sc = new Scanner(System.in);
	
	
	private List<Student> score;

	//생성자
	public ScoreManager(int size) {
		
		score = new ArrayList<Student>(size);
	
		
	}

	
	public ScoreManager() {
		this(10);//열개만들어지도록
		
	}
	
	//전체데이터 출력 : 배열의 입력된 모든데이터 출력
	public void showAllData() {
		System.out.println("학생 점수 리스트");
		System.out.println("------------------------------------");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println("------------------------------------");
		
		for(Student s : score) {
			System.out.println(s);
		}
		System.out.println("------------------------------------");
	}
		
	//데이터추가 : 배열의 요소로 추가 => Student타입의 참조값
	//List에 요소 추가
	public void insertScore(Student s) {
		
		score.add(s);
		//score[numOfStudent++] = s;
		//score[numOfStudent] = s;
		//numOfStudent++;//원래 이렇게 했는데 그냥 위에 해도 된다
	}
	
	//데이터검색 : 이름기준검색 => 배열의 요소들 중 이름(검색어)을 비교
	public void searchData() {
		System.out.println("검색하고자하는 학생의 이름을 입력해주세요");
		String name = sc.nextLine();
		
		//-1또는 배열 범위 안의 정수 0~N-1
		int index = searchIndex(name);
		
		if(index>-1) {
			System.out.println(score.get(index));
		}else {
			System.out.println("검색하신 이름의 데이터가 존재하지 않습니다.");
		}
		
		
//		for(int i=0; i<numOfStudent; i++) {
//			//검색어와 요소 객체의 name 문자열을 비교해야한다
//			if(score[i].getName().equals(name)) {
//				System.out.println(score[i]);
//			}
//		}
	}
	//데이터삭제 : 이름기준삭제 
	//=> 배열에 요소에 손흥민의 정보를 지운다! =>손흥민 객체를 참조하는 값이 없으면 데이터가 없는것
	//배열의 요소는 변수임.그 변수를 가리키는 주소가 없으면 삭제된것
	public void deleteScore() {
		
		System.out.println("삭제하고자하는학생의 이름을 입력해주세요.");
		String name = sc.nextLine();
		
		
		int index = searchIndex(name);
		
		//시프트 = 참조값을지운다->정보삭제
		if(index >-1) {
			System.out.println("검색하진 이름의 데이터가 존재하지");
//			for(int i = index; i<numOfStudent-1; i++) {
//				score [i] = score[i+1];
//			}
//			numOfStudent--;//데이터가 사라졌으니 학생수도 줄어야하는것
			score.remove(index);
			System.out.println("데이터가 삭제되었습니다.");
		}else {
			System.out.println("검색한 이름의 데이터가 존재하지 않습니다.");
		}
		
		
		
//		for(int i=0; i<numOfStudent; i++) {
//			if(score[i].getName().equals(name)) {
//				
//				//쉬프트처리를한다(1번지삭제되면 2번지가 1번지로, 3번지가2번지로..)
//				for(int j=i; j<numOfStudent-1; j++) {
//					score[j]=score[j+1];
//				}
//				System.out.println("삭제되었습니다.");
//			}
//		}
	}
	
	//이름으로 배열의 index찾아 index값을 반환하는 메소드
	
	private int searchIndex(String name) {
		
		int index =-1;//찾는 이름이없으면 -1로 나감
		
		for(int i=0; i<numOfStudent; i++) {
			if(score[i].getName().equals(name)) {
				index =i;
				break;//이름을 찾으면 멈춤
			}
		}
		return index;
	}
	//
	public void insertStudent() {
		System.out.println("학생 데이터를 입력합니다.");
		
		System.out.println("이름>> ");
		String name = sc.nextLine();
		
		System.out.println("국어점수>>");
		int scoreKor = Integer.parseInt(sc.nextLine());
		
		System.out.println("영어점수>>");
		int scoreEng = Integer.parseInt(sc.nextLine());
		
		System.out.println("수학점수>>");
		int scoreMath = Integer.parseInt(sc.nextLine());
		
		//Student객체생성하고 배열에 저장한것.
		insertScore(new Student(name, scoreKor, scoreEng, scoreMath));
		System.out.println("성적데이터가 입력되었습니다.");
	}
	
}
