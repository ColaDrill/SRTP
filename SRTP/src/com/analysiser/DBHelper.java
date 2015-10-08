package com.analysiser;

import java.sql.*;

import com.analysiser.model.*;

public class DBHelper {
	
	private Analysiser ana;
	private String databaseName ;
	
    public DBHelper(Analysiser Analysiser , String DatabaseName){
    	this.ana  = Analysiser;
    	this.databaseName = DatabaseName ;
    }
    public boolean write(){
    	Connection conn = null;
    	Statement stmt = null;
    	boolean res = false;
    	try {
    		Class.forName("com.mysql.jdbc.Driver").newInstance();
    		conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/" + databaseName, "root", "2271");
    		System.out.println("connect success!!");
    		stmt = conn.createStatement();
    		
    		stmt.execute("create table IF NOT EXISTS `event_info` (`timestamp` int(11), `devType` varchar(2000), `bala` varchar(2000), `eventType` varchar(50), `extraInfo` varchar(2000))");;
    		stmt.execute("create table IF NOT EXISTS `event_type_info` (`eventType` varchar(50), `explain` varchar(2000), primary key (`eventType`))");;
    		stmt.execute("create table If NOT EXISTS `dev_periodic_info` (`timestamp` int(11), `devType` varchar(50), `info` text, primary key(`timestamp`, `devType`))");;
    		System.out.println("create table success!");
    		
    		final String s1 = "insert into `event_info` (`timestamp`, `devType`, `bala` , `eventType`, `extraInfo`) values (?, ?, ?, ?, ?)";
    		PreparedStatement pstmt1 = conn.prepareStatement(s1); 
    		final String s2 = "insert into `event_type_info` (`eventType` , `explain`) values (?, ?)";
    		PreparedStatement pstmt2 = conn.prepareStatement(s2); 
    		final String s3 = "insert into `dev_periodic_info` (`timestamp`, `devType`, `info` ) values (?, ?, ?)";
    		PreparedStatement pstmt3 = conn.prepareStatement(s3); 
    		for(Event e : ana.events){
    			pstmt1.setInt(1, (int) e.timeStamp);
    			pstmt1.setString(2, e.devType);
    			pstmt1.setString(3,  e.bala);
    			pstmt1.setString(4, e.eventType);
    			pstmt1.setString(5, e.extraInfo);
    			pstmt1.addBatch();
    		}
    		pstmt1.executeBatch();
    		for(EventType et : ana.eventTypes){
    			pstmt2.setString(1, et.eventType);
    			pstmt2.setString(2, et.explain);
    			pstmt2.addBatch();
    		}
    		pstmt2.executeBatch();
    		for(DevPeriodic dp : ana.DevPs){
    			pstmt3.setInt(1, (int) dp.timeStamp);
    			pstmt3.setString(2, dp.devType);
    			pstmt3.setString(3, dp.info);
    			pstmt3.addBatch();
    		}
    		pstmt3.executeBatch();
    		res = true;
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		try {
    			stmt.close();
    			conn.close();
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    	}
		return res;
    	
    }
}
