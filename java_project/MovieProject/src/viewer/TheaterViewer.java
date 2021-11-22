package viewer;

import java.util.Scanner;

import cnotroller.TheaterController;
import model.TheaterDTO;
import model.UserDTO;
import utilM.ScannerUtil;

public class TheaterViewer {
    private TheaterController theaterController;
    private UserDTO logIn;
    private Scanner scanner;
    private MovieViewer movieViewer;
    
    public TheaterViewer() {
        theaterController = new TheaterController();
    }
    
    public void setLogIn(UserDTO logIn) {
        this.logIn = logIn;
    }
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
    public void setMovieViewer(MovieViewer movieViewer) {
        this.movieViewer = movieViewer;
    }
    
    //극장 목록을 출력한다
    public void printTheaterList() {
        for(TheaterDTO t : list) {
            System.out.printf("%d. %s\n", t.getId(), t.getName());
           }
        
        String message = new String("상세보기할 극장의 번호를 입력하거나 뒤로 가실려면 0을 입력해주세요.");
        int userChoice = ScannerUtil.nextInt(scanner, message);

        while (userChoice != 0 && theaterController.selectOne(userChoice) == null) {
            System.out.println("해당 극장 번호는 존재하지 않습니다.");
            userChoice = ScannerUtil.nextInt(scanner, message);
        }

        if (userChoice != 0) {
            printOne(userChoice);
        }
    }
    
    private void printOne(int id) {
        TheaterDTO t = theaterController.selectOne(id);
        
        System.out.println(t.getName());
        System.out.println("------------------------------");
        System.out.println("위치: " + t.getLocation());
        System.out.println("전화번호: " + t.getNum());
        System.out.println("------------------------------");
        
        //로그인상태가 관리자일시 영화수정삭제가 가능하게 화면이 나온다.
        if(logIn.getGrade() == 3) {
            String message = new String("1. 수정 2. 삭제 3. 뒤로가기");
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
            if(userChoice == 1) {
                update(id);
            }else if(userChoice == 2) {
                delete(id);
            }else if(userChoice == 3) {
                printTheaterList();
            }
        }
        
        String message = new String(t.getName()+"점에서 상영하는 영화목록을 보고싶으시면 y, 뒤로 가고 싶으시면 n을 눌러주세요");
        String yesNo = ScannerUtil.nextLine(scanner, message);
        
        if(yesNo.equalsIgnoreCase("Y")) {
            movieViewer.printMovieList1();
        }else {
            printTheaterList();
        }
    }
    
    //update(int id)
    private void update(int id) {
        TheaterDTO t =theaterController.selectOne(id);
        String message;
        
        message = new String("새로운 극장이름을 입력해주세요.");
        t.setName(ScannerUtil.nextLine(scanner, message));
        
        message = new String("새로운 극장위치를 입력해주세요.");
        t.setLocation(ScannerUtil.nextLine(scanner, message));
        
        message = new String("새로운 전화번호를 입력해주세요.");
        t.setNum(ScannerUtil.nextInt(scanner, message));
        
        theaterController.update(t);
        
        printOne(id);
    }
    
    //delete(int id)
    private void delete(int id) {
        String message = new String("해당 극장을 삭제하시겠습니까? Y/N");
        String yesNo = ScannerUtil.nextLine(scanner, message);
        
        if(yesNo.equalsIgnoreCase("Y")) {
            theaterController.delete(id);
            printTheaterList();
        }else {
            printOne(id);
        }
    }
    
    
}
