package dev.fujioka.felipe.projetoJava.repository;
import dev.fujioka.felipe.projetoJava.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author felipecesar
 *
 */

@Repository
public interface PlanoSaudeRepository
     extends JpaRepository<PlanoSaude, Long> {

}

