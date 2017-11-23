<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div class="table-responsive" id="logsTable1">
		<table class="table table-striped table-hover wrapped-table">
		<thead>
			<tr>
				<th>Log ID</th>
				<th>User ID</th>
				<th>Description</th>
				<th>Time Stamp</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="log" items="${logList}" varStatus="loop">
	        			<tr>
							<td id="id"><c:out value="${log.logId}"/></td>
							<td><c:out value="${log.userId}"/></td>
							<td><c:out value="${log.description}"/></td>
							<td><c:out value="${log.timeStamp}"/></td>
							<sec:authorize access="hasRole('ROLE_ADMIN')">
								<td class="align-center">
									<div class="btn-group deleteBtn deleteLog">
										<button
											type="button"
											title="Delete"
											data-id="${log.logId}"
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