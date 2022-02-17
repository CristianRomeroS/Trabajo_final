package com.formacionspringboot.app.service;

import java.util.List;

import com.formacionspringboot.app.entity.Producto;



public interface ProductoService {
	
	
	public List<Producto> listarTodosLosProductos();
	
	public Producto guardarProducto(Producto producto);
	
	public Producto obtenerProductoPorId(Long id);
	
	public void eliminarProducto(Long id);

}
