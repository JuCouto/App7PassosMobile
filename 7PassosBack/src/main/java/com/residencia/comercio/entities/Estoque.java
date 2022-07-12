package com.residencia.comercio.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "estoque")
public class Estoque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estoque")
	private Integer idEstoque;

	@Column(name = "quantidade")
	private Integer quantidade;

	@Column(name = "id_produto")
	private Integer idProduto;

	@OneToOne
	@JoinColumn(name = "id_produto", referencedColumnName = "id_produto", insertable = false, updatable = false)
	private Produto produto;

	public Integer getIdEstoque() {
		return idEstoque;
	}

	public void setIdEstoque(Integer idEstoque) {
		this.idEstoque = idEstoque;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
