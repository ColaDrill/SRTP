package analysiser;

import java.util.Scanner;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import analysiser.model.Event;

public class Test{
	public static void main(String[] args) throws FileNotFoundException{
		/*List<Event> listEvent = new LinkedList<Event>();
		Event e = new Event();
		e.timeStamp = 12222;
		e.print();
		Scanner fs = new Scanner(new File("sample.log"));
		final String r1 = "^([A-Z][a-z]{1,2}\\s+\\d{1,2}\\s+\\d{4}\\s+\\d\\d:\\d\\d:\\d\\d)\\s+([A-Za-z\\-0-9]+)\\s+(.+(?=\\/)\\/)(.+(?=:)):(.+(?=\\s\\())\\s(\\(.+\\))$";
		final String r2 = "^([A-Z][a-z]{1,3}\\s+\\d{1,2}\\s+\\d{4}\\s+\\d\\d:\\d\\d:\\d\\d)\\s+([A-Za-z\\-0-9]+)\\s+(.+(?=\\/)\\/)(.+(?=:)):(.+)$";
		boolean flag = false;
		while(fs.hasNext()){
			String line = fs.nextLine();
			if(line.length()==0)
				continue;
			System.out.println(line);
			Pattern p1 =  Pattern.compile(r1);
			Matcher m1 = p1.matcher(line);
			Pattern p2 = Pattern.compile(r2);
			Matcher m2 = p2.matcher(line);
			if(m1.find()){
				 for(int i=1; i<=m1.groupCount();i++){
				 	System.out.println(m1.group(i)); 
				 }
				 System.out.println("#########################");
			}else if(m2.find()){
				for(int i=1; i<=m2.groupCount();i++){
				 	System.out.println(m2.group(i)); 
				 }
				System.out.println("#########################");
			}else{
				if(line.matches("^#+$")){
					flag = !flag;
				}
					
			}
		}
		fs.close();*/
		
	}

	public static int getTimeStamp(String str){
		//String[] 
		
		return 1;
	}
}