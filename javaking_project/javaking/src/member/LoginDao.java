package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginDao {

	
	//정보입력
		//이름입력
		//폰번호입력
		//주소입력
	public int insertDelivery(Connection conn, Delivery del) {
		
		PreparedStatement pstmt = null;
		
		int resultCnt = 0;
		
			try {
		
				String sql = "insert into delivery values(del_seq.nextval, ?, ?, ?)";
				pstmt = conn.prepareStatement(sql);		//sql 실행
				pstmt.setString(1, del.getDname());		//주문자 이름입력
				pstmt.setString(2, del.getDphn());		//주문자 핸드폰번호입력
				pstmt.setString(3, del.getDaddr());		//주문자 주소입력
								
				resultCnt = pstmt.executeUpdate();		//정상적결과라면 1이 들어감.		
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JdbcUtil.close(pstmt);
			}
		return resultCnt;
	}
	
	
	//입력한정보확인
	
	
}
