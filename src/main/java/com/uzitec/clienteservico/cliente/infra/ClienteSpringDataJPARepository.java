package com.uzitec.clienteservico.cliente.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uzitec.clienteservico.cliente.domain.Cliente;

public interface ClienteSpringDataJPARepository extends JpaRepository<Cliente, UUID>{

}
