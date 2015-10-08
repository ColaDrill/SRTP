package com.analysiser.model;

public class DevPeriodic{
	public long timeStamp;
	public String devType;
	public String info;
	public DevPeriodic(){
		info = "";
	}
	public void print(){
		System.out.printf("timeStemp:%d, devType:%s, info:%s\n", timeStamp, devType, info);
	}
}