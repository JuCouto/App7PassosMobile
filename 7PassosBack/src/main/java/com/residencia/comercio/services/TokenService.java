package com.residencia.comercio.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.residencia.comercio.entities.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	@Value("${jwt.secret}")
	private String jwtSecret;
	
	public String generateToken(Authentication authentication) {
		Usuario usuario = (Usuario) authentication.getPrincipal();
		
		String tokenJwt = 
				Jwts.builder().setIssuer("IRS")
				.setIssuer("ComercioSeguro")
				.setSubject("Usuario")
				.claim("id", usuario.getIdUsuario())
				.claim("name", usuario.getNomeUsuario())
				.claim("email", usuario.getEmail())
				.claim("foto_perfil", usuario.getFotoPerfil())
				.setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, jwtSecret)
				.compact();
		
		return tokenJwt;
	}
	
	public String generateTokenWithUserData(Usuario usuario) {
		String tokenJwt = 
				Jwts.builder().setIssuer("IRS")
				.setIssuer("ComercioSeguro")
				.setSubject("Usuario")
				.claim("name", usuario.getNomeUsuario())
				.claim("email", usuario.getEmail())
				.claim("foto_perfil", usuario.getFotoPerfil())
				.setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, jwtSecret)
				.compact();
				
		return tokenJwt;
	}
	
	public boolean isTokenValid(String token) {
		try {
			Jwts.parser().setSigningKey(jwtSecret)
				.parseClaimsJws(token);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}
	
	public Integer extractIdFromToken(String token) {
		Claims body = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
		//Integer id = Integer.valueOf(body.getSubject());
		Integer id = Integer.valueOf(body.get("id").toString());
		return id;
	}
}
