package dev.fujioka.felipe.projetoJava.repository;
import dev.fujioka.felipe.projetoJava.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * @author felipecesar
 *
 */

@Repository
public interface ConsultasRepository
     extends JpaRepository<Consultas, Long> {
	
}

