package com.idat.EFJhonGarciaMedinaPizza.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.EFJhonGarciaMedinaPizza.dto.PizzaDTORequest;
import com.idat.EFJhonGarciaMedinaPizza.dto.PizzaDTOResponse;
import com.idat.EFJhonGarciaMedinaPizza.model.Pizza;
import com.idat.EFJhonGarciaMedinaPizza.repository.PizzaRepository;

@Service
public class PizzaServiceImpl implements PizzaService {
	@Autowired
	public 	PizzaRepository pizzaRepository;

	@Override
	public List<PizzaDTOResponse> listarPizza() {
		List<PizzaDTOResponse> lista = new ArrayList<PizzaDTOResponse>();
		PizzaDTOResponse p= null;
		for(Pizza pizza : pizzaRepository.findAll()) {
			p= new PizzaDTOResponse();
			p.setIdPizzaDTO(pizza.getIdPizza());
			p.setNombrePizzaDTO(pizza.getNombrePizza());
			p.setDescripcionDTO(pizza.getDescripcion());
			lista.add(p);
		}
		return lista;
	}

	@Override
	public void registrarPizza(PizzaDTORequest pizza) {
		Pizza p = new Pizza();
		
		p.setIdPizza(pizza.getIdPizzaDTO());
		p.setNombrePizza(pizza.getNombrePizzaDTO());
		p.setDescripcion(pizza.getDescripcionDTO());
		pizzaRepository.save(p);
		
	}

	@Override
	public void editarPizza(PizzaDTORequest pizza) {
		Pizza p = new Pizza();
		
		p.setIdPizza(pizza.getIdPizzaDTO());
		p.setNombrePizza(pizza.getNombrePizzaDTO());
		p.setDescripcion(pizza.getDescripcionDTO());
		pizzaRepository.saveAndFlush(p);
		
		
	}

	@Override
	public void eliminarPizza(Integer id) {
		// TODO Auto-generated method stub
		pizzaRepository.deleteById(id);
		
	}

	@Override
	public PizzaDTOResponse obtenerPizza(Integer id) {
		Pizza pizza= pizzaRepository.findById(id).orElse(null);
		PizzaDTOResponse p=new	PizzaDTOResponse();
		
		p.setIdPizzaDTO(pizza.getIdPizza());
		p.setNombrePizzaDTO(pizza.getNombrePizza());
		p.setDescripcionDTO(pizza.getDescripcion());
		
		return p;
	}

}
