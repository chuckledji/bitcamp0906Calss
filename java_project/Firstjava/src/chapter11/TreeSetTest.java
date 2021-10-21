package chapter11;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		
		TreeSet<Integer> set = new TreeSet<Integer>(); //제네릭타입 설정 후  생성
		set.add(4);
		set.add(1);
		set.add(2);
		set.add(5);
		set.add(3);
		set.add(1);
		
		System.out.println("요소의 개수 : "+ set.size()); 
		
		Iterator<Integer> itr = set.iterator();
		while(itr.hasNext()) {					//요소를 가지고 있는지
			System.out.println(itr.next());
		}
		
		
		
	}
}
