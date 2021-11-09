
package day0909;
// 사용자로부터 정보를 입력 받아서
// 다음과 같은 형식으로 비만도를 출력하는 프로그램을 작성하시오

import java.util.Scanner;

public class Ex05BmiChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 상수
        final double BMI_STANDARD1 = 18.5;
        final double BMI_STANDARD2 = 23;
        final double BMI_STANDARD3 = 24;
        
        
        //이름입력
        System.out.println("이름을 입력해주세요.");
        System.out.print("> ");
        String name = scanner.nextLine();
        
        //키 입력
        System.out.println("키를 미터 단위로 입력해주세요.");
        System.out.print("> ");
        double height = scanner.nextDouble();
        
        while ( height > 2.72) 
     // while( !(height > 0 && height <= MAX_HIGHT) )  
        {
            System.out.println("잘못 입력하셨습니다.");
            System.out.println("키를 미터 단위로 입력해주세요.");
            System.out.print("> ");
            height = scanner.nextDouble();
        }
        
        //몸무게 입력
        System.out.println("몸무게를 킬로그램 단위로 입력해주세요.");
        System.out.print("> ");
        double weight = scanner.nextDouble();
        
        while ( weight > 650)
     // while( !(height > 0 && height <= MAX_HIGHT) )
        {
            System.out.println("잘못 입력하셨습니다.");
            System.out.println("몸무게를 킬로그램 단위로 입력해주세요.");
            System.out.print("> ");
            weight = scanner.nextDouble();
        }
        
        // BMI계산
        double bmi = weight / height / height;
                                   
        // 비만도 값 결정
        
        // 비만도 값을 저장할 String 클래스 변수 '선언'
        String result; 
        //선언은 여기서하고 초기화를 해주어야한다.(변수는 선언하고 초기화를 반드시 해야함.)
        //if문에서 true면 true의 값이 나오고, 
        //false의 경우 나올 값이 없다. 그래서 else(false의 답)의 값이 필수이다.
        //아니면 else의 값을 먼저 여기서 초기화해준다.(그럼 밑에if문에 else가 필요없다.)
                
        if(bmi < BMI_STANDARD1) {
            result = "저체중";
        } else if (bmi < BMI_STANDARD2) {
            result = "정상체중";
        } else if (bmi < BMI_STANDARD3) {
            result = "과체중";
        } else {
            result = "비만";
        }                
                
        //결과 출력
     
        System.out.printf("이름: [%s] 키: %2f M 몸무게: %2f kg\n", name, height, weight);
        System.out.printf("BMI: %.3f 비만도: %s\n", bmi, result);
        
        scanner.close();
    }
}
