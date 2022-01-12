package com.bitcamp.junittest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JTest {

	//테스트코드 작성  전 -> 테스트 케이스 정의 필요 
	
	
	//@Before	   : @Test실행 전 실행
	@Before
	public void setup() {
		System.out.println("@Before 메소드 실행");
	}
	
	//@After 	   : @Test실행 후 실행
	@After
	public void tearDown() {
		System.out.println("@After 메소드 실행");
	}
	
	//@BeforeClass : 객체 생성 전 
	@BeforeClass
	public static void setupForClass() {				//static쓰는 이유?
		System.out.println("@BeforeClass 메소드 실행");
	}
	
	//@AfterClass  : 객체 소멸 전
	@AfterClass
	public static void tearDownForClass() {
		System.out.println("@AfterClass 메소드 실행");
	}
	
	
	//@Test
	@Test
	public void calTest() {
		assertEquals("동등비교결과입니다",1,2);
	}
	
	
	

}
