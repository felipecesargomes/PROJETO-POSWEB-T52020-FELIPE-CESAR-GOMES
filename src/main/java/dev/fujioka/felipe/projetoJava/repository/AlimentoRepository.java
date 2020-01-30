package dev.fujioka.felipe.projetoJava.repository;
import dev.fujioka.felipe.projetoJava.domain.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author felipecesar
 *
 */

@Repository
public interface AlimentoRepository
     extends JpaRepository<Alimento, Long> {
	
	@Query(value = "SELECT * FROM T_ALIMENTOS WHERE NOME_ALIMENTO LIKE %?1%", nativeQuery = true)
	public List<Alimento> listaPorNome(String nome);
	
}

