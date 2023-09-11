package com.uzitec.clienteservico.application.api;

import org.springframework.web.bind.annotation.RestController;

import com.uzitec.clienteservico.application.api.request.ClienteRequest;
import com.uzitec.clienteservico.application.api.response.ClienteResponse;
import com.uzitec.clienteservico.application.service.ClienteService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ClienteRestContoller implements ClienteAPI {

	private final ClienteService clienteService;

	@Override
	public ClienteResponse postCliente(@Valid ClienteRequest clienteRequest) {
		log.info("[inicia] ClienteRestContoller - postCliente");
		ClienteResponse clienteCriado = clienteService.criaCliente(clienteRequest);
		log.info("[finaliza] ClienteRestContoller - postCliente");
		return clienteCriado;
	}

}
