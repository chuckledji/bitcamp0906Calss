package service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploadCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {

		String view = null;
		
		if(request.getMethod().equals("GET")) {
			
			view = "/WEB-INF/views/upload/uploadform.jsp";
			
		}else if(request.getMethod().equals("POST")) {
			
			String userName = null;
			String title = null;
			String fileName = null;
			long fileSize = 0;
			String contentType = null;
			
			//1.multipart 여부 확인
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);	
			
			if(isMultipart) {
				
				//2.파일저장을 위한 Factory객체를 생성
				DiskFileItemFactory factory = new DiskFileItemFactory();
				
				//3.요청을 구분(form안에있는 input들을 분리)
				ServletFileUpload upload = new ServletFileUpload(factory);
				
				try {														//추상메소드오버라이딩이므로 try/catch로 해야함
					List<FileItem> items = upload.parseRequest(request);
					
					Iterator<FileItem> itr = items.iterator();
					
					while(itr.hasNext()) {
						
						FileItem item = itr.next();
						
						//파일과 일반 폼 필드를 구분해서 데이터처리
						if(item.isFormField()) {
							//text, password, checkbox, radio, hidden, select, textarea...
							//type=file을 제외한 타입
							
							//파라미터이름 : input의 name속성값
							String paramName = item.getFieldName();
							if(paramName.equals("title")) {
								try {
									title = item.getString("utf-8");
								} catch (UnsupportedEncodingException e) {
									e.printStackTrace();
								}
							}else if(paramName.equals("username")) {
								try {
								userName = item.getString("utf-8");
								} catch (UnsupportedEncodingException e) {
									e.printStackTrace();
								}
							}else {
								//....추가
							}
						}else {
							//file처리
							
							//웹경로
							String uploadURI = "/uploadfile";
							
							//시스템경로
							String saveDir = request.getSession().getServletContext().getRealPath(uploadURI);
							 System.out.println(saveDir);
							
							//파라미터이름
							String paramName = item.getFieldName();
							System.out.println("파라미터이름 : "+ paramName);
							
							if(paramName.equals("userfile")) {
								
								//파일이름
								fileName = item.getName();
								System.out.println("파일이름 : "+fileName);
								
								//contentType
								contentType = item.getContentType();
								System.out.println("컨텐트타입 : "+contentType);
								
								//파일사이즈
								fileSize = item.getSize();
								System.out.println("파일사이즈 : "+fileSize);
								
								//파일저장
								File saveFile = new File(saveDir, fileName);
								
								//파일중복확인
								if(saveFile.exists()) {
									saveFile = new File(saveDir, fileName.split("\\.")[0]+System.nanoTime()+".");
								}
								
								try {
									item.write(saveFile);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}			
						}						
					}
				} catch (FileUploadException e) {
					e.printStackTrace();
				}	
			}
			
			//Dao.insert()
			
			request.setAttribute("title", title);
			request.setAttribute("fileName", fileName);
			request.setAttribute("contentType", contentType);
			request.setAttribute("fileSize", fileSize);			//이렇게 여러개 보낼때 그냥 클래스를 설정하는 것이 편하다
			request.setAttribute("userName", userName);
			
			view="/WEB-INF/views/upload/upload.jsp";
		}
		
		return view;
	}

}
