package com.bitcamp.op.guestbook.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.guestbook.dao.GuestBookReplyDao;
import com.bitcamp.op.guestbook.domain.ReplyRegRequest;

@Service
public class ReplyRegService {

	private GuestBookReplyDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	
	public void insertReply(ReplyRegRequest regRequest){		//void해도 되는 이유 : 인티저 반환이 따로 필요없다.(이전에 이미 번호가 나옴)다시듣기
		
		dao = template.getMapper(GuestBookReplyDao.class);
		dao.insertReply(regRequest);
	}
	
	
}
