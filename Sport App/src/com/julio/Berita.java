package com.julio;

import java.io.Serializable;

public class Berita implements Serializable {
	private String berita=null;

	public Berita(String berita) {
		this.berita=berita;
	}
	
	public String getBerita() {
		return berita;
	}

	public void setBerita(String berita) {
		this.berita = berita;
	}
	
}
