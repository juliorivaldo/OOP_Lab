package com.julio;

import java.io.Serializable;

public abstract class User implements Serializable {
    private String user;
    private String pass;
    
    //constructor
    public User(String user, String pass) {
		super();
		this.user = user;
		this.pass = pass;
	}
    
	//setter and getter method
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}


    
}
