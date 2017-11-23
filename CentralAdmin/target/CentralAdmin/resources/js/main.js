$( document ).ready(function() {

	var deleteId;
	var deleteId2;
	var deleteId3;
	var deleteId4;
	var deleteId5;
	var unlockId;

	$.ajaxSetup({ headers: {  'X-CSRF-Token': $('meta[name="_csrf"]').attr('content') }
	});
	
	$('#forgotPass').on('click', function(){
		$('#forgotModal').modal('show');
	});
	
	$('#confirmPasswordReminder').on('click', function(){
		
		
		
		$('#forgotModal').modal('hide');
	});
	

	$('#logsTable1').load(contextpath +'/getLogsTable',  function(e) {

		$('.deleteLog').on('click', function(e) {
			deleteId5 = $(this).find('button:first').data("id");
			$('#confirmDeleteLogModal').data('id',$(this).data('id'));
			$('#confirmDeleteLogModal').modal('show');
		});
		
	}).fadeIn();

	$('#userTable1').load(contextpath +'/getUsersTable',  function(e) {

		$('.editUser').on('click', function(e) {
			$('#create').val('save');
			$('#create').attr('id', 'save');
			$('#password').prop('hidden', 'hidden');
			$('label[for=password]').remove();
			$('#userModal').data('id',$(this).data('id'));
			$('#userModal').data('username',$(this).data('username'));
			$('#userModal').data('enabled',$(this).data('enabled'));
			$('#userModal').data('firstname',$(this).data('firstname'));
			$('#userModal').data('lastname',$(this).data('lastname'));
			$('#userModal').data('emailaddress',$(this).data('emailaddress'));
			$('#userModal').data('role',$(this).data('role'));
			$('#userModal').data('accountlocked',$(this).data('accountlocked'));
			$('#userModal').data('accountexpired',$(this).data('accountexpired'));
			$('#userModal').data('cradentialsexpired',$(this).data('cradentialsexpired'));
			$('#userModal').modal('show');
		});

		$('.deleteUser').on('click', function(e) {
			deleteId = $(this).find('button:first').data("id");
			$('#confirmDeleteUserModal').data('id',$(this).data('id'));
			$('#confirmDeleteUserModal').modal('show');
		});

		$('.unlockUser').on('click', function(e) {

			unlockId = $(this).find('button:first').data("id");		
			$('#unlockUserModal').data('id',$(this).data('id'));
			$('#unlockUserModal').modal('show');	
		});

	}).fadeIn();

	$('#gamesTable1').load(contextpath +'/getGamesTable',  function(e) {

		$('.editGame').on('click', function(e) {
			$('#create').val('save');
			$('#create').attr('id', 'save');
			$('#gameModal').data('id',$(this).data('id'));
			$('#gameModal').data('gamename',$(this).data('gamename'));
			$('#gameModal').data('gametype',$(this).data('gametype'));
			$('#gameModal').data('gamegroup',$(this).data('gamegroup'));
			$('#gameModal').data('gamesubgroup',$(this).data('gamesubgroup'));
			$('#gameModal').data('status',$(this).data('status'));
			$('#gameModal').data('gamereleasedate',$(this).data('releasedate'));
			$('#gameModal').data('version',$(this).data('version'));
			$('#gameModal').data('supplierid',$(this).data('supplierid'));
			$('#gameModal').data('estimatedevcost',$(this).data('estimatedevcost'));
			$('#gameModal').data('estimatetestingcost',$(this).data('estimatetestingcost'));
			$('#gameModal').data('expectedmargin',$(this).data('expectedmargin'));
			$('#gameModal').data('rangemargin',$(this).data('rangemargin'));
			$('#gameModal').data('html5',$(this).data('html5'));
			$('#gameModal').data('flash',$(this).data('flash'));
			$('#gameModal').data('desktop',$(this).data('desktop'));
			$('#gameModal').data('mobile',$(this).data('mobile'));
			$('#gameModal').data('minigame',$(this).data('minigame'));
			$('#gameModal').modal('show');
		});

		$('.deleteGame').on('click', function(e) {
			deleteId2 = $(this).find('button:first').data("id");
			$('#confirmDeleteGameModal').data('id',$(this).data('id'));
			$('#confirmDeleteGameModal').modal('show');
		});

	}).fadeIn();

	$('#clientsTable1').load(contextpath +'/getClientsTable',  function(e) {
		$('.editClient').on('click', function(e) {
			$('#create').val('save');
			$('#create').attr('id', 'save');
			$('#clientModal').data('id',$(this).data('id'));
			$('#clientModal').data('clientalias',$(this).data('clientalias'));
			$('#clientModal').data('clientname',$(this).data('clientname'));
			$('#clientModal').data('clientlive',$(this).data('clientlive'));
			$('#clientModal').data('clientstatus',$(this).data('clientstatus'));
			$('#clientModal').data('clientstartintegration',$(this).data('clientstartintegration'));
			$('#clientModal').data('clientshutdate',$(this).data('clientshutdate'));
			$('#clientModal').data('clientplatform',$(this).data('clientplatform'));
			$('#clientModal').data('clientadminlink',$(this).data('clientadminlink'));
			$('#clientModal').data('clientbasecurrency',$(this).data('clientbasecurrency'));
			$('#clientModal').data('clientmonthlyfee',$(this).data('clientmonthlyfee'));
			$('#clientModal').data('clientcontractsigned',$(this).data('clientcontractsigned'));
			$('#clientModal').data('clientjurisdiction',$(this).data('clientjurisdiction'));
			$('#clientModal').modal('show');
		});

		$('.deleteClient').on('click', function(e) {
			deleteId3 = $(this).find('button:first').data("id");
			$('#confirmDeleteClientModal').data('id',$(this).data('id'));
			$('#confirmDeleteClientModal').modal('show');
		});
	}).fadeIn();

	$('#serversTable1').load(contextpath +'/getServerTable',  function(e) {

		$('.editServer').on('click', function(e) {
			$('#createServer1').val('save');
			$('#createServer1').attr('id', 'saveServer');
			$('#serverModal').data('id',$(this).data('id'));
			$('#serverModal').data('serverapplicationlocation',$(this).data('serverapplicationlocation'));
			$('#serverModal').data('servertype',$(this).data('servertype'));
			$('#serverModal').data('serverrole',$(this).data('serverrole'));
			$('#serverModal').data('serverversion',$(this).data('serverversion'));
			$('#serverModal').data('username',$(this).data('username'));
			$('#serverModal').data('password',$(this).data('password'));
			$('#serverModal').data('hostname',$(this).data('hostname'));
			$('#serverModal').data('ipaddress',$(this).data('ipaddress'));
			$('#serverModal').data('monthlycost',$(this).data('monthlycost'));
			$('#serverModal').data('description',$(this).data('description'));
			$('#serverModal').data('sslkey',$(this).data('sslkey'));
			$('#serverModal').data('sslexpiry',$(this).data('sslexpiry'));
			$('#serverModal').data('domainexpirydate',$(this).data('domainexpirydate'));
			$('#serverModal').data('provider',$(this).data('provider'));
			$('#serverModal').data('os',$(this).data('os'));
			$('#serverModal').data('ostype',$(this).data('ostype'));
			$('#serverModal').data('osversion',$(this).data('osversion'));
			$('#serverModal').data('descriptionpurpose',$(this).data('descriptionpurpose'));
			$('#serverModal').data('machinetype',$(this).data('machinetype'));
			$('#serverModal').data('prosessor',$(this).data('prosessor'));
			$('#serverModal').data('isresinpro',$(this).data('isresinpro'));
			$('#serverModal').data('resinproexpiydate',$(this).data('resinproexpiydate'));
			$('#serverModal').data('sshports',$(this).data('sshports'));
			$('#serverModal').data('skynetactive',$(this).data('skynetactive'));
			$('#serverModal').data('skynetversion',$(this).data('skynetversion'));
			$('#serverModal').data('offsitebackupactive',$(this).data('offsitebackupactive'));
			$('#serverModal').data('externalipaddress',$(this).data('externalipaddress'));
			$('#serverModal').data('clientid',$(this).data('clientid'));
			$('#serverModal').data('dbarchiverstatus',$(this).data('dbarchiverstatus'));
			$('#serverModal').data('dbarchiverruntime',$(this).data('dbarchiverruntime'));
			$('#serverModal').data('backupdirectory',$(this).data('backupdirectory'));
			$('#serverModal').data('backuplocation',$(this).data('backuplocation'));
			$('#serverModal').data('backuptime',$(this).data('backuptime'));
			$('#serverModal').data('loglifespan',$(this).data('loglifespan'));
			$('#serverModal').data('notes',$(this).data('notes'));
			$('#serverModal').data('providers',$(this).data('providers'));
			$('#serverModal').data('ram',$(this).data('ram'));
			$('#serverModal').data('cores',$(this).data('cores'));
			$('#serverModal').data('hdd',$(this).data('hdd'));
			$('#serverModal').modal('show');
		});

		$('.deleteServer').on('click', function(e) {
			deleteId4 = $(this).find('button:first').data("id");
			$('#confirmDeleteServerModal').data('id',$(this).data('id'));
			$('#confirmDeleteServerModal').modal('show');
		});

	}).fadeIn();



	$('#userModal').on('show.bs.modal', function(e) {
		//populate the textbox
		$('#myModalLabel').text('Edit User');
		$(e.currentTarget).find('input[name="userId"]').val($(this).data('id'));
		$(e.currentTarget).find('input[name="username"]').val($(this).data('username'));
		$(e.currentTarget).find('input[name="enabled"]').val($(this).data('enabled'));
		$(e.currentTarget).find('input[name="firstName"]').val($(this).data('firstname'));
		$(e.currentTarget).find('input[name="lastName"]').val($(this).data('lastname'));
		$(e.currentTarget).find('input[name="emailAddress"]').val($(this).data('emailaddress'));
		$(e.currentTarget).find('input[name="role"]').val($(this).data('role'));
		$(e.currentTarget).find('input[name="accountLocked"]').val($(this).data('accountlocked'));
		$(e.currentTarget).find('input[name="accountExpired"]').val($(this).data('accountexpired'));
		$(e.currentTarget).find('input[name="cradentialsExpired"]').val($(this).data('cradentialsexpired'));
	});

	$('#gameModal').on('show.bs.modal', function(e) {
		//populate the textbox
		$('#myModalLabel').text('Edit Game');
		$('#createClient1').val('save');
		$('#createClient1').attr('id', 'save');
		$(e.currentTarget).find('input[name="gameId"]').val($(this).data('id'));
		$(e.currentTarget).find('input[name="gameName"]').val($(this).data('gamename'));
		$(e.currentTarget).find('input[name="gameType"]').val($(this).data('gametype'));
		$(e.currentTarget).find('input[name="gameGroup"]').val($(this).data('gamegroup'));
		$(e.currentTarget).find('input[name="gameSubGroup"]').val($(this).data('gamesubgroup'));
		$(e.currentTarget).find('input[name="gameStatus"]').val($(this).data('status'));
		$(e.currentTarget).find('input[name="gameReleaseDate"]').val($(this).data('gamereleasedate'));
		$(e.currentTarget).find('input[name="version"]').val($(this).data('version'));
		$(e.currentTarget).find('input[name="supplierId"]').val($(this).data('supplierid'));
		$(e.currentTarget).find('input[name="estimatedDevCost"]').val($(this).data('estimatedevcost'));
		$(e.currentTarget).find('input[name="estimatedTestingCost"]').val($(this).data('estimatetestingcost'));
		$(e.currentTarget).find('input[name="expectedMargin"]').val($(this).data('expectedmargin'));
		$(e.currentTarget).find('input[name="rangeMargin"]').val($(this).data('rangemargin'));
		$(e.currentTarget).find('input[name="html5"]').val($(this).data('html5'));
		$(e.currentTarget).find('input[name="flash"]').val($(this).data('flash'));
		$(e.currentTarget).find('input[name="desktop"]').val($(this).data('desktop'));
		$(e.currentTarget).find('input[name="mobile"]').val($(this).data('mobile'));
		$(e.currentTarget).find('input[name="miniGame"]').val($(this).data('minigame'));

	});

	$('#clientModal').on('show.bs.modal', function(e) {
		//populate the textbox
		$('#myModalLabel').text('Edit Client');
		$(e.currentTarget).find('input[name="clientId"]').val($(this).data('id'));
		$(e.currentTarget).find('input[name="clientName"]').val($(this).data('clientname'));
		$(e.currentTarget).find('input[name="clientAlias"]').val($(this).data('clientalias'));
		$(e.currentTarget).find('input[name="clientLive"]').val($(this).data('clientlive'));
		$(e.currentTarget).find('input[name="clientStatus"]').val($(this).data('clientstatus'));
		$(e.currentTarget).find('input[name="clientStartIntegration"]').val($(this).data('clientstartintegration'));
		$(e.currentTarget).find('input[name="clientShutDate"]').val($(this).data('clientshutdate'));
		$(e.currentTarget).find('input[name="clientIsPlatform"]').val($(this).data('clientplatform'));
		$(e.currentTarget).find('input[name="clientAdminLink"]').val($(this).data('clientadminlink'));
		$(e.currentTarget).find('input[name="clientBaseCurrency"]').val($(this).data('clientbasecurrency'));
		$(e.currentTarget).find('input[name="clientMonthleyFee"]').val($(this).data('clientmonthlyfee'));
		$(e.currentTarget).find('input[name="clientContractSigned"]').val($(this).data('clientcontractsigned'));
		$(e.currentTarget).find('input[name="clientJuristriction"]').val($(this).data('clientjurisdiction'));
	});

	$('#serverModal').on('show.bs.modal', function(e) {
		//populate the textbox
		$('#myModalLabel').text('Edit Server');
		$(e.currentTarget).find('input[name="serverId"]').val($(this).data('id'));
		$(e.currentTarget).find('input[name="serverApplicationLocation"]').val($(this).data('serverapplicationlocation'));
		$(e.currentTarget).find('input[name="serverType"]').val($(this).data('servertype'));
		$(e.currentTarget).find('input[name="serverRole"]').val($(this).data('serverrole'));
		$(e.currentTarget).find('input[name="serverVersion"]').val($(this).data('serverversion'));
		$(e.currentTarget).find('input[name="userName"]').val($(this).data('username'));
		$(e.currentTarget).find('input[name="password"]').val($(this).data('password'));
		$(e.currentTarget).find('input[name="hostName"]').val($(this).data('hostname'));
		$(e.currentTarget).find('input[name="IPAddress"]').val($(this).data('ipaddress'));
		$(e.currentTarget).find('input[name="monthlyCost"]').val($(this).data('monthlycost'));
		$(e.currentTarget).find('input[name="description"]').val($(this).data('description'));
		$(e.currentTarget).find('input[name="sslKey"]').val($(this).data('sslkey'));
		$(e.currentTarget).find('input[name="sslExpiry"]').val($(this).data('sslexpiry'));
		$(e.currentTarget).find('input[name="domainExpiryDate"]').val($(this).data('domainexpirydate'));
		$(e.currentTarget).find('input[name="provider"]').val($(this).data('provider'));
		$(e.currentTarget).find('input[name="os"]').val($(this).data('os'));
		$(e.currentTarget).find('input[name="osType"]').val($(this).data('ostype'));
		$(e.currentTarget).find('input[name="osVersion"]').val($(this).data('osversion'));
		$(e.currentTarget).find('input[name="descriptionPurpose"]').val($(this).data('descriptionpurpose'));
		$(e.currentTarget).find('input[name="machineType"]').val($(this).data('machinetype'));
		$(e.currentTarget).find('input[name="prosessor"]').val($(this).data('prosessor'));
		$(e.currentTarget).find('input[name="isResinPro"]').val($(this).data('isresinpro'));
		$(e.currentTarget).find('input[name="resinProExpiyDate"]').val($(this).data('resinproexpiydate'));
		$(e.currentTarget).find('input[name="sshPorts"]').val($(this).data('sshports'));
		$(e.currentTarget).find('input[name="skynetActive"]').val($(this).data('skynetactive'));
		$(e.currentTarget).find('input[name="skynetVersion"]').val($(this).data('skynetversion'));
		$(e.currentTarget).find('input[name="offsiteBackupActive"]').val($(this).data('offsitebackupactive'));
		$(e.currentTarget).find('input[name="externalIPAddress"]').val($(this).data('externalipaddress'));
		$(e.currentTarget).find('input[name="clientId"]').val($(this).data('clientid'));
		$(e.currentTarget).find('input[name="dbArchiverStatus"]').val($(this).data('dbarchiverstatus'));
		$(e.currentTarget).find('input[name="dBArchiverRuntime"]').val($(this).data('dbarchiverruntime'));
		$(e.currentTarget).find('input[name="backUpDirectory"]').val($(this).data('backupdirectory'));
		$(e.currentTarget).find('input[name="backUpLocation"]').val($(this).data('backuplocation'));
		$(e.currentTarget).find('input[name="backupTime"]').val($(this).data('backuptime'));
		$(e.currentTarget).find('input[name="logLifespan"]').val($(this).data('loglifespan'));
		$(e.currentTarget).find('input[name="notes"]').val($(this).data('notes'));
		$(e.currentTarget).find('input[name="providers"]').val($(this).data('providers'));
		$(e.currentTarget).find('input[name="ram"]').val($(this).data('ram'));
		$(e.currentTarget).find('input[name="cores"]').val($(this).data('cores'));
		$(e.currentTarget).find('input[name="hdd"]').val($(this).data('hdd'));
	});



	$('#confirmDeleteUserModal').on('show.bs.modal', function(e) {
		$(e.currentTarget).find('input[name="id"]').val($(this).data('id'));
	});

	$('#confirmUnlockUser').on('show.bs.modal', function(e) {
		$(e.currentTarget).find('input[name="id"]').val($(this).data('id'));
	});

	$('#confirmDeleteGameModal').on('show.bs.modal', function(e) {
		$(e.currentTarget).find('input[name="id"]').val($(this).data('id'));
	});

	$('#confirmDeleteClientModal').on('show.bs.modal', function(e) {
		$(e.currentTarget).find('input[name="id"]').val($(this).data('id'));
	});

	$('#confirmDeleteServerModal').on('show.bs.modal', function(e) {
		$(e.currentTarget).find('input[name="id"]').val($(this).data('id'));
	});
	
	$('#confirmDeleteLogModal').on('show.bs.modal', function(e) {
		$(e.currentTarget).find('input[name="id"]').val($(this).data('id'));
	});
	
	
	$('#confirmDeleteLog').on('click', function(e) {
		$.ajax({
			url: contextpath + '/ajax/deleteLog?id=' + deleteId5,
			type: 'post',
			dataType: 'json',
			beforeSend: function(xhr) {xhr.setRequestHeader('X-CSRF-Token', $('meta[name="_csrf"]').attr('content'))},
			success: function(data) {
				$('#logsTable1').load(contextpath + '/getLogsTable', function(e){

					$('.deleteUser').on('click', function(e) {
						deleteId5 = $(this).find('button:first').data("id");
						$('#confirmDeleteLogModal').data('id',$(this).data('id'));
						$('#confirmDeleteLogModal').modal('show');
					});

				}).fadeIn();

				$('#confirmDeleteLogModal').modal('hide');
			},
			error: function(data) {
				if (!common.checkForSessionTimeOut(data)) {
					var jsonObject = JSON.parse(data.responseText);
					$('#deleteLogModal .ajaxresult-danger').html(jsonObject.message).fadeIn();
					e.stopPropagation();
					e.preventDefault();
				}
			}
		});
	});


	$('#confirmDeleteUser').on('click', function(e) {
		$.ajax({
			url: contextpath + '/ajax/deleteUser?id=' + deleteId,
			type: 'post',
			dataType: 'json',
			beforeSend: function(xhr) {xhr.setRequestHeader('X-CSRF-Token', $('meta[name="_csrf"]').attr('content'))},
			success: function(data) {
				$('#userTable1').load(contextpath + '/getUsersTable', function(e){

					$('.editUser').on('click', function(e) {
						$('#userModal').data('id',$(this).data('id'));
						$('#userModal').data('username',$(this).data('username'));
						$('#userModal').data('enabled',$(this).data('enabled'));
						$('#userModal').data('firstname',$(this).data('firstname'));
						$('#userModal').data('lastname',$(this).data('lastname'));
						$('#userModal').data('emailaddress',$(this).data('emailaddress'));
						$('#userModal').data('role',$(this).data('role'));
						$('#userModal').data('accountlocked',$(this).data('accountlocked'));
						$('#userModal').data('accountexpired',$(this).data('accountexpired'));
						$('#userModal').data('cradentialsexpired',$(this).data('cradentialsexpired'));
						$('#userModal').modal('show');
						$('#Create').val('save');
						$('#Create').attr('id', 'save');
					});

					$('.deleteUser').on('click', function(e) {
						deleteId = $(this).find('button:first').data("id");
						$('#confirmDeleteUserModal').data('id',$(this).data('id'));
						$('#confirmDeleteUserModal').modal('show');
					});

					$('.unlockUser').on('click', function(e) {
						unlockId = $(this).find('button:first').data("id");			
						$('#unlockUserModal').data('id',$(this).data('id'));
						$('#unlockUserModal').modal('show');	
					});

				}).fadeIn();

				$('#confirmDeleteUserModal').modal('hide');
			},
			error: function(data) {
				if (!common.checkForSessionTimeOut(data)) {
					var jsonObject = JSON.parse(data.responseText);
					$('#userModal .ajaxresult-danger').html(jsonObject.message).fadeIn();
					e.stopPropagation();
					e.preventDefault();
				}
			}
		});
	});

	$('#confirmUnlockUser').on('click', function(e) {
		$.ajax({
			url: contextpath + '/ajax/unlockUser?id=' + unlockId,
			type: 'post',
			dataType: 'json',
			beforeSend: function(xhr) {xhr.setRequestHeader('X-CSRF-Token', $('meta[name="_csrf"]').attr('content'))},
			success: function(data) {
				$('#userTable1').load(contextpath + '/getUsersTable', function(e){

					$('.editUser').on('click', function(e) {

						$('#userModal').data('id',$(this).data('id'));
						$('#userModal').data('username',$(this).data('username'));
						$('#userModal').data('enabled',$(this).data('enabled'));
						$('#userModal').data('firstname',$(this).data('firstname'));
						$('#userModal').data('lastname',$(this).data('lastname'));
						$('#userModal').data('emailaddress',$(this).data('emailaddress'));
						$('#userModal').data('role',$(this).data('role'));
						$('#userModal').data('accountlocked',$(this).data('accountlocked'));
						$('#userModal').data('accountexpired',$(this).data('accountexpired'));
						$('#userModal').data('cradentialsexpired',$(this).data('cradentialsexpired'));
						$('#userModal').modal('show');
						$('#Create').val('save');
						$('#Create').attr('id', 'save');
					});

					$('.deleteUser').on('click', function(e) {
						deleteId = $(this).find('button:first').data("id");
						$('#confirmDeleteUserModal').data('id',$(this).data('id'));
						$('#confirmDeleteUserModal').modal('show');
					});

					$('.unlockUser').on('click', function(e) {
						unlockId = $(this).find('button:first').data("id");	
						$('#unlockUserModal').data('id',$(this).data('id'));
						$('#unlockUserModal').modal('show');	
					});

				}).fadeIn();

				$('#confirmDeleteUserModal').modal('hide');
			},
			error: function(data) {
				if (!common.checkForSessionTimeOut(data)) {
					var jsonObject = JSON.parse(data.responseText);
					$('#unlockUserModal .ajaxresult-danger').html(jsonObject.message).fadeIn();
					e.stopPropagation();
					e.preventDefault();
				}
			}
		});
	});

	$('#confirmDeleteGame').on('click', function(e) {
		$.ajax({
			url: contextpath + '/ajax/deleteGame?id=' + deleteId2,
			type: 'post',
			dataType: 'json',
			beforeSend: function(xhr) {xhr.setRequestHeader('X-CSRF-Token', $('meta[name="_csrf"]').attr('content'))},
			success: function(data) {
				$('#gamesTable1').load(contextpath + '/getGamesTable', function(e){
					$('.editGame').on('click',  function(e) {
						$('#gameModal').data('id',$(this).data('id'));
						$('#gameModal').data('gamename',$(this).data('gamename'));
						$('#gameModal').data('gametype',$(this).data('gametype'));
						$('#gameModal').data('gamegroup',$(this).data('gamegroup'));
						$('#gameModal').data('status',$(this).data('status'));
						$('#gameModal').data('gamereleasedate',$(this).data('releasedate'));
						$('#gameModal').data('version',$(this).data('version'));
						$('#gameModal').data('supplierid',$(this).data('supplierid'));
						$('#gameModal').data('estimatedevcost',$(this).data('estimatedevcost'));
						$('#gameModal').data('estimatetestingcost',$(this).data('estimatetestingcost'));
						$('#gameModal').data('expectedmargin',$(this).data('expectedmargin'));
						$('#gameModal').data('rangemargin',$(this).data('rangemargin'));
						$('#gameModal').data('html5',$(this).data('html5'));
						$('#gameModal').data('flash',$(this).data('flash'));
						$('#gameModal').data('desktop',$(this).data('desktop'));
						$('#gameModal').data('mobile',$(this).data('mobile'));
						$('#gameModal').data('minigame',$(this).data('minigame'));
						$('#Create').val('save');
						$('#Create').attr('id', 'save');
					});

					$('.deleteGame').on('click',  function(e) {
						deleteId2 = $(this).find('button:first').data("id");
						$('#confirmDeleteGameModal').data('id',$(this).data('id'));
						$('#confirmDeleteGameModal').modal('show');
					});

				}).fadeIn();
				$('#confirmDeleteGameModal').modal('hide');
			},
			error: function(data) {
				if (!common.checkForSessionTimeOut(data)) {
					var jsonObject = JSON.parse(data.responseText);
					$('#gameModal .ajaxresult-danger').html(jsonObject.message).fadeIn();
					e.stopPropagation();
					e.preventDefault();
				}
			} 
		});
	});

	$('#confirmDeleteClient').on('click', function(e) {
		$.ajax({
			url: contextpath + '/ajax/deleteClient?id=' + deleteId3,
			type: 'post',
			dataType: 'json',
			beforeSend: function(xhr) {xhr.setRequestHeader('X-CSRF-Token', $('meta[name="_csrf"]').attr('content'))},
			success: function(data) {
				$('#clientsTable1').load(contextpath + '/getClientsTable', function(e){

					$('.editClient').on('click', 
							function(e) {
						$('#create').val('save');
						$('#create').attr('id', 'save');
						$('#clientModal').data('id',$(this).data('id'));
						$('#clientModal').data('clientalias',$(this).data('clientalias'));
						$('#clientModal').data('clientname',$(this).data('clientname'));
						$('#clientModal').data('clientlive',$(this).data('clientlive'));
						$('#clientModal').data('clientstatus',$(this).data('clientstatus'));
						$('#clientModal').data('clientstartintegration',$(this).data('clientstartintegration'));
						$('#clientModal').data('clientshutdate',$(this).data('clientshutdate'));
						$('#clientModal').data('clientplatform',$(this).data('clientplatform'));
						$('#clientModal').data('clientadminlink',$(this).data('clientadminlink'));
						$('#clientModal').data('clientbasecurrency',$(this).data('clientbasecurrency'));
						$('#clientModal').data('clientmonthlyfee',$(this).data('clientmonthlyfee'));
						$('#clientModal').data('clientcontractsigned',$(this).data('clientcontractsigned'));
						$('#clientModal').data('clientjurisdiction',$(this).data('clientjurisdiction'));
						$('#clientModal').modal('show');
					});

					$('.deleteClient').on('click', function(e) {
						deleteId3 = $(this).find('button:first').data("id");
						$('#confirmDeleteClientModal').data('id',$(this).data('id'));
						$('#confirmDeleteClientModal').modal('show');
					});

				}).fadeIn();

				$('#confirmDeleteGameModal').modal('hide');
			},
			error: function(data) {
				if (!common.checkForSessionTimeOut(data)) {
					var jsonObject = JSON.parse(data.responseText);
					$('#clientModal .ajaxresult-danger').html(jsonObject.message).fadeIn();
					e.stopPropagation();
					e.preventDefault();
				}
			}
		});
	});

	$('#confirmDeleteServer').on('click', function(e) {
		$.ajax({
			url: contextpath + '/ajax/deleteServer?id=' + deleteId4,
			type: 'post',
			dataType: 'json',
			beforeSend: function(xhr) {xhr.setRequestHeader('X-CSRF-Token', $('meta[name="_csrf"]').attr('content'))},
			success: function(data) {
				$('#serversTable1').load(contextpath + '/getServerTable', function(e){

					$('.editServer').on('click',  function(e) {
						$('#createServer1').val('save');
						$('#createServer1').attr('id', 'saveServer');
						$('#serverModal').data('serverapplicationlocation',$(this).data('serverapplicationlocation'));
						$('#serverModal').data('servertype',$(this).data('servertype'));
						$('#serverModal').data('serverrole',$(this).data('serverrole'));
						$('#serverModal').data('serverversion',$(this).data('serverversion'));
						$('#serverModal').data('username',$(this).data('username'));
						$('#serverModal').data('password',$(this).data('password'));
						$('#serverModal').data('hostname',$(this).data('hostname'));
						$('#serverModal').data('ipaddress',$(this).data('ipaddress'));
						$('#serverModal').data('monthlycost',$(this).data('monthlycost'));
						$('#serverModal').data('description',$(this).data('description'));
						$('#serverModal').data('sslkey',$(this).data('sslkey'));
						$('#serverModal').data('sslexpiry',$(this).data('sslexpiry'));
						$('#serverModal').data('domainexpirydate',$(this).data('domainexpirydate'));
						$('#serverModal').data('provider',$(this).data('provider'));
						$('#serverModal').data('os',$(this).data('os'));
						$('#serverModal').data('ostype',$(this).data('ostype'));
						$('#serverModal').data('osversion',$(this).data('osversion'));
						$('#serverModal').data('descriptionpurpose',$(this).data('descriptionpurpose'));
						$('#serverModal').data('machinetype',$(this).data('machinetype'));
						$('#serverModal').data('prosessor',$(this).data('prosessor'));
						$('#serverModal').data('isresinpro',$(this).data('isresinpro'));
						$('#serverModal').data('resinproexpiydate',$(this).data('resinproexpiydate'));
						$('#serverModal').data('sshports',$(this).data('sshports'));
						$('#serverModal').data('skynetactive',$(this).data('skynetactive'));
						$('#serverModal').data('skynetversion',$(this).data('skynetversion'));
						$('#serverModal').data('offsitebackupactive',$(this).data('offsitebackupactive'));
						$('#serverModal').data('externalipaddress',$(this).data('externalipaddress'));
						$('#serverModal').data('clientid',$(this).data('clientid'));
						$('#serverModal').data('dbarchiverstatus',$(this).data('dbarchiverstatus'));
						$('#serverModal').data('dbarchiverruntime',$(this).data('dbarchiverruntime'));
						$('#serverModal').data('backupdirectory',$(this).data('backupdirectory'));
						$('#serverModal').data('backuplocation',$(this).data('backuplocation'));
						$('#serverModal').data('backuptime',$(this).data('backuptime'));
						$('#serverModal').data('loglifespan',$(this).data('loglifespan'));
						$('#serverModal').data('notes',$(this).data('notes'));
						$('#serverModal').data('providers',$(this).data('providers'));
						$('#serverModal').data('ram',$(this).data('ram'));
						$('#serverModal').data('cores',$(this).data('cores'));
						$('#serverModal').data('hdd',$(this).data('hdd'));
						$('#serverModal').modal('show');
					});  


					$('.deleteServer').on('click', function(e) {
						deleteId4 = $(this).find('button:first').data("id");
						$('#confirmDeleteServerModal').data('id',$(this).data('id'));
						$('#confirmDeleteServerModal').modal('show');
					});

				}).fadeIn();

				$('#confirmDeleteServerModal').modal('hide');
			},
			error: function(data) {
				if (!common.checkForSessionTimeOut(data)) {
					var jsonObject = JSON.parse(data.responseText);
					$('#serverlModal .ajaxresult-danger').html(jsonObject.message).fadeIn();
					e.stopPropagation();
					e.preventDefault();
				}
			}
		});
	});


	$(".userModalFooter").on('click', '#save', function(e) {
		$.ajax({
			url: contextpath + '/ajax/save',
			type: 'post',
			dataType: 'json',
			beforeSend: function(xhr) {xhr.setRequestHeader('X-CSRF-Token', $('meta[name="_csrf"]').attr('content'))},
			data:$('form#user').serialize(),
			success: function(data) {
				$('#userTable1').load(contextpath + '/getUsersTable', function(e){
					$('.editUser').on('click',  function(e) {
						$('#password').prop('hidden', 'hidden');
						$('#userModal').data('id',$(this).data('id'));
						$('#userModal').data('username',$(this).data('username'));
						$('#userModal').data('enabled',$(this).data('enabled'));
						$('#userModal').data('firstname',$(this).data('firstname'));
						$('#userModal').data('lastname',$(this).data('lastname'));
						$('#userModal').data('emailaddress',$(this).data('emailaddress'));
						$('#userModal').data('role',$(this).data('role'));
						$('#userModal').data('accountlocked',$(this).data('accountlocked'));
						$('#userModal').data('accountexpired',$(this).data('accountexpired'));
						$('#userModal').data('cradentialsexpired',$(this).data('cradentialsexpired'));
						$('#userModal').modal('show');
					});

					$('.deleteUser').on('click', function(e) {
						deleteId = $(this).find('button:first').data("id");
						$('#confirmDeleteUserModal').data('id',$(this).data('id'));
						$('#confirmDeleteUserModal').modal('show');
					});

					$('.unlockUser').on('click', function(e) {
						unlockId = $(this).find('button:first').data("id");			
						$('#unlockUserModal').data('id',$(this).data('id'));
						$('#unlockUserModal').modal('show');	
					});

				}).fadeIn();
				$('#userModal').modal('hide');
			},
			error: function(data) {
				if (!common.checkForSessionTimeOut(data)) {
					var jsonObject = JSON.parse(data.responseText);
					$('#userModal .ajaxresult-danger').html(jsonObject.message).fadeIn().delay(1500).fadeOut();
					e.stopPropagation();
					e.preventDefault();
				}
			}
		});
	});

	$(".gameModalFooter").on('click', '#saveGame', function(e) {
		$.ajax({
			url: contextpath + '/ajax/saveGame',
			type: 'post',
			dataType: 'json',
			beforeSend: function(xhr) {xhr.setRequestHeader('X-CSRF-Token', $('meta[name="_csrf"]').attr('content'))},
			data: $('form#game').serialize(),
			success: function(data) {
				$('#gamesTable1').load(contextpath + '/getGamesTable', function(e){
					$('.editGame').on('click',  function(e) {
						$('#gameModal').data('id',$(this).data('id'));
						$('#gameModal').data('gamename',$(this).data('gamename'));
						$('#gameModal').data('gametype',$(this).data('gametype'));
						$('#gameModal').data('gamegroup',$(this).data('gamegroup'));
						$('#gameModal').data('gamesubgroup',$(this).data('gamesubgroup'));
						$('#gameModal').data('status',$(this).data('status'));
						$('#gameModal').data('gamereleasedate',$(this).data('releasedate'));
						$('#gameModal').data('version',$(this).data('version'));
						$('#gameModal').data('supplierid',$(this).data('supplierid'));
						$('#gameModal').data('estimatedevcost',$(this).data('estimatedevcost'));
						$('#gameModal').data('estimatetestingcost',$(this).data('estimatetestingcost'));
						$('#gameModal').data('expectedmargin',$(this).data('expectedmargin'));
						$('#gameModal').data('rangemargin',$(this).data('rangemargin'));
						$('#gameModal').data('html5',$(this).data('html5'));
						$('#gameModal').data('flash',$(this).data('flash'));
						$('#gameModal').data('desktop',$(this).data('desktop'));
						$('#gameModal').data('mobile',$(this).data('mobile'));
						$('#gameModal').data('minigame',$(this).data('minigame'));
						$('#gameModal').modal('show');
					});

					$('.deleteGame').on('click', function(e) {
						deleteId2 = $(this).find('button:first').data("id");
						$('#confirmDeleteGameModal').data('id',$(this).data('id'));
						$('#confirmDeleteGameModal').modal('show');
					});	
				}).fadeIn();
				$('#gameModal').modal('hide');
			},
			error: function(data) {
				if (!common.checkForSessionTimeOut(data)) {
					var jsonObject = JSON.parse(data.responseText);
					$('#gameModal .ajaxresult-danger').html(jsonObject.message).fadeIn().delay(1500).fadeOut();
					e.stopPropagation();
					e.preventDefault();
				}
			}
		});
	});

	$(".clientModalFooter").on('click', '#saveClient', function(e) {
		$.ajax({
			url: contextpath + '/ajax/saveClient',
			type: 'post',
			dataType: 'json',
			beforeSend: function(xhr) {xhr.setRequestHeader('X-CSRF-Token', $('meta[name="_csrf"]').attr('content'))},
			data: $('form#client').serialize(),
			success: function(data) {
				$('#clientsTable1').load(contextpath + '/getClientsTable', function(e){
					$('.editClient').on('click',  function(e) {
						$('#clientModal').data('id',$(this).data('id'));
						$('#clientModal').data('clientalias',$(this).data('clientalias'));
						$('#clientModal').data('clientname',$(this).data('clientname'));
						$('#clientModal').data('clientlive',$(this).data('clientlive'));
						$('#clientModal').data('clientstatus',$(this).data('clientstatus'));
						$('#clientModal').data('clientstartintegration',$(this).data('clientstartintegration'));
						$('#clientModal').data('clientshutdate',$(this).data('clientshutdate'));
						$('#clientModal').data('clientplatform',$(this).data('clientplatform'));
						$('#clientModal').data('clientadminlink',$(this).data('clientadminlink'));
						$('#clientModal').data('clientbasecurrency',$(this).data('clientbasecurrency'));
						$('#clientModal').data('clientmonthlyfee',$(this).data('clientmonthlyfee'));
						$('#clientModal').data('clientcontractsigned',$(this).data('clientcontractsigned'));
						$('#clientModal').data('clientjurisdiction',$(this).data('clientjurisdiction'));
						$('#clientModal').modal('show');
					});

					$('.deleteClient').on('click', function(e) {
						deleteId3 = $(this).find('button:first').data("id");
						$('#confirmDeleteClientModal').data('id',$(this).data('id'));
						$('#confirmDeleteClientModal').modal('show');
					});	
				}).fadeIn();
				$('#clientModal').modal('hide');
			},
			error: function(data) {
				if (!common.checkForSessionTimeOut(data)) {
					var jsonObject = JSON.parse(data.responseText);
					$('#clientModal .ajaxresult-danger').html(jsonObject.message).fadeIn().delay(1500).fadeOut();
					e.stopPropagation();
					e.preventDefault();
				}
			}
		});
	});

	$(".serverModalFooter").on('click', '#saveServer', function(e) {
		$.ajax({
			url: contextpath + '/ajax/saveServer',
			type: 'post',
			dataType: 'json',
			beforeSend: function(xhr) {xhr.setRequestHeader('X-CSRF-Token', $('meta[name="_csrf"]').attr('content'))},
			data: $('form#server').serialize(),
			success: function(data) {
				$('#serversTable1').load(contextpath + '/getServerTable', function(e){
					$('.editServer').on('click',  function(e) {
						$('#createServer1').val('save');
						$('#createServer1').attr('id', 'saveServer');
						$('#serverModal').data('id',$(this).data('id'));
						$('#serverModal').data('serverapplicationlocation',$(this).data('serverapplicationlocation'));
						$('#serverModal').data('servertype',$(this).data('servertype'));
						$('#serverModal').data('serverrole',$(this).data('serverrole'));
						$('#serverModal').data('serverversion',$(this).data('serverversion'));
						$('#serverModal').data('username',$(this).data('username'));
						$('#serverModal').data('password',$(this).data('password'));
						$('#serverModal').data('hostname',$(this).data('hostname'));
						$('#serverModal').data('ipaddress',$(this).data('ipaddress'));
						$('#serverModal').data('monthlycost',$(this).data('monthlycost'));
						$('#serverModal').data('description',$(this).data('description'));
						$('#serverModal').data('sslkey',$(this).data('sslkey'));
						$('#serverModal').data('sslexpiry',$(this).data('sslexpiry'));
						$('#serverModal').data('domainexpirydate',$(this).data('domainexpirydate'));
						$('#serverModal').data('provider',$(this).data('provider'));
						$('#serverModal').data('os',$(this).data('os'));
						$('#serverModal').data('ostype',$(this).data('ostype'));
						$('#serverModal').data('osversion',$(this).data('osversion'));
						$('#serverModal').data('descriptionpurpose',$(this).data('descriptionpurpose'));
						$('#serverModal').data('machinetype',$(this).data('machinetype'));
						$('#serverModal').data('prosessor',$(this).data('prosessor'));
						$('#serverModal').data('isresinpro',$(this).data('isresinpro'));
						$('#serverModal').data('resinproexpiydate',$(this).data('resinproexpiydate'));
						$('#serverModal').data('sshports',$(this).data('sshports'));
						$('#serverModal').data('skynetactive',$(this).data('skynetactive'));
						$('#serverModal').data('skynetversion',$(this).data('skynetversion'));
						$('#serverModal').data('offsitebackupactive',$(this).data('offsitebackupactive'));
						$('#serverModal').data('externalipaddress',$(this).data('externalipaddress'));
						$('#serverModal').data('clientid',$(this).data('clientid'));
						$('#serverModal').data('dbarchiverstatus',$(this).data('dbarchiverstatus'));
						$('#serverModal').data('dbarchiverruntime',$(this).data('dbarchiverruntime'));
						$('#serverModal').data('backupdirectory',$(this).data('backupdirectory'));
						$('#serverModal').data('backuplocation',$(this).data('backuplocation'));
						$('#serverModal').data('backuptime',$(this).data('backuptime'));
						$('#serverModal').data('loglifespan',$(this).data('loglifespan'));
						$('#serverModal').data('notes',$(this).data('notes'));
						$('#serverModal').data('providers',$(this).data('providers'));
						$('#serverModal').data('ram',$(this).data('ram'));
						$('#serverModal').data('cores',$(this).data('cores'));
						$('#serverModal').data('hdd',$(this).data('hdd'));
						$('#serverModal').modal('show');
					});  


					$('.deleteServer').on('click', function(e) {
						deleteId4 = $(this).find('button:first').data("id");
						$('#confirmDeleteServerModal').data('id',$(this).data('id'));
						$('#confirmDeleteServerModal').modal('show');
					});

				}).fadeIn();
				$('#serverModal').modal('hide');
			},
			error: function(data) {
				if (!common.checkForSessionTimeOut(data)) {
					var jsonObject = JSON.parse(data.responseText);
					$('#serverModal .ajaxresult-danger').html(jsonObject.message).fadeIn().delay(1500).fadeOut();
					e.stopPropagation();
					e.preventDefault();
				}
			}
		});
	});



	$(".gameModalFooter").on('click', '#createGame1', function(e) {
		$.ajax({
			url: contextpath + '/ajax/createGame',
			type: 'post',
			dataType: 'json',
			beforeSend: function(xhr) {xhr.setRequestHeader('X-CSRF-Token', $('meta[name="_csrf"]').attr('content'))},
			data: $('form#game').serialize(),
			success: function(data) {
				$('#gamesTable1').load(contextpath + '/getGamesTable', function(e){
					$('.editGame').on('click',  function(e) {
						$('#gameModal').data('id',$(this).data('id'));
						$('#gameModal').data('gamename',$(this).data('gamename'));
						$('#gameModal').data('gametype',$(this).data('gametype'));
						$('#gameModal').data('gamegroup',$(this).data('gamegroup'));
						$('#gameModal').data('gamesubgroup',$(this).data('gamesubgroup'));
						$('#gameModal').data('status',$(this).data('status'));
						$('#gameModal').data('gamereleasedate',$(this).data('releasedate'));
						$('#gameModal').data('version',$(this).data('version'));
						$('#gameModal').data('supplierid',$(this).data('supplierid'));
						$('#gameModal').data('estimatedevcost',$(this).data('estimatedevcost'));
						$('#gameModal').data('estimatetestingcost',$(this).data('estimatetestingcost'));
						$('#gameModal').data('expectedmargin',$(this).data('expectedmargin'));
						$('#gameModal').data('rangemargin',$(this).data('rangemargin'));
						$('#gameModal').data('html5',$(this).data('html5'));
						$('#gameModal').data('flash',$(this).data('flash'));
						$('#gameModal').data('desktop',$(this).data('desktop'));
						$('#gameModal').data('mobile',$(this).data('mobile'));
						$('#gameModal').data('minigame',$(this).data('minigame'));
						$('#gameModal').modal('show');
					});

					$('.deleteGame').on('click', function(e) {
						deleteId2 = $(this).find('button:first').data("id");
						$('#confirmDeleteGameModal').data('id',$(this).data('id'));
						$('#confirmDeleteGameModal').modal('show');
					});	
				}).fadeIn();
				$('#gameModal').modal('hide');
			},
			error: function(data) {
				if (!common.checkForSessionTimeOut(data)) {
					var jsonObject = JSON.parse(data.responseText);
					$('#gameModal .ajaxresult-danger').html(jsonObject.message).fadeIn().delay(1500).fadeOut();
					e.stopPropagation();
					e.preventDefault();
				}
			}
		});
	});

	$(".userModalFooter").on('click', '#create', function(e) {
		$.ajax({
			url: contextpath + '/ajax/createUser',
			type: 'post',
			dataType: 'json',
			beforeSend: function(xhr) {xhr.setRequestHeader('X-CSRF-Token', $('meta[name="_csrf"]').attr('content'))},
			data: $('form#user').serialize(),
			success: function(data) {
				$('#userTable1').load(contextpath + '/getUsersTable', function(e){
					$('.editUser').on('click',  function(e) {
						$('#password').removeProp('hidden');
						$('#userModal').data('id',$(this).data('id'));
						$('#userModal').data('username',$(this).data('username'));
						$('#userModal').data('enabled',$(this).data('enabled'));
						$('#userModal').data('firstname',$(this).data('firstname'));
						$('#userModal').data('lastname',$(this).data('lastname'));
						$('#userModal').data('emailaddress',$(this).data('emailaddress'));
						$('#userModal').data('password',$(this).data('password'));
						$('#userModal').data('role',$(this).data('role'));
						$('#userModal').data('accountlocked',$(this).data('accountlocked'));
						$('#userModal').data('accountexpired',$(this).data('accountexpired'));
						$('#userModal').data('cradentialsexpired',$(this).data('cradentialsexpired'));
						$('#userModal').modal('show');
					});

					$('.deleteUser').on('click', function(e) {
						deleteId = $(this).find('button:first').data("id");
						$('#confirmDeleteUserModal').data('id',$(this).data('id'));
						$('#confirmDeleteUserModal').modal('show');
					});

					$('.unlockUser').on('click', function(e) {
						unlockId = $(this).find('button:first').data("id");			
						$('#unlockUserModal').data('id',$(this).data('id'));
						$('#unlockUserModal').modal('show');	
					});

				}).fadeIn();
				$('#userModal').modal('hide');
			},
			error: function(data) {
				if (!common.checkForSessionTimeOut(data)) {
					var jsonObject = JSON.parse(data.responseText);
					$('#userModal .ajaxresult-danger').html(jsonObject.message).fadeIn().delay(1500).fadeOut();
					e.stopPropagation();
					e.preventDefault();
				}
			}

		});		
	});


	$(".clientModalFooter").on('click', '#createClient1', function(e) {
		$.ajax({
			url: contextpath + '/ajax/createClient',
			type: 'post',
			dataType: 'json',
			beforeSend: function(xhr) {xhr.setRequestHeader('X-CSRF-Token', $('meta[name="_csrf"]').attr('content'))},
			data: $('form#client').serialize(),
			success: function(data) {
				$('#clientsTable1').load(contextpath + '/getClientsTable', function(e){
					$('.editClient').on('click', 
							function(e) {
						$('#create').val('save');
						$('#create').attr('id', 'save');
						$('#clientModal').data('id',$(this).data('id'));
						$('#clientModal').data('clientalias',$(this).data('clientalias'));
						$('#clientModal').data('clientname',$(this).data('clientname'));
						$('#clientModal').data('clientlive',$(this).data('clientlive'));
						$('#clientModal').data('clientstatus',$(this).data('clientstatus'));
						$('#clientModal').data('clientstartintegration',$(this).data('clientstartintegration'));
						$('#clientModal').data('clientshutdate',$(this).data('clientshutdate'));
						$('#clientModal').data('clientplatform',$(this).data('clientplatform'));
						$('#clientModal').data('clientadminlink',$(this).data('clientadminlink'));
						$('#clientModal').data('clientbasecurrency',$(this).data('clientbasecurrency'));
						$('#clientModal').data('clientmonthlyfee',$(this).data('clientmonthlyfee'));
						$('#clientModal').data('clientcontractsigned',$(this).data('clientcontractsigned'));
						$('#clientModal').data('clientjurisdiction',$(this).data('clientjurisdiction'));
						$('#clientModal').modal('show');
					});

					$('.deleteClient').on('click', 
							function(e) {
						deleteId3 = $(this).find('button:first').data("id");
						$('#confirmDeleteClientModal').data('id',$(this).data('id'));
						$('#confirmDeleteClientModal').modal('show');
					});
				}).fadeIn();
				$('#clientModal').modal('hide');
			},
			error: function(data) {
				if (!common.checkForSessionTimeOut(data)) {
					var jsonObject = JSON.parse(data.responseText);
					$('#clientModal .ajaxresult-danger').html(jsonObject.message).fadeIn().delay(1500).fadeOut();
				}
				e.stopPropagation();
				e.preventDefault();
			}
		});
	});

	$(".serverModalFooter").on('click', '#createServer1', function(e) {
		$.ajax({
			url: contextpath + '/ajax/createServer',
			type: 'post',
			dataType: 'json',
			beforeSend: function(xhr) {xhr.setRequestHeader('X-CSRF-Token', $('meta[name="_csrf"]').attr('content'))},
			data: $('form#server').serialize(),
			success: function(xhr) {

				$('#serverTable1').load(contextpath + '/getServerTable', function(e){

					$('.editServer').on('click',  function(e) {
						$('#createServer1').val('save');
						$('#createServer1').attr('id', 'saveServer');
						$('#serverModal').data('id',$(this).data('id'));
						$('#serverModal').data('serverapplicationlocation',$(this).data('serverapplicationlocation'));
						$('#serverModal').data('servertype',$(this).data('servertype'));
						$('#serverModal').data('serverrole',$(this).data('serverrole'));
						$('#serverModal').data('serverversion',$(this).data('serverversion'));
						$('#serverModal').data('username',$(this).data('username'));
						$('#serverModal').data('password',$(this).data('password'));
						$('#serverModal').data('hostname',$(this).data('hostname'));
						$('#serverModal').data('ipaddress',$(this).data('ipaddress'));
						$('#serverModal').data('monthlycost',$(this).data('monthlycost'));
						$('#serverModal').data('description',$(this).data('description'));
						$('#serverModal').data('sslkey',$(this).data('sslkey'));
						$('#serverModal').data('sslexpiry',$(this).data('sslexpiry'));
						$('#serverModal').data('domainexpirydate',$(this).data('domainexpirydate'));
						$('#serverModal').data('provider',$(this).data('provider'));
						$('#serverModal').data('os',$(this).data('os'));
						$('#serverModal').data('ostype',$(this).data('ostype'));
						$('#serverModal').data('osversion',$(this).data('osversion'));
						$('#serverModal').data('descriptionpurpose',$(this).data('descriptionpurpose'));
						$('#serverModal').data('machinetype',$(this).data('machinetype'));
						$('#serverModal').data('prosessor',$(this).data('prosessor'));
						$('#serverModal').data('isresinpro',$(this).data('isresinpro'));
						$('#serverModal').data('resinproexpiydate',$(this).data('resinproexpiydate'));
						$('#serverModal').data('sshports',$(this).data('sshports'));
						$('#serverModal').data('skynetactive',$(this).data('skynetactive'));
						$('#serverModal').data('skynetversion',$(this).data('skynetversion'));
						$('#serverModal').data('offsitebackupactive',$(this).data('offsitebackupactive'));
						$('#serverModal').data('externalipaddress',$(this).data('externalipaddress'));
						$('#serverModal').data('clientid',$(this).data('clientid'));
						$('#serverModal').data('dbarchiverstatus',$(this).data('dbarchiverstatus'));
						$('#serverModal').data('dbarchiverruntime',$(this).data('dbarchiverruntime'));
						$('#serverModal').data('backupdirectory',$(this).data('backupdirectory'));
						$('#serverModal').data('backuplocation',$(this).data('backuplocation'));
						$('#serverModal').data('backuptime',$(this).data('backuptime'));
						$('#serverModal').data('loglifespan',$(this).data('loglifespan'));
						$('#serverModal').data('notes',$(this).data('notes'));
						$('#serverModal').data('providers',$(this).data('providers'));
						$('#serverModal').data('ram',$(this).data('ram'));
						$('#serverModal').data('cores',$(this).data('cores'));
						$('#serverModal').data('hdd',$(this).data('hdd'));
						$('#serverModal').modal('show');
					});  


					$('.deleteServer').on('click', function(e) {
						deleteId4 = $(this).find('button:first').data("id");
						$('#confirmDeleteServerModal').data('id',$(this).data('id'));
						$('#confirmDeleteServerModal').modal('show');
					});

				}).fadeIn();
				$('#serverModal').modal('hide');
			},
			error: function(data) {
				if (!common.checkForSessionTimeOut(data)) {
					var jsonObject = JSON.parse(data.responseText);
					$('#serverModal .ajaxresult-danger').html(jsonObject.message).fadeIn().delay(1500).fadeOut();
					e.stopPropagation();
					e.preventDefault();
				}

			}
		});
	});

	fadeErrors();

	$('#createUser').on('click', function(e) {

		$('#userModal').modal('show');
		$('#userId').remove();
		$('#password').removeProp('hidden');
		$('#username').val('');
		$('#enabled').val('');
		$('#firstName').val('');
		$('#lastName').val('');
		$('#emailAddress').val('');
		$('#password').val('');
		$('#role').val('');
		$('#accountLocked').val('');
		$('#cradentialsExpired').val('');
		$('#accountExpired').val('');
		$('#save').val('Create');
		$('#save').attr('id', 'create');

		$('#myModalLabel').text('Create User');

	});

	$('#createGame').on('click', function(e) {
		$('#gameModal').modal('show');
		$('#gameId').remove();
		$('#myModalLabel').text('Create Game');
		$('#saveGame').attr('id', 'createGame1');
		$('#createGame1').val('Create');
		$('#gameName').val('');
		$('#gameType').val('');
		$('#gameGroup').val('');
		$('#gameSubGroup').val('');
		$('#gameStatus').val('');
		$('#gameReleaseDate').val('');
		$('#version').val('');
		$('#supplierId').val('');
		$('#estimatedDevCost').val('');
		$('#estimatedTestingCost').val('');
		$('#rangeMargin').val('');
		$('#html5').val('');
		$('#flash').val('');
		$('#desktop').val('');
		$('#mobile').val('');
		$('#miniGame').val('');

	});

	$('#createClient').on('click', function(e) {
		$('#clientModal').modal('show');
		$('#clientId').remove();
		$('#myModalLabel').text('Create Client');
		$('#saveClient').attr('id', 'createClient1');
		$('#createClient1').val('Create');
		$('#clientName').val('');
		$('#clientAlias').val('');
		$('#clientLive').val('');
		$('#clientStatus').val('');
		$('#clientStartIntegration').val('');
		$('#clientShutDate').val('');
		$('#clientIsPlatform').val('');
		$('#clientAdminLink').val('');
		$('#clientBaseCurrency').val('');
		$('#clientMonthleyFee').val('');
		$('#clientContractSigned').val('');
		$('#clientJuristriction').val('');
	});

	$('#createServer').on('click', function(e) {
		$('#serverModal').modal('show');
		$('#serverId').remove();
		$('#myModalLabel').text('Create Server');
		$('#saveServer').attr('id', 'createServer1');
		$('#createServer1').val('Create');


	});

	$('#createServer').on('click', function(e) {
		$('#serverModal').modal('show');
		$('#serverId').remove();
		$('#myModalLabel').text('Create Server');
		$('#saveServer').attr('id', 'createServer1');
		$('#createServer1').val('Create');
	});

	$('#logout').on('click', function(e) {
		var logout ="logout";
		$.ajax({
			url: contextpath + '/login?'+logout,
			type: 'get',
			dataType: 'json',
			beforeSend: function(xhr) {xhr.setRequestHeader('X-CSRF-Token', $('meta[name="_csrf"]').attr('content'))},
			success: function(xhr) {}
		});
	});

	function fadeErrors() {
		$('#userModal .ajaxresult-info').fadeOut();
		$('#userModal .ajaxresult-danger').fadeOut();

		$('#clientModal .ajaxresult-info').fadeOut();
		$('#clientModal .ajaxresult-danger').fadeOut();

		$('#serverModal .ajaxresult-info').fadeOut();
		$('#serverModal .ajaxresult-danger').fadeOut();

		$('#gameModal .ajaxresult-info').fadeOut();
		$('#gameModal .ajaxresult-danger').fadeOut();
	}

	$('#close').on('click', function(e) { 

		var attr = $('#errorDiv').val();
		if (typeof attr !== typeof undefined && attr !== false) {
			window.location.reload();
		}
	});

});