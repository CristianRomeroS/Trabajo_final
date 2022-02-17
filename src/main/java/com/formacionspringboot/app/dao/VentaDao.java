package com.formacionspringboot.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.formacionspringboot.app.entity.Venta;



public interface VentaDao extends JpaRepository<Venta, Long>{

	
	
}