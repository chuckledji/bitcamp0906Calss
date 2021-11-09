package HW;

import java.util.ArrayList;

import java.util.Scanner;
import classEx.Board;
import util.ScannerUtil;

public class HW2MemoBoard {

    //상수
    
    //변수
    static Scanner scanner = new Scanner(System.in);
    static Board [] arr = new Board[0];
    static int nextNum = 1;
    static ArrayList<classEx.Board>bList = new ArrayList<>();
    
    
    //메인메소드
    public static void main(String[] args) {
        System.out.println("글 작성 게시판");
        //메뉴 보여주는 메소드 실행showMenu();
        showMenu();
        
    }
    //메뉴를 보여주는 showMenu()메소드
   public static void showMenu() {
       while(true) {
           String message = "1.글 작성 / 2.글 보기 / 3.프로그램 종료";
           int userChoice = ScannerUtil.nextInt(scanner, message);
           
           if (userChoice == 1) {
               //글작성 메소드 호출
               insert();
               
           }else if(userChoice == 2) {
               //글보기 메소드 호출
               printAll();
               
           }else if(userChoice == 3) {
               System.out.println("프로그램을 종료합니다.");
               scanner.close();
               break;
           }
       }
   }
    //글작성 매소드 insert()
   public static void insert() {
       if(bList.size() < bList.size()+1) {
           //입력받을 정보를 임시저장할 Board 변수
           Board b = new Board();
          
           //입력시 출력할 메세지를 담은 String변수
           String message;
           
           //번호
           b.num = nextNum++;
           
           //작성자
           message = "작성자의 이름을 입력해주세요";
           b.name = ScannerUtil.nextLine(scanner, message);
           
           //제목
           message = "글의 제목을 입력해주세요";
           b.title = ScannerUtil.nextLine(scanner, message);                  
          
           //내용
           message = "글의 내용을 작성해주세요";
           b.content = ScannerUtil.nextLine(scanner, message);
           
           //배열에 b추가한다
           bList.add(b);
       }
   }
    
   //글출력하는 printAll()메소드
   public static void printAll() {
       if(bList.isEmpty()) {
           System.out.println("아직 작성한 글이 없습니다.");
       }else {
           for(int i = 0; i < bList.size(); i++) {
               System.out.printf("%d번 글. 작성자: %s\n", i+1, bList.get(i).name);
               
           }
           String message = "보기할 글의 번호나 뒤로 가시려면 0을 입력해주세요";
           int userChoice = ScannerUtil.nextInt(scanner, message, 0, bList.size()) - 1;
       
           if(userChoice != -1) {
               //뒤로가기0을 누르지 않았다면 글 개별보기를 실행한다
               printOne(userChoice);
           }
       }
   }
   
   //글 개별보기 printOne()메소드
   public static void printOne(int index) {
       
       classEx.Board b = bList.get(index);
       
       b.printContent();
       
       String message = "1.글 수정 / 2.글 삭제 / 3. 뒤로가기";
       int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
       if(userChoice == 1) {
           //글수정 메소드를 호출한다
           update(index);
           
       }else if(userChoice == 2) {
           //글삭제 메소드를 호출한다
           delete(index);
           
       }else if(userChoice == 3) {
           printAll();
       }
       
   }
    //글수정 update()메소드
   public static void update(int index) {
       Board b = bList.get(index);
       
       String message;
       
     //제목
       message = "글의 새로운 제목을 입력해주세요";
       b.title = ScannerUtil.nextLine(scanner, message);                  
      
       //내용
       message = "글의 새로운 내용을 작성해주세요";
       b.content = ScannerUtil.nextLine(scanner, message);
       
       //수정한 내용을 출력한다
       printOne(index);
       
   }
    //글삭제 delete()메소드
   public static void delete(int index) {
       String message = "정말로 삭제하시겠습니까? Y/N";
       String yesNo = ScannerUtil.nextLine(scanner, message);
       
       if(yesNo.equalsIgnoreCase("Y")) {
           bList.remove(index);
           printAll();
           
       }else {
           printOne(index);
       }
   }
    
}
