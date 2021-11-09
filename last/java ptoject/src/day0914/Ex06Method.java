package day0914;
// 메소드

// 메소드란 여러줄의 코드를 합쳐서
// 하나의 기능으로 만들어놓은것을 메소드라고한다

// 예를들어, 우리가 scanner클래스 변수의
// nextInt() 라는 메소드를 실행했을때,
// 우리가 적은 것은 한줄에불과하지만, (scanner.nextInt())
// 실제로는, 해당 메소드 안에 적혀있는 모든 코드들이 차례대로 실행이 되는 구조이다.
// 즉 하나의 단축어라고도 할 수 있게 되는 것이다.

// 예를 들어서
// 우리가 "라면끓여와 "라는 메소드를 실행하게된다면
// 실제로는
// 1.라면을 준비한다
// 2.냄비를 준비함다
// 3.냄비에 물을 넣는다
// 4.냄비를 가스렌지 위에 올린다
// 5.라면봉지를 연다
// 6.물이  끓으면 라면 봉지에 내용물을 냄비에 넣는다
// 7.면이 익으면 그릇에 붓는다

// 메소드의 경우, 메소드는 반드시 선언과

// 메소드의 선언은 다음과 같이 이루어진다.
// 접근제한자(static) 리턴타입 메소드이름(파라미터)

// 접근제한자: 해당 메소드를 외부 클래스가 접근할때
//          어디에 있는 외부 클래스가 가능한지 설정하는 키워드
//          access Modifier라고 한다
//          접근제한자는 public, protected, package, private 4종류가 있다.
//          public :  다른 패키지에 있는 다른 클래스도 실행 가능
//          protected: 같은 패키지에 있는 다른 클래스는 실행 가능
//                     다른 패키지에 있는 클래스의 경우는 상속관계일때만 실행 가능
//          package: 같은 패키지에 있는 다른 클래스들만 실행 가능
//                   단, 패키지 접근 제한자는 우리가 아무런 접근제한자를 적어주지 않을때만 적용된다.
//          private: 다른 패키지는 어디에 있던간에 실행할 수 없다.
//                   즉, 해당 클래스만 실행 가능하다.

// static: static키워드는 헤당 메소드를 클래스 변수로 선언하지 않고 사용할 수 있게 한다
//         예를 들어서, 만약 우리가 기존에 사용하던 Scanner클래스의 nextInt()메소드에
//         static키워드가 붙어있다면, Scanner scanner = new scanner(System.in) -> scanner.nextInt()로 사용하는 것이 아니라
//         Scanner.nextInt()의 방식으로 사용하게 되는 것이다.
//         static키워드는 우리가 생략할 수 있지만 만약 static메소드가 다른 메소드를 곧장 호출할 때에는 그 다른메소드에도 static이 반드시
//         붙어야 한다.

// 리턴타입: 리턴타입이란, 해당 메소드가 종료될 때 호출된 곳으로 보내줄 값의 데이터타입을 말한다.
//         예를 들어서, 스캐너 클래스의nextInt() 메소드는 리턴 타입이 int라고 적혀있고, 내부적으로 코드를 모두 다 실행시킨 후에는
//         int타입의 값을 호출한 곳으로 보내주는 형태가 된다.
//         리턴타입이 존재할 시에는 해당 메소드의 내부에서 반드시 return이라는 키워드를 통해서 해당 데이터타입과 일치하는 값을
//         "리턴"해주어야 한다
//         만약 해당 메소드가 아무런 값도 리턴하지 않을 때에는 리턴 타입에 void라고 적어야하며 이 때에는 오히려
//         return 값을 적으면 에러가 발생한다.

// 메소드이름: 소문자로 시작하고 낙타등 표기법을 이용한다.

public class Ex06Method {
    public static void main(String[] args) {

//        //밑으로 보내준다
//        //1
//        String name = "정지원";
//        printName(name);
//        //2
//        printName("홍길동");
//        //3
//        String str = "이재영";
//        printName(str);
//        
        int num = selectNum();
        /*
         * * int num; stem.out.println("selectNum()실행"); System.out.println("이런저런코드실행");
         * System.out.println("최종 결과값 5를 호출된 곳으로 보내준다");
         * 
         * num = 5; *
         */

        System.out.println("num의 현재값:" + num);

    }

    public static void printNum() {
        System.out.println(1);
        System.out.println(2);
        System.out.println(3);
        System.out.println(4);
        System.out.println(5);
        System.out.println(6);

    }

    public static void printName(String name)// String파라미터때문에 뭘 넣던 String name으로 취급하겠다라는말 /해당변수로 초기화시킴

    {
        System.out.println(name + "1");
        System.out.println(name + "2");
        System.out.println(name + "3");
        System.out.println(name + "4");
        System.out.println(name + "5");
        System.out.println(name + "6");

    }

    // 여기서 메소드는 반드시int데이터아빙르 리ㅣ턴헤야힘
    // 그렇지않으려면 위에int num은 오류가 발생하게된
    public static int selectNum() {
        System.out.println("selectNum()실행");
        System.out.println("이런저런코드실행");
        System.out.println("최종 결과값 5를 호출된 곳으로 보내준다");
        // 여기에 int값을 리턴해주고있지 않으서 위에selectnum()에 빨간줄 오류가 나고있다
        return (5);
    }
}
