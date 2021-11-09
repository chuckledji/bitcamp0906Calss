
package day0909;
// 사용자로부터 정보를 입력 받아서
// 다음과 같은 형식으로 비만도를 출력하는 프로그램을 작성하시오

import java.util.Scanner;

public class Ex05BmiChecker2연습 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 상수
        final double BMI_STANDARD1 = 18.5;
        final double BMI_STANDARD2 = 23;
        final double BMI_STANDARD3 = 24;
        // 변수 
        int num = 0;
        String name = "";
        double height = 0;
        double weight = 0;
                
        //사용자 입 출력 선택        
        
        while(true) {
        System.out.println("1. 입력 2. 출력 3. 종료");
        System.out.print("> ");
        num = scanner.nextInt();
        
        if (num == 1) {
          //이름입력
            System.out.println("이름을 입력해주세요.");
            System.out.print("> ");
            scanner.nextLine();
            name = scanner.nextLine();
            
            //키 입력
            System.out.println("키를 미터 단위로 입력해주세요.");
            System.out.print("> ");
            height = scanner.nextDouble();
            
            while ( height > 2.72) {
                System.out.println("잘못 입력하셨습니다.");
                System.out.println("키를 미터 단위로 입력해주세요.");
                System.out.print("> ");
                height = scanner.nextDouble();
            }
            
            //몸무게 입력
            System.out.println("몸무게를 킬로그램 단위로 입력해주세요.");
            System.out.print("> ");
            weight = scanner.nextDouble();
            
            while ( weight > 650) {
                System.out.println("잘못 입력하셨습니다.");
                System.out.println("몸무게를 킬로그램 단위로 입력해주세요.");
                System.out.print("> ");
                weight = scanner.nextDouble();
            }
            
        }
        //2.사용자가 출력을 선택했을 때
        else if(num == 2) {
         
            if( name == "" || height == 0 || weight == 0) {
                System.out.println("아직은 입력된 정보가 없습니다.");
            }else {
                // BMI계산
                double bmi = weight / height / height;
                                           
                // 비만도 값 결정
                String result; 
              
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
            }
                            
        }
        //3. 사용자가 종료를 선택했을 때
        else if(num == 3) {
            System.out.println("프로그램을 종료합니다.");
            break;
        }
        }
        scanner.close();
    }
}
