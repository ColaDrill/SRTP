package summary.algo;

import java.util.ArrayList;
import java.util.List;

public class EventList{
	public int time;
	public List<Integer> events;
	
	public static int[][] S;
	
	public EventList(){
		this.events = new ArrayList<Integer>();
	}
	public EventList(int time, Integer... args){
		this();
		this.time = time;
		for(int arg : args){
			this.events.add(arg);
		}
	}
	public void append(Integer... args){
		for(int arg : args){
			this.events.add(arg);
		}
	}
	public void print(){
		System.out.printf("time: %d. ", this.time);
		for(int s : this.events){
			System.out.printf(" %d,", s);
		}
		System.out.println();
	}
}