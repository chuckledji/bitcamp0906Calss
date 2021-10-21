package chapter11;

import java.util.Iterator;
import java.util.LinkedList;
public class IteratorTest {

	public static void main(String[] args) {
		
		LinkedList<String> list = new LinkedList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		
		Iterator<String> itr = list.iterator();
		
		while(itr.hasNext()) {
			String str = itr.next();
			System.out.println(str);
			if(str.compareTo("3") == 0) {
				itr.remove();
			}
		}System.out.println("--------3제거 후 리스트------");
		
		itr = list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
