package day0916;
// 동적할당을 사용한 학생관리 프로그램2
// 전역 변수를 적용시킨프로그램
import java.util.Scanner;

import util.ArrayUtil;
import util.ScannerUtil;
public class Ex04GradeBook04 {
    //전역 상수
    static final int MAX_STUDENT = 5;
    static final int SUBJEXT_SIZE = 3;
    static final int SCORE_MIN = 0;
    static final int SCORE_MAX = 100;
    //전역 변수
    static Scanner scanner =new Scanner(System.in);
    static int[] idArray =new int[0];
    static String[] nameArray =new String[0];
    static int[] koreanArray =new int[0];
    static int[] englishArray =new int[0];
    static int[] mathArray =new int[0];
    
    //1. 입력을 담당하는 insert()메소드
    public static void insert()//파라미터 따로 필요없음
    String message;
    message = "번호를 입력해주세요";
    int id = ScannerUtil.nextInt(scanner,  message);
    idArray = ArrayUtil.add(idArray, id);
    
    message = "이름을 입력해주세요";
    String name = ScannerUtil.nextString(scanner,  message);
    nameArray = ArrayUtil.add(nameArray, name);
    
    message = "국어점수를 입력해주세요";
    int korean = ScannerUtil.nextInt(scanner,  message, SCORE_MIN, SCORE_MAX);
    koreanArray = ArrayUtil.add(koreanArray, korean);
    
    message = "수학점수를 입력해주세요";
    int math = ScannerUtil.nextInt(scanner,  message, SCORE_MIN, SCORE_MAX);
    mathArray = ArrayUtil.add(mathArray, math);
    
    message = "영어점수를 입력해주세요";
    int english = ScannerUtil.nextInt(scanner,  message, SCORE_MIN, SCORE_MAX);
    englishArray = ArrayUtil.add(englishArray, english);
    
        
    }

    
    //2. 목록출력을 담당하는 printAll()매소드
    public static void printAll() {
        if(ArrayUtil.isEmpty(idArray)) {
            System.out.println("입력한정보가없습니다");
            
        }else {
            for(int i = 0; i < ArrayUtil.size(idArray); i++) {
             System.out.printf("%d. [%s] \n", i+1, ArrayUtil.get(nameArray,  i));         
             
            
           }
            String message = "개별보기할 학생의 번호를 입력해주세요";
            int userchoice = ScannerUtil.nextInt(scanner,  message, 1, ArrayUtil.size(idArray)) -1;
            
            printOne(userChoice);
       }
    }
    //3. 개별정보출력을 담당하는 printOne()메소드
    public static void printOne(int index) {
        int id = ArrayUtil.get(idArray, index);
        String name = ArrayUtil.get(nameArray, index);
        int korean = ArrayUtil.get(koreanArray, index);
        int math = ArrayUtil.get(mathArray, index);
        int english = ArrayUtil.get(englishArray, index);
        
        int sum = korean + english + math;
        double average = (double) sum / SUBJECT_SIZE;

        System.out.printf("번호: %d번 이름: %s\n", id, name);
        System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", korean, english, math);
        System.out.printf("총점: %03d점 평균: %06.2f점\n", sum, average);

        String message = ("1.수정 2. 삭제 3. 뒤로가기");
       
        int userChoice = Scanner.nextInt(scanner, message, 1, 3);
        if(userChoice == 1) {
            //수정메소드호출
            update(index);
    }else if(userChoice==2){
        //삭제메소드호출
        delete(index);
        
    }else if(userChoice==3) {
        printAll();
    }
    } 
    //4. 메뉴출력을 담당하는 showMenu()메소드
    public static void showMenu() {
        while(true) {
            String message = "1.입력 2.출력 3.종료";
            int userChoice = ScannerUtil.nextInt(scanner, message);
            if(userChoice ==1) {
                //입력을 담당하는 메소드 호출
                insert();
                
            }else if(userChoice == 2) {
              //목룍출력을 담당하는 메소드 호출
                printAll();
               
            }else if(userChoice == 3) {
              //종료코드실행
                System.out.println("사용해주셔서 감사합니다"); 
               break;
            }
        }
    }
    //5.메인메소드
    public static void main(String[] args) {
        //메뉴 메소드 호출
        showMenu();
        
        //메뉴 메소드 종료시, scanner클래스 변수를 닫아준다
        scanner.close();
    }
    //6. 학생의 정보 수정을 담당하는 uppdate()메소드
    public static void update(int index) {
        String message;
        message="새로운 국어 점수를 입력해주세요";
        int korean = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);
        ArrayUtil.set(koreanArray, index, korean);
        
        message="새로운 수학 점수를 입력해주세요";
        int math = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);
        ArrayUtil.set(mathArray, index, math);
        
        message="새로운 영어 점수를 입력해주세요";
        int english = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);
        ArrayUtil.set(englishArray, index, english);
        
        printOne(index);
    }
    //7. 학생의 정보 삭제를 담당하는 delete()메소드
    public static void delete(int index) {
        String message = "정말로 삭제하시겠습니까? y/n";
        String yesNo = ScannerUtil.nextLine(scanner, message);
        
        if(yesNo.equalsIgnoreCase("y")) {
            idArray = ArrayUtil.removeByIndex(idArray, index);
            nameArray = ArrayUtil.remove(nameArray, index);
            koreanArray = ArrayUtil.removeByIndex(koreanArray, index);
            mathArray = ArrayUtil.removeByIndex(mathArray, index);
            englishArray = ArrayUtil.removeByIndex(englishArray, index);
            
            printAll();
        }else {
            printOne(index);
        }
    }
}
