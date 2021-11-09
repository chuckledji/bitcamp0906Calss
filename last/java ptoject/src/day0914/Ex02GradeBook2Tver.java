package day0914;

// 배열을 사용하되
// 입력과 출력을 메뉴로 분리시켜서
// 사용자가 개별 기능을 따로 입력시키는
// 학생관리 프로그램을 만들어보시오
import java.util.Scanner;

public class Ex02GradeBook2Tver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 다음에 입력을 '할' 인덱스를 저장한 int변수
        // int curIndex =0;
        //위의 curIndex를 사용하면
        // 한명도 입력이 안된 상태에서 출력을 할 시에는
        // "아직 입력된 학생의 정보가 없습니다"를 출력하거나
        // 혹은 5명을 초과하여 입력할 시에는
        // "더이상 입력하실 수 없습니다"라고 출력해줄수도있고
        //출력 시에는 현재 입력된 학생들만 출력 가능하다.
        
        //상수
        //1.과목숫자
        final int SUBJECT_SIZE = 3;
        //2.학생숫자
        final int STUDENT_SIZE = 5;
        
        //변수입력
        int[] idArray = new int[STUDENT_SIZE];
        String[] nameArray = new String[STUDENT_SIZE];
        int[] koreanArray = new int[SUBJECT_SIZE];
        int[] mathArray = new int[SUBJECT_SIZE];
        int[] englishArray = new int[SUBJECT_SIZE];
        int curIndex =0;
        
        
        //사용자선택
        while (true) {
            System.out.println("1.입력 2.출력 3.종료");
            System.out.println("> ");
            int userChoice = scanner.nextInt();
            
          //1. 입력을 눌렀을 시
            if (userChoice == 1) {
                
             if(curIndex < STUDENT_SIZE) {
                 //각 배열의 curIndex번 인덱스에 정보를 입력한다.
                
                     // 번호입력
                     System.out.println("번호를 입력해주세요");
                     System.out.println("> ");
                     idArray[curIndex] = scanner.nextInt();

                     // 이름입력
                     System.out.println("이름을 입력해주세요");
                     System.out.println("> ");
                     scanner.nextLine();
                     nameArray[curIndex] = scanner.nextLine();

                     // 국어입력
                     System.out.println("국어점수를 입력해주세요");
                     System.out.println("> ");
                     koreanArray[curIndex] = scanner.nextInt();

                     while (!(koreanArray[curIndex] >= 0 && koreanArray[curIndex] <= 100)) {
                         System.out.println("잘못입력하셨습니다");

                         System.out.println("국어점수를 입력해주세요");
                         System.out.println("> ");
                         koreanArray[curIndex] = scanner.nextInt();
                     }
                     // 수학입력
                     System.out.println("수학점수를 입력해주세요");
                     System.out.println("> ");
                     mathArray[curIndex] = scanner.nextInt();

                     while (!(mathArray[curIndex] >= 0 && mathArray[curIndex] <= 100)) {
                         System.out.println("잘못입력하셨습니다");

                         System.out.println("수학점수를 입력해주세요");
                         System.out.println("> ");
                         koreanArray[curIndex] = scanner.nextInt();
                     }
                     // 영어입력
                     System.out.println("영어점수를 입력해주세요");
                     System.out.println("> ");
                     englishArray[curIndex] = scanner.nextInt();

                     while (!(englishArray[curIndex] >= 0 && englishArray[curIndex] <= 100)) {
                         System.out.println("잘못입력하셨습니다");

                         System.out.println("영어점수를 입력해주세요");
                         System.out.println("> ");
                         englishArray[curIndex] = scanner.nextInt();
                     }
                     curIndex++;
             } }
            
         //2.출력을 눌렀을 시
            else if (userChoice == 2) {
            if(curIndex == 0) {
                //아직정보가 입력되지 않았으므로 경고메세지만출력
                System.out.println("아직 입력한 정보가 없습니다");
                
            }else {
                //결과ㅣ출력
                //0번 인덱스부터 curIndex 보다 작은 인덱스까지 출력
                for (int i = 0; i < curIndex; i++) {
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
            }
          //3. 종료 눌렀을 시
            else if (userChoice == 3) { 
                System.out.println("프로그램을 종료합니다");
                break;            
            }
        }
        scanner.close();
    }
}
