package HW;

import java.util.ArrayList;

import java.util.Scanner;

import classEx.Student2;
import util.ScannerUtil;


public class HW1Student2 {


  //상수
    final static int STUDENT_MAX = 5;
    final static int SCORE_MIN = 0;
    final static int SCORE_MAX = 100;
    
    //변수
    static Scanner scanner = new Scanner(System.in);
    static Student2[] arr = new Student2[0];
    //다음 입력할 학생의 번호를 저장할 변수
    static int nextId = 1;
    
    static ArrayList<classEx.Student>sList = new ArrayList<>();
    
    //메인메소드
    public static void main(String[] args) {
        showMenu();
        
    }
    //매뉴를 담당하는 showMenu()
    public static void showMenu() {
        while (true) {
            String message = "1.입력2.출력3.종료";
            int userChoice = ScannerUtil.nextInt(scanner, message);
            
            if (userChoice == 1) {
                //입력메소드호출
                insert();
            }else if(userChoice == 2) {
                //목록출력메소드호출
                printAll();
            }else if(userChoice ==3) {
                System.out.println("프로그램을 종료합니다");
                scanner.close();
                break;
            }
        }
    }
    
    //입력을 담당하는 insert()
    public static void insert() {
       if(sList.size() < STUDENT_MAX) {
         //입력받을 정보를 임시로 저장할 Student변수
           Student2 s = new Student2();
           
           //입력시 출력할 메세지를 담은 String 변수
           String message;
           
           //번호입력
           s.setId(nextId++);
           //이름입력
           message = "학생의 이름을 입력해주세요";
           s.setName(ScannerUtil.nextLine(scanner, message));
           
           //국어점수입력
           message = "학생의 국어점수를 입력해주세요";
           s.setKorean(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));
           
           //영어점수입력
           message = "학생의 영어점수를 입력해주세요";
           s.setEnglish(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));
           
           //수학점수입력
           message = "학생의 수학점수를 입력해주세요";
           s.setMath(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));
           
           //배열에s추가
          sList.add(s);
           
       }else {
           System.out.println("더이상 입력할 수 없습니다");
       }
    }
       
    
    //학생 목록출력을 담당하는 printAll()
    public static void printAll() {
        if(sList.isEmpty()) {
            System.out.println("아직입력한정보가없습니다");
        }else {
        for(int i = 0; i< sList.size(); i++) {
            System.out.printf("%d. %s\n", sList.get(i).getId(), sList.get(i).getName());
            
        }
        String message = "개별보기할 학생의 번호나 뒤로 가시려면 0을 입력해주세요";
        int userChoice = ScannerUtil.nextInt(scanner,  message, 0, sList.size()) - 1;
        
        if(userChoice != -1) {
            printOne(userChoice);
        }
        
        }
      }
    //개별학생출력을 담당하는printOne()
    public static void printOne(int index) {
        
        classEx.Student s = sList.get(index);
        
        System.out.println(s.getName() + "학생의정보"); 
       s.printInfo();
        
        String message = "1.수정 2.삭제 3.뒤로가기";
        int userChoice = ScannerUtil.nextInt(scanner,message, 1, 3);
        if(userChoice == 1) {
            //수정메소드호출
            update(index);
        }else  if(userChoice == 2) {
            //삭제메세지호출
            delete(index);
        }else if(userChoice == 3) {
            printAll();
        }
    }
    
    //학생 정보 수정을 담당하는 update()
    public static void update(int index) {
        Student s = sList.get(index); 
        
        String message;
      //국어점수입력
        message = "새로운 국어점수를 입력해주세요";
        s.setKorean(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));
        
        //영어점수입력
        message = "새로운 영어점수를 입력해주세요";
        s.setEnglish(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));
        
        //수학점수입력
        message = "새로운 수학점수를 입력해주세요";
        s.setMath(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));
        
        printOne(index);
    }
    //학생정보 삭제를 담당하는 delete()
    public static void delete(int index) {
        String message = "정말로 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner,  message);
        
        if(yesNo.equalsIgnoreCase("Y")) {
            sList.remove(index);
            printAll();
        }else {
            printOne(index);
        }
    }
    
    
    
}
