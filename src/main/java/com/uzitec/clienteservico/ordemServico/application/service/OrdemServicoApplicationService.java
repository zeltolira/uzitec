package com.uzitec.clienteservico.ordemServico.application.service;

import org.springframework.stereotype.Service;

import com.uzitec.clienteservico.ordemServico.application.api.request.OrdemServicoRequest;
import com.uzitec.clienteservico.ordemServico.application.api.response.OrdemServicoResponse;
import com.uzitec.clienteservico.ordemServico.application.repository.OrdemServicoRepository;
import com.uzitec.clienteservico.ordemServico.domain.OrdemServico;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class OrdemServicoApplicationService implements OrdemServicoService {

	private final OrdemServicoRepository ordemServicoRepository;

	@Override
	public OrdemServicoResponse saveOrdemServico(OrdemServicoRequest ordemServicoRequest) {
		log.info("[inicia] OrdemServiceApplicationService - postOrdemServico");
		OrdemServico ordemServico = ordemServicoRepository.saveOrdemServico(new OrdemServico(ordemServicoRequest));
		log.info("[finaliza] OrdemServiceApplicationService - postOrdemServico");
		return OrdemServicoResponse.builder()
				.idOrdemServico(ordemServico.getIdOrdemServico())
				.build();
	}

	@Override
	public OrdemServicoResponse findOrdemServicoById(Long idOrdemServico) {
		log.info("[inicia] OrdemServiceApplicationService - findOrdemServicoById");
		log.info("[finaliza] OrdemServiceApplicationService - findOrdemServicoById");
		return null;
	}

}
