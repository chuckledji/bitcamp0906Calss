package controller;

import java.util.ArrayList;

import model.UserDTO;

public class UserController {
    private ArrayList<UserDTO>list;
    private int nextId;
    
    private final int RANK_ADMIN = 1;
    private final int RANK_CRITIC = 2;
    private final int RANK_GENERAL = 3;
    
    //생성자
    public UserController(){
        list = new ArrayList<>();
        nextId = 1;
        
        //test
        UserDTO u1 = new UserDTO();
        u1.setUsername("a1");
        u1.setId(nextId++); //인서트객체를 통해서 넣었으면 setId는 뺴야하는데 add메소드로직접넣었으니 안뺴도 된다
        u1.setNickname("관리자");
        u1.setPassword("1");
        u1.setRank(RANK_ADMIN);
        list.add(u1);
        
        u1 = new UserDTO();
        u1.setUsername("c1");
        u1.setId(nextId++);
        u1.setNickname("평론가");
        u1.setPassword("1");
        u1.setRank(RANK_CRITIC);
        list.add(u1);
        
        u1 = new UserDTO();
        u1.setUsername("g1");
        u1.setId(nextId++);
        u1.setNickname("일반회원1");
        u1.setPassword("1");
        u1.setRank(RANK_GENERAL);
        list.add(u1);
        
    }
    
    //입력메소드
    public void insert(UserDTO u) {
        u.setId(nextId++);
        u.setRank(RANK_GENERAL);
        //회원가입은 무조건 일반회원가입이므로 랭크를 일반회원랭크로저장
        
        list.add(u);
    }
    
    //회원은 목록전체를 만들어서 전달할 일이 없다
    public UserDTO selectOne(int id) {
        for(UserDTO u : list) {
            if(u.getId() == id) {
                return new UserDTO(u);
            }
        }return null;
    }
    
    //사용자로부터 입력받은 username이 중복이거나 'X'와 일치하면 true.
    //그 외는 false가 리턴되는 메소드
    public boolean validate(String username) {
        if(username.equalsIgnoreCase("X")) {
            return true;
        }
        for(UserDTO u : list) {
            if(u.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        
        return false;
    }
    
    //사용자로부터 입력받은 username과 password가 일치하는 회원을 리턴하는 메소드
    public UserDTO auth(String username, String password) {
        for(UserDTO u :list) {
            if(u.getUsername().equalsIgnoreCase(username)&&
                    u.getPassword().equalsIgnoreCase(password)) {
                return new UserDTO(u);
            }
        }
        return null;
    }
    
    //회원정보수정메소드
    public void update(UserDTO u) {
        int index = list.indexOf(u);
        list.set(index, u);
    }
    
    //회원정보삭제 메소드
    public void delete(int id) {
        UserDTO u = new UserDTO();
        u.setId(id);
        list.remove(u);
    }
    
}
