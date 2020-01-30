package dev.fujioka.felipe.projetoJava.enums;

/**
 * @author felipecesar
 *
 */

public enum Turno {

	M("M", "MANHÃ"),
	T("T", "TARDE"),
	N("N", "NOITE");

	private String sigla;
	private String descricao;

	Turno(String sigla, String descricao) {
		this.sigla = sigla;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}
