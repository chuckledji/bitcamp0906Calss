package day0910;
//구구단을 출력하는 프로그램을 작성하시오
// 단 몇단인진는
public class Ex04Gugudan {
public static void main(String[] args) {
        
        for(int i =2; i <= 9; i++) {
            System.out.printf("---------------------\n\n");
            System.out.printf(i + "단\n\n");
            
            for(int j = 1; j <= 9; j++) {
                
                int result = i*j;
                
                System.out.printf("%d x %d = %d\n", i, j,  i*j); //result넣어도 됨
            }
            
        }
        
        
    }

}
