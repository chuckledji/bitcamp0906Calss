package chapter7_day1018.product;

public class ProductMain1 {
public static void main(String[] args) {
	//1.재품 객체들을 생성	
	Product p1 = new Computer (100);
	Product p2 = new Tv (40);
	Product p3 = new  Audio(20);
	
	//2.Buyer객체를 생성
	Buyer buyer = new Buyer();
	
	//3.구매 처리를 테스트
	buyer.buy(p1); //Computer 구매
	buyer.buy(p2); //Tv 구매
	buyer.buy(p3); //Audio 구매
	
	System.out.println("현재 보유한 돈은 "+ buyer.money+"원입니다.");
	System.out.println("현재 보너스 포인트는 "+ buyer.bonusPoint+"원입니다.");
	
	System.out.println("---------------------------");
	buyer.summary();
}
}
