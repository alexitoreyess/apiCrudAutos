package com.mx.apiCrudAutos.service;

import java.util.List;

import com.mx.apiCrudAutos.entity.Marcas;

public interface MarcaServ {

	public String guardar(Marcas marca);
	
	public List<Marcas> listar();
	
	public Marcas buscar(Long id);
	
	public String editar (Marcas marca);
	
	public String  eliminar(Long id);
	
}
