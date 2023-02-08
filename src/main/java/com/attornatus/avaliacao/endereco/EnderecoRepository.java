package com.attornatus.avaliacao.endereco;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository <EnderecoEntity, Long>{
	
	public List<EnderecoEntity> findAllByPessoaId(long id);
}
