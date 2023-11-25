package br.com.mfsdevsystem.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name="pessoa_juridica")
@PrimaryKeyJoinColumn(name="id")
public class PessoaJuridica extends Pessoa {

	private static final long serialVersionUID = 1L;
	

	@Column(name = "cnpj", nullable = false)
	private String cnpj ;
	
	@Column(name = "insc_estadual")
	private String inscEstadual;
	
	@Column(name = "insc_municipal")
	private String inscMunicipal;
	
	@Column(name = "nome_fantasia")
	private String nomeFantasia;
	
	@Column(nullable = false)
	private String razaoSocial;
	
	@Column(name = "site")
	private String site;
	
	private String categoria;

	@Temporal(TemporalType.DATE)
	private Date dataAbertura;
	
	
	public PessoaJuridica() {
		
	}
	

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscEstadual() {
		return inscEstadual;
	}

	public void setInscEstadual(String inscEstadual) {
		this.inscEstadual = inscEstadual;
	}

	public String getInscMunicipal() {
		return inscMunicipal;
	}

	public void setInscMunicipal(String inscMunicipal) {
		this.inscMunicipal = inscMunicipal;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	

}
