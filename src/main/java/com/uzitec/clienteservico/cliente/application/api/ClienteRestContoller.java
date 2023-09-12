package com.uzitec.clienteservico.cliente.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import com.uzitec.clienteservico.cliente.application.api.request.ClienteAlteracaoRequest;
import com.uzitec.clienteservico.cliente.application.api.request.ClienteRequest;
import com.uzitec.clienteservico.cliente.application.api.response.ClienteDetalhadoResponse;
import com.uzitec.clienteservico.cliente.application.api.response.ClienteListResponse;
import com.uzitec.clienteservico.cliente.application.api.response.ClienteResponse;
import com.uzitec.clienteservico.cliente.application.service.ClienteService;

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
	public ClienteDetalhadoResponse getClientePorId(UUID idCliente) {
		log.info("[inicia] ClienteRestContoller - getClientePorId");
	    ClienteDetalhadoResponse clienteDetalhado = clienteService.buscaClientesPorId(idCliente);
		log.info("[finaliza] ClienteRestContoller - getClientePorId");
		return clienteDetalhado;
	}

	@Override
	public void alteraClientePorId(UUID idCliente, ClienteAlteracaoRequest clienteAlteracaoRequest) {
		log.info("[inicia] ClienteRestContoller - alteraClientePorId");
		log.info("[idCliente] {}", idCliente);
		clienteService.alteraClientePorId(idCliente, clienteAlteracaoRequest);
		log.info("[finaliza] ClienteRestContoller - alteraClientePorId");
		
	}

	@Override
	public void deletaClientePorId(UUID idCliente) {
		log.info("[inicia] ClienteRestContoller - deletaClientePorId");
		log.info("[idCliente] {}", idCliente);
		clienteService.deletaClientePorId(idCliente);
		log.info("[finaliza] ClienteRestContoller - deletaClientePorId");
		
	}

}
