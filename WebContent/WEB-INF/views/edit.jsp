<%@page import="com.zml.entity.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<link rel="stylesheet" href="static/css/bootstrap.css" />
<body>

	<!-- <%
		Book book = (Book)request.getAttribute("book");	
	%> -->

	 
    <div class="container">
    	<div class="row">
    		<div class="col-md-4">
    			<form action="/edit" method="post" id="editForm">
    			
	         <fieldset>
		       <legend>修改书籍</legend>
		     </fieldset> 
           <div class="form-group">           		
           		<label>书籍名</label>
           		<input type="hidden" name="id" value="${book.id}" class="form-control"/>
           		<input type="text" name="bookname" value="${book.bname }" class="form-control" />
           </div>
        	
        	 <div class="form-group">
           		<label>书籍作者</label>
           		<input type="text" name="author" value="${book.author}" class="form-control" />
           </div>
            <div class="form-group">
           		<label>出版社</label>
           		<input type="text" name="publish" value="${book.publish}" class="form-control" />
           </div>
           <div class="form-group">
           		<label>书籍编号</label>
           		<input type="text" name="isbn" value ="${book.isbn}" class="form-control" disabled/>
           </div>
            <div class="form-group">
           		<label>总数量</label>
           		<input type="text" name="total" value="${book.much}" class="form-control" />
           </div>
           <div class="form-group">
           		<label>当前数量</label>
           		<input type="text" name="nowmuch" value="${book.nowmuch}" class="form-control" />
           </div>
           
        </form>
        <button class="btn btn-primary" id="editBtn">添加</button>  
        
    		</div>
    	</div>
        
    </div>
    
    <script src="/static/js/jquery3.js"></script>
   <script src="/static/js/jquery.validate.js"></script>
   
    <script>
    	$(function(){
    		
    		$("#editBtn").click(function(){
    			$("#editForm").submit();
    		});
    		
    	});
    </script>
</body>
</html>