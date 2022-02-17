package com.formacionspringboot.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacionspringboot.app.entity.Venta;

@Service
public class VentaServiceImpl implements VentaService{
	
	@Autowired
	VentaDao ventaDao;

	@Override
	public List<Venta> listarTodosLasVentas() {
		return ventaDao.findAll();
	}

	@Override
	public Venta guardarVenta(Venta venta) {
		return ventaDao.save(venta);
	}

	@Override
	public Venta obtenerVentaPorId(Long id) {
		return ventaDao.findById(id).get();
	}

	@Override
	public void eliminarVenta(Long id) {
		ventaDao.deleteById(id);
	}

}
