package day0909;

import java.util.Scanner;

public class Ex09BmiChecker2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 상수
        // 최대 키
        final double MAX_HEIGHT = 2.72;
        // 최대 몸무게
        final double MAX_WEIGHT = 650;
        // Bmi 기준
        final double BMI_STANDARD1 = 18.5;
        final double BMI_STANDARD2 = 23;
        final double BMI_STANDARD3 = 24;

        // 변수
        double height = 0;
        double weight = 0;
        String name = "";

        while (true) {
            System.out.println("1.입력 2.출력 3.종료");
            System.out.println("> ");
            int useChoice = scanner.nextInt();

            // 1.입력 선택
            if (useChoice == 1) {

                // 이름입력
                System.out.println("이름을 입력해주세요");
                System.out.println("> ");
                scanner.nextLine();
                name = scanner.nextLine();

                // 키입력
                System.out.println("키를 입력해주세요");
                System.out.println("> ");
                height = scanner.nextInt();

                while (height < 0 || height > MAX_HEIGHT) {
                    System.out.println("키를 다시입력해주세요");
                    System.out.println("> ");
                    height = scanner.nextInt();
                }

                // 몸무게입력
                System.out.println("몸무게를 입력해주세요");
                System.out.println("> ");
                weight = scanner.nextInt();

                while (weight < 0 || height > MAX_WEIGHT) {
                    System.out.println("몸무게를 다시입력해주세요");
                    System.out.println("> ");
                    weight = scanner.nextInt();
                }

            }
            // 2.출력 선택
            else if (useChoice == 2) {
                
                // 사용자가 입력을 했는지 안했는지 확인하기 위해서
                // height의 값이 0과 같은지 확인한다.
                // 만약 0과 같다는 것은 입력 코드가 실행된 적 없다 라는 의미이므로
                //"아직입력된 정보가 없습니다." 를 출력해주고
                //그외의 경우에는 정보를 출력하는 코드를 차례대로 실행시킨다.
                                
                if(heihgt == 0) {
                    System.out.println("아직은 입력된 정보가 없습니다.");
                }else {
                    // BMI계산
                    double bmi = weight / height / height;

                    // 비만도 값 결정
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
                    System.out.printf("이름: [%s] 키: %2f M 몸무게: %2f kg\n", name, height, weight);
                    System.out.printf("BMI: %.3f 비만도: %s\n", bmi, result);
                }
                }
                
               
            // 3.종료 선택
            else if (useChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }

        scanner.close();
    }
}