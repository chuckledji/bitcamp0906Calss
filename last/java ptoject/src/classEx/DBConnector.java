package classEx;
// DataBase 연결을 담당할 클래스들이 가지고 있을
// 메소드를 선언한 인터페이스
public interface DBConnector {
    public void makeConnection();
    public void destroyConnection();
    public void insert();
    public void delete();
    public void selectAll();
    public void selectOne();
    public void update();
    //반드시 7개의 메소드를 가지고있어야만한다 
    //(abstract가 안붙었지만 모두 추상메소드가 된다)
    
    //public String conn;
    //인터페이스는 필드가 존재할 수 없다

}
