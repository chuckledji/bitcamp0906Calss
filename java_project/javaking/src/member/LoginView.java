package member;

import java.sql.Connection;
import java.util.Scanner;

public class LoginView {
	public static Scanner sc = new Scanner(System.in);
	LoginDao logDao = new LoginDao();
	public static String logId = null;
	
	//로그인한다
	public void login(Connection conn) {
		
		System.out.println("로그인을 시작합니다.");
		System.out.println();
		System.out.println("아이디를 입력하세요. >");
		String id = sameId(conn);
		System.out.println("비밀번호를 입력하세요. >");
		String pw = rightPw(conn, id);
		
		System.out.println("로그인 성공");
		logId = id;	//로그인에 성공한 아이디를 현 로그인상태 변수에 넣는다.
	}
	
	
	//일치하는 아이디 확인하는 메소드
	private String sameId(Connection conn) {
		String inputId = null;
		while(true) {
			inputId = sc.nextLine();
			
			int sameId = logDao.sameId(conn, inputId);
			if(sameId == 1) {
				break;	//존재하는 아이디가 맞으므로 while문에서 벗어난다.
			}else {
				System.out.println("존재하지 않는 아이디입니다. 다시 입력해주세요. >");
			}
		}return inputId;
	}
	
	//패스워드 일치하는지 확인하는 메소드
	private String rightPw(Connection conn, String id) {
		
		String inputPw = null;
		while(true) {
			inputPw = sc.nextLine();
			
			int rightPw = logDao.samePw(conn, inputPw, id);
			if(rightPw ==1) {
				break;
			}else {
				System.out.println("맞는 비밀번호가 아닙니다. 다시 입력해주세요. >");
			}
		}return inputPw;
				
	}
	
	
	//주소 물어보는 메소드
	public void rightAddr(Connection conn) {
		
		System.out.println("회원님의 배달정보를 확인합니다.");
		
		String addr = logDao.sameAddr2(conn, logId);
		
		System.out.println(logId +"님이 배달받으실 주소 : " + addr);
		
		System.out.println("맞으시면 Y, 변경하시려면 N을 눌러주세요. >");
		
		String choice = sc.nextLine();
		
		if(choice.equalsIgnoreCase("N")) {
			//주소가 틀리면 주소변경을 시행한다.
			System.out.println("변경할 주소를 입력해주세요 >");
			String newAddr = sc.nextLine();
			logDao.updateAdrr(conn, newAddr, logId);
			System.out.println("변경완료! 위 주소로 배달하겠습니다.");
		}
	}
	

	
	
	
}
