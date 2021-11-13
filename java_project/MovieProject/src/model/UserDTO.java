package model;

public class UserDTO {
    //필드
    private int id;
    private String username;
    private String password;
    private String nickname;
    private int grade;
    
       
    
    //메소드
    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    public boolean equals(Object o) {
        if( o instanceof UserDTO) {
            UserDTO u =(UserDTO)o;
            if(id == u.id) {
                return true;
            }
        }return false;
    }
    
    //빈 생성자
    public UserDTO() {
        
    }
    
   //딥카피용 생성자
    public UserDTO(UserDTO u) {
        id = u.id;
        username = new String(u.username);
        nickname = new String(u.nickname);
        grade = u.grade;
    }
    
   
    
    
    
}
