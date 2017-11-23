<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div class="table-responsive" id="gamesTable1">
		<table class="table table-striped table-hover wrapped-table">
		<thead>
			<tr>
				<th>Game Id</th>
				<th>Game Name</th>
				<th>Game Type</th>
				<th>Game Group</th>
				<th>Game Sub Group</th>
				<th>Game Status</th>
				<th>Game Release Date</th>
				<th>Version</th>
				<th>Supplier ID</th>
				<th>Estimated Dev Cost</th>
				<th>Estimated Testing Cost</th>
				<th>Expected Margin</th>
				<th>Range Margin</th>
				<th>HTML5</th>
				<th>Flash</th>
				<th>Desktop</th>
				<th>Mobile</th>
				<th>Mini Game</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="game" items="${gameList}" varStatus="loop">
						<tr>
							<td id="userId"><c:out value="${game.gameId}"/></td>
							<td><c:out value="${game.gameName}"/></td>
							<td><c:out value="${game.gameType}"/></td>
							<td><c:out value="${game.gameGroup}"/></td>
							<td><c:out value="${game.gameSubGroup}"/></td>
							<td><c:out value="${game.gameStatus}"/></td>
							<td><c:out value="${game.gameReleaseDate}"/></td>
							<td><c:out value="${game.version}"/></td>
							<td><c:out value="${game.supplierId}"/></td>
							<td><c:out value="${game.estimatedDevCost}"/></td>
							<td><c:out value="${game.estimatedTestingCost}"/></td>
							<td><c:out value="${game.expectedMargin}"/></td>
							<td><c:out value="${game.rangeMargin}"/></td>
							<td><c:out value="${game.html5}"/></td>
							<td><c:out value="${game.flash}"/></td>
							<td><c:out value="${game.desktop}"/></td>
							<td><c:out value="${game.mobile}"/></td>
							<td><c:out value="${game.miniGame}"/></td>
							<sec:authorize access="hasRole('ROLE_ADMIN')">
								<td class="align-center">
							        <div class="btn-group editBtn">
										<button 
										type="button" 
										title="Edit" 
										data-id="${game.gameId}" 
										data-gamename="${game.gameName}" 
										data-gametype="${game.gameType}" 
										data-gamegroup="${game.gameGroup}"  
										data-gamesubgroup="${game.gameSubGroup}" 
										data-status="${game.gameStatus}" 
										data-releasedate="${game.gameReleaseDate}" 
										data-version="${game.version}" 
										data-supplierid="${game.supplierId}" 
										data-estimatedevcost="${game.estimatedDevCost}" 
										data-estimatetestingcost="${game.estimatedTestingCost}" 
										data-expectedmargin="${game.expectedMargin}" 
										data-rangemargin="${game.rangeMargin}" 
										data-html5="${game.html5}" 
										data-flash="${game.flash}" 
										data-desktop="${game.desktop}" 
										data-mobile="${game.mobile}" 
										data-miniGame="${game.miniGame}" 
										class="btn btn-primary editGame">
											<span class="glyphicon glyphicon-pencil"></span>
										</button>
									</div>
								
									<div class="btn-group deleteBtn deleteGame">
										<button
											type="button"
											title="Delete"
											data-id="${game.gameId}"
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