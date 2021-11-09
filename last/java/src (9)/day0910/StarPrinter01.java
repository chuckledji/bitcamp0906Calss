package day0910;
// 별찍기 1번
import java.util.Scanner;
public class StarPrinter01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("별찍기 1번");
        System.out.println("출력할 줄 수를 입력해주세요.");
        System.out.print("> ");
        
        int userNum = scanner.nextInt();
        
        for(int i = 1; i <= userNum; i++) {
            String stars = "";
            
            for(int j = 1; j <= i; j++) {
                stars += "*";                
            }
            
            System.out.println(stars);
        }
        
        
        scanner.close();
    }
}
