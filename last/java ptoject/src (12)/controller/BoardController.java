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

        for (int i = 1; i <= 6; i++) {
            BoardDTO b = new BoardDTO();

            b.setTitle("제목" + i);
            b.setContent("내용" + i);
            b.setWriterId((i % 3) + 1);

            insert(b);
        }
    }

    public void insert(BoardDTO b) {
        b.setId(nextId++);
        b.setWrittenDate(Calendar.getInstance());
        b.setUpdatedDate(Calendar.getInstance());

        list.add(b);
    }

    public ArrayList<BoardDTO> selectAll() {
        ArrayList<BoardDTO> temp = new ArrayList<>();

        for (BoardDTO b : list) {
            BoardDTO tempB = new BoardDTO(b);

            temp.add(tempB);

        }

        return temp;
    }

    public BoardDTO selectOne(int id) {

        for (BoardDTO b : list) {
            if (b.getId() == id) {
                return new BoardDTO(b);
            }
        }

        return null;
    }

    public void update(BoardDTO b) {
        int index = list.indexOf(b);
        list.set(index, b);
    }

    public void delete(int id) {
        BoardDTO b = new BoardDTO();
        b.setId(id);

        list.remove(b);
    }
}
