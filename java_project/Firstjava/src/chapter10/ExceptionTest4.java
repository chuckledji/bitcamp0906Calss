package chapter10;

import java.text.NumberFormat;
import java.util.Scanner;

public class ExceptionTest4 {
	
	public static void main(String[] args) {
		
		int[]arr = new int[3];
		Object o =new String("abc");
		String str = null;
		
		String number = "one";
		
		try {
			//배열 인덱스를 잘못 처리한 경우
			System.out.println(arr[3]);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("예외 발생");
			System.out.println(e.getMessage()); // 어떤 예외가 발생한건지 알려준다.
		}
		
		
		try {
		Integer i = (Integer)o;
		}catch(ClassCastException e) {
			System.out.println("예외 발생");
			System.out.println(e.getMessage());
		}
		
		
		int size = -10;
		try {
		int[] arr1 = new int[size];
		}catch(NegativeArraySizeException e) { //메세지가 따로 없어서 nnull이 나온다
			System.out.println("예외 발생");
			System.out.println(e.getMessage());
		}
		
		try {
		System.out.println(str.toUpperCase()); //참조값이 가지고있는 값이 null이라서 오류가 난다.
		}catch(NullPointerException e) {
			System.out.println("예외 발생");
			System.out.println(e.getMessage());
		}
		
		
		try {
			int temp = Integer.parseInt(number);
		}catch(NumberFormatException e) {
			System.out.println("예외 발생");
			System.out.println(e.getMessage());
		}
		
		System.out.println("프로그램을 종료합니다.");
	}
}
