package day0910;

// 별찍기 9번
import java.util.Scanner;

public class StarPrinter09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("별찍기 9번");
        System.out.println("출력할 줄 수를 입력해주세요.");
        System.out.print("> ");

        int userNum = scanner.nextInt();

        int maxHeight = 2 * userNum - 1;

        for (int i = 1; i <= maxHeight; i++) {
            String stars = "";

            // i번째 줄의 공백의 갯수를 저장할 변수
            int spaceWidth = 0;

            // i번째 줄의 별의 갯수를 저장할 변수
            int starWidth = 0;

            if (i < userNum) {
                // 윗부분일 경우
                spaceWidth = userNum - i;
                starWidth = 2 * i - 1;
            } else {
                // 아랫부분일 경우
                int lowerI = 2 * userNum - i;

                spaceWidth = userNum - lowerI;
                starWidth = 2 * lowerI - 1;

            }

            // 공백을 담당하는 j for 문
            for (int j = 1; j <= spaceWidth; j++) {
                stars += " ";
            }

            // 별을 담당하는 j for 문
            for (int j = 1; j <= starWidth; j++) {
                stars += "*";
            }

            System.out.println(stars);
        }

        scanner.close();
    }
}
