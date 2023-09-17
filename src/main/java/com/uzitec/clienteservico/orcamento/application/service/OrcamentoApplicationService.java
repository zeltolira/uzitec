package com.uzitec.clienteservico.orcamento.application.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.uzitec.clienteservico.orcamento.application.api.request.OrcamentoRequest;
import com.uzitec.clienteservico.orcamento.application.api.response.OrcamentoResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class OrcamentoApplicationService implements OrcamentoService {

	@Override
	public OrcamentoResponse criaOrcamento(UUID idCliente, OrcamentoRequest orcamentoRequest) {
		log.info("[inicia] OrcamentoApplicationService - criaOrcamento");
		log.info("[finaliza] OrcamentoApplicationService - criaOrcamento");
		return null;
	}

}
