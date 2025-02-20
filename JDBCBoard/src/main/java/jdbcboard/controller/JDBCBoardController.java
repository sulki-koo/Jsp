package jdbcboard.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jdbcboard.model.Article;
import jdbcboard.model.Board;
import jdbcboard.model.Member;
import jdbcboard.model.Reply;
import jdbcboard.service.impl.ArticleServiceImpl;
import jdbcboard.service.impl.BoardServiceImpl;
import jdbcboard.service.impl.MemberServiecImpl;
import jdbcboard.service.impl.ReplyServiceImpl;

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
		
		Member member = null;
		Board board = null;
		Article article = null;
		Reply reply = null;
		
		Gson gson =  new GsonBuilder().setPrettyPrinting().create();
		String jsonStr = null;
		PrintWriter pw = null; 
		
		switch (requestURI) {
			case "index.do" :
					response.sendRedirect("/selectArticle.do");
				break;
				
			case "selectMember.do" : 
				resultObj = MemberServiecImpl.getMemberServiecImpl().selectMember();
				request.setAttribute("memberList", resultObj);
				forward(request, response, viewPage);
				break;
				
			case "selectBoard.do" : 
				resultObj = BoardServiceImpl.getBoardServiceImpl().selectBoard();
				request.setAttribute("boardList", resultObj);
				forward(request, response, viewPage);
				break;
			case "selectBoardJson.do" :
				resultObj = BoardServiceImpl.getBoardServiceImpl().selectBoard();
				
				jsonStr = gson.toJson(resultObj);
				response.setContentType("application/json");
				pw = response.getWriter();
				pw.write(jsonStr);
				pw.flush();
				break;
				
			case "selectArticle.do" : 
				String searchBoard = request.getParameter("searchBoard");
				String searchClass = request.getParameter("searchClass");
				String searchVal = request.getParameter("searchVal");
				resultObj = ArticleServiceImpl.getArticleServiceImpl().selectArticle(searchBoard, searchClass, searchVal);
				request.setAttribute("articleList", resultObj);
				request.setAttribute("searchBoard", searchBoard);
				request.setAttribute("searchClass", searchClass);
				request.setAttribute("searchVal", searchVal);
				forward(request, response, viewPage);
				break;
			case "selectReply.do" : 
				resultObj = ReplyServiceImpl.getReplyServiceImpl().selectReply();
				jsonStr = gson.toJson(resultObj);
				response.setContentType("application/json");
				pw = response.getWriter();
				pw.write(jsonStr);
				pw.flush();
				break;
				
			case "getMember.do" : 
				resultObj = MemberServiecImpl.getMemberServiecImpl().getMember(request.getParameter("mid"));
				request.setAttribute("member", resultObj);
				forward(request, response, viewPage);
				break;
			case "getArticle.do" : 
				int aid = Integer.parseInt(request.getParameter("aid"));
				ArticleServiceImpl as = ArticleServiceImpl.getArticleServiceImpl();
				as.increaseAvcnt(aid);
				resultObj = as.getArticle(aid);
				request.setAttribute("article", resultObj);
				forward(request, response, viewPage);
				break;
				
			case "insertMemberForm.do":
	            response.sendRedirect(viewPage);
	            break;
			case "insertMember.do" : 
				member = new Member(
						request.getParameter("mid"),
						request.getParameter("mname"),
						request.getParameter("malias"),
						request.getParameter("mpass"),
						request.getParameter("memail"),
						request.getParameter("mcp"),
						"N");
				MemberServiecImpl.getMemberServiecImpl().insertMember(member);
				response.sendRedirect("/selectMember.do");
				break;
				
			case "insertBoardForm.do":
	            response.sendRedirect(viewPage);
	            break;
			case "insertBoard.do" : 
				board = new Board(	0, request.getParameter("bname"), 0);
				BoardServiceImpl.getBoardServiceImpl().insertBoard(board);
				response.sendRedirect("/selectBoard.do");
				break;	
				
			case "insertArticleForm.do":
	            response.sendRedirect(viewPage);
	            break;
			case "insertArticle.do" : 
				article = new Article(0,	request.getParameter("asubject"), request.getParameter("acontent"), 0, null, "N", 0, 0,
						Integer.parseInt(request.getParameter("bid")), request.getParameter("mid"), null);
				ArticleServiceImpl.getArticleServiceImpl().insertArticle(article);
				response.sendRedirect("/selectArticle.do");
				break;
			case "insertReply.do" : 
				BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
				reply = gson.fromJson(reader.readLine(), Reply.class);
				reply = new Reply(0,	reply.getRcontent(), null, "N", reply.getMid(), reply.getAid());
				ReplyServiceImpl.getReplyServiceImpl().insertReplyr(reply);
				break;
				
			case "updateMemberForm.do":
				resultObj = MemberServiecImpl.getMemberServiecImpl().getMember(request.getParameter("mid"));
				request.setAttribute("member", resultObj);
				forward(request, response, viewPage);
				break;
			case "updateMember.do" : 
				member = new Member(
						request.getParameter("mid"),
						request.getParameter("mname"),
						request.getParameter("malias"),
						null,
						request.getParameter("memail"),
						request.getParameter("mcp"),
						"N");
				MemberServiecImpl.getMemberServiecImpl().updateMember(member);
				response.sendRedirect("/selectMember.do");
				break;
				
			case "updateBoardForm.do":
				resultObj = BoardServiceImpl.getBoardServiceImpl().getBoard(Integer.parseInt(request.getParameter("bid")));
				request.setAttribute("board", resultObj);
				forward(request, response, viewPage);
				break;
			case "updateBoard.do" : 
				board = new Board(Integer.parseInt(request.getParameter("bid")), request.getParameter("bname"), 0);
				BoardServiceImpl.getBoardServiceImpl().updateBoard(board);
				response.sendRedirect("/selectBoard.do");
				break;
				
			case "updateArticleForm.do":
				resultObj = ArticleServiceImpl.getArticleServiceImpl().getArticle(Integer.parseInt(request.getParameter("aid")));
				request.setAttribute("article", resultObj);
				forward(request, response, viewPage);
				break;
			case "updateArticle.do" : 
				article = new Article(Integer.parseInt(request.getParameter("aid")),	request.getParameter("asubject"), request.getParameter("acontent"), 0, null, "N", 0, 0, 0, null, null);
				ArticleServiceImpl.getArticleServiceImpl().updateArticle(article);
				response.sendRedirect("/getArticle.do?aid=" + request.getParameter("aid"));
				break;
				
			case "deleteMember.do"	:
				resultObj = MemberServiecImpl.getMemberServiecImpl().deleteMember(request.getParameter("mid"));
				response.sendRedirect("/selectMember.do");
				break;
			case "deleteBoard.do"	:
				resultObj = BoardServiceImpl.getBoardServiceImpl().deleteBoard(Integer.parseInt(request.getParameter("bid")));
				response.sendRedirect("/selectBoard.do");
				break;
			case "deleteArticle.do"	:
				resultObj = ArticleServiceImpl.getArticleServiceImpl().deleteArticle(Integer.parseInt(request.getParameter("aid")));
				response.sendRedirect("/selectArticle.do");
				break;
			case "deleteReply.do"	:
				resultObj = ReplyServiceImpl.getReplyServiceImpl().deleteReply(Integer.parseInt(request.getParameter("rid")));
				break;
				
			case "login.do" :
				boolean loginResult = MemberServiecImpl.getMemberServiecImpl().checkLogin(request.getParameter("mid"), request.getParameter("mpass"));
				if(loginResult) {
					request.getSession().setAttribute("ss_mid", request.getParameter("mid"));
					request.setAttribute("loginResult", true);
				}else {
					request.setAttribute("loginResult", false);
				}
				response.sendRedirect("/selectArticle.do");
				break;
				
			case "logout.do" :
				HttpSession hs = request.getSession();
				if(hs!=null) request.getSession().invalidate();
				response.sendRedirect("/selectArticle.do");
				break;
				
		}
		
		System.out.println("컨트롤러 뷰페이지: " + viewPage);
				
	} // process

	   private void forward(HttpServletRequest request, HttpServletResponse response, 
		         String viewPage) throws ServletException, IOException {
		      RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		      rd.forward(request, response);      
		   }
	
} // class
