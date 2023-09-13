package com.uzitec.clienteservico.funcionario.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.uzitec.clienteservico.funcionario.application.api.request.FuncionarioRequest;
import com.uzitec.clienteservico.funcionario.application.api.response.FuncionarioResponse;

import jakarta.validation.Valid;

@RequestMapping("/v1/funcionario")
public interface FuncionarioAPI {

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	FuncionarioResponse salvaFuncionario(@Valid @RequestBody FuncionarioRequest funcionarioRequest);
}
