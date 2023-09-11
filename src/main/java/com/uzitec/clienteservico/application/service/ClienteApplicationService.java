package com.uzitec.clienteservico.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.uzitec.clienteservico.application.api.request.ClienteRequest;
import com.uzitec.clienteservico.application.api.response.ClienteDetalhadoResponse;
import com.uzitec.clienteservico.application.api.response.ClienteListResponse;
import com.uzitec.clienteservico.application.api.response.ClienteResponse;
import com.uzitec.clienteservico.application.repository.ClienteRepository;
import com.uzitec.clienteservico.domain.Cliente;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService {

	private final ClienteRepository clienteRepository;

	@Override
	public ClienteResponse criaCliente(ClienteRequest clienteRequest) {
		log.info("[inicia] ClienteApplicationService - criaCliente");
		Cliente cliente = clienteRepository.salva(new Cliente(clienteRequest));
		log.info("[finaliza] ClienteApplicationService - criaCliente");
		return ClienteResponse.builder()
				.idCliente(cliente.getIdCliente())
				.build();
	}

	@Override
	public List<ClienteListResponse> buscaTodosClientes() {
		log.info("[inicia] ClienteApplicationService - buscaTodosClientes");
		List<Cliente> clientes = clienteRepository.buscaTodosClientes();
		log.info("[finaliza] ClienteApplicationService - buscaTodosClientes");
		return ClienteListResponse.converte(clientes);
	}

	@Override
	public ClienteDetalhadoResponse buscaClientesPorId(UUID idCliente) {
		log.info("[inicia] ClienteApplicationService - buscaClientesPorId");
		Cliente cliente = clienteRepository.buscaClientePorId(idCliente);
		log.info("[finaliza] ClienteApplicationService - buscaClientesPorId");
		return new ClienteDetalhadoResponse(cliente);
	}

}
