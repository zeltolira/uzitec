package com.uzitec.clienteservico.ordemServico.application.service;

import org.springframework.stereotype.Service;

import com.uzitec.clienteservico.ordemServico.application.api.request.OrdemServicoRequest;
import com.uzitec.clienteservico.ordemServico.application.api.response.OrdemServicoResponse;
import com.uzitec.clienteservico.ordemServico.application.repository.OrdemServicorepository;
import com.uzitec.clienteservico.ordemServico.domain.OrdemServico;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class OrdemServicoApplicationService implements OrdemServicoService {

	private final OrdemServicorepository ordemServicoRepository;

	@Override
	public OrdemServicoResponse postOrdemServico(OrdemServicoRequest ordemServicoRequest) {
		log.info("[inicia] OrdemServiceApplicationService - postOrdemServico");
		OrdemServico ordemServico = ordemServicoRepository.postOrdemServico(new OrdemServico(ordemServicoRequest));
		log.info("[finaliza] OrdemServiceApplicationService - postOrdemServico");
		return OrdemServicoResponse.builder()
				.idOrdemServico(ordemServico.getIdOrdemServico())
				.build();
	}

}
