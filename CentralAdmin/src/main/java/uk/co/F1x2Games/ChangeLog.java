package uk.co.F1x2Games;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import com.google.gson.Gson;

public class ChangeLog {
	
private String description;
private int userId, logId;

private Date timeStamp;
DatabaseUtils dbu =  DatabaseUtils.getInstance();
Utils util =  Utils.getInstance();
Connection con;
ResultSet rs;
PreparedStatement prep;
private ChangeLog aChangeLog;

public int getLogId() {
	return logId;
}
public void setLogId(int logId) {
	this.logId = logId;
}

public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public Date getTimeStamp() {
	return timeStamp;
}
public void setTimeStamp(Date timeStamp) {
	this.timeStamp = timeStamp;
}
public ChangeLog getChangeLog(int userId){

	String selectChangeLogSQL 	= "SELECT * FROM CHANGE_LOG WHERE USER_ID=?";
	
	try {
		con = dbu.getConnection("ADMIN");
		prep = con.prepareStatement(selectChangeLogSQL);
		prep.setInt(1,userId);
		rs = prep.executeQuery();  
		
		if (rs.next()){
			aChangeLog.setDescription(rs.getString("DESCRIPTION"));
			aChangeLog.setTimeStamp(rs.getDate("TIMESTAMP"));
			aChangeLog.setUserId(rs.getInt("USER_ID"));
			
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
	return aChangeLog;	
}

}
