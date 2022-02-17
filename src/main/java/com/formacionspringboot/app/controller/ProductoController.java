package com.formacionspringboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.formacionspringboot.app.entity.Producto;
import com.formacionspringboot.app.service.ProductoService;



@Controller
public class ProductoController {
	@Autowired
	private ProductoService servicio;
	
	@GetMapping("/productos")
	public String listarProductos(Model model) {
		model.addAttribute("empleados",servicio.listarTodosLosProductos());
		return "productos";
	}
	
	@GetMapping("/producto/nuevo")
	public String formularioProducto(Model modelo) {
		Producto newProducto=new Producto();
		modelo.addAttribute("productoKey", newProducto);
		return "nuevo_producto";
	}
	
	@PostMapping("/producto")
	public String guardarProducto(@ModelAttribute("empleadoKey") Producto producto) {
		servicio.guardarProducto(producto);
		return "redirect:/productos";
	}
	
	@GetMapping("producto/editar/{id}")
	public String formulalrioEdicionProducto(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("departamentoKey", servicio.obtenerProductoPorId(id));
		return "editar_producto";
	}
	
	@PostMapping("/producto/editar/{id}")
	public String editarProducto(@PathVariable Long id, @ModelAttribute("productoKey") Producto producto) {
		Producto productoEdit=servicio.obtenerProductoPorId(id);
		productoEdit.setNombre(producto.getNombre());
		productoEdit.setDescripcion(producto.getDescripcion());
		productoEdit.setPrecioUnitario(producto.getPrecioUnitario());
		productoEdit.setExistencias(producto.getExistencias());
		servicio.guardarProducto(productoEdit);
		return "redirect:/productos";
	}
	
	@GetMapping("/producto/borrar/{id}")
	public String eliminarProdcuto(@PathVariable Long id) {
		servicio.eliminarProducto(id);
		return "redirect:/producto";
	}
}
