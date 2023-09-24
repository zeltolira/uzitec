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

	private final OrdemServicoService ordeServicoService;

	@Override
	public OrdemServicoResponse postOrdemServico(OrdemServicoRequest ordemServicoRequest) {
		log.info("[inicia] OrdemServicoRestController - postOrdemServico");
		OrdemServicoResponse ordemServicoCriada = ordeServicoService.postOrdemServico(ordemServicoRequest);
		log.info("[finaliza] OrdemServicoRestController - postOrdemServico");
		return ordemServicoCriada;
	}

}
