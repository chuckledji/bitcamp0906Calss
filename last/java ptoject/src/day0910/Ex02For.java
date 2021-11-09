package day0910;
// for문에 대한 기본 예제들

// 1. 1부터5까지 출력해라
// 2. 10부터 7까지 출력해라
// 3. 7부터 11까지 짝수를 출력해라
// 4. 사용자로부터 숫자를 입력받아서
//    1부터 그수까지 출력해라
// 5. 사용자로부터 숫자를 ㅍ2개 입력받아서
//    더 작은 수부터 더 큰ㄴ수까지 출력해라
// 6. 사용자로부터 숫자를 1개 입력받아서
//    1부터 그수까지의 합을 구하여 출력해라
// 7. 사용자로부터 숫자를 1개 입력받아서 1부터 
//    그수까지의 곱을 구하여 출력해라
import java.util.Scanner;
public class Ex02For {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("1번");
     // 1. 1부터5까지 출력해라
        
        for(int i = 1; i <= 5; i++) {
            System.out.println(i);
        }
        System.out.println("--------------------------------");
        
        
        System.out.println("2번");
        //2. 10부터 7까지 출력해라
        
        for(int i = 10; i >= 7; i--) {
            System.out.println(i);
        }
        System.out.println("--------------------------------");
        
        
        System.out.println("3번");
        // 3. 7부터 11까지 짝수를 출력해라.
      
        for(int i = 7; i <= 11; i++) {
            if(i % 2 == 0) {System.out.println(i);
        }
        }
        System.out.println("--------------------------------");
        
        
        System.out.println("4번");
        // 4. 사용자로부터 숫자를 입력받아서
        //    1부터 그수까지 출력해라
        
        System.out.println("숫자를 입력하세요");
        System.out.println("> ");
        int num = scanner.nextInt();
        
        for(int i = 1; i <= num; i++) {
            System.out.println("i의 현재값: " +i);
        }
        System.out.println("--------------------------------");
        
        
        System.out.println("5번");
        // 5. 사용자로부터 숫자를 2개 입력받아서
        //    더 작은 수부터 더 큰 수까지 출력해라
        
        System.out.println("첫번째 숫자를 입력하세요");
        System.out.println("> ");
        int num1 = scanner.nextInt();
        
        System.out.println("두번째 숫자를 입력하세요");
        System.out.println("> ");
        int num2 = scanner.nextInt();
        
        int start;
        
        int end;
                
        if(num1 < num2) {
           start = num1;
           end = num2;
        }
        }else {
            start = num2;
            end = num1;
        }
        for(int i = start; i = end; i++) {
            System.out.println(i);
        }
        System.out.println("--------------------------------");
        
        
        System.out.println("6번");
        // 6. 사용자로부터 숫자를 1개 입력받아서
        //    1부터 그수까지의 합을 구하여 출력해라
        
        //합을 저장할 변수
        int sum = 0;
        
        System.out.println("첫번째 숫자를 입력하세요");
        System.out.println("> ");
        num = scanner.nextInt();
        
        for(int i = 1; i <= num; i++) {
            sum += i;
        }
        
        System.out.println("--------------------------------");
        
        
        System.out.println("7번");
        // 7. 사용자로부터 숫자를 1개 입력받아서 1부터 
        //    그수까지의 곱을 구하여 출력해라
        
        
      scanner.close();
    }
    
}
