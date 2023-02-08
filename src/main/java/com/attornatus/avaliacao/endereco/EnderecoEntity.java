package com.attornatus.avaliacao.endereco;

import com.attornatus.avaliacao.pessoa.PessoaEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/* TODO Importar Lombok (para getters e setters) - OK
 * Importar MapStruct (para de para entre domain e dto)
 * Aplicar package by feature - OK
 * Construir o service para o endereco principal - OK
 * Incluir Entity nos models - OK
 * Criar DTO's
 * Testes
*/

@Entity
@Table(name = "tb_endereco")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String logradouro;
	
	private String cep;
	
	private Integer numero;
	
	private String cidade;
	
	private Boolean principal = false;

	@ManyToOne
	@JsonIgnoreProperties("enderecos")
	private PessoaEntity pessoa;
}
