package day0930;

import java.util.HashMap;

import classEx.Student2;

//map
//특정 데이터타입의 객체를 여러개 모아두는 Collection
public class Ex01Map {
public static void main(String[] args) {
    HashMap<String, Student2> map = new HashMap<>();
    Student2 s = new Student2();
    s.setId(1);
    s.setName("조재영");
    s.setKorean(80);
    s.setEnglish(80);
    s.setMath(81);
    
    map.put("s1",s); // 앞은 키값 
    
        System.out.println("map.get(\"s1\").getName():"+map.get("s1").getName());
        //->조재영
//에러남 System.out.println("map.get(\"s1\").getName()"+map.get("s2").getName());
        System.out.println("map.get(\"s1\").getName():"+map.get("s2"));
        //->null
        
        for(int i = 0; i<10; i++) {
        s = new Student2();
        
        s.setName("학생"+i);
        s.setId(i+2);
        s.setKorean(i*10);
        s.setEnglish(i*11);
        s.setMath(i*12);
        
        map.put("s"+i, s);
        } 
        //여기서put이10번실행됨 //위와s1이겹쳐서 위의put을 한번 더했음에도 사이즈는 10이나옴
        System.out.println("map.size():"+map.size()); //->10
        
        System.out.println("map.get(s1).getName():"+map.get("s1").getName());
        //->학생1  //기존의 것과 겹치면 새로운 것으로 덮어 씌운다
        
        //for(Student2 s1 : map) foreach문은 사용불가임
        System.out.println("map.keySet():"+map.keySet());
        //저장되어있는 키들을 리턴해줌
        //->s3,s4,s5,s6,s7,s8,s9,s0,s1,s2
        
        for(String str : map.keySet()) {
            Student2 temp = map.get(str); //먼저맵의 키셋을 불러와서(키셋은순서가 존재하니까)
        }
        
        
}
}
