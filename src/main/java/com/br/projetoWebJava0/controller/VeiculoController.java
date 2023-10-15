package com.br.projetoWebJava0.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.br.projetoWebJava0.modelo.Veiculo;
import com.br.projetoWebJava0.repository.VeiculoRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/veiculo")
public class VeiculoController {

	@Autowired
	private VeiculoRepository veiculoRepository;

	@GetMapping("/novo")
	public String adicionarVeiculo(Model model) {
		model.addAttribute("veiculo", new Veiculo());
		return "/publica-criar-veiculo";
	}

	@PostMapping("/salvar")
	public String salvarVeiculo(@Valid Veiculo veiculo, BindingResult result,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return "/publica-criar-veiculo";
		}
		veiculoRepository.save(veiculo);
		attributes.addFlashAttribute("mensagem", "Veículo salvo com sucesso!");
		return "redirect:/veiculo/novo";
	}

	@RequestMapping("/listar")
	public String listarVeiculo(Model model) {
		model.addAttribute("veiculos", veiculoRepository.findAll());
		return "/listar-veiculo";
	}

	@GetMapping("/apagar/{id}")
	public String deleteVeiculo(@PathVariable("id") long codigoModelo, Model model) {
		Veiculo veiculo = veiculoRepository.findById(codigoModelo)
				.orElseThrow(() -> new IllegalArgumentException("Veiculo inválido:" + codigoModelo));
		veiculoRepository.delete(veiculo);
		return "redirect:/veiculo/listar";
	}

	@GetMapping("/editar/{id}")
	public String editarVeiculo(@PathVariable("id") long codigoModelo, Model model) {
		Optional<Veiculo> veiculoVelho = veiculoRepository.findById(codigoModelo);
		if (!veiculoVelho.isPresent()) {
			throw new IllegalArgumentException("Veículo Inválido:" + codigoModelo);
		}
		Veiculo veiculo = veiculoVelho.get();
		model.addAttribute("veiculo", veiculo);
		return "/alterar-dados";
	}

	@PostMapping("/editar/{id}")
	public String editarVeiculo(@PathVariable("id") long codigoModelo, Model model,
			@Valid Veiculo veiculo, BindingResult result) {
		if (result.hasErrors()) {
			veiculo.setCodigoModelo(codigoModelo);
			return "/alterar-dados";
		}
		veiculo.setCodigoModelo(codigoModelo);
		veiculoRepository.save(veiculo);
		return "redirect:/veiculo/listar";
	}

}
