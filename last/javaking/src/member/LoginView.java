package member;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class LoginView {
	public static void main(String[] args) {
		//로그인정보 테스트
		
		//주소출력, 주문할 주소가 맞습니까? Y/N
		//@Y일시 
		//모든 정보 그대로 진행
		
		LoginDao logdao = new LoginDao();
		Connection conn;
		
		List<Delivery>dlist = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			//입력되는 부분이다.
			//여기서 1.회원일시, 1-1. 주소변경하지 않을 시, 기존정보를 불러 와 객체에 저장을한다.
			int log = 0;
			if(log == 1) {
				//로그인중인 회원의 정보를 전부 불러온다.
				
				Delivery newDelivery = new Delivery(addressnum, dname, dphn, daddr)
			}
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
