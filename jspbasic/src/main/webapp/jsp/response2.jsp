<%@ page contentType="text/html; charset=UTF-8"%>

<% 
   // 응답 전환 
   // 원래 response2.jsp 호출되면 response2.jsp가 실행되어야 하지만
   // 리다이렉션을 하면 reponse3.jsp가 실행되어 클라이언트에게 응답함
   System.out.println(request);
   request.setAttribute("name", "홍길동");
   response.sendRedirect("response3.jsp");
%>

<%="response3.jsp"%>