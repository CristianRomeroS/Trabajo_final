package com.formacionspringboot.app.service;

import java.util.List;

import com.formacionspringboot.app.entity.Venta;

public interface VentaService {
	
	public List<Venta> listarTodosLasVentas();
	
	public Venta guardarVenta(Venta departamento);
	
	public Venta obtenerVentaPorId(Long id);
	
	public void eliminarVenta(Long id);

}
