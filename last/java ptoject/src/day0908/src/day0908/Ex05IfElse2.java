package day0908;

// 1번부터 6번까지
// 그 반대 되는 경우를 생각하여
// 코드를 작성하시오
// 55분까지

import java.util.Scanner;

public class Ex05IfElse2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------1번---------------------");
        int num = 4;
        if (num < 5) {
            System.out.println("5보다 작습니다.");
        } else {
            System.out.println("5보다 크거나 같습니다.");
        }

        System.out.println("------------------------------------");

        System.out.println("-------------2번---------------------");

        num = 8;

        if (num % 2 == 0) {
            System.out.println("짝수입니다.");
        } else {
            System.out.println("홀수입니다.");
        }
        

        System.out.println("------------------------------------");

        System.out.println("-------------3번---------------------");

        System.out.println("숫자를 입력해주세요.");
        System.out.print("> ");
        num = scanner.nextInt();

        if (num % 6 == 0) {
            System.out.println("6의 배수입니다.");
        } else {
            System.out.println("6의 배수가 아닙니다.");
        }

        System.out.println("------------------------------------");

        System.out.println("-------------4번---------------------");

        System.out.println("나이를 입력해주세요.");
        System.out.print("> ");
        int age = scanner.nextInt();

        if (age < 19) {
            System.out.println("미성년자입니다.");
        } else {
            System.out.println("성인입니다.");
        }

        System.out.println("------------------------------------");

        System.out.println("-------------5번---------------------");

        System.out.println("숫자를 입력해주세요.");
        System.out.print("> ");
        num = scanner.nextInt();

        if (num >= 50 && num < 60) {
            System.out.println("50번대 숫자입니다.");
        } else {
            System.out.println("50번대 숫자가 아닙니다.");
        }

        System.out.println("------------------------------------");

        System.out.println("-------------6번---------------------");
        scanner.nextLine();

        System.out.println("아이디를 입력해주세요.");
        System.out.print("> ");
        String username = scanner.nextLine();

        System.out.println("비밀번호를 입력해주세요.");
        System.out.print("> ");
        String password = scanner.nextLine();

        if (username.equalsIgnoreCase("admin") && password.equals("111")) {
            System.out.println("로그인 성공");
        } else {
            System.out.println("로그인 실패");
        }

        System.out.println("------------------------------------");

        scanner.close();
    }
}
