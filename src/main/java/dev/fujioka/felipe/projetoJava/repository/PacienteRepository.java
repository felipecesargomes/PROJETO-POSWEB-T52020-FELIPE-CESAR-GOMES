package dev.fujioka.felipe.projetoJava.repository;
import dev.fujioka.felipe.projetoJava.domain.Paciente;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/**
 * @author felipecesar
 *
 */

@Repository
public interface PacienteRepository
     extends JpaRepository<Paciente, Long> {
	
	@Query(value = "SELECT * FROM T_PACIENTES WHERE NOME LIKE %?1% OR SOBRENOME LIKE %?1%", nativeQuery = true)
	public List<Paciente> listaPacientePorNome(String nome);
	
	@Query(value = "SELECT * FROM T_PACIENTES WHERE RG LIKE %?1%", nativeQuery = true)
	public List<Paciente> listaPacientePorRg(String rg);
	
	@Query(value = "SELECT * FROM T_PACIENTES WHERE CPF LIKE %?1%", nativeQuery = true)
	public List<Paciente> listaPacientePorCpf(String cpf);
	
	@Query(value = "SELECT * FROM T_PACIENTES WHERE DATA_NASCIMENTO >= (:dataInicial) AND DATA_NASCIMENTO <= (:dataFinal)", nativeQuery = true)
	public List<Paciente> listaPacientePorDataNascimento(Date dataInicial, Date dataFinal);
	
	@Query(value = "SELECT * FROM T_PACIENTES WHERE PLANO_SAUDE_ID = (:id)", nativeQuery = true)
	public List<Paciente> listaPacientePorPlano(long id);
	
	@Query(value = "SELECT * FROM T_PACIENTES WHERE SEXO = (:sexo)", nativeQuery = true)
	public List<Paciente> listaPacientePorSexo(String sexo);
	
	@Query(value = "SELECT count(1) FROM T_PACIENTES", nativeQuery = true)
	public Integer listaQtdPacientes();
}

