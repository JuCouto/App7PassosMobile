package com.residencia.comercio.dtos;

import java.util.Date;

public class FornecedorDTO {
	private Integer idFornecedor;

	private Integer cnpj;
	private String tipo;
	private String razaoSocial;
	private String uf;
	private String telefone;
	private String email;
	private String nomeFantasia;
	private String statusSituacao;
	private String bairro;
	private String logradouro;
	private Integer numero;
	private String complemento;
	private String cep;
	private String municipio;
	private Date dataAbertura;
	// private List<ProdutoDTO> produtoDTOList;

	public Integer getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(Integer idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public Integer getCnpj() {
		return cnpj;
	}

	public void setCnpj(Integer cnpj) {
		this.cnpj = cnpj;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getStatusSituacao() {
		return statusSituacao;
	}

	public void setStatusSituacao(String statusSituacao) {
		this.statusSituacao = statusSituacao;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	@Override
	public String toString() {
		return "FornecedorDTO [idFornecedor=" + idFornecedor + ", cnpj=" + cnpj + ", tipo=" + tipo + ", razaoSocial="
				+ razaoSocial + ", uf=" + uf + ", telefone=" + telefone + ", email=" + email + ", nomeFantasia="
				+ nomeFantasia + ", statusSituacao=" + statusSituacao + ", bairro=" + bairro + ", logradouro="
				+ logradouro + ", numero=" + numero + ", complemento=" + complemento + ", cep=" + cep + ", municipio="
				+ municipio + ", dataAbertura=" + dataAbertura + "]";
	}

}
