<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div class="table-responsive" id="serverTable1">
		<table class="table table-striped table-hover wrapped-table">
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
	        	<tr>
	        		<td>
	        			<ul>
	        			<li id="serverId"><b>Server ID:</b><c:out value="${server.serverId}"/></li>
	        			<li id="serverApplicationLocation"><b>Server App Location: </b><c:out value="${server.serverApplicationLocation}"/></li>
	        			<li id="serverType"><b>Server Type: </b><c:out value="${server.serverType}"/></li>
	        			<li id="serverRole"><b>Server Role: </b><c:out value="${server.serverRole}"/></li>
	        			<li id="serverVersion"><b>Server Version: </b><c:out value="${server.serverVersion}"/></li>
	        			<li id="userName"><b>User Name: </b><c:out value="${server.userName}"/></li>
	        			<li id="password"><b>Password: </b><c:out value="${server.password}"/></li>
	        			<li id="hostName"><b>Host Name: </b><c:out value="${server.hostName}"/></li>
	        			<li id="IPAddress"><b>IP Address: </b><c:out value="${server.IPAddress}"/></li>
	        			<li id="monthlyCost"><b>Monthly Cost: </b><c:out value="${server.monthlyCost}"/></li>
	        			<li id="description"><b>Description: </b><c:out value="${server.description}"/></li>
	        			<li id="sslKey"><b>SSL Key: </b><c:out value="${server.sslKey}"/></li>
	        			<li id="sslExpiry"><b>SSL Expiry: </b><c:out value="${server.sslExpiry}"/></li>
	        			<li id="domainExpiryDate"><b>Domain Expiry: </b><c:out value="${server.domainExpiryDate}"/></li>
	        			<li id="provider"><b>Provider: </b><c:out value="${server.provider}"/></li>
	        			<li  id="os"><b>OS: </b><c:out value="${server.os}"/></li>
	        			<li id="osType"><b>OS Type: </b><c:out value="${server.osType}"/></li>
	        			<li id="osVersion"><b>OS Version: </b><c:out value="${server.osVersion}"/></li>
	        			<li id="descriptionPurpose"><b>Description Purpose: </b><c:out value="${server.descriptionPurpose}"/></li>
	        			<li id="machineType"><b>Machine Type: </b><c:out value="${server.machineType}"/></li>
	        			<li id="prosessor"><b>Processor: </b><c:out value="${server.prosessor}"/></li>
	        			<li id="isResinPro"><b>Resin Pro: </b><c:out value="${server.isResinPro}"/></li>
	        			<li id="resinProExpiyDate"><b>Resin Pro Expiry Date: </b><c:out value="${server.resinProExpiyDate}"/></li>
	        			<li id="sshPorts"><b>SSH Ports: </b><c:out value="${server.sshPorts}"/></li>
	        			<li id="skynetActive"><b>Skynet Active: </b><c:out value="${server.skynetActive}"/></li>
	        			<li id="skynetVersion"><b>Skynet Version: </b><c:out value="${server.skynetVersion}"/></li>
	        			<li id="offsiteBackupActive"><b>Offsite Backup Active: </b><c:out value="${server.offsiteBackupActive}"/></li>
	        			<li id="externalIPAddress"><b>External IP Address: </b><c:out value="${server.externalIPAddress}"/></li>
	        			<li id="clientId"><b>Client ID: </b><c:out value="${server.clientId}"/></li>
	        			<li id="dbArchiverStatus"><b>DB Archiver Status: </b><c:out value="${server.dbArchiverStatus}"/></li>
	        			<li id="dBArchiverRuntime"><b>DB Archiver Runtime: </b><c:out value="${server.dBArchiverRuntime}"/></li>
	        			<li id="backUpDirectory"><b>Backup Directory: </b><c:out value="${server.backUpDirectory}"/></li>
	        			<li id="backUpLocation"><b>Backup Location: </b><c:out value="${server.backUpLocation}"/></li>
	        			<li id="backupTime"><b>Backup Time: </b><c:out value="${server.backupTime}"/></li>
	        			<li id="logLifespan"><b>Log Lifespan: </b><c:out value="${server.logLifespan}"/></li>
	        			<li id="notes"><b>Notes:</b><c:out value="${server.notes}"/></li>
	        			<li id="providers"><b>Providers: </b><c:out value="${server.providers}"/></li>
	        			<li id="ram"><b>RAM: </b><c:out value="${server.ram}"/></li>
	        			<li id="cores"><b>Cores: </b><c:out value="${server.cores}"/></li>
	        			<li id="hdd"><b>HDD: </b><c:out value="${server.hdd}"/></li>
	        			</ul>
	        		</td>
	        		<sec:authorize access="hasRole('ROLE_ADMIN')">
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
					</sec:authorize>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>