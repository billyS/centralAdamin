package uk.co.F1x2Games.users.dao;

import uk.co.F1x2Games.users.model.UserAttempts;

public interface UserDetailsDao {

	void updateFailAttempts(String username);

	void resetFailAttempts(String username);
	
	UserAttempts getUserAttempts(String username);

}