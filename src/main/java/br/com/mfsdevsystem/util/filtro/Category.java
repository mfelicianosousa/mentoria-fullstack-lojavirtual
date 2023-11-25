package br.com.mfsdevsystem.util.filtro;
/*
 * 
 * 
 * 
 * */
import java.io.Serializable;

import br.com.mfsdevsystem.enums.TipoDeLancamento;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categoria")
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	//@NotNull(message="Informe o nome")
	@Column(name="nome")
	private String nome;
	//@NotNull(message="Informe o tipo")
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_lancamento")
	private TipoDeLancamento tipoDeLancamento;


	/*############# CONSTRUTOR ###################################*/
	public Category() {

	}
	public Category(String nome, TipoDeLancamento tipoDeLancamento) {
		this.nome = nome;
		this.tipoDeLancamento = tipoDeLancamento;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public TipoDeLancamento getTipoDeLancamento() {
		return tipoDeLancamento;
	}
	public void setTipoDeLancamento(TipoDeLancamento tipoDeLancamento) {
		this.tipoDeLancamento = tipoDeLancamento;
	}
	/*################################################*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
