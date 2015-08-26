package analysiser;

import java.util.Scanner;
import java.io.*;
import java.util.LinkedList;
import java.util.Hashtable;
import java.util.List;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;
import java.text.*;

import org.json.*;

import analysiser.model.*;


public class Analysiser{
	private static String logURL = "log/sample.log" ;
	
	public static void main(String[] args){
		Analysiser a = new Analysiser();
		try {
			a.Analysis(logURL);
		} catch (FileNotFoundException e1) {
			// TODO 自动生成的 catch 块
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
			Analysiser.Analysis(logURL);
			DBHelper dbH = new DBHelper(Analysiser);
			dbH.write();
		} catch (FileNotFoundException e1) {
			// TODO 自动生成的 catch 块
			System.out.println("File not found");
			e1.printStackTrace();
		}
	}
	
	public static long getTimeStamp(String str, int type){
		//根据那个字符串获取时间戳
		String pat = "";
		if(type==1){
			pat = "MMM dd yyyy HH:mm:ss";
		}else{
			pat = "yyyy-MM-dd HH:mm:ss.SSS";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pat, Locale.US);
		Date dt = new Date();
		try {
			dt = sdf.parse(str);
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return dt.getTime()/1000;
	}
	
	public static String getEventType(String str){
		int x = str.indexOf("[");
		if(x == -1)
			return str;
		return str.substring(0, x);
	}
	
	public void Analysis(String log_path) throws FileNotFoundException{
		Scanner fs = new Scanner(new File(log_path));
		final String r1 = "^([A-Z][a-z]{1,2}\\s+\\d{1,2}\\s+\\d{4}\\s+\\d\\d:\\d\\d:\\d\\d)\\s+([A-Za-z\\-0-9]+)\\s+(.+(?=\\/)\\/)(.+(?=:)):(.+(?=\\s\\())\\s(\\(.+\\))$";
		final String r2 = "^([A-Z][a-z]{1,3}\\s+\\d{1,2}\\s+\\d{4}\\s+\\d\\d:\\d\\d:\\d\\d)\\s+([A-Za-z\\-0-9]+)\\s+(.+(?=\\/)\\/)(.+(?=:)):(.+)$";
		boolean flag = false;
		boolean getDevInfo=false;
		DevPeriodic dp = new DevPeriodic();
		Event eTmp = new Event();
		String Dev_Type = "UNKNOW_DEV_TYPE";
		
		JSONArray jsonArr1 = new JSONArray();
		JSONArray jsonArr2 = new JSONArray();
		
		Hashtable<String, String> dict = new Hashtable<String, String>();
		
		
		this.events = new LinkedList<Event>();
		this.DevPs = new LinkedList<DevPeriodic>();
		this.eventTypes = new LinkedList<EventType>();
		while(fs.hasNext()){
			String line = fs.nextLine();
			if(line.length()==0)
				continue;
			//System.out.println(line);
			Pattern p1 =  Pattern.compile(r1);
			Matcher m1 = p1.matcher(line);
			Pattern p2 = Pattern.compile(r2);
			Matcher m2 = p2.matcher(line);
			if(m1.find()){
				//第一类， 含有括号信息
				Event e = new Event();
				e.timeStamp = Analysiser.getTimeStamp(m1.group(1), 1);
				e.devType = m1.group(2);
				Dev_Type = e.devType;
				e.bala = m1.group(3);
				e.eventType = Analysiser.getEventType(m1.group(4));
				dict.put(Analysiser.getEventType(m1.group(4)), m1.group(5));
				e.extraInfo = m1.group(6);
				this.events.add(e);
			}else if(m2.find()){
				//第二类， 不含有括号信息
				Event e = new Event();
				e.timeStamp = Analysiser.getTimeStamp(m2.group(1), 1);
				e.devType = m2.group(2);
				Dev_Type = e.devType;
				e.bala = m2.group(3);
				e.eventType = Analysiser.getEventType(m2.group(4));
				dict.put(Analysiser.getEventType(m2.group(4)), m2.group(5));
				e.extraInfo = "()";
				this.events.add(e);
			}else{
				if(line.matches("^#+$")){
					flag = !flag;
					if(flag){
						dp = new DevPeriodic();
						eTmp = new Event();
						jsonArr2 = new JSONArray();
						dp.devType = Dev_Type;
						eTmp.devType = Dev_Type;
						eTmp.eventType = "INFO_COLLECT";
					}else{
						if(getDevInfo==false){
							dict.put("INFO_COLLECT", jsonArr1.toString());
						}
						getDevInfo = true;
						
						dp.info = jsonArr2.toString();
						this.DevPs.add(dp);
						this.events.add(eTmp);
					}
				}
				if(flag){

					if(line.matches("^#DateTime.+$")){
						String date_str = line.substring(line.indexOf(": ")+2);
						dp.timeStamp = Analysiser.getTimeStamp(date_str, 0);
						eTmp.timeStamp = dp.timeStamp;
					}else if(line.matches("^\\d+.+$")){
						String[] arr = line.split("( )+");
						int len = arr.length;
						HashMap<String, String> hm1 = new HashMap<String, String>();
						hm1.put(arr[0], arr[1]);
						jsonArr1.put(hm1);
						
						HashMap<String, String> hm2 = new HashMap<String, String>();
						hm2.put("CPU Usage", arr[len-3]);
						hm2.put("MPU Usage (Used/Total)", arr[len-2]+" "+arr[len-1]);
						jsonArr2.put(hm2);
						
					}
					
				}
				
			}
		}
		//TODO : 把dict里的信息转成this.eventTypes
		
		for(Iterator iter = dict.keySet().iterator();iter.hasNext();){
			String key = (String)iter.next();
			//System.out.println(key+":"+dict.get(key));
			EventType et = new EventType(key, dict.get(key));
			this.eventTypes.add(et);
		}
		
		fs.close();
	}
	
	public List<Event> events;
	public List<EventType> eventTypes;
	public List<DevPeriodic> DevPs;
}
