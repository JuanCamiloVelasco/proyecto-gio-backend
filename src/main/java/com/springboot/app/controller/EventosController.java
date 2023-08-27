package com.springboot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.entity.Eventos;
import com.springboot.app.service.IEventosService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EventosController {

	@Autowired
	private IEventosService eventosService;
	
	@GetMapping("/eventos")
	public List<Eventos> getAllEventos(){
		return eventosService.findAll();
	}
	
	@GetMapping("/eventos/{id}")
	public ResponseEntity<Eventos> getEventoById(@PathVariable int id){
		Eventos eventos = eventosService.findOne(id);
		return ResponseEntity.ok(eventos);
	}
	
	@PostMapping("/eventos")
	public Eventos crearEvento (@RequestBody Eventos eventos) {
		return eventosService.save(eventos);
	}
	
	@PutMapping("/eventos/{id}")
	public ResponseEntity<Eventos> updateEventos(@PathVariable int id, @RequestBody Eventos detallesEvento){
		detallesEvento = eventosService.update(id, detallesEvento);
		return ResponseEntity.ok(detallesEvento);
	}
	
	@DeleteMapping("/eventos/{id}")
	public boolean deleteEventos(@PathVariable int id) {
		return eventosService.delete(id);
	}
	
	@GetMapping("/filtro/{fechaInicial}/{fechaFinal}")
    public List<Eventos> reportFechas(@PathVariable("fechaInicial") String dateOne, @PathVariable("fechaFinal") String dateTwo){
        return eventosService.findFechas(dateOne, dateTwo);
    }
	
	@GetMapping("/criteria/{tipo}")
	public List<Eventos> getCodigoMen(@PathVariable String tipo){
		return eventosService.findEventos(tipo);
	}
	
}
