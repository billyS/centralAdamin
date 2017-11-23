<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="table-responsive" id="serverTable1">
		<table class="table table-responsive table-striped table-hover wrapped-table ">
		<thead>
			<tr>
				<th>Server ID</th>
				<th>Server App Location</th>
				<th>Server Type</th>
				<th>Server Role</th>
				<th>Server Version</th>
				<th>User Name</th>
				<th>Password</th>
				<th>Host Name</th>
				<th>IP Address</th>
				<th>Monthly Cost</th>
				<th>Description</th>
				<th>SSL Key</th>
				<th>SSL Expiry</th>
				<th>Domain Expiry</th>
				<th>Provider</th>
				<th>OS</th>
				<th>OS Type</th>
				<th>OS Version</th>
				<th>Description Purpose</th>
				<th>Machine Type</th>
				<th>Processor</th>
				<th>Resin Pro</th>
				<th>Resin Pro Expiry Date</th>
				<th>SSH Ports</th>
				<th>Skynet Active</th>
				<th>Skynet Version</th>
				<th>Offsite Backup Active</th>
				<th>External IP Address</th>
				<th>Client ID</th>
				<th>DB Archiver Status</th>
				<th>DB Archiver Runtime</th>
				<th>Backup Directory</th>
				<th>Backup Location</th>
				<th>Backup Time</th>
				<th>Log Life Span</th>
				<th>Notes</th>
				<th>Providers</th>
				<th>RAM</th>
				<th>Cores</th>
				<th>HDD</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="server" items="${serverList}" varStatus="loop">
	        	<tr id="server">
	        				<td id="serverId"><c:out value="${server.serverId}"/></td>
							<td id="serverApplicationLocation"><c:out value="${server.serverApplicationLocation}"/></td>
							<td id="serverType"><c:out value="${server.serverType}"/></td>
							<td id="serverRole"><c:out value="${server.serverRole}"/></td>
							<td id="serverVersion"><c:out value="${server.serverVersion}"/></td>
							<td id="userName"><c:out value="${server.userName}"/></td>
							<td id="password"><c:out value="${server.password}"/></td>
							<td id="hostName"><c:out value="${server.hostName}"/></td>
							<td id="IPAddress"><c:out value="${server.IPAddress}"/></td>
							<td id="monthlyCost"><c:out value="${server.monthlyCost}"/></td>
							<td id="description"><c:out value="${server.description}"/></td>
							<td id="sslKey"><c:out value="${server.sslKey}"/></td>
							<td id="sslExpiry"><c:out value="${server.sslExpiry}"/></td>
							<td id="domainExpiryDate"><c:out value="${server.domainExpiryDate}"/></td>
							<td id="provider"><c:out value="${server.provider}"/></td>
							<td id="os"><c:out value="${server.os}"/></td>
							<td id="osType"><c:out value="${server.osType}"/></td>
							<td id="osVersion"><c:out value="${server.osVersion}"/></td>
							<td id="descriptionPurpose"><c:out value="${server.descriptionPurpose}"/></td>
							<td id="machineType"><c:out value="${server.machineType}"/></td>
							<td id="prosessor"><c:out value="${server.prosessor}"/></td>
							<td id="isResinPro"><c:out value="${server.isResinPro}"/></td>
							<td id="resinProExpiyDate"><c:out value="${server.resinProExpiyDate}"/></td>
							<td id="sshPorts"><c:out value="${server.sshPorts}"/></td>
							<td id="skynetActive"><c:out value="${server.skynetActive}"/></td>
							<td id="skynetVersion"><c:out value="${server.skynetVersion}"/></td>
							<td id="offsiteBackupActive"><c:out value="${server.offsiteBackupActive}"/></td>
							<td id="externalIPAddress"><c:out value="${server.externalIPAddress}"/></td>
							<td id="clientId"><c:out value="${server.clientId}"/></td>
							<td id="dbArchiverStatus"><c:out value="${server.dbArchiverStatus}"/></td>
							<td id="dBArchiverRuntime"><c:out value="${server.dBArchiverRuntime}"/></td>
							<td id="backUpDirectory"><c:out value="${server.backUpDirectory}"/></td>
							<td id="backUpLocation"><c:out value="${server.backUpLocation}"/></td>
							<td id="backupTime"><c:out value="${server.backupTime}"/></td>
							<td id="logLifespan"><c:out value="${server.logLifespan}"/></td>
							<td id="notes"><c:out value="${server.notes}"/></td>
							<td id="providers"><c:out value="${server.providers}"/></td>
							<td id="ram"><c:out value="${server.ram}"/></td>
							<td id="cores"><c:out value="${server.cores}"/></td>
							<td id="hdd"><c:out value="${server.hdd}"/></td>
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
									data-sslexpiry="${server.sslExpiry}" 
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
									data-backuplocation="${server.backUpLocation}"
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