package com.uzitec.clienteservico.funcionario.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.uzitec.clienteservico.funcionario.application.api.request.AlteraFuncionarioRequest;
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

	@Override
	public FuncionarioResponse buscaFuncionarioPorId(UUID idFuncionario) {
		log.info("[inicia] FuncionarioApplicationService - buscaFuncionarioPorId");
		Funcionario funcionario = funcionariRepository.buscaFuncionarioPorId(idFuncionario);
		log.info("[finaliza] FuncionarioApplicationService - buscaFuncionarioPorId");
		return new FuncionarioResponse(funcionario);
	}

	@Override
	public List<FuncionarioResponse> buscaTodosFuncionarios() {
		log.info("[inicia] FuncionarioApplicationService - buscaTodosFuncionarios");
		List<Funcionario> funcinarios = funcionariRepository.buscaTodosFuncionarios();
		log.info("[finaliza] FuncionarioApplicationService - buscaTodosFuncionarios");
		return FuncionarioResponse.converte(funcinarios);
	}

	@Override
	public void deletaFuncionario(UUID idFuncionario) {
		log.info("[inicia] FuncionarioApplicationService - deletaFuncionario");
		funcionariRepository.deletaFuncionario(idFuncionario);
		log.info("[finaliza] FuncionarioApplicationService - deletaFuncionario");
	}

	@Override
	public void alteraFuncionario(UUID idFuncionario, AlteraFuncionarioRequest alteraFuncionarioRequest) {
		log.info("[inicia] FuncionarioApplicationService - alteraFuncionario");
		Funcionario funcionario = funcionariRepository.buscaFuncionarioPorId(idFuncionario);
		funcionario.altera(alteraFuncionarioRequest);
		funcionariRepository.salvaFuncionario(funcionario);
		log.info("[finaliza] FuncionarioApplicationService - alteraFuncionario");
	}

}
