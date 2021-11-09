package day0909;
// 사용자로부터

// 번호, 이름, 국어, 영어, 수학 점수 순으로 입력받아서
// 다음과 같은 형식으로 출력되는 프로그램을 작성하시오

import java.util.Scanner;

public class Ex04GradeBook2연습 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 과목의 개수를 저장할 상수
        final int SUBJECT_SIZE = 3;
        
        int id = 0;
        String name = "";
        int korean = 0;
        int english = 0;
        int math = 0;
        
                
        
        while(true) {
            System.out.println("1. 입력 2. 출력 3. 종료");
            System.out.println("> ");
            int num = scanner.nextInt();
 
          //1. 사용자가 입력을 눌렀을 때
            if (num == 1) {
          
             // 번호 입력
                System.out.println("번호를 입력해주세요.");
                System.out.print("> ");
                id = scanner.nextInt();

                
                // 이름입력
                System.out.println("이름을 입력해주세요.");
                System.out.print("> ");
                scanner.nextLine();
                name = scanner.nextLine();

                // 국어입력
                System.out.println("국어 점수를 입력해주세요.");
                System.out.print("> ");
                korean = scanner.nextInt();

                while(!(korean <=100 && korean >= 0))
              //while(temp >100 || temp < 0) 
                {
                    System.out.println("잘못 입력하셨습니다.");
                    System.out.println("국어 점수를 입력해주세요.");
                    System.out.print("> ");
                    korean = scanner.nextInt();
                }
                
                // 영어입력
                System.out.println("영어 점수를 입력해주세요.");
                System.out.print("> ");
                english = scanner.nextInt();

                while(!(english <=100 && english >= 0))
              //while(english >100 || english < 0) 
                {
                    System.out.println("잘못 입력하셨습니다.");
                    System.out.println("영어 점수를 입력해주세요.");
                    System.out.print("> ");
                    english = scanner.nextInt();
                }
                
                // 수학입력
                System.out.println("수학 점수를 입력해주세요.");
                System.out.print("> ");
                math = scanner.nextInt();

                while(!(math <=100 && math >= 0))
              //while(temp >100 || temp < 0) 
                {
                    System.out.println("잘못 입력하셨습니다.");
                    System.out.println("수학 점수를 입력해주세요.");
                    System.out.print("> ");
                    math = scanner.nextInt();
                }
                
            }
            //2. 사용자가 출력을 눌렀을 때
            else if (num == 2) {
                
                if(id == 0 || name = "" || korean = 0 ||  english = 0 || math = 0) {
                    System.out.println("입력을하지않았습니다. 입력해주세요");
                }else {
               
             // 총점 계산
                int sum = korean + english + math;

                // 평균 계산
                double average = (double) sum / SUBJECT_SIZE;

                // 결과출력
                System.out.printf("번호: %d번 이름: %s\n", id, name);
                System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", korean, english, math);
                System.out.printf("총점: %03d점 평균: %06.2f점\n", sum, average);
                }
            }else if (num == 3) {
                //3. 사용자가 종료를 눌렀을 때
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
      
       scanner.close();

    }
}
