package com.residencia.comercio.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.comercio.dtos.EstoqueProdutoDTO;
import com.residencia.comercio.entities.Estoque;
import com.residencia.comercio.entities.Produto;
import com.residencia.comercio.repositories.EstoqueRepository;

@Service
public class EstoqueService {
	@Autowired
	EstoqueRepository estoqueRepository;
	
	@Autowired
	ProdutoService produtoService;
	
	public List<Estoque> findAll(){
		return estoqueRepository.findAll();
	}
	
	public List<EstoqueProdutoDTO> findEstoqueProduto(){
		List<Estoque> listEstoque = estoqueRepository.findAll();
		List<EstoqueProdutoDTO> listEstProdDTO = new ArrayList<>();
		if(!listEstoque.isEmpty()) {
			for(Estoque estoque : listEstoque) {
				
				EstoqueProdutoDTO estProdDTO = new EstoqueProdutoDTO();
				
				estProdDTO.setIdEstoque(estoque.getIdEstoque());
				estProdDTO.setIdProduto(estoque.getIdProduto());
				estProdDTO.setQuantidade(estoque.getQuantidade());
				
				if(null != estoque.getProduto()) {
					estProdDTO.setNomeProduto(estoque.getProduto().getNomeProduto());
				}else if(null == estoque.getProduto() && null != estoque.getIdProduto()) {
				
					//Se, por acaso, a relacao entre Estoque e Produto nao fosse
					//  mapeada dentro da entidade Estoque ou se a instancia da Entidade 
					// Produto for null eu teria que fazer conforme abaixo:
					Produto produto = produtoService.findById(estoque.getIdProduto()); 
					estProdDTO.setNomeProduto(produto.getNomeProduto());

				}else {
					estProdDTO.setNomeProduto(null);
				}
				
				listEstProdDTO.add(estProdDTO);
			}
		}
		
		return listEstProdDTO;
	}
	
	public Estoque findById(Integer id) {
		return estoqueRepository.findById(id).isPresent() ?
				estoqueRepository.findById(id).get() : null;
	}
}