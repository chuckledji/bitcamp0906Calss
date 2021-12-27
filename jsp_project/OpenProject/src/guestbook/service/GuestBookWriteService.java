package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.dao.GuestBookDao;
import guestbook.domain.WritingRequest;
import jdbc.ConnectionProvider;

public class GuestBookWriteService {

	private GuestBookWriteService() {}
	private static GuestBookWriteService service = new GuestBookWriteService();
	public static GuestBookWriteService getInstance() {
		return service;
	}
	
	public int insertWriting(HttpServletRequest request, HttpServletResponse response) {
		
		int resultCnt = 0;
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String memberidx = request.getParameter("memberidx");
		
		Connection conn = null;
		
		WritingRequest guestReq = new WritingRequest(title, content, Integer.parseInt(memberidx));
		
		try {
			conn = ConnectionProvider.getConnection();
			
			resultCnt = GuestBookDao.getInstance().insertGuestBook(conn, guestReq);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return resultCnt;
	}
	
	
	
}
