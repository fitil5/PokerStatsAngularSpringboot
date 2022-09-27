package com.grokonez.jwtauthentication.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;



@Entity
@Table(name = "movimientos_wina")
@IdClass(IdMovimientoWina.class)
public class MovimientoWina implements Serializable{
	@Id	
	private String id_mano;	
	
	@Id	
	private long linea;	
	
	private String nombre_jugador;
	
	private Double stack;
	
	private int posicion;
	
	private Double cant;
	
	private int ronda;
	
	private Double pot;
	
	private String tipo;
	
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
	
	
	
	public MovimientoWina(String id_mano, long linea, String nombre_jugador, double stack, int posicion, double cant,
			int ronda, double pot, String tipo) {
		super();
		this.id_mano = id_mano;
		this.linea = linea;
		this.nombre_jugador = nombre_jugador;
		this.stack = stack;
		this.posicion = posicion;
		this.cant = cant;
		this.ronda = ronda;
		this.pot = pot;
		this.tipo = tipo;
	}

	public MovimientoWina() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getLinea() {
		return linea;
	}

	public void setLinea(long linea) {
		this.linea = linea;
	}

	public Double getStack() {
		return stack;
	}

	public void setStack(Double stack) {
		this.stack = stack;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public Double getCant() {
		return cant;
	}

	public void setCant(Double cant) {
		this.cant = cant;
	}

	public int getRonda() {
		return ronda;
	}

	public void setRonda(int ronda) {
		this.ronda = ronda;
	}

	public Double getPot() {
		return pot;
	}

	public void setPot(Double pot) {
		this.pot = pot;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	

}
