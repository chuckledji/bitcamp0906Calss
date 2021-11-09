package day0923;

import java.util.ArrayList;
import java.util.Scanner;

import classEx.Student2;
import util.ScannerUtil;

public class GradeBook01 {
    private static ArrayList<Student2> list = new ArrayList<>(); // 다른데서 쓸 일이없으니 프라이빗
    private static Scanner scanner = new Scanner(System.in);
    private static int nextId = 1;
    private static final int SCORE_MIN = 0;
    private static final int SCORE_MAX = 100;

    // 1. 메인 메소드가
    public static void main(String[] args) {
        showMenu();
    }

    // 2. 메뉴 출력 메소드
    private static void showMenu() {
        String message = new String("1.입력 2.출력 3.종료");
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message);
            if (userChoice == 1) {
                insert();
            } else if (userChoice == 2) {
                printList();
            } else if (userChoice == 3) {
                System.out.println("종료");
                scanner.close();
                break;
            }
        }
    }

    // 3. 학생 입력 메소드
    private static void insert() {
        String message;
        Student2 s = new Student2();

        //입력
        s.setId(nextId++);
        
        message = new String("학생의 이름을 입력해주세요");
        s.setName(ScannerUtil.nextLine(scanner, message));

        message = new String("학생의 국어점수를 입력해주세요");
        s.setKorean(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));

        message = new String("학생의 영어점수를 입력해주세요");
        s.setEnglish(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));

        message = new String("학생의 수학점수를 입력해주세요");
        s.setMath(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));

        // 배열에s추가
        list.add(s);
    }

    // 4. 학생 목록 메소드
    private static void printList() {
        if (list.isEmpty()) {
            System.out.println("아직입력한정보가없습니다");
        } else {
            for (int i = 0; i < list.size(); i++) {
                Student2 s = list.get(i);
            }
            // 향상된 for문(forEach문)
            // forEach문이란, List, 배열등의
            // 똑같은 데이터타입이 차례대로 모여있는 경우
            // 해당 콜렉션의 객체를 차례대로 뽑아서
            // 임시 변수로 불러주는 for문이다
            // 단, 해당 forEach문을 쓸 때
            // 콜렉션의 크기가 변경되면 에러가 발생되므로
            // 출력에서만 사용하는 것이 좋다

            for (Student2 s : list) {
                System.out.printf("%d. %s\n", s.getId(), s.getName());
            }
            String message = new String("상세보기할 학생의번호나 뒤로가려면 0을눌러주세요");
            int userChoice = ScannerUtil.nextInt(scanner, message);

            while (userChoice != 0 && retrieve(userChoice) == null) {
                System.out.println("잘못된 번호");
                userChoice = ScannerUtil.nextInt(scanner, message);

            }
            if (userChoice != 0) {
                printOne(userChoice);
            }
        }
    }

    // 5. 학생번호확인 메소드 + 학생번호인덱스 검색 메소드
    // 학생번호를 토대로 일치하는 학생을 
    // list에서 검색하여 리턴하는 메소드.
    // 단, 해당학생번호가 존재하지 않을 경우에는 null이 리턴된다.
    private static Student2 retrieve(int id) {
        Student2 s = new Student2();
        s.setId(id);

        int index = list.indexOf(s);

        if (index != -1) {
            return list.get(index);
        }
        return null;
    }

    // 6. 학생 개별보기 메소드
    private static void printOne(int id) {
        Student2 s = retrieve(id);
        // retrieve id일치하는 주소가 s에 복사되었을 것

        s.printInfo();

        String message = new String("1.수정 2.삭제 3.뒤로가기");
        int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
        if (userChoice == 1) {
            // 수정메소드호출
            update(id);
        } else if (userChoice == 2) {
            // 삭제메세지호출
            delete(id);
        } else if (userChoice == 3) {
            printList();
        }
    }

    // 7. 학생 수정 메소드
    private static void update(int id) {
        Student2 s = retrieve(id);

        String message;

        message = "새로운 국어점수를 입력해주세요";
        s.setKorean(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));

        message = "새로운 영어점수를 입력해주세요";
        s.setEnglish(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));

        message = "새로운 수학점수를 입력해주세요";
        s.setMath(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));

        printOne(id);
    }

    // 8. 학생 삭제 메소드
    private static void delete(int id) {
        Student2 s = retrieve(id);
        
        String message = new String("정말로 삭제하시겠습니까? Y/N");
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            list.remove(s);
            printList();
        } else {
            printOne(id);
        }
    }

}
