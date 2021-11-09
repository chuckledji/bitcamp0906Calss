package day0923;

import java.util.ArrayList;
import java.util.Scanner;
import classEx.BoardTver;
import util.ScannerUtil;

public class BoardEx01 {
    static ArrayList <BoardTver> list = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static int nextId = 1;
    
    //메인메소드
    public static void main(String[] args) {
        showMenu();
    }
    //메뉴 출력메소드
    public static void showMenu() {
        while (true) {
            System.out.println("게시판관리프로그램");
            String message = new String("1.입력2.출력3.종료");
            int userChoice = ScannerUtil.nextInt(scanner, message);
            
            if (userChoice == 1) {
                //글작성 메소드 호출
                write();
                
            }else if(userChoice == 2) {
                //글보기 메소드 호출
                printList();
                
            }else if(userChoice == 3) {
                System.out.println("프로그램을 종료합니다.");
                scanner.close();
                break;
            }
        }
    }
    //글작성세모드
    public static void write() {
        //입력할 글의 내용을 담을 Board객체 선언 및 초기화
        BoardTver b = new BoardTver();
        
        //입력시 출력할 메세지를 담을 string 객체
        String message;
        
        //글 번호입력 후 //다음글번호 1 증가(원래 마지막아래에 있던 거)
        b.id = nextId++;
        
        //글 제목입력
        message = new String("제목을 입력해주세여");
        b.title = ScannerUtil.nextLine(scanner, message);
        //글 작성자입력
        message = new String("작성자를 입력해주세여");
        b.writer = ScannerUtil.nextLine(scanner, message);
        //글 내용입력
        message = new String("내용을 입력해주세여");
        b.content = new String(ScannerUtil.nextLine(scanner, message));
        //이위에 뉴스트링안써도무상관
        //리스트에 추가
        list.add(b);
        
    }
    //글목록출력메소드
    public static void printList() {
     if(list.isEmpty())    {
         System.out.println("----------------------------\n");
         System.out.println("아직 작성한 글이 없습니다.");
         System.out.println("----------------------------\n");
     }else {
         for(int i = 0; i < list.size(); i++) {
             System.out.printf("%d. %s\n", i+1, list.get(i).title); 
         }
         System.out.println("----------------------------\n");
         String message = "보기할 글의 번호나 뒤로 가시려면 0을 입력해주세요";
         int userChoice = ScannerUtil.nextInt(scanner, message, 0, list.size()) - 1;
        
             // 사용자가 0을 입력하지 않았을경우
             // 올바른 번호를 입력했는지 체크
             // 그런 후에 올바른번호이면 printOne
             // 올바르지 않을 경우 다시 입력
             
             while(!validateId(userChoice)) {
                 System.out.println("해당글본호는 존재하지않는다");
                 userChoice = ScannerUtil.nextInt(scanner, message);
             }
             if (userChoice != 0) {
                 printOne(userChoice);  
             }
             
         
     }
    }
    //글개별메소드
    public static void printOne(int index) {
       
      list.get(index).printOne(); //이부분이 나랑다르네 비교해보자
      String message = new String("1.수정2.삭제3.뒤로가기");
      int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
      if(userChoice == 1) {
          //글수정 메소드를 호출한다
          update(index);
          
      }else if(userChoice == 2) {
          //글삭제 메소드를 호출한다
          delete(index);
          
      }else if(userChoice == 3) {
          printList();
      }
      
    }
    //글수정
    public static void update(int index) {
        String message;
        message = new String("새로운제목을 입력해주세요");
        list.get(index).title = ScannerUtil.nextLine(scanner, message);
        message = new String("새로운내용을 입력해주세요");
        list.get(index).content = ScannerUtil.nextLine(scanner, message);
        
        printOne(index);
    }
    //글삭제
    public static void delete(int index) {
        String message = new String("글을 정말로 삭제하시겠습니까? y/n");
        String yesNo = ScannerUtil.nextLine(scanner, message);
        
        if(yesNo.equalsIgnoreCase("Y")) {
            list.remove(index);
            printList();
            
        }else {
            printOne(index);
        }  
    }
    
}
