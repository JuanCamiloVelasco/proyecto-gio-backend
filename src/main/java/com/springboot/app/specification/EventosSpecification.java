package com.springboot.app.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.springboot.app.entity.Eventos;

@Component
public class EventosSpecification {
	
	public static Specification<Eventos> ConsultaTipoEvent(String evento){
		return ((root, criteriaQuery, criteriaBuilder) -> {
			return criteriaBuilder.equal(root.get("tipoevent"), evento);	
		});
	}
	
}

