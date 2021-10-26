package chapter12.circle;

import java.io.Serializable;

//Serializable 인터페이스 구현은 -> 직렬화의 대상이란 뜻 -> 객체를 저장하기 위해 쓰는 것 -> 인스턴스변수들을 저장한다.
public class Circle implements Serializable{
	
	int xPos;
	int yPos;
	double rad;
	
	public Circle(int xPos, int yPos, double rad) {
		
		this.xPos = xPos;
		this.yPos = yPos;
		this.rad = rad;
	}
	
	public void showCircleInfo() {
		System.out.printf("[%d, 5d]\n", xPos, yPos);
		System.out.println("rad: " + rad);
	}
	
}
