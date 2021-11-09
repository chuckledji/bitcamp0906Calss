package day0913;
import java.util.Random;
public class LottoGame01 {
    public static void main(String[] args) {
        Random random = new Random();
        final int SIZE = 6;
        final int NUMBER_MAX = 45;
        
        // 번호를 저장할 배열
        int[] numbers = new int[SIZE];
        
        // for문을 사용하여
        // int 배열 numbers의 각 인덱스번 칸에
        // 랜덤한 숫자를 넣어준다.
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(NUMBER_MAX) + 1;
        }
        
        // for문을 사용하여
        // 각 인덱스의 저장된 값을 출력한다.
        for(int i  = 0; i < numbers.length; i++) {
            System.out.printf("numbers[%d]: %d\n", i, numbers[i]);
        }
        
    }
    
}

