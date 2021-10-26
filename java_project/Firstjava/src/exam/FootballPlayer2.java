package exam;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class FootballPlayer2 implements Comparable<FootballPlayer2>, Serializable{
	String name; 
    int number; 
    String team; 
    int age ;
    
    public FootballPlayer2(String name, int number, String team, int age) {
	
		this.name = name;
		this.number = number;
		this.team = team;
		this.age = age;
	}
    
    //출력을 위한 toString
    @Override
	public String toString() {
		return "FootballPlayer2 [name=" + name + ", number=" + number + ", team=" + team + ", age=" + age + "]";
	}
    
    //2.HashSet을 위한 오버라이드//////////////////////////////////////////////
    
    @Override
	public boolean equals(Object obj) {

    	boolean result = false;
    	
    	if(obj != null && obj instanceof FootballPlayer2) {	//객체가 비지않았고, 객체가 FootballPlayer2로 형변환이 된다면
    		FootballPlayer2 player = (FootballPlayer2) obj; //그러면 들어온 객체는 이 클래스의 객체와 같은 것이다.
    		if(this.team.equals(player.team) && this.name.equals(player.name) && this.age == player.age) {
    			result = true;								//들어온 객체의 팀,이름,나이가 같다면 결과를 true
    		}
    	}
    	return result;
	}


	@Override
	public int hashCode() {
		return this.age % 10;
	}
	
	//3.TreeSet을 위한 오버라이드//////////////////////////////////////////////

	@Override
	public int compareTo(FootballPlayer2 o) {
		int result = this.team.compareTo(o.team);
		
		if(result ==0) {							//팀이 같다면
			result = this.name.compareTo(o.name);	
			if(result == 0) {						//이름이 같다면
				result = this.number - o.number;	//번호가 큰쪽이 양수, 작은쪽이 음수
			}
		}
		return result;
	}
	
    /////////////////////////////////////////////////////////////////////
    
    public static void main(String[] args) {
    	
    //1.축구선수 인스턴스를 저장할 수 있는 List<E> 컬렉션 인스턴스를 생성해서 
        //	인스턴스를 저장하고 출력하는 프로그램을 만들어 봅시다.
    	
    	System.out.println("문제1");
    	//인스턴스 생성
        List<FootballPlayer2> footballPlayer = new ArrayList<>();
        
        //인스턴스 저장
        footballPlayer.add(new FootballPlayer2("사람1",1,"팀1",25));
        
        //인스턴스 출력
        Iterator<FootballPlayer2> itr = footballPlayer.iterator();
        while(itr.hasNext()) {
        	FootballPlayer2 i = itr.next();
        	System.out.println(i);
        }
        System.out.println("------------------");
        System.out.println("문제2");
        
     //2.축구선수의 인스턴스가 팀과 이름 그리고 나이가 같으면 같은 선수라 판단하고
        //	입력이 되지 않도록 Set<E> 컬렉션을 이용해서 
        //	축구선수 인스턴스를 저장하고 출력하는 프로그램을 만들어 봅시다.
        
        //인스턴스생성
        HashSet<FootballPlayer2> hashPlayer = new HashSet<FootballPlayer2>();
        
        //인스턴스저장
        hashPlayer.add(new FootballPlayer2("사람1", 1, "팀1", 10));
        hashPlayer.add(new FootballPlayer2("사람2", 2, "팀1", 20));
        hashPlayer.add(new FootballPlayer2("사람3", 3, "팀2", 10));
        hashPlayer.add(new FootballPlayer2("사람3", 3, "팀2", 10));
        
        //인스턴스출력
        Iterator<FootballPlayer2> hitr = hashPlayer.iterator();
        while(hitr.hasNext()) {
        	System.out.println(hitr.next());
        }
        System.out.println("------------------");
        System.out.println("문제3");
        
     //3.TreeSet<E>을 이용해서 팀 이름순으로 정렬하고,
        //	같은 팀의 선수들은 이름 순으로 정렬하고, 
        //	같은 이름의 선수는 번호 순으로 저장하는 프로그램을 만들어 봅시다.
        
        //인스턴스생성
        TreeSet<FootballPlayer2> treePlayer = new TreeSet<FootballPlayer2>();
        
        //인스턴스저장
        treePlayer.add(new FootballPlayer2("사람1", 1, "팀1", 10));
        treePlayer.add(new FootballPlayer2("사람2", 3, "팀2", 20));
        treePlayer.add(new FootballPlayer2("사람2", 2, "팀3", 30));
        treePlayer.add(new FootballPlayer2("사람4", 6, "팀4", 40));
        
        //인스턴스출력
        Iterator<FootballPlayer2> titr = treePlayer.iterator();
        while(titr.hasNext()) {
        	System.out.println(titr.next());
        }
        System.out.println("------------------");
        System.out.println("문제4 출력1");
        
     //4.축구선수의 번호를 key로 하고 
        //축구선수 인스턴스를 저장하는 Map<K,V> 인스턴스를 이용해서 프로그램을 만들어봅시다.
        
        //인스턴스생성
        HashMap<Integer, FootballPlayer2> mapPlayer = new HashMap<Integer, FootballPlayer2>();
        
        //인스턴스저장
        mapPlayer.put(1, new FootballPlayer2("사람1", 1, "팀1", 10));
        mapPlayer.put(4, new FootballPlayer2("사람1", 4, "팀6", 20));
        mapPlayer.put(7, new FootballPlayer2("사람5", 7, "팀1", 30));
        
        //인스턴스출력
        //키값을 셋으로 바꿔준다.
        Iterator<Integer> mitr = mapPlayer.keySet().iterator();
        while(mitr.hasNext()) {
        	System.out.println(mapPlayer.get(mitr.next()));
        }
        System.out.println("------------------");
        System.out.println("문제4 출력2");
        
        //인스턴스출력
        for(Map.Entry<Integer, FootballPlayer2> e : mapPlayer.entrySet()) {
        	System.out.println("[" +e.getKey()+ " , " +e.getValue()+ "]");
        }
        
        
	}

	


	
}
