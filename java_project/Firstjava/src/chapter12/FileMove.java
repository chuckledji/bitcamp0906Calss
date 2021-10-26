package chapter12;

import java.io.File;

public class FileMove {
	public static void main(String[] args) {
		
		//원본파일의 경로를 객체로 생성한다.
		File myFile = new File("c:\\myJava\\java.pdf");		//\되는 이유는 utf-8이라서
		System.out.println(myFile.exists());
		
		if(!myFile.exists()) {
			
			//File file = new File("c:\\yourJava\\java-IO.pdf");
			File file = new File("c:\\yourJava","java-IO.pdf");
			
//			if(file.exists()) {
//				file.delete();
//				System.out.println("파일을 삭제했습니다.");
//			}
			
			System.out.println("원본파일이 존재하지 않습니다.");
			return;
			
		}
		
		//새로운 폴더를 생성 : 폴더가 존재하는지 여부 확인 후, 폴더 생성
		File newDir = new File("c:\\yourJava");
		if(!newDir.exists()) {
			newDir.mkdir();
			System.out.println("c:\\yourJava 폴더 생성");
		}
		
		//이동을 원하는 경로 생성
		File newFile = new File(newDir, "java-IO.pdf");
		
		//파일 이동
		myFile.renameTo(newFile);
		
		//이동한 파일이 존재하는지 확인
		if(newFile.exists()) {
			System.out.println("파일 이동 성공.");
		}else {
			System.out.println("파일 이동 실패.");
		}
	}
}
