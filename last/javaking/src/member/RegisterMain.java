package member;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;


public class RegisterMain {
public static void main(String[] args) {
		
		RegisterDao regDao = new RegisterDao();
		RegisterView regView = new RegisterView();
		Connection conn;
		
		
		try {
			conn = ConnectionProvider.getConnection();
			
			conn.setAutoCommit(false);
			//회원정보입력
			regView.insertUser(conn);
		
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
