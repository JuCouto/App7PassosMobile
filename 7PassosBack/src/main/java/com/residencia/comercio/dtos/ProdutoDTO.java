package com.residencia.comercio.dtos;

import java.math.BigDecimal;

public class ProdutoDTO {
	private Integer idProduto;
	private String sku;
	private String nomeProduto;
	private String descricaoProduto;
	private String imagemProduto;
	private BigDecimal precoProduto;
	private String nomeFornecedor;
	private Integer idFornecedor;
	private String nomeCategoria;
	private Integer idCategoria;

	public ProdutoDTO(Integer idProduto, String sku, String nomeProduto, String descricaoProduto, String imagemProduto,
			BigDecimal precoProduto, String nomeFornecedor, Integer idFornecedor, String nomeCategoria,
			Integer idCategoria) {
		super();
		this.idProduto = idProduto;
		this.sku = sku;
		this.nomeProduto = nomeProduto;
		this.descricaoProduto = descricaoProduto;
		this.imagemProduto = imagemProduto;
		this.precoProduto = precoProduto;
		this.nomeFornecedor = nomeFornecedor;
		this.idFornecedor = idFornecedor;
		this.nomeCategoria = nomeCategoria;
		this.idCategoria = idCategoria;
	}

	public ProdutoDTO(Integer idProduto, String sku, String nomeProduto, String descricaoProduto, String imagemProduto,
			BigDecimal precoProduto, String nomeFornecedor, String nomeCategoria) {
		super();
		this.idProduto = idProduto;
		this.sku = sku;
		this.nomeProduto = nomeProduto;
		this.descricaoProduto = descricaoProduto;
		this.imagemProduto = imagemProduto;
		this.precoProduto = precoProduto;
		this.nomeFornecedor = nomeFornecedor;
		this.nomeCategoria = nomeCategoria;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public String getImagemProduto() {
		return imagemProduto;
	}

	public void setImagemProduto(String imagemProduto) {
		this.imagemProduto = imagemProduto;
	}

	public BigDecimal getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(BigDecimal precoProduto) {
		this.precoProduto = precoProduto;
	}

	public String getNomeFornecedor() {
		return nomeFornecedor;
	}

	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}

	public Integer getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(Integer idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

}
