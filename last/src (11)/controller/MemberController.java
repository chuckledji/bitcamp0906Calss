package controller;

import java.util.ArrayList;

import model.MemberDTO;

public class MemberController {
    private ArrayList<MemberDTO> list;
    private int nextId;

    public MemberController() {
        list = new ArrayList<>();
        nextId = 1;
       
    }

    // deepCopy(MemberDTO m)
    public MemberDTO deepCopy(MemberDTO m) {
        MemberDTO temp = new MemberDTO();

        temp.setId(m.getId());
        temp.setUsername(new String(m.getUsername()));
        temp.setNickname(new String(m.getNickname()));

        return temp;
    }

    // insert(MemberDTO m)
    public void insert(MemberDTO m) {
        m.setId(nextId++);

        list.add(m);
    }

    // selectOne(int id)
    public MemberDTO selectOne(int id) {
        for (MemberDTO m : list) {
            if (m.getId() == id) {
                return deepCopy(m);
            }
        }

        return null;
    }

    // update(MemberDTO m)
    public void update(MemberDTO m) {
        int index = list.indexOf(m);
        list.set(index, m);
    }

    // delete(int id)
    public void delete(int id) {
        MemberDTO m = new MemberDTO();
        m.setId(id);

        list.remove(m);
    }

    // validateUsername(String username)
    public boolean validateUsername(String username) {
        if(username.equalsIgnoreCase("X")) {
            return true;
        }
        
        for (MemberDTO m : list) {
            if (m.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }

        return false;
    }

    // auth(String username, String password)
    public MemberDTO auth(String username, String password) {
        for (MemberDTO m : list) {
            if (m.getUsername().equalsIgnoreCase(username) && m.getPassword().equals(password)) {
                return deepCopy(m);
            }
        }

        return null;
    }
}
