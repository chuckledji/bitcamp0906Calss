package cnotroller;

import java.util.ArrayList;
import java.util.Calendar;

import model.RatingDTO;

public class RatingController {
        private ArrayList<RatingDTO>list;
        private int nextId;
        
        //생성자
        public RatingController() {
            list = new ArrayList<>();
            nextId = 1;
       }
        
        //평론가 평론입력
        //평론가면 평론가평론에 따로 입력이 된다
        public void insertCritic(RatingDTO r) {
           r.setId(nextId++);
           r.setGrade(2);
           r.setWrittenDate(Calendar.getInstance());
           
           list.add(r);
        }
        
        //일반관람객평론입력
        public void insert(RatingDTO r) {
            r.setId(nextId++);
            r.setGrade(1);
            r.setWrittenDate(Calendar.getInstance());
            
            list.add(r);
        }
        
        //영화리스트와 그영화의 평점 평균을 계산하는 메소드
        
        
        
        
        //영화에 맞는 평론selectByMovie()
        public ArrayList<RatingDTO>selectByMovie(int movieId){
            ArrayList<RatingDTO>temp = new ArrayList<>();
            for(RatingDTO r : list) {
                if(r.getMovieId() == movieId) {
                    RatingDTO tempR = new RatingDTO(r);
                    temp.add(tempR);
                }
            }return temp;
        }
        
        public void deleteByWriterId(int writerId) {
            for(int i = 0; i <list.size(); i++) {
                if(list.get(i).getWriterId() == writerId) {
                   list.remove(i);
                   i=-1;
                }
            }
        }
        
        
        
}
