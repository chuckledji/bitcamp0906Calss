package chapter06;

import java.util.Scanner;

public class Array {
	/*
	 * 문제 1.
	int형 1차원 배열을 매개변수로 전달 받아서 배열에 저장된 최대값,
	그리고 최소값을 구해서 반환하는 메소드를 다음의 형태로 각각 정의.
	public static int miniValue(int[] arr) { . . . . } // 최소값 반환
	public static int maxValue(int[] arr) { . . . . } // 최대값 반환
	
	위의 두 매소드는 인자로 전달되는 배열의 길이에 상관없이 동작하도록 정의.
	두 매소드 실행을 확인인하기 위한 main 메소드 정의.
	int형 배열에 채워질 정수는 프로그램 사용자로부터 입력 받고, 배열의 길이는 임의로 결정
	 */
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		//임의 배열
		int[] num = new int[6];
		
		//배열요소에 숫자저장
		for(int i = 0; i< num.length; i++) {
			System.out.println("총 " + num.length +"개의 숫자를 입력합니다.");
			System.out.println((i+1)+"번째 숫자를 입력하세요.\n>");
			num[i] = scanner.nextInt();
			
		}
		
		System.out.println("입력한 숫자 중 최소값: " +miniValue(num));
		System.out.println("입력한 숫자 중 최대값: " +maxValue(num));
		
		scanner.close();
	}
	
	
	
	//최소값반환
	public static int miniValue(int[] arr) {
		int min=arr[0];
		for(int i =0; i<arr.length; i++) {
			if(arr[i]<min) {
				min = arr[i];
			}
		}
		return min;
	}
	
	
	
	//최대값반환
	
	public static int maxValue(int[] arr) {
		int max=arr[0];
		
		for(int i =0; i<arr.length; i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		return max;
	}
	
}
