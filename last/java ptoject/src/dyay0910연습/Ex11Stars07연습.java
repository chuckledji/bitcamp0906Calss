package dyay0910연습;
import java.util.Scanner;
public class Ex11Stars07연습 {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("별찍기7번");
        System.out.println("출력할 줄 수를 입력하시오");
        System.out.println("> ");
        int num = scanner.nextInt();
        
        for(int i = 1; i <= num; i++) {
            String stars ="";
            for(int j = 1; j <= i; j++) {
                stars += "*";
            }
                          
           
            for(int j = i; j <= num-1; j++) {
                stars += "*";
            }
                          
            System.out.println(stars);
            
        }
        
        
        
        scanner.close();
    }
}
