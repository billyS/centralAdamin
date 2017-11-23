<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="table-responsive" id="serverTable1">
		<table class="table table-striped table-hover wrapped-table">
		<thead>
			<tr>
				<th>Server ID</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="server" items="${serverList}" varStatus="loop">
	        	<tr id="server">
	        		<td class="align-center">
						    <div class="btn-group editBtn">
									<button 
									type="button" 
									title="Edit" 
									data-id="${server.serverId}" 
									data-serverapplicationlocation="${server.serverApplicationLocation}" 
									data-servertype="${server.serverType}" 
									data-serverrole="${server.serverRole}" 
									data-serverversion="${server.serverVersion}" 
									data-username="${server.userName}" 
									data-password="${server.password}" 
									data-hostname="${server.hostName}" 
									data-ipaddress="${server.IPAddress}" 
									data-monthlycost="${server.monthlyCost}" 
									data-description="${server.description}" 
									data-sslkey="${server.sslKey}" 
									data-domainexpirydate="${server.domainExpiryDate}" 
									data-provider="${server.provider}" 
									data-os="${server.os}" 
									data-ostype="${server.osType}" 
									data-osversion="${server.osVersion}" 
									data-descriptionpurpose="${server.descriptionPurpose}" 
									data-machinetype="${server.machineType}" 
									data-prosessor="${server.prosessor}" 
									data-isresinpro="${server.isResinPro}" 
									data-resinproexpiydate="${server.resinProExpiyDate}" 
									data-sshports="${server.sshPorts}" 
									data-skynetactive="${server.skynetActive}" 
									data-skynetversion="${server.skynetVersion}" 
									data-offsitebackupactive="${server.offsiteBackupActive}" 
									data-externalipaddress="${server.externalIPAddress}" 
									data-clientid="${server.clientId}"
									data-dbarchiverstatus="${server.dbArchiverStatus}" 
									data-dbarchiverruntime="${server.dBArchiverRuntime}" 
									data-backupdirectory="${server.backUpDirectory}"
									data-backuptime="${server.backupTime}"
									data-loglifespan="${server.logLifespan}"
									data-notes="${server.notes}"  
									data-providers="${server.providers}"
									data-ram="${server.ram}"
									data-cores="${server.cores}"
									data-hdd="${server.hdd}"
									class="btn btn-primary editServer">
										<span class="glyphicon glyphicon-pencil"></span>
									</button>
							</div>
							
							<div class="btn-group deleteBtn deleteServer">
									<button
										type="button"
										title="Delete"
										data-id="${server.serverId}"
										class="btn btn-danger delete">
										<span class="glyphicon glyphicon-trash"></span>
									</button>
							</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>