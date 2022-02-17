package com.formacionspringboot.app.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.formacionspringboot.app.entity.Cliente;


public interface ClienteDao extends JpaRepository<Cliente, Long>{

	
	
}
