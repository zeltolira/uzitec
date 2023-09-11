package com.uzitec.clienteservico.application.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uzitec.clienteservico.domain.Cliente;

public interface ClienteSpringDataJPARepository extends JpaRepository<Cliente, UUID>{

}
