package com.formacionspringboot.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.formacionspringboot.app.entity.Venta;
import com.formacionspringboot.app.service.VentaService;

@Controller
public class VentaController {
	
	@Autowired
	private VentaService ventaService;
	
	@GetMapping("/ventas")
	public String listarVentas(Model model) {
		List<Venta> ventas = ventaService.listarTodosLasVentas();
		model.addAttribute("ventaKey", ventas);
		return "ventas";
	}
	
	@GetMapping("/nuevo-venta")
	@ResponseBody
	public String formularioVenta(Model model) {
		Venta venta = new Venta();
		model.addAttribute("ventaKey", venta);
		return "nuevo-venta";
	}
	
	@PostMapping("/ventas")
	public ResponseEntity<?> saveVenta(@RequestBody Venta venta) {
		Venta ventaNew = null;
		Map<String, Object> response = new HashMap<>();

		try {

			ventaNew = ventaService.guardarVenta(venta);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar insert a la base de datos");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		response.put("mensaje", "La venta ha sido creado con éxito!");
		response.put("venta", ventaNew);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}
	

	@PostMapping("/nueva-venta")
	public String guardarVenta(@ModelAttribute("venta") Venta venta) {
		ventaService.guardarVenta(venta);
		return "redirect:/ventas";
	}
	
	@GetMapping("/editar-venta/{id}")
	public String formularioEdicionVenta(@PathVariable Long id, Model model) {
		Venta venta = ventaService.obtenerVentaPorId(id);
		model.addAttribute("ventaKey", venta);
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
