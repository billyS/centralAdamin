<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div class="table-responsive" id="clientsTable1">
		<table class="table table-striped table-hover wrapped-table">
		<thead>
			<tr>
				<th>Client ID</th>
				<th>Client Name</th>
				<th>Client Alias</th>
				<th>Client Live</th>
				<th>Client Status</th>
				<th>Client start Integration</th>
				<th>Client Shut Date</th>
				<th>Is Platform</th>
				<th>Client Admin Link</th>
				<th>Base Currency</th>
				<th>Monthly Minimum Fee</th>
				<th>Contract Signed</th>
				<th>Client Jurisdiction</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="client" items="${clientList}" varStatus="loop">
	        			<tr>
							<td id="clientId"><c:out value="${client.clientId}"/></td>
							<td><c:out value="${client.clientName}"/></td>
							<td><c:out value="${client.clientAlias}"/></td>
							<td><c:out value="${client.clientLive}"/></td>
							<td><c:out value="${client.clientStatus}"/></td>
							<td><c:out value="${client.clientStartIntegration}"/></td>
							<td><c:out value="${client.clientShutDate}"/></td>
							<td><c:out value="${client.clientIsPlatform}"/></td>
							<td><a href="${client.clientAdminLink}" target="_blank"><c:out value="${client.clientAdminLink}"/></a></td>
							<td><c:out value="${client.clientBaseCurrency}"/></td>
							<td><c:out value="${client.clientMonthleyFee}"/></td>
							<td><c:out value="${client.clientContractSigned}"/></td>
							<td><c:out value="${client.clientJuristriction}"/></td>
							<sec:authorize access="hasRole('ROLE_ADMIN')">
								<td class="align-center">
						        <div class="btn-group editBtn">
									<button 
									type="button" 
									title="Edit" 
									data-id="${client.clientId}" 
									data-clientalias="${client.clientAlias}" 
									data-clientname="${client.clientName}" 
									data-clientlive="${client.clientLive}"  
									data-clientstatus="${client.clientStatus}" 
									data-clientstartintegration="${client.clientStartIntegration}" 
									data-clientshutdate="${client.clientShutDate}" 
									data-clientplatform="${client.clientIsPlatform}"
									data-clientadminlink="${client.clientAdminLink}" 
									data-clientbasecurrency="${client.clientBaseCurrency}" 
									data-clientmonthlyfee="${client.clientMonthleyFee}" 
									data-clientcontractsigned="${client.clientContractSigned}" 
									data-clientjurisdiction="${client.clientJuristriction}" 
									class="btn btn-primary editClient">
										<span class="glyphicon glyphicon-pencil"></span>
									</button>
								</div>
								
								<div class="btn-group deleteBtn deleteClient">
									<button
										type="button"
										title="Delete"
										data-id="${client.clientId}"
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