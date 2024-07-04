package com.mx.apiCrudAutos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.apiCrudAutos.entity.Marcas;
import com.mx.apiCrudAutos.service.MarcasImp;

@RestController
@RequestMapping("MarcasWS")
@CrossOrigin
public class MarcasWS {

	@Autowired
	MarcasImp imp;
	
	// http://localhost:9000/MarcasWS/listar
	@GetMapping("listar")
	public List<Marcas> listar(){
		return imp.listar();
	}
	
	// http://localhost:9000/MarcasWS/guardar
	@PostMapping("guardar")
	public ResponseEntity<?>guardar(@RequestBody Marcas marca){
		String respuesta = imp.guardar(marca);
		if(respuesta.equals("siexisteid")) {
			return new ResponseEntity<String>("ESE ID SI EXISTE", HttpStatus.OK);
		}else if(respuesta.equals("siexistenom")) {
			return new ResponseEntity<String>("ESE NOMBRE SI EXISTE", HttpStatus.OK);
		}else
			return new ResponseEntity<>(marca, HttpStatus.CREATED);
		
	}
	
	// http://localhost:9000/MarcasWS/buscar
	@PostMapping("buscar")
	public Marcas buscar(@RequestBody Marcas marca) {
		return imp.buscar(marca.getIdMar());
	}
	
	// http://localhost:9000/MarcasWS/editar
	@PostMapping("editar")
	public ResponseEntity<?>editar(@RequestBody Marcas marca){
		String respuestaE = imp.editar(marca);
		if(respuestaE.equals("siexiste")) {
			return new ResponseEntity<String>("EL ID SI EXISTE",HttpStatus.OK);
		}else if(respuestaE.equals("noexiste")) {
			return new ResponseEntity<String>("EL ID NO EXISTE",HttpStatus.OK);
		}
		return new ResponseEntity<>(marca , HttpStatus.CREATED);
	}
	
	// http://localhost:9000/MarcasWS/eliminar
	@PostMapping("eliminar")
	public ResponseEntity<String>eliminar(@RequestBody Marcas marca){
		String respuestaEl = imp.eliminar(marca.getIdMar());
		if(respuestaEl.equals("existe")) {
			return new ResponseEntity<String>("EL ID SI EXISTE",HttpStatus.OK);
		}else if(respuestaEl.equals("noexiste")) {
			return new ResponseEntity<String>("EL ID NO EXISTE",HttpStatus.OK);
		}
		return new ResponseEntity<String>("SE ELIMINO CORRECTAMENTE",HttpStatus.OK);
	}
	
	
	
	
}
