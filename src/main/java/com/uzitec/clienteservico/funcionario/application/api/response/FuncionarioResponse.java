package com.uzitec.clienteservico.funcionario.application.api.response;

import java.util.UUID;

import com.uzitec.clienteservico.funcionario.domain.Cargo;
import com.uzitec.clienteservico.funcionario.domain.Funcionario;

import lombok.Value;

@Value
public class FuncionarioResponse {
	private UUID idFuncionario;
	private String nomeFuncionario;
	private String cpf;
	private String celular;
	private Cargo cargo;

	public FuncionarioResponse(Funcionario funcionario) {
		this.idFuncionario = funcionario.getIdFuncionario();
		this.nomeFuncionario = funcionario.getNomeFuncionario();
		this.cpf = funcionario.getCpf();
		this.celular = funcionario.getCelular();
		this.cargo = funcionario.getCargo();
	}
}