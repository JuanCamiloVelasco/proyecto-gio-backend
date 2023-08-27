package com.springboot.app.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.springboot.app.entity.Eventos;

public interface IEventosDao extends CrudRepository<Eventos, Integer>, JpaSpecificationExecutor<Eventos> {

	public List<Eventos> findAllByFechaeventAfterAndFechaeventBefore(Date dateOne, Date dateTwo);
	
}
