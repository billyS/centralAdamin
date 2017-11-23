<!-- Modal -->
<div class="modal fade" id="clientModal" tabindex="-1" role="dialog"
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
				<form:form class="createClient" modelAttribute="client"
					method="POST" action="${contextpath}/saveClient">
					<div class="form-group">
						<form:hidden path="clientId" />
					</div>
					<div class="form-group">
						<form:label path="clientName">Client Name</form:label>
						<form:input name="clientName" path="clientName" />
						<form:errors path="clientName" />
					</div>
					<div class="form-group">
						<form:label path="clientAlias">Client Alias</form:label>
						<form:input name="clientAlias" path="clientAlias" />
						<form:errors path="clientAlias" />
					</div>
					<div class="form-group">
						<form:label path="clientLive">Client Live</form:label>
						<form:input name="clientLive" path="clientLive" />
						<form:errors path="clientLive" />
					</div>
					<div class="form-group">
						<form:label path="clientStatus">Client Status</form:label>
						<form:input name="clientStatus" path="clientStatus" />
						<form:errors path="clientStatus" />
					</div>
					<div class="form-group">
						<form:label path="clientStartIntegration">Client start Integration</form:label>
						<form:input name="clientStartIntegration"
							path="clientStartIntegration" />
						<form:errors path="clientStartIntegration" />
					</div>
					<div class="form-group">
						<form:label path="clientShutDate">Client Shut Date</form:label>
						<form:input name="clientShutDate" path="clientShutDate" />
						<form:errors path="clientShutDate" />
					</div>
					<div class="form-group">
						<form:label path="clientIsPlatform">Is Platform</form:label>
						<form:input name="clientIsPlatform" path="clientIsPlatform" />
						<form:errors path="clientIsPlatform" />
					</div>
					<div class="form-group">
						<form:label path="clientAdminLink">Client Admin Link</form:label>
						<form:input name="clientAdminLink" path="clientAdminLink" />
						<form:errors path="clientAdminLink" />
					</div>
					<div class="form-group">
						<form:label path="clientBaseCurrency">Base Currency</form:label>
						<form:input name="clientBaseCurrency" path="clientBaseCurrency" />
						<form:errors path="clientBaseCurrency" />
					</div>
					<div class="form-group">
						<form:label path="clientMonthleyFee">Monthly Minimum Fee</form:label>
						<form:input name="clientMonthleyFee" path="clientMonthleyFee" />
						<form:errors path="clientMonthleyFee" />
					</div>
					<div class="form-group">
						<form:label path="clientContractSigned">Contract Signed</form:label>
						<form:input name="clientContractSigned"
							path="clientContractSigned" />
						<form:errors path="clientContractSigned" />
					</div>
					<div class="form-group">
						<form:label path="clientJuristriction">Client Jurisdiction</form:label>
						<form:input name="clientJuristriction" path="clientJuristriction" />
						<form:errors path="clientJuristriction" />
					</div>
					<div class="modal-footer clientModalFooter">
						<input type="button" id="saveClient" value="Save"
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