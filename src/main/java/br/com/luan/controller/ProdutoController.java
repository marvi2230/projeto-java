package br.com.luan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.luan.entity.Produto;
import br.com.luan.service.ProdutoServiceImplements;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoServiceImplements ProdutoServiceImpl;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("allList", ProdutoServiceImpl.getAllProduto());
		return "index";
	}

	@GetMapping("/salvarproduto")
	public String addNewProduto(Model model) {
		Produto produto = new Produto();
		model.addAttribute("produto", produto);
		return "salvarproduto";
	}

	@PostMapping("/save")
	public String saveProduto(@ModelAttribute("produto") Produto produto) {
		ProdutoServiceImpl.save(produto);
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String updateForm(@PathVariable(value = "id") long id, Model model) {
		Produto produto = ProdutoServiceImpl.getById(id);
		model.addAttribute("produto", produto);
		return "atualizar";
	}

	@GetMapping("/deleteProduto/{id}")
	public String deleteThroughId(@PathVariable(value = "id") long id) {
		ProdutoServiceImpl.deleteViaId(id);
		return "redirect:/";

	}

}
