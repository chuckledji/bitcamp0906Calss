package com.bitcamp.op.guestbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.op.guestbook.domain.ReplyRegRequest;
import com.bitcamp.op.guestbook.service.GuestBookReplyDeleteService;
import com.bitcamp.op.guestbook.service.ReplyRegService;

@RestController
@RequestMapping("/api/v1/guestbook/reply")
public class GuestBookReplyRestController {				//rest로 진행

	@Autowired
	private ReplyRegService regService;
	
	@Autowired
	private GuestBookReplyDeleteService deleteService;
	
	//댓글 입력
	@PostMapping	//@ResponseBody쓴 것과 같음
	public String regReply(
			ReplyRegRequest regRequest
			) {
		regService.insertReply(regRequest);
		
		System.out.println("입력된 idx: " + regRequest.getIdx());
		
		return String.valueOf(regRequest.getIdx());					
	
		
	}
	
	//댓글 삭제
	@DeleteMapping("/{idx")
	public String deleteReply(
			//@RequestParam("idx")int idx
			@PathVariable("idx") int idx
			) {
		return String.valueOf(deleteService.deleteReply(idx));
	}
}
