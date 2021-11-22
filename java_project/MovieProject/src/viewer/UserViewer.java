package viewer;

import java.util.Scanner;

import cnotroller.UserController;
import model.UserDTO;
import utilM.ScannerUtil;


public class UserViewer {
        private UserController userController;
        private Scanner scanner;
        private UserDTO logIn;
        private MovieViewer movieViewer;
        private TheaterViewer theaterViewer;
        
        public UserViewer() {
            userController = new UserController();
            scanner = new Scanner(System.in);
            logIn = null;
            movieViewer = new MovieViewer();
            movieViewer.setUserViewer(this);
            movieViewer.setScanner(scanner);
            theaterViewer = new TheaterViewer();
           theaterViewer.setScanner(scanner);
                       
        }
        
        //첫메인UI
        public void homeMenu() {
            System.out.println("J CINEMA에 오신 것을 환영합니다.");
            String message = new String("1. 로그인 2. 회원가입 3. 프로그램 종료");
            while(true) {
                int userChoice = ScannerUtil.nextInt(scanner, message,1,3);
                if(userChoice == 1) {
                    //등급선택메소드
                    selectGrade();
                }else if(userChoice == 2){
                    //회원가입메소드
                    register();
                }else if(userChoice == 3) {
                    //프로그램종료
                    System.out.println("J CINEMA를 사용해주셔서 감사합니다.");
                    scanner.close();
                    break;
                }
                
            }
        }
        //등급선택메소드UI slectGrade()
        private void selectGrade() {
            System.out.println("로그인할 등급을 선택하세요.");
            String message = new String("1. 일반회원 2. 평론가 3. 관리자");
            int userChoice = ScannerUtil.nextInt(scanner, message,1,3);
            logIn(userChoice);
            if(logIn != null) {
               movieViewer.setLogIn(logIn);
               menu();
            }
        }
        
        //로그인메소드UI logIn(int grade)등급받아서
        public void logIn(int grade) {
               
            String message;
            
            message = new String("아이디를 입력해주세요.");
            String username = ScannerUtil.nextLine(scanner, message);
            
            message = new String("비밀번호를 입력해주세요.");
            String password = ScannerUtil.nextLine(scanner, message);
            
            
            while (userController.auth(username, password, grade) == null) {
                System.out.println("아이디 혹은 비밀번호가 잘못되었습니다.");
                message = new String("아이디를 입력하시거나 뒤로가시려면 X를 입력해주세요");
                username = ScannerUtil.nextLine(scanner, message);
                if(username.equalsIgnoreCase("X")) {
                    break;
                }
                message = new String("비밀번호를 입력해주세요.");
                password = ScannerUtil.nextLine(scanner, message);
            }
            
            logIn = userController.auth(username, password, grade);
        }
        
        private void register() {
            String message;

            message = new String("사용하실 아이디를 입력해주세요.");
            String username = ScannerUtil.nextLine(scanner, message);
            while (userController.validateUsername(username)) {
                System.out.println("해당 아이디는 사용하실 수 없습니다.");
                message = new String("사용하실 아이디를 입력하시거나 뒤로 가실려면 X를 입력해주세요.");
                username = ScannerUtil.nextLine(scanner, message);
                if (username.equalsIgnoreCase("X")) {
                    break;
                }
            }

            if (!username.equalsIgnoreCase("X")) {
                message = new String("사용하실 비밀번호를 입력해주세요.");
                String password = ScannerUtil.nextLine(scanner, message);

                message = new String("사용하실 닉네임을 입력해주세요.");
                String nickname = ScannerUtil.nextLine(scanner, message);
               
                int grade = 1;
                
                UserDTO u = new UserDTO();

                u.setUsername(username);
                u.setPassword(password);
                u.setNickname(nickname);
                u.setGrade(grade);
                
                userController.insert(u);

            }
        }
        
        //회원별보기메뉴
        private void menu() {
            System.out.println("실행할 메뉴를 선택하세요.");
            String message = new String("1. 영화목록보기 2. 영화평점보기 3. 극장목록보기 4.뒤로가기");
            
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 4);
            
            while(true) {
                if (userChoice == 1) {
                    //영화목록보기메소드
                    movieViewer.printMovieList1();
                }else if(userChoice == 2) {
                    //영화평점보기메소드
                    movieViewer.printMovieList2();
                    //printRateOne(movieId);
                }else if(userChoice == 3) {
                    //극장목록보기메소드
                    theaterViewer.printTheaterList();
                }else if(userChoice == 4) {
                    System.out.println("뒤로 돌아갑니다.");
                    break;
                }
            }
        }
        public void printNickName(int id) {
            System.out.print(userController.selectOne(id).getNickname());
        }
}
