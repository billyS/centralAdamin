<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<spring:url value="/resources/css/bootstrap.min.css" var="bootMinCss"/>
	<spring:url value="/resources/css/main.css" var="mainCss"/>
	
	<spring:url value="/resources/js/jquery-3.1.1.min.js" var="jqueryJs" />
	<spring:url value="/resources/js/main.js" var="mainJs" />
	<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapMinJs"/>
	<spring:url value="/resources/js/common.js" var="commonJs" />
	<spring:url value="/resources/js/login.js" var="loginJs" />


	<link href="${bootMinCss}" rel="stylesheet"/>
	<link href="${mainCss}" rel="stylesheet"/>
	
    <script src="${jqueryJs}" ></script>
    <script src="${bootstrapMinJs}"></script>
    <script src="${mainJs}" ></script>
    <script src="${commonJs}"></script>
    <script src="${loginJs}"></script>  
     
    <script> var contextpath='${contextpath}';</script>
</head>

<body onload='document.loginForm.username.focus();'>
<%@ include file="forgotModal.jsp"%>
	<h1>${title}</h1>
	<h1>${message}</h1>


	<div id="login-box">

		<h3>F1x2 Gaming Central Administration Login</h3>

		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
		
		<form name='loginForm' action="<c:url value='/auth/login_check?targetUrl=${targetUrl}' />" method='POST'>
			<div class="form-group">
				<div id="emailError" class="alert alert-danger" style="display:none;"></div> 
				<label for="email">Email
					<input  class="form-control" id="email" type="email" name="username" placeholder="Email">
				</label> 
			</div>
			<div class="form-group">
				<label for="password">Password
					<input class="form-control" id="password" type="password" name="password" placeholder="Password">
				</label>
			</div>
			<input id="login"class="btn btn-primary" name="submit" type="submit" value="Login">
			<a id="forgotPass">forgot password</a>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</div>
</body>
</html>