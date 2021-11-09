package day0908;
// 검증(Validation)

// 검증이란, 입력된 값을 처리하기 전에 
// 해당 값이 올바른 값인지 확인하는 과정을 검증이라고 한다.

// 검증은 다양한 방법으로 진행할 수 있지만
// 우리는 여기서 2가지 방법의 검증을 알아볼 것이다.

import java.util.Scanner;

public class Ex12Validation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("점수를 입력해주세요. ");
        System.out.print("> ");
        int score = scanner.nextInt();

        System.out.println("값 검증이 안됬을 경우");

        if (score >= 90) {
            System.out.println("A");
        } else if (score >= 80) {
            System.out.println("B");
        } else if (score >= 70) {
            System.out.println("C");
        } else if (score >= 60) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }

        System.out.println("--------------------\n");
        
        System.out.println("검증 1번. 정확한 조건식 사용");
        // 정확한 조건식이란? 
        // 해당 코드 블락이 실행되는 정확한 if 조건식을 만들어서
        // 그 경우에만 코드 블락이 실행되기 if - else if를 만들어 주는 것을 뜻한다.
        
        // 정확한 조건식의 경우, 올바른 값의 범위가 연속적이지 않을 때
        // 사용하면 좋다.
        
        if(score >= 90 && score <= 100) {
            System.out.println("A");
        } else if(score >= 80 && score <= 89) {
            System.out.println("B");
        } else if(score >= 70 && score <= 79) {
            System.out.println("C");
        } else if(score >= 60 && score <= 69) {
            System.out.println("D");
        } else if(score >= 0 && score <= 59) {
            System.out.println("F");
        } else {
            System.out.println("잘못 입력하셨습니다.");
        }
        
        
        
        System.out.println("--------------------\n");
        
        System.out.println("검증 2번. 값이 올바른 범위에 속하는지 먼저 체크하기");
        // 만약 올바른 값이 범위의 형태라면
        // 먼저 값이 올바른 범위에 속하는지 체크하고
        // 만약 올바르다면 추가적으로 코드를 실행시킨다.
        // 만약 올바르지 않다면 경고 메시지만 출력해준다.
        
        if(score >= 0 && score <= 100) {
            
            // 사용자가 입력한 점수가 올바른 점수이므로(=0이상 100 이하의 정수)
            // if-else if 구조를 사용하여 A, B, C, D, F를 출력해준다.
            // 이때에는 잘못된 점수(100을 초과하거나 0 미만인 경우)는 
            // 이 if 코드 블락 안에 접근 할 수 없으므로
            // 조건식을 간단하게 써도 된다.
            
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
            
        } else {
            // 사용자가 입력한 점수가 올바르지 않은 경우이므로
            // 경고메시지만 출력
            
            System.out.println("점수는 0미만이거나 100을 초과할 수 없습니다.");
            
        }
        
        
        System.out.println("--------------------\n");

        scanner.close();
    }
}



















