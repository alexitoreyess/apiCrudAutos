package com.mx.apiCrudAutos.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MARCAS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Marcas {

	/*
	 * ID NUMBER PRIMARY KEY, NOMBRE VARCHAR2(60) NOT NULL, PAIS VARCHAR2(60),
	 * NUM_MODELOS NUMBER
	 */
	
	//mapear los campos de la tabla
	@Id
	@Column(name = "ID")
	private Long idMar;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "PAIS")
	private String pais;
	
	@Column(name = "NUM_MODELOS")
	private Integer numModelos;
	
	//SE AGREGA LA CARDINALIDAD con el decorador
	//UNO A MUCHOS
	@OneToMany(mappedBy = "marca",cascade=CascadeType.ALL)
	@JsonIgnore //con esto indicamos que una propiedad o lista de propidades será ignorada
	List<Modelos> lista=new ArrayList<Modelos>();

	
	//NO AGREGAR LA LISTA POR QUE SE CICLA

	
	
	

}
