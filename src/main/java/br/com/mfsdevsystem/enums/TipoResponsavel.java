package br.com.mfsdevsystem.enums;

public enum TipoResponsavel {
	Pai("Pai"),
	Mae("Mãe"),
	Outro("Outro");
	
	private String stringEnum;
	private TipoResponsavel(String stringEnum) {
		this.stringEnum = stringEnum;
	}
	public String getStringEnum() {
		return stringEnum;
	}
	public void setStringEnum(String stringEnum) {
		this.stringEnum = stringEnum;
	}
	
}
