USE CENTRAL_ADMIN;
INSERT INTO SERVER (SERVER_APPLICATION_LOCATION, SERVER_TYPE, SERVER_ROLE, IP_ADDRESS, HOST_NAME, 
		DESCRIPTION, SSL_KEY, SSL_EXPIREY, PROVIDER, OS, OS_TYPE, OS_VERSION, DESCRIPTION_PURPOSE, MACHINE_TYPE, PROSSESOR, MONTHLY_COST,
		USER_NAME, NOTES, PASSWORD, IS_RESIN_PRO, RESIN_PRO_EXPIREY_DATE, PROVIDERS, DOMAIN_EXPIREY_DATE, SSH_PORTS, SKYNET_ACTIVE, SKYNET_VERSION,
		OFFSITE_BACKUP_ACTIVE, EXTERNAL_IP_ADDRESS, CLIENT_ID, DB_ARCHIVER_STATUS, DB_ARCHIVER_RUNTIME, LOG_LIFESPAN, BACKUP_DIRECTORY, BACKUP_LOCATION,
		BACKUP_TIME, RAM, CORES, HDD) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);

/*USE central_admin;
INSERT INTO SERVER (SERVER_APPLICATION_LOCATION, SERVER_TYPE, SERVER_ROLE,         IP_ADDRESS,                  HOST_NAME,      DESCRIPTION,   SSL_KEY, SSL_EXPIREY, PROVIDER,         OS,    OS_TYPE, OS_VERSION, DESCRIPTION_PURPOSE, MACHINE_TYPE,   PROSSESOR, MONTHLY_COST, USER_NAME,    NOTES, `PASSWORD`, IS_RESIN_PRO, RESIN_PRO_EXPIREY_DATE, PROVIDERS, DOMAIN_EXPIREY_DATE, SSH_PORTS, SKYNET_ACTIVE, SKYNET_VERSION, OFFSITE_BACKUP_ACTIVE, EXTERNAL_IP_ADDRESS,    CLIENT_ID, DB_ARCHIVER_STATUS, DB_ARCHIVER_RUNTIME, LOG_LIFESPAN, BACKUP_DIRECTORY, BACKUP_LOCATION, BACKUP_TIME, RAM, CORES, HDD)	
				VALUES('/usr/local/resin',        'resin',  'application server', 'http://192.168.2.15/resin', 'testHostName', 'Test Description', 1, '2017-11-23', 'Test Provider', 'Linux', 'Linux', 'Not Sure', 'informative',       'pile of crap', 'Quad Core', 100,        'testUser', 'No Notes', 'testPassword', 1,         '2018-11-29',    'Test Providers', '2019-12-29',     443,             1,             3,               1,            'http://192.168.2.15/backup', 1,    1,   'Not Sure', 30, '/usr/local/backup', 'Russia', '2019-12-29 23:59:00', '4gb', 4, '250gb' ); */  
		