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

import com.mx.apiCrudAutos.entity.Modelos;
import com.mx.apiCrudAutos.service.ModelosImp;

@RestController
@RequestMapping("ModelosWs")
@CrossOrigin
public class ModelosWs {

	@Autowired
	ModelosImp imp;
	
	// http://localhost:9000/ModelosWs/listar
	@GetMapping("listar")
	public List<Modelos>listar(){
		return imp.listar();
	}
	
	// http://localhost:9000/ModelosWs/guardar
	@PostMapping("guardar")
	public ResponseEntity<?>guardar(@RequestBody Modelos model){
		String respuesta = imp.guardar(model);
		if(respuesta.equals("idExiste")) {
			return new ResponseEntity<String>("ESE ID SI EXISTE. NO SE PUEDE GUARDAR", HttpStatus.OK);
		}else if(respuesta.equals("nombreExiste")) {
			return new ResponseEntity<String>("ESE NOMBRE SI EXISTE. NO SE PUEDE GUARDAR", HttpStatus.OK);
		}else if(respuesta.equals("idMarcaNoExiste")) {
			return new ResponseEntity<String>("EL ID MARCA NO EXISTE. NO SE PUEDE GUARDAR", HttpStatus.OK);
		}else
			return new ResponseEntity<>(model, HttpStatus.CREATED);
			
	}
	
	// http://localhost:9000/ModelosWs/buscar
	@PostMapping("buscar")
	public Modelos buscar(@RequestBody Modelos model) {
		return imp.buscar(model.getIdMod());
	}
	
	// http://localhost:9000/ModelosWs/editar
	@PostMapping("editar")
	public ResponseEntity<?>editar(@RequestBody Modelos modelo){
		String respuestaE = imp.editar(modelo);
		if(respuestaE.equals("idexiste")) {
			return new ResponseEntity<String>("EL ID SI EXISTE", HttpStatus.OK);
		}else if(respuestaE.equals("idnoexiste")) {
			return new ResponseEntity<String>("EL ID NO EXISTE", HttpStatus.OK);
		}
		return new ResponseEntity<>(modelo, HttpStatus.CREATED);
	}
	
	// http://localhost:9000/ModelosWs/eliminar
	@PostMapping("eliminar")
	public ResponseEntity<String>eliminar(@RequestBody Modelos modelo){
		String respuestaEl = imp.eliminar(modelo.getIdMod());
		if(respuestaEl.equals("siexiste")) {
			return new ResponseEntity<String>("EL ID SI EXISTE", HttpStatus.OK);
		}else if(respuestaEl.equals("noexiste")) {
			return new ResponseEntity<String>("EL ID NO EXISTE", HttpStatus.OK);
		}
		return new ResponseEntity<String>("SE ELIMINO CORRECTAMENTE", HttpStatus.OK);
	} 
	
	
	
}
