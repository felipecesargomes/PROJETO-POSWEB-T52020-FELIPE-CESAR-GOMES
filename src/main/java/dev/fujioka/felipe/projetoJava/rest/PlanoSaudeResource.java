package dev.fujioka.felipe.projetoJava.rest;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/planosaude")
public class PlanoSaudeResource {

	@Autowired
	private PlanoSaudeService planoSaudeService;

//-------------------------------------LISTAGEM-------------------------------------

	@GetMapping("/listar")
	public String getPlanoSaudeList(ModelMap model) {
		model.addAttribute("planoSaude", planoSaudeService.findAll());
		return "/planosaude/listar";
	}

//----------------------------------------------------------------------------------	

//-------------------------------------CADASTRO-------------------------------------	

	@GetMapping("/cadastrar")
	public String cadastrar(PlanoSaude planoSaude) {
		return "/planosaude/cadastrar";
	}

	@PostMapping("/salvar")
	public String save(@Valid PlanoSaude planoSaude, BindingResult result, RedirectAttributes pact, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("fail", "Não foi possível cadastrar, verifique os dados novamente!");
			return "planosaude/cadastrar";
		} else {

			planoSaudeService.save(planoSaude);
			pact.addFlashAttribute("success", "Planode Saude inserido com sucesso.");

			return "redirect:/planosaude/cadastrar";
		}
	}

//----------------------------------------------------------------------------------

//--------------------------------------UPDATE--------------------------------------	

	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		PlanoSaude planoSaude = planoSaudeService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid PlanoSaude Id:" + id));

		model.addAttribute("planoSaude", planoSaude);
		return "planosaude/editar";
	}

	@PostMapping("/update/{id}")
	public String updatePlanoSaude(@PathVariable("id") long id, @Valid PlanoSaude planoSaude, BindingResult result,
			Model model, RedirectAttributes pact) {
		if (result.hasErrors()) {
			planoSaude.setId(id);
			model.addAttribute("fail", "Plano de Saude não editado.");
			return "planosaude/editar";
		}

		planoSaudeService.save(planoSaude);
		pact.addFlashAttribute("success", "Plano de Saude editado com sucesso.");
		model.addAttribute("pac", planoSaudeService.findAll());
		return "redirect:/planosaude/listar";
	}

//----------------------------------------------------------------------------------	

//--------------------------------------DELETE--------------------------------------	

	@GetMapping("/delete/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes pact) {
		planoSaudeService.deleteById(id);
		pact.addFlashAttribute("success", "Plano de Saude excluído com sucesso.");
		return "redirect:/planosaude/listar";
	}

//----------------------------------------------------------------------------------	

//----------------------------------MODELATTRIBUTE----------------------------------


}