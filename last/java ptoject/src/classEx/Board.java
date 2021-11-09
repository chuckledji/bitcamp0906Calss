package classEx;

public class Board {
    //필드
    public int num;
    public String name;
    public String title;
    public String content;
    
    //메소드
    public void printContent() {
        System.out.printf("글번호: d% 작성자: s%\n", num, name);
        System.out.printf("제목: s%\n", title);
        System.out.printf("내용: s%\n", content);
        
    }
    public boolean equals(Object o) {
        if(o instanceof BoardTver) {
            Board b = (Board)o;
            if(num == b.num) {
                return true;
            }
        }
        return false;
    }
   
  
    
}
