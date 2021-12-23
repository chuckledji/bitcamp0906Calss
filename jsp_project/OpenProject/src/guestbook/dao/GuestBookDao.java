package guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import guestbook.domain.GuestRequest;
import jdbc.util.JdbcUtil;

public class GuestBookDao {

	private GuestBookDao() {}
	private static GuestBookDao dao = new GuestBookDao();
	public static GuestBookDao getInstance() {
		return dao;
	}
	public int insertGuestBook(Connection conn, GuestRequest guestReq) throws SQLException {
	
		int resultCnt=0;
		PreparedStatement pstmt = null;
		
		String sql = "insert into guestbook(subject, content, memberidx) values (?,?,?)";
		
		try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, guestReq.getSubject());
		pstmt.setString(2, guestReq.getContent());
		pstmt.setInt(3, guestReq.getMemberidx());
		
		resultCnt = pstmt.executeUpdate();
		
		} finally {
			JdbcUtil.close(pstmt);			
		}
		return resultCnt;
	}
	
}
