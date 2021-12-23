package guestbook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import guestbook.sevice.GuestBookWriteService;

public class GuestBookWriteCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		String view = null;
		
		
		if(request.getMethod().equals("GET")) {
			
			view="/WEB-INF/views/guestbook/guestbook.jsp";
			
		}else if(request.getMethod().equals("POST")) {
			
			
			int gcnt = GuestBookWriteService.getInstance().insertWriting(request, response);
			
			request.setAttribute("result", gcnt>0?"등록되었습니다." : "등록에 실패했습니다. 다시 확인해주세요");
			
			view="/WEB-INF/views/guestbook/regwriting.jsp";
		}
		
		return view;
	}

}
