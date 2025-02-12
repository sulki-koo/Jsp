package handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateCommand implements CommandHandler {

	@Override
	public String process(HttpServletRequest requset, HttpServletResponse response) {
		return "/jsp/update.jsp";
	}
	
}
