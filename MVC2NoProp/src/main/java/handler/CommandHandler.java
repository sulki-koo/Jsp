package handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface CommandHandler {

	public abstract String process(HttpServletRequest requset, HttpServletResponse response);
	
}
