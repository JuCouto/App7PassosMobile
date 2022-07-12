package com.residencia.comercio.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.residencia.comercio.entities.Usuario;
import com.residencia.comercio.repositories.UsuarioRepository;

@Service
public class UserDetailsServiceImplService implements UserDetailsService {
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
		Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
		
		if(usuario.isPresent()) {
			return usuario.get();
		}
		
		throw new UsernameNotFoundException("Usuário não encontrado");
	}
}
