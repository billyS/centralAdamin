package uk.co.F1x2Games.service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import uk.co.F1x2Games.DatabaseUtils;
import uk.co.F1x2Games.Game;
import uk.co.F1x2Games.Server;

@Service
public class ServerService {


	public ServerService() {
		super();
	}

	private Server aServer;
	private Connection con;
	private ResultSet rs;
	private PreparedStatement prep;
	DatabaseUtils dbu =  DatabaseUtils.getInstance();
	private List<Server> servers;
	
	/**
	 * @return a list off all servers in the database as a jsonArray
	 */
	public List<Server> getServers(){

		servers = new ArrayList<Server>();		
		try{
			con = dbu.getConnection("CENTRAL");
			prep = con.prepareStatement("Select * from SERVER");
			rs = prep.executeQuery();

			while(rs.next()){
				
				aServer = new Server();

				aServer.setServerId( rs.getInt("SERVER_ID"));
				aServer.setBackUpDirectory(rs.getString("BACKUP_DIRECTORY"));
				aServer.setBackUpLocation(rs.getString("BACKUP_LOCATION"));
				aServer.setBackupTime(""+rs.getDate("BACKUP_TIME"));
				aServer.setClientId(rs.getInt("CLIENT_ID"));
				aServer.setCores(rs.getString("CORES"));
				aServer.setdBArchiverRuntime(rs.getString("DB_ARCHIVER_RUNTIME"));
				aServer.setDbArchiverStatus(rs.getInt("DB_ARCHIVER_STATUS"));
				aServer.setDescription(rs.getString("DESCRIPTION"));
				aServer.setDescriptionPurpose(rs.getString("DESCRIPTION_PURPOSE"));
				aServer.setDomainExpiryDate(""+rs.getString("DOMAIN_EXPIREY_DATE"));
				aServer.setExternalIPAddress(rs.getString("EXTERNAL_IP_ADDRESS"));
				aServer.setHdd(rs.getString("HDD"));
				aServer.setHostName(rs.getString("HOST_NAME"));
				aServer.setIPAddress(rs.getString("IP_ADDRESS"));
				aServer.setLogLifespan(rs.getInt("LOG_LIFESPAN"));
				aServer.setMachineType(rs.getString("MACHINE_TYPE"));
				aServer.setMonthlyCost(rs.getInt("MONTHLY_COST"));
				aServer.setNotes(rs.getString("NOTES"));
				aServer.setOs(rs.getString("OS"));
				aServer.setOsType(rs.getString("OS_TYPE"));
				aServer.setOsVersion(rs.getString("OS_VERSION"));
				aServer.setPassword(rs.getString("PASSWORD"));
				aServer.setProsessor(rs.getString("PROSSESOR"));
				aServer.setProvider(rs.getString("PROVIDER"));
				aServer.setProviders(rs.getString("PROVIDERS"));
				aServer.setRam(rs.getString("RAM"));
				aServer.setServerApplicationLocation(rs.getString("SERVER_APPLICATION_LOCATION"));
				aServer.setServerRole(rs.getString("SERVER_ROLE"));
				aServer.setServerType(rs.getString("SERVER_TYPE"));
				aServer.setServerVersion(rs.getString("SERVER_ID"));
				aServer.setSkynetVersion(rs.getString("SKYNET_VERSION"));
				aServer.setSshPorts(rs.getInt("SSH_PORTS"));
				aServer.setSslExpiry(""+rs.getString("SSL_EXPIREY"));
				aServer.setSslKey(rs.getInt("SSL_KEY"));
				aServer.setSkynetActive(rs.getInt("SKYNET_ACTIVE"));
				aServer.setIsResinPro(rs.getInt("IS_RESIN_PRO"));
				aServer.setResinProExpiyDate(rs.getString("RESIN_PRO_EXPIREY_DATE"));
				aServer.setOffsiteBackupActive(rs.getInt("OFFSITE_BACKUP_ACTIVE"));
				aServer.setUserName(rs.getString("USER_NAME"));
				servers.add(aServer);
			}		     
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null){
					rs.close();
					rs 	= null;
				}
				if(prep != null){
					prep.close();
					prep = null;
				}
				if(con != null){
					con.close();
					con = null;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		  
		return servers;
	}
	
	/**
	 * @param serverId
	 * @return a server record from the database using the serverId to identify it.
	 */
	public Server getServer(int serverId){

		
		try{
			con = dbu.getConnection("CENTRAL");
			prep = con.prepareStatement("Select * from SERVER where SERVER_ID=?");
			prep.setInt(1,serverId);
			rs = prep.executeQuery();

			if (rs.next()){
				
				aServer = new Server();

				aServer.setServerId( rs.getInt("SERVER_ID"));
				aServer.setBackUpDirectory(rs.getString("BACKUP_DIRECTORY"));
				aServer.setBackUpLocation(rs.getString("BACKUP_LOCATION"));
				aServer.setBackupTime(""+rs.getDate("BACKUP_TIME"));
				aServer.setClientId(rs.getInt("CLIENT_ID"));
				aServer.setCores(rs.getString("CORES"));
				aServer.setdBArchiverRuntime(rs.getString("DB_ARCHIVER_RUNTIME"));
				aServer.setDbArchiverStatus(rs.getInt("DB_ARCHIVER_STATUS"));
				aServer.setDescription(rs.getString("DESCRIPTION"));
				aServer.setDescriptionPurpose(rs.getString("DESCRIPTION_PURPOSE"));
				aServer.setDomainExpiryDate(""+rs.getString("DOMAIN_EXPIREY_DATE"));
				aServer.setExternalIPAddress(rs.getString("EXTERNAL_IP_ADDRESS"));
				aServer.setHdd(rs.getString("HDD"));
				aServer.setHostName(rs.getString("HOST_NAME"));
				aServer.setIPAddress(rs.getString("IP_ADDRESS"));
				aServer.setLogLifespan(rs.getInt("LOG_LIFESPAN"));
				aServer.setMachineType(rs.getString("MACHINE_TYPE"));
				aServer.setMonthlyCost(rs.getInt("MONTHLY_COST"));
				aServer.setNotes(rs.getString("NOTES"));
				aServer.setOs(rs.getString("OS"));
				aServer.setOsType(rs.getString("OS_TYPE"));
				aServer.setOsVersion(rs.getString("OS_VERSION"));
				aServer.setPassword(rs.getString("PASSWORD"));
				aServer.setProsessor(rs.getString("PROSSESOR"));
				aServer.setProvider(rs.getString("PROVIDER"));
				aServer.setProviders(rs.getString("PROVIDERS"));
				aServer.setRam(rs.getString("RAM"));
				aServer.setServerApplicationLocation(rs.getString("SERVER_APPLICATION_LOCATION"));
				aServer.setServerRole(rs.getString("SERVER_ROLE"));
				aServer.setServerType(rs.getString("SERVER_TYPE"));
				aServer.setServerVersion(rs.getString("SERVER_ID"));
				aServer.setSkynetVersion(rs.getString("SKYNET_VERSION"));
				aServer.setSshPorts(rs.getInt("SSH_PORTS"));
				aServer.setSslExpiry(""+rs.getString("SSL_EXPIREY"));
				aServer.setSslKey(rs.getInt("SSL_KEY"));
				aServer.setSkynetActive(rs.getInt("SKYNET_ACTIVE"));
				aServer.setIsResinPro(rs.getInt("IS_RESIN_PRO"));
				aServer.setResinProExpiyDate(rs.getString("RESIN_PRO_EXPIREY_DATE"));
				aServer.setOffsiteBackupActive(rs.getInt("OFFSITE_BACKUP_ACTIVE"));
				aServer.setUserName("USER_NAME");
			}		     
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null){
					rs.close();
					rs 	= null;
				}
				if(prep != null){
					prep.close();
					prep = null;
				}
				if(con != null){
					con.close();
					con = null;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return aServer;
	}
	
	/**
	 * @param ipAddress
	 * @return a server record from the database using the IPAddress to identify it.
	 */
	public Server getServer(String ipAddress){
		
		try{
			con = dbu.getConnection("ADMIN");
			prep = con.prepareStatement("Select * from SERVER where IP_ADDRESS=?");
			prep.setString(1,ipAddress);
			rs = prep.executeQuery();

			if (rs.next()){
				aServer = new Server();

				aServer.setServerId( rs.getInt("SERVER_ID"));
				aServer.setBackUpDirectory(rs.getString("BACKUP_DIRECTORY"));
				aServer.setBackUpLocation(rs.getString("BACKUP_LOCATION"));
				aServer.setBackupTime(""+rs.getDate("BACKUP_TIME"));
				aServer.setClientId(rs.getInt("CLIENT_ID"));
				aServer.setCores(rs.getString("CORES"));
				aServer.setdBArchiverRuntime(rs.getString("DB_ARCHIVER_RUNTIME"));
				aServer.setDbArchiverStatus(rs.getInt("DB_ARCHIVER_STATUS"));
				aServer.setDescription(rs.getString("DESCRIPTION"));
				aServer.setDescriptionPurpose(rs.getString("DESCRIPTION_PURPOSE"));
				aServer.setDomainExpiryDate(""+rs.getString("DOMAIN_EXPIREY_DATE"));
				aServer.setExternalIPAddress(rs.getString("EXTERNAL_IP_ADDRESS"));
				aServer.setHdd(rs.getString("HDD"));
				aServer.setHostName(rs.getString("HOST_NAME"));
				aServer.setIPAddress(rs.getString("IP_ADDRESS"));
				aServer.setLogLifespan(rs.getInt("LOG_LIFESPAN"));
				aServer.setMachineType(rs.getString("MACHINE_TYPE"));
				aServer.setMonthlyCost(rs.getInt("MONTHLY_COST"));
				aServer.setNotes(rs.getString("NOTES"));
				aServer.setOs(rs.getString("OS"));
				aServer.setOsType(rs.getString("OS_TYPE"));
				aServer.setOsVersion(rs.getString("OS_VERSION"));
				aServer.setPassword(rs.getString("PASSWORD"));
				aServer.setProsessor(rs.getString("PROSSESOR"));
				aServer.setProvider(rs.getString("PROVIDER"));
				aServer.setRam(rs.getString("RAM"));
				aServer.setServerApplicationLocation(rs.getString("SERVER_APPLICATION_LOCATION"));
				aServer.setServerRole(rs.getString("SERVER_ROLE"));
				aServer.setServerType(rs.getString("SERVER_TYPE"));
				aServer.setServerVersion(rs.getString("SERVER_ID"));
				aServer.setSkynetVersion(rs.getString("SKYNET_VERSION"));
				aServer.setSshPorts(rs.getInt("SSH_PORTS"));
				aServer.setSslExpiry(""+rs.getString("SSL_EXPIREY"));
				aServer.setSslKey(rs.getInt("SSL_KEY"));
				aServer.setSkynetActive(rs.getInt("SKYNET_ACTIVE"));
				aServer.setIsResinPro(rs.getInt("IS_RESIN_PRO"));
				aServer.setResinProExpiyDate(rs.getString("RESIN_PRO_EXPIREY_DATE"));
				aServer.setOffsiteBackupActive(rs.getInt("OFFSITE_BACKUP_ACTIVE"));
			}		     
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null){
					rs.close();
					rs 	= null;
				}
				if(prep != null){
					prep.close();
					prep = null;
				}
				if(con != null){
					con.close();
					con = null;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return aServer;
	}
	
public Server getServerforClient(int clientId){
		
		try{
			con = dbu.getConnection("ADMIN");
			prep = con.prepareStatement("Select * from SERVER where CLIENT_ID=?");
			prep.setInt(1,clientId);
			rs = prep.executeQuery();

			if (rs.next()){
				aServer = new Server();

				aServer.setServerId( rs.getInt("SERVER_ID"));
				aServer.setBackUpDirectory(rs.getString("BACKUP_DIRECTORY"));
				aServer.setBackUpLocation(rs.getString("BACKUP_LOCATION"));
				aServer.setBackupTime(""+rs.getDate("BACKUP_TIME"));
				aServer.setClientId(rs.getInt("CLIENT_ID"));
				aServer.setCores(rs.getString("CORES"));
				aServer.setdBArchiverRuntime(rs.getString("DB_ARCHIVER_RUNTIME"));
				aServer.setDbArchiverStatus(rs.getInt("DB_ARCHIVER_STATUS"));
				aServer.setDescription(rs.getString("DESCRIPTION"));
				aServer.setDescriptionPurpose(rs.getString("DESCRIPTION_PURPOSE"));
				aServer.setDomainExpiryDate(""+rs.getString("DOMAIN_EXPIREY_DATE"));
				aServer.setExternalIPAddress(rs.getString("EXTERNAL_IP_ADDRESS"));
				aServer.setHdd(rs.getString("HDD"));
				aServer.setHostName(rs.getString("HOST_NAME"));
				aServer.setIPAddress(rs.getString("IP_ADDRESS"));
				aServer.setLogLifespan(rs.getInt("LOG_LIFESPAN"));
				aServer.setMachineType(rs.getString("MACHINE_TYPE"));
				aServer.setMonthlyCost(rs.getInt("MONTHLY_COST"));
				aServer.setNotes(rs.getString("NOTES"));
				aServer.setOs(rs.getString("OS"));
				aServer.setOsType(rs.getString("OS_TYPE"));
				aServer.setOsVersion(rs.getString("OS_VERSION"));
				aServer.setPassword(rs.getString("PASSWORD"));
				aServer.setProsessor(rs.getString("PROSSESOR"));
				aServer.setProvider(rs.getString("PROVIDER"));
				aServer.setRam(rs.getString("RAM"));
				aServer.setServerApplicationLocation(rs.getString("SERVER_APPLICATION_LOCATION"));
				aServer.setServerRole(rs.getString("SERVER_ROLE"));
				aServer.setServerType(rs.getString("SERVER_TYPE"));
				aServer.setServerVersion(rs.getString("SERVER_ID"));
				aServer.setSkynetVersion(rs.getString("SKYNET_VERSION"));
				aServer.setSshPorts(rs.getInt("SSH_PORTS"));
				aServer.setSslExpiry(""+rs.getString("SSL_EXPIREY"));
				aServer.setSslKey(rs.getInt("SSL_KEY"));
				aServer.setSkynetActive(rs.getInt("SKYNET_ACTIVE"));
				aServer.setIsResinPro(rs.getInt("IS_RESIN_PRO"));
				aServer.setResinProExpiyDate(rs.getString("RESIN_PRO_EXPIREY_DATE"));
				aServer.setOffsiteBackupActive(rs.getInt("OFFSITE_BACKUP_ACTIVE"));
			}		     
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null){
					rs.close();
					rs 	= null;
				}
				if(prep != null){
					prep.close();
					prep = null;
				}
				if(con != null){
					con.close();
					con = null;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return aServer;
	}
	
	

	public Server saveServer(Server server) {
		try {
			con = dbu.getConnection("CENTRAL");
			prep = con.prepareStatement("UPDATE SERVER SET SERVER_APPLICATION_LOCATION=?, SERVER_TYPE=?, SERVER_ROLE=?, IP_ADDRESS=?, HOST_NAME=?,"+ 
						"DESCRIPTION=?, SSL_KEY=?, SSL_EXPIREY=?, PROVIDER=?, OS=?, OS_TYPE=?, OS_VERSION=?, DESCRIPTION_PURPOSE=?, MACHINE_TYPE=?, PROSSESOR=?, MONTHLY_COST=?,"+
						"USER_NAME=?, NOTES=?, PASSWORD=?, IS_RESIN_PRO=?, RESIN_PRO_EXPIREY_DATE=?, PROVIDERS=?, DOMAIN_EXPIREY_DATE=?, SSH_PORTS=?, SKYNET_ACTIVE=?, SKYNET_VERSION=?,"+
						"OFFSITE_BACKUP_ACTIVE=?, EXTERNAL_IP_ADDRESS=?, CLIENT_ID=?, DB_ARCHIVER_STATUS=?, DB_ARCHIVER_RUNTIME=?, LOG_LIFESPAN=?, BACKUP_DIRECTORY=?, BACKUP_LOCATION=?,"+
						"BACKUP_TIME=?, RAM=?, CORES=?, HDD=?  WHERE SERVER_ID=?");
			
			prep.setString(1, server.getServerApplicationLocation());
			prep.setString(2, server.getServerType());
			prep.setString(3, server.getServerRole());
			prep.setString(4, server.getIPAddress());
			prep.setString(5, server.getHostName());
			prep.setString(6, server.getDescription());
			prep.setInt(7, server.getSslKey());
			prep.setString(8, server.getSslExpiry());
			prep.setString(9, server.getProvider());
			prep.setString(10, server.getOs());
			prep.setString(11, server.getOsType());
			prep.setString(12, server.getOsVersion());
			prep.setString(13, server.getDescriptionPurpose());
			prep.setString(14, server.getMachineType());
			prep.setString(15, server.getProsessor());
			prep.setInt(16, server.getMonthlyCost());
			prep.setString(17, server.getUserName());
			prep.setString(18, server.getNotes());
			prep.setString(19, server.getPassword());
			prep.setInt(20, server.getIsResinPro());
			prep.setString(21, server.getResinProExpiyDate());
			prep.setString(22, server.getProviders());
			prep.setString(23, server.getDomainExpiryDate());
			prep.setInt(24, server.getSshPorts());
			prep.setInt(25, server.getSkynetActive());
			prep.setString(26, server.getSkynetVersion());
			prep.setInt(27, server.getOffsiteBackupActive());
			prep.setString(28, server.getExternalIPAddress());
			prep.setInt(29, server.getClientId());
			prep.setInt(30, server.getDbArchiverStatus());
			prep.setString(31, server.getdBArchiverRuntime());
			prep.setInt(32, server.getLogLifespan());
			prep.setString(33, server.getBackUpDirectory());
			prep.setString(34, server.getBackUpLocation());
			prep.setString(35, server.getBackupTime());
			prep.setString(36, server.getRam());
			prep.setString(37, server.getCores());
			prep.setString(38, server.getHdd());
			prep.setInt(39, server.getServerId());
			

			if(prep.executeUpdate() < 1){
				//TODO log something here
			}else{
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(prep != null){
					prep.close();
					prep = null;
				}
				if(con != null){
					con.close();
					con = null;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return server;
	}
    
    public synchronized void deleteServer(Server aServer) {
		
    	try {
			con = dbu.getConnection("CENTRAL");
			prep = con.prepareStatement("DELETE FROM SERVER WHERE SERVER_ID = ?");
			prep.setInt(1,aServer.getServerId());
	
			if(prep.executeUpdate() < 1){
				//TODO log something here
			}else{
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(prep != null){
					prep.close();
					prep = null;
				}
				if(con != null){
					con.close();
					con = null;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void createServer(Server server) {
		
		try {
			con = dbu.getConnection("CENTRAL");
			prep = con.prepareStatement("INSERT INTO SERVER (SERVER_APPLICATION_LOCATION, SERVER_TYPE, SERVER_ROLE, IP_ADDRESS, HOST_NAME,"+ 
				"DESCRIPTION, SSL_KEY, SSL_EXPIREY, PROVIDER, OS, OS_TYPE, OS_VERSION, DESCRIPTION_PURPOSE, MACHINE_TYPE, PROSSESOR, MONTHLY_COST,"+ 
				"USER_NAME, NOTES, PASSWORD, IS_RESIN_PRO, RESIN_PRO_EXPIREY_DATE, PROVIDERS, DOMAIN_EXPIREY_DATE, SSH_PORTS, SKYNET_ACTIVE, SKYNET_VERSION,"+ 
				"OFFSITE_BACKUP_ACTIVE, EXTERNAL_IP_ADDRESS, CLIENT_ID, DB_ARCHIVER_STATUS, DB_ARCHIVER_RUNTIME, LOG_LIFESPAN, BACKUP_DIRECTORY, BACKUP_LOCATION,"+ 
				"BACKUP_TIME, RAM, CORES, HDD) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			prep.setString(1, server.getServerApplicationLocation());
			prep.setString(2, server.getServerType());
			prep.setString(3, server.getServerRole());
			prep.setString(4, server.getIPAddress());
			prep.setString(5, server.getHostName());
			prep.setString(6, server.getDescription());
			prep.setInt(7, server.getSslKey());
			prep.setString(8, server.getSslExpiry());
			prep.setString(9, server.getProvider());
			prep.setString(10, server.getOs());
			prep.setString(11, server.getOsType());
			prep.setString(12, server.getOsVersion());
			prep.setString(13, server.getDescriptionPurpose());
			prep.setString(14, server.getMachineType());
			prep.setString(15, server.getProsessor());
			prep.setInt(16, server.getMonthlyCost());
			prep.setString(17, server.getUserName());
			prep.setString(18, server.getNotes());
			prep.setString(19, server.getPassword());
			prep.setInt(20, server.getIsResinPro());
			prep.setString(21, server.getResinProExpiyDate());
			prep.setString(22, server.getProviders());
			prep.setString(23, server.getDomainExpiryDate());
			prep.setInt(24, server.getSshPorts());
			prep.setInt(25, server.getSkynetActive());
			prep.setString(26, server.getSkynetVersion());
			prep.setInt(27, server.getOffsiteBackupActive());
			prep.setString(28, server.getExternalIPAddress());
			prep.setInt(29, server.getClientId());
			prep.setInt(30, server.getDbArchiverStatus());
			prep.setString(31, server.getdBArchiverRuntime());
			prep.setInt(32, server.getLogLifespan());
			prep.setString(33, server.getBackUpDirectory());
			prep.setString(34, server.getBackUpLocation());
			prep.setString(35, server.getBackupTime());
			prep.setString(36, server.getRam());
			prep.setString(37, server.getCores());
			prep.setString(38, server.getHdd());
			
			if(prep.executeUpdate() < 1){
				//TODO log something here
			}else{
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(prep != null){
					prep.close();
					prep = null;
				}
				if(con != null){
					con.close();
					con = null;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}	
	}
}
