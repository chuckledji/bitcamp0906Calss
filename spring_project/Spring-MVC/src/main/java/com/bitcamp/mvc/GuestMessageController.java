package com.bitcamp.mvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.mvc.domain.GuestMessage;
import com.bitcamp.mvc.domain.OrderItem;

//REST수업 22.01.17
//@Controller
@RestController														//버전4.이상부터는 이 어노테이션사용으로@ResponseBody생략이 가능.
public class GuestMessageController {

	@RequestMapping("/guest/list.json")								//확장자 무의미, 그냥 요청 문자열로 보는것(list도 무관)
	//@ResponseBody
	public List<GuestMessage> getMessageList(){
		
		List<GuestMessage> list = new ArrayList<GuestMessage>();
		list.add(new GuestMessage(1, "테스트메세지", new Date()));		//문자열들 출력
		list.add(new GuestMessage(2, "안녕하세요.", new Date()));
		list.add(new GuestMessage(3, "반갑습니다.", new Date()));
		return list;
	}
	
	@RequestMapping("/simple")
	public String getString() {
		return "return String";										//return Spring 출력
	}
	
	@RequestMapping("/orderitem")
	public OrderItem getOrderItem(){
		return new OrderItem("product-10", 10000, "냉동식품");		//객체 출력
	}

	@RequestMapping("/orderitems")
	public List<OrderItem> getOrderItems(){
		
		List<OrderItem> list = new ArrayList<OrderItem>();
		list.add(new OrderItem("product-10", 10000, ""));
		list.add(new OrderItem("product-11", 100, "파손주의"));
		list.add(new OrderItem("product-12", 1000, "냉동식품"));
		
		return list;		
	}
	
	@RequestMapping("/orderitems2")
	public Map<String, OrderItem> getOrderItems2(){
		
		Map<String, OrderItem> map = new HashMap<String, OrderItem>();
		map.put("product-10", new OrderItem("product-10", 10000, "냉동식품"));		
		map.put("product-20", new OrderItem("product-20", 30000, "냉동식품"));
		//출력-속성의이름)"product-20": 
		//    속성의Data-객체타입){"itemId":"product-20","number": 0000,"remark":"냉동식품"}
		return map;		
	}

	@PostMapping("/orderitem")
	@ResponseBody
	public OrderItem getOrderItem(
			@RequestBody OrderItem item
			) {
		return item;
	}
	
}
