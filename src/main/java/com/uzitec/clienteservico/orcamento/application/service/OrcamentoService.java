package com.uzitec.clienteservico.orcamento.application.service;

import java.util.UUID;

import com.uzitec.clienteservico.orcamento.application.api.request.OrcamentoRequest;
import com.uzitec.clienteservico.orcamento.application.api.response.OrcamentoResponse;

public interface OrcamentoService {
	OrcamentoResponse criaOrcamento(UUID idCliente, OrcamentoRequest orcamentoRequest);
}
