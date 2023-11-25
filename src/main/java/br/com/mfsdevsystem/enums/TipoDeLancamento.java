package br.com.mfsdevsystem.enums;

public enum TipoDeLancamento {
	ENTRADA("E"),
	SAÍDA("S");

	private String tipoDelancamento_enum;

	private TipoDeLancamento(String tipoDelancamento_enum) {
		this.tipoDelancamento_enum = tipoDelancamento_enum;
	}
	
	public String getTipoDelancamento_enum() {
		return tipoDelancamento_enum;
	}

	public void setTipoDelancamento_enum(String tipoDelancamento_enum) {
		this.tipoDelancamento_enum = tipoDelancamento_enum;
	}
}
