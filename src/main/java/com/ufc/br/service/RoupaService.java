package com.ufc.br.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ufc.br.model.Roupa;
import com.ufc.br.repository.RoupaRepository;
import com.ufc.br.util.FileUtil;
import java.util.List;

@Service
public class RoupaService {
	@Autowired
	RoupaRepository roupaRepository;
	
	public void salvarRoupa(Roupa roupa, MultipartFile imagem) {
		String caminho = "images/" + roupa.getDescricao() + ".png";
		FileUtil.salvarIMG(caminho, imagem);
		roupaRepository.save(roupa);		
		
	}
	
	public List<Roupa> listarRoupa(){
		
		return roupaRepository.findAll();
		
	}
	
	public Roupa buscarRoupaPorId(Long id) {
		return roupaRepository.getOne(id);
		
	}
	
	public void deletarRoupaPorId(Long id) {
		roupaRepository.deleteById(id);
		
	}
	
	

}
