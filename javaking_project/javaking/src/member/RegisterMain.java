package member;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;


public class RegisterMain {

    RegisterDao regDao = new RegisterDao();
    RegisterView regView = new RegisterView();
    Connection conn;
    
    //입력메소드
    public void connect() {
        
        
        try {
            conn = ConnectionProvider.getConnection();
            //회원정보입력
            regView.insertUser(conn);
        
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //로그인메소드
    public void connect1() {
        
        try {
            conn = ConnectionProvider.getConnection();
            
            conn.setAutoCommit(false);
            //회원정보입력
            regView.insertUser(conn);
        
            conn.commit();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
