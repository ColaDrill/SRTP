package com.action.charts;

import com.opensymphony.xwork2.ActionSupport;

public class ChartsAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String select(){
		System.out.println("select");
		return "success" ;
	}
	public String index(){
		System.out.println("index");
		return "success" ;
	}
}
