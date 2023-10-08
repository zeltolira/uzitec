package com.uzitec.clienteservico.Servico.application.api;

import org.springframework.web.bind.annotation.RestController;

import com.uzitec.clienteservico.Servico.application.api.request.ServicoRequest;
import com.uzitec.clienteservico.Servico.application.api.response.ServicoResponse;
import com.uzitec.clienteservico.Servico.application.service.ServicoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ServicoRestController implements ServicoAPI {

	private final ServicoService servicoService;

	@Override
	public ServicoResponse postServico(ServicoRequest servicoRequest) {
		log.info("[inicia] ServicoRestController - postServico");
		ServicoResponse servicoResponse = servicoService.postServico(servicoRequest);
		log.info("[finaliza] ServicoRestController - postServico");
		return servicoResponse;
	}

	@Override
	public ServicoResponse findServicoById(Long idServico) {
		log.info("[inicia] ServicoRestController - findServicoById");
		ServicoResponse servicoResponse = servicoService.findServicoById(idServico);
		log.info("[finaliza] ServicoRestController - findServicoById");
		return servicoResponse;
	}

}
