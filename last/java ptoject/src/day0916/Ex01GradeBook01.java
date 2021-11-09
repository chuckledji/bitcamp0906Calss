package day0916;
// 동적할당을 사용한 배열을 이용하여 학생관리 프로그램을 작성하시오
// 단 관리가능한 최대 학생은 5명입니다
import java.util.Scanner;
import util.ArrayUtil;
import util.ScannerUtil;
public class Ex01GradeBook01 {
 
    // 상수
    static final int SUBJECT_SIZE = 3;
    static final int STUDENT_SIZE = 5;
    static final int SCORE_MIN = 0;
    static final int SCORE_MAX = 100;

    public static void main(String[] args) {
   
    // 변수
    Scanner scanner = new Scanner(System.in);
    int[] idArray = new int[0];
    String[] nameArray = new String[0]; //동적할당을 넣을거기 때문에 0에서 시작한다
    int[] koreanArray = new int[0];
    int[] englishArray = new int[0];
    int[] mathArray = new int[0];
//    int curIndex = 0; //필요없어짐

    while (true) {
        String message = "1. 입력 2. 출력 3. 종료";
        int userChoice = ScannerUtil.nextInt(scanner, message);

        if (userChoice == 1) {
            // 입력 코드 구현
            if (ArrayUtil.size(idArray) < STUDENT_SIZE) 
            // 더 입력 가능한 상태
                {
                
                message = "학생의 번호를 입력해주세요.";
                int id = ScannerUtil.nextInt(scanner, message);
                idArray = ArrayUtil.add(idArray, id);

//              idArray = ArrayUtil.add(idArray, ScannerUtil.nextInt(scanner, message));
               //이렇게 한줄로 줄일수있음
                
                
                message = "학생의 이름을 입력해주세요.";
                String name = ScannerUtil.nextLine(scanner, message);
                nameArray = ArrayUtil.add(nameArray, name);
                
                message = "학생의 국어 점수를 입력해주세요.";
                int korean = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);
                koreanArray = ArrayUtil.add(koreanArray, korean);
                
                message = "학생의 영어 점수를 입력해주세요.";
                int english = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);
                englishArray = ArrayUtil.add(englishArray, english);
                
                message = "학생의 수학 점수를 입력해주세요.";
                int math = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);
                mathArray = ArrayUtil.add(mathArray, math);
                
                // 다음 입력위치 1 증가하던 curIndex++; 필요없어짐

            } else {
                //더이상 입력할 수없는 상태
                System.out.println("더이상 입력하실 수 없습니다.");
            }

        } else if (userChoice == 2) {
            // 출력 코드 구현
            if (ArrayUtil.isEmpty(idArray)) //이젠 어레이유틸을 사용해서 간단하게 할 수 있다
            { System.out.println("아직 입력된 학생이 존재하지 않습니다.");
            } else {
                for (int i = 0; i < ArrayUtil.size(idArray); i++) {
                    System.out.println("----------------------------");
                    System.out.println(nameArray[i] + " 학생의 정보");
                    System.out.println("----------------------------");

                    int id = ArrayUtil.get(idArray, i);
                    String name = ArrayUtil.get(nameArray, i);
                    int korean = ArrayUtil.get(koreanArray, i);
                    int english = ArrayUtil.get(englishArray,i);
                    int math = ArrayUtil.get(mathArray, i);

                    int sum = korean + english + math;

                    double average = (double) sum / SUBJECT_SIZE;

                    System.out.printf("번호: %d번 이름: %s\n", id, name);
                    System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", korean, english, math);
                    System.out.printf("총점: %03d점 평균: %06.2f점\n", sum, average);

                    System.out.println("============================\n");
                }

            }

        } else if (userChoice == 3) {
            // 종료 코드 구현
            System.out.println("사용해주셔서 감사합니다.");
            break;
        }
    }

    scanner.close();
}
}
