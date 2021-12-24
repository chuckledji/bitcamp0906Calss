package member.service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import jdbc.ConnectionProvider;
import jdbc.util.JdbcUtil;
import member.dao.MemberDao;
import member.domain.RegRequest;

public class MemberRegService {
	
	//Service클래스도 메소드만 있는 클래스다! -> 싱글톤처리하자
	private MemberRegService() {
		
	}
	private static MemberRegService regService = new MemberRegService();
	public static MemberRegService getInstance() {
		return regService;
	}
	//사용자가 전달한 요청 데이터를 받아서 Dao insert로 전달
	//입력 결과 데이터 반환하는 메소드, 사용자 요청처리, 응답처리
	
	public int insertMember(HttpServletRequest request, HttpServletResponse response) {
		
		int resultCnt = 0;
		
		//파일업로드
		//파라미터받기, 파일업로드, 저장파일 이름을 생성
		//RegRequest의 객체 생성
		
	
		//1.multipart 여부 확인
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);	
		
		if(isMultipart) {
			
			String userId = null;
			String pw = null; 			//""로 초기화할 경우 인스턴스를 생성하므로 null로 써준다.
			String userName = null;
			String fileName = null; 	//파일이 있으면 업로드하고 저장된 파일의 이름 저장 /없으면 null
			File newFile = null;
			Connection conn = null;
			
			//2.파일저장을 위한 Factory객체를 생성
			DiskFileItemFactory factory = new DiskFileItemFactory();
			
			//3.요청을 구분(form안에있는 input들을 분리)
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			try {
				
				List<FileItem> items = upload.parseRequest(request);
				
				Iterator<FileItem> itr = items.iterator();
				
				while(itr.hasNext()) {
					
					FileItem item = itr.next();
					
					//일반파라미터와 file을 구분해서처리한다
					if(item.isFormField()) {
						//일반파라미터
						//파라미터 이름에 맞는 데이터를 받고 변수에 저장
						String paramName = item.getFieldName();
						
						if(paramName.equals("userid")) {
							userId = item.getString("utf-8"); 		// add catch cause~try추가해주기(밑에 생성)
						} else if(paramName.equals("pw")) {
							pw = item.getString("utf-8");
						}else if(paramName.equals("username")) {
							userName = item.getString("utf-8");
						}
						
					}else {
						//file
						
						if(item.getFieldName().equals("photo") && item.getSize()>0) {
							//웹 저장경로
							String uploadURI ="/uploadfile";
							//시스템경로
							String saveDir = request.getSession().getServletContext().getRealPath(uploadURI);
							//새로운 파일이름은 중복되지 않는 숫자로 생성
							String newFileName = String.valueOf(System.nanoTime());
							
							//file저장을 위한 File 객체 생성
							newFile = new File(saveDir, newFileName);
							//File newFile = new File(request.getSession().getServletContext().getRealPath(uploadURI), newFileName);
							
							//파일저장
							item.write(newFile);	//try catch처리 (밑에생성됨)
							//item.write(new File(request.getSession().getServletContext().getRealPath(uploadURI), newFileName));
							
							System.out.println("파일저장완료");
							
							fileName = newFileName;
						}
					}			
				}			
				
				if(fileName ==null) {
					fileName = "doh1.png";
				}
				
				//Dao호출
				conn = ConnectionProvider.getConnection();
				
				RegRequest regRequest = new RegRequest(userId, pw, userName, fileName);
				
				resultCnt = MemberDao.getInstance().insertMember(conn, regRequest);
				
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
				//저장된 파일이있다면 파일을 삭제
				if(newFile != null && newFile.exists()) {
					newFile.delete();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				JdbcUtil.close(conn);
			}
		}
		return resultCnt;
	}
}
