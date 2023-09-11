package com.uzitec.clienteservico.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import com.uzitec.clienteservico.application.api.request.ClienteRequest;
import com.uzitec.clienteservico.application.api.response.ClienteDetalhadoResponse;
import com.uzitec.clienteservico.application.api.response.ClienteListResponse;
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
	public ClienteResponse postCliente(ClienteRequest clienteRequest) {
		log.info("[inicia] ClienteRestContoller - postCliente");
		ClienteResponse clienteCriado = clienteService.criaCliente(clienteRequest);
		log.info("[finaliza] ClienteRestContoller - postCliente");
		return clienteCriado;
	}

	@Override
	public List<ClienteListResponse> getTodosClientes() {
		log.info("[inicia] ClienteRestContoller - getTodosClientes");
		List<ClienteListResponse>  clientes = clienteService.buscaTodosClientes();
		log.info("[finlaiza] ClienteRestContoller - getTodosClientes");
		return clientes;
	}

	@Override
	public ClienteDetalhadoResponse getClientePorId(@Valid UUID idCliente) {
		log.info("[inicia] ClienteRestContoller - getClientePorId");
		ClienteDetalhadoResponse clienteDetalhado = clienteService.buscaClientesPorId(idCliente);
		log.info("[finaliza] ClienteRestContoller - getClientePorId");
		return clienteDetalhado;
	}

}
