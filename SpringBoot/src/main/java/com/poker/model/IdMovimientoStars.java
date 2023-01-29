package com.poker.model;

import java.io.Serializable;

import javax.persistence.Id;

public class IdMovimientoStars implements Serializable{

	
	private String id_mano;
	private long linea;

	

	



	public IdMovimientoStars() {
		super();
		// TODO Auto-generated constructor stub
	}



	public IdMovimientoStars(String id_mano, long linea) {
		super();
		this.id_mano = id_mano;
		this.linea = linea;
	}



	public String getId_mano() {
		return id_mano;
	}



	public void setId_mano(String id_mano) {
		this.id_mano = id_mano;
	}



	

	

	public long getLinea() {
		return linea;
	}

	public void setLinea(long linea) {
		this.linea = linea;
	}
	
}
