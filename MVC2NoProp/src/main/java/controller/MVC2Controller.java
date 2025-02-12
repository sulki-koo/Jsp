package controller;

import java.io.IOException;

import handler.CommandHandler;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MVC2Controller extends HttpServlet {

	public void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 명령어 가져오기 위해 요청URI 획득 (예 : /list.do)
		String command = request.getRequestURI();
		
		// 요청URI가 컨텍스트루트로 시작하면 (예 : /list.do는 /로 시작한다 = /의 인덱스가 0)
		if (command.indexOf(request.getContextPath()) == 0) {
			// 요청URI에서 명령어 획득 (예 : /list.do에서 ContextPath인 /의 인덱스+1부터 끝까지 => list.do)
			command = command.substring(request.getContextPath().length() + 1);
		}

		String handlerClassStr = "handler."+ command.substring(0, 1).toUpperCase() + command.substring(1, command.indexOf(".do")) + "Command";
		
		CommandHandler handlerObj = null;
		
		System.out.println(handlerClassStr);
		
		try {
			Class handlerClass = Class.forName(handlerClassStr);
			
			handlerObj = (CommandHandler) handlerClass.newInstance();
			
			String viewPage = null;
			viewPage = handlerObj.process(request, response);
			
			if(viewPage != null) {
				RequestDispatcher rd = request.getRequestDispatcher(viewPage);
				rd.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	} // processRequest
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

} // class
