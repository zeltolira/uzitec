package com.uzitec.clienteservico.cliente.application.service;

import java.util.List;
import java.util.UUID;

import com.uzitec.clienteservico.cliente.application.api.request.ClienteAlteracaoRequest;
import com.uzitec.clienteservico.cliente.application.api.request.ClienteRequest;
import com.uzitec.clienteservico.cliente.application.api.response.ClienteDetalhadoResponse;
import com.uzitec.clienteservico.cliente.application.api.response.ClienteListResponse;
import com.uzitec.clienteservico.cliente.application.api.response.ClienteResponse;

public interface ClienteService {
	ClienteResponse criaCliente(ClienteRequest clienteRequest);
	List<ClienteListResponse> buscaTodosClientes();
	ClienteDetalhadoResponse buscaClientesPorId(UUID idCliente);
	void alteraClientePorId(UUID idCliente, ClienteAlteracaoRequest clienteAlteracaoRequest);
	void deletaClientePorId(UUID idCliente);
	ClienteDetalhadoResponse buscaClientePorCpf(String cpf);
}