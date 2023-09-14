package com.uzitec.clienteservico.funcionario.application.api.response;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

	public static List<FuncionarioResponse> converte(List<Funcionario> funcinarios) {
		return funcinarios.stream()
				.map(FuncionarioResponse::new)
				.collect(Collectors.toList());
	}
	
}