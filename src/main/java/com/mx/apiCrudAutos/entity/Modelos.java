package com.mx.apiCrudAutos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MODELOS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Modelos {
	/*
	 * iD NUMBER PRIMARY KEY, NOMBRE VARCHAR2(60) NOT NULL, PRECIO NUMBER, TIPO
	 * VARCHAR2(50), ID_MARCA NUMBER, FOREIGN KEY(ID_MARCA) REFERENCES MARCAS_19(ID)
	 */
	
	@Id
	@Column(name = "ID")
	private Long idMod;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "PRECIO")
	private Float precio;
	
	@Column(name = "TIPO")
	private String tipo;
	
	//CARDINALIDAD muchos a uno
	//Fech---indicamos como debe ser cargada la entidad
	//FetchType---indicamos que la relacion debe ser cargada al momento
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_MARCA")
	Marcas marca;

	
	
	
	
	
	

}
