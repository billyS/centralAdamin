package uk.co.F1x2Games.service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import uk.co.F1x2Games.DatabaseUtils;
import uk.co.F1x2Games.Game;
import uk.co.F1x2Games.Utils;

import java.io.IOException;

@Service
public class GameService {
	
    int configuration = 100;
    int limit = 1000;
    Properties properties;
	PropertyPlaceholderConfigurer props2;
	List<Game> gameList;
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(GameService.class);
    //String clientName = properties.getProperty("client_name");
   
	public GameService() {
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

	DatabaseUtils dbu =  DatabaseUtils.getInstance();
    Utils util =  Utils.getInstance();
    Connection con;
    ResultSet rs;
    PreparedStatement prep;
	private String description;
	
	public synchronized List<Game> getGames() {
		gameList = new ArrayList<Game>();
		Game game = null;

		try {
			con = dbu.getConnection("CENTRAL");
			prep = con.prepareStatement("Select * from GAME");
			rs = prep.executeQuery();

			while (rs.next()){
				game = new Game();
				game.setDesktop(rs.getBoolean("DESKTOP"));
				game.setEstimatedDevCost(rs.getInt("ESTIMATED_DEV_COST"));
				game.setEstimatedTestingCost(rs.getInt("ESTIMATED_TESTING_COST"));
				game.setFlash(rs.getBoolean("FLASH"));
				game.setGameGroup(rs.getString("GAME_GROUP"));
				game.setGameId(rs.getInt("GAME_ID"));
				game.setGameName(rs.getString("GAME_NAME"));
				game.setGameReleaseDate(rs.getString("GAME_RELEASE_DATE"));
				game.setGameStatus(rs.getString("GAME_STATUS"));
				game.setGameSubGroup(rs.getString("GAME_SUB_GROUP"));
				game.setGameType(rs.getString("GAME_TYPE"));
				game.setHtml5(rs.getBoolean("HTML5"));
				game.setMiniGame(rs.getBoolean("MINI_GAME"));
				game.setMobile(rs.getBoolean("MOBILE"));
				game.setRangeMargin(rs.getInt("RANGE_MARGIN"));
				game.setSupplierId(rs.getInt("SUPPLIER_ID"));
				game.setVersion(rs.getString("VERSION"));
				game.setExpectedMargin(rs.getInt("EXPECTED_MARGIN"));
				
				gameList.add(game);
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
		
		return gameList;
	}
	
	public Gson getGame(Game aGame){
		Gson gUser= new Gson();
		gUser.toJson(aGame);
		return gUser;
		
	}

	public Game getGame(String gameName) {
		Game game = null;
		
		try {
			con = dbu.getConnection("CENTRAL");
			prep = con.prepareStatement("Select * from GAME where GAME_NAME = ?");
			prep.setString(1,gameName);
			rs = prep.executeQuery();

			while(rs.next()){
				game = new Game();
				game.setDesktop(rs.getBoolean("DESKTOP"));
				game.setEstimatedDevCost(rs.getInt("ESTIMATED_DEV_COST"));
				game.setEstimatedTestingCost(rs.getInt("ESTIMATED_TESTING_COST"));
				game.setFlash(rs.getBoolean("FLASH"));
				game.setGameGroup(rs.getString("GAME_GROUP"));
				game.setGameId(rs.getInt("GAME_ID"));
				game.setGameName(rs.getString("GAME_NAME"));
				game.setGameReleaseDate(rs.getString("GAME_RELEASE_DATE"));
				game.setGameStatus(rs.getString("GAME_STATUS"));
				game.setGameSubGroup(rs.getString("GAME_SUB_GROUP"));
				game.setGameType(rs.getString("GAME_TYPE"));
				game.setHtml5(rs.getBoolean("HTML5"));
				game.setMiniGame(rs.getBoolean("MINI_GAME"));
				game.setMobile(rs.getBoolean("MOBILE"));
				game.setRangeMargin(rs.getInt("RANGE_MARGIN"));
				game.setSupplierId(rs.getInt("SUPPLIER_ID"));
				game.setVersion(rs.getString("VERSION"));
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
		return game;
	}
	
	public Game getGame(int gameId) {
		Game game = null;
		try {
			con = dbu.getConnection("CENTRAL");
			prep = con.prepareStatement("Select * from GAME where GAME_ID = ?");
			prep.setInt(1,gameId);
			rs = prep.executeQuery();

			while(rs.next()){
				game = new Game();
				game.setDesktop(rs.getBoolean("DESKTOP"));
				game.setEstimatedDevCost(rs.getInt("ESTIMATED_DEV_COST"));
				game.setEstimatedTestingCost(rs.getInt("ESTIMATED_TESTING_COST"));
				game.setFlash(rs.getBoolean("FLASH"));
				game.setGameGroup(rs.getString("GAME_GROUP"));
				game.setGameId(rs.getInt("GAME_ID"));
				game.setGameName(rs.getString("GAME_NAME"));
				game.setGameReleaseDate(rs.getString("GAME_RELEASE_DATE"));
				game.setGameStatus(rs.getString("GAME_STATUS"));
				game.setGameSubGroup(rs.getString("GAME_SUB_GROUP"));
				game.setGameType(rs.getString("GAME_TYPE"));
				game.setHtml5(rs.getBoolean("HTML5"));
				game.setMiniGame(rs.getBoolean("MINI_GAME"));
				game.setMobile(rs.getBoolean("MOBILE"));
				game.setRangeMargin(rs.getInt("RANGE_MARGIN"));
				game.setSupplierId(rs.getInt("SUPPLIER_ID"));
				game.setVersion(rs.getString("VERSION"));
				
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
		return game;
	}
	
      
    public Game createGame(Game aGame) {
    	
    	try {
			con = dbu.getConnection("CENTRAL");
			prep = con.prepareStatement("INSERT INTO GAME (GAME_NAME, GAME_TYPE, VERSION, SUPPLIER_ID, GAME_GROUP, GAME_SUB_GROUP, GAME_STATUS, ESTIMATED_DEV_COST, "
					+ "ESTIMATED_TESTING_COST, EXPECTED_MARGIN, RANGE_MARGIN, GAME_RELEASE_DATE, HTML5, FLASH, DESKTOP, MOBILE, MINI_GAME) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			prep.setString(1, aGame.getGameName());
			prep.setString(2,aGame.getGameType());
			prep.setString(3,aGame.getVersion());
			prep.setInt(4,aGame.getSupplierId());
			prep.setString(5,aGame.getGameGroup());
			prep.setString(6,aGame.getGameSubGroup());
			prep.setString(7,aGame.getGameStatus());
			prep.setInt(8,aGame.getEstimatedDevCost());
			prep.setInt(9,aGame.getEstimatedTestingCost());
			prep.setInt(10,aGame.getExpectedMargin());
			prep.setInt(11,aGame.getRangeMargin());
			prep.setString(12,aGame.getGameReleaseDate());
			prep.setBoolean(13,aGame.isHtml5());
			prep.setBoolean(14,aGame.isFlash());
			prep.setBoolean(15,aGame.isDesktop());
			prep.setBoolean(16,aGame.isMobile());
			prep.setBoolean(17,aGame.isMiniGame());
	
			if(prep.executeUpdate() < 1){
				//TODO log something here
			}else{
				
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
		return aGame;
	}
    
    public Game saveGame(Game aGame) {
		
    	try {
			con = dbu.getConnection("CENTRAL");
			prep = con.prepareStatement("UPDATE GAME SET GAME_NAME=?, GAME_TYPE=?, VERSION=?, SUPPLIER_ID=?, GAME_GROUP=?, GAME_SUB_GROUP=?, GAME_STATUS=?, ESTIMATED_DEV_COST=?, "
					+ "ESTIMATED_TESTING_COST=?, EXPECTED_MARGIN=?, RANGE_MARGIN=?, GAME_RELEASE_DATE=?, HTML5=?, FLASH=?, DESKTOP=?, MOBILE=?, MINI_GAME=? "
					+ "WHERE GAME_ID=?");
			
			prep.setString(1, aGame.getGameName());
			prep.setString(2,aGame.getGameType());
			prep.setString(3,aGame.getVersion());
			prep.setInt(4,aGame.getSupplierId());
			prep.setString(5,aGame.getGameGroup());
			prep.setString(6,aGame.getGameSubGroup());
			prep.setString(7,aGame.getGameStatus());
			prep.setInt(8,aGame.getEstimatedDevCost());
			prep.setInt(9,aGame.getEstimatedTestingCost());
			prep.setInt(10,aGame.getExpectedMargin());
			prep.setInt(11,aGame.getRangeMargin());
			prep.setString(12,aGame.getGameReleaseDate());
			prep.setBoolean(13,aGame.isHtml5());
			prep.setBoolean(14,aGame.isFlash());
			prep.setBoolean(15,aGame.isDesktop());
			prep.setBoolean(16,aGame.isMobile());
			prep.setBoolean(17,aGame.isMiniGame());
			prep.setInt(18,aGame.getGameId());

			if(prep.executeUpdate() < 1){
				//TODO log something here
			}else{
				
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
		return aGame;
	}
    
    public synchronized void deleteGame(Game aGame) {
		//System.out.println(agame.getgameId());
    	try {
			con = dbu.getConnection("CENTRAL");
			prep = con.prepareStatement("DELETE FROM GAME WHERE GAME_ID = ?");
			prep.setInt(1,aGame.getGameId());
	
			if(prep.executeUpdate() < 1){
				//TODO log something here
			}else{
				
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
	}
}
