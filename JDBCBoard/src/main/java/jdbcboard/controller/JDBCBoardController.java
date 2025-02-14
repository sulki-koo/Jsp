package jdbcboard.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdbcboard.model.Article;
import jdbcboard.model.Board;
import jdbcboard.model.Member;
import jdbcboard.service.ArticleService;
import jdbcboard.service.BoardService;
import jdbcboard.service.MemberService;
import jdbcboard.service.impl.ArticleServiceImpl;
import jdbcboard.service.impl.BoardServiceImpl;
import jdbcboard.service.impl.MemberServiecImpl;

public class JDBCBoardController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	} // doGet

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	} // doPost

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = (String) request.getAttribute("requestURI");
		Object resultObj = null;
		String viewPage = (String) request.getAttribute("viewPage");
		System.out.println("컨트롤러 뷰페이지: " + viewPage);
		
		switch (requestURI) {
			case "selectMember.do" : 
				resultObj = new MemberServiecImpl().selectMember();
				request.setAttribute("memberList", resultObj);
				break;
			case "selectBoard.do" : 
				resultObj = new BoardServiceImpl().selectBoard();
				request.setAttribute("boardList", resultObj);
				break;
			case "selectArticle.do" : 
				resultObj = new ArticleServiceImpl().selectArticle();
				request.setAttribute("articleList", resultObj);
				break;
			case "getMember.do" : 
				resultObj = new MemberServiecImpl().getMember(request.getParameter("mid"));
				request.setAttribute("member", resultObj);
				break;
			case "getBoard.do" : 
				resultObj = new BoardServiceImpl().getBoard(Integer.parseInt(request.getParameter("bid")));
				request.setAttribute("board", resultObj);
				break;
			case "getArticle.do" : 
				resultObj = new ArticleServiceImpl().getArticle(Integer.parseInt(request.getParameter("aid")));
				request.setAttribute("article", resultObj);
				break;
			case "insertMemberForm.do" : 
				Member member = new Member(
						request.getParameter("mid"),
						request.getParameter("mname"),
						request.getParameter("malias"),
						request.getParameter("mpass"),
						request.getParameter("memail"),
						request.getParameter("mcp"),
						request.getParameter("mdelyn"));
				resultObj = new MemberServiecImpl().insertMember(member);
				request.setAttribute("member", resultObj);
				break;
			case "updateMemberForm.do" : 
				Member member1 = new Member(
						request.getParameter("mid"),
						request.getParameter("mname"),
						request.getParameter("malias"),
						request.getParameter("mpass"),
						request.getParameter("memail"),
						request.getParameter("mcp"),
						request.getParameter("mdelyn"));
				resultObj = new MemberServiecImpl().updateMember(member1);
				request.setAttribute("member", resultObj);
				break;
				
			
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
		
	} // process

} // class
