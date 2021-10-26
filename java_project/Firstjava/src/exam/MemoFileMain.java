package exam;

import java.io.File;
import java.io.IOException;

public class MemoFileMain {

	public static void main(String[] args) throws IOException {
		
		MemoFile m = new MemoFile(); 
		
		//폴더생성 - File클래스이용
		File newDir = new File("c:\\ExamMemo");
		if(!newDir.exists()) {
			newDir.mkdir();
			System.out.println("c:\\ExamMemo 폴더 생성완료.");
		}
		
		while(true) {
			System.out.println("<메모장 입력 프로그램>");
			System.out.println("1.메모장목록보기");
			System.out.println("2.메모장읽기");
			System.out.println("3.메모장등록");
			System.out.println("4.프로그램종료");
			System.out.println("메뉴를 선택하세요 > ");
			
			int userChoice = Integer.parseInt(m.scanner.nextLine());
			
			switch(userChoice) {
			case 1:
				m.printMemoList();
				break;
			case 2:
				m.findMemoName();
				break;
			case 3:
				m.writeMemo();
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
}
