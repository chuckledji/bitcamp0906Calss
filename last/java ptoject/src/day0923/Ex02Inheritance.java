package day0923;

import classEx.Student;
import classEx.Animal;
import classEx.Monkey;
import classEx.Gorilla;

// 상속(inheritance)
// 상속이란, 부모클래스의 메소드 혹은 필드를 자식클래스가
// 또 적어주지 않더라도 그대로 받아서 쓸 수 있게 만들어 주는 것을 
// 상속이라고한다

// 상속은 사실 클래스상속과 인터페이스상속으로 나뉘는데
// 클래스 상속의 목적은 코드의 재사용성을 높이기 위함이고
// 인터페이스 상속의 목적은 다형성(Polymorphism)을 위함이다.

// 상속을 하는 방법:
// public class 자식클래스 extends 부모클래스{
//
// }

// 자식클래스의 객체를 초기화할때는
// 부모클래스의 생성자가 먼저 호출되고 그 다음애 자식클래스의 생성자가 호출이된다

// 오버라이드(Override)
// 오버라이드란 부모클래스로부터 상속받은 메소드가
// 자식클래스가 사용하기 부적절한경우,
// 자식클래스에서 재정의를 하여, 자식클래스가 적절하게 사용할 수 있도록
// 상속받은 메소드를 "덮어씌우는것"을 오버라이드라고한다.
// 단, 오버라이드를 할 시에 주의할 점은
// 부모클래스가 선언한대로 똑같이 선언해주어야 한다는 것이다.

// java.lang.Object
// Object란? 객체를 뜻한다(Object Oriented Programming ->객체지향프로그래밍)
// 자바의 모든 클래스는java.lang.Object를 직접적으로나 간접적으로상속을 받는다
// 이 java.lang.Object는 말그대로 클래스들의 원본이라고 할 수 있는데
// 이 Object라는 클래스 안에는
// 객체를 사용하는데 필요한 몇가지 메소드들이 만들어져있다
// 대표적으로, 
// 기본형 데이터타입 필드는 0으로, 참조형 데이터타입필드는 null로 초기화해주는 기본생성자,
// 두 객체가 같은지 비교해주는 equals()메소드,
// 객체의 정보를 String으로 변환해주는 toString()메소드 등이 있따

// 하지만, java.lang.Object의 메소드들은
// 매우 두루뭉실하게 구현이 되어있다.
// 예를들어 equals()메소드 같은 경우에는
// 어떤 객체의 특정 필드 값을 비교하여 결과를 보여주는 것이 아니라
// 단순하게 주소값 비교를 하게 구현이 되어있다.
// toString()을 포함한 다른메소드들도 우리가 직접쓰기에는
// 불편하게 구현이되어있으므로
// 만약 equals()나 toString()과 같은 메소드를 우리 객체에 맞춰서 쓰려면
// 우리가 직접 오버라이드를 해야한다!

// 다형성(polymorphism)
// 다형성이란 "다양한 모습을 지닌 성격"을 다형성이라고한다
// 자바의 경우, 리턴타입, 생성자, 파라미터에 부모 클래스를 타입으로 적어주면
// 자식 클래스도 그 자리에 들어갈 수 있다.
// 단, 자식클래스의 자리에는 부모 클래스가 들어갈 수 없다!

public class Ex02Inheritance {
    public static void main(String[] args) {
        Monkey a = new Monkey(); 
        // Animal에서 몽키로 바꿈(classEx 몽키에 extends 붙이고 나서 바꿈)
        // 몽키는 부모클래스 Animal의 것을 접근제한자만 제대로 쓰면 다 쓸 수 있따
        
        a.setType("원숭이");
        a.makeSound();
        a.move();
        a.showInfo();
        
        Gorilla g = new Gorilla();
        g.setType("고릴라");
        g.makeSound();
        g.move();
        g.showInfo();
        
        Gorilla g2 = new Gorilla();
        
        System.out.println("g.equals(g2)" + g.equals(g2));
        String abc = new String("abc");
        System.out.println("g.equals(abc)" + g.equals(abc)); //세시사십분 설명다시듣기(다형성)
        
        Animal g3 = new Gorilla();
//      Gorilla g4  = new Animal(); //이건 안된다. 동물에는 고릴리말고 다른것도 있을 수 있으므로
        
        // 객체를 println()에 넣으면 어떻게 될까?
        // println()에 파라미터로 String클래스 아닌 객체가
        // 들어가게된다면
        // 그 클래스 객체의 toString() 메소드가 실행돼서 리턴된
        // String값이 화면에 출력이 된다
        
        // 만약 별다른 toString()오버라이드를 하지 않았을 경우
        // 패키지.객체 클래스 @ 힙메모리주소값 이 리턴돼서 출력된다.
        
        System.out.println(g);
        System.out.println(g3);
        
        Student s1 = new Student();
        s1.id = 1;
        s1.name = "정지원";
        s1.korean = 1;
        s1.english = 1;
        s1.math = 1;
        
        System.out.println(s1); 
    }
   
    

}
