package com.uzitec.clienteservico.funcionario.application.api;

import java.util.List;
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
		FuncionarioResponse funcionarioResponse = funcionarioService.buscaFuncionarioPorId(idFuncionario);
		log.info("[finaliza] FuncionarioRestController - buscaFuncionarioPorId");
		return funcionarioResponse;
	}

	@Override
	public List<FuncionarioResponse> buscaTodosFuncionarios() {
		log.info("[inicia] FuncionarioRestController - buscaTodosFuncionarios");
		List<FuncionarioResponse> funcionarios = funcionarioService.buscaTodosFuncionarios();
		log.info("[finaliza] FuncionarioRestController - buscaTodosFuncionarios");
		return funcionarios;
	}

	@Override
	public void deletaFuncionario(UUID idFuncionario) {
		log.info("[inicia] FuncionarioRestController - deletaFuncionario");
		funcionarioService.deletaFuncionario(idFuncionario);
		log.info("[finaliza] FuncionarioRestController - deletaFuncionario");
	}

}
