package com.uzitec.clienteservico.funcionario.application.service;

import com.uzitec.clienteservico.funcionario.application.api.request.FuncionarioRequest;
import com.uzitec.clienteservico.funcionario.application.api.response.FuncionarioResponse;

public interface FuncionarioService {
	FuncionarioResponse salvaFuncionario(FuncionarioRequest funcionarioRequest);
}