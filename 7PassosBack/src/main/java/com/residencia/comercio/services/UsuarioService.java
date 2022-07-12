package com.residencia.comercio.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.residencia.comercio.dtos.UsuarioRecuperacaoSenhaDTO;
import com.residencia.comercio.entities.Usuario;
import com.residencia.comercio.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	ArquivoService arquivoService;
	
	public Usuario save(String usuarioJson, MultipartFile file) {
		Usuario usuario = convertUsuarioFromStringJson(usuarioJson);
		String encodedPass = passwordEncoder.encode(usuario.getSenha());
		usuario.setSenha(encodedPass);
		Usuario novoUsuario = usuarioRepository.save(usuario);

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        fileName = "usuario_" + novoUsuario.getIdUsuario().toString() + "_" + fileName;
        novoUsuario.setFotoPerfil(fileName);
        arquivoService.storeFile(file, fileName);
        
        return usuarioRepository.save(novoUsuario); 
	}
	
	public Usuario save2(Usuario usuario) {
		String encodedPass = passwordEncoder.encode(usuario.getSenha());
		usuario.setSenha(encodedPass);
		Usuario novoUsuario = usuarioRepository.save(usuario);
        
        return usuarioRepository.save(novoUsuario); 
	}
	
	
	public Usuario alteraSenha(UsuarioRecuperacaoSenhaDTO usuarioSenhaDTO) {
		Usuario usuario = usuarioRepository.findByEmail(usuarioSenhaDTO.getEmail()).get();
		usuario.setSenha(usuarioSenhaDTO.getSenha());
		return usuarioRepository.save(usuario);
	}
	
	private Usuario convertUsuarioFromStringJson(String usuarioJson) {
		Usuario usuario = new Usuario();
		
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			usuario = objectMapper.readValue(usuarioJson, Usuario.class);
		} catch (IOException err) {
			System.out.printf("Ocorreu um erro ao tentar converter a string json para um instância da entidade Usuario", err.toString());
		}
		
		return usuario;
	}
	
}
