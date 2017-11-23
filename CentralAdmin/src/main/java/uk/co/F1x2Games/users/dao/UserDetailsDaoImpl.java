package uk.co.F1x2Games.users.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.security.authentication.LockedException;
import org.springframework.stereotype.Repository;

import uk.co.F1x2Games.users.model.UserAttempts;

@Repository
public class UserDetailsDaoImpl extends JdbcDaoSupport implements UserDetailsDao {

	private static final String SQL_USERS_UPDATE_LOCKED = "UPDATE USERS SET accountNonLocked = ? WHERE USER_NAME = ?";
	private static final String SQL_USERS_COUNT = "SELECT count(*) FROM USERS WHERE USER_NAME = ?";

	private static final String SQL_USER_ATTEMPTS_GET = "SELECT * FROM FAILED_LOGIN_ATTEMPTS WHERE USER_NAME = ?";
	private static final String SQL_USER_ATTEMPTS_INSERT = "INSERT INTO FAILED_LOGIN_ATTEMPTS (USER_NAME, ATTEMPTS, LAST_MODIFIED) VALUES(?,?,?)";

	private static final String SQL_USER_ATTEMPTS_UPDATE_ATTEMPTS = "UPDATE FAILED_LOGIN_ATTEMPTS SET ATTEMPTS = ATTEMPTS + 1, LAST_MODIFIED = ? WHERE USER_NAME = ?";
	private static final String SQL_USER_ATTEMPTS_RESET_ATTEMPTS = "UPDATE FAILED_LOGIN_ATTEMPTS SET ATTEMPTS = 0, LAST_MODIFIED = null WHERE USER_NAME = ?";

	private static final int MAX_ATTEMPTS = 3;

	@Autowired
	private DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public void updateFailAttempts(String username) {

		UserAttempts user = getUserAttempts(username);
		if (user == null) {
			if (isUserExists(username)) {
				// if no record, insert a new
				getJdbcTemplate().update(SQL_USER_ATTEMPTS_INSERT, new Object[] { username, 1, new Date() });
			}
		} else {

			if (isUserExists(username)) {
				// update attempts count, +1
				getJdbcTemplate().update(SQL_USER_ATTEMPTS_UPDATE_ATTEMPTS, new Object[] { new Date(), username });
			}

			if (user.getAttempts() + 1 >= MAX_ATTEMPTS) {
				// locked user
				getJdbcTemplate().update(SQL_USERS_UPDATE_LOCKED, new Object[] { false, username });
				// throw exception
				throw new LockedException("User Account is locked!");
			}

		}

	}

	@Override
	public UserAttempts getUserAttempts(String username) {

		try {

			UserAttempts userAttempts = getJdbcTemplate().queryForObject(SQL_USER_ATTEMPTS_GET,
					new Object[] { username }, new RowMapper<UserAttempts>() {
						public UserAttempts mapRow(ResultSet rs, int rowNum) throws SQLException {

							UserAttempts user = new UserAttempts();
							user.setId(rs.getInt("id"));
							user.setUsername(rs.getString("USER_NAME"));
							user.setAttempts(rs.getInt("ATTEMPTS"));
							user.setLastModified(rs.getDate("LAST_MODIFIED"));

							return user;
						}

					});
			return userAttempts;

		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	@Override
	public void resetFailAttempts(String username) {

		getJdbcTemplate().update(SQL_USER_ATTEMPTS_RESET_ATTEMPTS, new Object[] { username });

	}

	private boolean isUserExists(String username) {

		boolean result = false;

		int count = getJdbcTemplate().queryForObject(SQL_USERS_COUNT, new Object[] { username }, Integer.class);
		if (count > 0) {
			result = true;
		}

		return result;
	}

}