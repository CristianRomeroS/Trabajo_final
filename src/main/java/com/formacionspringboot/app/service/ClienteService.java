package com.formacionspringboot.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.formacionspringboot.app.entity.Cliente;

public interface ClienteService {
	
	public List<Cliente> findAll();
	
	public Cliente findById(long id);
	
	public Cliente save(Cliente cliente);
	
	public void delete(long id);

}
