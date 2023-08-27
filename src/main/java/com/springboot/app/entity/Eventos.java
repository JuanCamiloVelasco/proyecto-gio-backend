package com.springboot.app.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "eventos")
public class Eventos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String tipoevent;
	private String descrevent;
	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	private Date fechaevent;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipoevent() {
		return tipoevent;
	}
	public void setTipoevent(String tipoevent) {
		this.tipoevent = tipoevent;
	}
	public String getDescrevent() {
		return descrevent;
	}
	public void setDescrevent(String descrevent) {
		this.descrevent = descrevent;
	}
	public Date getFechaevent() {
		return fechaevent;
	}
	public void setFechaevent(Date fechaevent) {
		this.fechaevent = fechaevent;
	}
	
	
}


/*package com.springboot.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "eventos")
public class Eventos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String tipoevent;
	private String descrevent;
	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	private String  fechaevent;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipoevent() {
		return tipoevent;
	}
	public void setTipoevent(String tipoevent) {
		this.tipoevent = tipoevent;
	}
	public String getDescrevent() {
		return descrevent;
	}
	public void setDescrevent(String descrevent) {
		this.descrevent = descrevent;
	}
	public String getFechaevent() {
		return fechaevent;
	}
	public void setFechaevent(String fechaevent) {
		this.fechaevent = fechaevent;
	}
	
	
}*/

