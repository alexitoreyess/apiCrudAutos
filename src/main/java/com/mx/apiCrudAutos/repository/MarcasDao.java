package com.mx.apiCrudAutos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.apiCrudAutos.entity.Marcas;

public interface MarcasDao extends JpaRepository<Marcas, Long> {

}
