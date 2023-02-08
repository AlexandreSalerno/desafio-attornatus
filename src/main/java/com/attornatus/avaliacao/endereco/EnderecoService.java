package com.attornatus.avaliacao.endereco;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository repository;
	
	public List<EnderecoEntity> enderecoPrincipal(long pessoaId, long enderecoId) {

		List<EnderecoEntity> enderecos = repository.findAllByPessoaId(pessoaId);
		
		for (EnderecoEntity endereco : enderecos) {
			if (endereco.getId().equals(enderecoId)) {
				endereco.setPrincipal(true);
			} else {
				endereco.setPrincipal(false);
			}
		}
		
		return repository.saveAll(enderecos);
	}
}
