package com.desafiomv.cafedamanha.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.desafiomv.cafedamanha.model.Opcao;
import com.desafiomv.cafedamanha.repository.OpcaoRepository;

@RestController
@RequestMapping("/opcao")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OpcaoController {

	@Autowired
	private OpcaoRepository opcaoRepository;
	
	@GetMapping
	public ResponseEntity<List<Opcao>> GetAll(){
		return ResponseEntity.ok(opcaoRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Opcao> GetById(@PathVariable long id){
		return opcaoRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/endereco/{opcao_comida}")
	public ResponseEntity<List<Opcao>> GetByTitulo(@PathVariable("opcao_comida") String opcao_comida){
		return ResponseEntity.ok(opcaoRepository.findByOpcaoContainingIgnoreCase(opcao_comida));
	}
	
	@PostMapping
	public ResponseEntity<Opcao> post (@Valid @RequestBody Opcao opcao){
		return ResponseEntity.status(HttpStatus.CREATED).body(opcaoRepository.save(opcao));
	}
	
	@PutMapping
	public ResponseEntity<Opcao> put (@Valid @RequestBody Opcao opcao){
		return opcaoRepository.findById(opcao.getIdOpcao())
				.map(resp -> ResponseEntity.status(HttpStatus.OK).body(opcaoRepository.save(opcao)))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
		
				
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		 Optional<Opcao> post = opcaoRepository.findById(id);
	        if(post.isEmpty())
		        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
	        opcaoRepository.deleteById(id);
	}
}
