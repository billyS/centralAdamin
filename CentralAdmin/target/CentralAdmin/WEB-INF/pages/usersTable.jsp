<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div class="table-responsive" id="userTable1">
		<table class="table table-striped table-hover wrapped-table">
		<thead>
			<tr>
				<th>User ID</th>
				<th>User Name</th>
				<th>Enabled</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email Address</th>
				<th>Role</th>
				<th>Account Expired</th>
				<th>Credentials Expired</th>
				<th>Account Locked</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${userList}" varStatus="loop">
	        			<tr>
							<td id="userId"><c:out value="${user.userId}"/></td>
							<td><c:out value="${user.username}"/></td>
							<td><c:out value="${user.enabled}"/></td>
							<td><c:out value="${user.firstName}"/></td>
							<td><c:out value="${user.lastName}"/></td>
							<td><c:out value="${user.emailAddress}"/></td>
							<td><c:out value="${user.role}"/><p></td>
							<td><c:out value="${user.accountNonExpired}"/><p></td>
							<td><c:out value="${user.credentialsNonExpired}"/><p></td>
							<td><c:out value="${user.accountNonLocked}"/><p></td>
							<sec:authorize access="hasRole('ROLE_ADMIN')">
								<td class="align-center">
								
								<div class="btn-group unlockUser">
									<button
										type="button"
										title="Unlock"
										data-id="${user.userId}"
										class="btn btn-secondary">
										<span class="glyphicon glyphicon-lock"></span>
									</button>
								</div>
								
						        <div class="btn-group editBtn">
									<button 
									type="button" 
									title="Edit" 
									data-id="${user.userId}" 
									data-username="${user.username}" 
									data-enabled="${user.enabled}" 
									data-firstname="${user.firstName}" 
									data-lastname="${user.lastName}"  
									data-emailaddress="${user.emailAddress}"
									data-role="${user.role}"
									data-accountexpired="${user.accountNonExpired}"  
									data-accountlocked="${user.accountNonLocked}"  
									data-cradentialsexpired="${user.credentialsNonExpired}"    
									class="btn btn-primary editUser">
										<span class="glyphicon glyphicon-pencil"></span>
									</button>
								</div>
								
								<div class="btn-group deleteBtn deleteUser">
									<button
										type="button"
										title="Delete"
										data-id="${user.userId}"
										class="btn btn-danger delete">
										<span class="glyphicon glyphicon-trash"></span>
									</button>
								</div>							
								</td>
							</sec:authorize>
						</tr>
			</c:forEach>
		</tbody>
	</table>
</div>