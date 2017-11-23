package uk.co.F1x2Games;



import java.sql.*;
import javax.sql.*;

import java.lang.*;
import java.util.*;
import java.text.*;
import java.io.*;

public class Utils {
	java.util.Date d;
	java.sql.Date today;
	String amount="";
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

	int traceLevel = 0;
	String logDIR="";
	Hashtable hash = new Hashtable();
	String [] GAMENAMES=new String[200];
	Connection con;
	PreparedStatement prep;
	ResultSet rs;
	int numGames=0;
	String selectDrop="<option value=0>Select by game</option><option value=0>All Games</option>";
	String currencyDrop="<option value=0>Select by Currency</option><option value=0>All Currencies</option>";
	//DatabaseUtils db= DatabaseUtils.getInstance();
	int numLockedAccounts=0;
	String [] lockedAccounts;
	String [] GAMETYPES=new String[200];
	Hashtable errorStatusHash = new Hashtable();
	String [] errorKeyPairs;
	String [] thePair;
	String fpf="";
	String logname="utils";
	Hashtable QFGameNames=new Hashtable();
	Hashtable QFGameNames2=new Hashtable();
	Hashtable QFGameIDs=new Hashtable();

	public String getQFGameName(String qfgameID){
	
	return (String)QFGameNames.get(qfgameID);
	
	
	}

		public String getQFGameName2(String qfgameID){
	
	return (String)QFGameNames2.get(qfgameID);
	
	
	}

		public String getQFGameID(String qfgameID){
	
	return (String)QFGameIDs.get(qfgameID);
	
	
	}

	private static Utils utils = null;

	
	private Utils(){
		

	}

	
	public static synchronized Utils getInstance()  {
		if (utils == null) {
			utils = new Utils();
		}
				
		return utils;
    }	


	public String arrayToString(int [] Arr){
		String arr_string="";
		for(int i=0;i<Arr.length;i++){
			arr_string+=""+Arr[i]+",";
		}
		arr_string=arr_string.substring(0,(arr_string.length()-1));
		return arr_string;
	}


	public int[] stringToArray(String str, int arrayUnits){
		int [] arr = new int[arrayUnits];
		int count=0;
		int index=0;
		while(str.length()>0){
			index=str.indexOf(',');
			if(index!=-1){
				arr[count]=Integer.parseInt(str.substring(0,index));
				str=str.substring((index+1),str.length());
			}
			else{
				arr[count]=Integer.parseInt(str.substring(0,str.length()));
				str="";
			}
			count++;
		}

		return arr;
	}


	

/*	public String dealWithApos(String str){
		int i = str.indexOf("'");
		String dst = str;
		while(i>=0) {
			dst = replaceApos(dst, i);
			i = dst.indexOf("'");
		}
		return dst.toString();
	}

	
	public static String replaceApos(String Str, int j) {
		String newString = Str.substring(0,j)+"&#39;";
		String secondNewString = Str.substring(j+1,Str.length());
		String returnString = newString+secondNewString;
		return returnString;
	}


	public String dealWithPound(String str){
		int i = str.indexOf("�");
		String dst = str;
		while(i>=0) {
			dst = replacePound(dst, i);
			i = dst.indexOf("�");
		}
		return dst.toString();
	}

	
	public static String replacePound(String Str, int j) {
		String newString = Str.substring(0,j)+"&pound;";
		String secondNewString = Str.substring(j+1,Str.length());
		String returnString = newString+secondNewString;
		return returnString;
	}

	
	public String  dealWithApos2(String name){
		name=name.replace('\047' , ' ');
		return name;
	}

*/
	public void Logger(String logFile, String message)throws IOException{
		
	}


	public void Logger(String logFile, Exception e)throws IOException{
		

	}




	public static String formatIt(String str){
		String dst = "";
		if(str!=null) {
			int i = str.indexOf("'");
			int j = str.indexOf("--");
			int k = str.indexOf("select ");
			int l = str.indexOf("drop");
			if((i+j+k+l)>=0) {
			}
			else {
				dst = str;
			}
		}
		return dst.toString();
	}


	public int getTraceLevel() {
		return traceLevel;
	}

  public String getGameParameter(String p){



	  String r=(String)hash.get(p);
       if(r==null)r="0";

    return r;
 }

public  String getGameName(int id){
return GAMENAMES[id];
}

public int getNumGames(){
return numGames;
}

public  String getSelectDrop(){
return selectDrop;
}

public  String getCurrencyDrop(){
return currencyDrop;
}
public  String getGameType(int id){
return GAMETYPES[id];
}
public  String getLogName(int id){
return  getGameParameter(GAMETYPES[id]+"LOGNAME");
}

public boolean accountLocked(String accID){
  boolean isLocked=false;
	for(int y=0;y<numLockedAccounts;y++){
		if(lockedAccounts[y].equals(accID))isLocked=true;

	}
return isLocked;
}

public void updateGameParameters(){


}

public void updateLockedAccount(){
	
}

public String getErrorStatus(int errorCode){
  String es=(String)errorStatusHash.get(""+errorCode);
  if(es==null)es="UNSPECIFIED";

  return es;
}

public synchronized double FPF(double num){
fpf=""+num;
if(fpf.indexOf(".49999")!=-1){
num=num+0.01;
}

return num;
}

}