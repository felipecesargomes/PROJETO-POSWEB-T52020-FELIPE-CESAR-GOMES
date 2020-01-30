package dev.fujioka.felipe.projetoJava.service;

import dev.fujioka.felipe.projetoJava.domain.*;
import dev.fujioka.felipe.projetoJava.repository.ConsultasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultasService implements CrudInterface<Consultas> {

	@Autowired
	private ConsultasRepository consultasRepository;

	@Override
	public List<Consultas> findAll() {
		return consultasRepository.findAll();
	}

	@Override
	public Optional<Consultas> save(Consultas entity) {
		return Optional.of(consultasRepository.save(entity));
	}

	@Override
	public Optional<Consultas> findById(long id) {
		return consultasRepository.findById(id);

	}

	@Override
	public void delete(Consultas entity) {
		consultasRepository.delete(entity);
	}

	@Override
	public void deleteById(long id) {
		consultasRepository.deleteById(id);
	}

	@Override
	public long count() {
		return consultasRepository.count();
	}
	
}