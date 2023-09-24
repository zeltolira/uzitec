package com.uzitec.clienteservico.ordemServico.infra;

import org.springframework.stereotype.Repository;

import com.uzitec.clienteservico.ordemServico.application.repository.OrdemServicoRepository;
import com.uzitec.clienteservico.ordemServico.domain.OrdemServico;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class OrdemServicoInfraRepository implements OrdemServicoRepository {

	private final OrdemServicoSpringJPARepository ordemServicoSpringJPARepository;

	@Override
	public OrdemServico postOrdemServico(OrdemServico ordemServico) {
		log.info("[inicia] OrdemServicoInfraRepository - postOrdemServico");
		ordemServicoSpringJPARepository.save(ordemServico);
		log.info("[finaliza] OrdemServicoInfraRepository - postOrdemServico");
		return ordemServico;
	}

}
