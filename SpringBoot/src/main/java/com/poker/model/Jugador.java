package com.poker.model;

public class Jugador {

	private String nombre;
	private double cbet;
	private double vpip;
	private double pfr;
	private double mediaCantFlop;
	private double mediaCantTurn;
	private double mediaCantRiver;
	private double bet3;
	private double manos;
	private double cbetCall;
	private double cbetCallTurn;
	private double foldCbet;
	
	
	
	
	
	
	
	
	
	
	
	public Jugador(String nombre, double cbet, double vpip, double pfr, double mediaCantFlop, double mediaCantTurn,
			double mediaCantRiver, double bet3, double manos, double cbetCall, double cbetCallTurn, double foldCbet) {
		super();
		this.nombre = nombre;
		this.cbet = cbet;
		this.vpip = vpip;
		this.pfr = pfr;
		this.mediaCantFlop = mediaCantFlop;
		this.mediaCantTurn = mediaCantTurn;
		this.mediaCantRiver = mediaCantRiver;
		this.bet3 = bet3;
		this.manos = manos;
		this.cbetCall = cbetCall;
		this.cbetCallTurn = cbetCallTurn;
		this.foldCbet = foldCbet;
	}
	public Jugador() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setVpip(int vpip) {
		this.vpip = vpip;
	}
	public double getCbet() {
		return cbet;
	}
	public void setCbet(double cbet) {
		this.cbet = cbet;
	}
	public double getVpip() {
		return vpip;
	}
	public void setVpip(double vpip) {
		this.vpip = vpip;
	}
	public double getPfr() {
		return pfr;
	}
	public void setPfr(double pfr) {
		this.pfr = pfr;
	}
	public double getMediaCantFlop() {
		return mediaCantFlop;
	}
	public void setMediaCantFlop(double mediaCantFlop) {
		this.mediaCantFlop = mediaCantFlop;
	}
	public double getMediaCantTurn() {
		return mediaCantTurn;
	}
	public void setMediaCantTurn(double mediaCantTurn) {
		this.mediaCantTurn = mediaCantTurn;
	}
	public double getBet3() {
		return bet3;
	}
	public void setBet3(double bet3) {
		this.bet3 = bet3;
	}
	public double getManos() {
		return manos;
	}
	public void setManos(double manos) {
		this.manos = manos;
	}
	public double getMediaCantRiver() {
		return mediaCantRiver;
	}
	public void setMediaCantRiver(double mediaCantRiver) {
		this.mediaCantRiver = mediaCantRiver;
	}
	public double getCbetCall() {
		return cbetCall;
	}
	public void setCbetCall(double cbetCall) {
		this.cbetCall = cbetCall;
	}
	public double getCbetCallTurn() {
		return cbetCallTurn;
	}
	public void setCbetCallTurn(double cbetCallTurn) {
		this.cbetCallTurn = cbetCallTurn;
	}
	public double getFoldCbet() {
		return foldCbet;
	}
	public void setFoldCbet(double foldCbet) {
		this.foldCbet = foldCbet;
	}
	
	
}
