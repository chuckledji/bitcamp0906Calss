package day0914;
// 배열을 사용하되
// 입력과 출력을 메뉴로 분리시켜서
// 사용자가 개별 기능을 따로 입력시키는
// 학생관리 프로그램을 만들어보시오
import java.util.Scanner;
public class Ex02GradeBook02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 다음에 입력을 '할' 인덱스를 저장한 int변수
        int curIndex =0;
        //위의 curIndex를 사용하면
        // 한명도 입력이 안된 상태에서 출력을 할 시에는
        // "아직 입력된 학생의 정보가 없습니다"를 출력하거나
        // 혹은 5명을 초과하여 입력할 시에는
        // "더이상 입력하실 수 없습니다"라고 출력해줄수도있고
        //출력 시에는 현재 입력된 학생들만 출력 가능하다.
        
        //상수입력
        final int STUDENT_SIZE = 5;
        
        //변수입력
        int[] idArray = new int[STUDENT_SIZE];
        String[] nameArray = new String[STUDENT_SIZE];
        
        //사용자선택
        while (true) {
            System.out.println("1.입력 2.출력 3.종료");
            System.out.println("> ");
            int userChoice = scanner.nextInt();
            
          //1. 입력을 눌렀을 시
            if (userChoice == 1) {
             for(int i = 0; i < STUDENT_SIZE; i++) {
                 
              
                 // 번호입력
                 System.out.println("번호를 입력해주세요");
                 System.out.println("> ");
                 idArray[i] = scanner.nextInt();

                 // 이름입력
                 System.out.println("이름을 입력해주세요");
                 System.out.println("> ");
                 scanner.nextLine();
                 nameArray[i] = scanner.nextLine();   
                 
                 
               }curIndex += 1;
                
            }
            
         //2.출력을 눌렀을 시
            if (userChoice == 1) {
            if(curIndex == 0) {
                System.out.println("아직 입력한 정보가 없습니다");
                
            }else {
                //결과ㅣ출력
                System.out.printf("이름,학생번호);
            } }
          //3. 종료 눌렀을 시
            if (userChoice == 3) { 
                System.out.println("프로그램을 종료합니다");
                break;            
            }
        }
        
        
        
        
        scanner.close();
    }
}
