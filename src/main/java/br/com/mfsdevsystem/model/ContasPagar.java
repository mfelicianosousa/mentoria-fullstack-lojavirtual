package br.com.mfsdevsystem.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import br.com.mfsdevsystem.enums.StatusContasPagar;
import br.com.mfsdevsystem.enums.StatusDeLancamento;
import br.com.mfsdevsystem.enums.TipoDeLancamento;
import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name="contas_pagar")
@SequenceGenerator(name = "sequence_contas_pagar", sequenceName = "sequence_contas_pagar", allocationSize = 1, initialValue = 1)
public class ContasPagar implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_contas_pagar")
	private Long id ;
	
	//@NotNull(message="Informe o tipo de lançamento")
	@Enumerated(EnumType.STRING)
	@Column(name="tipo_lancamento", nullable=false, length=1)
	private TipoDeLancamento tipoLancamento=TipoDeLancamento.SAÍDA ;//ENTRADA ou SAIDA
	
	//@NotNull(message="Informe a situação de lançamento")
	@Enumerated(EnumType.STRING)
	@Column(name = "status_lancamento", length=9)
	private StatusDeLancamento statusLancamento=StatusDeLancamento.Pendente; //Pendente,Pago,Cancelado;
	
	@Column(name="numero", nullable=false, length=50)
	private String historico;
	
	@Enumerated(EnumType.STRING)
	private StatusContasPagar status;
	
	@Temporal(TemporalType.DATE)
	private Date dataEmissao;
	
	@Temporal(TemporalType.DATE)
	private Date dataVencimento;
	
	@Temporal(TemporalType.DATE)
	private Date dataPagamento;

	@Column(name="valor_Total", scale=2, precision=12) 
	private BigDecimal valorTotal;
	
	@Column(name="valor_desconto", scale=2, precision=12) 
	private BigDecimal valorDesconto;
	
	@Column(name="valor_acrescimo",scale=2,precision=10)  
    private BigDecimal valorAcrescimo; //Valor de Acrescimo emcima do valor lançado
	
	@Column(name="valor_pago", scale=2, precision=12)  
    private BigDecimal valorPago;
	
	
	@ManyToOne(targetEntity = Pessoa.class)
	@JoinColumn(name = "pessoa_id", nullable=false, 
	     foreignKey=@ForeignKey(value=ConstraintMode.CONSTRAINT, name="pessoa_fk"))
	private Pessoa pessoa;
	
	@ManyToOne(targetEntity = Pessoa.class)
	@JoinColumn(name = "fornecedor_id", nullable=false, 
	     foreignKey=@ForeignKey(value=ConstraintMode.CONSTRAINT, name="fornecedor_fk"))
	private Pessoa fornecedor;
	
	public ContasPagar() {
		
	}
	
	public ContasPagar(Long id, String historico, StatusContasPagar status, Date dataEmissao, Date dataVencimento,
			Date dataPagamento, BigDecimal valorTotal, BigDecimal valorDesconto) {
		this.id = id;
		this.historico = historico;
		this.status = status;
		this.dataEmissao = dataEmissao;
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
		this.valorTotal = valorTotal;
		this.valorDesconto = valorDesconto;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoDeLancamento getTipoLancamento() {
		return tipoLancamento;
	}

	public void setTipoLancamento(TipoDeLancamento tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}

	public StatusDeLancamento getStatusLancamento() {
		return statusLancamento;
	}

	public void setStatusLancamento(StatusDeLancamento statusLancamento) {
		this.statusLancamento = statusLancamento;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public StatusContasPagar getStatus() {
		return status;
	}

	public void setStatus(StatusContasPagar status) {
		this.status = status;
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

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
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
		this.valorDesconto = valorDesconto;
	}

	public BigDecimal getValorAcrescimo() {
		return valorAcrescimo;
	}

	public void setValorAcrescimo(BigDecimal valorAcrescimo) {
		this.valorAcrescimo = valorAcrescimo;
	}

	public BigDecimal getValorPago() {
		return valorPago;
	}

	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public Pessoa getFornecedor() {
		return fornecedor;
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
		ContasPagar other = (ContasPagar) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
}
