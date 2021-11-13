package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	
	public static Connection getConnection() throws SQLException {		//성능개선을 위해 static을 쓴다.
		
		
		//String jdbcUrl1="jdbc:oracle:thie:@[주소]:[포트]:[데이터베이스]"//sql디벨롭퍼에 접속누르면 접속정보 볼 수 있음
		String jdbcUrl1="jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String pw = "tiger";
		
		return DriverManager.getConnection(jdbcUrl1,user,pw);
	}
}
