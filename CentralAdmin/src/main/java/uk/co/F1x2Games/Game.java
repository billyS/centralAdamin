package uk.co.F1x2Games;

public class Game {
	
private String gameName, gameType, version, gameGroup, gameSubGroup, gameStatus, gameReleaseDate;

private boolean html5, flash, desktop, mobile, miniGame;

private int gameId, supplierId, estimatedDevCost, estimatedTestingCost, expectedMargin, rangeMargin;


public String getGameName() {
	return gameName;
}

public void setGameName(String gameName) {
	this.gameName = gameName;
}

public String getGameType() {
	return gameType;
}

public void setGameType(String gameType) {
	this.gameType = gameType;
}

public String getVersion() {
	return version;
}

public void setVersion(String version) {
	this.version = version;
}

public String getGameGroup() {
	return gameGroup;
}

public void setGameGroup(String gameGroup) {
	this.gameGroup = gameGroup;
}

public String getGameSubGroup() {
	return gameSubGroup;
}

public void setGameSubGroup(String gameSubGroup) {
	this.gameSubGroup = gameSubGroup;
}

public String getGameStatus() {
	return gameStatus;
}

public void setGameStatus(String gameStauts) {
	this.gameStatus = gameStauts;
}

public String getGameReleaseDate() {
	return gameReleaseDate;
}

public void setGameReleaseDate(String gameReleaseDate) {
	this.gameReleaseDate = gameReleaseDate;
}

public boolean isHtml5() {
	return html5;
}

public void setHtml5(boolean html5) {
	this.html5 = html5;
}

public boolean isFlash() {
	return flash;
}

public void setFlash(boolean flash) {
	this.flash = flash;
}

public boolean isDesktop() {
	return desktop;
}

public void setDesktop(boolean desktop) {
	this.desktop = desktop;
}

public boolean isMobile() {
	return mobile;
}

public void setMobile(boolean mobile) {
	this.mobile = mobile;
}

public boolean isMiniGame() {
	return miniGame;
}

public void setMiniGame(boolean miniGame) {
	this.miniGame = miniGame;
}

public int getGameId() {
	return gameId;
}

public void setGameId(int gameId) {
	this.gameId = gameId;
}

public int getSupplierId() {
	return supplierId;
}

public void setSupplierId(int supplierId) {
	this.supplierId = supplierId;
}

public int getEstimatedDevCost() {
	return estimatedDevCost;
}

public void setEstimatedDevCost(int estimatedDevCost) {
	this.estimatedDevCost = estimatedDevCost;
}

public int getEstimatedTestingCost() {
	return estimatedTestingCost;
}

public void setEstimatedTestingCost(int estimatedTestingCost) {
	this.estimatedTestingCost = estimatedTestingCost;
}

public int getExpectedMargin() {
	return expectedMargin;
}

public void setExpectedMargin(int expectedMargin) {
	this.expectedMargin = expectedMargin;
}

public int getRangeMargin() {
	return rangeMargin;
}

public void setRangeMargin(int rangeMargin) {
	this.rangeMargin = rangeMargin;
}
}
