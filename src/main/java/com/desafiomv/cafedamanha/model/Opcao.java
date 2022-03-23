package com.desafiomv.cafedamanha.model;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class Opcao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOpcao;
	
	@NotNull(message = "O atributo opcao_comida é obrigatório")
	private String opcao_comida;

	@NotNull(message = "O atributo quantidade é obrigatório")
	private int quantidade;
	
	@ManyToOne
	@JsonIgnoreProperties("opcao")
	@JoinColumn(name = "fk_colaborador")
	private Colaborador colaborador;

	public Long getIdOpcao() {
		return idOpcao;
	}

	public void setIdOpcao(Long idOpcao) {
		this.idOpcao = idOpcao;
	}

	public String getOpcao_comida() {
		return opcao_comida;
	}

	public void setOpcao_comida(String opcao_comida) {
		this.opcao_comida = opcao_comida;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
	
}
