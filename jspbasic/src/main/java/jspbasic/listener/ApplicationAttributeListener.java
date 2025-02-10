package jspbasic.listener;

import java.util.Enumeration;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;

public class ApplicationAttributeListener implements ServletContextAttributeListener{
	
	// 어플리케이션에 추가된 속성변수명들
	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
//		Enumeration<String> en = event.getServletContext().getAttributeNames();
//		while(en.hasMoreElements()) {
//			System.out.println(en.nextElement());
//		}
		System.out.println("어플리케이션 속성변수 추가");
	}
	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("어플리케이션 속성변수 삭제");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("어플리케이션 속성변수 값 대체");
	}
	
}
