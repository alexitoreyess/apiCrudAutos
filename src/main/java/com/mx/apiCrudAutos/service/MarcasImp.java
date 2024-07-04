package com.mx.apiCrudAutos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.apiCrudAutos.entity.Marcas;
import com.mx.apiCrudAutos.repository.MarcasDao;

@Service
public class MarcasImp implements MarcaServ{

	@Autowired
	MarcasDao marcadao;
	
	@Transactional
	@Override
	public String guardar(Marcas marca) {
		// TODO Auto-generated method stub
		String respuesta="";
		boolean bandera=false;
		for(Marcas m: marcadao.findAll()) {
			if(m.getIdMar()==marca.getIdMar()) {
				respuesta="siexisteid";
				bandera=true;
			}else if(m.getNombre().equals(marca.getNombre())) {
				respuesta="siexistenom";
				bandera=true;
			}
		}
		if(bandera==false) {
			respuesta="guardar";
			marcadao.save(marca);
		}
		return respuesta;
		
	}

	@Transactional(readOnly = true)
	@Override
	public List<Marcas> listar() {
		// TODO Auto-generated method stub
		return marcadao.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Marcas buscar(Long id) {
		// TODO Auto-generated method stub
		return marcadao.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public String editar(Marcas marca) {
		// TODO Auto-generated method stub
		String respuesta="";
		boolean bandera=false;
		for(Marcas m : marcadao.findAll()) {
			if(m.getIdMar()==marca.getIdMar()) {
				respuesta="siexiste";
				bandera=true;
			}else if(bandera==false) {
				respuesta="noexiste";
			}
			if(bandera==true) {
				respuesta="guardado";
				marcadao.save(marca);
			}
		}
		return respuesta;
		
	
	}

	@Override
	public String eliminar(Long id) {
		// TODO Auto-generated method stub
		String respuesta="";
		boolean bandera= false;
		for(Marcas m: marcadao.findAll()) {
			if(m.getIdMar().equals(id)) {
				respuesta="existe";
				bandera=true;
			}else if(bandera==false) {
				respuesta="noexiste";
			}
			if(bandera==true) {
				respuesta="eliminado";
				marcadao.deleteById(id);
			}
		}
		return respuesta;
	}

}
