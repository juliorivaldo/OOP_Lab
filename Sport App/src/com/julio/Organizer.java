package com.julio;


public class Organizer extends User{
	private boolean getBlock = false;
	private boolean getRegist = false;
	
    public Organizer(String user, String pass) {
        super(user, pass);
    }
    @Override
    public String getUser() {
        return super.getUser();
    }
    @Override
    public String getPass() {
        return super.getPass();
    }
    
    public boolean isBlock() {
        return getBlock;
    }

    public boolean isRegis() {
        return getRegist;
    }

    public void setBlock(boolean block) {
        getBlock = block;
    }

    public void setRegis(boolean regist) {
        getRegist = regist;
    }
}