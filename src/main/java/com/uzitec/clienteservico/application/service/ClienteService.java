package com.uzitec.clienteservico.application.service;

import java.util.List;
import java.util.UUID;

import com.uzitec.clienteservico.application.api.request.ClienteRequest;
import com.uzitec.clienteservico.application.api.response.ClienteDetalhadoResponse;
import com.uzitec.clienteservico.application.api.response.ClienteListResponse;
import com.uzitec.clienteservico.application.api.response.ClienteResponse;

import jakarta.validation.Valid;

public interface ClienteService {
	ClienteResponse criaCliente(ClienteRequest clienteRequest);
	List<ClienteListResponse> buscaTodosClientes();
	ClienteDetalhadoResponse buscaClientesPorId(@Valid UUID idCliente);
}