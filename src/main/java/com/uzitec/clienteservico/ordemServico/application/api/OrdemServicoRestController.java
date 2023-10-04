package com.uzitec.clienteservico.ordemServico.application.api;

import org.springframework.web.bind.annotation.RestController;

import com.uzitec.clienteservico.ordemServico.application.api.request.OrdemServicoRequest;
import com.uzitec.clienteservico.ordemServico.application.api.response.OrdemServicoResponse;
import com.uzitec.clienteservico.ordemServico.application.service.OrdemServicoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class OrdemServicoRestController implements OrdemServicoAPI {

	private final OrdemServicoService ordemServicoService;

	@Override
	public OrdemServicoResponse saveOrdemServico(OrdemServicoRequest ordemServicoRequest) {
		log.info("[inicia] OrdemServicoRestController - saveOrdemServico");
		OrdemServicoResponse ordemServicoCriada = ordemServicoService.saveOrdemServico(ordemServicoRequest);
		log.info("[finaliza] OrdemServicoRestController - saveOrdemServico");
		return ordemServicoCriada;
	}

	@Override
	public OrdemServicoResponse findOrdemServicoById(Long idOrdemServico) {
		log.info("[inicia] OrdemServicoRestController - findOrdemServicoById");
		OrdemServicoResponse ordemServicoResponse = ordemServicoService.findOrdemServicoById(idOrdemServico);
		log.info("[finaliza] OrdemServicoRestController - findOrdemServicoById");
		return ordemServicoResponse;
	}

	@Override
	public OrdemServicoResponse findAllOrdemServico() {
		log.info("[inicia] OrdemServicoRestController - findAllOrdemServico");
		
		log.info("[finaliza] OrdemServicoRestController - findAllOrdemServico");
		return null;
	}

}
