package day0909;

import java.util.Scanner;

public class Ex04BmiChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 상수
        final double MAX_HEIGHT = 2.72;
        final double MAX_WEIGHT = 650;
        final double BMI_STANDARD1 = 18.5;
        final double BMI_STANDARD2 = 23;
        final double BMI_STANDARD3 = 25;

        // 이름을 입력 받는다.
        System.out.println("이름을 입력해주세요.");
        System.out.print("> ");
        String name = scanner.nextLine();

        // 키를 입력 받는다.
        System.out.println("키를 입력해주세요.");
        System.out.print("> ");
        double height = scanner.nextDouble();

        while (!(height > 0 && height <= MAX_HEIGHT)) {
            System.out.println("잘못 입력하셨습니다.");

            System.out.println("키를 입력해주세요.");
            System.out.print("> ");
            height = scanner.nextDouble();
        }

        // 몸무게를 입력 받는다.
        System.out.println("몸무게를 입력해주세요.");
        System.out.print("> ");
        double weight = scanner.nextDouble();

        while (!(weight > 0 && weight <= MAX_WEIGHT)) {
            System.out.println("잘못 입력하셨습니다.");

            System.out.println("몸무게를 입력해주세요.");
            System.out.print("> ");
            weight = scanner.nextDouble();
        }

        // BMI 계산한다.
        double bmi = weight / height / height;

        // 결과값 결정
        String result = "비만";

        if (bmi < BMI_STANDARD1) {
            result = "저체중";
        } else if (bmi < BMI_STANDARD2) {
            result = "정상체중";
        } else if (bmi < BMI_STANDARD3) {
            result = "과체중";
        }

        // 출력
        System.out.printf("이름: [%s] 키: %.2f M 몸무게: %.2f kg\n", name, height, weight);
        System.out.printf("BMI: %.3f 비만도: %s\n", bmi, result);

        scanner.close();
    }
}
