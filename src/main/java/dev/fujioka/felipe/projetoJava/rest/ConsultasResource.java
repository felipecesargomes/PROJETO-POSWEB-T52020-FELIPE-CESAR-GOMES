package dev.fujioka.felipe.projetoJava.rest;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import dev.fujioka.felipe.projetoJava.domain.*;
import dev.fujioka.felipe.projetoJava.service.*;

/**
 * @author felipecesar
 *
 */

@Controller
@RequestMapping("/consultas")
public class ConsultasResource {

	@Autowired
	private ConsultasService consultasService;
	@Autowired
	private PacienteService pacienteService;
	@Autowired
	private NutricionistaService nutricionistaService;

//-------------------------------------LISTAGEM-------------------------------------

	@GetMapping("/listar")
	public String getConsultasList(ModelMap model) {
		model.addAttribute("consultas", consultasService.findAll());
		return "/consultas/listar";
	}

//----------------------------------------------------------------------------------	

//-------------------------------------CADASTRO-------------------------------------	

	@GetMapping("/cadastrar")
	public String cadastrar(Consultas consultas) {
		return "/consultas/cadastrar";
	}

	@PostMapping("/salvar")
	public String save(@Valid Consultas consultas, BindingResult result, RedirectAttributes pact, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("fail", "Não foi possível cadastrar, verifique os dados novamente!");
			return "consultas/cadastrar";
		} else {
			consultasService.save(consultas);
			pact.addFlashAttribute("success", "Consulta inserida com sucesso.");

			return "redirect:/consultas/cadastrar";
		}
	}

//----------------------------------------------------------------------------------

//--------------------------------------UPDATE--------------------------------------	

	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Consultas consultas = consultasService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Consultas Id:" + id));

		model.addAttribute("consultas", consultas);
		return "consultas/editar";
	}

	@PostMapping("/update/{id}")
	public String updateConsultas(@PathVariable("id") long id, @Valid Consultas consultas, BindingResult result,
			Model model, RedirectAttributes pact) {
		if (result.hasErrors()) {
			consultas.setId(id);
			model.addAttribute("fail", "Consulta não editada.");
			return "consultas/editar";
		}
		consultasService.save(consultas);
		pact.addFlashAttribute("success", "Consulta editada com sucesso.");
		model.addAttribute("pac", consultasService.findAll());
		return "redirect:/consultas/listar";
	}

//----------------------------------------------------------------------------------	

//--------------------------------------DELETE--------------------------------------	

	@GetMapping("/delete/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes pact) {
		consultasService.deleteById(id);
		pact.addFlashAttribute("success", "Consulta excluída com sucesso.");
		return "redirect:/consultas/listar";
	}

//----------------------------------------------------------------------------------	

//----------------------------------MODELATTRIBUTE----------------------------------

	@ModelAttribute("paciente")
	public List<Paciente> listaDePaciente() {
		return pacienteService.findAll();
	}

	@ModelAttribute("nutricionista")
	public List<Nutricionista> listaDeNutricionista() {
		return nutricionistaService.findAll();
	}

}