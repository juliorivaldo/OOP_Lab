package com.julio;

import java.io.Serializable;
import java.util.ArrayList;

public class Event implements Serializable{
	//Constructor attributes
	private String kategori;
	private String nama;
	private String organizer;
	private String level;
	private String tempat;
	private int tanggal;
    private int bulan;
    private int tahun;
    private int min_player;
    private int max_player;
    private int biaya;
    
    //counting players in event
    private int player = 0;
    private static ArrayList<String> list_pemain = new ArrayList<>();
    
    //attribute for condition
    private boolean getAvail = true;
    //Constructor
	public Event(String kategori, String nama, String organizer, String level, String tempat, int tanggal, int bulan,
			int tahun, int min_player, int max_player, int biaya) {
		this.kategori = kategori;
		this.nama = nama;
		this.organizer = organizer;
		this.level = level;
		this.tempat = tempat;
		this.tanggal = tanggal;
		this.bulan = bulan;
		this.tahun = tahun;
		this.min_player = min_player;
		this.max_player = max_player;
		this.biaya = biaya;
	}
	public Event(String nama, String organizer) {
		this.nama = nama;
		this.organizer = organizer;
	}
	//setter and getter method
	public String getKategori() {
		return kategori;
	}
	public void setKategori(String kategori) {
		this.kategori = kategori;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getOrganizer() {
		return organizer;
	}
	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getTempat() {
		return tempat;
	}
	public void setTempat(String tempat) {
		this.tempat = tempat;
	}
	public int getTanggal() {
		return tanggal;
	}
	public void setTanggal(int tanggal) {
		this.tanggal = tanggal;
	}
	public int getBulan() {
		return bulan;
	}
	public void setBulan(int bulan) {
		this.bulan = bulan;
	}
	public int getTahun() {
		return tahun;
	}
	public void setTahun(int tahun) {
		this.tahun = tahun;
	}
	public int getMin_player() {
		return min_player;
	}
	public void setMin_player(int min_player) {
		this.min_player = min_player;
	}
	public int getMax_player() {
		return max_player;
	}
	public void setMax_player(int max_player) {
		this.max_player = max_player;
	}
	public int getBiaya() {
		return biaya;
	}
	public void setBiaya(int biaya) {
		this.biaya = biaya;
	}
	public int getPlayer() {
		return player;
	}
	public void setAvail(boolean getAvail) {
        this.getAvail = getAvail;
    }
    public boolean isAvail() {
        return getAvail;
    }
	public ArrayList<String> getList_pemain() {
		return list_pemain;
	}
	public void setList_pemain(String nama) {
		list_pemain.add(nama);
	}
	//Method 
    public void add_player() {
    	player+=1;
    }
    public void subtract_player() {
    	player-=1;
    }
    public static void del_player(String nama) {
    	int temp=0;
    	for(int i=0 ; i < list_pemain.size() ; i++) {
    		if(list_pemain.get(i) == nama) temp = i;
    	}
    	list_pemain.remove(temp);
    }
}
