package chapter06.day1015.score;


public class ScoreMain1 {
	public static void main(String[] args) {
		
		
		ScoreManager manager = new ScoreManager(); //10개저장공간 생성
		
		//1.데이터저장
		manager.insertScore(new Student("사람1", 100, 100, 100));
		manager.insertScore(new Student("사람2", 30, 70, 100));
		manager.insertScore(new Student("사람3", 20, 80, 90));
		
		//2.데이터전체출력
		manager.showAllData();
		
		//3.데이터 검색(이름으로)
		manager.searchData();
		manager.searchData();
		
		//4.데이터 삭제(이름으로)
		manager.deleteScore();
		manager.deleteScore();
		
		//5.데이터검색 또는 데이터 전체출력(삭제한 것 잘 되었나)
		manager.showAllData();
	}
}
