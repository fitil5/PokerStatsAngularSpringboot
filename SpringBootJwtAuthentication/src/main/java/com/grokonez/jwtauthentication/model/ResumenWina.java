package com.grokonez.jwtauthentication.model;



import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "resumen_wina")
public class ResumenWina {
	@Id
private String id_mano;
private Date fecha;
private String txt;
public String getId_mano() {
	return id_mano;
}

public ResumenWina(String id_mano, Date fecha, String txt) {
	super();
	this.id_mano = id_mano;
	this.fecha = fecha;
	this.txt = txt;
}

public void setId_mano(String id_mano) {
	this.id_mano = id_mano;
}

public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public String getTxt() {
	return txt;
}
public void setTxt(String txt) {
	this.txt = txt;
}
public ResumenWina() {
	super();
	// TODO Auto-generated constructor stub
}

}
