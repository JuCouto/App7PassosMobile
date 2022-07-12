package com.residencia.comercio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.residencia.comercio.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {

	
}