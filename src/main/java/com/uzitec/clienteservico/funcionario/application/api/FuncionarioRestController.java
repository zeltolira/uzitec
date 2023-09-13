package com.uzitec.clienteservico.funcionario.application.api;

import org.springframework.web.bind.annotation.RestController;

import com.uzitec.clienteservico.funcionario.application.api.request.FuncionarioRequest;
import com.uzitec.clienteservico.funcionario.application.api.response.FuncionarioResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class FuncionarioRestController implements FuncionarioAPI {

	@Override
	public FuncionarioResponse salvaFuncionario(@Valid FuncionarioRequest funcionarioRequest) {
		log.info("[inicia] FuncionarioRestController - salvaFuncionario");
		log.info("[finaliza] FuncionarioRestController - salvaFuncionario");
		return null;
	}

}
