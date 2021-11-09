package day0910;
import java.util.Scanner;
public class Ex08Sta7r {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
       System.out.println ("별찍기 1번");
       System.out.println ("출력할 줄 수를 입력해주세요");
       System.out.println("> ");
       int num = scanner.nextInt();
        
       
       //윗부분
        for(int i =1; i <= num; i++) {
            for(int j =1; j <= i; j++) {
                System.out.print("*");
              }
        }
               
        
        scanner.close();
    }
}
