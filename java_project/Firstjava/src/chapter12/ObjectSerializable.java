package chapter12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;



public class ObjectSerializable {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		//인스턴스저장을 위한 스트림
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Object.ser"));
		
		//인스턴스 실제로 저장1
		out.writeObject(new Circle(1, 1, 2.4)); 	//시리얼라이저블 마킹되어있는 클래스만 가능
		out.writeObject(new Circle(2, 2, 6.5));
		out.writeObject(new String("문자열"));		//String도 시리얼라이저블 가능하므로 직렬화의 대상이 될 수 있다.
		//저장2
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("one");
		arr.add("two");
		arr.add("three");
		out.writeObject(arr);
		
		out.close();
		
		//저장된 파일을 이용해서 인스턴스를 생성 : 복원
		//복원시키는 저장 순서대로 복원해주어야한다.
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("Object.ser"));
		
		//복원 : 인스턴스 생성하고 반환
		Circle c1 = (Circle) in.readObject();		//오브젝트타입 반환
		Circle c2 = (Circle) in.readObject();
		String str = (String) in.readObject();		//저장한 순서대로 출력한다.
		//복원2
		ArrayList<String> arr1 = (ArrayList) in.readObject();
		for(String s : arr1) {
			System.out.println(s);
		}
		
		in.close();
		
		c1.showCircleInfo();
		c2.showCircleInfo();
		System.out.println(str);
		
	}
}
