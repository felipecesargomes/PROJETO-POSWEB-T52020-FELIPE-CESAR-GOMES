package dev.fujioka.felipe.projetoJava.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import dev.fujioka.felipe.projetoJava.Tratamentos;

/**
 * @author felipecesar
 *
 */

@MappedSuperclass
@SuppressWarnings("serial")
public abstract class PessoaAbstractEntity<ID extends Serializable> extends Tratamentos implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private ID id;
	@Size(min = 3, max = 250, message = "O nome deve conter no minimo 3 e no máximo 250 caracteres.")
	@NotBlank(message = "O nome da Pessoa é obrigatório")
	@Column(name = "nome")
	private String nome;
	@Size(min = 3, max = 250, message = "O sobrenome deve conter no minimo 3 e no máximo 250 caracteres.")
	@NotBlank(message = "O sobrenome da Pessoa é obrigatório")
	@Column(name = "sobrenome")
	private String sobrenome;
	@Size(min = 3, max = 14, message = "Verifique o RG novamente")
	@NotBlank
	@Column(name = "rg", unique = true)
	private String rg;
	@Size(max = 14, message = "O CPF deve conter no máximo 11 caracteres.")
	@NotBlank
	@CPF(message = "CPF Inválido")
	@Column(name = "cpf", unique = true)
	private String cpf;
	@Transient
	private int idade;

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = removerAcentos(nome);
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = removerAcentos(sobrenome);
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = removerPontos(cpf);
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	

}