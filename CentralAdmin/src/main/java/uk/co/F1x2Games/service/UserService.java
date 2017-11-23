package uk.co.F1x2Games.service;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import uk.co.F1x2Games.ChangeLog;
import uk.co.F1x2Games.DatabaseUtils;
import uk.co.F1x2Games.PasswordEncoderGenerator;
import uk.co.F1x2Games.ResetToken;
import uk.co.F1x2Games.users.model.User;
import uk.co.F1x2Games.Utils;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.SecureRandom;

/**
 * @author billy.sneddon
 *
 */
@Service
public class UserService {
	
    int configuration = 100;
    int limit = 1000;
    Properties properties;
	PropertyPlaceholderConfigurer props2;
	List<User> userList;
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(UserService.class);
	private  Random RANDOM = new SecureRandom();
    //String clientName = properties.getProperty("client_name");
	PasswordEncoderGenerator passGen = new PasswordEncoderGenerator();
	private UserSessionService sessionService; 
   
	public UserService() {
		super();
		try {
			sessionService = new UserSessionService();
		
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
	private String description;
	String username="";
	String password="";
	
	public Gson getUser(User aUser){
		Gson gUser= new Gson();
		gUser.toJson(aUser);
		return gUser;
		
	}
	
	public synchronized List<User> getUsers() {
		
		userList = new ArrayList<User>();
		User user = null;
		Connection con1 =null;
		ResultSet rs1 = null;
		PreparedStatement prep1=null;
		
		try {
			con1 = dbu.getConnection("CENTRAL");
			prep1 = con1.prepareStatement("Select * from USERS");
			rs1 = prep1.executeQuery();

			while (rs1.next()){
				user = new User();
				user.setUsername(rs1.getString("USER_NAME"));
				user.setPassword(rs1.getString("PASSWORD"));
				user.setUserId(rs1.getInt("USER_ID"));
				user.setEnabled(rs1.getInt("ENABLED"));
				user.setEmailAddress(rs1.getString("EMAIL_ADDRESS"));
				user.setFirstName(rs1.getString("FIRST_NAME"));
				user.setLastName(rs1.getString("LAST_NAME"));
				
				if(rs1.getInt("accountNonExpired") > 0){
					user.setAccountNonExpired(false);
				}else{
					user.setAccountNonExpired(true);
				}
				
				if(rs1.getInt("accountNonLocked") > 0){
					user.setAccountNonLocked(false);
				}else{
					user.setAccountNonLocked(true);
				}
				
				if(rs1.getInt("credentialsNonExpired") > 0){
					user.setCredentialsNonExpired(false);
				}else{
					user.setCredentialsNonExpired(true);
				}
				
				userList.add(getUserRoles(user));
				//checkAccess();
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs1 != null){
					rs1.close();
					rs1 	= null;
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
		return userList;
	}

	public User getUser(String aUsername, String aPassword) {
		String name;
		User user = null;
		
		try {
			con = dbu.getConnection("CENTRAL");
			prep = con.prepareStatement("Select * from USERS where USER_NAME = ? AND PASSWORD = ?");
			prep.setString(1,aUsername);
			prep.setString(2,aPassword);
			rs = prep.executeQuery();

			if (rs.next()){
				user = new User();
				user = new User();
				user.setUsername(rs.getString("USER_NAME"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setUserId(rs.getInt("USER_ID"));
				user.setEnabled(rs.getInt("ENABLED"));
				user.setEmailAddress(rs.getString("EMAIL_ADDRESS"));
				user.setFirstName(rs.getString("FIRST_NAME"));
				user.setLastName(rs.getString("LAST_NAME"));
				
				if(rs.getInt("accountNonExpired") > 0){
					user.setAccountNonExpired(false);
				}else{
					user.setAccountNonExpired(true);
				}
				
				if(rs.getInt("accountNonLocked") > 0){
					user.setAccountNonLocked(false);
				}else{
					user.setAccountNonLocked(true);
				}
				
				if(rs.getInt("credentialsNonExpired") > 0){
					user.setCredentialsNonExpired(false);
				}else{
					user.setCredentialsNonExpired(true);
				}
				//checkAccess();
				
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
		return user;
	}
	
	public User getUser(String aUsername) {
		String name;
		User user = null;
		
		try {
			con = dbu.getConnection("CENTRAL");
			prep = con.prepareStatement("Select * from USERS where USER_NAME = ?");
			prep.setString(1,aUsername);
			rs = prep.executeQuery();

			if (rs.next()){
				user = new User();
				user = new User();
				user.setUsername(rs.getString("USER_NAME"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setUserId(rs.getInt("USER_ID"));
				user.setEnabled(rs.getInt("ENABLED"));
				user.setEmailAddress(rs.getString("EMAIL_ADDRESS"));
				user.setFirstName(rs.getString("FIRST_NAME"));
				user.setLastName(rs.getString("LAST_NAME"));
				
				if(rs.getInt("accountNonExpired") > 0){
					user.setAccountNonExpired(false);
				}else{
					user.setAccountNonExpired(true);
				}
				
				if(rs.getInt("accountNonLocked") > 0){
					user.setAccountNonLocked(false);
				}else{
					user.setAccountNonLocked(true);
				}
				
				if(rs.getInt("credentialsNonExpired") > 0){
					user.setCredentialsNonExpired(false);
				}else{
					user.setCredentialsNonExpired(true);
				}
				
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
		return user;
	}
	
	public User getUser(int userId) {
		String name;
		User user = null;
		
		try {
			con = dbu.getConnection("CENTRAL");
			prep = con.prepareStatement("Select * from USERS where USER_ID = ?");
			prep.setInt(1,userId);
			rs = prep.executeQuery();

			if (rs.next()){
				user = new User();
				user = new User();
				user.setUsername(rs.getString("USER_NAME"));
				user.setUserId(rs.getInt("USER_ID"));
				user.setEnabled(rs.getInt("ENABLED"));
				user.setEmailAddress(rs.getString("EMAIL_ADDRESS"));
				user.setFirstName(rs.getString("FIRST_NAME"));
				user.setLastName(rs.getString("LAST_NAME"));
				
				if(rs.getInt("accountNonExpired") > 0){
					user.setAccountNonExpired(false);
				}else{
					user.setAccountNonExpired(true);
				}
				
				if(rs.getInt("accountNonLocked") > 0){
					user.setAccountNonLocked(false);
				}else{
					user.setAccountNonLocked(true);
				}
				
				if(rs.getInt("credentialsNonExpired") > 0){
					user.setCredentialsNonExpired(false);
				}else{
					user.setCredentialsNonExpired(true);
				}
				
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
		return user;
	}
   
    public User getUserSession(int userId){
    	
    	User aUser = getUser(userId);
    	try {
    		con = dbu.getConnection("CENTRAL");
			prep = con.prepareStatement("Select * from USERS_SESSIONS where USER_ID = ?");
	    	prep.setInt(1,aUser.getUserId());
	    	
	        rs = prep.executeQuery();
	        
	        while(rs.next()){
	        	aUser.setLoginTime("" + rs.getDate("LOGIN_TIME"));
	        	aUser.setSessionId(rs.getInt("SESSION_ID"));
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
    	
    	return aUser;
    }
    
    public void changeUserPassword(int userId, String username, String password){
    	User adminUser = getUser(userId);
    	User aUser = getUser(userId);
    	StringBuilder description = new StringBuilder();
    	description.append("User: ");
    	description.append(adminUser.getUsername());
    	description.append("changed the password for ");
    	description.append(aUser.getUsername());

    	final Random r = new SecureRandom();
    	byte[] salt = new byte[32];
    	r.nextBytes(salt);
    	
    	aUser.setPassword(hashPassword(password, salt.toString()));
    	saveUser(aUser);
    	updateChangeLog(adminUser, description.toString());
    }
    
    /**
     * Creating a user and assigning a user role
     * @param aUser
     * @return The newly created user
     */
    public User createUser(User aUser) {
		System.out.println(aUser.getUserId());
		//TODO Get Session Id from Session table to insert into this table
		int userId=0;
    	try {
			con = dbu.getConnection("CENTRAL");
			prep = con.prepareStatement("INSERT INTO USERS (USER_NAME, ENABLED, FIRST_NAME, LAST_NAME, EMAIL_ADDRESS, PASSWORD, accountNonExpired, credentialsNonExpired, accountNonLocked) VALUES(?,?,?,?,?,?,?,?,?)");
			prep.setString(1,aUser.getUsername());
			prep.setInt(2,aUser.getEnabled());
			prep.setString(3,aUser.getFirstName());
			prep.setString(4,aUser.getLastName());
			prep.setString(5,aUser.getEmailAddress());
			String password = passGen.encodePassword(aUser.getPassword());
			prep.setString(6,password);
			
			if(aUser.getAccountNonExpired()){
				prep.setInt(7, 0);
			}else{
				prep.setInt(7, 1);
			}
			if(aUser.getCredentialsNonExpired()){
				prep.setInt(8, 0);
			}else{
				prep.setInt(8, 1);
			}
			if(aUser.getAccountNonLocked()){
				prep.setInt(9, 0);
			}else{
				prep.setInt(9, 1);
			}
			
			if(prep.executeUpdate() < 1){
				
			}else{
				
			}
			
			prep = con.prepareStatement("SELECT LAST_INSERT_ID() FROM USERS");
			rs = prep.executeQuery();
				
			if(rs.next()){
				userId = rs.getInt(1);
			}
		
			addUserRoles(userId,aUser);

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
		return aUser;
	}
    
    private void updateUserSession() {
		
	}

	private void addUserRoles(int userId, User aUser) {
    	
    	try {
    		prep = con.prepareStatement("INSERT INTO USER_ROLES (USER_ID, USER_NAME,ROLE) VALUES(?,?,?)");
    		prep.setInt(1, userId);
    		prep.setString(2,aUser.getUsername());
    		prep.setString(3,aUser.getRole());
			
			if(prep.executeUpdate() < 1){
				
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

	public User saveUser(User aUser) {
	
    	try {
			con = dbu.getConnection("CENTRAL");
			prep = con.prepareStatement("UPDATE USERS SET USER_NAME=?, ENABLED=?, EMAIL_ADDRESS=?, FIRST_NAME=?, LAST_NAME=?, accountNonExpired=?, credentialsNonExpired=?, accountNonLocked=? WHERE USER_ID = ?");
			prep.setString(1,aUser.getUsername());
			prep.setInt(2,aUser.getEnabled());
			prep.setString(3,aUser.getEmailAddress());
			prep.setString(4,aUser.getFirstName());
			prep.setString(5,aUser.getLastName());
			if(aUser.getAccountNonExpired()){
				prep.setInt(6, 0);
			}else{
				prep.setInt(6, 1);
			}
			if(aUser.getCredentialsNonExpired()){
				prep.setInt(7, 0);
			}else{
				prep.setInt(7, 1);
			}
			if(aUser.getAccountNonLocked()){
				prep.setInt(8, 0);
			}else{
				prep.setInt(8, 1);
			}
			prep.setInt(9,aUser.getUserId());

			if(prep.executeUpdate() < 1){
				//TODO log something here
			}else{
				
			}
			
			prep = con.prepareStatement("UPDATE USER_ROLES SET ROLE=? WHERE USER_ID=?");
			prep.setString(1,aUser.getRole());
			prep.setInt(2,aUser.getUserId());
			
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
		return aUser;
	}
    
    public synchronized void deleteUser(User aUser) {
		//System.out.println(aUser.getUserId());
    	try {
			con = dbu.getConnection("CENTRAL");
			prep = con.prepareStatement("DELETE FROM USERS WHERE USER_ID = ?");
			prep.setInt(1,aUser.getUserId());
	
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

	public String hashPassword(String passwordToHash, String   salt){
    	String generatedPassword = null;
    	    try {
    	         MessageDigest md = MessageDigest.getInstance("SHA-512");
    	         md.update(salt.getBytes("UTF-8"));
    	         byte[] bytes = md.digest(passwordToHash.getBytes("UTF-8"));
    	         StringBuilder sb = new StringBuilder();
    	         for(int i=0; i< bytes.length ;i++){
    	            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
    	         }
    	         generatedPassword = sb.toString();
    	        } 
    	       catch (Exception e){
    	        e.printStackTrace();
    	       }
    	    return generatedPassword;
    	}
	
	public void changeFirstName(int userId, String name){
		
		User adminUser = getUser(userId);
		User aUser = getUser(username);
		
    	StringBuilder description = new StringBuilder();
    	description.append("User: ");
    	description.append(adminUser.getUsername());
    	description.append("changed the first name for ");
    	description.append(aUser.getUsername());
		
		aUser.setFirstName(name);
		saveUser(aUser);
    	updateChangeLog(adminUser, description.toString());

	}
	
	public void changeLastName(int userId, String name){
		
		User adminUser = getUser(userId);
		User aUser = getUser(username);
		
    	StringBuilder description = new StringBuilder();
    	description.append("User: ");
    	description.append(adminUser.getUsername());
    	description.append("changed the last name for ");
    	description.append(aUser.getUsername());
    	
		aUser.setLastName(name);
		saveUser(aUser);
    	updateChangeLog(adminUser, description.toString());
	}
	
	public void changeEmailAddress(int userId, String emailAddress){
		
		User adminUser = getUser(userId);
		User aUser = getUser(username);
		
    	StringBuilder description = new StringBuilder();
    	description.append("User: ");
    	description.append(adminUser.getUsername());
    	description.append("changed the email address for ");
    	description.append(aUser.getUsername());
    	
		aUser.setEmailAddress(emailAddress);
		saveUser(aUser);
    	updateChangeLog(adminUser, description.toString());

	}
	
	public void updateChangeLog(User aUser, String description){
		
		String insertChangeLogSQL 	= "INSERT INTO CHANGE_LOG"
									+ "(USER_ID, DESCRIPTION, TIMESTAMP) VALUES"
									+ "(?,?,?)";
		try {
			con = dbu.getConnection("CENTRAL");
			prep = con.prepareStatement(insertChangeLogSQL);
			prep.setInt(1,aUser.getUserId());
			prep.setString(2,description);
			prep.setDate(3, getCurrentTimeStamp());
			rs = prep.executeQuery();  //TODO check if i need the resultSet
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
	}

	private Date getCurrentTimeStamp() {
		java.util.Date today = new java.util.Date();
		
		return (Date) today;
	}
	
	public Gson getChangeLog(int userId){
		
		ChangeLog aChangeLog = new ChangeLog().getChangeLog(userId);
		Gson changeLog = new Gson();
		changeLog.toJson(aChangeLog);	
		return changeLog;
	}
	
	public byte[] getNextSalt() {
	    byte[] salt = new byte[16];
	    RANDOM.nextBytes(salt);
	    return salt;
	}
	
	public User getUserRoles(User aUser){
		
		try {
			con = dbu.getConnection("CENTRAL");
			prep = con.prepareStatement("Select * from USER_ROLES WHERE USER_ID=?");
			prep.setInt(1,aUser.getUserId());
			
			rs = prep.executeQuery();
			while (rs.next()){
				
				if(rs.getString("ROLE").equalsIgnoreCase("ROLE_ADMIN")){ 
					aUser.setRole("Admin");
				}
				else { 
					aUser.setRole("User");
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
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
		return aUser;
	}

	
	public void unlockUser(User aUser) {
		//System.out.println(aUser.getUserId());
    	try {
			con = dbu.getConnection("CENTRAL");
			prep = con.prepareStatement("UPDATE USERS SET accountNonLocked=1 WHERE USER_ID=?;");
			prep.setInt(1,aUser.getUserId());
	
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

	
	
	//TODO Add disable user method!!!!
}
