package com.uzitec.clienteservico.application.repository;

import java.util.List;

import com.uzitec.clienteservico.domain.Cliente;

public interface ClienteRepository {
	Cliente salva(Cliente cliente);
	List<Cliente> buscaTodosClientes();
}