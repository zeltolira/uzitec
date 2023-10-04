package com.uzitec.clienteservico.orcamento.infra;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.uzitec.clienteservico.cliente.domain.Cliente;
import com.uzitec.clienteservico.handler.APIException;
import com.uzitec.clienteservico.orcamento.application.repository.OrcamentoRepository;
import com.uzitec.clienteservico.orcamento.domain.Orcamento;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class OrcamentoInfraRepository implements OrcamentoRepository {

	private final OrcamentoSpringDataJPARepository orcamentoSpringDataJPARepository;

	@Override
	public Orcamento salvaOrcamento(Orcamento orcamento) {
		log.info("[inicia]OrcamentoInfraRepository - salvaOrcamento");
		Orcamento orcamentoCriado = orcamentoSpringDataJPARepository.save(orcamento);
		log.info("[finaliza]OrcamentoInfraRepository - salvaOrcamento");
		return orcamentoCriado;
	}

	@Override
	public List<Orcamento> getTodosOrcamentosDoCliente(Cliente cliente) {
		log.info("[inicia]OrcamentoInfraRepository - getTodosOrcamentosDoCliente");
		List<Orcamento> todosOrcamentos = orcamentoSpringDataJPARepository.findByCliente(cliente);
		log.info("[finaliza]OrcamentoInfraRepository - getTodosOrcamentosDoCliente");
		return todosOrcamentos;
	}

	@Override
	public Orcamento getOrcamentoPorId(Long idOrcamento) {
		log.info("[inicia]OrcamentoInfraRepository - getOrcamentoPorId");
		var orcamento = orcamentoSpringDataJPARepository.findById(idOrcamento)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Orçamento não encontrado para o cliente"));
		log.info("[finaliza]OrcamentoInfraRepository - getOrcamentoPorId");
		return orcamento;
	}

	@Override
	public void deleteOrcamento(Long idOrcamento) {
		log.info("[inicia]OrcamentoInfraRepository - deleteOrcamento");
		orcamentoSpringDataJPARepository.deleteById(idOrcamento);
		log.info("[finaliza]OrcamentoInfraRepository - deleteOrcamento");
		
	}

}
