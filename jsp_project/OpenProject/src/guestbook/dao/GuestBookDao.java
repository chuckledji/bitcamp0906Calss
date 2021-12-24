package guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import guestbook.domain.ListRequest;
import guestbook.domain.WritingRequest;
import jdbc.util.JdbcUtil;

public class GuestBookDao {

	private GuestBookDao() {}
	private static GuestBookDao dao = new GuestBookDao();
	public static GuestBookDao getInstance() {
		return dao;
	}
	public int insertGuestBook(Connection conn, WritingRequest guestReq) throws SQLException {
	
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
	public List<ListRequest> selectList(Connection conn, int index, int count) throws SQLException {
		
		//작성글테이블과 멤버테이블을 조인해서 데이터를 구해 ListRequest리스트에 넣어 보낸다
		List<ListRequest> list = new ArrayList<ListRequest>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select g.idx, g.subject, m.userid, g.regdate from member m join guestbook g on m.idx = g.memberIdx order by g.idx asc limit ?, ?";
				
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, index);
		pstmt.setInt(2, count);
		
		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			ListRequest listRequest = new ListRequest(rs.getInt("g.idx"), rs.getString("g.subject"), rs.getString("m.userid"), rs.getString("g.regdate"));
			list.add(listRequest);
		}
		return list;
	}
	public int selectTotalCount(Connection conn) throws SQLException {
		
		int totalCount = 0;
		
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = " select count(*) from guestbook";
		
		
		try {
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
			if(rs.next()) {
				totalCount = rs.getInt(1);
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
				
		return totalCount;
	}
	
	
	
	
}
