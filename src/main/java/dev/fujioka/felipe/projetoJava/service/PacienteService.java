package dev.fujioka.felipe.projetoJava.service;

import dev.fujioka.felipe.projetoJava.Tratamentos;
import dev.fujioka.felipe.projetoJava.domain.Consultas;
import dev.fujioka.felipe.projetoJava.domain.Paciente;
import dev.fujioka.felipe.projetoJava.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService extends Tratamentos implements CrudInterface<Paciente> {

	@Autowired
	private PacienteRepository pacienteRepository;

	@Override
	public List<Paciente> findAll() {

		return pacienteRepository.findAll();
	}

	@Override
	public Optional<Paciente> save(Paciente entity) {

		return Optional.of(pacienteRepository.save(entity));
	}

	@Override
	public Optional<Paciente> findById(long id) {

		return pacienteRepository.findById(id);

	}

	@Override
	public void delete(Paciente entity) {
		pacienteRepository.delete(entity);
	}

	@Override
	public void deleteById(long id) {
		pacienteRepository.deleteById(id);
	}

	@Override
	public long count() {
		return pacienteRepository.count();
	}

	public List<Paciente> buscaPorNome(String nome) {
		return pacienteRepository.listaPacientePorNome(nome);
	}

	public List<Paciente> buscaPorRg(String rg) {
		return pacienteRepository.listaPacientePorRg(rg);
	}

	public List<Paciente> buscaPorCpf(String cpf) {
		return pacienteRepository.listaPacientePorCpf(removerPontos(cpf));
	}

	public List<Paciente> buscaPorDataNascimento(Date dataInicial, Date dataFinal) {
		return pacienteRepository.listaPacientePorDataNascimento(dataInicial, dataFinal);
	}

	public List<Paciente> buscaPorPlano(long id) {
		return pacienteRepository.listaPacientePorPlano(id);
	}
	
	public List<Paciente> buscaPorSexo(String sexo) {
		return pacienteRepository.listaPacientePorSexo(sexo);
	}

}