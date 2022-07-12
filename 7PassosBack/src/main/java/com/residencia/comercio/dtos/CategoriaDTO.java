package com.residencia.comercio.dtos;

public class CategoriaDTO {
	private Integer idCategoria;
	private String nomeCategoria;
	private String nomeImagem;

	public CategoriaDTO() {
		super();
	}

	public CategoriaDTO(Integer idCategoria, String nomeCategoria, String nomeImagem) {
		super();
		this.idCategoria = idCategoria;
		this.nomeCategoria = nomeCategoria;
		this.nomeImagem = nomeImagem;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public String getNomeImagem() {
		return nomeImagem;
	}

	public void setNomeImagem(String nomeImagem) {
		this.nomeImagem = nomeImagem;
	}

	@Override
	public String toString() {
		return "CategoriaDTO [idCategoria=" + idCategoria + ", nomeCategoria=" + nomeCategoria + ", nomeImagem="
				+ nomeImagem + "]";
	}

}
