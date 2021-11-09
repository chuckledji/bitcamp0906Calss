package model;

import java.util.Calendar;

public class RatingDTO {
    // 평점 번호(등록된평점의 내부id값), 작성 회원 번호, 영화 번호, 평점, 평론(평론가만가능)이 존재합니다.
    private int id;
    private int writerId;
    private int movieId;
    private int rating;
    private String critics;
    private int grade;
    private Calendar writtenDate;
    
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

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getCritics() {
        return critics;
    }

    public void setCritics(String critics) {
        this.critics = critics;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Calendar getWrittenDate() {
        return writtenDate;
    }

    public void setWrittenDate(Calendar writtenDate) {
        this.writtenDate = writtenDate;
    }
    
    public boolean equals(Object o) {
        if( o instanceof RatingDTO) {
            RatingDTO r = (RatingDTO)o;
            if(id == r.id) {
                return true;
            }
        }return false;
    }
    
    public RatingDTO() {
        
    }
    public RatingDTO(RatingDTO r) {
        id = r.id;
        writerId = r.writerId;
        movieId = r.movieId;
        rating = r.rating;
        critics = new String(r.critics);
        grade = r.grade;
    }
    
    
}
