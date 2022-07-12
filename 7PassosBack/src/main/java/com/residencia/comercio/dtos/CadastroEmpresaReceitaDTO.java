package com.residencia.comercio.dtos;

import java.util.List;

public class CadastroEmpresaReceitaDTO {

	private String situacao;
	private String tipo;
	private String nome;
	private String porte;
	private String abertura;
	private String data_situacao;
	private String motivo_situacao;
	private String telefone;
	private String email;
	private String natureza_juridica;
	private String cnpj;
	private String ultima_atualizacao;
	private String status;
	private String fantasia;
	private String logradouro;
	private String numero;
	private String complemento;
	private String cep;
	private String bairro;
	private String municipio;
	private String uf;

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	public String getAbertura() {
		return abertura;
	}

	public void setAbertura(String abertura) {
		this.abertura = abertura;
	}

	public String getData_situacao() {
		return data_situacao;
	}

	public void setData_situacao(String data_situacao) {
		this.data_situacao = data_situacao;
	}

	public String getMotivo_situacao() {
		return motivo_situacao;
	}

	public void setMotivo_situacao(String motivo_situacao) {
		this.motivo_situacao = motivo_situacao;
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

	public String getNatureza_juridica() {
		return natureza_juridica;
	}

	public void setNatureza_juridica(String natureza_juridica) {
		this.natureza_juridica = natureza_juridica;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getUltima_atualizacao() {
		return ultima_atualizacao;
	}

	public void setUltima_atualizacao(String ultima_atualizacao) {
		this.ultima_atualizacao = ultima_atualizacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
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

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@Override
	public String toString() {
		return "CadastroEmpresaReceitaDTO [situacao=" + situacao + ", tipo=" + tipo + ", nome=" + nome + ", porte="
				+ porte + ", abertura=" + abertura + ", data_situacao=" + data_situacao + ", motivo_situacao="
				+ motivo_situacao + ", telefone=" + telefone + ", email=" + email + ", natureza_juridica="
				+ natureza_juridica + ", cnpj=" + cnpj + ", ultima_atualizacao=" + ultima_atualizacao + ", status="
				+ status + ", fantasia=" + fantasia + ", logradouro=" + logradouro + ", numero=" + numero
				+ ", complemento=" + complemento + ", cep=" + cep + ", bairro=" + bairro + ", municipio=" + municipio
				+ ", uf=" + uf + "]";
	}

}
