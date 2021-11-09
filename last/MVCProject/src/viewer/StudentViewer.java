package viewer;

import java.util.ArrayList;
import java.util.Scanner;

import controller.StudentController;
import model.StudentDTO;
import util.ScannerUtil;

public class StudentViewer {
    // 우리는 서버가 따로 존재하지 않으므로
    // 한개의 컨트롤러만 사용되어야 한다.
    // 따라서 StudentViewer의 필드로
    // StudentController 객체가 하나 있어야 하고
    // 데이터를 CRUD할 때 반드시 그 하나의 StudentController 객체를 통해서만
    // 해야 정상적으로 입력, 수정, 삭제 등이 반영될 수 있다.
    private StudentController studentController;
    private Scanner scanner;

    private final int SUBJECT_SIZE = 3;
    private final int SCORE_MIN = 0;
    private final int SCORE_MAX = 100;

    public StudentViewer() { //생성자만들어준다.위에 필드에 선언되어 있는 생성자!
                             // 생성자는 다른데서 호출할 수 있도록public
        studentController = new StudentController(); // 객체초기화
        studentController.makeConnection();
        //이 메소드를 통해 어레이리스트랑  nextId쓸 수 있는 것!
        //하지만 설명 다시 들어보자

        scanner = new Scanner(System.in);
    }

    // 메뉴 출력을 담당하는 showMenu()
    public void showMenu() {
        String message = new String("1. 새로운 학생 입력 2. 학생 목록 출력 3. 종료");
        while (true) {
            System.out.println("--------------------------------------");
            System.out.println("비트고등학교 학생관리 프로그램");
            System.out.println("--------------------------------------");
            System.out.println();
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice == 1) {
                // 학생 입력 메소드 호출
                add();
            } else if (userChoice == 2) {
                // 학생 목록 출력 메소드 호출
                printAll();
            } else if (userChoice == 3) {
                // 경고 메시지 후 프로그램 종료
                System.out.println("사용해주셔서 감사합니다.");
                scanner.close();
                break;
            }
        }
    }

    // 학생 입력을 담당하는 메소드
    private void add() {
        StudentDTO s = new StudentDTO();//클래스의 객체 선언 및 초기화

        String message;

        message = new String("학생의 이름을 입력해주세요.");
        s.setName(ScannerUtil.nextLine(scanner, message));//그 변수에 값을 저장한다

        message = new String("학생의 국어 점수를 입력해주세요.");
        s.setKorean(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));

        message = new String("학생의 영어 점수를 입력해주세요.");
        s.setEnglish(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));

        message = new String("학생의 수학 점수를 입력해주세요.");
        s.setMath(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));

        studentController.insert(s);//스튜던트 컨트롤러의 인서트 메소드를 실행하여 입력한s값을 저장한다
    }

    private void printAll() {
        ArrayList<StudentDTO> temp = studentController.selectAll();//모든 값을 불러서 temp배열에 저장한다.
        // 모든값이 temp에 저장이 되었다.
        // 이것이 비었으면 입력하라고 하기
        // 아니라면 차례대로 출력해내면 된다
        if (temp.isEmpty()) {
            System.out.println("-------------------------------");
            System.out.println("아직 입력된 학생이 존재하지 않습니다.");
            System.out.println("-------------------------------");
            System.out.println();
        } else {
            for (StudentDTO s : temp) { //배열차례대로 값이 나온다.
                System.out.printf("%d. %s\n", s.getId(), s.getName());
            }
            System.out.println("-------------------------------");
            String message = new String("상세보기할 학생의 번호나 뒤로가실려면 0을 입력해주세요.");

            int userChoice = ScannerUtil.nextInt(scanner, message);

            while (userChoice != 0 && studentController.selectOne(userChoice) == null) {
                System.out.println("해당 번호를 가진 학생은 존재하지 않습니다.");
                userChoice = ScannerUtil.nextInt(scanner, message);
            }

            if (userChoice != 0) {
                // 개별 출력 메소드 호출
                printOne(userChoice);
            }
        }
    }

    private void printOne(int id) {
        StudentDTO s = studentController.selectOne(id);//번호에 해당하는 한학생의정보를 s객체에 저장한다.

        System.out.println("-----------------------------");
        System.out.println(s.getName() + " 학생 정보"); //저장한s객체에서 이름을 불로러온다.
        System.out.println("-----------------------------");
        System.out.printf("번호: %d번 이름: %s\n", s.getId(), s.getName());
        System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", s.getKorean(), s.getEnglish(), s.getMath());
        int sum = s.getKorean() + s.getEnglish() + s.getMath();
        double average = (double) sum / SUBJECT_SIZE;
        System.out.printf("총점: %03d점 평균: %06.2f점\n", sum, average);
        System.out.println("-----------------------------");
        String message = new String("1. 수정 2. 삭제 3. 목록으로");
        int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
        if (userChoice == 1) {
            // 수정 메소드 호출
            update(id);
        } else if (userChoice == 2) {
            // 삭제 메소드 호출
            delete(id);
        } else if (userChoice == 3) {
            printAll();
        }
    }
    //업데이트 메소드
    private void update(int id) {
        StudentDTO s = studentController.selectOne(id);
        //개별선택하는 메소드실행하여 내용을 s에 저장환다

        String message;

        message = new String("새로운 국어 점수를 입력해주세요.");
        s.setKorean(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));

        message = new String("새로운 영어 점수를 입력해주세요.");
        s.setEnglish(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));

        message = new String("새로운 수학 점수를 입력해주세요.");
        s.setMath(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));

        studentController.update(s); //저장한정보를 컨트롤러업데이트 메소드에 넘긴다.
        printOne(id);
    }

    private void delete(int id) {
        String message = new String("해당 학생을 정말로 삭제하시겠습니까? y/n");
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            studentController.delete(id);//컨트롤러의 딜리트에 id번 정보를 삭제한다.
            printAll();
        } else {
            printOne(id);
        }
    }
}
