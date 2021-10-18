package chapter7_day1018;
//(3)
public class HybridWaterCar extends HybridCar {
	//변수
	int waterGauge;
	//생성자
	HybridWaterCar(int gasolinegauge, int electronicGauge, int waterGauge) {
		super(gasolinegauge, electronicGauge);// 2.상위클래스의 생성자 호츌
		this.waterGauge = waterGauge;// 6. 변수의 초기화
	}
	//(4)메인메소드
	public static void main(String[] args) {
		HybridWaterCar hdCar = new HybridWaterCar(10, 20, 30); // 1.생성자호츌
		
		System.out.println(Car.door);
		System.out.println(HybridCar.door);
		System.out.println(HybridWaterCar.door);
		
	}
}

//(2)
class HybridCar extends Car {
	//변수
	int electronicGauge;

	// 상속관계에서 상위 클래스에 생성자가 존재하면 생성자 호출해 주어야한다.
	// 그리고 상위 클래스의 변수를 초기화해야 하기 때문에
	// 초기화할 값을 받아서 상위 클래스의 생성자를 호출한다!
	HybridCar(int gasolinegauge, int electronicGauge) {
		super(gasolinegauge);// 3.상위클래스의 생성자호출
		this.electronicGauge = electronicGauge;// 5.변수의초기화

	}

}

//(1)
class Car {
	
	static int door =5;//상위스태틱변수에 하위클래스도 이름만으로 접근이 가능하다
	
	//변수
	int gasolinegauge;

	// Car클래스의 변수를 초기화하는 생성자
	Car(int gasolinegauge) {
		this.gasolinegauge = gasolinegauge;// 4. 생성자 실행(오브젝트클래스를 상속하므로 super생략)
	}
}