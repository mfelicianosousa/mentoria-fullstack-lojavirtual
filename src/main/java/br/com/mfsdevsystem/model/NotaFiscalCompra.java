package br.com.mfsdevsystem.model;
/*************************************
 *  Nota Fiscal de Entrada (Compras)
 *  Author: Marcelino
 * 
 **/
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="nfe")
@SequenceGenerator(name = "sequence_nfe", sequenceName = "sequence_nfe", allocationSize = 1, initialValue = 1)
public class NotaFiscalCompra implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_nfe")
	private Long id;
	
	@Column(name="numero", nullable=false, length=10)
	private String numero;
	
	@Column(name="serie", nullable=false, length=5)
	private String serie;
	
	@Column(name="observacao", nullable=false, length=200)
	private String observacao;
	
	@Column(name="valor_Total", scale=2, precision=12)
	private BigDecimal valorTotal;
	
	@Column(name="valor_desconto", scale=2, precision=12)
	private BigDecimal ValorDesconto;
	
	@Column(name="perc_icms", scale=2, precision=5)
	private BigDecimal percIcms;
	
	@Column(name="valor_icms", scale=2, precision=12)
	private BigDecimal ValorIcms;
	
	@Temporal(TemporalType.DATE)
	private Date dataCompra;
	
	@Temporal(TemporalType.DATE)
	private Date dataEmissao;
	
	@Temporal(TemporalType.DATE)
	private Date dataVencimento;
	
	@ManyToOne(targetEntity = Pessoa.class)
	@JoinColumn(name = "pessoa_id", nullable=false, 
	     foreignKey=@ForeignKey(value=ConstraintMode.CONSTRAINT, name="nfe_pessoa_fk"))
	private Pessoa pessoa;
	
	
	@ManyToOne(targetEntity = ContasPagar.class)
	@JoinColumn(name = "contas_pagar_id", nullable=false, 
	     foreignKey=@ForeignKey(value=ConstraintMode.CONSTRAINT, name="nfe_ct_pagar_fk"))
	private ContasPagar contasPagar;

	public NotaFiscalCompra() {
		
	}
	
	public NotaFiscalCompra(Long id, String numero, String serie, String observacao, BigDecimal valorTotal,
			BigDecimal valorDesconto, BigDecimal percIcms, BigDecimal valorIcms, Date dataCompra, Date dataEmissao,
			Date dataVencimento, Pessoa pessoa, ContasPagar contasPagar) {
		this.id = id;
		this.numero = numero;
		this.serie = serie;
		this.observacao = observacao;
		this.valorTotal = valorTotal;
		ValorDesconto = valorDesconto;
		this.percIcms = percIcms;
		ValorIcms = valorIcms;
		this.dataCompra = dataCompra;
		this.dataEmissao = dataEmissao;
		this.dataVencimento = dataVencimento;
		this.pessoa = pessoa;
		this.contasPagar = contasPagar;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public BigDecimal getValorDesconto() {
		return ValorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		ValorDesconto = valorDesconto;
	}

	public BigDecimal getPercIcms() {
		return percIcms;
	}

	public void setPercIcms(BigDecimal percIcms) {
		this.percIcms = percIcms;
	}

	public BigDecimal getValorIcms() {
		return ValorIcms;
	}

	public void setValorIcms(BigDecimal valorIcms) {
		ValorIcms = valorIcms;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public ContasPagar getContasPagar() {
		return contasPagar;
	}

	public void setContasPagar(ContasPagar contasPagar) {
		this.contasPagar = contasPagar;
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
		NotaFiscalCompra other = (NotaFiscalCompra) obj;
		return Objects.equals(id, other.id);
	}

	
}
