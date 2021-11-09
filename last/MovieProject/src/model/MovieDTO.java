package model;



public class MovieDTO {

    //영화에는 
    //영화 번호, 영화 제목, 영화 줄거리, 영화 등급(#세관람이상)이 존재합니다.
    
    //필드
    private int id;
    private String title;
    private String storyLine;
    private String rated;
  
   
    //메소드
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
    public String getStoryLine() {
        return storyLine;
    }
    public void setStoryLine(String storyLine) {
        this.storyLine = storyLine;
    }
    public String getRated() {
        return rated;
    }
    public void setRated(String rated) {
        this.rated = rated;
    }

    
    public boolean equals(Object o) {
        if(o instanceof MovieDTO) {
            MovieDTO m = (MovieDTO)o;
            return id == m.id;
        }
        return false;
    }
    public MovieDTO() {
        
    }
    public MovieDTO(MovieDTO m) {
        id = m.id;
        title = new String(m.title);
        storyLine = new String(m.storyLine);
        rated = m.rated;
    }
}
