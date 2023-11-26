package br.com.mfsdevsystem.model;

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
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="venda_loja_virtual")
@SequenceGenerator(name = "sequence_venda_loja_virtual", sequenceName = "sequence_venda_loja_virtual", allocationSize = 1, initialValue = 1)
public class VendaLojaVirtual implements Serializable {

    private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_venda_loja_virtual")
	private Long id;
		
	@Column(name="observacao", nullable=false, length=200)
	private String observacao;
	
	@Column(name="valor_Total", scale=2, precision=12)
	private BigDecimal valorTotal;
	
	@Column(name="valor_desconto", scale=2, precision=10)
	private BigDecimal valorDesconto;
	
	@Column(name="perc_icms", scale=2, precision=5)
	private BigDecimal percIcms;
	
	@Column(name="valor_icms", scale=2, precision=10)
	private BigDecimal valorIcms;
	
	@Column(name="valor_frete", scale=2, precision=10)
	private BigDecimal valorFrete;
	
	private Byte diaEntrega;
	
	
	@Temporal(TemporalType.DATE)
	private Date dataVenda;
	
	@Temporal(TemporalType.DATE)
	private Date dataEmissao;
	
	@Temporal(TemporalType.DATE)
	private Date dataEntrega;
	
	@Temporal(TemporalType.DATE)
	private Date dataPrevEntrega;
	
	@ManyToOne(targetEntity = Pessoa.class)
	@JoinColumn(name = "pessoa_id", nullable=false, 
	     foreignKey=@ForeignKey(value=ConstraintMode.CONSTRAINT, name="vendaLojavirtual_pessoa_fk"))
	private Pessoa pessoa;
	
	@ManyToOne(targetEntity = Endereco.class)
	@JoinColumn(name = "endereco_entrega_id", nullable=false, 
	     foreignKey=@ForeignKey(value=ConstraintMode.CONSTRAINT, name="endereco_entrega_fk"))
	private Endereco enderecoEntrega;
	
	@ManyToOne(targetEntity = Endereco.class)
	@JoinColumn(name = "endereco_cobranca_id", nullable=false, 
	     foreignKey=@ForeignKey(value=ConstraintMode.CONSTRAINT, name="endereco_cobranca_fk"))
	private Endereco enderecoCobranca;
	
	@ManyToOne(targetEntity = FormasPagamento.class)
	@JoinColumn(name = "forma_pagamento_id", nullable=false, 
	     foreignKey=@ForeignKey(value=ConstraintMode.CONSTRAINT, name="formas_pagamento_fk"))
	private FormasPagamento formaPagamento;
	
	@ManyToOne(targetEntity = ContasReceber.class)
	@JoinColumn(name = "contas_receber_id", nullable=false, 
	     foreignKey=@ForeignKey(value=ConstraintMode.CONSTRAINT, name="vendaLojaVirtual_ct_receber_fk"))
	private ContasReceber contasReceber;
	
	@OneToOne(targetEntity = NotaFiscalSaida.class)
	@JoinColumn(name = "nfs_id", nullable=false, 
	     foreignKey=@ForeignKey(value=ConstraintMode.CONSTRAINT, name="nfs_fk"))
	private NotaFiscalSaida notaFiscalVenda;

	@ManyToOne(targetEntity = CupomDesconto.class)
	@JoinColumn(name = "cupom_desconto_id", nullable=false, 
	     foreignKey=@ForeignKey(value=ConstraintMode.CONSTRAINT, name="cupom_desconto_fk"))
	private CupomDesconto cupomDesconto;

	public VendaLojaVirtual(Long id, String observacao, BigDecimal valorTotal, BigDecimal valorDesconto,
			BigDecimal percIcms, BigDecimal valorIcms, BigDecimal valorFrete, Byte diaEntrega, Date dataVenda,
			Date dataEmissao, Date dataEntrega, Date dataPrevEntrega, Pessoa pessoa, Endereco enderecoEntrega,
			Endereco enderecoCobranca, FormasPagamento formaPagamento, ContasReceber contasReceber,
			NotaFiscalSaida notaFiscalVenda, CupomDesconto cupomDesconto) {
		this.id = id;
		this.observacao = observacao;
		this.valorTotal = valorTotal;
		this.valorDesconto = valorDesconto;
		this.percIcms = percIcms;
		this.valorIcms = valorIcms;
		this.valorFrete = valorFrete;
		this.diaEntrega = diaEntrega;
		this.dataVenda = dataVenda;
		this.dataEmissao = dataEmissao;
		this.dataEntrega = dataEntrega;
		this.dataPrevEntrega = dataPrevEntrega;
		this.pessoa = pessoa;
		this.enderecoEntrega = enderecoEntrega;
		this.enderecoCobranca = enderecoCobranca;
		this.formaPagamento = formaPagamento;
		this.contasReceber = contasReceber;
		this.notaFiscalVenda = notaFiscalVenda;
		this.cupomDesconto = cupomDesconto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		valorDesconto = valorDesconto;
	}

	public BigDecimal getPercIcms() {
		return percIcms;
	}

	public void setPercIcms(BigDecimal percIcms) {
		this.percIcms = percIcms;
	}

	public BigDecimal getValorIcms() {
		return valorIcms;
	}

	public void setValorIcms(BigDecimal valorIcms) {
		valorIcms = valorIcms;
	}

	public BigDecimal getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(BigDecimal valorFrete) {
		this.valorFrete = valorFrete;
	}

	public Byte getDiaEntrega() {
		return diaEntrega;
	}

	public void setDiaEntrega(Byte diaEntrega) {
		this.diaEntrega = diaEntrega;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Date getDataPrevEntrega() {
		return dataPrevEntrega;
	}

	public void setDataPrevEntrega(Date dataPrevEntrega) {
		this.dataPrevEntrega = dataPrevEntrega;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Endereco getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(Endereco enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	public Endereco getEnderecoCobranca() {
		return enderecoCobranca;
	}

	public void setEnderecoCobranca(Endereco enderecoCobranca) {
		this.enderecoCobranca = enderecoCobranca;
	}

	public FormasPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormasPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public ContasReceber getContasReceber() {
		return contasReceber;
	}

	public void setContasReceber(ContasReceber contasReceber) {
		this.contasReceber = contasReceber;
	}

	public NotaFiscalSaida getNotaFiscalVenda() {
		return notaFiscalVenda;
	}

	public void setNotaFiscalVenda(NotaFiscalSaida notaFiscalVenda) {
		this.notaFiscalVenda = notaFiscalVenda;
	}

	public CupomDesconto getCupomDesconto() {
		return cupomDesconto;
	}

	public void setCupomDesconto(CupomDesconto cupomDesconto) {
		this.cupomDesconto = cupomDesconto;
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
		VendaLojaVirtual other = (VendaLojaVirtual) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
