package classEx;
// 학생의 정보를 저장하고 관리한 Student클래스

public class Student {
    //필드
    public int id;
    public String name;
    public int korean;
    public int english;
    public int math;
    public final int SUBJECT_SIZE = 3;
    
    //메소드
    //1. 학생의 총점을 계산하는 calculateSum()
    public int calculateSum() { //파라미터가 필요없다? 왜지 2시34분거수업다시듣기
        return korean + english + math;
    }
    //2.학생의 평균을 계산하는 calculateAverage()
    public double calculateAverage() {
        return (double)calculateSum() / SUBJECT_SIZE;
    }
    //3. 학생의 정보를 출력하는 printInfo()
    public void printInfo() {
        System.out.printf("번호: %d번 이름: %s\n", id, name);
        System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", korean, english, math);
        System.out.printf("총점: %03d점 평균: %06.2f점\n", calculateSum(), calculateAverage());
        //이전에는 sum average따로 계산해서 했지만 이제는 메소드가 존재하니 그것을 사용한다
        
    }
    //4. 파라미터 있는 생성자
    public Student(int id, String name, int korean, int math, int english) { 
        //  id = id;
        //  위의 id = id를 풀어서 쓰면?
        // 파라미터로 들어온 int변수 id에 파라미터로 들어온 int변수 id의 현재 값을 저장해라
        
        // 만약 파라미터와 필드의 이름이 같을 경우에는
        // 필드를 저장할 때 앞에 this. 을뭍여서
        //"이 메소드를 실행싴티는 객체자신"이란 것을 명시해준다
        this.id = id;
        //위의 this.id = id;는
        //이 Student(int, Sting, int, int,int)메소드르 실행시키는
        //객체의 필드id에 파라미터로 들어온 int id의 현재값을 저장해라 라는 의미가된다
        
       
        this.name = name;
        this.english = english;
        this.math = math;
        this.korean = korean;
        
        //d위에 파라미터에 int id, String name, int korean, int math, int english를 넣으면
        //Student s2 = new Student();에 빨간줄이 뜬다. 
        //넣는다는 건 특정한 값으로 초기화하려고 한다는 것 
    }
       
    //5. 파라미터 없는 생성자
    public Student() {
      //Student s2 = new Student();에 빨간줄이 없어진다(파라미터있는 생성자만 있을 때)
        
        id = -1;
        name = "아직없음";
        korean = -1;
        english = -1;
        math = -1;
                
//      System.out.println("생성자호출");
//      id = -1;
//      name = "아직없음";
//      korean = -1;
//      english = -1;
//      math = -1;
//      System.out.println("생성자종료"); 
    }
        //6. equals()
        // 단, equals() 메소드의 파라미터는 어떤 클래스던 간에
        // 반드시 Object 타입의 변수로 해야한다
        public boolean equals(Object o) {
            //퍼블릭불리안이퀄즈는오브젝트는 항상 동일

            //1. 파라미터로 들어온 Object o가
            //   Student클래스의 객체가 맞는지 확인
            //2. 명시적 형변환을 통해 o의 값을 Student클래스객체로
            //   임시로 바꿔준다
            //3. 이 메소드를 실행하는 객체의 id와 위의 2번에서 생성된 임시객체의 id가
            //   같으면 true를 리턴한다
        if(o instanceof Student) {
            Student s = (Student)o;
            if(id == s.id) {
                return true;
            }
        }
        return false;   
    }
        public String toString() {
            return"학생정보:" + id + ", 학생이름: " + name + ", 국어점수: " + korean + ", 수학점수: " + math + ", 영어점수: " + english;
        }
}
