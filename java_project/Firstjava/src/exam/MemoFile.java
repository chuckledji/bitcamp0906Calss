package exam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class MemoFile {
	private static int fileNum;	//파일의 개수
	private static String[] memoList;
	final static Scanner scanner = new Scanner(System.in);

	
	
	//TEST
	public static void main(String[] args) throws IOException {
		writeMemo();
	}
	
	
	//1.메모목록을 출력하는 메소드
	public static void printMemoList() {
		
		if (fileNum==0) {					//메모가 등록되지 않았을 경우
			System.out.println("아직 등록된 메모가 존재하지 않습니다.");
		}else {
			for(int i=0; i<fileNum; i++) {
				System.out.print("["+(i+1)+"]");
				System.out.println(memoList[i]);
			}
		}
	}
	
	
	//2-1.선택한번호의 메모장이름을 불러와 그 메모장 파일을 출력하는 메소드
	public static void findMemoName() throws IOException {
		
		if(fileNum==0) {					//메모가 등록되지 않았을 경우
			System.out.println("아직 등록된 메모가 존재하지 않습니다.");
		}else {
			System.out.println("볼 메모장의 번호를 선택하세요.> ");
			int memoNum = scanner.nextInt();
			
			//선택한 번호에 맞는 메모장이름을 불러온다.
			for(int i=0; i<fileNum; i++) {
				if(memoNum == i+1) {
					String fileName = memoList[i];
					readFile(fileName);
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

				
		//파일생성 - 파일의 이름은 날짜와 메모제목이다.(문자기반스트림 이용)
		BufferedWriter out = new BufferedWriter(new FileWriter(strDate +" " + title + ".txt"));
		
		out.newLine();
		out.write("작성날짜 : " + strDate);					//파일에 입력한 내용 저장
		out.newLine();
		out.write("제목 : " + title);
		out.newLine();	
		out.write("내용 : " + content);
		
		out.close();
		System.out.println("입력이 완료 되었습니다.");
										
		String fileName = (strDate +" " + title + ".txt");
		System.out.println(fileName);
		//리스트에 메모파일 이름을 저장한다.
		memoList[fileNum++] = fileName;
		System.out.println("테스트성공2");
		
		
	}
}
