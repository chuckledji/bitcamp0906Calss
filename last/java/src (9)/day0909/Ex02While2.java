package day0909;
// 사용자로부터 숫자를 입력받아서 출력하는 프로그램.
// 단 사용자가 0을 입력하면 0이 아닌 숫자가 입력될때까지
// 다시 입력되도록 코드를 작성해보시오.
// 9시 47분까지
import java.util.Scanner;
public class Ex02While2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("숫자를 하나 입력하세요.");
        System.out.print("> ");
        int num = scanner.nextInt();
        
        while(num == 0) {
            System.out.println("0이 아닌 숫자를 입력해주세요.");
            
            System.out.println("숫자를 하나 입력하세요.");
            System.out.print("> ");
            num = scanner.nextInt();
        }
        
        System.out.println("사용자가 입력한 숫자: " + num);        
        
        scanner.close();
    }
}
