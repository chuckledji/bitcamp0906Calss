package day0910;

// 별찍기 10번
import java.util.Scanner;

public class StarPrinter10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("별찍기 10번");
        System.out.println("출력할 줄 수를 입력해주세요.");
        System.out.print("> ");

        int userNum = scanner.nextInt();

        int maxHeight = 2 * userNum - 1;
        int maxWidth = 2 * userNum - 1;
        for (int i = 1; i <= maxHeight; i++) {
            String stars = "";

            if (i == 1 || i == maxHeight) {
                // 맨 처음 혹은 맨 마지막 줄일 경우

                for (int j = 1; j <= maxWidth; j++) {
                    stars += "*";
                }

            } else {
                // 그 외의 경우

                // 별의 갯수
                int starWidth = 0;

                // 공백의 갯수
                int spaceWidth = 0;

                if (i < userNum) {
                    // i 가 1 혹은 maxHeight이 아닌 경우 중
                    // i 가 userNum보다 작을 경우
                    // = 윗부분일 경우

                    // 윗부분의 기준으로 잡을 upperI
                    int upperI = i - 1;

                    // 별의 갯수
                    starWidth = userNum - upperI;

                } else {
                    // i 가 1 혹은 maxHeight이 아닌 경우 중
                    // i 가 userNum보다 작지 않을 경우
                    // = 아랫부분일 경우

                    // 아랫부분을 기준으로 잡을 lowerI
                    int lowerI = i - userNum + 1;

                    // 별의 갯수
                    starWidth = lowerI;

                }

                // 공백의 갯수
                spaceWidth = maxWidth - 2 * starWidth;

                // 왼쪽 별을 담당하는 j for 문
                for (int j = 1; j <= starWidth; j++) {
                    stars += "*";
                }

                // 가운데 공백을 담당하는 j for 문
                for (int j = 1; j <= spaceWidth; j++) {
                    stars += " ";
                }

                // 오른쪽 별을 담당하는 j for 문
                for (int j = 1; j <= starWidth; j++) {
                    stars += "*";
                }

            }

            System.out.println(stars);
        }

        scanner.close();
    }
}
