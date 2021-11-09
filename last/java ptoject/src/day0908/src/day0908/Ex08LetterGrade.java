package day0908;
// 사용자로부터 점수를 입력받아서
// 90~: A
// 80~: B
// 70~: C
// 60~: D
// 그외: F
// 가 출력되는 프로그램을 작성하시오
// 2시 55분까지
import java.util.Scanner;
public class Ex08LetterGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 점수 입력
        System.out.println("점수를 입력해주세요. ");
        System.out.print("> ");
        int score = scanner.nextInt();
        
        if(score >= 90) {
            System.out.println("A");
        } else if(score >= 80) {
            System.out.println("B");
        } else if(score >= 70) {
            System.out.println("C");
        } else if(score >= 60) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
        
        scanner.close();
    }
}
