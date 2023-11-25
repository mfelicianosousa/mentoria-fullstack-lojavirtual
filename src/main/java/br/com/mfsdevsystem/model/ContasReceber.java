package br.com.mfsdevsystem.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import br.com.mfsdevsystem.enums.StatusContasReceber;
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
	
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private StatusContasReceber status;
	
	@Temporal(TemporalType.DATE)
	private Date dataEmissao;
	
	@Temporal(TemporalType.DATE)
	private Date dataVencimento;
	
	@Temporal(TemporalType.DATE)
	private Date dataPagamento;

	private BigDecimal valorTotal;
	private BigDecimal valorDesconto;
	
	@ManyToOne(targetEntity = Pessoa.class)
	@JoinColumn(name = "pessoa_id", nullable=false, foreignKey=@ForeignKey(value=ConstraintMode.CONSTRAINT, name="pessoa_fk"))
	private Pessoa pessoa;
	
	public ContasReceber() {
		
	}
	
	public ContasReceber(Long id, String descricao, StatusContasReceber status, Date dataEmissao, Date dataVencimento,
			Date dataPagamento, BigDecimal valorTotal, BigDecimal valorDesconto) {
		this.id = id;
		this.descricao = descricao;
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

	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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
