package com.residencia.comercio.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "fornecedor")
@JsonIdentityInfo(scope = Fornecedor.class,generator = ObjectIdGenerators.PropertyGenerator.class,property = "idFornecedor")
public class Fornecedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_fornecedor")
	private Integer idFornecedor;

	@Column(name = "cnpj")
	@NotEmpty(message = "O número do CNPJ não pode ficar em branco.")
	private String cnpj;

	@Column(name = "tipo")
	private String tipo;

	@Column(name = "razao_social")
	private String razaoSocial;
	
	@Column(name = "uf")
	private String uf;
	
	@Column(name = "telefone")
	private String telefone;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "nome_fantasia")
	private String nomeFantasia;
	
	@Column(name = "status_situacao")
	private String statusSituacao;
	
	@Column(name = "bairro")
	private String bairro;
	
	@Column(name = "logradouro")
	private String logradouro;
	
	@Column(name = "numero")
	private Integer numero;
	
	@Column(name = "complemento")
	private String complemento;
	
	@Column(name = "cep")
	private String cep;
	
	@Column(name = "municipio")
	private String municipio;
	
	@Column(name = "data_abertura")
	private Date dataAbertura;

	@OneToMany(mappedBy = "fornecedor")
	private List<Produto> produtoList;
	
	public Integer getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(Integer idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
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

	public List<Produto> getProdutoList() {
		return produtoList;
	}

	public void setProdutoList(List<Produto> produtoList) {
		this.produtoList = produtoList;
	}
	
}