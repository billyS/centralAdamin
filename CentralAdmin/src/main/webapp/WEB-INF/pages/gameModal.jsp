<!-- Modal -->
<div class="modal fade" id="gameModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Edit Game</h4>
			</div>
			<div class="modal-body">
				<div id="warningDiv" class="alert alert-info ajaxresult-info" style="display: none"></div>
				<div id="errorDiv" class="alert alert-danger ajaxresult-danger" style="display: none"></div>
				<form:form class="createGame" modelAttribute="game" method="POST"
					action="${contextpath}/saveGame">
					<div class="form-group">
						<form:hidden path="gameId" />
					</div>
					<div class="form-group">
						<form:label path="gameName">Game Name</form:label>
						<form:input name="gameName" path="gameName" />
						<form:errors path="gameName" />
					</div>
					<div class="form-group">
						<form:label path="gameType">Game Type</form:label>
						<form:input name="gameType" path="gameType" />
						<form:errors path="gameType" />
					</div>
					<div class="form-group">
						<form:label path="gameGroup">Game Group</form:label>
						<form:input name="gameGroup" path="gameGroup" />
						<form:errors path="gameGroup" />
					</div>
					<div class="form-group">
						<form:label path="gameSubGroup">Game Sub Group</form:label>
						<form:input name="gameSubGroup" path="gameSubGroup" />
						<form:errors path="gameSubGroup" />
					</div>
					<div class="form-group">
						<form:label path="gameStatus">Game Status</form:label>
						<form:input name="gameStatus" path="gameStatus" />
						<form:errors path="gameStatus" />
					</div>
					<div class="form-group">
						<form:label path="gameReleaseDate">Game Release Date</form:label>
						<form:input name="gameReleaseDate" path="gameReleaseDate" />
						<form:errors path="gameReleaseDate" />
					</div>
					<div class="form-group">
						<form:label path="version">Version</form:label>
						<form:input name="version" path="version" />
						<form:errors path="version" />
					</div>
					<div class="form-group">
						<form:label path="supplierId">Supplier ID</form:label>
						<form:input name="supplierId" path="supplierId" />
						<form:errors path="supplierId" />
					</div>
					<div class="form-group">
						<form:label path="estimatedDevCost">Estimated Dev Cost</form:label>
						<form:input name="estimatedDevCost" path="estimatedDevCost" />
						<form:errors path="estimatedDevCost" />
					</div>
					<div class="form-group">
						<form:label path="estimatedTestingCost">Estimated Testing Cost</form:label>
						<form:input name="estimatedTestingCost"
							path="estimatedTestingCost" />
						<form:errors path="estimatedTestingCost" />
					</div>
					<div class="form-group">
						<form:label path="expectedMargin">Expected Margin</form:label>
						<form:input name="expectedMargin" path="expectedMargin" />
						<form:errors path="expectedMargin" />
					</div>
					<div class="form-group">
						<form:label path="rangeMargin">Range Margin</form:label>
						<form:input name="rangeMargin" path="rangeMargin" />
						<form:errors path="rangeMargin" />
					</div>
					<div class="form-group">
						<form:label path="html5">HTML5</form:label>
						<form:input name="html5" path="html5" />
						<form:errors path="html5" />
					</div>
					<div class="form-group">
						<form:label path="flash">Flash</form:label>
						<form:input name="flash" path="flash" />
						<form:errors path="flash" />
					</div>
					<div class="form-group">
						<form:label path="desktop">Desktop</form:label>
						<form:input name="desktop" path="desktop" />
						<form:errors path="desktop" />
					</div>
					<div class="form-group">
						<form:label path="mobile">Mobile</form:label>
						<form:input name="mobile" path="mobile" />
						<form:errors path="mobile" />
					</div>
					<div class="form-group">
						<form:label path="miniGame">Mini Game</form:label>
						<form:input name="miniGame" path="miniGame" />
						<form:errors path="miniGame" />
					</div>
					<div class="modal-footer gameModalFooter">
						<input type="button" id="saveGame" value="Save"
							class="btn btn-primary">
						<button type="button" id="close" class="btn btn-default delete"
							data-dismiss="modal">Close</button>
					</div>
				</form:form>
			</div>
			<!-- /.modal-body -->
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->