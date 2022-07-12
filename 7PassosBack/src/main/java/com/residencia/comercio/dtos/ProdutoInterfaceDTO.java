package com.residencia.comercio.dtos;

import java.math.BigDecimal;

public interface ProdutoInterfaceDTO {
	public Integer getIdProduto();
	public String getSku();
	public String getNomeProduto();
	public String getDescricaoProduto();
	public String getImagemProduto();
	public BigDecimal getPrecoProduto();
	public String getNomeFornecedor();
	public Integer getIdFornecedor();
	public String getNomeCategoria();
	public Integer getIdCategoria();
}
