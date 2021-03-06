package day0923;

import java.util.Scanner;

import classEx.DBConnector;
import classEx.MySqlConnector;
import classEx.OracleConnector;
import util.ScannerUtil;

//인터페이스를 활용해 다형성체험을해보자
public class EX04Interface {
    static DBConnector conn;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        conn = new OracleConnector();
        showMenu(); // MySqlConnector // DBConnector 전부해봄.
    }

    private static void showMenu() {
        String message = "1. DB연결2.데이터입력 3.데이터전체출력 4. 데이터개별출력 5. 데이터 수정 6. 데이터 삭제 7. 프로그램종료";
        while (true) {

            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 7);

            if (userChoice == 1) {
                conn.makeConnection();
            } else if (userChoice == 2) {
                conn.insert();
            } else if (userChoice == 3) {
                conn.selectAll();
            } else if (userChoice == 4) {
                conn.selectOne();
            } else if (userChoice == 5) {
                conn.update();
            } else if (userChoice == 6) {
                conn.delete();
            } else if (userChoice == 7) {
                System.out.println("종료합니다");
                conn.destroyConnection();
                break;
            } // 이거 다시 작성 다시듣자 다섯시
        }
    }
}
