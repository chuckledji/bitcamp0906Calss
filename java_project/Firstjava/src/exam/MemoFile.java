package exam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class MemoFile {
	
	private static List<String> memoList = new ArrayList<String>();
	final static Scanner scanner = new Scanner(System.in);

	
	//1.메모목록을 출력하는 메소드
	public static void printMemoList() {
		
		if (memoList.size()==0) {						//메모가 등록되지 않았을 경우
			System.out.println("아직 등록된 메모가 존재하지 않습니다.");
		}else {
			for(int i=0; i<memoList.size(); i++) {
				System.out.print("["+(i+1)+"]");
				System.out.println(memoList.get(i));
			}
		}
	}
	
	
	//2-1.선택한번호의 메모장이름을 불러와 그 메모장 파일을 출력하는 메소드
	public static void findMemoName() throws IOException {
		
		if(memoList.size()==0) {						//메모가 등록되지 않았을 경우
			System.out.println("아직 등록된 메모가 존재하지 않습니다.");
		}else {
			printMemoList();
			System.out.println("볼 메모장의 번호를 선택하세요.> ");
			int memoNum = Integer.parseInt(scanner.nextLine());
			
			for(int i=0; i<memoList.size(); i++) {		//선택한 번호에 맞는 메모장이름을 불러온다.
				if(memoNum == i+1) {
					String fileName = memoList.get(i);
					System.out.println(fileName);
					readFile(fileName);					//2-2파일출력메소드실행
					break;
				}else {
					System.out.println("자료가 존재하지 않습니다.");
				}
			}
		}
	}
	
	//2-2. 메모장이름에 맞는 파일출력하는 메소드
	public static void readFile(String fileName) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		
		String str;
		while(true) {
			str = in.readLine();
			if(str==null) {
				break;
			}
			System.out.println(str);
		}
		in.close();
	}
	
	
	//3.메모 작성하여 파일을 생성하는 메소드
	public static void writeMemo() throws IOException {
		Date date = new Date();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = format1.format(date);
		
		//메모등록 - 사용자에게 입력요청해서
		System.out.println("작성날짜 > "+strDate);			//메모작성날짜
		
		System.out.println("메모제목을 입력해주세요. >");		//메모제목등록
		String title = scanner.nextLine();
		
		System.out.println("메모내용을 입력해주세요. >");		//메모내용등록
		String content = scanner.nextLine();

		String fileName = String.valueOf(strDate + " " + title + ".txt");		
		//파일생성 - 파일의 이름은 날짜와 메모제목이다.(문자기반스트림 이용)
		BufferedWriter out = new BufferedWriter(new FileWriter(new File("c:\\ExamMemo",fileName)));
		
		out.newLine();
		out.write("작성날짜 : " + strDate);					//파일에 입력한 내용 저장
		out.newLine();
		out.write("제목 : " + title);
		out.newLine();	
		out.write("내용 : " + content);
		
		out.close();
		System.out.println("입력이 완료 되었습니다.");
		System.out.println(fileName+" 파일 생성");
		
		//리스트에 메모파일 이름을 저장한다.
		memoList.add(fileName);
		
	
	}
	
	
	
}
