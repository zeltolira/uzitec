package com.uzitec.clienteservico.orcamento.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.uzitec.clienteservico.cliente.application.repository.ClienteRepository;
import com.uzitec.clienteservico.cliente.domain.Cliente;
import com.uzitec.clienteservico.orcamento.application.api.request.OrcamentoRequest;
import com.uzitec.clienteservico.orcamento.application.api.response.OrcamentoDetalhadoResponse;
import com.uzitec.clienteservico.orcamento.application.api.response.OrcamentoListResponse;
import com.uzitec.clienteservico.orcamento.application.api.response.OrcamentoResponse;
import com.uzitec.clienteservico.orcamento.application.repository.OrcamentoRepository;
import com.uzitec.clienteservico.orcamento.domain.Orcamento;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class OrcamentoApplicationService implements OrcamentoService {

	private final OrcamentoRepository orcamentoRepository;
	private final ClienteRepository clienteRepository;
	@Override
	public OrcamentoResponse criaOrcamento(UUID idCliente, OrcamentoRequest orcamentoRequest) {
		log.info("[inicia] OrcamentoApplicationService - criaOrcamento");
		Cliente cliente = clienteRepository.buscaClientePorId(idCliente);
		Orcamento orcamento = orcamentoRepository.salvaOrcamento(new Orcamento(cliente, orcamentoRequest));
		log.info("[finaliza] OrcamentoApplicationService - criaOrcamento");
		return OrcamentoResponse.builder()
				.idOrcamento(orcamento.getIdOrcamento())
				.build();
	}
	@Override
	public List<OrcamentoListResponse> getTodosOrcamentosDoCliente(UUID idCliente) {
		log.info("[inicia] OrcamentoApplicationService - getTodosOrcamentosDoCliente");
		Cliente cliente = clienteRepository.buscaClientePorId(idCliente);
		List<Orcamento> orcamento = orcamentoRepository.getTodosOrcamentosDoCliente(cliente);
		log.info("[finaliza] OrcamentoApplicationService - getTodosOrcamentosDoCliente");
		return OrcamentoListResponse.converte(orcamento);
	}
	@Override
	public OrcamentoDetalhadoResponse getOrcamentoPorId(UUID idCliente, Long idOrcamento) {
		log.info("[inicia] OrcamentoApplicationService - getOrcamentoPorId");
		clienteRepository.buscaClientePorId(idCliente);
		Orcamento orcamento = orcamentoRepository.getOrcamentoPorId(idOrcamento);
		log.info("[inicia] OrcamentoApplicationService - getOrcamentoPorId");
		return new OrcamentoDetalhadoResponse(orcamento);
	}

}
