package handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListCommand implements CommandHandler {

	@Override
	public String process(HttpServletRequest requset, HttpServletResponse response) {
		return "/jsp/list.jsp";
	}
	
}
