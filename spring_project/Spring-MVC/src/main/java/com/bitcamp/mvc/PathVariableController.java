package com.bitcamp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathVariableController {
	
	//요청 들어올 때 : /mvc/names/0 /mvc/names/1 /mvc/names/2... 
	@RequestMapping("/names/{path}/{no}")
	public String getPage(
				@PathVariable("path") String path,
				@PathVariable("no") int index,
				Model model
				) {
		
		System.out.println(path);
		
		String[] names = new String[] {"김일일", "이이이", "박삼삼","최사사"};
		
		model.addAttribute("result", names[index]);
		
		return"path/view";
	}
}
