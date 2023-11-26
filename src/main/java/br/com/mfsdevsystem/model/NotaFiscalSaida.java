package br.com.mfsdevsystem.model;
/*************************************
 *  Nota Fiscal de Saída (Vendas)
 *  Author: Marcelino
 *  
 *  A nota fiscal de saída é emitida quando há uma operação de venda de produtos
 *    ou prestação de serviços. Ela é utilizada para registrar a saída de mercadorias,
 *    realização de serviços para clientes ou consumidores.
 * 
 **/
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
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="nfs")
@SequenceGenerator(name = "sequence_nfs", sequenceName = "sequence_nfs", allocationSize = 1, initialValue = 1)
public class NotaFiscalSaida implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_nfs")
	private Long id;
	
	@Column(name="numero", nullable=false, length=10)
	private String numero;
	
	@Column(name="serie", nullable=false, length=5)
	private String serie;
	
	private String tipo;
	
	@Column(columnDefinition ="text")
	private String XML;
	
	@Column(columnDefinition ="text")
	private String PDF;
	
	
	@OneToOne(targetEntity = VendaLojaVirtual.class)
	@JoinColumn(name = "venda_loja_virtual_id", nullable=false, 
	     foreignKey=@ForeignKey(value=ConstraintMode.CONSTRAINT, name="VendaLojaVirtual_fk"))
	private VendaLojaVirtual vendaLojaVirtual;
	
	
	public NotaFiscalSaida() {
	}
	
	

	public NotaFiscalSaida(Long id, String numero, String serie, String tipo, String xML, String pDF) {
		this.id = id;
		this.numero = numero;
		this.serie = serie;
		this.tipo = tipo;
		XML = xML;
		PDF = pDF;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getXML() {
		return XML;
	}

	public void setXML(String xML) {
		XML = xML;
	}

	public String getPDF() {
		return PDF;
	}

	public void setPDF(String pDF) {
		PDF = pDF;
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
		NotaFiscalSaida other = (NotaFiscalSaida) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
