package dyay0910연습;
import java.util.Scanner;
public class Ex08Stars4 {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("별찍기 4번");
        System.out.println("출력할 줄 수를 입력해주세요");
        System.out.println("> ");
        int num = scanner.nextInt();
        
        for( int i = 1; i<= num; i++) {
            String stars = "";
            for(int j = 1; j <= i - 1; j++) {
                stars += " ";
            }
            for(int j = i; j<=num; j++) {
                stars += "*";
            }
            
            System.out.println(stars);
        }
       
        
        
        
        
        scanner.close();
    }
}
