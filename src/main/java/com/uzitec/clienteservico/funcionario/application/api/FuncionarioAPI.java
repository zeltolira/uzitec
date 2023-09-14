package com.uzitec.clienteservico.funcionario.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.uzitec.clienteservico.funcionario.application.api.request.FuncionarioRequest;
import com.uzitec.clienteservico.funcionario.application.api.request.AlteraFuncionarioRequest;
import com.uzitec.clienteservico.funcionario.application.api.response.FuncionarioResponse;

import jakarta.validation.Valid;

@RequestMapping("/v1/funcionario")
public interface FuncionarioAPI {

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	FuncionarioResponse salvaFuncionario(@Valid @RequestBody FuncionarioRequest funcionarioRequest);
	
	@GetMapping(value = "/{idFuncionario}")
	@ResponseStatus(code = HttpStatus.OK)
	FuncionarioResponse buscaFuncionarioPorId(@PathVariable UUID idFuncionario);
	
	@GetMapping(value = "/funcionarios")
	@ResponseStatus(code = HttpStatus.OK)
	List<FuncionarioResponse> buscaTodosFuncionarios();
	
	@DeleteMapping(value = "/{idFuncionario}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void deletaFuncionario(@PathVariable UUID idFuncionario);
	
	@PatchMapping(value = "/altera/{idFuncionario}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void alteraFuncionario(@PathVariable UUID idFuncionario, @Valid @RequestBody AlteraFuncionarioRequest alteraFuncionarioRequest);
	
}
