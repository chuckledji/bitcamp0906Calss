package viewer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import controller.ReplyController;
import model.MemberDTO;
import model.ReplyDTO;
import util.ScannerUtil;


public class ReplyViewer {
    private ReplyController replyController;
    private Scanner scanner;
    private final String DATE_TIME_FORMAT = new String("yy/M/d H:m:s");
    private MemberViewer memberViewer;
    private MemberDTO logIn;
   //private BoardViewer boardViewer;
   //public void setBoardViewer(BoardViewer boardViewer) {
   //this.boardViewer = boardViewer;
   //}
    
    public void setScanner(Scanner scanner) {
    this.scanner = scanner;
   }
    public void setLogIn(MemberDTO logIn) {
        this.logIn = logIn;
    }
    public ReplyViewer() {//생성자만들어준다
        replyController = new ReplyController();
    }
    public void setMemberViewer(MemberViewer memberViewer) {
     this.memberViewer = memberViewer;
    }
    
    public int printAll(int boardId) { //여기서 주의할 것은 글의 댓글을 출력하는 것이니 파라미터에 boardId필요
       //리스트를받아온다
       ArrayList<ReplyDTO>list = replyController.selectByBoardId(boardId);
      
     //비어있지않은경우
       if(!list.isEmpty()) {
          SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT);
           
           for(ReplyDTO r : list) { // 지금 리플라이디티오에는 회원번호만 있다.
              System.out.printf("%s by", r.getContent());
              memberViewer.printNickName(r.getWriterId());
              System.out.println("at" + sdf.format(r.getWrittenDate().getTime()));
          }
       }
       
       //댓글보기나 뒤로가기를 해야하는데
       //뒤로가기는 보드뷰어에서 해야하고 거기에 알려줘야하니까 리턴타입은 인트(위에)이다
       String message = new String("1.댓글등록 2.뒤로가기");
       int userChoice = ScannerUtil.nextInt(scanner, message);
       
       if (userChoice == 1) {
           //새 댓글 작성 메소드 실행
           writeReply(boardId);
       }       
       return userChoice;
   }
    
    //새댓글작성메소드
    private void writeReply(int boardId) {
        ReplyDTO r = new ReplyDTO();
        
        r.setBoardId(boardId);
        //작성자회원번호랑 내용을 저장해주면된다
        //작성자 번호는 로그인한사람기준으로 한다
        
        String message = new String("댓글의 내용을 입력해주세요");
        r.setContent(ScannerUtil.nextLine(scanner, message));
        
        r.setWriterId(logIn.getId());
        
        replyController.insert(r);
    }
    public void deleteByWriterId(int writerId) {
        replyController.deleteByWriterId(writerId);
    }
}
