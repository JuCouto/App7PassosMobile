package com.residencia.comercio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.comercio.dtos.EstoqueProdutoDTO;
import com.residencia.comercio.entities.Estoque;
import com.residencia.comercio.services.EstoqueService;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {
	@Autowired
	EstoqueService estoqueService;
	
	@GetMapping
	public ResponseEntity<List<Estoque>> findAll(){
		return new ResponseEntity<>(estoqueService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/estoque-produto")
	public ResponseEntity<List<EstoqueProdutoDTO>> findEstoqueProduto(){
		List<EstoqueProdutoDTO> listEstProdDTO = estoqueService.findEstoqueProduto();
		if(!listEstProdDTO.isEmpty())
			return new ResponseEntity<>(listEstProdDTO, HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Estoque> findById(@PathVariable Integer id){
		Estoque estoque = estoqueService.findById(id);
		if(null != estoque)
			return new ResponseEntity<>(estoque, HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
}
