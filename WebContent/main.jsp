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
    <%! public void say(){	
    %>
    	
    	
    <%!}%>
    
    <%
	    List lists = new ArrayList();
    	System.out.println(lists.size());
    	String name = "cuicui";
	    for(int i = 0;i < 3;i++){
    %>
    	hello<%= name %>;
    	<%= lists.size()%>
    	
    <%} %>
   
</body>
</html>