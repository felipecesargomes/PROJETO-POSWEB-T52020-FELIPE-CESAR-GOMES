package dev.fujioka.felipe.projetoJava.service;


import dev.fujioka.felipe.projetoJava.domain.*;
import dev.fujioka.felipe.projetoJava.repository.PlanoSaudeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanoSaudeService
        implements CrudInterface<PlanoSaude> {

    @Autowired
    private PlanoSaudeRepository planoSaudeRepository;


    @Override
    public List<PlanoSaude> findAll() {

        return planoSaudeRepository.findAll();
    }

    @Override
    public Optional<PlanoSaude> save(PlanoSaude entity) {

        return Optional.of(planoSaudeRepository.save(entity));
    }

    @Override
    public Optional<PlanoSaude> findById(long id) {

        return planoSaudeRepository.findById(id);

    }

    @Override
    public void delete(PlanoSaude entity) {
    	planoSaudeRepository.delete(entity);
    }

    @Override
    public void deleteById(long id) {
    	planoSaudeRepository.deleteById(id);
    }

    @Override
    public long count() {
        return planoSaudeRepository.count();
    }
    

}