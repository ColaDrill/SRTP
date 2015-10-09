package test;

import java.io.FileOutputStream;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;


public static void test2(){
	
	    //连接数据库
	    databaseName = "simple_log_summary" ;
		userName = "root" ;
		passWord = "root" ;
	    Class.forName("com.mysql.jdbc.Driver").newInstance() ;
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/" + databaseName , userName , passWord );
		System.out.println("connect success!!"); 
		
		//查询event_info表
		stmt = con.createStatement() ;
		resultSet = stmt.executeQuery("select * from event_info ;");
			
		//对timestamp的不同event分别计数		
		HashMap<String , Integer> timeStamp = new HashMap<String , Integer> () ;	
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
			
		Object[] key = timeStamp.keySet().toArray() ;
		Arrays.sort(key);
		
		//convert into Json
		JSONStringer js = new JSONStringer();
							
		for(int i = 0 ; i < key.length ; i ++ ){
			
            JSONObject object[i] = new JSONObject() ;
			object[i].put(key[i] , timeStamp.get(key[i]) ;      //前者key[i]值为event发生次数，后者为event名
			
			js.object().key("session").value(object1).endObject();
			System.out.println(js.toString()) ;
			
			//PrintWriter out_txt = new PrintWriter( new FileOutputStream("test.txt") ) ;
			//out_txt.println( js.toString() ) ;
			
		public static void main(String[] args) {

		    test2(); 
	    }
}