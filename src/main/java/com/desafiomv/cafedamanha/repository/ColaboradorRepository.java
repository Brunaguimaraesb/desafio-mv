package com.desafiomv.cafedamanha.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafiomv.cafedamanha.model.Colaborador;

public interface ColaboradorRepository  extends JpaRepository<Colaborador, Long> {
	
	public Optional<Colaborador> findByCpf(String cpf); 
	
	public List<Colaborador> findAllByColaboradorContainingIgnoreCase(String colaborador);


}
