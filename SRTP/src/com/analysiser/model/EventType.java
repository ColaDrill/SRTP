package com.analysiser.model;

public class EventType{
	public String eventType;
	public String explain;
	public EventType(){
		
	}
	public EventType(String et, String exp){
		this.eventType = et;
		this.explain = exp;
	}
	public void print(){
		System.out.printf("eventType:%s, explain:%s\n", eventType, explain);
	}
}