package day0910;
import java.util.Scanner;
public class Ex09Star8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
       System.out.println ("별찍기 8번");
       System.out.println ("출력할 줄 수를 입력해주세요");
       System.out.println("> ");
       int num = scanner.nextInt();
        
       
       //윗부분
        for(int i =1; i <=2* num-1; i++) {
           String stars = "";
           
           if (i < num) {
               //윗부분
               
               //공백을 담당하는 j for문
               for(int j =1; j <=num - i; j++) {
                   stars +=" ";
                   
               }
               
               //별을 담당하는 j for문
               for(int j =1; j <= i; j++) {
                   stars +="*";
           }else {
               //아랫부분
           }
           System.out.println(stars);
        }
               
        
        scanner.close();
    }
}
