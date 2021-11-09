package day0909;
import java.util.Scanner;
public class 연습 {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("이름을 입력해주세요.");
        System.out.println("> ");
        String name = scanner.nextLine();
        
        System.out.println("키를 입력해주세요.");
        System.out.println("> ");
        Double height = scanner.nextDouble();
        
        while(height > 2.17) {
            System.out.println("잘못 입력하셨습니다.");
            System.out.println("키를 입력해주세요.");
            System.out.println("> ");
            height = scanner.nextDouble();
        }
        System.out.println("몸무게를 입력해주세요.");
        System.out.println("> ");
        Double weight = scanner.nextDouble();
        
        while(weight > 650) {
            System.out.println("잘못 입력하셨습니다.");
            System.out.println("몸무게를 입력해주세요.");
            System.out.println("> ");
            weight = scanner.nextDouble();
        }
        double bmi = weight / height / height;
        
        final double BMI_STANDARD1 = 18.5;
        final double BMI_STANDARD2 = 23;
        final double BMI_STANDARD3 = 24;
        
        String result;
        
        if (bmi < BMI_STANDARD1) {
            result = "저채중";
        } else if (bmi < BMI_STANDARD2) {
            result = "정상채중";
        } else if (bmi < BMI_STANDARD3) {
            result = "과채중";
        }else {
            result = "비만";
        }

            System.out.printf("이름 : [%s] 키: %4.2f M 몸무게: %5.2f kg\n", name, height, weight);
            System.out.printf("BMI: %6.3f 비만도: %s", bmi, result);
            
    scanner.close();
    }
}
