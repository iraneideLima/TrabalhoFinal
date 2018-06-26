package com.ufc.br.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ufc.br.model.Roupa;
import com.ufc.br.model.Usuario;
import com.ufc.br.util.FileUtil;

public class CarrinhoService {
	
	private List<Roupa> roupas = new ArrayList<>();	
	

	public void adicionarRoupaNoCarrinho(Roupa roupa) {
		
		roupas.add(roupa);
	}
	
	public List<Roupa> listarRoupasDoCarrinho(){
		return roupas;
	}
	
		
	public void excluirRoupaDoCarrinhoId(Long id) {
	roupas.remove(id);
	}

	
	
	
}
