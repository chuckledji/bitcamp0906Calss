package day0907;
// 여러분들이 직접 알맞은 변수를 선언하고 값을 초기화해서

// 다음과 같은 결과가 출력되도록 코드를 작성하시오

// 이름: [###] 나이: [0##]세
// 학년: #학년 반: #반
// 국어: [0##]점 영어: [0##]점 수학: [0##]점
// 총점: [0##]점 평균: [0##.##]점
// 4시 10분까지
public class Ex05GradeBook {
    public static void main(String[] args) {
        // 이름을 담당할 String 변수 name의 선언과 초기화
        String name = "조재영";
        // 나이를 담당할 int 변수 age의 선언과 초기화
        int age = 12;
        // 학년을 담당할 int 변수 grade의 선언과 초기화
        int grade = 5;
        // 반을 담당할 int 변수 studentClass의 선언과 초기화
        int studentClass = 2;
        // 국어 점수를 담당할 int 변수 korean의 선언과 초기화
        int korean = 80;
        // 영어 점수를 담당할 int 변수 english의 선언과 초기화
        int english = 81;
        // 수학 점수를 담당할 int 변수 math의 선언과 초기화
        int math = 78;
        // 총점을 담당할 int 변수 sum의 선언과 초기화
        int sum = korean + english + math;
        // 평균을 담당할 double 변수 average의 선언과 초기화
        double average = sum / 3.0;

        // 이름과 나이를 출력하는 코드
        System.out.printf("이름: [%s] 나이 : [%03d]세\n", name, age);
        // 학년과 반을 출력하는 코드
        System.out.printf("학년: %d학년 반: %d반\n", grade, studentClass);
        // 국어, 영어, 수학점수를 출력하는 코드
        System.out.printf("국어: [%03d]점 영어: [%03d]점 수학: [%03d]점\n", korean, english, math);
        // 총점과 평균을 출력하는 코드
        System.out.printf("총점: [%03d]점 평균: [%06.2f]점\n", sum, average);
    }
}
