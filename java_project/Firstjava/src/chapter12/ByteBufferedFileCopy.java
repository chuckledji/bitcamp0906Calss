package chapter12;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;



public class ByteBufferedFileCopy {
	public static void main(String[] args)  {
		
		try {
		
		InputStream in = new FileInputStream("eclipse.zip");
		OutputStream out = new FileOutputStream("copy3.zip");
		
		//보조스트림( 필터스트림) : 필터스트림을 사용하기 위해서는 기본 스트림이 필요하다		//성능향상을 위해서 쓰는 버퍼스트림
		BufferedInputStream bin = new BufferedInputStream(in, 1024*2);
		BufferedOutputStream bout = new BufferedOutputStream(out, 1024*2);
		
		
		int copyByte = 0; 		//복사한 바이트 사이즈 계산
		int bData = -1;			//스트림으로부터 읽어온 byte 단위의 데이터
		
		while(true) {
			//파일읽기
			bData = bin.read();
			if(bData == -1){
				break;			
			}
			//파일쓰기
			bout.write(bData);
			
			copyByte++;
		}
		
		in.close();
		out.close();
		
		System.out.println("복사된 byte size : " +copyByte);
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
