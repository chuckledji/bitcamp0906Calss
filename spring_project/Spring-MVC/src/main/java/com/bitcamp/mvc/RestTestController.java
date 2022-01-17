package com.bitcamp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mc/simple")
public class RestTestController {		//RequestBody연습

	
	@GetMapping
	public String form() {
		return"mc/form";
	}
	
	@PostMapping
	@ResponseBody								//String응답을 뷰이름이 아닌 데이터로 보내겠다는 뜻
	public String simple(						//반환타입의 data가 응답의 dato = body내용이라는 뜻이다.											
			@RequestBody String bodyContent 	//uname=이름&age=20 파라미터로 들어오는 (바디안의)데이터를 받는다.
			) {
		System.out.println("body : "+ bodyContent);
		return "Rest Test";						//이 문자열을 바디로 보내준다.(Reset Test가 화면이 나타난다)
	}
}
