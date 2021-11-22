package cnotroller;

import java.util.ArrayList;

import model.UserDTO;

public class UserController {
    private ArrayList<UserDTO> list;
    private int nextId;
    
    public UserController() {
        list = new ArrayList<>();
        nextId =1;
        
        //평론가회원정보생성
        for(int i = 1; i <= 5; i++) {
            UserDTO c = new UserDTO();
            
            c.setUsername("c" + i);
            c.setPassword("c" + i);
            c.setNickname("평론가"+i);
            c.setGrade(2);
            
            insert(c);
        }
        
        //관리자회원정보생성
        for(int i = 1; i <= 3; i++) {
            UserDTO m = new UserDTO();
            
            m.setUsername("m" + i);
            m.setPassword("m"+ i);
            m.setNickname("관리자"+i);
            m.setGrade(3);
            
            insert(m);
        }
        
    }
 
    
    //리스트에추가하는메소드insert()
    public void insert(UserDTO u) {
        u.setId(nextId);
        list.add(u);
    }
    
    //하나의 유저정보를 리턴하는 selectOne(int id)
    public UserDTO selectOne(int id) {
        for(UserDTO u : list) {
            if(u.getId() == id) {
                return new UserDTO(u);
            }
        }return null;
    }
    
    //정보 수정을 리스트에 반영하는 update(UserDTO u)
    public void update(UserDTO u) {
        int index = list.indexOf(u);
        list.set(index,  u);
    }
    
    //정보삭제를 실행하는 delete(int id)
    public void delete(int id) {
        UserDTO u = new UserDTO();
        u.setId(id);
        
        list.remove(u);
    }
    //회원아이디가 중복되는지 확인할 수 있는 validateUsername(String username)
    public boolean validateUsername(String username) {
        if(username.equalsIgnoreCase("X")) {
            return true;
        }
        for(UserDTO u : list) {
            if(u.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }return false;
    }
    //회원정보와 등급이 일치하는지 확인이 필요한 auth
    public UserDTO auth(String username, String password, int grade) {
        for(UserDTO u : list) {
            if(u.getUsername().equalsIgnoreCase(username) && u.getPassword().equalsIgnoreCase(password) && u.getGrade() == grade) {
                return new UserDTO(u);
            }
        }return null;
    }
    
}
