package com.attornatus.avaliacao.pessoa;

import java.util.Date;
import java.util.List;

import com.attornatus.avaliacao.endereco.EnderecoEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_pessoa")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataNascimento;
	
	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("pessoa")
	private List<EnderecoEntity> enderecos;
}
