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
import dev.fujioka.felipe.projetoJava.domain.Nutricionista;
import dev.fujioka.felipe.projetoJava.service.NutricionistaService;

/**
 * @author felipecesar
 *
 */

@Controller
@RequestMapping("/nutricionista")
public class NutricionistaResource {

	@Autowired
	private NutricionistaService nutricionistaService;

//-------------------------------------LISTAGEM-------------------------------------

	@GetMapping("/listar")
	public String getNutricionistaList(ModelMap model) {
		model.addAttribute("nutricionista", nutricionistaService.findAll());
		return "/nutricionista/listar";
	}

//----------------------------------------------------------------------------------	

//-------------------------------------CADASTRO-------------------------------------	

	@GetMapping("/cadastrar")
	public String cadastrar(Nutricionista nutricionista) {
		return "/nutricionista/cadastrar";
	}

	@PostMapping("/salvar")
	public String save(@Valid Nutricionista nutricionista, BindingResult result, RedirectAttributes pact, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("fail", "Não foi possível cadastrar, verifique os dados novamente!");
			return "nutricionista/cadastrar";
		} else {
			nutricionistaService.save(nutricionista);
			pact.addFlashAttribute("success", "Nutricionista inserido com sucesso.");
			return "redirect:/nutricionista/cadastrar";
		}
	}

//----------------------------------------------------------------------------------

//--------------------------------------UPDATE--------------------------------------	

	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Nutricionista nutricionista = nutricionistaService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Nutricionista Id:" + id));

		model.addAttribute("nutricionista", nutricionista);
		return "nutricionista/editar";
	}

	@PostMapping("/update/{id}")
	public String updateNutricionista(@PathVariable("id") long id, @Valid Nutricionista nutricionista, BindingResult result,
			Model model, RedirectAttributes pact) {
		if (result.hasErrors()) {
			nutricionista.setId(id);
			model.addAttribute("fail", "Nutricionista não editado.");
			return "nutricionista/editar";
		}

		nutricionistaService.save(nutricionista);
		pact.addFlashAttribute("success", "Nutricionista editado com sucesso.");
		model.addAttribute("pac", nutricionistaService.findAll());
		return "redirect:/nutricionista/listar";
	}

//----------------------------------------------------------------------------------	

//--------------------------------------DELETE--------------------------------------	

	@GetMapping("/delete/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes pact) {

		nutricionistaService.deleteById(id);
		pact.addFlashAttribute("success", "Nutricionista excluído com sucesso.");

		return "redirect:/nutricionista/listar";
	}

//----------------------------------------------------------------------------------	

//----------------------------------MODELATTRIBUTE----------------------------------

//----------------------------------------------------------------------------------	

		@GetMapping("/buscanome")
		public String pesquisarPorNome(@RequestParam("nome") String nome, ModelMap model) {
			model.addAttribute("nutricionista", nutricionistaService.buscaPorNome(nome.toUpperCase()));
			return "/nutricionista/listar";
		}
		
		@GetMapping("/buscarg")
		public String pesquisarPorRg(@RequestParam("rg") String rg, ModelMap model) {
			model.addAttribute("nutricionista", nutricionistaService.buscaPorRg(rg));
			return "/nutricionista/listar";
		}
		
		@GetMapping("/buscacpf")
		public String pesquisarPorCpf(@RequestParam("cpf") String cpf, ModelMap model) {
			model.addAttribute("nutricionista", nutricionistaService.buscaPorCpf(cpf));
			return "/nutricionista/listar";
		}
		
		@GetMapping("/buscaturno")
		public String pesquisarPorTurno(@RequestParam("turno") String turno, ModelMap model) {
			model.addAttribute("nutricionista", nutricionistaService.buscaPorTurno(turno));
			return "/nutricionista/listar";
		}
	
}