package com.mx.apiCrudAutos.service;

import java.util.List;

import com.mx.apiCrudAutos.entity.Modelos;

public interface ModeloServ {

	public List<Modelos> listar();
	
	public String guardar(Modelos modelo);
	
	public Modelos buscar(Long id);
	
	public String editar (Modelos modelo);
	
	public String eliminar(Long id);
	
	
}
