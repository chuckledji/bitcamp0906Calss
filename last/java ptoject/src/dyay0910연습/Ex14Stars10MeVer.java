package dyay0910연습;

import java.util.Scanner;

public class Ex14Stars10MeVer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("별찍기10번");
        System.out.println("출력할 줄 수를 입력하세요.");
        System.out.println("> ");
        int num = scanner.nextInt();

        // 맨윗줄 별부분

        for (int i = 1; i <= num - 4; i++) {
            String stars = "";
            for (int j = i; j <= num * 2 - 1; j++) {
                stars += "*";
            }
            System.out.println(stars);
        }

        for (int i = 1; i <= num - 1; i++) {
            String stars = "";

            // 2. 1별부분 4321
            for (int j = i; j <= num - 1; j++) {
                stars += "*";
            }
            // 3. 공백부분 1357
            for (int j = 1; j <= i * 2 - 1; j++) {
                stars += " ";
            }
            // 4. 2별부분 4321
            for (int j = i; j <= num - 1; j++) {
                stars += "*";
            }
            System.out.println(stars);
        }

        // 아랫부분
        for (int i = 2; i+1 <= num; i++) {
            String stars = "";

            // 5. 1별부분 234
            for (int j = 1; j <= i; j++) {
                stars += "*";
            }
            // 6. 공백부분 531
            for (int j = 1; j <= 2 * num - 1 - 2 * i; j++) {
                stars += " ";
            }
            // 7. 2별부분 234
            for (int j = 1; j <= i; j++) {
                stars += "*";
            }
            System.out.println(stars);
        }
        
        //맨아랫줄 별부분

        for (int i = 1; i <= num - 4; i++) {
            String stars = "";
            for (int j = i; j <= num * 2 - 1; j++) {
                stars += "*";
            }
            System.out.println(stars);
        }

        scanner.close();
    }
}
