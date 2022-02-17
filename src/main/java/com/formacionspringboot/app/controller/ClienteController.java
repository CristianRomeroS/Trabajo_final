package com.formacionspringboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.formacionspringboot.app.entity.Cliente;
import com.formacionspringboot.app.service.ClienteService;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteService servicio;
	
	@GetMapping({"/clientes"})
	public String listarClientes(Model model) {
		model.addAttribute("key",servicio.findAll());
		return"clientes";
	}
	
	@GetMapping("/cliente/nuevo")
	public String formularioCliente(Model modelo) {
		Cliente newCliente = new Cliente();
		modelo.addAttribute("clienteKey",newCliente);
		return "nuevo_cliente";
	}
	
	@PostMapping("cliente")
	public String guardarCliente(@ModelAttribute("clienteKey") Cliente cliente) {
		servicio.save(cliente);
		return "redirect:/clientes";
	}
	
	@GetMapping("/cliente/editar/{id}")
	public String formularioEdicionCliente(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("clienteKey", servicio.findById(id));
		return "editar_cliente";
		
	}
	
	@PostMapping("/cliente/editar/{id}")
	public String editarCliente(@PathVariable Long id, @ModelAttribute("clienteKey") Cliente cliente) {
		Cliente newCliente = servicio.findById(id);
		newCliente.setNombre(cliente.getNombre());

		return "redirect:/clientes";
	}

}
