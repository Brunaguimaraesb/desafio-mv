package com.desafiomv.cafedamanha.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "colaborador")
public class Colaborador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "O atributo Nome é obrigatório")
	private String colaborador;
	
	@CPF(message = "O atributo deve ser um cpf")
	@Size(min = 11, max = 11, message = "O atributo cpf deve ter 11 caracteres")
	private String cpf;
	
	@OneToMany(mappedBy = "colaborador", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("colaborador")
	private List<Opcao> opcao = new ArrayList<>();
	
	public Colaborador(long id, String colaborador, String cpf) {
		
		this.id = id;
		this.colaborador = colaborador;
		this.cpf = cpf;
	}

	public Colaborador() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getColaborador() {
		return colaborador;
	}

	public void setColaborador(String colaborador) {
		this.colaborador = colaborador;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public List<Opcao> getOpcao() {
		return opcao;
	}

	public void setPostagem(List<Opcao> opcao) {
		this.opcao = opcao;
	}
	
}