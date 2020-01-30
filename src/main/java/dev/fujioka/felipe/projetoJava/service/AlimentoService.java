package dev.fujioka.felipe.projetoJava.service;

import dev.fujioka.felipe.projetoJava.domain.*;
import dev.fujioka.felipe.projetoJava.repository.AlimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlimentoService implements CrudInterface<Alimento> {

	@Autowired
	private AlimentoRepository alimentoRepository;

	@Override
	public List<Alimento> findAll() {
		return alimentoRepository.findAll();
	}

	@Override
	public Optional<Alimento> save(Alimento entity) {
		return Optional.of(alimentoRepository.save(entity));
	}

	@Override
	public Optional<Alimento> findById(long id) {
		return alimentoRepository.findById(id);

	}

	@Override
	public void delete(Alimento entity) {
		alimentoRepository.delete(entity);
	}

	@Override
	public void deleteById(long id) {
		alimentoRepository.deleteById(id);
	}

	@Override
	public long count() {
		return alimentoRepository.count();
	}

	public List<Alimento> buscaPorNome(String nome) {
		return alimentoRepository.listaPorNome(nome);
	}

}