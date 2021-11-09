package classEx;
// 학생의 정보를 저장하고 관리한 Student클래스

public class Student2 {
    // 필드
    private int id;
    private String name;
    private int korean;
    private int english;
    private int math;
    private final int SUBJECT_SIZE = 3;
    // 이건 외부에서 알 필요가 없고 이미 3이라는 숫자도있어서 외부에서 값을 넘어와서 초기화할 일이 없으니까 gettersetter가 필요없다

    // 필드에 대한 getter setter 메소드
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setKorean(int korean) {
        this.korean = korean;
    }

    public int getKorean() {
        return korean;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getEnglish() {
        return english;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getMath() {
        return math;
    }

    // 메소드
    public boolean equals(Object o) {
        if (o instanceof Student2) {
            Student2 s = (Student2) o;
            if (id == s.id) {
                return true;
            }
        }
        return false;
    }

    // 1. 학생의 총점을 계산하는 calculateSum() // 외부에서 쓸 일 없으므로 private
    private int calculateSum() {
        return korean + english + math;
    }

    // 2.학생의 평균을 계산하는 calculateAverage() //외부에서 쓸 일 없으므로 private
    private double calculateAverage() {
        return (double) calculateSum() / SUBJECT_SIZE;
    }

    // 3. 학생의 정보를 출력하는 printInfo()
    public void printInfo() {
        System.out.printf("번호: %d번 이름: %s\n", id, name);
        System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", korean, english, math);
        System.out.printf("총점: %03d점 평균: %06.2f점\n", calculateSum(), calculateAverage());

    }
}
