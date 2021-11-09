package day0909;
// 사용자로부터 점수를 입력받아
// A, B, C, D, F가 알맞게 출력되는 프로그램을 작성하시오.
// 단, 사용자가 잘못된 점수를 입력할 경우, 올바른 점수가 입력될 때까지
// 다시 입력을 받도록 작성하시오.

// 10시 10분까지

import java.util.Scanner;
public class Ex03LetterGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("점수를 입력해주세요.");
        System.out.print("> ");
        int score = scanner.nextInt();
        
        while( score < 0 || score > 100 ) {
            System.out.println("잘못 입력하셨습니다.");
            
            System.out.println("점수를 입력해주세요.");
            System.out.print("> ");
            score = scanner.nextInt();
                    
        }
        
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












