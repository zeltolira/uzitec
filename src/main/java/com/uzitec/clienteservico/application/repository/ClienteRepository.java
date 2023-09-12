package com.uzitec.clienteservico.application.repository;

import java.util.List;
import java.util.UUID;

import com.uzitec.clienteservico.domain.Cliente;

public interface ClienteRepository {
	Cliente salva(Cliente cliente);
	List<Cliente> buscaTodosClientes();
	Cliente buscaClientePorId(UUID idCliente);
	void deleta(Cliente cliente);
}