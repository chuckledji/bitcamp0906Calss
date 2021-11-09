package day0910;

// 별찍기 8번
import java.util.Scanner;

public class StarPrinter08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("별찍기 8번");
        System.out.println("출력할 줄 수를 입력해주세요.");
        System.out.print("> ");

        int userNum = scanner.nextInt();

        for (int i = 1; i <= 2 * userNum - 1; i++) {
            String stars = "";

            if (i < userNum) {
                // 윗부분

                // 공백을 담당하는 j for 문
                for (int j = 1; j <= userNum - i; j++) {
                    stars += " ";
                }

                // 별을 담당하는 j for 문
                for (int j = 1; j <= i; j++) {
                    stars += "*";
                }

            } else {
                // 아랫부분

                // 아래의 기준점이 될 int 변수 lowerI

                int lowerI = i - userNum + 1;

                // 공백을 담당하는 j for 문
                for (int j = 1; j <= lowerI - 1; j++) {
                    stars += " ";
                }

                // 별을 담당하는 j for 문
                for (int j = lowerI; j <= userNum; j++) {
                    stars += "*";
                }
            }

            System.out.println(stars);
        }

        scanner.close();
    }
}
