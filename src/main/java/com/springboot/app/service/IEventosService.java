package com.springboot.app.service;

import java.util.List;

import com.springboot.app.entity.Eventos;

public interface IEventosService {
	
	public List<Eventos> findAll();
	
	public Eventos save (Eventos eventos);
	
	public Eventos findOne (int id);
	
	public boolean delete (int id);
	
	public Eventos update (int id, Eventos eventos);
	
	public List<Eventos> findFechas(String a, String b);
	
	public List<Eventos> findEventos(String evento);
	
}