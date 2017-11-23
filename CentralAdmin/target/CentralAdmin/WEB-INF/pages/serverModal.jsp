<!-- Modal -->
<div class="modal fade" id="serverModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
       <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4 class="modal-title" id="myModalLabel">Edit Server</h4>
        </div>
        	<div class="modal-body">
        	<div id="warningDiv" class="alert alert-info ajaxresult-info" style="display: none"></div>
			<div id="errorDiv" class="alert alert-danger ajaxresult-danger" style="display: none"></div>
			<form:form class="createServer" modelAttribute="server" method="POST" action="${contextpath}/saveServer">
						<div class="form-group">
	                        <form:hidden path="serverId"/>
	                    </div>
	                    <div class="form-group">
	                        <form:label path="clientId">Client Id</form:label>
	                        <form:input name="clientId" path="clientId"/>
	                        <form:errors path="clientId"/>
	                    </div>
	                     <div class="form-group">
	                        <form:label path="serverApplicationLocation">Server App Location</form:label>
	                        <form:input name="serverApplicationLocation" path="serverApplicationLocation"/>
	                        <form:errors path="serverApplicationLocation"/>
	                    </div>
	                     <div class="form-group">
	                        <form:label path="serverType">Server Type</form:label>
	                        <form:input name="serverType" path="serverType"/>
	                        <form:errors path="serverType"/>
	                    </div>
	                     <div class="form-group">
	                        <form:label path="serverRole">Server Role</form:label>
	                        <form:input name="serverRole" path="serverRole"/>
	                        <form:errors path="serverRole"/>
	                    </div>
	                     <div class="form-group">
	                        <form:label path="serverVersion">Server Version</form:label>
	                        <form:input name="serverVersion" path="serverVersion"/>
	                        <form:errors path="serverVersion"/>
	                    </div>
	                     <div class="form-group">
	                        <form:label path="userName">User Name</form:label>
	                        <form:input name="userName" path="userName"/>
	                        <form:errors path="userName"/>
	                    </div>
	                     <div class="form-group">
	                        <form:label path="password">Password</form:label>
	                        <form:input name="password" path="password"/>
	                        <form:errors path="password"/>
	                    </div>
	                     <div class="form-group">
	                        <form:label path="hostName">Host Name</form:label>
	                        <form:input name="hostName" path="hostName"/>
	                        <form:errors path="hostName"/>
	                    </div>
	                     <div class="form-group">
	                        <form:label path="IPAddress">IP Address</form:label>
	                        <form:input name="IPAddress" path="IPAddress"/>
	                        <form:errors path="IPAddress"/>
	                    </div>
	                     <div class="form-group">
	                        <form:label path="monthlyCost">Monthly Cost</form:label>
	                        <form:input name="monthlyCost" path="monthlyCost"/>
	                        <form:errors path="monthlyCost"/>
	                    </div>
	                     <div class="form-group">
	                        <form:label path="description">Description</form:label>
	                        <form:input name="description" path="description"/>
	                        <form:errors path="description"/>
	                    </div>
	                     <div class="form-group">
	                        <form:label path="sslKey">SSL Key</form:label>
	                        <form:input name="sslKey" path="sslKey"/>
	                        <form:errors path="sslKey"/>
	                    </div>
	                     <div class="form-group">
	                        <form:label path="sslExpiry">SSL Expiry</form:label>
	                        <form:input name="sslExpiry" path="sslExpiry"/>
	                        <form:errors path="sslExpiry"/>
	                    </div>
	                     <div class="form-group">
	                        <form:label path="domainExpiryDate">Domain Expiry Date</form:label>
	                        <form:input name="domainExpiryDate" path="domainExpiryDate"/>
	                        <form:errors path="domainExpiryDate"/>
	                    </div>
	                     <div class="form-group">
	                        <form:label path="provider">Provider</form:label>
	                        <form:input name="provider" path="provider"/>
	                        <form:errors path="provider"/>
	                    </div>
	                     <div class="form-group">
	                        <form:label path="os">OS</form:label>
	                        <form:input name="os" path="os"/>
	                        <form:errors path="os"/>
	                    </div>
	                     <div class="form-group">
	                        <form:label path="osType">OS Type</form:label>
	                        <form:input name="osType" path="osType"/>
	                        <form:errors path="osType"/>
	                    </div>
	                     <div class="form-group">
	                        <form:label path="osVersion">OS Version</form:label>
	                        <form:input name="osVersion" path="osVersion"/>
	                        <form:errors path="osVersion"/>
	                    </div>
	                     <div class="form-group">
	                        <form:label path="descriptionPurpose">Description Purpose</form:label>
	                        <form:input name="descriptionPurpose" path="descriptionPurpose"/>
	                        <form:errors path="descriptionPurpose"/>
	                    </div>
	                     <div class="form-group">
	                        <form:label path="machineType">Machine Type</form:label>
	                        <form:input name="machineType" path="machineType"/>
	                        <form:errors path="machineType"/>
	                    </div>
	                     <div class="form-group">
	                        <form:label path="prosessor">Processor</form:label>
	                        <form:input name="prosessor" path="prosessor"/>
	                        <form:errors path="prosessor"/>
	                    </div>
	                     <div class="form-group">
	                        <form:label path="isResinPro">Resin Pro</form:label>
	                        <form:input name="isResinPro" path="isResinPro"/>
	                        <form:errors path="isResinPro"/>
	                    </div>
	                     <div class="form-group">
	                        <form:label path="resinProExpiyDate">Resin Pro Expiy Date</form:label>
	                        <form:input name="resinProExpiyDate" path="resinProExpiyDate"/>
	                        <form:errors path="resinProExpiyDate"/>
	                    </div>
	                     <div class="form-group">
	                        <form:label path="sshPorts">SSH Ports</form:label>
	                        <form:input name="sshPorts" path="sshPorts"/>
	                        <form:errors path="sshPorts"/>
	                    </div>
	                     <div class="form-group">
	                        <form:label path="skynetActive">Skynet Active</form:label>
	                        <form:input name="skynetActive" path="skynetActive"/>
	                        <form:errors path="skynetActive"/>
	                    </div>
	                     <div class="form-group">
	                        <form:label path="skynetVersion">Skynet Version</form:label>
	                        <form:input name="skynetVersion" path="skynetVersion"/>
	                        <form:errors path="skynetVersion"/>
	                    </div>
	                     <div class="form-group">
	                        <form:label path="offsiteBackupActive">Offsite Backup Active</form:label>
	                        <form:input name="offsiteBackupActive" path="offsiteBackupActive"/>
	                        <form:errors path="offsiteBackupActive"/>
	                    </div>
	                     <div class="form-group">
	                        <form:label path="externalIPAddress">External IP Address</form:label>
	                        <form:input name="externalIPAddress" path="externalIPAddress"/>
	                        <form:errors path="externalIPAddress"/>
	                    </div>
	                    <div class="form-group">
	                        <form:label path="dbArchiverStatus">DB Archiver Status</form:label>
	                        <form:input name="dbArchiverStatus" path="dbArchiverStatus"/>
	                        <form:errors path="dbArchiverStatus"/>
	                    </div>
	                    <div class="form-group">
	                        <form:label path="dBArchiverRuntime">DB Archiver Runtime</form:label>
	                        <form:input name="dBArchiverRuntime" path="dBArchiverRuntime"/>
	                        <form:errors path="dBArchiverRuntime"/>
	                    </div>
	                    <div class="form-group">
	                        <form:label path="backUpDirectory">Backup Directory</form:label>
	                        <form:input name="backUpDirectory" path="backUpDirectory"/>
	                        <form:errors path="backUpDirectory"/>
	                    </div>
	                    <div class="form-group">
	                        <form:label path="backUpLocation">Backup Location</form:label>
	                        <form:input name="backUpLocation" path="backUpLocation"/>
	                        <form:errors path="backUpLocation"/>
	                    </div>
	                    <div class="form-group">
	                        <form:label path="backupTime">Backup Time</form:label>
	                        <form:input name="backupTime" path="backupTime"/>
	                        <form:errors path="backupTime"/>
	                    </div>
	                    <div class="form-group">
	                        <form:label path="logLifespan">Log Lifespan</form:label>
	                        <form:input name="logLifespan" path="logLifespan"/>
	                        <form:errors path="logLifespan"/>
	                    </div>
	                    <div class="form-group">
	                        <form:label path="notes">Notes</form:label>
	                        <form:input name="notes" path="notes"/>
	                        <form:errors path="notes"/>
	                    </div>
	                    <div class="form-group">
	                        <form:label path="providers">Providers</form:label>
	                        <form:input name="providers" path="providers"/>
	                        <form:errors path="providers"/>
	                    </div>
	                    <div class="form-group">
	                        <form:label path="ram">RAM</form:label>
	                        <form:input name="ram" path="ram"/>
	                        <form:errors path="ram"/>
	                    </div>
	                    <div class="form-group">
	                        <form:label path="cores">Cores</form:label>
	                        <form:input name="cores" path="cores"/>
	                        <form:errors path="cores"/>
	                    </div>
	                    <div class="form-group">
	                        <form:label path="hdd">HDD</form:label>
	                        <form:input name="hdd" path="hdd"/>
	                        <form:errors path="hdd"/>
	                    </div>
				<div class="modal-footer serverModalFooter">
					<input type="button" id="saveServer" value="Save" class="btn btn-primary">
			        <button type="button" id="close" class="btn btn-default delete" data-dismiss="modal">Close</button>
			    </div>
			</form:form>
		</div><!-- /.modal-body --> 
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->