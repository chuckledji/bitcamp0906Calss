package day0909;

import java.util.Scanner;

public class Ex10GradeBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int SUBJECT_SIZE = 3;

        int id = 0;
        String name = "";
        int korean = 0;
        int english = 0;
        int math = 0;
        boolean inputSwitch = false;

        while (true) {
            System.out.println("1. 입력 2. 출력 3. 종료");
            System.out.print("> ");
            int userChoice = scanner.nextInt();

            if (userChoice == 1) {
                // 입력 코드 구현
                // 사용자가 입력한 int 값을 임시로 보관할 변수
                int temp;

                // 번호 입력
                System.out.println("번호를 입력해주세요.");
                System.out.print("> ");
                id = scanner.nextInt();

                // 이름 입력
                System.out.println("이름을 입력해주세요.");
                System.out.print("> ");
                scanner.nextLine();
                name = scanner.nextLine();

                // 국어 점수 입력
                System.out.println("국어 점수를 입력해주세요.");
                System.out.print("> ");
                temp = scanner.nextInt();

                while (!(temp >= 0 && temp <= 100)) {
                    System.out.println("잘못 입력하셨습니다.");

                    System.out.println("국어 점수를 입력해주세요.");
                    System.out.print("> ");
                    temp = scanner.nextInt();
                }

                korean = temp;

                // 영어 점수 입력
                System.out.println("영어 점수를 입력해주세요.");
                System.out.print("> ");
                temp = scanner.nextInt();

                while (!(temp >= 0 && temp <= 100)) {
                    System.out.println("잘못 입력하셨습니다.");

                    System.out.println("영어 점수를 입력해주세요.");
                    System.out.print("> ");
                    temp = scanner.nextInt();
                }

                english = temp;

                // 수학 점수 입력
                System.out.println("수학 점수를 입력해주세요.");
                System.out.print("> ");
                temp = scanner.nextInt();

                while (!(temp >= 0 && temp <= 100)) {
                    System.out.println("잘못 입력하셨습니다.");

                    System.out.println("수학 점수를 입력해주세요.");
                    System.out.print("> ");
                    temp = scanner.nextInt();
                }

                math = temp;

                inputSwitch = true;

            } else if (userChoice == 2) {

                if (inputSwitch) {
                    // 출력 코드 구현
                    // 총점 계산
                    int sum = korean + english + math;

                    // 평균 계산
                    double average = (double) sum / SUBJECT_SIZE;

                    // 결과 출력
                    System.out.printf("번호: %d번 이름: %s\n", id, name);
                    System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", korean, english, math);
                    System.out.printf("총점: %03d점 평균: %06.2f점\n", sum, average);
                } else {
                    System.out.println("아직 입력된 정보가 존재하지 않습니다.");
                }

            } else if (userChoice == 3) {
                // 종료
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }

        scanner.close();
    }
}
