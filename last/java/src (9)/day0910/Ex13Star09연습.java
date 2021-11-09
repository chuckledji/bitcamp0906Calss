package day0910;

import java.util.Scanner;

public class Ex13Star09연습 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("별찍기9번");
        System.out.println("출력할 줄 수를 입력해주세요");
        System.out.println("> ");
        int num = scanner.nextInt();

        for (int i = 1; i <= num; i++) {
            String stars = "";

            for (int j = i; j <= num - 1; j++) {
                stars += " ";
            }
            for (int j = 1; j <= i * 2 - 1; j++) {
                stars += "*";
            }
            System.out.println(stars);
        }
        for (int i = num - 1; i >= 1; i--) {
            String stars = "";

            // 공백부분
            for (int j = 1; j <= num - i; j++) {
                stars += " ";
            }

            // 별부분
            for (int j = 1; j <= 2 * i - 1; j++) {
                stars += "*";
            }

            System.out.println(stars);
        }

        scanner.close();
    }

}