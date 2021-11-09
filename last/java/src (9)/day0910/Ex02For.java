package day0910;
// for문에 대한 기본 예제들

// 1. 1부터 5까지 출력해라
// 2. 10부터 7까지 출력해라
// 3. 7부터 11까지의 짝수를 출력해라
// 4. 사용자로부터 숫자를 입력받아서
//    1부터 그수까지 출력해라
// 5. 사용자로부터 숫자를 2개 입력받아서
//    더 작은 수부터 더 큰수까지 출력해라
// 6. 사용자로부터 숫자를 1개 입력 받아서
//    1부터 그수까지의 합을 구하여 출력해라
// 7. 사용자로부터 숫자를 1개 입력 받아서
//    1부터 그수까지의 곱을 구하여 출력해라
// 쉬는시간 포함 40분까지
import java.util.Scanner;

public class Ex02For {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1번");
        
        for(int i = 1; i <= 5; i++) {
            System.out.println(i);
        }

        System.out.println("-----------------\n");

        System.out.println("2번");
        
        for(int i = 10; i >= 7; i--) {
            System.out.println(i);
        }

        System.out.println("-----------------\n");

        System.out.println("3번");
        
        for(int i = 7; i <= 11; i++) {
            if(i % 2 == 0) {
                System.out.println(i);    
            }            
        }

        System.out.println("-----------------\n");

        System.out.println("4번");
        
        System.out.println("숫자를 입력해주세요.");
        System.out.print("> ");
        int num = scanner.nextInt();
        
        for(int i = 1; i <= num; i++) {
            System.out.println(i);
        }

        System.out.println("-----------------\n");

        System.out.println("5번");
        
        System.out.println("첫번째 숫자를 입력해주세요.");
        System.out.print("> ");
        int num1 = scanner.nextInt();
        
        System.out.println("두번째 숫자를 입력해주세요.");
        System.out.print("> ");
        int num2 = scanner.nextInt();
        
        int start;
        
        int end;
        
        
        if(num1 < num2) {
            start = num1;
            end = num2;
        } else {
            start = num2;
            end = num1;
        }
        
        for(int i = start; i <= end; i++) {
            System.out.println(i);
        }
        
        

        System.out.println("-----------------\n");

        System.out.println("6번");
        
        // 합을 저장할 변수
        int sum = 0;
        
        System.out.println("숫자를 입력해주세요.");
        System.out.print("> ");
        num = scanner.nextInt();
        
        for(int i = 1; i <= num; i++) {
            sum += i;
        }
        
        System.out.printf("1부터 %d까지의 합: %d\n", num, sum);

        System.out.println("-----------------\n");

        System.out.println("7번");
        
        sum = 1;
        
        System.out.println("숫자를 입력해주세요.");
        System.out.print("> ");
        num = scanner.nextInt();
        
        for(int i = 1; i <= num; i++) {
            sum*= i;
        }
        
        System.out.printf("1부터 %d까지의 곱: %d\n", num, sum);

        System.out.println("-----------------\n");

        scanner.close();
    }
}












