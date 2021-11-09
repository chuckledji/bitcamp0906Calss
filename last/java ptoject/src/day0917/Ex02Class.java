package day0917;
// 클래스
// 우리가 기존에는 정보를 입력하는 공간과 기능을 분리해서 만들어놓았다
// 예를 들어서, 학생의 정보는 우리가 최종적으로 구조체라는 것을 사용하여
// 학생의 정보를 넣을 데이터타입을 규정을하고
// 기능은 따로 만들었었다
// 이러한 방법은 2세대 언어에서 사용이 된 방법인데, 왜냐하면 2세대 언어에서는
// 프로그램을 "기능의 집합"으로 보았기 때문이다
// 그래서 우리가 최종적으론 구조체 배열과 메인 메소드를 제외한 다른 메소드를 만들어서
// 따로따로 사용을 했던 것이다

// 하지만 왜 학생의 정보를 넣을 공간과 기능을 분리해야하는가?

// 3세대 언어에서는 만약 학생을 관리하는 프로그램을 만든다고 할 시에는
// 학생의 정보를 저장할 공간 + 그 정보를 사용하는 기능을 합쳐서 하나의 프로그램으로 만들고
// 우리가 실행할 프로그램에서는 그 학생 프로그램을 하나의 변수처럼 다루자가 주된 목표가 된다

// 즉, 구조체와 기능이 합쳐져서 하나의 온전한 클래스가 만들어지고
// 우리가 필요하면 그 클래스의 변수를 우리 프로그램에서 활용하자라는 것이 목표가 된다
// 즉, 3세대 언어, 객체지향언어에서는
// 프로그램을 더 작은 프로그램들의 집합으로 보게되는것이다

// 객체란 무엇인가?
// 객체란 클래스 변수를 객체라고한다

// 클래스의 구성
// 클래스는 필드와 메소드로 이루어져있다
// 필드 : 해당 클래스 변수가 가지고 있을 데이터들의 종류
// 메소드 : 해당 클래스 변수들이 실행 가능한 기능들

// static 키워드
// static키워드는 해당 메소드 혹은 필드를 클래스변수(객체)선언없이 사용하게 만든다
//  객체지향 프로그럄애서는, 객체 즉 클래스 변수를 만들어서 우리가 활용하는게 지향점이다
// 즉, static키워드가 사용되는 순간, 우리가 객체 지향 프로그램이 아니라
// 2세대 언어, 즉 절차지향적 프로그래밍을 하게 되는 것이다
// 따라서 우리는 static키워드의 사용을 최소한으로 해야한다

//최동적으론, ScannerUtil과 main메소드를 제외한 그 어디에소 static키워드는 전재하진않아햐한다
//최종적으론, 객체선언없이사용되는 소수의 메소드 필드를 제외하고서는 
//그 어디에도 static키워드는 존재하지 않아야한다

//생성자(Constructor)
//생성자란 특수한 메소드로서, 해당 클래스의 변수가 초기화될때
//호출되는 메소드이다
//만약 우리가 해당 클래스 변수를 초기화할때 해주어야 할 작업(=실행할 코드)가 존재할 시에는
//생성자를 사용하면 된다.

// 만약 우리가 생성자를 따로 만들지 않을 경우에는
// 자바가 제공하는 기본생성자를 사용하게 되는데
// 이 기본 생성자는 해당 객체의 필드값을 기본형데이터타입이면 0
// 참조형 데이터타입이면 null로 초기화한다.

//우리가 직접 생성자를 만들어 줄 때는 다음과 같이 만들어주면 된다
// public 클래스이름() {
// 초기화시 실행할 코드
// }
//위에 리턴타입이없다. 객체의 초기화만 담당하고 어디론가 호출되는 것이 아느몰 리턴타입이 없다

//생성자를 우리가 만들어주면, 더이상 자바가 제공해주는 기본 생성자는 사용할 수 없다.

//또한, 우리가 생성자에 파라미터를 넣어줄 수도 있는데,
//주의할 점은 만약 파라미터가 있는 생성자만 만들어주면
//더이상 파라미터 없는 생성자는 사용할 수 없다(예시 : Scanner객체)

//this
//this 키워드는 해당 메소드를 실행시키는 객체 자신을 가리키는 대명사와 같은 키워드이다.
//이 this라는 키워드는 우리가 클래스 내부에서 메소드를 만들어줄때 자주 사용이 되는데
//왜냐하면 메소드 안에서 파라미터 혹은 변수가 필드와 같은 이름일 경우
//우라가 해당 이름을 호출하면 무조건 파라미터/변수가 호출되기 때문이다



import classEx.Student;
public class Ex02Class {
    public static void main(String[] args) {
        // Student클래스의 객체를 만들어보자
        Student s1 = new Student();
        
        s1.printInfo();
        
        s1 = new Student(4,"ddd", 44, 44, 45);
        
        s1.printInfo(); // 이름만참조형데이터타입이라 null로 나온다
        
        
        //Student 객체 s1에 값을 입력해보자
        //이때에는 "해당 객체의"내부 필드 혹은 메소드를 접속할때 사용하는
        //접속연산자.을 사용하면된다
        s1.id = 1;
        s1.name = "정지원";
        s1.korean = 80;
        s1.math = 80;
        s1.english = 80;
        
        //s1의 내부 정보를 출력해보자
        //기존에는 우리가 이 메인 메소드가 있는 클래스에 
        //따로 static메소드를 만들어주거나
        // 아니면 모든 코드를 직접 적어주었지만
        //이제는 해당 클래스 안에 정의되어있는
        //매ㅔ소드를 객체가 되면 실행시키면 된다
        s1.printInfo();
        
        //또다른 Student객체를 만들어서 정보를 입력해보자
        Student s2 = new Student();
        s2.id = 2;
        s2.name = "정지원";
        s2.english = 80;
        s2.korean = 80;
        s2.math = 80;
        
        //s2의 printInfo()를 실행시켜봊자
        s2.printInfo();
        
        // equals()비교하기
        // equals()의 경우, 우리가 클래스 안에
        // 새로 만들어주지않으면
        // 부정확한 값이 나온다
        // 이유는 나중에
        
        System.out.println("-----------------------------------\n");
        s1 = new Student(4, "ddd", 44, 44, 45);
        s2 = new Student(4, "ddd", 44, 44, 45);
        s1.printInfo();
        s2.printInfo();
        
        System.out.println("s1.equals(s2): " + s1.equals(s2));
        //false가 나오다가object o 처리해주니까 true로 나온다
        
    }

    
}
