package com.bitcamp.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.mvc.domain.SerchType;

@Controller
public class SearchController {

	@RequestMapping("/serch/serch1")
	public void getForm1() {
		
	}
	@RequestMapping("/serch/serch2")
	public void getForm2() {
		
	}
	@RequestMapping("/serch/serch1")
	public void getForm3() {
		
	}
	
	//검색 타입 : 메소드가 반환하는 개체를 view에 전달
	@ModelAttribute("serchType")
	public List<SerchType> getSerchType(){
		List<SerchType> list = new ArrayList<SerchType>();
		list.add(new SerchType(1, "아이디"));
		list.add(new SerchType(2, "이름"));
		list.add(new SerchType(3, "이름+아이디"));

		return list;
	}
	
	//인기검색어
	@ModelAttribute("keywords")
	public String[] getkeywords() {
		return new String[] {"COOL", "HOT", "SON"};
	}
}
