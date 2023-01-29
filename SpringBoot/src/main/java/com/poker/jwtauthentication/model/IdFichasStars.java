package com.poker.jwtauthentication.model;

import java.io.Serializable;

public class IdFichasStars implements Serializable{
private String id_mano;
private String nombre_jugador;
public IdFichasStars() {
	super();
	// TODO Auto-generated constructor stub
}
public IdFichasStars(String id_mano, String nombre_jugador) {
	super();
	this.id_mano = id_mano;
	this.nombre_jugador = nombre_jugador;
}
public String getId_mano() {
	return id_mano;
}
public void setId_mano(String id_mano) {
	this.id_mano = id_mano;
}
public String getNombre_jugador() {
	return nombre_jugador;
}
public void setNombre_jugador(String nombre_jugador) {
	this.nombre_jugador = nombre_jugador;
}

}
