package com.residencia.comercio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.residencia.comercio.entities.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor,Integer> {

}