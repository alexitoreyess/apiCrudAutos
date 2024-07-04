package com.mx.apiCrudAutos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.apiCrudAutos.entity.Marcas;
import com.mx.apiCrudAutos.entity.Modelos;
import com.mx.apiCrudAutos.repository.MarcasDao;
import com.mx.apiCrudAutos.repository.ModelosDo;

@Service
public class ModelosImp implements ModeloServ {

	@Autowired
	ModelosDo dao;
	@Autowired
	MarcasDao daom;

	@Transactional(readOnly = true)
	@Override
	public List<Modelos> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Transactional
	@Override
	public String guardar(Modelos modelo) {
		// TODO Auto-generated method stub
		String respuesta = "";
		boolean banderama = false;
		boolean banderamo = false;

		for (Marcas ma : daom.findAll()) {
			if (ma.getIdMar() == modelo.getMarca().getIdMar()) {
				banderama = true;
				for (Modelos mo : dao.findAll()) {
					if (mo.getIdMod() == modelo.getIdMod()) {
						banderamo = true;
						respuesta = "idExiste";
					} else if (mo.getNombre().equals(modelo.getNombre())) {
						banderamo = true;
						respuesta = "nombreExiste";
					}
				}
				break;
			}
		}
		// validar marca no existe
		if (banderama == false) {
			respuesta = "idMarcaNoExiste";
			banderamo = true;
		} else if (banderamo == false) {
			dao.save(modelo);
		}
		return respuesta;

	}

	@Transactional(readOnly = true)
	@Override
	public Modelos buscar(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);

	}

	@Transactional
	@Override
	public String editar(Modelos modelo) {
		// TODO Auto-generated method stub
		String respuesta = "";
		boolean bandera = false;
		for (Modelos m : dao.findAll()) {
			if (m.getIdMod() == modelo.getIdMod()) {
				respuesta = "idexiste";
				bandera = true;
			} else {
				bandera = false;
				respuesta = "idnoexiste";
			}
			if (bandera == true) {
				respuesta = "guardar";
				dao.save(modelo);
			}
		}
		return respuesta;
	}

	@Transactional
	@Override
	public String eliminar(Long id) {
		// TODO Auto-generated method stub
		String respuesta = "";
		boolean bandera = false;
		for (Modelos m : dao.findAll()) {
			if (m.getIdMod().equals(id)) {
				respuesta = "existe";
				bandera = true;
			} else {
				bandera = false;
				respuesta = "noexiste";
			}
			if (bandera == true) {
				respuesta = "eliminado";
				dao.deleteById(id);
			}
		}
		return respuesta;
	}

}
