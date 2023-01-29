package com.poker.jwtauthentication.model;

import java.io.Serializable;

public class FechaIdWina implements Serializable{
	private String id_mano;
	private String username;
	
	
	public FechaIdWina() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FechaIdWina(String id_mano, String username) {
		super();
		this.id_mano = id_mano;
		this.username = username;
	}
	public String getId_mano() {
		return id_mano;
	}
	public void setId_mano(String id_mano) {
		this.id_mano = id_mano;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
