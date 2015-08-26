package test.readEventType;

import java.awt.RenderingHints.Key;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class readEventInfo {

	private static String databaseName = null ;
	private static String userName = null ;
	private static String passWord = null ;
	
	private static Connection con = null ;
	private static Statement stmt = null ;
	private static ResultSet resultSet = null ;
		
	private static Object[] key = null ;
	private static HashMap<String , Integer> timeStamp = null ;
	
	public static void eventInfoToList(final String databaseName , final String userName , final String passworld){
		try{
			timeStamp = new HashMap<String , Integer> () ;
			Class.forName("com.mysql.jdbc.Driver").newInstance() ;
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/" + databaseName , userName , passWord ); 
			stmt = con.createStatement() ; // 用Connection对象创建Statement
			resultSet = stmt.executeQuery("select * from event_info ;");			
			
			timeStamp.clear();
			while( resultSet.next() == true ){
				String key = resultSet.getString("timestamp") ;
				if( timeStamp.get(key) != null ){
					int cnt = timeStamp.get(key) ;
					cnt ++ ;
					timeStamp.put(key , cnt) ;
				}else{
					timeStamp.put(key , 1) ;
				}
			}
			
			key = timeStamp.keySet().toArray() ;
			Arrays.sort(key);
					
			for(int i = 0 ; i < key.length ; i ++ ){
				System.out.print(key[i] + " : " ) ;
				System.out.println( timeStamp.get(key[i]) ) ;
			}

		}catch( Exception e ){
			System.out.println("ERROR : " + e.getMessage() ) ;
		}
	}
	
	public static void fromatPrintf(){
		System.out.print("[") ;
		for(int i = 0 ; i < key.length ; i ++){
			System.out.print("'" + key[i] + "'");
			if(i < key.length - 1){
				System.out.print(",");
			}else{
				System.out.println("]");
			}
		}
		for(int i = 0 ; i < key.length ; i ++){
			if(i == 0) System.out.print("[");
			System.out.print(timeStamp.get(key[i]));
			if(i < key.length - 1){
				System.out.print(",");
			}else{
				System.out.print("]");
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//	mapTest() ;
		
		databaseName = "simple_log_summary" ;
		userName = "root" ;
		passWord = "2271" ;
		eventInfoToList(databaseName , userName , passWord );
		fromatPrintf();
	}

}
