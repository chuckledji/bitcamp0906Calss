package day0914;
//메소드 오버로드

// 오버로드란, 똑같은 목적을 가지고 있을 경우,
// 메소드의 이름을 통일 시켜서 코드의 가독성을 높여주는 방법이다.
// 하지만 똑같은 이름의 메소드를 만들 때 주의할 점이 있는데,
// 반드시 파라미터의 내용이 달라야 한다는 것이다!

public class Ex08Overload {
    public static int add( int a, int b) {
        return a+b;
    }
    public static double add(double a, double b) {
        return a+b;
    }
    public static double add(int a, double b) {
        return a+b;
    }
    
//    public static double add(double b, double a) {
//        return b+ a; //에러가 날 수 있다. 
//    }
//    
    public static void main(String [] args) {
        System.out.println(add(3,4));//1번add가 ㅅㄹ행된다
        System.out.println(add(3.0, 4.0)); //2번 add가실행이된다 //통일은했지만 파라미터가 달라야한다
       
    }
}
//파라미터가 다르다는 건 무슨뜻일까?
