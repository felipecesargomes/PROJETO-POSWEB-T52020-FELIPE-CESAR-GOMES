package dev.fujioka.felipe.projetoJava.service;

import dev.fujioka.felipe.projetoJava.Tratamentos;
import dev.fujioka.felipe.projetoJava.domain.Nutricionista;
import dev.fujioka.felipe.projetoJava.repository.NutricionistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NutricionistaService extends Tratamentos implements CrudInterface<Nutricionista> {

	@Autowired
	private NutricionistaRepository nutricionistaRepository;

	@Override
	public List<Nutricionista> findAll() {

		return nutricionistaRepository.findAll();
	}

	@Override
	public Optional<Nutricionista> save(Nutricionista entity) {

		return Optional.of(nutricionistaRepository.save(entity));
	}

	@Override
	public Optional<Nutricionista> findById(long id) {

		return nutricionistaRepository.findById(id);

	}

	@Override
	public void delete(Nutricionista entity) {
		nutricionistaRepository.delete(entity);
	}

	@Override
	public void deleteById(long id) {
		nutricionistaRepository.deleteById(id);
	}

	@Override
	public long count() {
		return nutricionistaRepository.count();
	}

	public List<Nutricionista> buscaPorNome(String nome) {
		return nutricionistaRepository.listaNutricionistaPorNome(nome);
	}

	public List<Nutricionista> buscaPorRg(String rg) {
		return nutricionistaRepository.listaNutricionistaPorRg(rg);
	}

	public List<Nutricionista> buscaPorCpf(String cpf) {
		return nutricionistaRepository.listaNutricionistaPorCpf(removerPontos(cpf));
	}

	public List<Nutricionista> buscaPorTurno(String turno) {
		return nutricionistaRepository.listaNutricionistaPorTurno(turno);
	}

}