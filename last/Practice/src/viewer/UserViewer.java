package viewer;

import java.util.Scanner;

import controller.UserController;
import model.UserDTO;
import utilP.ScannerUtil;

public class UserViewer {
    private UserController userController;
    private Scanner scanner;
    private UserDTO logIn; //로그인한 정보를 계속 가지고있을 객체
    //밑 네개는 주입해줘야함
    private MovieViewer movieViewer;
    private TheaterViewer theaterViewer;
    private ShowViewer showViewer;
    private RatingViewer ratingViewer;
    
    private final int RANK_ADMIN = 1;
    private final int RANK_CRITIC = 2;
    //private final int RANK_GENERAL = 3;이건 왜 안만들지?
    
    //필드를 초기화할 생성자
    public UserViewer() {
        userController = new UserController();
        scanner = new Scanner(System.in);
    }
    
    //의존성 주입을 위한 셋터
    public void setMovieViewer( MovieViewer movieViewer) {
        this.movieViewer = movieViewer;
        this.movieViewer.setScanner(scanner);//여러개의스캐너객체를 만들필요가없다?12-36분 듣기
    }
    public void setShowViewer( ShowViewer showViewer) {
        this.showViewer = showViewer;
    }
    public void setTheaterViewer( TheaterViewer theaterViewer) {
        this.theaterViewer = theaterViewer;
    }
    public void setRatingViewer( RatingViewer ratingViewer) {
        this.ratingViewer = ratingViewer;
        this.ratingViewer.setScanner(scanner);//4:00
    }
    
    
    //인덱스화면
    public void showIndex() {
        String message = new String ("1회원가입 2로그인 3종료");
        while(true) {
            int userChoice = ScannerUtil.nextInt(scanner, message,1,3);
            if(userChoice ==1) {
                //회원가입메소드
                register();
            }else if(userChoice == 2) {
                //로그인메소드
                logIn();
                
                //로그인에 저장된 값이 null인지 아닌지
                if(logIn != null) {
                    movieViewer.setLogIn(logIn);//무비뷰어에서 로그인세터만들어준 다음 로그인세터를 불러와준다.
                    ratingViewer.setLogIn(logIn);
                    //로그인한경우가 관리자일경우, 그 외일 경우
                    if(logIn.getRank() == RANK_ADMIN){
                        //관리자메뉴실행
                        showAdminMenu();
                    }else {
                    //비관리자메뉴실행
                        showNonAdminMenu();
                   }
               }
            }else if(userChoice ==3) {
                System.out.println("시스템종료");
                scanner.close();
                break;
            }
        }
    }
    
    //회원가입메소드
    private void register() {
        String message;
        
        message = new String("사용하실 아이디를 입력해주세요");
        String username = ScannerUtil.nextLine(scanner, message);
                
        while(userController.validate(username)) {
            System.out.println("해당 아이디는 사용하실 수 없습니다");
            message = new String("사용하실 아이디를 입력하시거나 뒤로 가시려면 X를 눌러주세요");
            username = ScannerUtil.nextLine(scanner, message);
            if(username.equalsIgnoreCase("X")) {
                break; //아이디못쓴다고?가입안할래 해서 누른 엑스
            }
        }
        if(!username.equalsIgnoreCase("X")) {
            //x와 일치하지 않는경우
            message = new String("사용하실비밀번호를 입력해주세요");
            String password = ScannerUtil.nextLine(scanner, message);
            
            message = new String("사용하실닉네임을 입력해주세요");
            String nickname = ScannerUtil.nextLine(scanner, message);
            
            UserDTO u = new UserDTO();
            u.setUsername(username);
            u.setPassword(password);
            u.setNickname(nickname);
            
            userController.insert(u); //인서트가 어차피 여기서만 쓰이는거였나?
        }
    }
    
    //로그인메소드
    private void logIn() {
        String message;
        
        message = new String("아이디를 입력해주세요");
        String username = ScannerUtil.nextLine(scanner, message);
        
        message = new String("비밀번호를 입력해주세요");
        String password = ScannerUtil.nextLine(scanner, message);
        
        UserDTO u = userController.auth(username,  password);
        
        while(u == null) {//일치하는 회원정보가 없을떄
            System.out.println("로그인정보를 다시 확인해주세요");
            message = new String("아이디를 입력하시거나 뒤로가시려면 X를 눌러주세요");
            username = ScannerUtil.nextLine(scanner, message);
            
            //로그인안할래 x라고 입력했을경우
            if(username.equalsIgnoreCase("X")) {
                break;//이게 실행이 되면 다음 코드는 실행이 안된다
            }
            
            message = new String("비밀번호를 입력해주세요");
            password = ScannerUtil.nextLine(scanner, message);
            u = userController.auth(username, password); //다시 체크한다
        }
        //while문이 끝났을때
        logIn = u; //u가 가지고 있을 값으로 초기화를 해준다.
        
    }
    
    //관리자메뉴
    public void showAdminMenu() {
        String message = new String("1.영화관리 2. 극장관리 3. 상영정보관리 4. 로그아웃");
        while(true) {
            int userChoice = ScannerUtil.nextInt(scanner, message,1,4);
            
            if(userChoice == 1) {
                //MovieViewer의 showAdminMenu()실행
                movieViewer.showAdminMenu();
                
            }else if(userChoice == 2) {
              //TheaterViewer의 showAdminMenu()실행
                theaterViewer.showAdminMenu();
                
            }else if(userChoice == 3) {
              //ShowViewer의 showAdminMenu()실행
                showViewer.showAdminMenu();
                
            }else {
                System.out.println("로그아웃하셨습니다");
                logIn = null;
                break;
            }
        }
        
    }
    
    //비관리자메뉴
    public void showNonAdminMenu(){
        String message = new String("1.영화목록보기 2. 극장목록보기 3. 내정보보기 4. 로그아웃");
        while(true) {
            int userChoice = ScannerUtil.nextInt(scanner, message,1,4);
            
            if(userChoice == 1) {
              //MovieViewer의 printList()실행 
                movieViewer.printList();
                
            }else if(userChoice == 2) {
              //TheaterViewer의 printList()실행 
                theaterViewer.printList();
                
            }else if(userChoice == 3) {
              //개별 회원 정보 보기 메소드실행 
               printOne(logIn.getId());
                
            }else if(userChoice == 4) {
              System.out.println("로그아웃하셨습니다");
              logIn = null;
              //break;//11-44//위에서 탈퇴하면 이미 널로 변하니까 여기서 널이 안되니까 그런거야?
            }
            if(logIn == null) {
                break;
            }
        }
    }
    private void printOne(int id) {
        UserDTO u = userController.selectOne(id);
        
        String rank;
        
        if(u.getRank() == RANK_ADMIN) {
            rank = new String("관리자");
            
        }else if(u.getRank() == RANK_CRITIC) {
            rank = new String("평론가");
            
        }else {
            rank = new String("일반회원");
        }
        
        System.out.println("-------------");
        System.out.println(u.getNickname()+"님의정보");
        System.out.println("-------------");
        System.out.println("아이디"+u.getUsername());
        System.out.println("닉네임"+u.getNickname());
        System.out.println("회원등급: ");
        System.out.println("아이디"+u.getUsername());
        System.out.println("-------------");
        
        String messge = new String("1.회원정보수정 2. 회원탈퇴 3. 뒤로가기");
        int userChoice = ScannerUtil.nextInt(scanner, messge,1,3);
        
        if(userChoice ==1) {
            //회원정보 수정 메소드 실행
            update(id);
        }else if(userChoice == 2) {
            //회원정보 탈퇴 메소드 실행
            withdrawl(id);
        }
    }
   
    private void update(int id) {
        UserDTO u = userController.selectOne(id);
        
        String message;
        
        message = new String("새로운 비밀번호를 입력해주세요");
        u.setPassword(ScannerUtil.nextLine(scanner, message));
        
        message = new String("새로운 닉네임을 입력해주세요");
        u.setNickname(ScannerUtil.nextLine(scanner, message));
        
        userController.update(u);
        printOne(id);
    }
    
    private void withdrawl(int id) {
        String message = new String("정말로 탈퇴하시겠습니까? Y/N");
        String yesNo = ScannerUtil.nextLine(scanner, message);
        
        if(yesNo.equalsIgnoreCase("Y")) {
            userController.delete(id);
            logIn = null;
            //RatingViewer의 deleteByWriterId()실행
            ratingViewer.deleteByWriterId(id);
            System.out.println("회원탈퇴가 완료되었습니다");
        }else {
            printOne(id);
        }
        
        
    }
    
    //해당 회원번호를 가진 회원의 닉네임만 출력하는 메소드
    public void printNicnameById(int id) {
        UserDTO u =userController.selectOne(id);
        System.out.print(u.getNickname());
    }
    
    //중간다리역할을 하는 2-55
    //해당회원번호를 가진 회원의 회원 등급을 리턴하는 메소드
    public int selectRankById(int id) {
//        int rank = userController.selectOne(id).getRank();
//        return rank;
        return userController.selectOne(id).getRank();
    }
}
