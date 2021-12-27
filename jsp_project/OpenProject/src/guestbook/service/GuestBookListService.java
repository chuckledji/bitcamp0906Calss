package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import guestbook.dao.GuestBookDao;
import guestbook.domain.GuestBookListView;
import guestbook.domain.ListRequest;
import jdbc.ConnectionProvider;

public class GuestBookListService {
	//싱글톤 처리
	private GuestBookListService() {}
	private static GuestBookListService service = new GuestBookListService();
	public static GuestBookListService getInstance() {
		return service;
	}
	
	
	//작성한 글 리스트를 반환하는 메소드
	public GuestBookListView getPage(int pageNum) {
		GuestBookListView listView = null;
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			int currentPage = pageNum;
			
			final int COUNT_PER_PAGE = 5;
			
			int index = (currentPage-1)*COUNT_PER_PAGE;
			
			//작성 글 목록을 만들 객체 가져오기
			List<ListRequest> list = GuestBookDao.getInstance().selectList(conn, index, COUNT_PER_PAGE );
			//전체 글 개수 구하기
			int totalCount = GuestBookDao.getInstance().selectTotalCount(conn);
			
			listView = new GuestBookListView(totalCount, COUNT_PER_PAGE, currentPage, list);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return listView;
	}
}
	