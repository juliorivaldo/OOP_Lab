package com.julio;

import java.util.ArrayList;

public class Player extends User {
	private boolean getBlock = false;
	private boolean getRegist = false;
	
	private static ArrayList<String> titles = new ArrayList<>();
	
    public Player(String user, String pass) {
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
    public ArrayList<String> getTitles() {
        return titles;
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
    public void setTitles(String title){
        titles.add(title);
    }
}
