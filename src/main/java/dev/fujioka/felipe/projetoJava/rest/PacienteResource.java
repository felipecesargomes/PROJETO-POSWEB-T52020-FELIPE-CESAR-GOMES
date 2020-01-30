package dev.fujioka.felipe.projetoJava.rest;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import dev.fujioka.felipe.projetoJava.domain.Paciente;
import dev.fujioka.felipe.projetoJava.domain.PlanoSaude;
import dev.fujioka.felipe.projetoJava.repository.PacienteRepository;
import dev.fujioka.felipe.projetoJava.service.PacienteService;
import dev.fujioka.felipe.projetoJava.service.PlanoSaudeService;

/**
 * @author felipecesar
 *
 */

@Controller
@RequestMapping("/paciente")
public class PacienteResource {

	@Autowired
	private PacienteService pacienteService;
	@Autowired
	private PlanoSaudeService planoSaudeService;
	private PacienteRepository pacienteRepository;

//-------------------------------------LISTAGEM-------------------------------------

	@GetMapping("/listar")
	public String getPacienteList(ModelMap model, Pageable paginacao) {
		model.addAttribute("paciente", pacienteService.findAll());
		return "/paciente/listar";
	}

//----------------------------------------------------------------------------------	

//-------------------------------------CADASTRO-------------------------------------	

	@GetMapping("/cadastrar")
	public String cadastrar(Paciente paciente) {
		return "/paciente/cadastrar";
	}

	@PostMapping("/salvar")
	public String save(@Valid Paciente paciente, BindingResult result, RedirectAttributes pact, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("fail", "Não foi possível cadastrar, verifique os dados novamente!");
			return "paciente/cadastrar";
		} else {

			pacienteService.save(paciente);
			pact.addFlashAttribute("success", "Paciente inserido com sucesso.");

			return "redirect:/paciente/cadastrar";
		}
	}

//----------------------------------------------------------------------------------

//--------------------------------------UPDATE--------------------------------------	

	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Paciente paciente = pacienteService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Paciente Id:" + id));

		model.addAttribute("paciente", paciente);
		return "paciente/editar";
	}

	@PostMapping("/update/{id}")
	public String updatePaciente(@PathVariable("id") long id, @Valid Paciente paciente, BindingResult result,
			Model model, RedirectAttributes pact) {
		if (result.hasErrors()) {
			paciente.setId(id);
			model.addAttribute("fail", "Paciente não editado.");
			return "paciente/editar";
		}

		pacienteService.save(paciente);
		pact.addFlashAttribute("success", "Paciente editado com sucesso.");
		model.addAttribute("pac", pacienteService.findAll());
		return "redirect:/paciente/listar";
	}

//----------------------------------------------------------------------------------	

//--------------------------------------DELETE--------------------------------------	

	@GetMapping("/delete/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes pact) {

		pacienteService.deleteById(id);
		pact.addFlashAttribute("success", "Paciente excluído com sucesso.");

		return "redirect:/paciente/listar";
	}

//----------------------------------------------------------------------------------	

//----------------------------------MODELATTRIBUTE----------------------------------
	@ModelAttribute("planoSaude")
	public List<PlanoSaude> listaDePlanos() {
		return planoSaudeService.findAll();
	}

//----------------------------------------------------------------------------------	

	@GetMapping("/buscanome")
	public String pesquisarPorNome(@RequestParam("nome") String nome, ModelMap model) {
		model.addAttribute("paciente", pacienteService.buscaPorNome(nome.toUpperCase()));
		return "/paciente/listar";
	}
	
	@GetMapping("/buscarg")
	public String pesquisarPorRg(@RequestParam("rg") String rg, ModelMap model) {
		model.addAttribute("paciente", pacienteService.buscaPorRg(rg));
		return "/paciente/listar";
	}
	
	@GetMapping("/buscacpf")
	public String pesquisarPorCpf(@RequestParam("cpf") String cpf, ModelMap model) {
		model.addAttribute("paciente", pacienteService.buscaPorCpf(cpf));
		return "/paciente/listar";
	}
	
	@GetMapping("/buscadata")
	public String pesquisarPorDataNascimento(@RequestParam("dataInicial") @DateTimeFormat(pattern = "yyyy-mm-dd") Date dataInicial , @RequestParam("dataFinal") @DateTimeFormat(pattern = "yyyy-mm-dd") Date dataFinal, ModelMap model) {
		model.addAttribute("paciente", pacienteService.buscaPorDataNascimento(dataInicial, dataFinal));
		return "/paciente/listar";
	}
	
	@GetMapping("/buscaplano")
	public String pesquisarPorPlano(@RequestParam("id") long id, ModelMap model) {
		model.addAttribute("paciente", pacienteService.buscaPorPlano(id));
		return "/paciente/listar";
	}
	
	@GetMapping("/buscasexo")
	public String pesquisarPorSexo(@RequestParam("sexo") String sexo, ModelMap model) {
		model.addAttribute("paciente", pacienteService.buscaPorSexo(sexo));
		return "/paciente/listar";
	}
}