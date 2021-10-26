package exam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FootballPlayerSerializable {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		//인스턴스저장을 위한 스트림
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("FootBallPlyer.ser"));
		
		//인스턴스에 저장한다
		List<FootballPlayer> arr = new ArrayList<FootballPlayer>();
		arr.add(new FootballPlayer("사람1", 7, "team1", 27));
		arr.add(new FootballPlayer("사람2", 4, "team2", 25));
		
		out.writeObject(arr);
		
		out.close();
		
		//저장된 파일을 이용해 인스턴스생성 = 복원
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("FootBallPlyer.ser"));
		
		//복원 : 인스턴스 생성후에 반환한다.
		List<FootballPlayer> arr1 = (List) in.readObject();
		for(FootballPlayer f : arr1) {
			System.out.println(f);
		}
		
		
		in.close();
		
	}
	
	
}
