package com.attornatus.avaliacao.pessoa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pessoas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PessoaController {
	
	@Autowired
	private PessoaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<PessoaEntity>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<PessoaEntity> getById(@PathVariable long id){ 
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<PessoaEntity> post (@RequestBody @Valid PessoaEntity pessoa){
		System.out.println(pessoa.getNome());
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(pessoa));
	}
	
	@PutMapping
	public ResponseEntity<PessoaEntity> put (@RequestBody PessoaEntity pessoa){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(pessoa));
	}
}
