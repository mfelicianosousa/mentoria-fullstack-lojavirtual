package br.com.mfsdevsystem.model;

import java.io.Serializable;
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

@Entity
@Table(name="status_rastreio")
@SequenceGenerator(name = "sequence_status_rastreio", sequenceName = "sequence_status_rastreio", allocationSize = 1, initialValue = 1)
public class StatusRastreio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_status_rastreio")
	private Long id ;
    
	@Column(name="observacao", nullable=false, length=50)
	private String centroDistribuicao;
	
	@Column(name="cidade", nullable=false, length=40)
	private String cidade;
	
	@Column(name="uf", nullable=false, length=2)
	private String estado;
	
	private String status;
	
	@ManyToOne(targetEntity = VendaLojaVirtual.class)
	@JoinColumn(name = "venda_loja_virtual_id", nullable=false, 
	     foreignKey=@ForeignKey(value=ConstraintMode.CONSTRAINT, name="VendaLojaVirtual_fk"))
	private VendaLojaVirtual vendaLojaVirtual;
	
	
	public StatusRastreio() {
		
	}



	public StatusRastreio(Long id, String centroDistribuicao, String cidade, String estado, String status) {
		this.id = id;
		this.centroDistribuicao = centroDistribuicao;
		this.cidade = cidade;
		this.estado = estado;
		this.status = status;
	}

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getCentroDistribuicao() {
		return centroDistribuicao;
	}



	public void setCentroDistribuicao(String centroDistribuicao) {
		this.centroDistribuicao = centroDistribuicao;
	}



	public String getCidade() {
		return cidade;
	}



	public void setCidade(String cidade) {
		this.cidade = cidade;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
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
		StatusRastreio other = (StatusRastreio) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
