package uk.co.F1x2Games.handeler;

import java.util.Date;

import javax.mail.MessagingException;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

//import uk.co.F1x2Games.PostMan;
import uk.co.F1x2Games.users.dao.UserDetailsDao;
import uk.co.F1x2Games.users.model.UserAttempts;


public class LimitLoginAuthenticationProvider extends DaoAuthenticationProvider {

	UserDetailsDao userDetailsDao;
	String [] recipients = {"sneddon.billy@yahoo.co.uk","billy.sneddon@1x2gaming.com"};
    //PostMan postman;
  
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		try {

			Authentication auth = super.authenticate(authentication);

			// if here, login successful, else exception will be thrown
			// reset the user_attempts
			userDetailsDao.resetFailAttempts(authentication.getName());

			return auth;

		} catch (BadCredentialsException e) {
			//TODO Remember to log this stuff!!!
			userDetailsDao.updateFailAttempts(authentication.getName());
			throw e;

		} catch (LockedException e) {
			
			String error = "";
			UserAttempts userAttempts = userDetailsDao.getUserAttempts(authentication.getName());
			if (userAttempts != null) {
				Date lastAttempts = userAttempts.getLastModified();
				//try {
					//postman = new PostMan();
					//postman.postMail(recipients,"Central Admin User Account Locked for User: " + authentication.getName() + " has been locked Due to to many faild login attempts. Last Login attaempt: " + lastAttempts);
				//} //catch (MessagingException e1) {
					//e1.printStackTrace();
				//}
				
				
				error = "User account is locked! <br><br>Username : " + authentication.getName()
						+ "<br>Last Attempts : " + lastAttempts;
			} else {
				error = e.getMessage();
			}

			throw new LockedException(error);
		}

	}

	public UserDetailsDao getUserDetailsDao() {
		return userDetailsDao;
	}

	public void setUserDetailsDao(UserDetailsDao userDetailsDao) {
		this.userDetailsDao = userDetailsDao;
	}

}