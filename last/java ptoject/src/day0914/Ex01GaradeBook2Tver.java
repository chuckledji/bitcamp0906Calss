package day0914;
// 5명의 학생의 정보를 차례대로 입력받고

// 차례대로 출력하는 프로그램을 작성하시오

// 1번 학생의 번호, 이름,국어, 영어, 수학
// 2번...
// 3번...
// 4번...
// 5번...
// 입력후에
//---------
// ###학생정보
//----------
// 번호:###번 이름:###
//....
import java.util.Scanner;

public class Ex01GaradeBook2Tver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 상수입력
        final int SUBJECT_SIZE = 3;
        final int STUDENT_SIZE = 5;

        // 변수입력
        int[] idArray = new int[STUDENT_SIZE];
        String[] nameArray = new String[STUDENT_SIZE];
        int[] koreanArray = new int[SUBJECT_SIZE];
        int[] mathArray = new int[SUBJECT_SIZE];
        int[] englishArray = new int[SUBJECT_SIZE];

        // 각 배열에 차례대로 입력을 받는다.
        for (int i = 0; i < STUDENT_SIZE; i++) {

            System.out.println("------------------");
            System.out.printf("%d번째 학생\n", i + 1);
            System.out.println("------------------");

            // 번호입력
            System.out.println("번호를 입력해주세요");
            System.out.println("> ");
            idArray[i] = scanner.nextInt();

            // 이름입력
            System.out.println("이름을 입력해주세요");
            System.out.println("> ");
            scanner.nextLine();
            nameArray[i] = scanner.nextLine();

            // 국어입력
            System.out.println("국어점수를 입력해주세요");
            System.out.println("> ");
            koreanArray[i] = scanner.nextInt();

            while (!(koreanArray[i] == 0 && koreanArray[i] <= 100)) {
                System.out.println("잘못입력하셨습니다");

                System.out.println("국어점수를 입력해주세요");
                System.out.println("> ");
                koreanArray[i] = scanner.nextInt();
            }
            // 수학입력
            System.out.println("수학점수를 입력해주세요");
            System.out.println("> ");
            mathArray[i] = scanner.nextInt();

            while (!(mathArray[i] == 0 && mathArray[i] <= 100)) {
                System.out.println("잘못입력하셨습니다");

                System.out.println("수학점수를 입력해주세요");
                System.out.println("> ");
                koreanArray[i] = scanner.nextInt();
            }
            // 영어입력
            System.out.println("영어점수를 입력해주세요");
            System.out.println("> ");
            englishArray[i] = scanner.nextInt();

            while (!(englishArray[i] == 0 && englishArray[i] <= 100)) {
                System.out.println("잘못입력하셨습니다");

                System.out.println("영어점수를 입력해주세요");
                System.out.println("> ");
                englishArray[i] = scanner.nextInt();
            }
        }
        // 각 배열에 차례대로 출력한다.
        for (int i = 0; i < STUDENT_SIZE; i++) {
            System.out.println("--------------------------");
            System.out.println(nameArray[i] + "학생의 정보");
            System.out.println("--------------------------");
            
            //이번에 출력할 학생의 번호
            int id = idArray[i];
            //이번에 출력할 학생의 이름
            String name = nameArray[i];
            //이번에 출력할 국어점수
            int korean = koreanArray[i];
            //이번에 출력할 수학점수
            int math = mathArray[i];
            //이번에 출력할 영어점수
            int english = englishArray[i];
            
            //총점
            int sum = korean + english + math;
            
            //평균 
            double average = (double) sum / SUBJECT_SIZE;
            
            System.out.printf("번호 :%d번 이름: %s\n", id, name);
            
            System.out.printf("국어점수: %03d 수학점수: %03d 영어점수: %03d\n",korean, math, english);
            System.out.printf("총점: %03d 평균: %06.2f점\n", sum, average);
            
            System.out.println("===========================\n");
        }
        scanner.close();
    }

}
