package member;

import java.sql.Connection;
import java.sql.SQLException;

public class LoginMain {

	    LoginDao logDao = new LoginDao();
	    LoginView logView = new LoginView();
	    Connection conn;
	    
	    //입력메소드
	    public void connect2() {
	        try {
	            conn = ConnectionProvider.getConnection();
	            //로그인화면
	            logView.login(conn);
	            logView.rightAddr(conn);
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
}
