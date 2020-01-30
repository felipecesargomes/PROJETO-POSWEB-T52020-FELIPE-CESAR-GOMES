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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import dev.fujioka.felipe.projetoJava.domain.*;
import dev.fujioka.felipe.projetoJava.service.*;

/**
 * @author felipecesar
 *
 */

@Controller
@RequestMapping("/alimento")
public class AlimentoResource {

	@Autowired
	private AlimentoService alimentoService;

//-------------------------------------LISTAGEM-------------------------------------

	@GetMapping("/listar")
	public String getAlimentoList(ModelMap model) {
		model.addAttribute("alimento", alimentoService.findAll());
		return "/alimento/listar";
	}

//----------------------------------------------------------------------------------	

//-------------------------------------CADASTRO-------------------------------------	

	@GetMapping("/cadastrar")
	public String cadastrar(Alimento alimento) {
		return "/alimento/cadastrar";
	}

	@PostMapping("/salvar")
	public String save(@Valid Alimento alimento, BindingResult result, RedirectAttributes pact, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("fail", "Não foi possível cadastrar, verifique os dados novamente!");
			return "alimento/cadastrar";
		} else {
			alimento.calculoAutoKcal();
			alimentoService.save(alimento);
			pact.addFlashAttribute("success", "Alimento inserido com sucesso.");
			return "redirect:/alimento/cadastrar";
		}
	}

//----------------------------------------------------------------------------------

//--------------------------------------UPDATE--------------------------------------	

	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Alimento alimento = alimentoService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Alimento Id:" + id));

		model.addAttribute("alimento", alimento);
		return "alimento/editar";
	}

	@PostMapping("/update/{id}")
	public String updateAlimento(@PathVariable("id") long id, @Valid Alimento alimento, BindingResult result,
			Model model, RedirectAttributes pact) {
		if (result.hasErrors()) {
			alimento.setId(id);
			model.addAttribute("fail", "Alimento não editado.");
			return "alimento/editar";
		}
		alimento.calculoAutoKcal();
		alimentoService.save(alimento);
		pact.addFlashAttribute("success", "Alimento editado com sucesso.");
		model.addAttribute("pac", alimentoService.findAll());
		return "redirect:/alimento/listar";
	}

//----------------------------------------------------------------------------------	

//--------------------------------------DELETE--------------------------------------	

	@GetMapping("/delete/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes pact) {
		alimentoService.deleteById(id);
		pact.addFlashAttribute("success", "Alimento excluído com sucesso.");
		return "redirect:/alimento/listar";
	}

//----------------------------------------------------------------------------------	

//----------------------------------MODELATTRIBUTE----------------------------------

//----------------------------------------------------------------------------------		

	@GetMapping("/buscanome")
	public String pesquisarPorNome(@RequestParam("nome") String nome, ModelMap model) {
		model.addAttribute("alimento", alimentoService.buscaPorNome(nome.toUpperCase()));
		return "/alimento/listar";
	}

}
