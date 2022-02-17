package com.formacionspringboot.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formacionspringboot.app.entity.Producto;


public interface ProductoDao extends JpaRepository<Producto, Long>{

	
	
}