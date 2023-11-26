package br.com.mfsdevsystem.model;

import java.io.Serializable;
import java.util.Objects;

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
@Table(name="nfe_item_produto")
@SequenceGenerator(name = "sequence_nfe_item_produto", sequenceName = "sequence_nfe_item_produto", allocationSize = 1, initialValue = 1)
public class NotaFiscalCompraItemProduto  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_nfe_item_produto")
	private Long id;

	private Double quantidade;
	
	@ManyToOne(targetEntity = Produto.class)
	@JoinColumn(name = "produto_id", nullable=false, 
	    foreignKey=@ForeignKey(value=ConstraintMode.CONSTRAINT, name="nfe_item_produto_fk"))
	private Produto produto;

	@ManyToOne(targetEntity = Produto.class)
	@JoinColumn(name = "nota_fiscal_compra_id", nullable=false, 
	    foreignKey=@ForeignKey(value=ConstraintMode.CONSTRAINT, name="nfe_fk"))
	private NotaFiscalCompra notafiscalcompra;
	
	public NotaFiscalCompraItemProduto () {
		
	}
	
	

	public NotaFiscalCompraItemProduto(Long id, Double quantidade, Produto produto, NotaFiscalCompra notafiscalcompra) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.produto = produto;
		this.notafiscalcompra = notafiscalcompra;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}


	public NotaFiscalCompra getNotafiscalcompra() {
		return notafiscalcompra;
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
		NotaFiscalCompraItemProduto other = (NotaFiscalCompraItemProduto) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
