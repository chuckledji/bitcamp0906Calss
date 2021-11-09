package dyay0910연습;

import java.util.Random;
import java.util.Scanner;

public class Hw02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // 상수
        final int OPTION_SCISSOR = 1;
        final int OPTION_ROCK = 2;
        final int OPTION_PAPER = 3;
        final int OPTION_MAX = 3;

        // 변수
        int win = 0;
        int lose = 0;
        int draw = 0;
        
        // 승리, 무승부, 패배 중 하나를 저장할 String result
        String result = "";
        // 컴의 선택을 가위바위보로 변환해 저장할 String
        String comChoice = "";
        // 사용자의 선택을 가위바위보로 변환해 저장할 String
        String userChoice = "";
        while (true) {
            System.out.println("1. 플레이 2. 점수보기 3. 종료");
            System.out.println("> ");
            int num = scanner.nextInt();

            if (num == 1) {
                // 플레이에 대한 코드
                // 1.컴퓨터의 숫자선정
                int computerNum = random.nextInt(OPTION_MAX) + 1;

                // 2. 사용자 숫자 입력
                System.out.println("1.가위 2. 바위 3. 보");
                System.out.println("> ");
                int userNum = scanner.nextInt();

                while (!(userNum >= OPTION_SCISSOR && userNum <= OPTION_PAPER)) {
                    System.out.println("잘못입력하셨습니다.");
                    System.out.println("1.가위 2. 바위 3. 보");
                    System.out.println("> ");
                    userNum = scanner.nextInt();
                }
                // 3. 결과 계산 및 출력

               

                if (userNum == computerNum) {
                    // 무승부인 경우
                    result = "무승부";
                    draw++;

                    if (userNum == 1) {
                        userChoice = comChoice = "가위";
                    } else if (userNum == 2) {
                        userChoice = comChoice = "바위";
                    } else if (userNum == 3) {
                        userChoice = comChoice = "보";
                    }
                } else if (userNum == 1) {
                    userChoice = "가위";
                    if (computerNum == 2) {
                        comChoice = "바위";
                        lose++;
                        result = "패배";

                    } else if (computerNum == 3) {
                        comChoice = "보";
                        win++;
                        result = "승리";
                    }
                } else if (userNum == 2) {
                    userChoice = "바위";
                    if (computerNum == 1) {
                        comChoice = "가위";
                        win++;
                        result = "승리";

                    } else if (computerNum == 3) {
                        comChoice = "보";
                        lose++;
                        result = "패배";
                    }
                }else if (userNum == 3) {
                    userChoice = "보자기";
                    if (computerNum == 1) {
                        comChoice = "가위";
                        lose++;
                        result = "패배";

                    } else if (computerNum == 2) {
                        comChoice = "주먹";
                        win++;
                        result = "승리";
                    }
                }
                //출력
                System.out.printf("사용자: %s 컴퓨터: %s 승리여부: %s\n", userChoice, comChoice, result);

            } else if (num == 2) {
                // 점수보기에 대한 코드
                //플레이를 한번도 하지 않았을 떄
                int total = win + lose + draw;
                double rate = (double)win / total * 100; 
                if(total == 0) {
                    System.out.println("아직 플레이한 기록이 없습니다.");
                 }
                System.out.printf("승리: %d회 패배: %d회 무승부: %d회 승률: %.2f%% \n", win, lose, draw, rate);
            } else if (num == 3) {
                // 프로그램 종료
                System.out.println("프로그램을 종료합니다.");
                break;
            }

        }

        scanner.close();
    }
}
