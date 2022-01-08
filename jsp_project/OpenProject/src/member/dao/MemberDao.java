package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.util.JdbcUtil;
import member.domain.EditRequest;
import member.domain.Member;
import member.domain.RegRequest;

public class MemberDao {
	
	//싱글톤처리
	private MemberDao() {
		
	}
	private static MemberDao dao = new MemberDao();
	public static MemberDao getInstance() {
		return dao;
	}
	
	//Connection객체, Member객체를 전달받아 데이터베이스에 데이터 입력	//21.12.21 파라미터에 member객체를 request로변경
	public int insertMember(Connection conn, RegRequest request) throws SQLException {
		
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		
		String sql = "insert into member(userid, password, username, photo) values (?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);	//이번엔 서비스에서 예외처리하도록 처리.
			pstmt.setString(1, request.getUserid());
			pstmt.setString(2, request.getPw());
			pstmt.setString(3, request.getUsername());
			pstmt.setString(4, request.getFileName());
			
			resultCnt = pstmt.executeUpdate();
			
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return resultCnt;
	}

	// 로그인 처리를 위한 select 메소드
		public Member selectByIdPw(Connection conn, String userId, String pw) 
				throws SQLException {

			Member member = null;

			PreparedStatement pstmt = null;
			ResultSet rs = null;

			String sql = "select * from member where userid=? and password=?";

			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userId);
				pstmt.setString(2, pw);

				rs = pstmt.executeQuery();

				if (rs.next()) {
//					member = new Member(rs.getInt("idx"), // 1
//							rs.getString("userid"), // 2
//							rs.getString("password"), // 3
//							rs.getString("username"), // 4
//							rs.getString("regdate"), // 6
//							rs.getString("photo")); // 5
					member = getMember(rs);
				}

			} finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}

			return member;
		}

		public Member selectById(Connection conn, String userId) throws SQLException {
			
			Member member = null;

			PreparedStatement pstmt = null;
			ResultSet rs = null;

			String sql = "select * from member where userid=?";

			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userId);
				

				rs = pstmt.executeQuery();

				if (rs.next()) {
//					member = new Member(rs.getInt("idx"), // 1
//										rs.getString("userid"), // 2
//										rs.getString("password"), // 3
//										rs.getString("username"), // 4
//										rs.getString("regdate"), // 6
//										rs.getString("photo")); // 5
					member = getMember(rs);
				}

			} finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}

			return member;
		}

		public List<Member> selectList(Connection conn, int index, int count) throws SQLException {
			
			//반환
			List<Member> list = new ArrayList<Member>();
			
			//list를 완성할 코드
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql ="select * from member order by regdate desc limit ?, ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, index);
			pstmt.setInt(2, count);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
//				Member 	member = new Member(rs.getInt("idx"), // 1
//											rs.getString("userid"), // 2
//											rs.getString("password"), // 3
//											rs.getString("username"), // 4
//											rs.getString("regdate"), // 6
//											rs.getString("photo")); // 5
					list.add(getMember(rs));
			}
			return list;
		}

		private Member getMember(ResultSet rs) throws SQLException {
			return new Member(rs.getInt("idx"), // 1
					rs.getString("userid"), // 2
					rs.getString("password"), // 3
					rs.getString("username"), // 4
					rs.getString("regdate"), // 6
					rs.getString("photo")); // 5
		}
		
		public int selectTotalCount(Connection conn) throws SQLException {

			int totalCount = 0;

			Statement stmt = null;
			ResultSet rs = null;

			String sql = "select count(*) from member";

			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);

				if (rs.next()) {
					totalCount = rs.getInt(1);
				}
			} finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(stmt);
			}

			return totalCount;
		}

		public Member selectByIdx(Connection conn, int idx) throws SQLException {
			
			Member member = null;
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql ="select * from member where idx=1";
			
			try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
			rs= pstmt.executeQuery();
			
			if(rs .next()) {
				member = getMember(rs);
			}
			} finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}
			return member;
		}

		public int updateMember(Connection conn, EditRequest editRequest) throws SQLException {
			
			int resultCnt = 0;
			PreparedStatement pstmt = null;
			String sql = "update member set password=?, username=?, photo=? where idx=?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, editRequest.getPw());
				pstmt.setString(2, editRequest.getUsername());
				pstmt.setString(3, editRequest.getFileName());
				pstmt.setInt(4, editRequest.getIdx());
				
				resultCnt = pstmt.executeUpdate();
			} finally {
				JdbcUtil.close(pstmt);
			}
			
			return resultCnt;
		}

		public int deleteMemberByIdx(Connection conn, int idx) throws SQLException {
			
			int resultCnt = 0;
			
			PreparedStatement pstmt = null;
			
			String sql = "DELETE FROM member WHERE idx=?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, idx);
				
				resultCnt = pstmt.executeUpdate();
				
			} finally {
				JdbcUtil.close(pstmt);
			}
			
			return resultCnt;
		}

		public int selectByIdCount(Connection conn, String userId) throws SQLException {
			
			int resultCnt = 0;
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql = "select count(*) from member where userid=?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userId);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					resultCnt = rs.getInt(1);
				}
			} finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}
			
			
			
			
			
			return resultCnt;
		}

	}
