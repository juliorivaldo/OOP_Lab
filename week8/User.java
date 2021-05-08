package week8;

import java.util.*;

public class User {
	private String user_id;
	private String pass;
	private boolean login_status;
	
	User(){
		login_status = false;
	}
	
	
	public void set_userId(String user_id) {
		this.user_id=user_id;
	}
	
	public void set_pass(String pass) {
		this.pass = pass;
	}
	
	//getter function
	public String get_userId() {
		return user_id;
	}
	
	public String get_pass() {
		return pass;
	}
	
	public boolean verify_login() {
		if(user_id.equals("admin")) {
			
			if(pass.equals("admin")) {
			login_status = true;
			}
		}
		return login_status;	
	}
	
}
