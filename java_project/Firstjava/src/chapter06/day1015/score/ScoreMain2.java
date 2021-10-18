package chapter06.day1015.score;

public class ScoreMain2 {
	public static void main(String[] args) {
		
		ScoreManager manager = new ScoreManager();
		//사용자가 Student 데이터를 입력해야한다
		//사용자가 데이터입력/검색/출력/삭제/프로그램종료 를 선택한다!
		
		while (true) {
			
			
			showMenu();
			
			int userChoice =Integer.parseInt( ScoreManager.sc.nextLine());//인티저는 버퍼때문에 오류생길수있어서 라인씀
			
			switch(userChoice) {
				case 1: 
					System.out.println("점수데이터를 입력합니다.");
					//점수입력기능
					manager.insertStudent();
					break;
				case 2: 
					System.out.println("점수데이터를 출력합니다.");
					manager.showAllData();
					break;
				case 3: 
					System.out.println("학생정보를 검색합니다.");
					manager.searchData();
					break;
				case 4: 
					System.out.println("학생정보를 삭제합니다.");
					manager.deleteScore();
					break;
				case 5: System.out.println("프로그램을 종료합니다.");
					return;//리턴은 메소드를 종료를 시킨다.(현 리턴은 메인메소드
			}
		}
		
	}
	public static void showMenu() {
		System.out.println("시험점수 관리 프로그램");
		System.out.println("------------------------");
		System.out.println("1.학생점수데이터 입력");
		System.out.println("2.전체데이터 출력");
		System.out.println("3.학생점수 검색");
		System.out.println("4.학생점수 삭제");
		System.out.println("5.프로그램 종료");
		
		System.out.println("------------------------");
		System.out.println("메뉴번호를 입력해주세요>>>>>");
	}
	
	
}
