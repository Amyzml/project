<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
	<%
		String username = (String)request.getAttribute("name");
		Integer money = (Integer)request.getAttribute("money");
		List<String> lists = (ArrayList<String>)request.getAttribute("list");
	%>
       <!-- <h3>欢迎<%=request.getParameter("username") %></h3>
        <h3> 您的余额为<%=request.getParameter("money") %></h3>  -->
        
        <h3>欢迎<%=username %></h3>
        <h3>你的余额<%=money %></h3>
   <ul>
   		<%
   			for(int i = 0; i < lists.size(); i++) {
   		%>
   			
   			<li><%=lists.get(i) %></li>
   		<%
   			}
   		%>
   </ul>
</body>
</html>