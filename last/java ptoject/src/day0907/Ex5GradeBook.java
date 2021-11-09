package day0907;
// 알맞은 변수를 선언하고 값을 초기화하여 다음과 같은 결과가 출력되도록 코드를 작성하시오

// 이름: [###] 나이: [0##]세
// 학년: #학년 반: #반
// 국어: [0##]점 영어: [0##]점 수학: [0##]점
// 총점: [0##]점 영어평균: [0##.##]점
public class Ex5GradeBook {
    public static void main(String[] args) {

        // String str = "정지원";
        // System.out.print("이름: [" + str + "]");

        // int number = 27;
        // System.out.printf("나이: [%0d]\n", number);

        // ---------------------------------

        // 이름을 담당할 String 변수 name의 선언과 초기화
        String name = "정지원";
        // 나이를 담당할 int변수 age의 선언과 초기화
        int age = 12;
        // 학년을 담당할 int변수 grade의 선언과 초기화
        int grade = 3;
        // 반을 담당할 int변수 studentClass의 선언과 초기화
        int studentClass = 2;
        // 국어점수를 담당할 int변수 korean의 선언과 초기화
        int korean = 90;
        // 영어점수를 담당할 int변수 english의 선언과 초기화
        int english = 90;
        // 수학점수를 담당할 int변수 math의 선언과 초기화
        int math = 90;
        // 총점수를 담당할 int변수 sum의 선언과 초기화
        int sum = korean + english + math;
        // 평균을 담당할 double 변수 average의 선언과 초기화
        double average = (double) sum / 3; // 몫만 나올 수 있으므로 (double)

        // 이름과 나이를 출력하는 코드
        System.out.printf("이름: [%s] 나이: [%03d]세\n", name, age);
        // 학년과 반을 출력하는 코드
        System.out.printf("학년: %d학년 반: %d반\n", grade, studentClass);
        // 국어, 영어, 수학 점수 출력하는 코드
        System.out.printf("국어: [%03d]점 영어: [%03d]점 수학: [%03d]점\n", korean, english, math);
        // 총점과 평균을 출력하는 코드
        System.out.printf("총점: [%03d]점 평균: [%06.2f]점\n", sum, average);
    }

}
