package com.uzitec.clienteservico.funcionario.application.api;

import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import com.uzitec.clienteservico.funcionario.application.api.request.FuncionarioRequest;
import com.uzitec.clienteservico.funcionario.application.api.response.FuncionarioResponse;
import com.uzitec.clienteservico.funcionario.application.service.FuncionarioService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class FuncionarioRestController implements FuncionarioAPI {

	private final FuncionarioService funcionarioService;

	@Override
	public FuncionarioResponse salvaFuncionario(FuncionarioRequest funcionarioRequest) {
		log.info("[inicia] FuncionarioRestController - salvaFuncionario");
		FuncionarioResponse funcionarioresponse = funcionarioService.salvaFuncionario(funcionarioRequest);
		log.info("[finaliza] FuncionarioRestController - salvaFuncionario");
		return funcionarioresponse;
	}

	@Override
	public FuncionarioResponse buscaFuncionarioPorId(UUID idFuncionario) {
		log.info("[inicia] FuncionarioRestController - buscaFuncionarioPorId");
		log.info("[finaliza] FuncionarioRestController - buscaFuncionarioPorId");
		return null;
	}

}
