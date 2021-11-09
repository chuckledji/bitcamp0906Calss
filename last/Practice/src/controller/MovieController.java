package controller;

import java.util.ArrayList;

import model.MovieDTO;

public class MovieController {
    private ArrayList<MovieDTO> list;
    private int nextId;
    
    public MovieController() {
        list = new ArrayList<>();
        nextId = 1;
        
        MovieDTO m = new MovieDTO();
        m.setTitle("영화1");
        m.setSummary("영화줄거리1");
        m.setFilmGrade(13);//이등급도 회원등급처럼 처리하는게 편하긴함
        insert(m);
        
        m = new MovieDTO();
        m.setTitle("영화2");
        m.setSummary("영화줄거리2");
        m.setFilmGrade(15);
        insert(m);
        
        m = new MovieDTO();
        m.setTitle("영화3");
        m.setSummary("영화줄거리3");
        m.setFilmGrade(18);
        insert(m);
    }
    
    //영화추가메소드
    public void insert(MovieDTO m) {
        m.setId(nextId++);
        
        list.add(m);
    }
    
    //영화목록불러오기메소드
    public ArrayList<MovieDTO> selectAll(){
        ArrayList<MovieDTO> temp = new ArrayList<>();
        for(MovieDTO m : list) {
            temp.add(new MovieDTO(m));
        }
        return temp;
    }
    //개별영화불러오기메소드
    public MovieDTO selectOne(int id) {
        for(MovieDTO m : list) {
            if( m.getId() == id) {
                return new MovieDTO(m);
            }
        }
        return null;
    }
    //영화수정메소드
    public void update(MovieDTO m) {
        int index = list.indexOf(m);
        list.set(index, m);
    }
    //영화삭제메소드
    public void delete (int id) {
        MovieDTO m = new MovieDTO();
        m.setId(id);
        list.remove(m);
    }
    
}
