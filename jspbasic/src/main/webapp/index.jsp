<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<%!
   public void printSum(int a, int b){
   System.out.println("합계 :" + (a+b));
   }
%>
<%--JSP주석 :서버주석/tomcat이 java변환 시 빠짐/파싱x--%>
<!-- HTML주석 :web browser에서의 주석 -->
<%="jspbasic index.jsp" %>
<%
   //JAVA주석
   //스크립트릿(scriptlet/스크립트조각) 내에 선언한 변수는 _jspService메소드의 지역변수
   //스크립트릿 내에서는 메소드 선언이 불가능
   int i =3;
   int j =5;
   //out-jsp내장객채
   out.print("<br>합계 : "+(i+j));
   printSum(i,j);
%>
</body>
</html>