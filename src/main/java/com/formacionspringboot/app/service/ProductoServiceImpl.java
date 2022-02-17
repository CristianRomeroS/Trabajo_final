package com.formacionspringboot.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacionspringboot.app.dao.ProductoDao;
import com.formacionspringboot.app.entity.Producto;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	ProductoDao productoDao;

	@Override
	public List<Producto> listarTodosLosProductos() {
		return productoDao.findAll();
	}

	@Override
	public Producto guardarDepartamento(Producto producto) {
		return productoDao.save(producto);
	}

	@Override
	public Producto obtenerProductoPorId(Long id) {
		return productoDao.findById(id).get();
	}

	@Override
	public void eliminarProducto(Long id) {
		productoDao.deleteById(id);
	}

	
}
