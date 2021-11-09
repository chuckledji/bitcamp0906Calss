package controller;

import java.util.ArrayList;
import java.util.Calendar;

import model.ReplyDTO;

public class ReplyController {
    private ArrayList<ReplyDTO> list; //컨트롤쉬프트 오(임포트만 전문적으로 해주는) /  컨트롤 스페이스(코드에 대한 자동완성)
    private int nextId;
    
    //생성자만들어서 위의 필드들을 초기화
    public ReplyController() {
        list = new ArrayList<>();
        nextId =1;
    }
    
    //insert(ReplyDTO r) 댓글입력
    public void insert(ReplyDTO r) {
    //작성자번호와 글의번호 글의내용은 입력받아 객체로 들어올 것이니까 나머지만채움 
    r.setId(nextId++);
    r.setWrittenDate(Calendar.getInstance());
    
    list.add(r);
    }
    
    
    //selectAll() ReplyDTO모든 값 선택해서 리턴하는 메소드
    //우리가 어떤글을 들어갔을때 그 글에 댓글이 존재하면 그 댓글을 불러와야함 그래서 셀렉트바이보드
    public ArrayList<ReplyDTO> selectByBoardId(int boardId){
                
        ArrayList<ReplyDTO>temp = new ArrayList<>();
        for(ReplyDTO r : list) {
            if(r.getBoardId() == boardId) { //원본보드아이디와 파라미터로 들어온게시판아이디가일치하면
                ReplyDTO tempR = new ReplyDTO(r);//아이디가 일치한 정보를 tempR에 딥카피하는것임
                temp.add(tempR);
            }
        }
        return temp;
    }
    public void deleteByWriterId(int writerId) {
        for(int i = 0; i <list.size(); i++) {
            if(list.get(i).getWriterId() == writerId) {
                list.remove(i);
                i =-1; //보드컨트롤러에 추가한 메소드와 내용이 같음
            }
        }
    }
}
