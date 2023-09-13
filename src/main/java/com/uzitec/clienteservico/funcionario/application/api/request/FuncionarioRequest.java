package com.uzitec.clienteservico.funcionario.application.api.request;

import org.hibernate.validator.constraints.br.CPF;

import com.uzitec.clienteservico.funcionario.domain.Cargo;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class FuncionarioRequest {
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
