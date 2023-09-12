package com.uzitec.clienteservico.cliente.application.api.response;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.uzitec.clienteservico.cliente.domain.Cliente;

import lombok.Value;

@Value
public class ClienteListResponse {
	private UUID idCliente;
	private String nomeCliente;
	
	
	
	public static List<ClienteListResponse> converte(List<Cliente> clientes) {
		return clientes.stream()
				.map(ClienteListResponse::new)
				.collect(Collectors.toList());
	}


	public ClienteListResponse(Cliente cliente) {
		this.idCliente = cliente.getIdCliente();
		this.nomeCliente = cliente.getNomeCliente();
		
	}
	
	
}
