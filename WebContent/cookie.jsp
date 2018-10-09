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
<link rel="stylesheet" href="static/css/bootstrap.css" />
<body>
    <div class="container">
    	<button class="btn btn-primary" id="cookie1">设置cookie</button>
    	<button class="btn btn-success" id="cookie2">获取cookie</button>
    	<button class="btn btn-active" id="cookie3">删除cookie</button>
    </div>
    <script src="/static/js/jquery3.js"></script>
    <script src="/static/js/jquery.cookie.js"></script>
    
    <script>
    	$(function(){
    		$("#cookie1").click(function(){
    			$.cookie('name','tom',{expires: 7, path: '/'});
    		});
    		
    		$("#cookie2").click(function(){
    			
    			alert($.cookie('name'))
    		});
    		
    		$("#cookie3").click(function(){
    			$.removeCookie('name'); 
    		});
    	});
    
    </script>
</body>
</html>