package com.poker.model;



import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@Entity
@Table(name = "fechas_wina")
@IdClass(FechaIdWina.class)
public class FechaWina {
@Id
private String id_mano;
private Date fecha;
@Id
private String username;

public FechaWina() {
	super();
	// TODO Auto-generated constructor stub
}





public String getId_mano() {
	return id_mano;
}
public void setId_mano(String id_mano) {
	this.id_mano = id_mano;
}


public FechaWina(String id_mano, Date fecha, String username) {
	super();
	this.id_mano = id_mano;
	this.fecha = fecha;
	this.username = username;
}





public Date getFecha() {
	return fecha;
}





public void setFecha(Date fecha) {
	this.fecha = fecha;
}





public String getUsername() {
	return username;
}



public void setUsername(String username) {
	this.username = username;
}


}
