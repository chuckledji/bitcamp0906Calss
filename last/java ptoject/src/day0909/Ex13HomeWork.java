package day0909;
// 가위바위보 게임을 만드세요
// 1. 플레이 하기
// 사용자가 선택한 것과
// 컴퓨터가 선택한 것을 
// 각각 보여주고
// 승리, 무승부, 패배 중 하나를 결과로 출력합니다.
//
// 2. 결과 보기
// 사용자의 승리, 무승부, 패배 그리고 승률을 출력합니다.
// 단, 사용자가 한번도 하지 않은 경우에는 
// 아직 플레이 기록이 없습니다 가 출력됩니다.
import java.util.Scanner;
import java.util.Random;
public class Ex13HomeWork {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
       //상수
        //가위
        final int OPTION_SCISSOR = 1;
        //바위
        final int OPTION_ROCK = 2;
        //보
        final int OPTION_PAPER = 3;
        //최대 선택 가능한 옵션 숫자
        final int WIN = 0;
        //변수
        //승리 횟수
        int win = 0;
        //무승부 횟수
        int draw = 0;
        //패배 횟수
        int lose = 0;
        
        
        
        while(true) {
            System.out.println("1. 플레이하기 2. 결과보기 3. 종료");
            System.out.println("> ");
            int userChoice = scanner.nextInt();
            
            if (userChoice == 1) {
                //가위바위보 선택 후 승리여부 출력
                
                //1. 컴퓨터 선택지정
                 int computerNum = random.nextInt(OPTION_MAX + 1);
                
                
                //2. 사용자에게 선택 입력받기
                
                 System.out.println("1.가위 2. 바위 3. 보");
                 System.out.println("> ");
                 int userNum = scanner.nextInt();
                 
                 while(!(userNum >= OPTION_SCISSOR && userNum <= OPTION_PAPER)) {
                     System.out.println("잘못입력하셨습니다");
                     System.out.println("1.가위 2. 바위 3. 보");
                     System.out.println("> ");
                     userNum = scanner.nextInt();
                 }
                 
                //3. 값 비교하여 승리여부 출력
                 
                 //승리, 무승부, 패배 중 하나를 저장할 String result
                 String result = "";
                 
                 //컴퓨터 선택을"가위바위보"중 하나로 변환해서 저장ㅇ할 String compText
                 String compText = "";
                 
                 //사용자의 선택을 "가위바위보"중 하나로 변환해서 저장할 String userText
                 String userText = "";
                 
                 if(userNum == computerNum) {
                     //무승부인경우
                     result = "무승부";
                     draw++;
                     
                     if(userNum == OPTION_SCISSOR) {
                         userText = compText = "가위";
                     }else if(userNum == OPTION_ROCK) {
                         
                         userText = compText = "바위";}
                     else if(userNum == OPTION_PAPER) {
                         userText = compText = "보";
                     }
                 }else {
                     //무승부가 아닌경우
                     if(userNum == OPTION_SCISSOR) {
                         if(computerNum == OPTION_SCISSOR)
                     }else if(userNum == OPTION_ROCK) {
                         
                     }else if(userNum == OPTION_PAPER)
                 }
                 
                 
                 System.out.printf("컴퓨터: s% 사용자: s% 결과: s%  \n", compText, userText, result);
            }
            else if(userChoice == 2) {
                //기록보기 코드 구현
                
                //총전적을 계산한다.
                total = win + lose + draw;
                if(total <0) {
                    //사용자가 한번이상  ㅍ ㅡㄹ레이했으므로 
                    //전적을 출력한다
                    double rate = (double)win / total;
                    
                    System.out.printf("\n 승리: []회 무승부:[]회 패매: []회 승률:[%,2f]%% \n\n", win, draw, lose, rate)
                    
                }else {
                    //사용자가 플레이하지않았으므로 메세지를 출력한다.
                    System.out.println("아직플레이를 하지 않았습니다");
                }
                
            }
            else if (useChoice == 3) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }       
        
        
        scanner.close();
    }
}
