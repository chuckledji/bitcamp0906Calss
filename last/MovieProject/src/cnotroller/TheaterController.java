package cnotroller;

import java.util.ArrayList;

import model.TheaterDTO;

public class TheaterController {
    private ArrayList<TheaterDTO>list;
    private int nextId;
    
    public TheaterController() {
        list = new ArrayList<>();
        nextId = 1;
    }
    
    public void insert(TheaterDTO t) {
        t.setId(nextId++);
        list.add(t);
    }
    public ArrayList<TheaterDTO> selectAll(){
        ArrayList<TheaterDTO> temp = new ArrayList();
        for(TheaterDTO t : list) {
            TheaterDTO tempT = new TheaterDTO(t);
            temp.add(tempT);
        }
        return temp;
    }
    public TheaterDTO selectOne(int id) {
        for(TheaterDTO t : list) {
            if(t.getId() == id) {
                return new TheaterDTO(t);
            }
        }
        return null;
    }
    //관리자 권한------------------------------
    public void update(TheaterDTO t) {
        int index = list.indexOf(t);
        list.set(index, t);
        
    }
    public void delete(int id) {
        TheaterDTO t = new TheaterDTO();
        t.setId(id);
        list.remove(t);
    }
    
}
