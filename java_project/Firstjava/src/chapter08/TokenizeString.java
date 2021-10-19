package chapter08;

import java.util.StringTokenizer;



public class TokenizeString {
	public static void main(String[] args) {
		
		//문자열원본
		String str = "11:22:33:44:55";
		String [] strMsg = new String[5];
		String zzang = "김성준:남현주:문가란:박태현:서선영:오종현:정지원:조윤재:지명근";
		
		StringTokenizer st = new StringTokenizer(str, ":");
		
		int i =0;
		//반복문을 이용해서 전체 토큰 참조
		while(st.hasMoreTokens()) {
			String temp = st.nextToken();
			System.out.println(temp);
			strMsg[i++] = temp;
		}
		System.out.println("----------------------");
		for(String s : strMsg) {
			System.out.println(s);
		}
		
		System.out.println("---------A반 반장뽑기----------");
		while(st.hasMoreTokens()) {
			String temp = st.nextToken();
			System.out.println(temp);
			
		}	
		
		
	}
}
