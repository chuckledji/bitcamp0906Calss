package day0910;

// 별찍기 2번
import java.util.Scanner;

public class StarPrinter02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("별찍기 2번");
        System.out.println("출력할 줄 수를 입력해주세요.");
        System.out.print("> ");

        int userNum = scanner.nextInt();

        for (int i = 1; i <= userNum; i++) {
            String stars = "";

            for (int j = i; j <= userNum; j++) {
                stars += "*";
            }

            System.out.println(stars);
        }

        scanner.close();
    }
}
