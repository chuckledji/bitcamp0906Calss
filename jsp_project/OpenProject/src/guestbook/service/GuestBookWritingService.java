package guestbook.service;

import java.sql.Connection;

import guestbook.dao.GuestBookDao;
import guestbook.domain.GuestBook;
import jdbc.ConnectionProvider;

public class GuestBookWritingService {

	//싱글톤
	private GuestBookWritingService() {}
	private static GuestBookWritingService service = new GuestBookWritingService();
	public static GuestBookWritingService getInstace() {
		return service;
	}
	
	//글번호에 맞는 작성글 정보 가져오기
	public GuestBook getGbook(int idx) {
		
		GuestBook gbook = null;
		
		Connection conn = null;
		
		conn = ConnectionProvider.getConnection();
		
		gbook = GuestBookDao.getInstance().selectByIdx(conn, idx);
		
		
		
	}
	
	
}
