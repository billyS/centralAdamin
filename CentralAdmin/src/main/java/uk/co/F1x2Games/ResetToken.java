package uk.co.F1x2Games;

import java.util.Date;

public class ResetToken {
 private static final int EXPIRATION = 60 * 24;
 private int tokenId;
 private String token;
 private Date expiryDate;
 private String userName;
 
 
 public Date getExpiryDate() {
	return expiryDate;
}
public void setExpiryDate(Date expiryDate) {
	this.expiryDate = expiryDate;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public int getTokenId() {
	return tokenId;
}
public void setTokenId(int tokenId) {
	this.tokenId = tokenId;
}
public String getToken() {
	return token;
}
public void setToken(String token) {
	this.token = token;
}

 
}
