package day0908;
// 사용자로부터
// 이름 국어 영어 수학 순으로 입력받아서
// 만약 총점이 210점 미만이거나 
// 한 과목이라도 60점 미만일 때에는
// "### 학생은 불합격입니다" 라고 출력되고
// 그외는 "###학생은 합격입니다" 라고 출력되는
// 프로그램을 작성하시오
import java.util.Scanner;

public class Ex06TfElse3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //총점기준
        final int SUM_STANDARD = 210;
        
        //과목별기준
        final int SUBJECT_STANDARD = 60;
        
        // 이름입력
        System.out.println("이름을 입력해주세요.");
        System.out.print("> ");
        String name = scanner.nextLine();
        
        //국어입력
        System.out.println("국어 점수를 입력해주세요.");
        System.out.print("> ");
        int korean = scanner.nextInt();
        
        //영어입력
        System.out.println("영어 점수를 입력해주세요.");
        System.out.print("> ");
        int english = scanner.nextInt();
        
        //수학입력
        System.out.println("수학 점수를 입력해주세요.");
        System.out.print("> ");
        int math = scanner.nextInt();
        
        //총점계산
        int sum = korean + english + math;
        
        
        
        if (sum < SUM_STANDARD || korean < SUBJECT_STANDARD || english < SUBJECT_STANDARD || math < SUBJECT_STANDARD) {
         // 210점보다 작다 보다 기준을 세워놓고 기준으로 비교하는것이 깔끔하다
            System.out.printf("%s학생은 불합격입니다\n", name); //( name + "학생은 합격입니다")
            
        } else {
            System.out.printf("%s학생은 합격입니다\n", name);
            
        }
        
        scanner.close();
        
    }
}
