package com.action.login;
import com.model.user.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<User>{
	private static final long serialVersionUID = 1L;
	private User user = new User();
	public String login(){
		if( user.getUserNameString().equals("root") == true ){
			if( user.getPassWordString().equals("1234") == true ){
				System.out.println("SUCCESS") ;
				return SUCCESS ;
			}else{
				System.out.println("passWordError") ;
				return "passWordError" ;
			}
		}
		System.out.println("userNameError") ;		
		return "userNameError" ;
	}
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
}
