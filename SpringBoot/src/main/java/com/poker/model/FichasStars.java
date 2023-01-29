package com.poker.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "fichas_stars")
@IdClass(IdFichasStars.class)
public class FichasStars implements Serializable{
@Id
private String id_mano;
private Double stack_inicial;
private Double stack_final;
@Id
private String nombre_jugador;
private Double stake;
private long posicion;
private Double ganancias;
private Double ganancias_bigblinds;
public String getId_mano() {
	return id_mano;
}
public void setId_mano(String id_mano) {
	this.id_mano = id_mano;
}
public Double getStack_inicial() {
	return stack_inicial;
}
public void setStack_inicial(Double stack_inicial) {
	this.stack_inicial = stack_inicial;
}
public Double getStack_final() {
	return stack_final;
}
public void setStack_final(Double stack_final) {
	this.stack_final = stack_final;
}
public String getNombre_jugador() {
	return nombre_jugador;
}
public void setNombre_jugador(String nombre_jugador) {
	this.nombre_jugador = nombre_jugador;
}

public long getPosicion() {
	return posicion;
}
public void setPosicion(long posicion) {
	this.posicion = posicion;
}

public FichasStars() {
	super();
	// TODO Auto-generated constructor stub
}
public Double getGanancias() {
	return ganancias;
}
public void setGanancias(Double ganancias) {
	this.ganancias = ganancias;
}


public FichasStars(String id_mano, Double stack_inicial, Double stack_final, String nombre_jugador, Double stake,
		long posicion, Double ganancias, Double ganancias_bigblinds) {
	super();
	this.id_mano = id_mano;
	this.stack_inicial = stack_inicial;
	this.stack_final = stack_final;
	this.nombre_jugador = nombre_jugador;
	this.setStake(stake);
	this.posicion = posicion;
	this.ganancias = ganancias;
	this.ganancias_bigblinds = ganancias_bigblinds;
}
public Double getGanancias_bigblinds() {
	return ganancias_bigblinds;
}
public void setGanancias_bigblinds(Double ganancias_bigblinds) {
	this.ganancias_bigblinds = ganancias_bigblinds;
}
public Double getStake() {
	return stake;
}
public void setStake(Double stake) {
	this.stake = stake;
}


}
