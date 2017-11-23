package uk.co.F1x2Games.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.co.F1x2Games.DatabaseUtils;
import uk.co.F1x2Games.ResetToken;
import uk.co.F1x2Games.ResetTokenGenerator;
import uk.co.F1x2Games.Utils;

@Service
public class PasswordResetService {

	@Autowired
	private ResetTokenGenerator gen;
	
	public ResetToken createToken(String userName) {

		DatabaseUtils dbu =  DatabaseUtils.getInstance();
		Utils util =  Utils.getInstance();
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement prep = null;

		ResetToken token = new ResetToken();
		
		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar now = Calendar.getInstance();
	
		try {
			con = dbu.getConnection("CENTRAL");
			prep = con.prepareStatement("INSERT INTO PASSWORD_RESET_TOKEN (TOKEN, USER_NAME, EXPIRY_TIME) VALUES(?,?,?)");
			prep.setString(1,gen.nextResetToken().getToken());
			prep.setString(2, userName);
			prep.setString(3,formatter.format(now.getTime()));

			prep.executeUpdate();
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
		return null;
	}

	public ResetToken getResteToken(int tokenId) {

		DatabaseUtils dbu =  DatabaseUtils.getInstance();
		Utils util =  Utils.getInstance();
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement prep = null;

		ResetToken token = new ResetToken();

		try {
			con = dbu.getConnection("CENTRAL");
			prep = con.prepareStatement("Select * from PASSWORD_RESET_TOKEN WHERE TOKEN_ID=?");
			prep.setInt(1,tokenId);

			rs = prep.executeQuery();
			while (rs.next()){
				token.setToken(rs.getString("TOKEN"));
				token.setTokenId(rs.getInt("TOKEN_ID"));
				token.setUserName(rs.getString("USER_NAME"));
				token.setExpiryDate(rs.getDate("EXPIRY_TIME"));
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
		return null;
	}
}
