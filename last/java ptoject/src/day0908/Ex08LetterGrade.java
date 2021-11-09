package day0908;
//사용자로부터 점수를 입력받아서
// 90~: A
// 80~: B
// 70~: C
// 60~: D
// 그외: F
// 가 출력되는 프로그램을 작성하시오.
import java.util.Scanner;
public class Ex08LetterGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("점수를 입력해주세요.");
        System.out.print("> ");
        int number = scanner.nextInt();
        
        if (number >= 90) {
            System.out.println("A");
        } else if(number >= 80){
            System.out.println("B");
        } else if(number >= 70){
            System.out.println("C");
        } else if(number >= 60){
            System.out.println("D");
        } else if(number < 60){
            System.out.println("F");
        } 
        
        scanner.close();
}
}