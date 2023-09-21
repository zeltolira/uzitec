package com.uzitec.clienteservico.orcamento.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;

import com.uzitec.clienteservico.orcamento.application.api.request.OrcamentoPatchRequest;
import com.uzitec.clienteservico.orcamento.application.api.request.OrcamentoRequest;
import com.uzitec.clienteservico.orcamento.application.api.response.OrcamentoDetalhadoResponse;
import com.uzitec.clienteservico.orcamento.application.api.response.OrcamentoListResponse;
import com.uzitec.clienteservico.orcamento.application.api.response.OrcamentoResponse;
import com.uzitec.clienteservico.orcamento.application.service.OrcamentoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequiredArgsConstructor
public class OrcamentoRestController implements OrcamentoAPI {

	private final OrcamentoService orcamentoService;

	@Override
	public OrcamentoResponse postOrcamento(UUID idCliente, OrcamentoRequest orcamentoRequest) {
		log.info("[inicia] OrcamentoRestController - postOrcamento");
		OrcamentoResponse orcamentoCriado = orcamentoService.criaOrcamento(idCliente, orcamentoRequest);
		log.info("[finlaiza] OrcamentoRestController - postOrcamento");
		return orcamentoCriado;
	}

	@Override
	public List<OrcamentoListResponse> getTodosOrcamentoDoCliente(UUID idCliente) {
		log.info("[inicia] OrcamentoRestController - getTodosOrcamentoDoCliente");
		List<OrcamentoListResponse> orcamentos = orcamentoService.getTodosOrcamentosDoCliente(idCliente);
		log.info("[finaliza] OrcamentoRestController - getTodosOrcamentoDoCliente");
		return orcamentos;
	}

	@Override
	public OrcamentoDetalhadoResponse getOrcamentoPorId(UUID idCliente, Long idOrcamento) {
		log.info("[inicia] OrcamentoRestController - getOrcamentoPorId");
		OrcamentoDetalhadoResponse orcamentoDetalhado = orcamentoService.getOrcamentoPorId(idCliente, idOrcamento);
		log.info("[finaliza] OrcamentoRestController - getOrcamentoPorId");
		return orcamentoDetalhado;
	}

	@Override
	public void patchOrcamento(Long idOrcamento, OrcamentoPatchRequest orcamentoPatchRequest) {
		log.info("[inicia] OrcamentoRestController - patchOrcamento");
		orcamentoService.patchOrcamento(idOrcamento, orcamentoPatchRequest);
		log.info("[finaliza] OrcamentoRestController - patchOrcamento");
	}
}