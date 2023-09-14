package com.uzitec.clienteservico.funcionario.application.service;

import java.util.UUID;

import com.uzitec.clienteservico.funcionario.application.api.request.FuncionarioRequest;
import com.uzitec.clienteservico.funcionario.application.api.response.FuncionarioResponse;

public interface FuncionarioService {
	FuncionarioResponse salvaFuncionario(FuncionarioRequest funcionarioRequest);
	FuncionarioResponse buscaFuncionarioPorId(UUID idFuncionario);
}