package com.uzitec.clienteservico.funcionario.application.api.request;

import com.uzitec.clienteservico.funcionario.domain.Cargo;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class AlteraFuncionarioRequest {
	@NotBlank(message = "Campo Obrigatório!")
	private String nomeFuncionario;
	private String cpf;
	private String celular;
	private Cargo cargo;
}
