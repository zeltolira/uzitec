package com.uzitec.clienteservico.funcionario.domain;

import java.util.UUID;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID idFuncionario;
	@NotBlank(message = "Campo Obrigatório")
	private String nomeFuncionario;
	@NotBlank(message = "Campo Obrigatório")
	@CPF
	@Column(unique = true)
	private String cpf;
	private String celular;
	@Enumerated(EnumType.STRING)
	private Cargo cargo;
	
}
