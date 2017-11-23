package uk.co.F1x2Games.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Service;

import uk.co.F1x2Games.Client;
import uk.co.F1x2Games.DatabaseUtils;
import uk.co.F1x2Games.Utils;

@Service
public class ClientService {
	
	int configuration = 100;
    int limit = 1000;
    Properties properties;
	PropertyPlaceholderConfigurer props2;
	List<Client> clientList;
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(ClientService.class);
    //String clientName = properties.getProperty("client_name");
	
	public ClientService(){
		super();
		try {
			properties= PropertiesLoaderUtils.loadAllProperties("General.properties");
			props2 = new PropertyPlaceholderConfigurer();
			props2.setProperties(properties);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	DatabaseUtils dbu =  DatabaseUtils.getInstance();
    Utils util =  Utils.getInstance();
    Connection con;
    ResultSet rs;
    PreparedStatement prep;

	public Client saveClient(Client aClient) {
		
		try {
			con = dbu.getConnection("CENTRAL");
			prep = con.prepareStatement("UPDATE CLIENT SET CLIENT_NAME=?, CLIENT_ALIAS=?, CLIENT_LIVE=?, CLIENT_STATUS=?, CLIENT_START_INTEGRATION=?, CLIENT_SHUT_DATE=?, CLIENT_IS_PLATFORM=?, CLIENT_ADMIN_LINK=?, CLIENT_BASE_CURRENCY=?, CLIENT_MONTHLEY_MIN_FEE=?," 
										+"CLIENT_CONTRACT_SIGNED=?, CLIENT_JURISDICTION=? WHERE CLIENT_ID=?");

			prep.setString(1, aClient.getClientName());
			prep.setString(2, aClient.getClientAlias());
			prep.setInt(3, aClient.getClientLive());
			prep.setString(4, aClient.getClientStatus());
			prep.setString(5, aClient.getClientStartIntegration());
			prep.setString(6, aClient.getClientShutDate());
			prep.setInt(7, aClient.getClientIsPlatform());
			prep.setString(8, aClient.getClientAdminLink());
			prep.setString(9, aClient.getClientBaseCurrency());
			prep.setInt(10, aClient.getClientMonthleyFee());
			prep.setInt(11, aClient.getClientContractSigned());
			prep.setString(12, aClient.getClientJuristriction());
			prep.setInt(13, aClient.getClientId());
			
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
		return aClient;
	}

	public List<Client> getClients() {
		clientList = new ArrayList<Client>();
		
		
		try {
			con = dbu.getConnection("CENTRAL");
			prep = con.prepareStatement("Select * from CLIENT");
			rs = prep.executeQuery();

			while (rs.next()){
				Client client = new Client();
				client.setClientId(rs.getInt("CLIENT_ID"));
				logger.debug("[Client Service] getClientsTable: Before adding to list Client Id = " + client.getClientId());
				client.setClientName(rs.getString("CLIENT_NAME"));
				client.setClientAlias(rs.getString("CLIENT_ALIAS"));
				client.setClientLive(rs.getInt("CLIENT_LIVE"));
				client.setClientStatus(rs.getString("CLIENT_STATUS"));
				client.setClientStartIntegration(rs.getString("CLIENT_START_INTEGRATION"));
				client.setClientShutDate(rs.getString("CLIENT_SHUT_DATE"));
				client.setClientIsPlatform(rs.getInt("CLIENT_IS_PLATFORM"));
				client.setClientAdminLink(rs.getString("CLIENT_ADMIN_LINK"));
				client.setClientBaseCurrency(rs.getString("CLIENT_BASE_CURRENCY"));
				client.setClientMonthleyFee(rs.getInt("CLIENT_MONTHLEY_MIN_FEE"));
				client.setClientContractSigned(rs.getInt("CLIENT_CONTRACT_SIGNED"));
				client.setClientJuristriction(rs.getString("CLIENT_JURISDICTION"));
				clientList.add(client);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		return clientList;
	}

	public Client getClient(int clientId) {
		Client client = new Client();
		try {
			con = dbu.getConnection("CENTRAL");
			prep = con.prepareStatement("Select * from CLIENT WHERE CLIENT_ID=?");
			prep.setInt(1,clientId);
			rs = prep.executeQuery();

			while (rs.next()){
				client.setClientId(rs.getInt("CLIENT_ID"));
				client.setClientName(rs.getString("CLIENT_NAME"));
				client.setClientAlias(rs.getString("CLIENT_ALIAS"));
				client.setClientLive(rs.getInt("CLIENT_LIVE"));
				client.setClientStatus(rs.getString("CLIENT_STATUS"));
				client.setClientStartIntegration(rs.getString("CLIENT_START_INTEGRATION"));
				client.setClientShutDate(rs.getString("CLIENT_SHUT_DATE"));
				client.setClientIsPlatform(rs.getInt("CLIENT_IS_PLATFORM"));
				client.setClientAdminLink(rs.getString("CLIENT_ADMIN_LINK"));
				client.setClientBaseCurrency(rs.getString("CLIENT_BASE_CURRENCY"));
				client.setClientMonthleyFee(rs.getInt("CLIENT_MONTHLEY_MIN_FEE"));
				client.setClientContractSigned(rs.getInt("CLIENT_CONTRACT_SIGNED"));
				client.setClientJuristriction(rs.getString("CLIENT_JURISDICTION"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		return client;
	}
	
	public Client getClient(String clientName) {
		Client client = new Client();
		try {
			con = dbu.getConnection("CENTRAL");
			prep = con.prepareStatement("Select * from CLIENT WHERE CLIENT_NAME=?");
			prep.setString(1,clientName);
			
			rs = prep.executeQuery();

			while (rs.next()){
				client.setClientId(rs.getInt("CLIENT_ID"));
				client.setClientName(rs.getString("CLIENT_NAME"));
				client.setClientAlias(rs.getString("CLIENT_ALIAS"));
				client.setClientLive(rs.getInt("CLIENT_LIVE"));
				client.setClientStatus(rs.getString("CLIENT_STATUS"));
				client.setClientStartIntegration(rs.getString("CLIENT_START_INTEGRATION"));
				client.setClientShutDate(rs.getString("CLIENT_SHUT_DATE"));
				client.setClientIsPlatform(rs.getInt("CLIENT_IS_PLATFORM"));
				client.setClientAdminLink(rs.getString("CLIENT_ADMIN_LINK"));
				client.setClientBaseCurrency(rs.getString("CLIENT_BASE_CURRENCY"));
				client.setClientMonthleyFee(rs.getInt("CLIENT_MONTHLEY_MIN_FEE"));
				client.setClientContractSigned(rs.getInt("CLIENT_CONTRACT_SIGNED"));
				client.setClientJuristriction(rs.getString("CLIENT_JURISDICTION"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		return client;
	}

	public Client createClient(Client aClient) {
		try {
			con = dbu.getConnection("CENTRAL");
			prep = con.prepareStatement("INSERT INTO CLIENT (CLIENT_NAME, CLIENT_ALIAS, CLIENT_LIVE, CLIENT_STATUS, CLIENT_START_INTEGRATION, CLIENT_SHUT_DATE, CLIENT_IS_PLATFORM, CLIENT_ADMIN_LINK, CLIENT_BASE_CURRENCY, CLIENT_MONTHLEY_MIN_FEE,"+ 
										"CLIENT_CONTRACT_SIGNED, CLIENT_JURISDICTION) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");

			prep.setString(1, aClient.getClientName());
			prep.setString(2, aClient.getClientAlias());
			prep.setInt(3, aClient.getClientLive());
			prep.setString(4, aClient.getClientStatus());
			prep.setString(5, aClient.getClientStartIntegration());
			prep.setString(6, aClient.getClientShutDate());
			prep.setInt(7, aClient.getClientIsPlatform());
			prep.setString(8, aClient.getClientAdminLink());
			prep.setString(9, aClient.getClientBaseCurrency());
			prep.setInt(10, aClient.getClientMonthleyFee());
			prep.setInt(11, aClient.getClientContractSigned());
			prep.setString(12, aClient.getClientJuristriction());
			
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
		return aClient;
	}

	public void deleteClient(Client aClient) {
		try {
			con = dbu.getConnection("CENTRAL");
			prep = con.prepareStatement("DELETE FROM CLIENT WHERE CLIENT_ID=?");
			
			prep.setInt(1, aClient.getClientId());
		
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
