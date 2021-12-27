package guestbook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;

public class GuestBookWritingCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		
		if(request.getMethod().equals("GET")) {
			//선택한 번호에 해당하는 글정보를 가져온다
			
			String index = request.getParameter("idx");
			
			request.setAttribute("writing", "객체");
			
			
			//선택한 번호에 해당하는 댓글정보를 가져온다
			
		}
		
		
		
		return "/WEB-INF/views/guestbook/writing.do";
	}

}
