package com.bitcamp.op;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bitcamp.op.member.dao.MemberDao;

@RunWith(SpringJUnit4ClassRunner.class)											//여기서 컨테이너를 만들고 구동시키도록
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")	//이 경로안에 우리가 원하는 sqlsession이 있으므로 >root>session>Memberdao인터페이스이용이가능
public class DaoTest {

	private MemberDao dao;
	@Autowired
	SqlSessionTemplate template;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test																					//테스트 케이스 다양하게 많이 만들어보기  // 결과값을 먼저 가정하고 진행한다.
	public void 회원의전체수구하는테스트1() {														//개인용이면 한글테스트로 해도 되지만 영문을 권유
		dao = template.getMapper(MemberDao.class);
		
		//case : 전체 회원의 수를 반환하는 메소드 테스트는 결과가 MySql Workbench에서 select 한 결과 (숫자)와 같아야 한다
		int cnt = dao.selectTotalCount(new HashMap<String, String>());
		assertEquals("전체 회원수 확인 : (수)기대", 10, cnt);										//기대하는 수, 실제 수
		
		//fail("Not yet implemented");
	}
	
	@Test
	public void 회원의전체수구하는테스트2() {	
		dao = template.getMapper(MemberDao.class);
		
		//case : 검색타입과 검색어를 전달해주면 결과가 2 가 반환되어야한다
		HashMap<String, String> map  = new HashMap<String, String>();
		map.put("searchType", "uid");
		map.put("keyWord", "rrr");
		int cnt = dao.selectTotalCount(map);
		assertEquals("아이디가 rrr문자열을 포함하는 회원의 수", 3, cnt);								//select # from member where uid= %rrr%  ??맞나
		
		//fail("Not yet implemented");
	}


}
