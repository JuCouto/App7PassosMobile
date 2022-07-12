package com.residencia.comercio.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.residencia.comercio.dtos.CategoriaDTO;
import com.residencia.comercio.entities.Categoria;
import com.residencia.comercio.exceptions.NoSuchElementFoundException;
import com.residencia.comercio.services.CategoriaService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	@Autowired
	CategoriaService categoriaService;

	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAllCategoria(@RequestParam(required = false) Integer pagina, @RequestParam(required = false) Integer qtdRegistros) {
		List<CategoriaDTO> categoriaList = categoriaService.findAllCategoriaDTO(pagina, qtdRegistros);
		return new ResponseEntity<>(categoriaList, HttpStatus.OK);
	}

	@GetMapping("/dto/{id}")
	public ResponseEntity<CategoriaDTO> findCategoriaDTOById(@PathVariable Integer id) {
		CategoriaDTO categoriaDTO = categoriaService.findCategoriaDTOById(id);
		return new ResponseEntity<>(categoriaDTO, HttpStatus.OK);
	}
	
	@ApiResponse(responseCode = "200", description = "Registro Encontrado")
	@ApiResponse(responseCode = "404", description = "Registro Não Encontrado")
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> findCategoriaById(@PathVariable Integer id) {
		Categoria categoria = categoriaService.findCategoriaById(id);
		if(null == categoria)
			throw new NoSuchElementFoundException("Não foi encontrado Categoria com o id " + id);
		else
			return new ResponseEntity<>(categoria, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Categoria> saveCategoria(@Valid @RequestBody Categoria categoria) {
		Categoria novoCategoria = categoriaService.saveCategoria(categoria);
		return new ResponseEntity<>(novoCategoria, HttpStatus.CREATED);
	}

	@PostMapping("/dto")
	public ResponseEntity<CategoriaDTO> saveCategoriaDTO(@RequestBody CategoriaDTO categoriaDTO) {
		CategoriaDTO novoCategoriaDTO = categoriaService.saveCategoriaDTO(categoriaDTO);
		return new ResponseEntity<>(novoCategoriaDTO, HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/com-foto", consumes = 
		   { MediaType.APPLICATION_JSON_VALUE, 
			MediaType.MULTIPART_FORM_DATA_VALUE})
	
	public ResponseEntity<Categoria> saveCategoriaComFoto(
			@RequestPart("categoria") String categoria,
			@RequestPart("file") MultipartFile file
			) throws Exception {
		
		Categoria novoCategoria = categoriaService.saveCategoriaComFoto(categoria, file);
		return new ResponseEntity<>(novoCategoria, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Categoria> updateCategoria(@RequestBody Categoria categoria) {
		Categoria novoCategoria = categoriaService.updateCategoria(categoria);
		return new ResponseEntity<>(novoCategoria, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCategoria(@PathVariable Integer id) {
		if(null == categoriaService.findCategoriaById(id))
			return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
		
		categoriaService.deleteCategoria(id);
		return new ResponseEntity<>("", HttpStatus.OK);
	}
	
	@GetMapping("/count")
	public Long count() {
		return categoriaService.count();
	}

}
