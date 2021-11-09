package main;

import viewer.StudentViewer;

public class StudentMain {
public static void main(String[] args) {
StudentViewer viewer = new StudentViewer(); //StudentViewer클래스에 객체viewer를 선언하고 초기화한다.
viewer.showMenu();//viewer객체에서showMenu메소드를 실항한다.
}
}