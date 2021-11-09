package model;

import java.util.Calendar;

public class ReplyDTO { //댓글달기 수정,삭제는없음, 자기글에는 댓글 쓸 수 없습니다.
    private int id;
    private int writerId;
    private int boardId;
    private String content;
    private Calendar writtenDate;
    
    //메소드
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getWriterId() {
        return writerId;
    }
    public void setWriterId(int writerId) {
        this.writerId = writerId;
    }
    public int getBoardId() {
        return boardId;
    }
    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Calendar getWrittenDate() {
        return writtenDate;
    }
    public void setWrittenDate(Calendar writtenDate) {
        this.writtenDate = writtenDate;
    }
    
    public ReplyDTO() {
        //그냥 생성자호출을 위해 필요하다 // int는 0으로 String은 null로 // 일반생성자
    }
    public ReplyDTO(ReplyDTO r) {
        //파라미터에 값이 있는거는 딥카피를 할때 사용을 해야 하므로 필요하다 //딥카피해줄겸
        id = r.id;
        writerId = r.writerId;
        content = new String(r.content);
        writtenDate = Calendar.getInstance();
        writtenDate.setTime(r.writtenDate.getTime());       
    }
    public boolean equals(Object o) {
        if( o instanceof ReplyDTO) {
            ReplyDTO r = (ReplyDTO)o;
            return id == r.id;
        }
        return false;
        
    }
    
}
