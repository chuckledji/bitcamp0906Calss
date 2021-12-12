package util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

// 클래스의용도 현재 사용하는 시점의 요청에 있는 쿠키 값들을 저장하고 관리 기능을 제곻하는 클래스
// 쿠키생성, 쿠키제공, 쿠키값제공, 쿠키유무확인
public class CookieBox {

	//쿠키 값을 저장한다 : 간단한 코드로 빠르게 참조하고자 한다!
	//->HashMap<Strng, Cookie>에 저장
	private Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
	
	//생성자를 통해서 값을 초기화 : Map에 Cookie객체들을 저장
	public CookieBox(HttpServletRequest request) {		//HashMap과 List는 다룰줄 알기
		
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null) {
			for(int i=0; i<cookies.length; i++) {
				cookieMap.put(cookies[i].getName(), cookies[i]);
			}
		}
	}
	//쿠키생성메소드 : 인스턴스 생성없이 사용가능하도록 한다. -> static
	//쿠키생성시 필요한 데이터 : 쿠키이름, 쿠키값, 유효시간, 경로, 도메인
	//오버로딩으로 같은 이름의 메소드를 정의
	public static Cookie createCookie(String name, String value) throws UnsupportedEncodingException {
		return new Cookie(name, URLEncoder.encode(value, "utf-8"));
	}
	public static Cookie createCookie(String name, String value, int maxAge) throws UnsupportedEncodingException {
		Cookie c = new Cookie(name, URLEncoder.encode(value, "utf-8"));
		c.setMaxAge(maxAge);
		return c;
	}
	public static Cookie createCookie(String name, String value, int maxAge, String path) throws UnsupportedEncodingException {
		Cookie c = new Cookie(name, URLEncoder.encode(value, "utf-8"));
		c.setMaxAge(maxAge);
		c.setPath(path);
		return c;
	}
	public static Cookie createCookie(String name, String value, int maxAge, String path, String domain) throws UnsupportedEncodingException {
		Cookie c = new Cookie(name, URLEncoder.encode(value, "utf-8"));
		c.setMaxAge(maxAge);
		c.setPath(path);
		c.setDomain(domain);
		return c;
	}
	
	//쿠키 객체를 제공하는 메소드 //인스턴스변수 - 현재 요청할때 쿠키는 모두 쿠키맵에들ㅇㅓ와있다.
	public Cookie getCookie(String cookieName) {
		return cookieMap.get(cookieName);
	}
	
	//쿠키 저장값을 반환 : String 
	public String getValue(String cookieName) throws UnsupportedEncodingException {//IOException상위타입으로 해도 됨
		Cookie c = cookieMap.get(cookieName);
		if(c ==null) {
			return null;
		}
		return URLDecoder.decode(c.getValue(), "utf-8");
	}
	
	//쿠키 존재유무확인
	public boolean exists(String cookieName) {
		return cookieMap.get(cookieName)!=null;	//존재하면 true, 반대면 false
	}
}
