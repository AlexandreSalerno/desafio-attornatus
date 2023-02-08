package com.attornatus.avaliacao.endereco;

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
@RequestMapping("/enderecos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EnderecoController {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping
	public ResponseEntity<List<EnderecoEntity>> getAll(){
		return ResponseEntity.ok(enderecoRepository.findAll());
	}
	
	@GetMapping("/pessoa/{id}")
	public ResponseEntity<List<EnderecoEntity>> getAllByPessoaId (@PathVariable long id) {
		return ResponseEntity.ok(enderecoRepository.findAllByPessoaId(id));
	}
	
	@PostMapping
	public ResponseEntity<EnderecoEntity> post (@RequestBody @Valid EnderecoEntity endereco){
		return ResponseEntity.status(HttpStatus.CREATED).body(enderecoRepository.save(endereco));
	}
	
	@PutMapping("/pessoa/{pessoaId}/principal/{enderecoId}")
	public ResponseEntity<List<EnderecoEntity>> putAllByPessoaId (@PathVariable long pessoaId, @PathVariable long enderecoId){
		return ResponseEntity.status(HttpStatus.OK).body(enderecoService.enderecoPrincipal(pessoaId, enderecoId));
	}
}
