package com.bitcamp.op.member.service;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.member.dao.JdbcTemplateMemberDao;
import com.bitcamp.op.member.dao.MemberDao;
import com.bitcamp.op.member.dao.MyBatisMemberDao;
import com.bitcamp.op.member.domain.ListPageView;
import com.bitcamp.op.member.domain.Member;
import com.bitcamp.op.member.domain.SearchParams;

@Service
public class MemberListService {

//	@Autowired
//	private MemberDao dao;

//	@Autowired
//	private JdbcTemplateMemberDao dao;
	
//	@Autowired
//	private MyBatisMemberDao dao;

	private MemberDao dao;
	@Autowired
	private SqlSessionTemplate template;
	
	
	// 페이지 당 표현할 회원의 수
	private final int COUNT_PER_PAGE = 3;

	
	public ListPageView getPageView(int pageNum) throws SQLException {

		ListPageView view = null;

		dao = template.getMapper(MemberDao.class);									//Dao-sqlSessionTemplate
		
//		Connection conn = null;
//		try {
//			conn = ConnectionProvider.getConnection();		

		// 전체 회원의 수
		// int totalCount = dao.selectTotalCount(conn);
		int totalCount = dao.selectTotalCount();									//커넥션 생략됨.

		// 현재 페이지 번호
		// int currentPage = pageNum;

		int index = (pageNum - 1) * COUNT_PER_PAGE;
//		List<Member> list = dao.selectList(conn, index, COUNT_PER_PAGE);			//Dao
//		List<Member> list = dao.selectList(index, COUNT_PER_PAGE);					//JdbcTemplate
//		SearchParams params = new SearchParams(index, COUNT_PER_PAGE, null,null);	//MyBatis-SqlSession
//		List<Member> list = dao.selectList(params);									//MyBatis-SqlSession
		List<Member> list = dao.selectList(COUNT_PER_PAGE, index);					//Dao-SqlSessionTemplate
		
		
		view = new ListPageView(totalCount, pageNum, COUNT_PER_PAGE, list);

//		} finally {
//			JdbcUtil.close(conn);
//		}

		return view;
	}

}