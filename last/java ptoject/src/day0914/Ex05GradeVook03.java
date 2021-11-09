package day0914;
// 국어 영어 수학을 
// 개별의 1차원 개별이 아니라
//scoreArray라는 2차원배열을 만들어서
// 해당 2차원배열의 각 배열의 0번인덱스에는 국어 점수가,
// 1번인덱스에는 영어 점수가
// 2번 인덱스에는 수학점수가 들어가게 프로그램을 만들어보세요

//단, 점수가 올바른지 체크, 입력종료츌력 안해도 됨
//차례대로 입력되게 만드시오
//학생수는 5명
import java.util.Scanner;
public class Ex05GradeVook03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        final int STUDENT_SIZE = 5;
        final int SUBJECT_SIZE = 3;
        int [][] student = new int[STUDENT_SIZE][SUBJECT_SIZE];
        
        for(int i = 0; i < STUDENT_SIZE; i++) {
            System.out.printf("%d번째 학생의 정보\n", i+1);
            System.out.println("국어점수를 입력하시오");
            System.out.println("> ");
            student [i][0] = scanner.nextInt();
            
            System.out.println("영어점수를 입력하시오");
            System.out.println("> ");
            student [i][1] = scanner.nextInt();
            
            System.out.println("수학점수를 입력하시오");
            System.out.println("> ");
            student [i][2] = scanner.nextInt();
           
        }
        for(int i = 0; i < STUDENT_SIZE; i++) {
            System.out.printf("%d번째 학생의 정보: ", i+1);
            
                System.out.printf("국어점수 : %d \n", student[i][0]);
                System.out.printf("영어점수 : %d \n", student[i][1]);
                System.out.printf("수학점수 : %d \n", student[i][2]);
            
        }
        
        
     scanner.close();   
    }
}
