<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <h2>我们的服务器好像挂了,请稍后再试</h2>
    
    <%
    String message = exception.getMessage();
    out.print(message);
    
    Class  type = (Class)request.getAttribute("javax.servlet.error.exception_type");
    out.print(type.getName());
    %>
</body>
</html>