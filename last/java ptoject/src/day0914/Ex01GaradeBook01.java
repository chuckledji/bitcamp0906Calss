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

public class Ex01GaradeBook01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 상수입력
        final int SIZE = 6;
                
        int[] student = new int[SIZE];
        
        //1.학생정보 입력
        // 번호입력
        for (int i = 0; i < student.length; i++) {
            
            String name = "";
            int num = 0;
            int korean = 0;
            int math = 0;
            int english = 0;
            
            System.out.println("번호를 입력하세요");
            System.out.println("> ");
            num = scanner.nextInt();

            // 이름입력
            System.out.println("이름을 입력하세요");
            System.out.println("> ");
            scanner.nextLine();
            name = scanner.nextLine();

            // 국어점수입력

            System.out.println("국어점수를 입력하세요");
            System.out.println("> ");
            KOREAN = scanner.nextInt();

            // 수학점수입력
            System.out.println("수학점수를 입력하세요");
            System.out.println("> ");
            MATH = scanner.nextInt();

            // 영어점수입력
            System.out.println("영어점수를 입력하세요");
            System.out.println("> ");
            ENGLISH = scanner.nextInt();
          }
        
        //2. 학생정보 출력
        for(int i = 0; i < student.length; i++) {
            System.out.printf("%s 학생정보\n 번호: %3d번 이름: %s \n국어점수: %d 수학점수: %d 영어점수: %d\n",NAME, NUM, NAME, KOREAN, MATH, ENGLISH);
            
        }

        scanner.close();
    }
}
