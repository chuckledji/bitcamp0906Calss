package day0914;
// 사용자가 넘겨주는 int값 2개를 

// 사칙연산을 예쁘게 출력하고(예: 5 X 3 = [15])
// 그 결과값을 리턴하는 메소드 5개를 만들고
// 메인 메소드에서 사용자가 키보드 입력을 통해
// 입력한 int값 2개에 대한 메소드 결과를 실행시키는 
// 코드를 작성하시오

// 단, 나눗셈의 경우 결과가double로 나올 수 있게 작성하시오
import java.util.Scanner;
public class Ex07Caculator {

    // 더하기 담당
    // 메소드 리턴타입int 이며 그 뒤에 파라미터는 숫자 드ㅜ개 들어가야함.num1도된다
    public static int add(int a, int b) {
        System.out.printf("%d + %d = [%d]\n", a, b, a + b);
        return a + b; // 는 왜 해야되는거야?
    }

    // 빼기담당메소드

    public static int subtract(int a, int b) {
        System.out.printf("%d - %d = [%d]\n", a, b, a - b);
        return a - b;
    }
    // 곱하기담당메소드
    public static int multiply(int a, int b) {
        System.out.printf("%d X %d = [%d]\n", a, b, a * b);
        return a * b;
    }

    // 나누기담당메소드
    // 리턴타입 더블이므로
    public static double divide(int a, int b) {
        System.out.printf("%d / %d = [%.3f]\n", a, b, (double) a / b);
        return (double) a / b;
    }
    // 나머지담당메소드
    public static int remain(int a, int b) {
        System.out.printf("%d %% %d = [%d]\n", a, b, a % b);
        return a%b;
    }
    public static void main(String[] args) {
        //컨트롤스페이스엔터 누르면 만들엊;ㅣㅁ
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("첫번째 숫자를 입력해수제");
        System.out.println("> ");
        int num1 = scanner.nextInt();
        System.out.println("두번째 숫자를 입력해수제");
        System.out.println("> ");
        int num2 = scanner.nextInt();
        
        add(num1, num2); //넘겨주면 파라미터는 int b는 num2이된다
        subtract(num2, num1);//이건반대. 들어오는 순서대로 이름 붙임
        multiply(num1, num2);
        divide(num1, num2);
        remain(num1, num2);
        
        add(add(2,3), add(4,5));
        //메소드의 파라미터안에 또 메소드가 들어가있는 것도 가능
        // = > add(5, 9)랑 똑같다.
        
        
        scanner.close();
    }
}
