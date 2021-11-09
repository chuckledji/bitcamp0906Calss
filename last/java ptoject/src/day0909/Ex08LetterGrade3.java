package day0909;
// 사용자로부터 점수를 입력받아
// A, B, C, D, F를 출력하는 프로그램.
// 단 사용자가 입력을 누르면 입력 기능이 실행되고
//출력 기능을 실행하면 가장 마지막에 입력한 점수와 알파벳이 출력된다.
// 또한, 잘못된 점수를 입력했을 경우, 올바른 점수가 입력될때까지 다시 입력을 받는다.

// 힌트: 변수의 유효범위
import java.util.Scanner;
public class Ex08LetterGrade3 {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        
        while(true) {
        System.out.println("1. 입력 2. 출력 3. 종료");
        System.out.println("> ");
        int userChoice = scanner.nextInt();

        
        if(userChoice == 1) {
            //1의 입력코드 구현
            System.out.println("점수를 입력해주세요.");
            System.out.println("> ");
            score = scanner.nextInt();
            
                while( !( score >=0 && score <= 100)) {
                    System.out.println("잘못입력하셨습니다.");
                    System.out.println("점수를 입력해주세요.");
                    System.out.println("> ");
                    score = scanner.nextInt();
                }
            
        } else if(userChoice == 2) {
            //2의 출력코드 구현
            
            if (score >= 90) {
                System.out.println("A" );
            } else if (score >= 80) {
                System.out.println("B" );
            } else if (score >= 70) {
                System.out.println("C" );
            } else if (score >= 60) {
                System.out.println("D" );
            } else  {
                System.out.println("F" );
            }
            
            
        } else if(userChoice == 3) {
            //메세지 출력 후 break
            System.out.println("사용해주셔서 감사합니다.");
            break;
        }
        
        }  
        
       scanner.close(); 
    }
    
}
