package chapter7_day1018.product;

public class Buyer {
	//변수
	int money;
	int bonusPoint;
	
	//제품 구매와 함께 카트(구매내역)를 정의
	//배열- buy메소드를 통해서 전달받는 product 타입의 인스턴스(구매한 제품)를 저장
	Product[] cart; //구매한 제품들을 넣을 수 있는 배열
	int cnt;		//카트에 추가된 개수(numOfStudent와 같은역할)
	
	//생성자
	Buyer(){
		money =1000;//매개변수 받아서 사용하는 메소드가 아니기 때문에 this없이 작성
		bonusPoint =0;
		cart = new Product[10];
		cnt = 0;
	}
	
	//메소드
	//제품구매
	//public void buy(Computer com) {}
	//public void buy(Tv tv) {}
	//public void buy(Audio audio) {}
	//다형성을 이용하지 않으면 계속 오버로딩해서 작성해야하는 것.
	
	//다형성을 이용해서 메소드를 하나만 정의
	public void buy(Product p) {
		//Product p1 = new Computer(100);
		//Product p2 = new Tv(90);
		//Product p3 = new Audio(80);
		
		
		if(money<p.price) {
			System.out.println("보유한 돈이 부족하므로 제품을 구매하실 수 없습니다.");
			return;//종료
		}
		money -= p.price;
		bonusPoint += p.bonusPoint;
		//System.out.println(p+"을/를 구매하셨습니다.");//println(p)하면 toString반환
		
		//cart에 제품 추가
		cart[cnt++] =  p;
	}
	public void summary() {
		//총 구매액
		int sum =0;
		
		//구매내역(제품의 리스트)
		String itemList="";
		
		//배열을 이용하면 -> 반복문
		for(int i =0; i<cnt; i++){
			//합을 구하기
			//sum = sum + cart[i]
			sum+= cart[i].price;
			itemList += cart[i] + ",";
			
		
	}
	System.out.println("구매하신 제품은"+itemList+"입니다.");
	System.out.println("구매한 제품들의 총 구매액은 "+sum+"원입니다.");
}
}