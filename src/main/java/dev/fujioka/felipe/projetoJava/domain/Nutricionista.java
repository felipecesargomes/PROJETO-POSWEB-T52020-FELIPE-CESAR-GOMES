package dev.fujioka.felipe.projetoJava.domain;

import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.*;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
import dev.fujioka.felipe.projetoJava.enums.Turno;

/**
 * @author felipecesar
 *
 */

@Entity
@Table(name = "t_nutricionistas")
public class Nutricionista extends PessoaAbstractEntity<Long> {

	@Column(name = "crn")
	@Size(min = 3,max = 30,message = "O CRN deve conter pelo menos 3 caracteres")
	private String crn;
	@Column(name = "turno_atendimento")
	@Enumerated(EnumType.STRING)
	private Turno turnoAtendimento;
	@NotNull
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private BigDecimal salario;

	public String getCrn() {
		return crn;
	}

	public void setCrn(String crn) {
		this.crn = crn;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Turno getTurnoAtendimento() {
		return turnoAtendimento;
	}

	public void setTurnoAtendimento(Turno turnoAtendimento) {
		this.turnoAtendimento = turnoAtendimento;
	}

}
