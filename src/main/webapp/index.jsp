<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.huang.moana.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
	String str = LoginServlet.getString();
	//String str = "ww";
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%=str %></h1>
    </body>
</html>
