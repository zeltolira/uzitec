package com.uzitec.clienteservico.Servico.application.service;

import org.springframework.stereotype.Service;

import com.uzitec.clienteservico.Servico.application.api.request.ServicoRequest;
import com.uzitec.clienteservico.Servico.application.api.response.ServicoResponse;
import com.uzitec.clienteservico.Servico.application.repostory.ServicoRepository;
import com.uzitec.clienteservico.Servico.domain.Servico;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class ServicoApplicationService implements ServicoService {

	private final ServicoRepository servicoRepository;

	@Override
	public ServicoResponse postServico(ServicoRequest servicoRequest) {
		log.info("[inicia]ServicoApplicationService - postServico");
		Servico servico = servicoRepository.postServico(new Servico(servicoRequest));
		log.info("[finaliza]ServicoApplicationService - postServico");
		return new ServicoResponse(servico);
	}

}
