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

        scanner.close();
    }
}
