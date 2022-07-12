package com.residencia.comercio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.residencia.comercio.entities.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {

}
