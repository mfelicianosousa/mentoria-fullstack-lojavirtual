package br.com.mfsdevsystem.model;

import java.io.Serializable;

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

@Entity
@Table(name="item_venda_loja_virtual")
@SequenceGenerator(name = "sequence_item_venda_loja_virtual", sequenceName = "sequence_item_venda_loja_virtual", allocationSize = 1, initialValue = 1)
public class ItemVendaLojaVirtual implements Serializable {

    private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_item_venda_loja_virtual")
	private Long id;
    
	private Double quantidade;
	
	@ManyToOne(targetEntity = Produto.class)
	@JoinColumn(name = "produto_id", nullable=false, 
	    foreignKey=@ForeignKey(value=ConstraintMode.CONSTRAINT, name="item_venda_loja_produto_fk"))
	private Produto produto;
	
	@ManyToOne(targetEntity = VendaLojaVirtual.class)
	@JoinColumn(name = "venda_loja_virtual_id", nullable=false, 
	     foreignKey=@ForeignKey(value=ConstraintMode.CONSTRAINT, name="item_venda_Loja_virtual_fk"))
	private VendaLojaVirtual vendaLojaVirtual;
	
	public ItemVendaLojaVirtual() {}
	
	
}
