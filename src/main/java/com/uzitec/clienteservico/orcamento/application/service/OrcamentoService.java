package com.uzitec.clienteservico.orcamento.application.service;

import java.util.List;
import java.util.UUID;

import com.uzitec.clienteservico.orcamento.application.api.request.OrcamentoRequest;
import com.uzitec.clienteservico.orcamento.application.api.response.OrcamentoDetalhadoResponse;
import com.uzitec.clienteservico.orcamento.application.api.response.OrcamentoListResponse;
import com.uzitec.clienteservico.orcamento.application.api.response.OrcamentoResponse;

public interface OrcamentoService {
	OrcamentoResponse criaOrcamento(UUID idCliente, OrcamentoRequest orcamentoRequest);
	List<OrcamentoListResponse> getTodosOrcamentosDoCliente(UUID idCliente);
	OrcamentoDetalhadoResponse getOrcamentoPorId(UUID idCliente, Long idOrcamento);
}
