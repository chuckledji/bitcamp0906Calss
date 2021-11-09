package day0909;
// 사용자로부터

// 번호, 이름, 국어, 영어, 수학 점수 순으로 입력받아서
// 다음과 같은 형식으로 출력되는 프로그램을 작성하시오

import java.util.Scanner; 
public class Ex04GradeBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 과목의 개수를 저장할 상수
        final int SUBJECT_SIZE = 3;

        // 사용자가 입력한 int 값을 임시로 보관할 변수
        int temp;
        
        // 번호 입력
        System.out.println("번호를 입력해주세요.");
        System.out.print("> ");
        int id = scanner.nextInt();

        
        // 이름입력
        System.out.println("이름을 입력해주세요.");
        System.out.print("> ");
        scanner.nextLine();
        String name = scanner.nextLine();

        // 국어입력
        System.out.println("국어 점수를 입력해주세요.");
        System.out.print("> ");
        temp = scanner.nextInt();

        while(!(temp <=100 && temp >= 0))
      //while(temp >100 || temp < 0) 
        {
            System.out.println("잘못 입력하셨습니다.");
            System.out.println("국어 점수를 입력해주세요.");
            System.out.print("> ");
            temp = scanner.nextInt();
        }
        int korean = temp;
        
        // 영어입력
        System.out.println("영어 점수를 입력해주세요.");
        System.out.print("> ");
        temp = scanner.nextInt();

        while(!(temp <=100 && temp >= 0))
      //while(temp >100 || temp < 0) 
        {
            System.out.println("잘못 입력하셨습니다.");
            System.out.println("영어 점수를 입력해주세요.");
            System.out.print("> ");
            temp = scanner.nextInt();
        }
        int english = temp;
        
        // 수학입력
        System.out.println("수학 점수를 입력해주세요.");
        System.out.print("> ");
        temp = scanner.nextInt();

        while(!(temp <=100 && temp >= 0))
      //while(temp >100 || temp < 0) 
        {
            System.out.println("잘못 입력하셨습니다.");
            System.out.println("수학 점수를 입력해주세요.");
            System.out.print("> ");
            temp = scanner.nextInt();
        }
        int math = temp;
        
        // 총점 계산
        int sum = korean + english + math;

        // 평균 계산
        double average = (double) sum / SUBJECT_SIZE;

        // 결과출력
        System.out.printf("번호: %d번 이름: %s\n", id, name);
        System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", korean, english, math);
        System.out.printf("총점: %03d점 평균: %06.2f점\n", sum, average);

        scanner.close();

    }
}
