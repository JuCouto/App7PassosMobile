package com.residencia.comercio.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.comercio.entities.Usuario;
import com.residencia.comercio.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<Usuario> save(@Valid @RequestBody Usuario usuario){
		return new ResponseEntity<>(usuarioService.save2(usuario), HttpStatus.CREATED);
	}
	
}
