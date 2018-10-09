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
		String bookname = (String) request.getAttribute("bookname");
		String author = (String) request.getAttribute("author");
		String publish = (String) request.getAttribute("publish");
		String total = (String) request.getAttribute("total");
		String isbn = (String) request.getAttribute("isbn");
		
		bookname = (bookname == null ? "" : bookname);
		author = (author == null ? "" : author);
		publish = (publish == null? "" : publish);
		total = (total == null? "" : total);
		isbn = (isbn == null ? "" : isbn);
		
		String error = (String) request.getAttribute("error");
	%> -->
	
	
    <div class="container">
    	<div class="row">
    		<div class="col-md-4">
    			<form action="/add" method="post" id = "addForm">
    		
    					
    			<c:if test="${not empty error }">
    				<div class="alert alert-danger">${error}</div>
    			</c:if>
	         <fieldset>
		       <legend>增加书籍</legend>
		     </fieldset> 
           <div class="form-group">           		
           		<label>书籍名</label>
           		<input type="text" name="bookname" value="${bookname}" class="form-control" />
           </div>
        	
        	 <div class="form-group">
           		<label>书籍作者</label>
           		<input type="text" name="author" value= "${author}" class="form-control" />
           </div>
            <div class="form-group">
           		<label>出版社</label>
           		<input type="text" name="publish" value="${publish}" class="form-control" />
           </div>
           <div class="form-group">
           		<label>书籍编号</label>
           		<input type="text" name="isbn" value ="${isbn}" class="form-control" />
           </div>
            <div class="form-group">
           		<label>总数量</label>
           		<input type="text" name="total" value = "${total}" class="form-control" />
           </div>
           
        </form>
        <button class="btn btn-primary" id = "addBtn">添加</button>  
        
    		</div>
    	</div>
        
    </div>
    
    <script src="/static/js/jquery3.js"></script>
   <script src="/static/js/jquery.validate.js"></script>
   
    <script>
    	$(function(){
    		
    		$("#addBtn").click(function(){
    			$("#addForm").submit();
    		});
    		
    	});
    </script>
</body>
</html>