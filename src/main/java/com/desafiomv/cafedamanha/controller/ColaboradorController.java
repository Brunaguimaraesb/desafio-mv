package com.desafiomv.cafedamanha.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.desafiomv.cafedamanha.model.Colaborador;
import com.desafiomv.cafedamanha.repository.ColaboradorRepository;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/colaborador")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ColaboradorController {
	
	@Autowired
	private ColaboradorRepository ColaboradorRepository;
	
	@GetMapping("/all")
	public ResponseEntity<List<Colaborador>> getAll() {
        return ResponseEntity.ok(ColaboradorRepository.findAll());
        
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Colaborador> getById(@PathVariable long id) {
	        return ColaboradorRepository.findById(id)
		        .map(resp -> ResponseEntity.ok(resp))
		        .orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Colaborador> post (@Valid @RequestBody Colaborador colaborador){
		return ResponseEntity.status(HttpStatus.CREATED).body(ColaboradorRepository.save(colaborador));
	}
	
	@PutMapping
	public ResponseEntity<Colaborador> put (@Valid @RequestBody Colaborador colaborador){
		return ColaboradorRepository.findById(colaborador.getId())
				.map(resp -> ResponseEntity.status(HttpStatus.OK).body(ColaboradorRepository.save(colaborador)))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());	
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		 Optional<Colaborador> post = ColaboradorRepository.findById(id);
	        if(post.isEmpty())
		        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
	        ColaboradorRepository.deleteById(id);
	}

}
