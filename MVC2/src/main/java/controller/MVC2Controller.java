package controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import handler.CommandHandler;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MVC2Controller extends HttpServlet {

	// 명령어(커맨드)와 명령어처리객체(ListCommand, WriteCommand, UpdateCommand, DeleteCommand)를
	// 맵핑할 맵
	Map<String, Object> commandMap = null;

	@Override
	public void init(ServletConfig sc) throws ServletException {

		// web.xml에 설정한 서블릿 초기화 파라미터 값
		// /WEB-INF/classes/props/command.properties
		String commandFile = sc.getInitParameter("commandFile");

		// .properties파일을 읽어 저장할 Properties( : 키와 값이 모두 문자열인 맵)
		Properties prop = new Properties();

		// .properties파일의 실제 경로
		String commandFilePath = sc.getServletContext().getRealPath(commandFile);
		// System.out.println(commandFilePath);
		
		// .properties파일에서 문자를 입력받을 스트림
		FileReader fr = null;

		try {
			// 스트림 생성
			fr = new FileReader(commandFilePath);

			// 파일내의 키, 값을 Properties객체에 맵핑
			prop.load(fr);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		// 프라퍼티의 키들을 반복할 Iterator 획득
		Iterator it = prop.keySet().iterator();

		// 커맨드맵을 생성 
		// 명령어(키)와 명령어처리클래스(값)를 저장할 맵
		commandMap = new HashMap<String, Object>();

		// 키가 있는 만큼 반복
		while (it.hasNext()) {
			String command = (String) it.next(); // 키 = 명령어 문자열
			String handlerClassStr = prop.getProperty(command); // 값 = 명령어처리클래스의 문자열
			try {
				// 명령어처리클래스 문자열로 클래스를 생성
				Class handlClass = Class.forName(handlerClassStr);
				// 명령어처리클래스의 객체를 생성
				CommandHandler handlerObj = (CommandHandler) handlClass.newInstance();
				// 명령어와 명령어처리클래스의 객체를 맵에 등록
				commandMap.put(command, handlerObj);
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		} // while

	} // init

	public void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 명령어 가져오기 위해 요청URI 획득 (예 : /list.do)
		String command = request.getRequestURI();

		// 요청URI가 컨텍스트루트로 시작하면 (예 : /list.do는 /로 시작한다 = /의 인덱스가 0)
		if (command.indexOf(request.getContextPath()) == 0) {
			// 요청URI에서 명령어 획득 (예 : /list.do에서 ContextPath인 /의 인덱스+1부터 끝까지 => list.do)
			command = command.substring(request.getContextPath().length() + 1);
		}

		// 명령어를 처리할 명령어처리클래스의 객체를 맵에서 획득
		CommandHandler handler = (CommandHandler) commandMap.get(command);

		// 뷰페이지
		String viewPage = null;

		try {
			// 명령어처리클래스의 객체에서 view페이지 획득
			viewPage = handler.process(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		// 뷰페이지가 존재한다면
		if(viewPage != null) {
			// 뷰페이지로 포워딩
			RequestDispatcher rd = request.getRequestDispatcher(viewPage);
			rd.forward(request, response);
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
