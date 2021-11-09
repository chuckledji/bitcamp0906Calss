package classEx;

public class OracleConnector implements DBConnector {

    @Override
    public void makeConnection() {
        System.out.println("Oracle 데이터베이스와의 연결실행");
    }

    @Override
    public void destroyConnection() {
        System.out.println("Oracle 데이터베이스와의 연결종료");
    }

    @Override
    public void insert() {
        System.out.println("Oracle 데이터베이스 insert()실행");
    }

    @Override
    public void delete() {
        System.out.println("Oracle 데이터베이스 delete()실행");
    }

    @Override
    public void selectAll() {
        System.out.println("Oracle 데이터베이스 SelectAll()실행");
    }

    @Override
    public void selectOne() {
        System.out.println("Oracle 데이터베이스 SelectAOne()실행");
    }

    @Override
    public void update() {
        System.out.println("Oracle 데이터베이스 update()실행");
        
    }

}
