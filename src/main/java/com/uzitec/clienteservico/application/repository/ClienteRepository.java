package com.uzitec.clienteservico.application.repository;

import com.uzitec.clienteservico.domain.Cliente;

public interface ClienteRepository {
	Cliente salva(Cliente cliente);
}