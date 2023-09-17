package com.uzitec.clienteservico.orcamento.application.infra;

import org.springframework.stereotype.Repository;

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

}
