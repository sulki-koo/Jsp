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
		String handlerClassStr = (String) request.getAttribute("handlerClassStr");
		
		CommandHandler handlerObj = null;

		try {
			Class handlerClass = Class.forName(handlerClassStr);

			handlerObj = (CommandHandler) handlerClass.newInstance();

			String viewPage = null;
			viewPage = handlerObj.process(request, response);

			if (viewPage != null) {
				RequestDispatcher rd = request.getRequestDispatcher(viewPage);
				rd.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	} // processRequest

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

} // class
