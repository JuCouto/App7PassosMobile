package com.residencia.comercio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.residencia.comercio.dtos.TokenDTO;
import com.residencia.comercio.dtos.UsuarioRecuperacaoSenhaDTO;
import com.residencia.comercio.entities.Usuario;
import com.residencia.comercio.services.TokenService;
import com.residencia.comercio.services.UsuarioService;

@RestController
@RequestMapping("/autenticacao")
public class AutenticacaoController {
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	TokenService tokenService;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@PostMapping
	public ResponseEntity<TokenDTO> auth(@RequestBody Usuario usuario){
		
		UsernamePasswordAuthenticationToken 
		usernamePasswordAuthenticationToken = 
		new UsernamePasswordAuthenticationToken(usuario.getEmail(), usuario.getSenha());
		
		Authentication 
		authentication = 
		authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		
		String token = tokenService.generateToken(authentication);
		TokenDTO tokenDTO = new TokenDTO("Bearer", token);
		return new ResponseEntity<>(tokenDTO, HttpStatus.OK);
	}
	
	@PostMapping(value = "/registro", consumes = { MediaType.APPLICATION_JSON_VALUE,
			 MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<TokenDTO> registrar(@RequestPart("usuario") String usuario, @RequestPart("file") MultipartFile file){
		Usuario novoUsuario = usuarioService.save(usuario, file);
		
		String token = tokenService.generateTokenWithUserData(novoUsuario);
		TokenDTO tokenDTO = new TokenDTO("Bearer", token);
		return new ResponseEntity<>(tokenDTO, HttpStatus.OK);
	}
	
	@PostMapping("/cadastro")
	public ResponseEntity<TokenDTO> registrarSemFile(@RequestBody Usuario usuario){
		Usuario novoUsuario = usuarioService.save2(usuario);
		
		String token = tokenService.generateTokenWithUserData(novoUsuario);
		TokenDTO tokenDTO = new TokenDTO("Bearer", token);
		return new ResponseEntity<>(tokenDTO, HttpStatus.OK);
	}
	
	
	@PostMapping("/recuperar-senha")
	public ResponseEntity<TokenDTO> recuperarSenha(@RequestBody UsuarioRecuperacaoSenhaDTO usuarioSenhaDTO){
		String encodedPass = passwordEncoder.encode(usuarioSenhaDTO.getSenha());
		usuarioSenhaDTO.setSenha(encodedPass);

        Usuario usuarioAtualizado = usuarioService.alteraSenha(usuarioSenhaDTO);
		
		String token = tokenService.generateTokenWithUserData(usuarioAtualizado);
		TokenDTO tokenDTO = new TokenDTO("Bearer", token);
		return new ResponseEntity<>(tokenDTO, HttpStatus.OK);
	}
	
}
