package com.uzitec.clienteservico.funcionario.application.service;

import org.springframework.stereotype.Service;

import com.uzitec.clienteservico.funcionario.application.api.request.FuncionarioRequest;
import com.uzitec.clienteservico.funcionario.application.api.response.FuncionarioResponse;
import com.uzitec.clienteservico.funcionario.application.repository.FuncionarioRepository;
import com.uzitec.clienteservico.funcionario.domain.Funcionario;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class FuncionarioApplicationService implements FuncionarioService {

	private final FuncionarioRepository funcionariRepository;

	@Override
	public FuncionarioResponse salvaFuncionario(FuncionarioRequest funcionarioRequest) {
		log.info("[inicia] FuncionarioApplicationService - salvaFuncionario");
		Funcionario funcionario = funcionariRepository.salvaFuncionario(new Funcionario(funcionarioRequest));
		log.info("[finaliza] FuncionarioApplicationService - salvaFuncionario");
		return new FuncionarioResponse(funcionario);
	}

}
