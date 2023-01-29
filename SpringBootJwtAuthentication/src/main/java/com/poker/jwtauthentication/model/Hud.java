package com.poker.jwtauthentication.model;

public class Hud {
private Jugador p1;
private Jugador p2; 
private Jugador p3; 
private Jugador p4; 
private Jugador p5;
private Jugador p6;
private Jugador p7;
private Jugador p8;
private Jugador p9;
public Hud(Jugador p1, Jugador p2, Jugador p3, Jugador p4, Jugador p5, Jugador p6, Jugador p7, Jugador p8, Jugador p9,
		String nombre_mesa) {
	super();
	this.p1 = p1;
	this.p2 = p2;
	this.p3 = p3;
	this.p4 = p4;
	this.p5 = p5;
	this.p6 = p6;
	this.p7 = p7;
	this.p8 = p8;
	this.p9 = p9;
	this.nombre_mesa = nombre_mesa;
}
private String nombre_mesa;



public Hud() {
	super();
	// TODO Auto-generated constructor stub
}
public Jugador getP1() {
	return p1;
}
public void setP1(Jugador p1) {
	this.p1 = p1;
}
public Jugador getP2() {
	return p2;
}
public void setP2(Jugador p2) {
	this.p2 = p2;
}
public Jugador getP3() {
	return p3;
}
public void setP3(Jugador p3) {
	this.p3 = p3;
}
public Jugador getP4() {
	return p4;
}
public void setP4(Jugador p4) {
	this.p4 = p4;
}
public Jugador getP5() {
	return p5;
}
public void setP5(Jugador p5) {
	this.p5 = p5;
}
public Jugador getP6() {
	return p6;
}
public void setP6(Jugador p6) {
	this.p6 = p6;
}
public String getNombre_mesa() {
	return nombre_mesa;
}
public void setNombre_mesa(String nombre_mesa) {
	this.nombre_mesa = nombre_mesa;
}
public Jugador getP7() {
	return p7;
}
public void setP7(Jugador p7) {
	this.p7 = p7;
}
public Jugador getP8() {
	return p8;
}
public void setP8(Jugador p8) {
	this.p8 = p8;
}
public Jugador getP9() {
	return p9;
}
public void setP9(Jugador p9) {
	this.p9 = p9;
}

}
