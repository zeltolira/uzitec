package com.uzitec.clienteservico.funcionario.application.service;

import java.util.List;
import java.util.UUID;

import com.uzitec.clienteservico.funcionario.application.api.request.AlteraFuncionarioRequest;
import com.uzitec.clienteservico.funcionario.application.api.request.FuncionarioRequest;
import com.uzitec.clienteservico.funcionario.application.api.response.FuncionarioResponse;

public interface FuncionarioService {
	FuncionarioResponse salvaFuncionario(FuncionarioRequest funcionarioRequest);
	FuncionarioResponse buscaFuncionarioPorId(UUID idFuncionario);
	List<FuncionarioResponse> buscaTodosFuncionarios();
	void deletaFuncionario(UUID idFuncionario);
	void alteraFuncionario(UUID idFuncionario, AlteraFuncionarioRequest alteraFuncionarioRequest);
}