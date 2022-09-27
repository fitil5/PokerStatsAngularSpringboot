package com.grokonez.jwtauthentication.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "asientos_stars")
public class AsientoStars {
	@Id
private String id_mano;
private String p1_nombre;
private String p2_nombre;
private String p3_nombre;
private String p4_nombre;
private String p5_nombre;
private String p6_nombre;
private String p7_nombre;
private String p8_nombre;
private String p9_nombre;

private String nombre_mesa;

public AsientoStars() {
	super();
	// TODO Auto-generated constructor stub
}

public AsientoStars(String id_mano, String p1_nombre, String p2_nombre, String p3_nombre, String p4_nombre,
		String p5_nombre, String p6_nombre, String p7_nombre, String p8_nombre, String p9_nombre,
		String nombre_mesa) {
	super();
	this.id_mano = id_mano;
	this.p1_nombre = p1_nombre;
	this.p2_nombre = p2_nombre;
	this.p3_nombre = p3_nombre;
	this.p4_nombre = p4_nombre;
	this.p5_nombre = p5_nombre;
	this.p6_nombre = p6_nombre;
	this.p7_nombre = p7_nombre;
	this.p8_nombre = p8_nombre;
	this.p9_nombre = p9_nombre;
	this.nombre_mesa = nombre_mesa;
}





public String getId_mano() {
	return id_mano;
}
public void setId_mano(String id_mano) {
	this.id_mano = id_mano;
}
public String getP1_nombre() {
	return p1_nombre;
}
public void setP1_nombre(String p1_nombre) {
	this.p1_nombre = p1_nombre;
}
public String getP2_nombre() {
	return p2_nombre;
}
public void setP2_nombre(String p2_nombre) {
	this.p2_nombre = p2_nombre;
}
public String getP3_nombre() {
	return p3_nombre;
}
public void setP3_nombre(String p3_nombre) {
	this.p3_nombre = p3_nombre;
}
public String getP4_nombre() {
	return p4_nombre;
}
public void setP4_nombre(String p4_nombre) {
	this.p4_nombre = p4_nombre;
}
public String getP5_nombre() {
	return p5_nombre;
}
public void setP5_nombre(String p5_nombre) {
	this.p5_nombre = p5_nombre;
}
public String getP6_nombre() {
	return p6_nombre;
}
public void setP6_nombre(String p6_nombre) {
	this.p6_nombre = p6_nombre;
}

public String getNombre_mesa() {
	return nombre_mesa;
}

public void setNombre_mesa(String nombre_mesa) {
	this.nombre_mesa = nombre_mesa;
}



public String getP7_nombre() {
	return p7_nombre;
}



public void setP7_nombre(String p7_nombre) {
	this.p7_nombre = p7_nombre;
}



public String getP8_nombre() {
	return p8_nombre;
}




public void setP8_nombre(String p8_nombre) {
	this.p8_nombre = p8_nombre;
}


public String getP9_nombre() {
	return p9_nombre;
}



public void setP9_nombre(String p9_nombre) {
	this.p9_nombre = p9_nombre;
}









}
