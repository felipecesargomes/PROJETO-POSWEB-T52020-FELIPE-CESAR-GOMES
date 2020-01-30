package dev.fujioka.felipe.projetoJava.enums;

/**
 * @author felipecesar
 *
 */

public enum Sexo {
	
	M("M", "MASCULINO"),
	F("F", "FEMININO");
	
	private String sigla;
	private String descricao;
	
	Sexo(String sigla, String descricao) {
		this.sigla = sigla;
		this.descricao = descricao;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	
}
