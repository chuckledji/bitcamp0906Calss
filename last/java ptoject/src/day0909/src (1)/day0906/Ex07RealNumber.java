package day0906;
// 기본형 데이터타입 02
// 실수형 기본데이터타입

// 실수란, 소수점 이하의 숫자가 존재하는 숫자를 우리가 실수라고 한다.
// 자바에서는 double과 float 두가지 종류의 데이터타입이 있는데
// 기본적으로 코드에 적힌 실수를 자바는 double로 인식한다.


public class Ex07RealNumber {
    public static void main(String[] args) {
        // double 데이터타입의 변수 myDouble을 선언하고 3.14로 초기화해보자
        double myDouble = 3.14;
        // 화면에 myDouble의 현재값을 출력해보자
        System.out.println(myDouble);
        
        // float 데이터타입의 변수 myFloat을 선언하고 3.14로 초기화해보자
        // float myFloat = 3.14;
        // 위 코드는 에러가 발생하는데 우리가 보기에 3.14는 적은 자릿수의 실수이지만
        // 실제론 컴퓨터 내부상에서는 3.14000000000000.... 으로 인식하기 때문에
        // float에 값을 전부 집어넣지 못하는 상황이 발생하는 것이다.
        // 따라서 우리가 float 데이터타입의 공간에 값을 저장할 때에는
        // 명확하게 해당 값이 float자릿수만큼 지정된 실수이다 라는 것을 컴퓨터한테 명시해야한다.
        // 그 때에는 값 뒤에 f 라고 붙여주면 된다.
        float myFloat = 3.14f;
        
        // 화면에 myFloat에 현재값을 출력해보자
        System.out.println(myFloat);
        
        // 만약 정수 값을 실수로 바꾼다면 어떻게 하면 될까?
        // 4를 실수로 바꾸면? 4.0
        // 5를 실수로 바꾸면? 5.0
        
        // 즉 정수를 실수로 바꿀 때에는
        // 데이터 손실이 발생하지 않는다.
        // 데이터 손실이 발생하지 않을때에는
        // 추가적인 코드를 적어주지 않더라도 
        // 자동적으로 데이터타입이 바뀌게 된다.
        
        // myDouble에 6을 저장해보자
        myDouble = 6;
        
        // 화면에 myDouble에 현재 저장된 값을 출력해보자
        System.out.println(myDouble);
    }
}


















