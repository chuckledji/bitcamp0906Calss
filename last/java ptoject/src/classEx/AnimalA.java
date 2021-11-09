package classEx;
//동물 추상 클래스

public abstract class AnimalA {
    //추상 메소드의 경우, 우리가 클래스와 메소드를 선언할때 abstract만 붙여주고
    //실제 코드 구현은 하지 않는다
    
    public abstract void makeSound();
    public abstract void move();   
    //추상메소드는 쉽게 표현하자면
    //"이 클래스를 상속받는 클래스는 반드시 해당 추상 메소드들을 재정의(오버라이드)하여 가지고있어야한다!"
    //라는 의미가된다.
    public void printInfo() {
    System.out.println("동물입니다");
    }
}
