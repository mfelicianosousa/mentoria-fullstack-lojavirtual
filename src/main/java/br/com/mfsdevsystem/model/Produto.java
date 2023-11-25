package br.com.mfsdevsystem.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="produto")
@SequenceGenerator(name = "sequence_produto", sequenceName = "sequence_produto", allocationSize = 1, initialValue = 1)
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_produto")
	private Long id;
	
	private String nome;
	private String tipoUnidade;
	
	@Column(columnDefinition = "text", length=4000)
	private String descricao;
    
	private String nota_item_produto; // associar
	
    private Double peso;
    private Double largura;
    private Double altura;
    private Double profundidade;
    
    @Column(name="valor_venda", scale=2, precision=12) 
    private BigDecimal valorVenda = BigDecimal.ZERO;
    private Integer qtdeEstoque;
    private Integer qtdeAlertaEstoque;
    private Boolean alertaQtdeEstoque = Boolean.FALSE;
    private String LinkYoutube;
    private Integer qtdeClick = 0;
    private Boolean ativo = Boolean.TRUE;
    
    public Produto() {
    	
    }

	public Produto(Long id, String nome, String tipoUnidade, String descricao, String nota_item_produto, Double peso,
			Double largura, Double altura, Double profundidade, BigDecimal valorVenda, Integer qtdeEstoque,
			Integer qtdeAlertaEstoque, Boolean alertaQtdeEstoque, String linkYoutube, Integer qtdeClick,
			Boolean ativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipoUnidade = tipoUnidade;
		this.descricao = descricao;
		this.nota_item_produto = nota_item_produto;
		this.peso = peso;
		this.largura = largura;
		this.altura = altura;
		this.profundidade = profundidade;
		this.valorVenda = valorVenda;
		this.qtdeEstoque = qtdeEstoque;
		this.qtdeAlertaEstoque = qtdeAlertaEstoque;
		this.alertaQtdeEstoque = alertaQtdeEstoque;
		LinkYoutube = linkYoutube;
		this.qtdeClick = qtdeClick;
		this.ativo = ativo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoUnidade() {
		return tipoUnidade;
	}

	public void setTipoUnidade(String tipoUnidade) {
		this.tipoUnidade = tipoUnidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNota_item_produto() {
		return nota_item_produto;
	}

	public void setNota_item_produto(String nota_item_produto) {
		this.nota_item_produto = nota_item_produto;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getLargura() {
		return largura;
	}

	public void setLargura(Double largura) {
		this.largura = largura;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getProfundidade() {
		return profundidade;
	}

	public void setProfundidade(Double profundidade) {
		this.profundidade = profundidade;
	}

	public BigDecimal getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
	}

	public Integer getQtdeEstoque() {
		return qtdeEstoque;
	}

	public void setQtdeEstoque(Integer qtdeEstoque) {
		this.qtdeEstoque = qtdeEstoque;
	}

	public Integer getQtdeAlertaEstoque() {
		return qtdeAlertaEstoque;
	}

	public void setQtdeAlertaEstoque(Integer qtdeAlertaEstoque) {
		this.qtdeAlertaEstoque = qtdeAlertaEstoque;
	}

	public Boolean getAlertaQtdeEstoque() {
		return alertaQtdeEstoque;
	}

	public void setAlertaQtdeEstoque(Boolean alertaQtdeEstoque) {
		this.alertaQtdeEstoque = alertaQtdeEstoque;
	}

	public String getLinkYoutube() {
		return LinkYoutube;
	}

	public void setLinkYoutube(String linkYoutube) {
		LinkYoutube = linkYoutube;
	}

	public Integer getQtdeClick() {
		return qtdeClick;
	}

	public void setQtdeClick(Integer qtdeClick) {
		this.qtdeClick = qtdeClick;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}
    
 
}
