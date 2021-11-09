package model;

import java.util.Calendar;

public class BoardDTO {
    private int id;
    private int writerId;
    private String title;
    private String content;
    private Calendar writtenDate;
    private Calendar updatedDate;
    
    
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
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
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
    public Calendar getUpdatedDate() {
        return updatedDate;
    }
    public void setUpdatedDate(Calendar updatedDate) {
        this.updatedDate = updatedDate;
    }
    
    @Override
    public boolean equals(Object o) {
        if(o instanceof BoardDTO) {
            BoardDTO b = (BoardDTO)o;
            return id == b.id;
        }
        return false;
    }
    
    public BoardDTO() {
        //그냥 생성자호출을 위해 필요하다 // int는 0으로 String은 null로
    }
    public BoardDTO(BoardDTO b) {
        //파라미터에 값이 있는거는 딥카피를 할때 사용을 해야 하므로 필요하다
        id = b.id;
        writerId = b.writerId;
        title = new String(b.title);
        content = new String(b.content);
        writtenDate = Calendar.getInstance();
        writtenDate.setTime(b.writtenDate.getTime());
        updatedDate = Calendar.getInstance();
        updatedDate.setTime(b.updatedDate.getTime());
    }
    
}
