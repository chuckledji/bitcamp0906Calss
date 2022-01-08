package com.bitcamp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptioinCotroler {

	private HelloService service;
	
	
	@RequestMapping("/error/null")
	public String getPage() {
		
		service.getGreetin();
		
		return "index";
	}
	
	@ExceptionHandler(NullPointerException.class)
	public String handleNullPointerExceptioin(NullPointerException e) {
		
		return "error/null";
	}
}
