package com.ufc.br.model;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Carrinho {
	
	private float valorTotal;
	private List<Roupa> itens;
	
	public void addItem(Roupa roupa) {
		itens.add(roupa);
		valorTotal += roupa.getPreco(); 
	}
	
	public void removerItem(Roupa roupa) {
		itens.remove(roupa);
		valorTotal -= roupa.getPreco();
	}
	
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
	public List<Roupa> getItens() {
		return itens;
	}
	public void setItens(List<Roupa> itens) {
		this.itens = itens;
	}
}
