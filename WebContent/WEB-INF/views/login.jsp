<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

	<c:if test="${not empty error}">
		<!-- <div class="alert alert-danger">密码或者账户错误</div>-->

		<div class="alert alert-danger">${error}</div>

	</c:if>

	<!--<c:if test="${not empty message}">
			<div class="alert alert-danger">登录已过期,请重新登录</div>
		</c:if>-->

	<c:if test="${not empty param.callback}">
		<div class="alert alert-danger">登录信息已过期，请重新登录</div>
	</c:if>

	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<form action="/login" method="post" id="formLogin">

					<fieldset>
						<legend>用户登录</legend>
					</fieldset>

					<div class="form-group">
						<label>账户</label> 
						<input type="text" class="form-control" name="username" value="${username}" /> 
						<input type="hidden" class="form-control" name="callback" value="${param.callback }">
					</div>
					<div class="form-group">
						<label>密码</label> <input type="password" class="form-control" name="password" id="password" />
					</div>

					<div class="form-group">
						<input type="checkbox" checked name="boxLogin" value="boxLogin"	id="boxLogin" />记住账号
					</div>

				</form>
				
					<div>
						<button class="btn btn-primary" id="formBtn">登录</button>
					</div>
			</div>
		</div>
	</div>

	<script src="/static/js/jquery3.js"></script>
	<script src="/static/js/jquery.cookie.js"></script>
	<script src="/static/js/jquery.validate.js"></script>
	 <script src="/static/js/cryptojs/rollups/md5.js"></script>
	<script>
		$(function() {
			$("#formLogin").validate({
				errorClass : "text-danger",
				errorElement : "span",
				rules : {
					username : {
						required : true
					},
					password : {
						required : true
					}
				},
				messages : {
					username : {
						required : "请输入账户"
					},
					password : {
						required : "请输入密码"
					}
				}

			});

			$("#formBtn").click(function() {
				//if("#boxLogin".is(":checked")){
				//	 $.cookie('boxLogin',$("#boxLogin").val{expries:3,path:'/'})
				// }
				
				var password = $("#password").val();
				
				var md5password = CryptoJS.MD5(password);
				
				$("#password").val(md5password);
					//alert($("#password"));
				$("#formLogin").submit();
			});

		});

		$(document).keydown(function() {
			if (event.keyCode == 13) {
                var password = $("#password").val();
				
				var md5password = CryptoJS.MD5(password);
				
				$("#password").val(md5password);
				//alert($("#password"));
				$("#formLogin").submit();
			}
		})
	</script>
</body>
</html>