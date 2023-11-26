package br.com.mfsdevsystem.model;

import java.io.Serializable;
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
@Table(name="avaliacao_produto")
@SequenceGenerator(name = "sequence_avaliacao_produto", sequenceName = "sequence_avaliacao_produto", allocationSize = 1, initialValue = 1)
public class AvaliacaoProduto  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_avaliacao_produto")
	private Long id;
	
	private Integer nota;
	
	@Column(name="observacao", nullable=false, length=200)
	private String observacao;
	
	@Temporal(TemporalType.DATE)
	private Date dataAvaliacao;
	
	@ManyToOne(targetEntity = Pessoa.class)
	@JoinColumn(name = "pessoa_id", nullable=false, 
	     foreignKey=@ForeignKey(value=ConstraintMode.CONSTRAINT, name="avaliacao_produto_pessoa_fk"))
	private Pessoa pessoa;

	@ManyToOne(targetEntity = Produto.class)
	@JoinColumn(name = "produto_id", nullable=false, 
	    foreignKey=@ForeignKey(value=ConstraintMode.CONSTRAINT, name="avaliacao_produto_fk"))
	private Produto produto;
	
	public AvaliacaoProduto() {}

	public AvaliacaoProduto(Long id, Integer nota, String observacao, Date dataAvaliacao, Pessoa pessoa,
			Produto produto) {
		this.id = id;
		this.nota = nota;
		this.observacao = observacao;
		this.dataAvaliacao = dataAvaliacao;
		this.pessoa = pessoa;
		this.produto = produto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(Date dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
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
		AvaliacaoProduto other = (AvaliacaoProduto) obj;
		return Objects.equals(id, other.id);
	}

	
	
}
