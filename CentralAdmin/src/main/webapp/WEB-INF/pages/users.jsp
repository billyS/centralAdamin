<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language='java' import="java.util.*,uk.co.F1x2Games.users.model.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta name="_csrf" content="${_csrf.token}"/>
    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
	<spring:url value="/resources/css/bootstrap.min.css" var="bootMinCss"/>
	<spring:url value="/resources/css/main.css" var="mainCss" />
	
	<spring:url value="/resources/js/jquery-3.1.1.min.js" var="jqueryJs" />
	<spring:url value="/resources/js/main.js" var="mainJs" />
	<spring:url value="/resources/js/common.js" var="commonJs" />
	<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapMinJs"/>


	<link href="${bootMinCss}" rel="stylesheet"/>
	<link href="${mainCss}" rel="stylesheet" />
	
    <script src="${jqueryJs}"></script>
    <script src="${bootstrapMinJs}"></script>
    <script src="${mainJs}"></script>
    <script src="${commonJs}"></script>
    <script>
		var contextpath='${contextpath}';
	</script>
</head>
<body>
	<%@ include file="userModal.jsp"%>
	<%@ include file="deleteUserModal.jsp"%>
	<%@ include file="unlockUserModal.jsp"%>
	<%@ include file="navbar.jsp"%>
	
	<sec:authorize access="hasRole('ROLE_ADMIN')"> 
		<button type="button" class="btn btn-secondary" id="createUser">Create User
			<span class="glyphicon glyphicon-user"></span>
		</button>
	</sec:authorize>
	<div class="table-responsive" id="userTable1">
	</div>
</body>
</html>