package com.idat.EFJhonGarciaMedinaPizza.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "pizza")
public class Pizza {
	
	private Integer idPizza;
	private String nombrePizza;
	private String descripcion;

}
