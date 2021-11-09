package day0908;
// 사용자로부터 정보를 입력 받아서

// 다음과 같은 형식으로 비만도를 출력하는 프로그램을 작성하시오

// 결과)))
// 이름: [###] 키: #.## M 몸무게: ##.## kg
// BMI: ##.### 비만도: ###

// 단, BMI 공식은
// 몸무게 / 키(미터 단위) / 키(미터 단위) 입니다.
// 비만도는
// ~18.5: 저체중
// ~23: 정상체중
// ~25: 과체중
// 그외: 비만
// 으로 분류됩니다.

// 3시 20분까지
import java.util.Scanner;

public class Ex09BmiChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 상수
        final double BMI_STANDARD1 = 18.5;
        final double BMI_STANDARD2 = 23;
        final double BMI_STANDARD3 = 25;

        // 이름 입력
        System.out.println("이름을 입력해주세요.");
        System.out.print("> ");
        String name = scanner.nextLine();

        // 키 입력
        System.out.println("키를 미터 단위로 입력해주세요.");
        System.out.print("> ");
        double height = scanner.nextDouble();

        // 몸무게 입력
        System.out.println("몸무게를 킬로그램 단위로 입력해주세요.");
        System.out.print("> ");
        double weight = scanner.nextDouble();

        // BMI 계산
        double bmi = weight / height / height;

        // 비만도값 결정

        // 비만도값을 저장할 String 클래스 변수 '선언'
        String result;

        if (bmi < BMI_STANDARD1) {
            result = "저체중";
        } else if (bmi < BMI_STANDARD2) {
            result = "정상체중";
        } else if (bmi < BMI_STANDARD3) {
            result = "과체중";
        } else {
            result = "비만";
        }

        // 결과 출력
        System.out.printf("이름: [%s] 키: %.2f M 몸무게: %.2f kg\n", name, height, weight);
        System.out.printf("BMI: %.3f 비만도: %s\n", bmi, result);

        scanner.close();
    }
}
