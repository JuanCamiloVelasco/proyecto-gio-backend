package com.springboot.app.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.app.dao.IEventosDao;
import com.springboot.app.entity.Eventos;
import com.springboot.app.service.IEventosService;
import com.springboot.app.specification.EventosSpecification;


@Service
public class EventosServiceImplement implements IEventosService{

	@Autowired
	private IEventosDao eventosDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Eventos> findAll(){
		return (List<Eventos>) eventosDao.findAll();
	}
	
	@Override
	@Transactional
	public Eventos save(Eventos eventos) {
		return eventosDao.save(eventos);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Eventos findOne(int id) {
		return eventosDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public boolean delete(int id) {
		Optional<Eventos> event = eventosDao.findById(id);
		if(!event.isEmpty()) {
			eventosDao.deleteById(id);
			return true;
		}
		return false;
	}
	
	@Override
	@Transactional
	public Eventos update(int id, Eventos detallesEventos) {
		
		Eventos eventos = eventosDao.findById(id).get();
		eventos.setTipoevent(detallesEventos.getTipoevent());
		eventos.setDescrevent(detallesEventos.getDescrevent());
		eventos.setFechaevent(detallesEventos.getFechaevent());
		eventosDao.save(eventos);
		return detallesEventos;
		
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Eventos> findFechas(String dateA, String dateB) {
        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date aDate= new Date();
        Date bDate= new Date();
        
        try {
        
            aDate = parser.parse(dateA);
            bDate = parser.parse(dateB);
            
        }catch(ParseException event){
            event.printStackTrace();
        }
        if(aDate.before(bDate)){
            return eventosDao.findAllByFechaeventAfterAndFechaeventBefore(aDate, bDate);
        }else{
            return new ArrayList<>();
        }
    }

	@Override
	@Transactional(readOnly = true)
	public List<Eventos> findEventos(String evento) {
		Specification<Eventos> specifications = Specification
				.where(EventosSpecification.ConsultaTipoEvent(evento));
		return eventosDao.findAll(specifications);
	}
	
	
}
