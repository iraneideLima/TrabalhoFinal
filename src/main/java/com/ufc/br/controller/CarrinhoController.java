package com.ufc.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ufc.br.model.Carrinho;
import com.ufc.br.model.Roupa;
import com.ufc.br.service.RoupaService;

@Controller("/carrinho")
public class CarrinhoController {
	
	@Autowired
	private Carrinho carrinho;
	
	@Autowired
	private RoupaService roupaService;
	
	@PostMapping("/adicionar/{id}")
	public void adicionarItem(@PathVariable Long id) {
		Roupa roupaBanco = roupaService.buscarRoupaPorId(id);
		carrinho.addItem(roupaBanco);
	}
	
	@RequestMapping("/excluir/{id}")
	public void removerItem(@PathVariable Long id) {
		Roupa roupaBanco = roupaService.buscarRoupaPorId(id);
		carrinho.removerItem(roupaBanco);
	}
	
	@GetMapping("/listar")
	public ModelAndView listarItens() {
		ModelAndView mv = new ModelAndView("listarItens");
		List<Roupa> itens = carrinho.getItens();
		mv.addObject("itens", itens);
		
		return mv;
	}
	
	
	public void finalizarCompra(Carrinho carinho) {
		
	}
}
