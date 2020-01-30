package dev.fujioka.felipe.projetoJava.repository;
import dev.fujioka.felipe.projetoJava.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author felipecesar
 *
 */

@Repository
public interface NutricionistaRepository
     extends JpaRepository<Nutricionista, Long> {


	@Query(value = "SELECT * FROM T_NUTRICIONISTAS WHERE NOME LIKE %?1% OR SOBRENOME LIKE %?1%", nativeQuery = true)
	public List<Nutricionista> listaNutricionistaPorNome(String nome);
	
	@Query(value = "SELECT * FROM T_NUTRICIONISTAS WHERE RG LIKE %?1%", nativeQuery = true)
	public List<Nutricionista> listaNutricionistaPorRg(String rg);
	
	@Query(value = "SELECT * FROM T_NUTRICIONISTAS WHERE CPF LIKE %?1%", nativeQuery = true)
	public List<Nutricionista> listaNutricionistaPorCpf(String cpf);
	
	@Query(value = "SELECT * FROM T_NUTRICIONISTAS WHERE turno_atendimento = (:turno)", nativeQuery = true)
	public List<Nutricionista> listaNutricionistaPorTurno(String turno);
}