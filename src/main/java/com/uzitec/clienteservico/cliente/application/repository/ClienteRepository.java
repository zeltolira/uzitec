package com.uzitec.clienteservico.cliente.application.repository;

import java.util.List;
import java.util.UUID;

import com.uzitec.clienteservico.cliente.domain.Cliente;

public interface ClienteRepository {
	Cliente salva(Cliente cliente);
	List<Cliente> buscaTodosClientes();
	Cliente buscaClientePorId(UUID idCliente);
	void deletaCliente(Cliente cliente);
}