package classEx;
//추상클래스 AnimalA를 상속받는 Dog클래스

public class Dog extends AnimalA{
    //추상클래스를 상속받는 클래스는
    //반드시 추상클래스 안의 추상메소드들을 오버라이드해주어야만한다
    public void makeSound() {
        System.out.println("멍멍");
    }
    public void move() {
        System.out.println("산책하러 네발로 달린다.");
        
    }
}
