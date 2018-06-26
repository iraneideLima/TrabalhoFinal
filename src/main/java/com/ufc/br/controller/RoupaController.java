package com.ufc.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ufc.br.model.Roupa;
import com.ufc.br.service.RoupaService;

@Controller
@RequestMapping("/vendas")
public class RoupaController {
	
	@Autowired
	RoupaService roupaService;
	
	
	@RequestMapping("/adicionar/roupa")
	public ModelAndView addRoupa() {
		ModelAndView mv = new ModelAndView("addRoupa");
		mv.addObject("roupa", new Roupa());
		
		return mv;	
		
	}
	
	@PostMapping("/salvar/roupa")
	public ModelAndView salvarRoupa(Roupa roupa, @RequestParam(value = "imagem") MultipartFile imagem) {
		roupaService.salvarRoupa(roupa, imagem);
		ModelAndView mv = new ModelAndView("redirect:/vendas/listar/roupa");
		return mv;
	}
	
	@GetMapping("/listar/roupa")
	public ModelAndView listarRoupa() {
		ModelAndView mv = new ModelAndView("listarRoupa");
		List<Roupa> roupa = roupaService.listarRoupa();
		mv.addObject("todasRoupas", roupa);
		
		return mv;
	}
	
	@RequestMapping("/atualizar/roupa/{id}")
	public ModelAndView atualizarRoupaPorId(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("addRoupa");
		Roupa roupa = roupaService.buscarRoupaPorId(id);
		mv.addObject("roupa", roupa);
		
		return mv;
	}
	
	@RequestMapping("/excluir/roupa/{id}")
	public ModelAndView excluirRoupaPorId(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("redirect:/vendas/listar/roupa");
		roupaService.deletarRoupaPorId(id);
		
		return mv;
	}
	
	@RequestMapping("/listar/roupa/{id}")
	public ModelAndView listarRoupaPorId(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("umaRoupa");
		
		Roupa roupa = roupaService.buscarRoupaPorId(id);
		mv.addObject("roupa", roupa);		
		return mv;
	}
		
	
}
