package day0908;
// 사용자로부터 성별, 나이, 신체등급을 입력받아

// 현역, 공익, 면제를 출력하는 프로그램을 작성하시오

// 단, 사용자가 여성의 경우, 추가적인 입력 없이
// "여성에게는 국방의 의무가 부여되지 않습니다." 만 출력되게 코드를 작성하시오

// 단, 사용자가 남성이지만 미성년자의 경우
// "아직 미성년자에게는 신체등급이 부여되지 않습니다." 만 출력되게 코드를 작성하시오.

//성별의 경우, 입력시에 int로 입력을 받아 1이면 남자, 2이면 여자로 판정합니다.
// 현역: 1~3
// 공익: 4
// 면제: 그외
import java.util.Scanner;

public class Ex11Army {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    // 사용자에게 성별을 입력받는다.
    System.out.println("성별을 입력해주세요.(남성일시1, 여성일시2 입력)");
    System.out.print("> ");
    int sex = scanner.nextInt();
    
    if (sex == 1) {
        System.out.println("나이를 입력해주세요.");
        System.out.print("> ");
        int age = scanner.nextInt();
        
        if (age >= 20) { 
            // 성인이므로 신체등급입력
            System.out.println("신체등급을 입력해주세요.");
            System.out.print("> ");
            int category  = scanner.nextInt();
             
            if(category <= 3) {
                System.out.println("현역입니다");
            } else if(category == 4 ) {
                System.out.println("공익입니다");
            } else{
                System.out.println("면제입니다");
            } 
            }else {
                // 미성년자이므로 메세지만 출력
                System.out.println("아직 미성년자에게는 신체등급이 부여되지 않습니다.");
            }
        
        
     } else {
         System.out.println("여성에게는 국방의 의무가 부여되지 않습니다.");
     }
           
   scanner.close();
}
}