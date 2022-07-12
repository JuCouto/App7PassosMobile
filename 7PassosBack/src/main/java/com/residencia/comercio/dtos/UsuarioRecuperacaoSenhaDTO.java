package com.residencia.comercio.dtos;

public class UsuarioRecuperacaoSenhaDTO {
	private Integer idUsuario;
	private String nomeUsuario;
	private String email;
	private String senha;

	public UsuarioRecuperacaoSenhaDTO(Integer idUsuario, String nomeUsuario, String email, String senha) {
		super();
		this.idUsuario = idUsuario;
		this.nomeUsuario = nomeUsuario;
		this.email = email;
		this.senha = senha;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
