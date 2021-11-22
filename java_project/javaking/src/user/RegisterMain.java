<<<<<<< HEAD:java_project/javaking-main/Javaking/src/javaKing/RegisterMain.java
package javaKing;
=======
package user;
>>>>>>> e3dadb45a45169651c7efbac58c42a5fe8fdf0c3:java_project/javaking/src/user/RegisterMain.java

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/*RegisterDao > RegisterView > RegisterMain > StartUi*///순으로 진행

public class RegisterMain {

    RegisterDao regDao = new RegisterDao();
    RegisterView regView = new RegisterView();
    Connection conn;
    
    //입력메소드
    public void regmain() {
        try {
            conn = ConnectionProvider.getConnection();
            //회원정보입력
            regView.insertUser(conn);
            conn.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
   
}
