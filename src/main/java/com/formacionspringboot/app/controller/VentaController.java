package com.formacionspringboot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.formacionspringboot.app.entity.Venta;
import com.formacionspringboot.app.service.VentaService;

@Controller
public class VentaController {
	
	@Autowired
	private VentaService ventaService;
	
	@GetMapping({"/ventas"})
	public String listarProyecto(Model model) {
		List<Venta> ventas = ventaService.listarTodosLasVentas();
		model.addAttribute("ventas", ventas);
		return "ventas";
	}
	
	@GetMapping("/nuevo-venta")
	public String formularioVenta(Model model) {
		Venta venta = new Venta();
		model.addAttribute("venta", venta);
		return "nuevo-venta";
	}

	@PostMapping("/nueva-venta")
	public String guardarVenta(@ModelAttribute("venta") Venta venta) {
		ventaService.guardarVenta(venta);
		return "redirect:/ventas";
	}
	
	@GetMapping("/editar-venta/{id}")
	public String formularioEdicionVenta(@PathVariable Long id, Model model) {
		Venta venta = ventaService.obtenerVentaPorId(id);
		model.addAttribute("venta", venta);
		return "editar-ventas";
	}
	
	@PostMapping("/editar-venta/{id}")
	public String editarVenta(@ModelAttribute("venta") Venta venta, @PathVariable Long id) {
		Venta ventaModificar = ventaService.obtenerVentaPorId(id);
		ventaModificar.setCliente(venta.getCliente());
		ventaModificar.setProducto(venta.getProducto());
		ventaModificar.setIva(venta.getIva());
		ventaModificar.setSubtotal(venta.getSubtotal());
		ventaModificar.setTotal(venta.getTotal());
		ventaModificar.setCantidad(venta.getCantidad());
		return "redirect:/ventas";
	}
	
	@GetMapping("/eliminar-venta/{id}")
	public String eliminarProyecto(@PathVariable Long id) {
		ventaService.eliminarVenta(id);
		return "redirect:/ventas";
	}

}
