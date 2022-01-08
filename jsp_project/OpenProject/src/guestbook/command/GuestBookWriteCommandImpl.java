package guestbook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import guestbook.service.GuestBookWriteService;

public class GuestBookWriteCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		String view = null;
		
		if(request.getMethod().equals("GET")) {
			
			view = "/WEB-INF/views/guestbook/writeform.jsp";
			
		} else if(request.getMethod().equals("POST")) {
			System.out.println("문제찾기-controller-1");
			request.setAttribute("result", GuestBookWriteService.getInstance().writeArticle(request, response));
			System.out.println("문제찾기-controller-2");
			view = "/WEB-INF/views/guestbook/write.jsp";
		}
		
		
		return view;
	}

}