package day0916;
// 구조체(Struct)
// 구조체란 여러가지 자료형을 조합해서
// 내가 필요한 나만의 자료형을 만드는 방법이다
// 단, 구조체는 2세대 언어의 개념으로 자바에서는 지원안함

import Struct.Student;

// 대신, 우리는 구조체 역할을 할 클래스를 만들어서
// 해당 클래스 변수를 사용하게 될 것이다!

public class Ex05Struct {
    public static void main(String []args) {
        //우리가 struct패키지에 만들어 놓은 Student 클래스는
        // 하나의 "데이터타입"이다
        // 우리가 스트링변수를 만들어서 값을 저장했듯
        // 우리가 필요할 때 Studnt 클래스 데이터타입을 가진 변수를 만들고
        // 그 안에 id, name, korean, math, english라는 공간에 딸 ㅗ값ㅇ르 집어넣게된다
        
        //Student 클래스 데이터타입을 가진 변수 s를 초기화해보자
        Student s = new Student();
        
        //우리가 s안에 번호, 이름, 국어,영어,수학 점수의 공간을 겁근할 때에는//변수이름 공간이름ㅇ로 접근하게된다
        s.id = 3;
        s.name = "wjdwldnjs";
        s.korean = 80;
        
        // 만약 우릭 ㅏ필요하다면 
        //또 다른 Student 클래스 변수를 만들어서 다른 값을 넣어줄 수도 있따
        Student s2 = new Student();
        s2.id = 4;
        //매열도 만ㄷ르어줄수있음
        Student[] arr = newStudent[3];
        arr[0].id = 40;
        arr[1].id = 50;
        
        
    }
    
}
