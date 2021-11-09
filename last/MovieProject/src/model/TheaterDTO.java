package model;

public class TheaterDTO {
    //극장 번호, 극장 이름, 극장 위치, 극장 전화번호가 존재합니다.
    private int id;
    private String name;
    private String location;
    private int num;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    
    public boolean equals (Object o) {
        if(o instanceof TheaterDTO) {
            TheaterDTO t = (TheaterDTO)o;
            if(id == t.id) {
                return true;
            }
        }return false;
    }
   
    public TheaterDTO() {
        
    }
    public TheaterDTO(TheaterDTO t) {
        id = t.id;
        name = new String(t.name);
        location = new String(t.location);
        num = t.num;
    }
    
}
