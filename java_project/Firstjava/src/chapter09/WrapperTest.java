package chapter09;

import java.util.ArrayList;
import java.util.List;

public class WrapperTest {

		public static void main(String[] args) {
			
			Integer iValue1 = new Integer(11); //래퍼클래스의 참조변수와 인스턴스
			Integer iValue2 = 11; //Autㅐ Boxing : 기본형 데이터를  자동으로 인스턴스로 만드는 것
			
			System.out.println(iValue1);
			System.out.println(iValue2);
			
			System.out.println("참조변수의 비교: "+(iValue1 == iValue2));
			System.out.println("iValue1.equals(iValue2): "+iValue1.equals(iValue2));
			
			int num = iValue1; //Auto UnBoxing : 래퍼클래스에서 인스턴스값을 꺼내는것
			int num2 = Integer.parseInt("11");
			
			//Collection 클래스들은 객체를 저장하는 목적으로 만든 클래스이다. List처럼
			List<Integer> list = new ArrayList<Integer>();
			list.add(11); //오토박싱해서 new Integer(11)로 들어감 (객체로 넣어야하지만 오토로 이렇게 가능)
		}
}
