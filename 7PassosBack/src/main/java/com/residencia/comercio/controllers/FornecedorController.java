package com.residencia.comercio.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.comercio.dtos.CadastroEmpresaReceitaDTO;
import com.residencia.comercio.dtos.FornecedorDTO;
import com.residencia.comercio.entities.Fornecedor;
import com.residencia.comercio.exceptions.NoSuchElementFoundException;
import com.residencia.comercio.services.FornecedorService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/fornecedor")
@Validated
public class FornecedorController {
	@Autowired
	FornecedorService fornecedorService;

	@GetMapping
	public ResponseEntity<List<Fornecedor>> findAllFornecedor() {
		List<Fornecedor> fornecedorList = fornecedorService.findAllFornecedor();
		return new ResponseEntity<>(fornecedorList, HttpStatus.OK);
	}
	
	@GetMapping("/cnpj/{cnpj}")
	public ResponseEntity<CadastroEmpresaReceitaDTO> consultarDadosPorCnpj(
			@PathVariable @NotBlank @Pattern(regexp="^[0-9]{14}", message="O CNPJ deve conter apenas números, com 14 dígitos.") String cnpj) {
		CadastroEmpresaReceitaDTO cadEmpresaDTO = fornecedorService.consultarDadosPorCnpj(cnpj);
		if(null == cadEmpresaDTO)
			throw new NoSuchElementFoundException("Não foram encontrados dados para o CNPJ informado");
		else
			return new ResponseEntity<>(cadEmpresaDTO, HttpStatus.OK);
	}

	@GetMapping("/cnpj/query")
	public ResponseEntity<CadastroEmpresaReceitaDTO> queryConsultarDadosPorCnpj(
			@RequestParam @Pattern(regexp="^[0-9]{14}", message="O CNPJ deve conter apenas números, com 14 dígitos.") String cnpj) {
		CadastroEmpresaReceitaDTO cadEmpresaDTO = fornecedorService.consultarDadosPorCnpj(cnpj);
		if(null == cadEmpresaDTO)
			throw new NoSuchElementFoundException("Não foram encontrados dados para o CNPJ informado");
		else
			return new ResponseEntity<>(cadEmpresaDTO, HttpStatus.OK);
	}
	
	@GetMapping("/dto/{id}")
	public ResponseEntity<FornecedorDTO> findFornecedorDTOById(@PathVariable Integer id) {
		FornecedorDTO fornecedorDTO = fornecedorService.findFornecedorDTOById(id);
		return new ResponseEntity<>(fornecedorDTO, HttpStatus.OK);
	}
	
	@ApiResponse(responseCode = "200", description = "Registro Encontrado")
	@ApiResponse(responseCode = "404", description = "Registro Não Encontrado")
	@GetMapping("/{id}")
	public ResponseEntity<Fornecedor> findFornecedorById(@PathVariable Integer id) {
		Fornecedor fornecedor = fornecedorService.findFornecedorById(id);
		if(null == fornecedor)
			throw new NoSuchElementFoundException("Não foi encontrado Fornecedor com o id " + id);
		else
			return new ResponseEntity<>(fornecedor, HttpStatus.OK);
	}
	
	@PostMapping("/cnpj")
	public ResponseEntity<Fornecedor> saveFornecedor(@Pattern(regexp="^[0-9]{14}", message="O CNPJ deve conter apenas números, com 14 dígitos.") @RequestBody String cnpj) {
		Fornecedor fornecedor = new Fornecedor();
		Fornecedor novoFornecedor = fornecedorService.saveFornecedor(fornecedor);
		return new ResponseEntity<>(novoFornecedor, HttpStatus.CREATED);
	}

	@PostMapping
	public ResponseEntity<Fornecedor> saveFornecedorCompleto(
			@Valid @RequestBody Fornecedor fornecedor) {
		Fornecedor novoFornecedor = fornecedorService.saveFornecedor(fornecedor);
		return new ResponseEntity<>(novoFornecedor, HttpStatus.CREATED);
	}
	
	@PostMapping("/dto")
	public ResponseEntity<FornecedorDTO> saveFornecedorDTO(@RequestBody FornecedorDTO fornecedorDTO) {
		FornecedorDTO novoFornecedorDTO = fornecedorService.saveFornecedorDTO(fornecedorDTO);
		return new ResponseEntity<>(novoFornecedorDTO, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Fornecedor> updateFornecedor(@RequestBody Fornecedor fornecedor) {
		Fornecedor novoFornecedor = fornecedorService.updateFornecedor(fornecedor);
		return new ResponseEntity<>(novoFornecedor, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteFornecedor(@PathVariable Integer id) {
		if(null == fornecedorService.findFornecedorById(id))
			return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
		
		fornecedorService.deleteFornecedor(id);
		return new ResponseEntity<>("", HttpStatus.OK);
	}

}
