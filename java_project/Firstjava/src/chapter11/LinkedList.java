package chapter11;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinkedList {
	public static void main(String[] args) {
		
		//ArrayList<Integer> list = null;
		LinkedList<Integer>list = new LinkedList<Integer>();
		
		
		//list = new ArrayList<Integer>();//위에 참조변수에서 타입을 설정해놓았으므로 생략해도 된다.
		//list = new ArrayList<>(); 			
		
		
		List<Integer>list2 = new ArrayList<Integer>();
		
		//데이터(인스턴스) 저장 : add(E e)
		list.add(new Integer(1));
		list.add(10); 		//10이 인스턴스로 들어가야해, 그래서 오토박싱 된 것. = new Integer(10);
		list.add(8);
		list.add(34);
		list.add(1); 		//중복가능
		
		//리스트의 요소의 개수
		int size = list.size();
		System.out.println("요소의 개수 "+ size);
		
		//출력1.
		//for이용 일괄 참조
		for(int i=0; i<list.size();i++) {
			System.out.println(list.get(i)); //래퍼클래스의 투스트링이나온다?
		}
		
		System.out.println("-----------------------");
		
		//출력2.
		//for each
		for(Integer i : list) {
			System.out.println(i);
		}
		
		System.out.println("-----------------------");
		
		//출력3.
		//정렬자를 이용한 전체출력
		Iterator<Integer> itr = list.iterator();
		
		while(itr.hasNext()) {
			Integer i = itr.next();
			System.out.println(i);
		}
		
		//리스트의 요소 삭제
		list.remove(2); //오브젝트로 지우는 것보단 중복이 있으니 인덱스로 지우는것이 깔끔
		
		System.out.println("-----------------------");
		
		for(Integer i : list) {
			System.out.println(i);
		}
	
	}
	
}
