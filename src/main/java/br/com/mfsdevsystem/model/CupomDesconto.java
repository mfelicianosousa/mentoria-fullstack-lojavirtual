package br.com.mfsdevsystem.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="cupom_desconto")
@SequenceGenerator(name = "sequence_cupom_desconto", sequenceName = "sequence_cupom_desconto", allocationSize = 1, initialValue = 1)
public class CupomDesconto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_cupom_desconto")
	private Long id;
	
	private String codigo_cupom;
	
	@Column(name="valor_real_desconto", scale=2, precision=12) 
	private BigDecimal valorRealDesconto;
	
	@Column(name="valor_perc_desconto", scale=2, precision=6) 
	private BigDecimal valorPercDesconto;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_validade", nullable = false)
	private Date dataValidade;

	public CupomDesconto() {
		
	}

	public CupomDesconto(Long id, String codigo_cupom, BigDecimal valorRealDesconto, BigDecimal valorPercDesconto,
			Date dataValidade) {
		this.id = id;
		this.codigo_cupom = codigo_cupom;
		this.valorRealDesconto = valorRealDesconto;
		this.valorPercDesconto = valorPercDesconto;
		this.dataValidade = dataValidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo_cupom() {
		return codigo_cupom;
	}

	public void setCodigo_cupom(String codigo_cupom) {
		this.codigo_cupom = codigo_cupom;
	}

	public BigDecimal getValorRealDesconto() {
		return valorRealDesconto;
	}

	public void setValorRealDesconto(BigDecimal valorRealDesconto) {
		this.valorRealDesconto = valorRealDesconto;
	}

	public BigDecimal getValorPercDesconto() {
		return valorPercDesconto;
	}

	public void setValorPercDesconto(BigDecimal valorPercDesconto) {
		this.valorPercDesconto = valorPercDesconto;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
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
		CupomDesconto other = (CupomDesconto) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
