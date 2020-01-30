package dev.fujioka.felipe.projetoJava.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.fujioka.felipe.projetoJava.repository.PacienteRepository;

/**
 * @author felipecesar
 *
 */

@Controller
@RequestMapping("/")
public class IndexResources {

	@Autowired
	PacienteRepository pacienteRepository;
	
	@GetMapping("/")
	public String getIndex(Model model) {
		model.addAttribute("qtdPacientes", pacienteRepository.listaQtdPacientes());
		return "/index";
	}
	
}