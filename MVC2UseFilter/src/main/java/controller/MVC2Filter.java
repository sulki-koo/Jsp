package controller;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class MVC2Filter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("필터 초기화");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chian)
			throws IOException, ServletException {
		System.out.println("필터 호출");

		HttpServletRequest httpRquest = (HttpServletRequest) request;
		String command = httpRquest.getRequestURI();

		// 요청URI가 컨텍스트루트로 시작하면 (예 : /list.do는 /로 시작한다 = /의 인덱스가 0)
		if (command.indexOf(httpRquest.getContextPath()) == 0) {
			// 요청URI에서 명령어 획득 (예 : /list.do에서 ContextPath인 /의 인덱스+1부터 끝까지 => list.do)
			command = command.substring(httpRquest.getContextPath().length() + 1);
		}

		String handlerClassStr = "handler." + command.substring(0, 1).toUpperCase()
				+ command.substring(1, command.indexOf(".do")) + "Command";
		
		request.setAttribute("handlerClassStr", handlerClassStr);
		
		System.out.println(handlerClassStr);
		
		chian.doFilter(httpRquest, response);
		
	}

	@Override
	public void destroy() {
		System.out.println("필터 소멸");
	}

}
