package com.idat.EFJhonGarciaMedinaPizza.service;

import java.util.List;

import com.idat.EFJhonGarciaMedinaPizza.dto.PizzaDTORequest;
import com.idat.EFJhonGarciaMedinaPizza.dto.PizzaDTOResponse;

public interface PizzaService {
	
	public List<PizzaDTOResponse> listarPizza();
	
	public void registrarPizza(PizzaDTORequest pizza);
	
	public void editarPizza(PizzaDTORequest pizza);
	
	public void eliminarPizza(Integer id);
	
	public PizzaDTOResponse obtenerPizza(Integer id);

}
