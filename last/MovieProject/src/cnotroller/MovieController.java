package cnotroller;

import java.util.ArrayList;


import model.MovieDTO;

public class MovieController {
    private ArrayList<MovieDTO>list;
    private int nextId;

    //생성자
    public MovieController() {
        list = new ArrayList<>();
        nextId=1;

        //임의 영화목록 생성
        for(int i = 1; i <= 10; i++) {
            MovieDTO m = new MovieDTO();
            
            m.setTitle("영화제목"+i);
            m.setStoryLine("영화줄거리"+i);
            int g = ((i % 3)+1);
            if(g == 1) {
                m.setRated("전체관람가");   
            }else if(g == 2) {
                m.setRated("15세 이상관람가");
            }else if(g == 3) {
                m.setRated("청소년 관람불가");
            }
            insert(m);
        }
    }
        
   //목록 전부를 선택해서 내보내는 selectAll(){
    public ArrayList<MovieDTO> selectAll(){
        ArrayList<MovieDTO> temp = new ArrayList<>();
        for(MovieDTO m : list) {
            MovieDTO tempM = new MovieDTO(m);
            
            temp.add(tempM);
        }
        return temp;
    }
    //영화개별보기를 선택하면 하나를 내보내는 selectOne(int id)
    public MovieDTO selectOne(int id) {
        for(MovieDTO m : list) {
            if(m.getId() == id) {
                return new MovieDTO(m);
            }
        }return null;
    }
    
    //관리자권한---------------------------------------------
    
    //리스트에 추가하는insert(MovieDTO m)
    public void insert(MovieDTO m) {
        m.setId(nextId++);
        
        list.add(m);
    }
    //수정된 사항을 리스트에 올리는update(MovieDTO m)
    public void update(MovieDTO m) {
        int index = list.indexOf(m);
        list.set(index, m);
    }
    
   //삭제할번호를 선택하면 삭제를 실행하는 delete(int id)
    public void delete(int id) {
        MovieDTO m = new MovieDTO();
        m.setId(id);
        list.remove(m);
    }
    
}
