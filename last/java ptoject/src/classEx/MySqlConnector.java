package classEx;
// DBConnector인터페이스를 상속받는 MySql
// 인터페이스 상속은 extends가 아닌 implements라는 키워드를 통해 이루어진다
public class MySqlConnector implements DBConnector{

    @Override
    public void makeConnection() {
        System.out.println("MySql 데이터베이스와의 연결실행");
    }

    @Override
    public void destroyConnection() {
        System.out.println("MySql 데이터베이스와의 연결종료");
    }

    @Override
    public void insert() {
        System.out.println("MySql의 insert()실행");
    }

    @Override
    public void delete() {
        System.out.println("MySql의 delete()실행");
    }

    @Override
    public void selectAll() {
        System.out.println("MySql의 SelectAll()실행");
    }

    @Override
    public void selectOne() {
        System.out.println("MySql의 SelectOne()실행");
    }

    @Override
    public void update() {
        System.out.println("MySql의 update()실행");
    }
}
