package com.uzitec.clienteservico.orcamento.application.infra;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uzitec.clienteservico.cliente.domain.Cliente;
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
		orcamentoSpringDataJPARepository.save(orcamento);
		log.info("[finaliza]OrcamentoInfraRepository - salvaOrcamento");
		return orcamento;
	}

	@Override
	public List<Orcamento> getTodosOrcamentosDoCliente(Cliente cliente) {
		log.info("[inicia]OrcamentoInfraRepository - getTodosOrcamentosDoCliente");
		List<Orcamento> todosOrcamentos = orcamentoSpringDataJPARepository.findByCliente(cliente);
		log.info("[finaliza]OrcamentoInfraRepository - getTodosOrcamentosDoCliente");
		return todosOrcamentos;
	}

}
