package controller;

import java.util.ArrayList;
import java.util.Calendar;

import model.BoardDTO;

public class BoardController {
    private ArrayList<BoardDTO> list;
    private int nextId;

    public BoardController() {
        list = new ArrayList<>();
        nextId = 1;

        // 초기화시 기본적으로 list에 글을 몇개 추가되게 코드를 작성해보자
        for (int i = 1; i <= 5; i++) {
            BoardDTO b = new BoardDTO();
            b.setTitle("제목" + i);
            b.setWriter("작성자" + i);
            b.setContent("내용" + i);
            insert(b);
        }

    }

    // insert()
    public void insert(BoardDTO b) {
        b.setId(nextId++);
        b.setWrittenDate(Calendar.getInstance());
        b.setUpdatedDate(Calendar.getInstance());
        list.add(b);
    }

    // selectAll()
    public ArrayList<BoardDTO> selectAll() {
        ArrayList<BoardDTO> temp = new ArrayList<>();

        for (BoardDTO b : list) {
            temp.add(deepCopy(b));
        }

        return temp;
    }

    // selectOne()
    public BoardDTO selectOne(int id) {
        for (BoardDTO b : list) {
            if (b.getId() == id) {
                return deepCopy(b);
            }
        }

        return null;
    }

    // update()
    public void update(BoardDTO b) {
        b.setUpdatedDate(Calendar.getInstance());

        int index = list.indexOf(b);
        list.set(index, b);
    }

    // delete()
    public void delete(int id) {
        BoardDTO temp = new BoardDTO();
        temp.setId(id);
        list.remove(temp);
    }

    // deepCopy()
    public BoardDTO deepCopy(BoardDTO b) {
        BoardDTO temp = new BoardDTO();

        temp.setId(b.getId());
        temp.setTitle(new String(b.getTitle()));
        temp.setWriter(new String(b.getWriter()));
        temp.setContent(new String(b.getContent()));
        temp.setWrittenDate(b.getWrittenDate());
        temp.setUpdatedDate(b.getUpdatedDate());

        return temp;
    }

}
