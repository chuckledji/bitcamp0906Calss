package day0913;
// switch 조건문
// switch 조건문의 경우, if 조건문과는 다르게
// 변수를 하나 선택하여
// 그 변수의 값에 대한 코드 처리를 하게 된다
// 또한, 명확하게 값이 나뉘는 변수에 대해서만 switch 조건문을 만들어줄 수 있기 때문에
// 정수형,  문자형 변수 혹은 연산의 결과값에 대해서만 switch조건문을 만들 수 있다.

// switch 조건문의 구조는 이렇다.

public class Ex01Switch {
    public static void main(String[] args) {
        int num = 4;
        
        switch (num % 3) { //실수형은 사용할 수 없다.
        case 1:
            System.out.println("1입니다");
            break;
        case 2:
            System.out.println("2입니다");
            break;
        case 3:
            System.out.println("3입니다");
            break;
        default: //else와 같음
            System.out.println("그외입니다");
            break;//break가 나올때까지 모든 코드를 실행한다.
            
        }
    }
}
