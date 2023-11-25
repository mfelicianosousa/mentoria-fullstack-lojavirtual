package br.com.mfsdevsystem.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import br.com.mfsdevsystem.enums.StatusContasReceber;
import br.com.mfsdevsystem.enums.StatusDeLancamento;
import br.com.mfsdevsystem.enums.TipoDeLancamento;
import br.com.mfsdevsystem.util.DataUtil;
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
@Table(name="contas_receber")
@SequenceGenerator(name = "sequence_contas_receber", sequenceName = "sequence_contas_receber", allocationSize = 1, initialValue = 1)
public class ContasReceber implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_contas_receber")
	private Long id ;
	
	//@NotNull(message="Informe o tipo de lançamento")
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_lancamento")
	private TipoDeLancamento tipoLancamento=TipoDeLancamento.ENTRADA;
	
	//@NotNull(message="Informe a situação de lançamento")
	@Enumerated(EnumType.STRING)
	@Column(name = "status_lancamento")
	private StatusDeLancamento statusLancamento=StatusDeLancamento.Pendente; //Pendente, Pago, Cancelado;
	
	@Enumerated(EnumType.STRING)
	private StatusContasReceber status;
	
	@Temporal(TemporalType.DATE)
	private Date dataEmissao;
	
	@Temporal(TemporalType.DATE)
	private Date dataVencimento;
	
	@Temporal(TemporalType.DATE)
	private Date dataPagamento;

	@Column(name="valor_total", scale=2, precision=12) 
	private BigDecimal valorTotal; // Valor Lançado
	
	@Column(name="valor_desconto", scale=2, precision=10) 
	private BigDecimal valorDesconto;
	
	@Column(name="valor_acrescimo",scale=2,precision=10)  
    private BigDecimal valorAcrescimo; //Valor de Acrescimo em cima do valor lançado
	
	@Column(name="valor_pago", scale=2, precision=12)  
    private BigDecimal valorPago;
	
	private String historico; // Descrição do usuário
	
	  
    @Column(name = "observacao")//INFORMAÇÃO SOBRE QUANTIDADES DE LANÇAMENTOS REPETIDOS
    private String observacao;//CODIGO UNICO DE OPERAÇÃO (u-lançamento único) (r-lançamentos repetidos) + data em Timestamp

    @Column(name = "motivo_cancelamento")
    private String motivoCancelamento;//MOTIVO DO CANCELAMENTO OBRIGATÓRIO
    
    @Column(name = "motivo_estorno")
    private String motivoEstorno;//MOTIVO PARA ESTORNAR OBRIGATÓRIO
	
	@ManyToOne(targetEntity = Pessoa.class)
	@JoinColumn(name = "pessoa_id", nullable=false, foreignKey=@ForeignKey(value=ConstraintMode.CONSTRAINT, name="pessoa_fk"))
	private Pessoa pessoa;
	
	public ContasReceber() {
		
	}
	
	public ContasReceber(Long id, String historico, StatusContasReceber status, Date dataEmissao, Date dataVencimento,
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

	/**Função que valida se a data e vencimento esta em atrazo em relaçao 
	 * a data de hoje usada no datatable 
	 */
	public boolean getLancamentoVencido(){
		if(this.statusLancamento==StatusDeLancamento.Pendente){
			// Se a data de hoje for maior , return true
			if(!DataUtil.comparaDataInicialDataFinal(this.dataVencimento, new Date())){
				return true;
			}	
		}
		return false;
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

	public StatusContasReceber getStatus() {
		return status;
	}

	public void setStatus(StatusContasReceber status) {
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

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getMotivoCancelamento() {
		return motivoCancelamento;
	}

	public void setMotivoCancelamento(String motivoCancelamento) {
		this.motivoCancelamento = motivoCancelamento;
	}

	public String getMotivoEstorno() {
		return motivoEstorno;
	}

	public void setMotivoEstorno(String motivoEstorno) {
		this.motivoEstorno = motivoEstorno;
	}

	public Pessoa getPessoa() {
		return pessoa;
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
		ContasReceber other = (ContasReceber) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
}
