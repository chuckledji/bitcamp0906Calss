package model;

import java.util.Calendar;

public class BoardDTO {
    // 필드
    private int id;
    private String title;
    private String writer;
    private String content;
    private Calendar writtenDate;
    private Calendar updatedDate;

    // 메소드
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
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

    public boolean equals(Object o) {
        if (o instanceof BoardDTO) {
            BoardDTO b = (BoardDTO) o;
            if (id == b.id) {
                return true;
            }
        }
        return false;
    }

}
