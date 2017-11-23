<header class="navbar navbar-default bs-docs-nav" role="banner">
	<div class="container">
		<div class="navbar-header">
			<button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
				<span class="sr-only">Toggle navigation</span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
			</button>
			<a href="${contextpath}" class="navbar-brand">
			<img id="navImg" src="${contextpath}/resources/img/1X2.jpg">
		</a>
		</div>
		<nav class="navbar-collapse bs-navbar-collapse collapse" role="navigation" style="height: 1px;">
			<ul class="nav navbar-nav navbar-right">
				<li id="userNav" class="dropdown">
					<a href="#" data-toggle="dropdown"><span class="dropdown-toggle glyphicon glyphicon-user"></span>&nbsp;${pageContext.request.userPrincipal.name}<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a id="userNav" href="${contextpath}/users">Users</a></li>
						<li><a href="${contextpath}/servers">Servers</a></li>
						<li><a href="${contextpath}/clients">Clients</a></li>
						<li><a id="gameNav" href="${contextpath}/games">Games</a></li>
						<li><a href="${contextpath}/logs">Logs</a></li>
						<li><a href="<c:url value="/login?logout" />">Logout</a></li>
					</ul>
				</li>
			</ul>
		</nav>
	</div>
</header>