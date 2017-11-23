package uk.co.F1x2Games;
import java.security.SecureRandom;
import java.util.Date;
import java.math.BigInteger;

public final class ResetTokenGenerator {
	
  private SecureRandom random = new SecureRandom();
  private static final int EXPIRATION = 60 * 24;
  private Date expiryDate;

  public ResetToken nextResetToken() {
	  ResetToken token = new ResetToken();
	  token.setToken(new BigInteger(100, random).toString(32));
	  
	  return token;
  }
	  
}