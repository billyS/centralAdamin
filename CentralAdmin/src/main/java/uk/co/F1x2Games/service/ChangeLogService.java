package uk.co.F1x2Games.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import uk.co.F1x2Games.ChangeLog;
import uk.co.F1x2Games.DatabaseUtils;
import uk.co.F1x2Games.Game;
import uk.co.F1x2Games.Utils;
import uk.co.F1x2Games.users.model.User;

@Service
public class ChangeLogService {


	Properties properties;
	PropertyPlaceholderConfigurer props2;
	List<ChangeLog> logList;
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(ChangeLogService.class);


	public ChangeLogService() {
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


	public void insertLog(User aUser, String description){

		DatabaseUtils dbu =  DatabaseUtils.getInstance();
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement prep = null;
		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar now = Calendar.getInstance();
		String insertChangeLogSQL = "INSERT INTO CHANGE_LOG" + "(USER_ID, DESCRIPTION, TIMESTAMP) VALUES" + "(?,?,?)";

		try {
			con = dbu.getConnection("CENTRAL");
			prep = con.prepareStatement(insertChangeLogSQL);
			prep.setInt(1,aUser.getUserId());
			prep.setString(2,description);
			prep.setString(3, formatter.format(now.getTime()));
			prep.executeUpdate();  //TODO check if i need the resultSet
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

	private String getCurrentTimeStamp() {
		java.util.Date today = new java.util.Date();

		return today.toString();
	}


	public List<ChangeLog> getlogs() {
		ChangeLog log = null; 
		DatabaseUtils dbu =  DatabaseUtils.getInstance();
	    Utils util =  Utils.getInstance();
	    Connection con = null;
	    ResultSet rs = null;;
	    PreparedStatement prep = null;;
	    logList = new ArrayList<ChangeLog>();
		try {
			con = dbu.getConnection("CENTRAL");
			prep = con.prepareStatement("Select * from CHANGE_LOG");
			rs = prep.executeQuery();

			while (rs.next()){
				log = new ChangeLog();
				log.setLogId(rs.getInt("ID"));
				log.setUserId(rs.getInt("USER_ID"));
				log.setDescription(rs.getString("DESCRIPTION"));
				log.setTimeStamp(rs.getTimestamp("TIMESTAMP"));
				logList.add(log);
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
		return logList;
	}
}
