package com.action.databaseworker;

import java.io.FileNotFoundException;
import org.junit.Test;
import com.opensymphony.xwork2.ActionSupport;
import com.analysiser.Analysiser;
import com.analysiser.DBHelper;
import com.analysiser.model.DevPeriodic;
import com.analysiser.model.Event;
import com.analysiser.model.EventType;

public class DBwork  extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private static String LogURL = "LogSourceFile/a.log" ;
	private static String DatabaseName = "SRTP" ; 
	
	@Test
	public void SetLogToDatabase(){
		Analysiser a = new Analysiser();
		try {
			a.Analysis(LogURL);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		for(Event e : a.events){
			e.print();
		}
		for(EventType et : a.eventTypes){
			et.print();
		}
		for(DevPeriodic dp : a.DevPs){
			dp.print();
		}
		
		Analysiser Analysiser = new Analysiser();
		try {
			Analysiser.Analysis(LogURL);
			DBHelper dbH = new DBHelper(Analysiser , DatabaseName);
			dbH.write();
			System.out.println("123");
		} catch (FileNotFoundException e1) {
			System.out.println("File not found");
			e1.printStackTrace();
		}
	}
	
}
