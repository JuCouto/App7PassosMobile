package com.residencia.comercio.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "produto")
@JsonIdentityInfo(scope = Produto.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "idProduto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	@NotBlank
	private Integer idProduto;

	@NotBlank(message = "O sku do produto não pode estar vazio.")
	@Column(name = "sku")
	private String sku;

	@Column(name = "nome_produto")
	private String nomeProduto;

	@Column(name = "imagem_produto")
	private String imagemProduto;

	@Column(name = "preco_produto")
	private BigDecimal precoProduto;

	@Column(name = "descricao_produto")
	private String descricaoProduto;

	@ManyToOne
	@JoinColumn(name = "id_fornecedor", referencedColumnName = "id_fornecedor")
	private Fornecedor fornecedor;

	@ManyToOne
	@JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
	private Categoria categoria;

	/*
	 * @OneToOne(mappedBy="produto") private Estoque estoque;
	 */

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

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}