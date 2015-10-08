package com.analysiser.model;

public class Event{
	public long timeStamp;
	public String devType;
	public String bala;
	public String eventType;
	public String extraInfo;
	public Event(){
		bala = "";
		extraInfo = "()";
	}
	public void print(){
		System.out.printf("time:%d, devType:%s, bala:%s, eventType:%s, extraInfo:%s\n", this.timeStamp, this.devType, this.bala, this.eventType, this.extraInfo);
	}
}