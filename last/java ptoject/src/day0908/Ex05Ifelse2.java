package day0908;

// 모두 반대로 만들어 보세요 
import java.util.Scanner;

public class Ex05Ifelse2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------1번--------------------");
        
        
      //1. int변수 num을 만들고 4로 초기화해서 만약 num이 5보다 작으면 "5보다 작습니다" 가 출력되게 코드를 작성하시오
        int num = 4;
        if (num < 5) {
            System.out.println("5보다 작습니다.");
        } else {
            System.out.println("5보다 큽니다.");
        }
        
        System.out.println("-----------------2번--------------------");
        
        
      //2. 변수 num에 8로 초기화하고 만약 num이 짝수이면 "짝수입니다."가 출력되게 코드를 작성하시오
        num = 8;
        
        if (num % 2 == 0) {
            System.out.println("짝수입니다.");
        } else {
            System.out.println("홀수입니다.");
        }
        
        System.out.println("-----------------3번--------------------");
        
        
      // 3. 사용자로부터 숫자를 입력받아서 해당 숫자가 6의배수이면, "6의 배수입니다"가 출력되게 코드를 작성하시오
        System.out.println("숫자를 입력해주세요.");
        System.out.print("> ");
        num = scanner.nextInt();
        
        if(num % 6 == 0) {
                System.out.println("6의 배수입니다.");
        }else {
            System.out.println("6의 배수가 아닙니다.");
        }
        
        System.out.println("-----------------4번--------------------");
       
        
      // 4. 사용자로부터 나이를 입력받아서 미성년자일시, "미성년자입니다"가 출력되게 코드를 작성하시오
        System.out.println("나이를 입력해주세요.");
        System.out.print("> ");
        int age = scanner.nextInt();
        
        if (age < 20) {
            System.out.println("미성년자입니다.");
        } else {
            System.out.println("성인입니다.");
        }
        
        System.out.println("-----------------5번--------------------");
        
        
      // 5. 사용자로부터 숫자를 입력받아서 50이상 60미만일 경우, "50번대 숫자입니다"가 출력되게 코드를 작성하시오
        System.out.println("숫자를 입력해주세요.");
        System.out.print("> ");
        num = scanner.nextInt();
        
        if (num >= 50 && num < 60) {
            System.out.println("50번대 숫자입니다.");
        }else {
            System.out.println("50번대 숫자가 아닙니다.");
        }
        
        System.out.println("-----------------6번--------------------");
        
        scanner.nextLine(); // 밑에 string을 써야 해서 날려버려야하기때문에
        
      // 6. 사용자로부터 아이디와 비밀번호를 입력받아서 아이디가 "admin"이고 비밀번호가 "111"이면 
      //    "로그인성공"이 출력되게 코드를 작성하시오. 단, 아이디는 대소문자 구분을 하지 않습니다.
        System.out.println("아이디를 입력해주세요.");
        System.out.print("> ");
        String username = scanner.nextLine();
        
        System.out.println("비밀번호를 입력해주세요.");
        System.out.print("> ");
        String password = scanner.nextLine();
        if (username.equalsIgnoreCase("admin") && password.equals("111")) {
            System.out.println("로그인 성공");
        }       else {
            System.out.println("로그인 실패");
        }
       scanner.close();
    }

}
