package com.bitcamp.op.member.service;

import org.springframework.stereotype.Service;

import com.bitcamp.op.member.domain.Member;

@Service
public class MailSenderService {

	public int send(String subject, String content, String email) {
		return 0;
	}
	
	public int send(String email) {	//오버로딩
		return 0;
	}
	
	public int send(String[] emails) {
		return 0;
	}
	public int send(Member member) {
		return 0;
	}
	
}
