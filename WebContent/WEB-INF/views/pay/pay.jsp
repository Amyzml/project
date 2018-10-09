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
<link rel="stylesheet" href="/static/css/bootstrap.css" />
<body>
    <div class="container">
	    <form action="/pay" method="post" >
	    	<div class="form-group">
	    	   <input type="text" class="form-control" name="money" value="${money}" placeholder="100" />
	    	   <input type="hidden" value="${token}" name="token" />
	    	</div>   
	    	<button class="btn btn-primary">支付</button>
	    </form> 
    </div>
</body>
</html>