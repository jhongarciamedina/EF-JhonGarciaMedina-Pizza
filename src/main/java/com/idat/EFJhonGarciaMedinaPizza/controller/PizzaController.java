package com.idat.EFJhonGarciaMedinaPizza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.EFJhonGarciaMedinaPizza.dto.PizzaDTORequest;
import com.idat.EFJhonGarciaMedinaPizza.dto.PizzaDTOResponse;
import com.idat.EFJhonGarciaMedinaPizza.service.PizzaService;

@Controller
@RequestMapping("/api/v1/pizza")
public class PizzaController {
	
	
	@Autowired
	private PizzaService pizzaService;
	
	
	@GetMapping("/listarPizza")
	public @ResponseBody List<PizzaDTOResponse> listarPizza(){
		return pizzaService.listarPizza();
	}
	@GetMapping("/listar/{id}")
	public @ResponseBody PizzaDTOResponse obtenerPizzaId(@PathVariable Integer id) {
		return pizzaService.obtenerPizza(id);
		
	}
	@PostMapping("/guardarPizza")
	public void guardarClientes(@RequestBody PizzaDTORequest pizza) {
		pizzaService.registrarPizza(pizza);
	}
	
	@PutMapping("/editarPizza")
	public void actualizarPizza(@RequestBody PizzaDTORequest pizza) {
		pizzaService.obtenerPizza(pizza.getIdPizzaDTO());
		pizzaService.editarPizza(pizza);
	}
	@DeleteMapping("/eliminar/id")
	public void eliminarClientes(@PathVariable("id") Integer id) {
		pizzaService.eliminarPizza(id);
	}

}
