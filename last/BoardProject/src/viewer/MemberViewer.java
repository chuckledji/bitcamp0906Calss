package viewer;

import java.util.Scanner;

import controller.MemberController;
import model.MemberDTO;
import util.ScannerUtil;

public class MemberViewer {
    private MemberController memberController;
    private Scanner scanner;
    private MemberDTO logIn;
    private BoardViewer boardViewer;

    public MemberViewer() {
        memberController = new MemberController();
        scanner = new Scanner(System.in);
        logIn = null;

        boardViewer = new BoardViewer();
        boardViewer.setMemberViewer(this); 
        // 우리는 지금 디비도없고 서버도 없다 그래서 뷰어클래스아래 컨트롤러아래 어레이리스트를 생성해서 사용중인데
        // 보드뷰어를 사용중인데 회원정보가 꼭 필요하다. 기존의 멤버컨트롤러를 가져오고싶은데 컨드롤러가 프라이빗이라서 직접 접근이 되지 않는다
        // 그래서보드뷰어 안에 멤컨트롤러를 새로 만든다, 그런데
        // 그 멤컨트롤러 아래의 어레이리스트는 이전 어레이리스트랑 별개의 공간인것.(그래서 이전의 정보들에 접근할 수 없는것)
        // 보드뷰어 안에 멤버뷰어필드를 하나 만들어주되, 대신 멤버뷰어와 필드멤버뷰어를 연결시켜주면 이전 어레이리스트에 졉근할 수 있는 것이다.
        //그 두개를 연결시켜주는 메소드가 위의 셋 메소드이다 
        boardViewer.setScanner(scanner);
    }

    public void showIndex() {
        String message = new String("1. 로그인 2. 회원가입 3. 프로그램 종료");
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);

            if (userChoice == 1) {
                // 로그인 메소드 실행 후,
                // 만약 로그인이 성공적이었을 경우에는
                // showMenu() 실행
                logIn();

                if (logIn != null) {
                    boardViewer.setLogIn(logIn);
                    showMain();
                }

            } else if (userChoice == 2) {
                // 회원가입 메소드 실행
                register();
            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                scanner.close();
                break;
            }
        }
    }

    private void register() {
        String message;

        message = new String("사용하실 아이디를 입력해주세요.");
        String username = ScannerUtil.nextLine(scanner, message);
        while (memberController.validateUsername(username)) {
            System.out.println("해당 아이디는 사용하실 수 없습니다.");
            message = new String("사용하실 아이디를 입력하시거나 뒤로 가실려면 X를 입력해주세요.");
            username = ScannerUtil.nextLine(scanner, message);
            if (username.equalsIgnoreCase("X")) {
                break;
            }
        }

        if (!username.equalsIgnoreCase("X")) {
            message = new String("사용하실 비밀번호를 입력해주세요.");
            String password = ScannerUtil.nextLine(scanner, message);

            message = new String("사용하실 닉네임을 입력해주세요.");
            String nickname = ScannerUtil.nextLine(scanner, message);

            MemberDTO m = new MemberDTO();

            m.setUsername(username);
            m.setPassword(password);
            m.setNickname(nickname);

            memberController.insert(m);

        }
    }

    private void logIn() {
        String message;

        message = new String("아이디를 입력해주세요.");
        String username = ScannerUtil.nextLine(scanner, message);

        message = new String("비밀번호를 입력해주세요.");
        String password = ScannerUtil.nextLine(scanner, message);

        while (memberController.auth(username, password) == null) {
            System.out.println("아이디 혹은 비밀번호가 잘못되었습니다.");
            message = new String("아이디를 입력하시거나 뒤로 가실려면 X를 입력해주세요.");
            username = ScannerUtil.nextLine(scanner, message);

            if (username.equalsIgnoreCase("X")) {
                break;
            }

            message = new String("비밀번호를 입력해주세요.");
            password = ScannerUtil.nextLine(scanner, message);
        }

        logIn = memberController.auth(username, password);

    }

    private void showMain() {
        String message = new String("1. 게시판 2. 회원 정보 보기 3. 로그 아웃");
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);

            if (userChoice == 1) {
                boardViewer.showMenu();
            } else if (userChoice == 2) {
                showMenu();
            } else if (userChoice == 3) {
                System.out.println("성공적으로 로그아웃 하셨습니다.");
                logIn = null;
                boardViewer.setLogIn(null);
            }

            if (logIn == null) {
                break;
            }
        }
    }

    private void showMenu() {
        String message = new String("1. 회원 정보 수정 2. 회원 탈퇴 3. 뒤로 가기");
        while (true) {
            printOne(logIn.getId());
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
            if (userChoice == 1) {
                // 수정 메소드 실행
                update(logIn.getId());

            } else if (userChoice == 2) {
                // 탈퇴 메소드 실행
                delete(logIn.getId());

            } else if (userChoice == 3) {
                break;
            }

            if (logIn == null) {
                break;
            }

        }
    }

    private void printOne(int id) {
        MemberDTO m = memberController.selectOne(id);
        System.out.println("회원 번호: " + m.getId());
        System.out.println("회원 아이디: " + m.getUsername());
        System.out.println("회원 닉네임: " + m.getNickname());
    }

    private void update(int id) {
        String message;

        message = new String("새로운 비밀번호를 입력해주세요.");
        String password = ScannerUtil.nextLine(scanner, message);

        message = new String("새로운 닉네임을 입력해주세요.");
        String nickname = ScannerUtil.nextLine(scanner, message);

        message = new String("정말로 수정하시겠습니까? Y/N");
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            message = new String("기존 비밀번호를 입력해주세요.");
            String oldPassowrd = ScannerUtil.nextLine(scanner, message);
            if (memberController.auth(logIn.getUsername(), oldPassowrd) != null) {
                MemberDTO m = new MemberDTO();
                m.setId(logIn.getId());
                m.setUsername(logIn.getUsername());
                m.setPassword(password);
                m.setNickname(nickname);

                memberController.update(m);
            }
        }
    }

    private void delete(int id) {
        String message = new String("정말로 탈퇴하시겠습니까? Y/N");
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            message = new String("비밀번호를 입력해주세요.");
            String password = ScannerUtil.nextLine(scanner, message);

            if (memberController.auth(logIn.getUsername(), password) != null) {
                memberController.delete(id);
                boardViewer.deleteByWriterId(id);/////////////&&&
                logIn = null;
            }
        }
    }

    // 회원 번호를 파라미터로 받아서
    // 해당 회원의 닉네임만 출력하는 메소드
    public void printNickName(int id) {
        System.out.print(memberController.selectOne(id).getNickname());
    }
}
