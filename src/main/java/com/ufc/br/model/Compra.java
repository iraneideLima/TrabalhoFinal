package com.ufc.br.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GeneratorType;

@Entity
public class Compra {
	@ManyToOne
    @JoinColumn(name="id", nullable=false)
	private Usuario usuario;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Roupa> getItens() {
		return itens;
	}
	public void setItens(List<Roupa> itens) {
		this.itens = itens;
	}
	public float getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	private List<Roupa> itens;
	private float valorTotal;
	

}
