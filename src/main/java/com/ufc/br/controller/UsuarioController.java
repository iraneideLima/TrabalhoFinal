package com.ufc.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.ufc.br.model.Usuario;
import com.ufc.br.service.UsuarioService;

@Controller
@RequestMapping("/user")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@RequestMapping("/formulario")
	public ModelAndView formularioUsuario() {
		ModelAndView mv = new ModelAndView("formulario");
		mv.addObject("usuario", new Usuario());
		
		return mv;	
		
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarUsuario(Usuario usuario) {
		usuarioService.adicionarUsuario(usuario);
		ModelAndView mv = new ModelAndView("redirect:/user/listar");
		
		//ModelAndView mv = new ModelAndView("formulario");
		//mv.addObject("mensagem", "Usuário cadastrado com sucesso");
		
		return mv;
	}
	
	
	
	@GetMapping("/listar")
	public ModelAndView listarUsuario() {
		List<Usuario> usuario = usuarioService.listarUsuarios();
		ModelAndView mv = new ModelAndView("listarUsuarios");
				//.addObject("usuario", usuario);
		
		mv.addObject("listarUsuarios", usuario);
		
		return mv;
	}
	
	@RequestMapping("{id}")
	public ModelAndView atualizarUsuario(@PathVariable Long id) {
		Usuario usuario = usuarioService.boscarUsuarioPorId(id);
		ModelAndView mv = new ModelAndView("formulario");
		mv.addObject("usuario", usuario);
		
		return mv;
	}
	
	@RequestMapping("/excluir/{id}")
	public ModelAndView excluirUsuario(@PathVariable Long id) {
		usuarioService.excluirUsuarioPorId(id);;
		ModelAndView mv = new ModelAndView("redirect:/user/listar");
		return mv;
	}
	
	@RequestMapping("/logar")
	public ModelAndView logar() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	
	
	
}
