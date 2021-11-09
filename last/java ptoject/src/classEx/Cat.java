package classEx;
//추상클래스 AnimalA를 상속받는 Cat클래스

public class Cat extends AnimalA{
    public void makeSound() {
        System.out.println("야옹");
    }
    public void move() {
        System.out.println("잠만잔다.");        
    }
}
