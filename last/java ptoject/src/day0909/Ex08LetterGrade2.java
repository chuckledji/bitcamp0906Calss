package day0909;
// 사용자로부터 점수를 입력받아
// A, B, C, D, F를 출력하는 프로그램.
// 단 사용자가 입력을 누르면 입력 기능이 실행되고
//출력 기능을 실행하면 가장 마지막에 입력한 점수와 알파벳이 출력된다.
// 또한, 잘못된 점수를 입력했을 경우, 올바른 점수가 입력될때까지 다시 입력을 받는다.

// 힌트: 변수의 유효범위
import java.util.Scanner;
public class Ex08LetterGrade2 {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);
    
        while(true) {
        System.out.println("실행할 기능을 선택해 주세요.");
        System.out.println("1. 입력 2. 출력");
        System.out.println("> ");
        int userChoice = scanner.nextInt();
        
        //입력선택했을 시
        if (userChoice == 1 ) {
        
        System.out.println("점수를 입력해주세요.");
        System.out.println("> ");
        int number = scanner.nextInt();
        
        //만약 잘못입력했을 시
        if(number <0 || number >= 100) {
            System.out.println("잘못 입력하셨습니다.");
            System.out.println("점수를 입력해주세요.");
            System.out.println("> ");
            int number = scanner.nextInt();
        }
        }
        
        
        else if (userChoice == 2){
            if (number >= 90) {
                System.out.print("점수는 A" );
            } else if (number >= 80) {
                System.out.print("점수는 B" );
            } else if (number >= 70) {
                System.out.print("점수는 C" );
            } else if (number >= 60) {
                System.out.print("점수는 D" );
            }else  {
                System.out.print("점수는 F" );
                
            }break; 
        }
    
        } 
       scanner.close(); 
    }
    
}
