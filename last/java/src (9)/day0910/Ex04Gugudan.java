package day0910;
// 구구단을 출력하는 프로그램을 작성하시오.
// 단 몇단인지는 i for문으로 출력하고
// a x b = ab 는 j for문으로 출력하시오.


public class Ex04Gugudan {
    public static void main(String[] args) {
        for(int i = 2; i <= 9; i++) {
            System.out.println("---------------------------------");
            System.out.println(i+"단");
            System.out.println("---------------------------------");
            
            for(int j = 1; j <= 9; j++) {
                System.out.printf("%d x %d = %d\n", i, j, i*j);
            }
            
            System.out.println();
        }
    }
}
