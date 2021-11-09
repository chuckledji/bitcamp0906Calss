package viewer;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.ArrayList;

import cnotroller.RatingController;
import model.UserDTO;
import model.RatingDTO;
import utilM.ScannerUtil;


public class RatingViewer {
    private RatingController ratingController;
    private Scanner scanner;
    private final String DATE_TIME_FORMAT = new String("yy/M/d H:m:s");
    private UserViewer userViewer;
    private UserDTO logIn;
    
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
    public void setLogIn(UserDTO logIn) {
        this.logIn = logIn;
    }
    public void setUserViewer(UserViewer userViewer) {
        this.userViewer = userViewer;
    }
    
    //생성자
    public RatingViewer() {
        ratingController = new RatingController();
    }
    
    //전체영화의 평론평균출력
    //영화 리스트 옆에 평점평균이 나온다.
    //평점 평균은 평론가+일반관람객 의 평균이다.
    //printAllRates()
    
    
    
    

    public int printRateOne(int movieId) {
        ArrayList<RatingDTO>list = ratingController.selectByMovie(movieId);
        if(!list.isEmpty()) {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT);
            
            for(RatingDTO r : list) {
                System.out.printf("평점: %d\n닉네임: ", r.getRating());
                    userViewer.printNickName(r.getWriterId());
                    System.out.println("작성시간" + sdf.format(r.getWrittenDate().getTime()));
                    System.out.printf("평론: %s\n", r.getCritics());
            }
        }
        String message = new String("1.평점등록 2.뒤로가기");
        int userChoice = ScannerUtil.nextInt(scanner, message);
        if(userChoice == 1) {
            writeCritics(movieId);
        }
        return userChoice;
    }
      
    //평점입력메소드
    private void writeCritics(int movieId) {
        RatingDTO r = new RatingDTO();
        
        r.setMovieId(movieId);
        String message = new String("평점을 입력해주세요.(10점만점)");
        r.setRating(ScannerUtil.nextInt(scanner, message,0,10));
        //평점이 0에서 10을 벗어난다면 다시입력받아야함
        String message1 = new String("평론 글을 작성해주세요.");
        r.setCritics(ScannerUtil.nextLine(scanner, message1));
        
        r.setWriterId(logIn.getId());
        
        ratingController.insert(r);
    }
    
    public void deleteByWriterId(int writerId) {
        ratingController.deleteByWriterId(writerId);
    }
    
}
