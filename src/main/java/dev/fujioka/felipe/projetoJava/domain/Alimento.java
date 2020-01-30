package dev.fujioka.felipe.projetoJava.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import dev.fujioka.felipe.projetoJava.Tratamentos;

/**
 * @author felipecesar
 *
 */

@Entity
@Table(name = "t_alimentos")
public class Alimento extends Tratamentos {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@Column(name = "nome_alimento")
	@Size(min = 3, max = 100, message = "O Nome do alimento deve conter pelo menos 3 caracteres")
	private String nomeAlimento;
	private Double kcal = null;
	private Double carb;
	private Double prot;
	private Double gordTotais;
	private Double vitaminaA;
	private Double vitaminaB;
	private Double vitaminaC;
	private Double calcio;
	private Double ferro;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeAlimento() {
		return nomeAlimento;
	}

	public void setNomeAlimento(String nomeAlimento) {
		this.nomeAlimento = removerAcentos(nomeAlimento);
	}

	public Double getKcal() {
		return kcal;
	}

	public void setKcal(Double kcal) {
		this.kcal = kcal;
	}

	public Double getCarb() {
		return carb;
	}

	public void setCarb(Double carb) {
		this.carb = carb;
	}

	public Double getProt() {
		return prot;
	}

	public void setProt(Double prot) {
		this.prot = prot;
	}

	public Double getGordTotais() {
		return gordTotais;
	}

	public void setGordTotais(Double gordTotais) {
		this.gordTotais = gordTotais;
	}

	public Double getVitaminaA() {
		return vitaminaA;
	}

	public void setVitaminaA(Double vitaminaA) {
		this.vitaminaA = vitaminaA;
	}

	public Double getVitaminaB() {
		return vitaminaB;
	}

	public void setVitaminaB(Double vitaminaB) {
		this.vitaminaB = vitaminaB;
	}

	public Double getVitaminaC() {
		return vitaminaC;
	}

	public void setVitaminaC(Double vitaminaC) {
		this.vitaminaC = vitaminaC;
	}

	public Double getCalcio() {
		return calcio;
	}

	public void setCalcio(Double calcio) {
		this.calcio = calcio;
	}

	public Double getFerro() {
		return ferro;
	}

	public void setFerro(Double ferro) {
		this.ferro = ferro;
	}

	public void calculoAutoKcal() {
		if (this.kcal == null || this.kcal == 0) {
			this.kcal =  FormatacaoDecimal(((this.getCarb() * 4) + (this.getProt() * 4) + (this.getGordTotais() * 9)));	
		}
	}

}
