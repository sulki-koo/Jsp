package jspbasic.listener;

import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

public class SessAttributeListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
//		Enumeration<String> en = event.getSession().getAttributeNames();
//		while(en.hasMoreElements()) {
//			System.out.println(en.nextElement());
//		}
		System.out.println("세션 속성변수 추가");
	}
	
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("세션 속성변수 삭제");
	}
	
	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("세션 속성변수 대체");
	}
	
}
