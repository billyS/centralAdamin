package uk.co.F1x2Games.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.stereotype.Service;

import uk.co.F1x2Games.DatabaseUtils;
import uk.co.F1x2Games.Session;
import uk.co.F1x2Games.users.model.User;

@Service
public class UserSessionService {
	
	public void insertUserSessionStart(User aUser, String sessionToken){
		
		DatabaseUtils dbu =  DatabaseUtils.getInstance();
		Connection con = null;
		PreparedStatement prep = null;
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar now = Calendar.getInstance();
		String insertChangeLogSQL = "INSERT INTO USER_SESSIONS" + "(USER_ID, LOGIN_TIME, SESSION_TOKEN) VALUES" + "(?,?,?)";

		try {
			con = dbu.getConnection("CENTRAL");
			prep = con.prepareStatement(insertChangeLogSQL);
			prep.setInt(1,aUser.getUserId());
			prep.setString(2, formatter.format(now.getTime()));
			prep.setString(3,sessionToken);
			prep.executeUpdate();
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
	
	public void insertUserSessionEnd(User aUser, String sessionToken){
		
		DatabaseUtils dbu =  DatabaseUtils.getInstance();
		Connection con = null;
		PreparedStatement prep = null;
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar now = Calendar.getInstance();
		String insertChangeLogSQL = "UPDATE USER_SESSIONS SET LOGOUT_TIME=? WHERE USER_ID=?";

		try {
			con = dbu.getConnection("CENTRAL");
			prep = con.prepareStatement(insertChangeLogSQL);
			prep.setInt(1,aUser.getUserId());
			prep.setString(2, formatter.format(now.getTime()));
			prep.setString(2,sessionToken);
			prep.executeUpdate();
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
	
	public Session getUserSession(int userId){
		
		Session aSession = new Session();
		DatabaseUtils dbu =  DatabaseUtils.getInstance();
		Connection con = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		String insertChangeLogSQL = "SELECT * FROM  USER_SESSIONS WHERE USER_ID = ? ORDER BY SESSION_ID DESC LIMIT 1";

		try {
			con = dbu.getConnection("CENTRAL");
			prep = con.prepareStatement(insertChangeLogSQL);
			prep.setInt(1,userId);
			
			rs = prep.executeQuery();
			
			while(rs.next()){
				aSession.setLoginTime(rs.getString("LOGIN_TIME"));
				aSession.setSessionId(rs.getInt("SESSION_ID"));
				aSession.setSessionToken(rs.getString("SESSION_TOKEN"));
				aSession.setUserId(rs.getInt("USER_ID"));
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
		
		return aSession;
	}

}
