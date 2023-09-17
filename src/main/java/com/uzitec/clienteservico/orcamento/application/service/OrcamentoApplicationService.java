package com.uzitec.clienteservico.orcamento.application.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.uzitec.clienteservico.cliente.application.repository.ClienteRepository;
import com.uzitec.clienteservico.cliente.domain.Cliente;
import com.uzitec.clienteservico.orcamento.application.api.request.OrcamentoRequest;
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
		Cliente cliente =clienteRepository.buscaClientePorId(idCliente);
		Orcamento orcamento = orcamentoRepository.salvaOrcamento(new Orcamento(cliente, orcamentoRequest));
		log.info("[finaliza] OrcamentoApplicationService - criaOrcamento");
		return OrcamentoResponse.builder()
				.idOrcamento(orcamento.getIdOrcamento())
				.build();
	}

}
