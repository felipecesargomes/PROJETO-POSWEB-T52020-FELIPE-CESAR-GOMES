package dev.fujioka.felipe.projetoJava.domain;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import dev.fujioka.felipe.projetoJava.enums.Sexo;

/**
 * @author felipecesar
 *
 */

@Entity
@Table(name = "t_pacientes")
public class Paciente extends PessoaAbstractEntity<Long> {

	@Column(name = "altura")
	private Integer altura;
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	@Column(name = "peso")
	private Double peso;
	@Transient
	private String imc;
	@OneToOne
	private PlanoSaude planoSaude;
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@Transient
	private Date dataCriacao;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Column(name = "data_nascimento")
	private Date dataNascimento;

	public PlanoSaude getPlanoSaude() {
		return this.planoSaude;
	}

	public void setPlanoSaude(PlanoSaude planoSaude) {
		this.planoSaude = planoSaude;
	}

	public Integer getAltura() {
		return altura;
	}

	public void setAltura(Integer altura) {
		this.altura = altura;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getImc() {
		BigDecimal valor = new BigDecimal(((this.peso) / (this.altura * this.altura)) * 10000);
		DecimalFormat df = new DecimalFormat("#,##0.00");
		String imc = df.format(valor);
		return imc;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}