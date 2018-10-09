
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
<link rel="stylesheet" href="/static/css/bootstrap.css" />
<body>
    <div class="container">
   
    		<table class = "table">
    			<thead>
    				<tr>
    					<th>书籍名</th>
    					<th>作者</th>
    					<th>出版社</th>
    					<th>编号</th>
    					<th>总数量</th>
    					<th>当前数量<th>
    				</tr>
    			</thead>
    			<tbody>
    			
    				<c:forEach items="${page.items}" var="book">
    					<tr>
    					<td>${book.bname}</td>
    					<td>${book.author}</td>
    					<td>${book.publish}</td>
    					<td>${book.isbn}</td>
    					<td>${book.much}</td>
    					<td>${book.nowmuch}<td>
    					<td><a href="/edit?id=${book.id}">修改</a> <a href="javascript:;" class="del" rel="${book.id}">删除</a></td>
    				</tr>
	    			</c:forEach>	
    				
    			</tbody>
    		</table>
    		
    		 <ul id="pagination" class="pagination-sm pull-right"></ul> 
    		
    		  <nav aria-label="Page navigation">
				  <ul class="pagination">
				    <c:choose>
				    	<c:when test="${page.pageNow == 1}" >
				    		 <li class="disabled"><a href="javascript:;">首页</a></li>
				             <li class="disabled"><a href="javascript:;">上一页</a></li>
				    	</c:when>
				    	<c:otherwise>
				    		 <li><a href="/list">首页</a></li>
				             <li><a href="/list?p=${page.pageNow - 1}">上一页</a></li>
				    	</c:otherwise>
				    </c:choose>
				   
				   <c:choose>
				    	<c:when test="${page.pageNow == page.pageTotal}">
				    		   <li class="disabled"><a href="javascript:;">下一页</a></li>
				               <li class="disabled"><a href="javascript:;">末页</a></li>
				    	</c:when>
				    	<c:otherwise>
				    		<li><a href="/list?p=${page.pageNow + 1}">下一页</a></li>
				            <li><a href="/list?p=${page.pageTotal}">末页</a></li>
				    	</c:otherwise>
				    </c:choose> 
				   
				  </ul>
			</nav> 
    		
    		
    		 <a href="/add" class="btn btn-primary">新增书籍</a>
    		 <a href="/logout" class="btn btn-default">退出登录</a>
    	</div>
   	
    <script src="/static/js/jquery3.js"></script>
    <script src="/static/js/jquery.twbsPagination.js"></script>
   <script>
   		$(function(){
   			
   			 $("#pagination").twbsPagination({
   				totalPages: "${page.pageTotal}",
    	        visiblePages: 3,
    	        href : "/list?p={{number}}",
    	        first : "首页",
    	        last : "末页",
    	        prev : "上一页",
    	        next : "下一页"
   			});
   			
   			
   			
   			$(".del").click(function(){
   				if(confirm("确定删除吗")){
   					var id = $(this).attr("rel");
   					window.location.href="/del?id=" + id;
   				}
   			})
   			
   			
   		})   
   </script>
</body>
</html>