package hello.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SumServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer a = Integer.parseInt(request.getParameter("a"));
		Integer b = Integer.parseInt(request.getParameter("b"));
		// 콘솔에 출력
		System.out.println(a + " + " + b +" = " + (a+b));
		
		// 클라이언트에 출력
		PrintWriter pw = response.getWriter();
		pw.write("<!DOCTYPE html>");
		pw.write("<html>");
		pw.write("<meta charset='utf-8'>");
		pw.write("<title>두 수의 합 구하기</title>");
		pw.write("</head>");
		pw.write("<body>");
		pw.write("<p>" + a + " + " + b +" = " + (a+b) + "</p>");
		pw.write("</body>");
		pw.write("</html>");
		pw.flush();
		pw.close();
	}
	
} // class
