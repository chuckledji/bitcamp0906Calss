package chapter12.circle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectSerializable {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("Object.ser"));
		
		//복원 : 인스턴스 생성하고 반환
		Circle c1 = (Circle) in.readObject();		//오브젝트타입 반환
		Circle c2 = (Circle) in.readObject();
		
		String str = (String) in.readObject();		//저장한 순서대로 출력한다.
		in.close();
		
		c1.showCircleInfo();
		c2.showCircleInfo();
		System.out.println(str);
		
	}
}
