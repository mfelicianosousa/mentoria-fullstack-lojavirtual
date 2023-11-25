package br.com.mfsdevsystem.util.filtro;

import br.com.mfsdevsystem.enums.TipoDeLancamento;

public class FiltroCategoria extends FiltroBaseAbstract{

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private TipoDeLancamento tipoDeLancamento=TipoDeLancamento.SAÍDA;
	
	public FiltroCategoria(String nome, TipoDeLancamento tipoDeLancamento) {
		this.nome = nome;
		this.tipoDeLancamento = tipoDeLancamento;
	}
	public FiltroCategoria() {

	}
	/*########### GETS E SETS ###################*/
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

}
