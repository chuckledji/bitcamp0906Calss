package day0906;
// 연산자(Operator)

// 연산자란, 수학적 기호에 프로그래밍 기능을 정의해둔 것으로써,
// 우리가 알고 있던 수학적 기호와 의미가 같을 수도 있지만
// 의미가 다른 연산자들도 많이 있다.

// 연산자에는 산술, 할당, 비교, 논리, 비트 다섯가지 연산자의 종류가 있다.

// 산술연산자
// 산술연산자는 2개의 값에 대한 연산을 한다.
// 산술연산자에는 +, -, *, /, % 5가지 연산이 있다.
// +: 앞에 값과 뒤의 값을 더한 결과값을 연산한다.
// -: 앞에 값에서 뒤의 값을 뺀 결과값을 연산한다.
// *: 앞에 값과 뒤의 값을 곱한 결과값을 연산한다.
// /: 앞에 값에서 뒤의 값을 나눈 몫을 연산한다.
// %: 앞에 값에서 뒤의 값을 나눈 나머지를 연산한다.

// 만약 서로 다른 데이터타입의 값들을 산술연산할 경우, 
// 결과값의 데이터타입은 무조건 데이터손실이 발생하지 않는 데이터타입으로 맞춰진다.

public class Ex12Operator {
    public static void main(String[] args) {
        // int 끼리의 산술 연산
        System.out.println("int 끼리의 산술연산");
        // int 변수 num1과 num2를 선언하고 각각 3과 5로 초기화한다.
        int num1 = 3;
        int num2 = 5;

        System.out.println(num1 + num2);

        System.out.println(num1 - num2);

        System.out.println(num1 * num2);

        System.out.println(num1 / num2);

        System.out.println(num1 % num2);

        System.out.println("-----------------");
        System.out.println();

        // double 끼리의 산술연산
        System.out.println("double끼리의 산술연산");
        // double변수 myDouble1과 myDouble2를 선언하고 각각 3.0과 5.0으로 초기화한다.
        double myDouble1 = 3.0;
        double myDouble2 = 5.0;

        System.out.println(myDouble1 + myDouble2);

        System.out.println(myDouble1 - myDouble2);

        System.out.println(myDouble1 * myDouble2);

        System.out.println(myDouble1 / myDouble2);

        System.out.println(myDouble1 % myDouble2);

        System.out.println("-----------------");
        System.out.println();

        // 정수와 실수의 산술연산
        System.out.println("정수와 실수의 산술연산");

        System.out.println(num1 + myDouble2);
        System.out.println(num1 - myDouble2);
        System.out.println(num1 * myDouble2);
        System.out.println(num1 / myDouble2);
        System.out.println(num1 % myDouble2);

        System.out.println("-----------------");
        System.out.println();

        // 주의할 점: int 값 3개의 평균 내서 실수로 나타내고 싶을때에?

        // double 데이터타입 변수 result에 3, 4, 6의 평균을 저장해보자
        double result = (3 + 4 + 6) / 3;

        // result의 현재 값을 화면에 출력해보자
        System.out.println(result);

        // String 데이터타입의 + 연산
        // String 데이터타입의 값은 + 연산이 가능한데
        // 그 의미는 모두다 글자로 바꿔서
        // 한개의 커다란 String 값으로 이어붙여라 라는 의미가 된다!
        System.out.println("String의 경우");
        // 1. String 끼리의 + 연산
        // 이 때에는 앞의 String 값 뒤에 뒤의 String 값을 연결하라 라는 의미가 된다.

        System.out.println("abc" + "abc");

        // 2. 다른 데이터타입끼리의 + 연산
        // 이 때에는 다른 데이터타입을 String 값으로 바꾸고 앞과 뒤를 연결하라 라는 의미가 된다.

        System.out.println("12" + 345);
        // 위 코드는 10진법 12 와 345를 더하기 연산 하여 357 이라는 결과값을 화면에 출력하라 라는 의미가 아닌
        // 글자 "12" 뒤에 345를 글자로 바꾼 "345"를 이어붙여서
        // "12345"라는 글자를 화면에 출력하라는 의미가 된다.

        System.out.println(12 + "345");
        // 12라는 10진법 값을 String 값(=글자들) "12"로 바꾸고
        // 뒤에 "345"를 이어붙여서
        // "12345"라는 글자를 화면에 출력하라는 의미가 된다.

        System.out.println("------------------");
        System.out.println();
    }
}
