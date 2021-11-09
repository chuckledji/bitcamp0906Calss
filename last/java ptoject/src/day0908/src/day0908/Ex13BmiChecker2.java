package day0908;
// 사용자로부터 키와 몸무게를 입력 받아

// BMI수치를 계산하고 비만도를 출력하는 프로그램을 작성하시오.

// 기네스북에 따르면 세계에서 가장 키가 컸던 사람의 키는 2.72m였습니다.
// 기네스북에 따르면 세계에서 가장 몸무게가 무거웠던 사람의 몸무게는 650킬로그램였습니다.

// 만약 사용자가 잘못된 값을 입력할 경우, 추가적인 입력 없이 
// "잘못된 입력을 감지하여 프로그램을 종료합니다." 라는
// 메시지가 출력되면서 프로그램이 종료되게 코드를 작성하시오.

// 6시까지
import java.util.Scanner;

public class Ex13BmiChecker2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 키 최대값
        final double HEIGHT_MAX = 2.72;
        // 몸무게 최대값
        final double WEIGHT_MAX = 650;
        // 저체중 <-> 정상체중 기준
        final double BMI_STANDARD1 = 18.5;
        // 정상체중 <-> 과체중 기준
        final double BMI_STANDARD2 = 23;
        // 과체중 <-> 비만 기준
        final double BMI_STANDARD3 = 25;

        // 키를 입력 받는다.
        System.out.println("키를 m 단위로 입력해주세요.");
        System.out.print("> ");
        double height = scanner.nextDouble();

        if (height > 0 && height <= HEIGHT_MAX) {
            // 키가 올바른 값이므로 몸무게 입력을 받는다.
            System.out.println("몸무게를 kg 단위로 입력해주세요.");
            System.out.print("> ");
            double weight = scanner.nextDouble();

            if (weight > 0 && weight <= WEIGHT_MAX) {
                // 몸무게 올바른 값이므로 이름 입력 -> BMI 계산 -> 비만도 결정 -> 결과 출력을 실행한다.

                // 이름을 입력 받는다.
                System.out.println("이름을 입력해주세요.");
                System.out.print("> ");
                scanner.nextLine();
                String name = scanner.nextLine();

                // BMI를 계산한다.
                double bmi = weight / height / height;

                // 비만도를 결정한다.
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

            } else {
                // 올바르지 않은 몸무게이므로 경고 메시지만 출력한다.
                System.out.println("잘못된 입력을 감지하여 프로그램을 종료합니다.");
            }

        } else {
            // 올바르지 않은 키이므로 경고 메시지만 출력한다.
            System.out.println("잘못된 입력을 감지하여 프로그램을 종료합니다.");
        }

        scanner.close();
    }
}
