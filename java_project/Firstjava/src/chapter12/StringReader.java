package chapter12;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

public class StringReader {
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new FileReader("String.txt"));
		
		//한 라인의 문자열을 받을 변수
		String str;
		
		while(true) {
			
			str = in.readLine();		//한 줄을 읽어오는 것
			if(str==null) {
				break;
			}
			System.out.println(str);
		}
		in.close();
	}
}
