package dev.fujioka.felipe.projetoJava.domain;

import javax.persistence.*;
import javax.validation.constraints.*;

import dev.fujioka.felipe.projetoJava.Tratamentos;

/**
 * @author felipecesar
 *
 */

@Entity
@Table(name = "t_plano_saude")
public class PlanoSaude extends Tratamentos {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@Column(name = "nome")
	@Size(min = 3, max = 50, message = "Verifique o nome do plano de Saúde.")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = removerAcentos(nome);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
