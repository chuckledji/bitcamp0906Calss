package chapter06;


public class Array {
	/*
	 * 문제 1. int형 1차원 배열을 매개변수로 전달 받아서 배열에 저장된 최대값, 그리고 최소값을 구해서 반환하는 메소드를 다음의 형태로
	 * 각각 정의. public static int miniValue(int[] arr) { . . . . } // 최소값 반환 public
	 * static int maxValue(int[] arr) { . . . . } // 최대값 반환
	 * 
	 * 위의 두 매소드는 인자로 전달되는 배열의 길이에 상관없이 동작하도록 정의. 두 매소드 실행을 확인인하기 위한 main 메소드 정의.
	 * int형 배열에 채워질 정수는 프로그램 사용자로부터 입력 받고, 배열의 길이는 임의로 결정
	 */
	public static void main(String[] args) {

		// 배열요소에 숫자저장
		int[] arr = { 1, 4, 56, 6, 2, 34, 1234 };
		int[] arr2 = { 1, 4, 56, 6 };

		// 반환 메소드 이용하여 출력
		System.out.println("입력한 숫자 중 최소값: " + miniValue(arr));
		System.out.println("입력한 숫자 중 최대값: " + maxValue(arr2));

		// 2차원배열의출력
		int[][] arr3 = { { 1, 5, 67 }, { 23, 26, 6, 7, 4 }, { 3, 56, 7, 8, 9, 24, 64 } };
		System.out.println("2차원배열출력");
		addOneDArr(arr3, 10);
	}

	public static void addOneDArr(int[][] arr, int add) {

		// 출력
		// 행
		for (int i = 0; i < arr.length; i++) {
			// 열
			for (int j = 0; j < arr[i].length; i++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}

		// 매개변수로 전달받은 숫자를 각 요소에 더해준다
		for (int i = 0; i < arr.length; i++) {
			// 열
			for (int j = 0; j < arr[i].length; i++) {
				arr[i][j] += add;
			}
		}
		// 각요소에 숫자를 더하기==================
		// 행
		for (int i = 0; i < arr.length; i++) {
			// 열
			for (int j = 0; j < arr[i].length; i++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

	// 최소값반환
	public static int miniValue(int[] arr) { // 배열을 매개변수로 받을 수 있습니다.
		int min = arr[0];// 임의로 처음값을 최소값으로 저장

		// 각 요소의 값과 최소값들을 비교 후에 새로운 값이 더 작을 때 최소값을 저장한다
		// 전달받은 베열의 사이즈만큼 반복하면서 비교한다.
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}

	// 최대값반환

	public static int maxValue(int[] arr) {
		int max = arr[0];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

}
