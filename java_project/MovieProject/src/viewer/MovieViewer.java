package viewer;


import java.util.Scanner;

import cnotroller.MovieController;
import model.MovieDTO;
import model.UserDTO;
import utilM.ScannerUtil;

public class MovieViewer {
    private MovieController movieController;
    private Scanner scanner;
    
    private UserDTO logIn;
    private UserViewer userViewer;
    private RatingViewer ratingViewer;
    
    //의존성주입
    public void setLogIn(UserDTO logIn) {
        this.logIn = logIn;
        ratingViewer.setLogIn(logIn);
    }
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
        ratingViewer.setUserViewer(userViewer);
    }
    public void setUserViewer(UserViewer userViewer) {
        this.userViewer = userViewer;
        ratingViewer.setUserViewer(userViewer);
    }
    
    
    
    //생성자
    public MovieViewer () {
        movieController = new MovieController();
        
    }
    

    //printMovoielist
    public void printMovieList1() {
       
        for(MovieDTO m : movieController.selectAll()) {
           System.out.printf("%d. %s\n", m.getId(), m.getTitle());
       }
       String message = new String("상세보기할 영화번호를 입력하시거나 뒤로 가시려면 0을 입력하세요.");
       
       int userChoice = ScannerUtil.nextInt(scanner, message);
       while(userChoice != 0 && movieController.selectOne(userChoice) == null) {
           System.out.println("해당 번호의 영화는 존재하지 않습니다.");
           userChoice = ScannerUtil.nextInt(scanner, message);
       }
       if(userChoice != 0) {
           printOne(userChoice);
       }
    }
    
    public void printMovieList2() {
        
        for(MovieDTO m : movieController.selectAll()) {
           System.out.printf("%d. %s\n", m.getId(), m.getTitle());
       }
        String message = new String("상세보기할 영화번호를 입력하시거나 뒤로 가시려면 0을 입력하세요.");
        
        int userChoice = ScannerUtil.nextInt(scanner, message);
        while(userChoice != 0 && movieController.selectOne(userChoice) == null) {
            System.out.println("해당 번호의 영화는 존재하지 않습니다.");
            userChoice = ScannerUtil.nextInt(scanner, message);
        }
        if(userChoice != 0) {
            ratingViewer.printRateOne(userChoice);
        }
        
    }
    
    //printOne(int id)
    private void printOne(int id) {
        MovieDTO m = movieController.selectOne(id);
        System.out.println("------------------------------");
        System.out.println(m.getTitle());
        System.out.println("------------------------------");
        System.out.println("등급: " + m.getRated());
        System.out.println("줄거리: " + m.getStoryLine());
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
                printMovieList1();
            }
        }
    }
    
    //update(int id)
    private void update(int id) {
        MovieDTO m =movieController.selectOne(id);
        String message;
        
        message = new String("새로운 영화제목을 입력해주세요.");
        m.setTitle(ScannerUtil.nextLine(scanner, message));
        
        message = new String("새로운 영화등급을 입력해주세요.");
        m.setRated(ScannerUtil.nextLine(scanner, message));
        
        message = new String("새로운 줄거리를 입력해주세요.");
        m.setStoryLine(ScannerUtil.nextLine(scanner, message));
        
        movieController.update(m);
        
        printOne(id);
    }
    
    //delete(int id)
    private void delete(int id) {
        String message = new String("해당 영화를 삭제하시겠습니까? Y/N");
        String yesNo = ScannerUtil.nextLine(scanner, message);
        
        if(yesNo.equalsIgnoreCase("Y")) {
            movieController.delete(id);
            printMovieList1();
        }else {
            printOne(id);
        }
    }
    
    
    
}
