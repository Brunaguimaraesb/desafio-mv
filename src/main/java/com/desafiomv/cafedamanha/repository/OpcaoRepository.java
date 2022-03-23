package com.desafiomv.cafedamanha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafiomv.cafedamanha.model.Opcao;

public interface OpcaoRepository  extends JpaRepository<Opcao, Long > {
	
	public List <Opcao> findByOpcaoContainingIgnoreCase(String opcao_comida);

}
