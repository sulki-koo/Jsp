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
import jdbcboard.model.Reply;
import jdbcboard.service.ArticleService;
import jdbcboard.service.BoardService;
import jdbcboard.service.MemberService;
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
		
		switch (requestURI) {
			case "selectMember.do" : 
				resultObj = MemberServiecImpl.getMemberServiecImpl().selectMember();
				request.setAttribute("memberList", resultObj);
				break;
			case "selectBoard.do" : 
				resultObj = BoardServiceImpl.getBoardServiceImpl().selectBoard();
				request.setAttribute("boardList", resultObj);
				break;
			case "selectArticle.do" : 
				resultObj = ArticleServiceImpl.getArticleServiceImpl().selectArticle();
				request.setAttribute("articleList", resultObj);
				break;
//			case "selectReply.do" : 
//				resultObj = ReplyServiceImpl.getReplyServiceImpl().selectReply();
//				request.setAttribute("replyList", resultObj);
//				break;
				
			case "getMember.do" : 
				resultObj = MemberServiecImpl.getMemberServiecImpl().getMember(request.getParameter("mid"));
				request.setAttribute("member", resultObj);
				break;
			case "getBoard.do" : 
				resultObj = BoardServiceImpl.getBoardServiceImpl().getBoard(Integer.parseInt(request.getParameter("bid")));
				request.setAttribute("board", resultObj);
				break;
			case "getArticle.do" : 
				resultObj = ArticleServiceImpl.getArticleServiceImpl().getArticle(Integer.parseInt(request.getParameter("aid")));
				request.setAttribute("article", resultObj);
				request.setAttribute("replyList", ReplyServiceImpl.getReplyServiceImpl().selectReply());
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
				return;
			case "insertBoard.do" : 
				board = new Board(	0, request.getParameter("bname"), 0);
				BoardServiceImpl.getBoardServiceImpl().insertBoard(board);
				response.sendRedirect("/selectBoard.do");
				return;	
			case "insertArticle.do" : 
				article = new Article(0,	request.getParameter("asubject"), request.getParameter("acontent"), 0, null, "N", 0, 0,
						Integer.parseInt(request.getParameter("bid")), request.getParameter("mid"));
				ArticleServiceImpl.getArticleServiceImpl().insertArticle(article);
				response.sendRedirect("/selectArticle.do");
				return;
			case "insertReply.do" : 
				reply = new Reply(0,	request.getParameter("rcontent"), null, "N", request.getParameter("mid"), Integer.parseInt(request.getParameter("aid")));
				ReplyServiceImpl.getReplyServiceImpl().insertReplyr(reply);
				response.sendRedirect("/getArticle.do?aid="+Integer.parseInt(request.getParameter("aid")));
				return;
				
			case "updateMemberForm.do":
				resultObj = MemberServiecImpl.getMemberServiecImpl().getMember(request.getParameter("mid"));
				request.setAttribute("member", resultObj);
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
				return;
				
			case "updateBoardForm.do":
				resultObj = BoardServiceImpl.getBoardServiceImpl().getBoard(Integer.parseInt(request.getParameter("bid")));
				request.setAttribute("board", resultObj);
				break;
			case "updateBoard.do" : 
				board = new Board(Integer.parseInt(request.getParameter("bid")), request.getParameter("bname"), 0);
				BoardServiceImpl.getBoardServiceImpl().updateBoard(board);
				response.sendRedirect("/selectBoard.do");
				return;
				
			case "updateArticleForm.do":
				resultObj = ArticleServiceImpl.getArticleServiceImpl().getArticle(Integer.parseInt(request.getParameter("aid")));
				request.setAttribute("article", resultObj);
				break;
			case "updateArticle.do" : 
				article = new Article(Integer.parseInt(request.getParameter("aid")),	request.getParameter("asubject"), request.getParameter("acontent"), 0, null, "N", 0, 0,
						Integer.parseInt(request.getParameter("aid")), request.getParameter("aid"));
				ArticleServiceImpl.getArticleServiceImpl().updateArticle(article);
				response.sendRedirect("/selectArticle.do");
				return;
				
			case "deleteMember.do"	:
				resultObj = MemberServiecImpl.getMemberServiecImpl().deleteMember(request.getParameter("mid"));
				response.sendRedirect("/selectMember.do");
				return;
			case "deleteBoard.do"	:
				resultObj = BoardServiceImpl.getBoardServiceImpl().deleteBoard(Integer.parseInt(request.getParameter("bid")));
				response.sendRedirect("/selectBoard.do");
				return;
			case "deleteArticle.do"	:
				resultObj = ArticleServiceImpl.getArticleServiceImpl().deleteArticle(Integer.parseInt(request.getParameter("aid")));
				response.sendRedirect("/selectArticle.do");
				return;
			case "deleteReply.do"	:
				resultObj = ReplyServiceImpl.getReplyServiceImpl().deleteReply(Integer.parseInt(request.getParameter("rid")));
				response.sendRedirect("/selectArticle.do");
				return;
		}
		
		System.out.println("컨트롤러 뷰페이지: " + viewPage);
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
		
	} // process

} // class
